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
    int jumps = 0;
    int jumpCooldown = 4;

    @Override
    public boolean applyUpdateEffect(LivingEntity entity, int amplifier) {
        if(entity instanceof PlayerEntity && entity.getWorld().isClient) {
            if(entity.isOnGround()) {
                jumps = amplifier + 1; //Reset # of jumps if player is on the ground
                jumpCooldown = 4;
            } else {
                if(jumpCooldown > 0)
                    jumpCooldown--;
            }
            if(entity.horizontalCollision && BerbersBrewsClient.isJumping) {
                jumpCooldown = 10;
                entity.fallDistance = 0f;
                if(entity.isSneaking()) {
                    //0.003 is the smallest positive value that resets fall damage properly
                    entity.setVelocity(entity.getVelocity().getX(), 0.003, entity.getVelocity().getZ());
                } else {
                    entity.setVelocity(entity.getVelocity().getX(), 0.4, entity.getVelocity().getZ());
                }
            }
            else if(!entity.isOnGround() && !entity.horizontalCollision && BerbersBrewsClient.hasJumped && jumps > 0) {
                if(jumpCooldown == 0) {
                    jumps--; //Consume a jump
                    entity.setVelocity(entity.getVelocity().getX(), 0.6, entity.getVelocity().getZ()); //Apply upward velocity
                    entity.fallDistance = 0f;
                    jumpCooldown = 4;
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
