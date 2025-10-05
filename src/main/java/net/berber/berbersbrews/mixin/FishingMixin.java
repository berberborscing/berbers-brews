package net.berber.berbersbrews.mixin;

import net.berber.berbersbrews.effect.ModEffects;
import net.berber.berbersbrews.fishing.EarlyLootStorage;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ItemEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.FishingBobberEntity;
import net.minecraft.item.FishingRodItem;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.loot.LootTable;
import net.minecraft.loot.LootTables;
import net.minecraft.loot.context.LootContextParameterSet;
import net.minecraft.loot.context.LootContextParameters;
import net.minecraft.loot.context.LootContextTypes;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.text.Text;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.ModifyArg;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.List;

@Mixin(FishingBobberEntity.class)
public abstract class FishingMixin extends Entity implements EarlyLootStorage {

    @Shadow private int hookCountdown;
    @Shadow private int fishTravelCountdown;

    @Shadow @Nullable public abstract PlayerEntity getPlayerOwner();

    @Unique
    private List<ItemStack> earlyLoot = List.of();

    @Unique
    boolean flag = false; //Used to prevent repeated loot generation; only randomize loot once

    //Cycle iterates both i and deployCounter every 20 ticks (1 second).
    //i is used to display multiple items. deployCounter is the potion's pity mechanic
    @Unique
    int i, cycle, deployCounter = 0;

    @Override
    public void berbers_brews$setEarlyLoot(List<ItemStack> loot) {
        this.earlyLoot = loot;
    }

    @Override
    public List<ItemStack> berbers_brews$getEarlyLoot() {
        return earlyLoot;
    }

    @Override
    public boolean berbers_brews$hasEarlyLoot() {
        return !earlyLoot.isEmpty();
    }

    public FishingMixin(EntityType<?> type, World world) {
        super(type, world);
    }

    //This is where most of the effect's code is
    @Inject(method="tickFishingLogic", at = @At("HEAD"))
    private void onFishingTick(CallbackInfo ci) {
        //
        if (this instanceof EarlyLootStorage lootStorage && !lootStorage.berbers_brews$hasEarlyLoot()) {
            if (!this.getWorld().isClient) {
                generateLootEarly((FishingBobberEntity) (Object) this, lootStorage);
            }
        }
        if(this instanceof EarlyLootStorage lootStorage && lootStorage.berbers_brews$hasEarlyLoot() && this.getPlayerOwner() != null) {
            cycle++;
            if(cycle > 20) { //iterate i and deploycounter
                i = i + 1;
                deployCounter = deployCounter + 1;
                cycle = 0;
            }
            if(i >= lootStorage.berbers_brews$getEarlyLoot().size()) {
                i = 0; //prevents game crash
            }
            this.setCustomName(Text.literal(lootStorage.berbers_brews$getEarlyLoot().get(i).getName().getString()));
            if(this.getPlayerOwner().hasStatusEffect(ModEffects.SONAR)) { //only applies when sonar effect is active
                if(this.fishTravelCountdown > 0 || this.hookCountdown > 0 || deployCounter > 4) {
                    //used for debugging
                    //this.getPlayerOwner().sendMessage(Text.literal("i: " + i + ", cycle: " + cycle + ", deployCounter: " + deployCounter + ", earlyLootSize: " + berbers_brews$getEarlyLoot().size()), true);
                    this.setCustomNameVisible(true); //only show what's on the line when the little particles are coming OR when 5 seconds have passed
                }
            } else { //Immediately make the name tag invisible when it wears off
                this.setCustomNameVisible(false);
            }
        }
        //Reroll loot if the bite is missed
        if (this.hookCountdown <= 0) {
            if (this instanceof EarlyLootStorage lootStorage) {
                if(!flag) {
                    generateLootEarly((FishingBobberEntity) (Object) this, lootStorage);
                    deployCounter = 0; //Reset the pity mechanic
                    this.setCustomNameVisible(false); //Fixes a bug where the deployCounter isn't obeyed when the line isn't pulled
                    flag = true;
                }
            }
        } else { //Reset this flag when something bites and there is still time
            flag = false;
        }
    }

    //method used to roll loot on command (exactly as done in vanilla)
    @Unique
    private void generateLootEarly(FishingBobberEntity bobber, EarlyLootStorage lootStorage) {
        ServerWorld world = (ServerWorld) bobber.getWorld();
        ServerPlayerEntity player = (ServerPlayerEntity) bobber.getPlayerOwner();

        if (player == null) return;
        //Get the fishing rod from either the main hand or the offhand
        ItemStack tool = player.getMainHandStack();

        if (!(tool.getItem() instanceof FishingRodItem)) {
            tool = player.getOffHandStack();
        }

        // Build the LootContextParameterSet first
        LootContextParameterSet.Builder paramBuilder = new LootContextParameterSet.Builder(world)
                .add(LootContextParameters.ORIGIN, bobber.getPos())
                .add(LootContextParameters.TOOL, tool)
                .add(LootContextParameters.THIS_ENTITY, bobber)
                .luck(player.getLuck());

        LootContextParameterSet paramSet = paramBuilder.build(LootContextTypes.FISHING);
        LootTable fishingLootTable = world.getServer().getReloadableRegistries().getLootTable(LootTables.FISHING_GAMEPLAY);
        List<ItemStack> drops = fishingLootTable.generateLoot(paramSet);

        if (!drops.isEmpty()) {
            lootStorage.berbers_brews$setEarlyLoot(drops.stream() //Store ALL items, enables mod functionality like Cobblemon's Poke Rod templates
                    .map(ItemStack::copy)
                    .toList());

            this.setCustomName(Text.literal(lootStorage.berbers_brews$getEarlyLoot().get(0).getName().getString())); //Start by displaying the first item on the line
        }
    }

    //Overwrite the ItemStack at reel-in with the pregenerated one
    @ModifyArg(
            method = "use(Lnet/minecraft/item/ItemStack;)I",
            at = @At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/entity/ItemEntity;<init>(Lnet/minecraft/world/World;DDDLnet/minecraft/item/ItemStack;)V"
            ),
            index = 4 //ItemStack arg
    )
    private ItemStack replaceCaughtItem(ItemStack original) {
        FishingBobberEntity bobber = (FishingBobberEntity) (Object) this;

        if (bobber instanceof EarlyLootStorage storage && storage.berbers_brews$hasEarlyLoot()) {
            List<ItemStack> loot = storage.berbers_brews$getEarlyLoot();

            return loot.get(0).copy(); //only replace the first item
        }

        return original; //fallback to vanilla loot
    }

    //Mod compatibility (i.g., Cobblemon Smithing Templates)
    @Inject(
            method = "use",
            at = @At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/world/World;spawnEntity(Lnet/minecraft/entity/Entity;)Z",
                    shift = At.Shift.AFTER
            )
    )
    private void dropExtraLoot(ItemStack usedItem, CallbackInfoReturnable<Integer> cir) {
        FishingBobberEntity self = (FishingBobberEntity)(Object)this;

        if (self instanceof EarlyLootStorage storage && storage.berbers_brews$hasEarlyLoot()) {
            List<ItemStack> loot = storage.berbers_brews$getEarlyLoot();
            storage.berbers_brews$setEarlyLoot(List.of());

            //skip first item since it was used in replaceCaughtItem
            for (int i = 1; i < loot.size(); i++) {
                ItemEntity extra = new ItemEntity(self.getWorld(), self.getX(), self.getY(), self.getZ(), loot.get(i).copy());
                if (self.getPlayerOwner() != null) {
                    double dx = self.getPlayerOwner().getX() - self.getX();
                    double dy = self.getPlayerOwner().getEyeY() - self.getY();
                    double dz = self.getPlayerOwner().getZ() - self.getZ();
                    double dist = Math.sqrt(dx * dx + dy * dy + dz * dz);
                    double velocityFactor = 1;

                    extra.setVelocity(dx / dist * velocityFactor,
                            dy / dist * velocityFactor,
                            dz / dist * velocityFactor);
                }
                self.getWorld().spawnEntity(extra);
            }
        }
    }
}