package net.berber.berbersbrews.effect;

import net.minecraft.entity.Entity;
import net.minecraft.entity.ExperienceOrbEntity;
import net.minecraft.entity.ItemEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.math.Box;

import java.util.List;

public class ReachEffect extends StatusEffect {
    public ReachEffect(StatusEffectCategory statusEffectCategory, int color) {
        super(statusEffectCategory, color);
    }

    @Override
    public boolean applyUpdateEffect(LivingEntity entity, int amplifier) {
        if(!entity.getWorld().isClient) {
            if(entity instanceof PlayerEntity) {
                amplifier++;
                double maxDist = 4 + (amplifier * 2);
                List<Entity> nearbyList = entity.getWorld().getOtherEntities(entity,
                        new Box(entity.getX()-maxDist, entity.getY()-maxDist, entity.getZ()-maxDist,
                                entity.getX()+maxDist, entity.getY()+maxDist, entity.getZ()+maxDist));
                for(Entity tmp: nearbyList) {
                    if(tmp instanceof ItemEntity) { tmp.onPlayerCollision((PlayerEntity) entity); }
                    if(tmp instanceof ExperienceOrbEntity) { tmp.onPlayerCollision((PlayerEntity) entity); }
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
