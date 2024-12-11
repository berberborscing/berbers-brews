package net.berber.berbersbrews.mixin;

import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.mob.HoglinEntity;
import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.mob.WaterCreatureEntity;
import net.minecraft.entity.passive.AllayEntity;
import net.minecraft.entity.passive.BatEntity;
import net.minecraft.entity.passive.GolemEntity;
import net.minecraft.entity.passive.PassiveEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.ModifyArg;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import static net.berber.berbersbrews.effect.ModEffects.SILENCE;

@Mixin(Entity.class)
public abstract class PotionMixin {
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
    @Inject(method="getTeamColorValue", at = @At(value= "TAIL"))
    private int setTeams(CallbackInfoReturnable<Boolean> info) {
        if(((Object)this instanceof HostileEntity)) { return 16711680; } //Hostile mobs will always be marked red
        else if((Object)this instanceof HoglinEntity) { return 16711680; } //Prevents hoglins from being identified as allies
        else if((Object)this instanceof PassiveEntity) { return 65280; } //Passive mobs will always be marked green
        else if((Object)this instanceof WaterCreatureEntity) { return 65280; } //Prevents fish from being identified as enemies
        else if((Object)this instanceof GolemEntity) { return 65280; } //Prevents golems from being identified as enemies
        else if((Object)this instanceof AllayEntity) { return 65280; } //Prevents allays from being identified as enemies
        else if((Object)this instanceof BatEntity) { return 65280; } //Prevents bats from being identified as enemies
        else if((Object)this instanceof MobEntity) { return 16711680; }  //Covers ghasts and phantoms not being identified as enemies
        else { return 16777215; }
    }

}