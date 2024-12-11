package net.berber.berbersbrews.effect;

import net.berber.berbersbrews.BerbersBrewsClient;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.entity.player.PlayerEntity;

public class AbleEffect extends StatusEffect {
    public AbleEffect(StatusEffectCategory statusEffectCategory, int color) {
        super(statusEffectCategory, color);
    }

    @Override
    public boolean applyUpdateEffect(LivingEntity entity, int amplifier) {
        if(entity instanceof PlayerEntity && entity.getWorld().isClient) {
            if(entity.horizontalCollision && BerbersBrewsClient.isJumping) {
                if(entity.isSneaking()) {
                    entity.setVelocity(entity.getVelocity().getX(), 0, entity.getVelocity().getZ());
                } else {
                    entity.setVelocity(entity.getVelocity().getX(), 0.4, entity.getVelocity().getZ());
                }
            }
        }

        return true;
    }

    @Override
    public boolean canApplyUpdateEffect(int d, int p) {
            return true;
    }
}
