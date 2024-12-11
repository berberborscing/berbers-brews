package net.berber.berbersbrews.effect;

import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.boss.dragon.EnderDragonEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.entity.passive.FoxEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.event.GameEvent;
import org.jetbrains.annotations.Nullable;
import org.joml.Vector3d;

public class TeleportEffect extends StatusEffect {
    public TeleportEffect(StatusEffectCategory statusEffectCategory, int color) {
        super(statusEffectCategory, color);
    }

    private Vector3d tryTeleport(LivingEntity entity, int amplifier) {
        int maxDist = 64 * amplifier;
        double d = entity.getX() + (entity.getRandom().nextDouble() - 0.5) * maxDist;
        double f = entity.getZ() + (entity.getRandom().nextDouble() - 0.5) * maxDist;
        double e = 0;
        //If applied in a cave or underground environment, will send you to the surface.
        // Only applies to dimensions with sky light. This means it won't work in the Nether or the End.
        if(!entity.getEntityWorld().isSkyVisible(entity.getBlockPos()) && entity.getEntityWorld().getDimension().hasSkyLight()) {
            for (int i = (int) entity.getY() + 1; e == 0 || i >= ((ServerWorld)entity.getEntityWorld()).getLogicalHeight(); i++) {
                if(entity.getEntityWorld().isSkyVisible(new BlockPos((int)d, i, (int)f))) {
                    e = i + 1;
                }
            }
        }
        //Otherwise it will just randomly teleport.
        else {
            e = MathHelper.clamp(
                    entity.getY() + (double)(entity.getRandom().nextInt(maxDist) - (maxDist/2)),
                    (double)entity.getEntityWorld().getBottomY(),
                    (double)(entity.getEntityWorld().getBottomY() + ((ServerWorld)entity.getEntityWorld()).getLogicalHeight() - 1)
            );
        }
        return new Vector3d(d, e, f);
    }

    //Tipped arrow effect
    @Override
    public void onApplied(LivingEntity entity, int amplifier) {
        //This potion should not work on the Ender Dragon.
        if(!entity.getEntityWorld().isClient() && !(entity instanceof EnderDragonEntity)) {
            amplifier++;
            boolean teleported = false;
            //The effect will try 50 times before it takes desperate measures.
            for(int j = 0; j < 50; j++) {
                Vector3d triedPos = tryTeleport(entity, amplifier);

                if (entity.hasVehicle()) {
                    entity.stopRiding();
                }

                Vec3d vec3d = entity.getPos();
                if (entity.teleport(triedPos.x, triedPos.y, triedPos.z, true)) {
                    entity.getEntityWorld().emitGameEvent(GameEvent.TELEPORT, vec3d, GameEvent.Emitter.of(entity));
                    SoundCategory soundCategory;
                    SoundEvent soundEvent;
                    if (entity instanceof FoxEntity) {
                        soundEvent = SoundEvents.ENTITY_FOX_TELEPORT;
                        soundCategory = SoundCategory.NEUTRAL;
                    } else {
                        soundEvent = SoundEvents.ITEM_CHORUS_FRUIT_TELEPORT;
                        soundCategory = SoundCategory.PLAYERS;
                    }

                    entity.getEntityWorld().playSound(null, entity.getX(), entity.getY(), entity.getZ(), soundEvent, soundCategory);
                    entity.onLanding();
                    teleported = true;
                    break;
                }
            }
            //It will try 10 more times with increasing desperation before failing.
            if(!teleported) {
                for(int k = 1; k <= 10; k++) {
                    Vector3d triedPos2 = tryTeleport(entity, amplifier + k);

                    if (entity.hasVehicle()) {
                        entity.stopRiding();
                    }

                    Vec3d vec3d = entity.getPos();
                    if (entity.teleport(triedPos2.x, triedPos2.y, triedPos2.z, true)) {
                        entity.getEntityWorld().emitGameEvent(GameEvent.TELEPORT, vec3d, GameEvent.Emitter.of(entity));
                        SoundCategory soundCategory;
                        SoundEvent soundEvent;
                        if (entity instanceof FoxEntity) {
                            soundEvent = SoundEvents.ENTITY_FOX_TELEPORT;
                            soundCategory = SoundCategory.NEUTRAL;
                        } else {
                            soundEvent = SoundEvents.ITEM_CHORUS_FRUIT_TELEPORT;
                            soundCategory = SoundCategory.PLAYERS;
                        }

                        entity.getEntityWorld().playSound(null, entity.getX(), entity.getY(), entity.getZ(), soundEvent, soundCategory);
                        entity.onLanding();
                        teleported = true;
                        break;
                    }
                }
            }
        }
    }

    //Potion effect
    @Override
    public void applyInstantEffect(@Nullable Entity source, @Nullable Entity attacker, LivingEntity entity, int amplifier, double proximity) {
        //This potion should not work on the Ender Dragon.
        if(!entity.getEntityWorld().isClient() && !(entity instanceof EnderDragonEntity)) {
            amplifier++;
            boolean teleported = false;
            //The effect will try 50 times before it takes desperate measures.
            for(int j = 0; j < 50; j++) {
                Vector3d triedPos = tryTeleport(entity, amplifier);

                if (entity.hasVehicle()) {
                    entity.stopRiding();
                }

                Vec3d vec3d = entity.getPos();
                if (entity.teleport(triedPos.x, triedPos.y, triedPos.z, true)) {
                    entity.getEntityWorld().emitGameEvent(GameEvent.TELEPORT, vec3d, GameEvent.Emitter.of(entity));
                    SoundCategory soundCategory;
                    SoundEvent soundEvent;
                    if (entity instanceof FoxEntity) {
                        soundEvent = SoundEvents.ENTITY_FOX_TELEPORT;
                        soundCategory = SoundCategory.NEUTRAL;
                    } else {
                        soundEvent = SoundEvents.ITEM_CHORUS_FRUIT_TELEPORT;
                        soundCategory = SoundCategory.PLAYERS;
                    }

                    entity.getEntityWorld().playSound(null, entity.getX(), entity.getY(), entity.getZ(), soundEvent, soundCategory);
                    entity.onLanding();
                    teleported = true;
                    break;
                }
            }
            //It will try 10 more times with increasing desperation before failing.
            if(!teleported) {
                for(int k = 1; k <= 10; k++) {
                    Vector3d triedPos2 = tryTeleport(entity, amplifier + k);

                    if (entity.hasVehicle()) {
                        entity.stopRiding();
                    }

                    Vec3d vec3d = entity.getPos();
                    if (entity.teleport(triedPos2.x, triedPos2.y, triedPos2.z, true)) {
                        entity.getEntityWorld().emitGameEvent(GameEvent.TELEPORT, vec3d, GameEvent.Emitter.of(entity));
                        SoundCategory soundCategory;
                        SoundEvent soundEvent;
                        if (entity instanceof FoxEntity) {
                            soundEvent = SoundEvents.ENTITY_FOX_TELEPORT;
                            soundCategory = SoundCategory.NEUTRAL;
                        } else {
                            soundEvent = SoundEvents.ITEM_CHORUS_FRUIT_TELEPORT;
                            soundCategory = SoundCategory.PLAYERS;
                        }

                        entity.getEntityWorld().playSound(null, entity.getX(), entity.getY(), entity.getZ(), soundEvent, soundCategory);
                        entity.onLanding();
                        teleported = true;
                        break;
                    }
                }
            }
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
