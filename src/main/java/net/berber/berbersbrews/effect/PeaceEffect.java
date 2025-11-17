package net.berber.berbersbrews.effect;

import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.util.math.Box;

import java.util.List;

public class PeaceEffect extends StatusEffect {
    public PeaceEffect(StatusEffectCategory statusEffectCategory, int color) {
        super(statusEffectCategory, color);
    }

    @Override
    public boolean applyUpdateEffect(LivingEntity entity, int amplifier) {
        if(!entity.getWorld().isClient()) {
            double maxDist = 128;
            int currentMobCount = 0;
            int revisedMobCap = 50 / (amplifier+1); //amplifier suppresses the local mob cap more
            List<Entity> nearbyList = entity.getWorld().getOtherEntities(entity,
                    new Box(entity.getX()-maxDist, entity.getY()-maxDist, entity.getZ()-maxDist,
                            entity.getX()+maxDist, entity.getY()+maxDist, entity.getZ()+maxDist));
            for(Entity tmp: nearbyList) {
                if(tmp instanceof HostileEntity) {
                    currentMobCount++;
                    //Ignore persistent mobs
                    if (!((HostileEntity) tmp).isPersistent() && currentMobCount > revisedMobCap) {
                        double distSq = tmp.getBlockPos().getSquaredDistance(entity.getBlockPos());
                        //Only discard entities that are not very close to the player AND not aggroed to the target
                        if (distSq > (24*24) && ((HostileEntity) tmp).getTarget() != entity) {
                            tmp.discard();
                        }
                    }
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
