package net.berber.berbersbrews.mixin;

import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;

import net.minecraft.entity.mob.*;
import net.minecraft.entity.passive.*;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.ModifyArg;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import static net.berber.berbersbrews.effect.ModEffects.SILENCE;

@Mixin(Entity.class)
public abstract class EntityMixin {
    //This code makes the Silence potion buff work.
    @Inject(at = @At("TAIL"), method = "occludeVibrationSignals", cancellable = true)
    private void occludeVibrationSignals(CallbackInfoReturnable<Boolean> info) {
        if((Object)this instanceof LivingEntity) {
            if(((LivingEntity) (Object) this).hasStatusEffect(SILENCE)) { info.setReturnValue(true); }
            else { info.setReturnValue(false); }
        }
    }

    //This code stifles audio from Silenced entities.
    @ModifyArg(method = "playSound", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/World;playSound(Lnet/minecraft/entity/player/PlayerEntity;DDDLnet/minecraft/sound/SoundEvent;Lnet/minecraft/sound/SoundCategory;FF)V"), index = 6)
    private float adjustVolume(float vol) {
        if((Object)this instanceof LivingEntity) {
            if(((LivingEntity) (Object) this).hasStatusEffect(SILENCE)) {
                return 0f;
            } else {
                return vol;
            }
        }
        else {
            return vol;
        }
    }

    //Assigns highlighting colors for the Potion of Privy.
    @Inject(method="getTeamColorValue", at = @At(value= "TAIL"), cancellable = true)
    private void setTeams(CallbackInfoReturnable<Integer> info) {
        Entity entity = (Entity)(Object)this;

        if(entity instanceof HostileEntity) { info.setReturnValue(16711680); } //Hostile mobs will always be marked red
        else if(entity instanceof HoglinEntity) { info.setReturnValue(16711680); } //Prevents hoglins from being identified as allies
        else if(entity instanceof PassiveEntity) { info.setReturnValue(65280); } //Passive mobs will always be marked green
        else if(entity instanceof WaterCreatureEntity) { info.setReturnValue(65280); } //Prevents fish from being identified as enemies
        else if(entity instanceof ShulkerEntity) { info.setReturnValue(16711680); } //Fixes a bug where Shulkers were marked as friendly
        else if(entity instanceof GolemEntity) { info.setReturnValue(65280); } //Prevents golems from being identified as enemies
        else if(entity instanceof AllayEntity) { info.setReturnValue(65280); } //Prevents allays from being identified as enemies
        else if(entity instanceof BatEntity) { info.setReturnValue(65280); } //Prevents bats from being identified as enemies
        else if(entity instanceof MobEntity) { info.setReturnValue(16711680); }  //Covers ghasts and phantoms not being identified as enemies
        else { info.setReturnValue(16777215); }
    }

}