package net.berber.berbersbrews.effect;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.registry.RegistryKey;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.TeleportTarget;
import net.minecraft.world.World;

import java.util.HashMap;
import java.util.UUID;

public class ReturnEffect extends StatusEffect {
    private static final HashMap<UUID, PositionData> originalPositions = new HashMap<>();

    public ReturnEffect(StatusEffectCategory statusEffectCategory, int color) {
        super(statusEffectCategory, color);
    }

    private static class PositionData {
        public final Vec3d position;
        public final RegistryKey<World> dimension;

        public PositionData(Vec3d position, RegistryKey<World> dimension) {
            this.position = position;
            this.dimension = dimension;
        }
    }

    @Override
    public boolean applyUpdateEffect(LivingEntity entity, int amplifier) {
        if (!entity.getEntityWorld().isClient()) {
            UUID entityId = entity.getUuid();
            PositionData originalData = originalPositions.get(entityId);

            // If there's no stored original position, it means it's the first application
            if (originalData == null) {
                // Store original position and dimension
                originalPositions.put(entityId, new PositionData(entity.getPos(), entity.getWorld().getRegistryKey()));

                // Teleport entity to spawn
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

            // Check for expiration
            if (entity.getStatusEffect(ModEffects.RETURN) != null && entity.getStatusEffect(ModEffects.RETURN).getDuration() <= 1) {
                // Teleport back to the original position on effect expiration
                if (originalData != null && entity instanceof ServerPlayerEntity serverPlayerEntity) {
                    ServerWorld targetWorld = serverPlayerEntity.getServer().getWorld(originalData.dimension);
                    if (targetWorld != null) {
                        serverPlayerEntity.teleport(targetWorld, originalData.position.x, originalData.position.y, originalData.position.z, serverPlayerEntity.getYaw(), serverPlayerEntity.getPitch());
                        targetWorld.playSound(null, originalData.position.x, originalData.position.y, originalData.position.z, SoundEvents.BLOCK_PORTAL_TRAVEL, SoundCategory.PLAYERS, 0.25f, 2f);
                    }
                }
                // Clean up the stored position data after teleporting
                originalPositions.remove(entityId);
            }
        }
        return true;
    }

    @Override
    public boolean canApplyUpdateEffect(int pDuration, int pAmplifier) {
        return true;
    }
}
