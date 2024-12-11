package net.berber.berbersbrews.effect;

import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.util.math.Box;

import java.util.List;

public class PrivyEffect extends StatusEffect {
    public PrivyEffect(StatusEffectCategory statusEffectCategory, int color) {
        super(statusEffectCategory, color);
    }

    @Override
    public boolean applyUpdateEffect(LivingEntity entity, int amplifier) {
        amplifier++;
        double maxDist = 16 * amplifier;
        //entity.setPos(entity.getX(), entity.getY()+1, entity.getZ());
        List<Entity> nearbyList = entity.getWorld().getOtherEntities(entity,
                new Box(entity.getX()-maxDist, entity.getY()-maxDist, entity.getZ()-maxDist,
                        entity.getX()+maxDist, entity.getY()+maxDist, entity.getZ()+maxDist));
        for(Entity tmp: nearbyList) {
            if(tmp instanceof LivingEntity) {
                ((LivingEntity)tmp).addStatusEffect(new StatusEffectInstance(StatusEffects.GLOWING, 10, 0, true, false, false));
            }
        }

        return true;
    }

    @Override
    public boolean canApplyUpdateEffect(int d, int p) {
        return true;
    }
}
