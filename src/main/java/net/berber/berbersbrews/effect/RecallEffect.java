package net.berber.berbersbrews.effect;

import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.boss.dragon.EnderDragonEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.TeleportTarget;
import org.jetbrains.annotations.Nullable;

public class RecallEffect extends StatusEffect {
    public RecallEffect(StatusEffectCategory statusEffectCategory, int color) {
        super(statusEffectCategory, color);
    }

    //Tipped arrow effect
    @Override
    public void onApplied(LivingEntity entity, int amplifier) {
        if(!entity.getEntityWorld().isClient() && !(entity instanceof EnderDragonEntity)) {
            BlockPos blockPos = entity.getEntityWorld().getSpawnPos();
            Vec3d vec3d = blockPos.toBottomCenterPos();
            if (entity instanceof ServerPlayerEntity serverPlayerEntity) {
                entity.teleportTo(serverPlayerEntity.getRespawnTarget(false, TeleportTarget.NO_OP));
            } else {
                vec3d = entity.getWorldSpawnPos((ServerWorld) entity.getEntityWorld(), blockPos).toBottomCenterPos();
                entity.teleport(vec3d.x, vec3d.y, vec3d.z, false);
            }
            entity.getEntityWorld().playSound(null, entity.getX(), entity.getY(), entity.getZ(), SoundEvents.BLOCK_PORTAL_TRAVEL, SoundCategory.PLAYERS, 0.25f, 2f);
            entity.onLanding();
        }
    }

    //Potion effect
    @Override
    public void applyInstantEffect(@Nullable Entity source, @Nullable Entity attacker, LivingEntity entity, int amplifier, double proximity) {
        //This potion should not work on the Ender Dragon.
        if(!entity.getEntityWorld().isClient() && !(entity instanceof EnderDragonEntity)) {
            BlockPos blockPos = entity.getEntityWorld().getSpawnPos();
            Vec3d vec3d = blockPos.toBottomCenterPos();
            if (entity instanceof ServerPlayerEntity serverPlayerEntity) {
                entity.teleportTo(serverPlayerEntity.getRespawnTarget(false, TeleportTarget.NO_OP));
            } else {
                vec3d = entity.getWorldSpawnPos((ServerWorld) entity.getEntityWorld(), blockPos).toBottomCenterPos();
                entity.teleport(vec3d.x, vec3d.y, vec3d.z, false);
            }
            entity.getEntityWorld().playSound(null, entity.getX(), entity.getY(), entity.getZ(), SoundEvents.BLOCK_PORTAL_TRAVEL, SoundCategory.PLAYERS, 0.25f, 2f);
            entity.onLanding();
        }
    }

    @Override
    public boolean canApplyUpdateEffect(int pDuration, int pAmplifier) {
        return true;
    }

    @Override
    public boolean isInstant() {
        return true;
    }
}
