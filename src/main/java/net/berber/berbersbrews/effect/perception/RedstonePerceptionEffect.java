package net.berber.berbersbrews.effect.perception;

import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.registry.Registries;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class RedstonePerceptionEffect extends StatusEffect {
    public RedstonePerceptionEffect(StatusEffectCategory statusEffectCategory, int color) {
        super(statusEffectCategory, color);
    }

    @Override
    public boolean applyUpdateEffect(LivingEntity entity, int amplifier) {
        if (entity.getWorld().isClient) {
            World world = entity.getWorld();
            BlockPos playerPos = entity.getBlockPos();
            amplifier++;
            amplifier = Math.min(2, amplifier);

            // Adjust range as needed (3 here means 3 blocks away)
            int range = 8 * amplifier;

            for (int x = -range; x <= range; x++) {
                for (int y = -range; y <= range; y++) {
                    for (int z = -range; z <= range; z++) {
                        BlockPos targetPos = playerPos.add(x, y, z);
                        Block block = world.getBlockState(targetPos).getBlock();
                        float pitch = (float) Math.pow(2, (16 - playerPos.getSquaredDistance(targetPos.toCenterPos())) / 16);
                        // Get the block's ID and check against the ore tag
                        Identifier blockId = Registries.BLOCK.getId(block);
                        //This not only identifies Redstone Ores and Blocks, but also Redstone Dust, Torches, Lamps, and Trapped Chests.
                        if (blockId.getPath().contains("redstone") || block == Blocks.TRAPPED_CHEST) {
                            world.playSound(entity, targetPos, SoundEvents.BLOCK_NOTE_BLOCK_BASS.value(), SoundCategory.BLOCKS, 1f, pitch);
                        }
                    }
                }
            }
        }
        return true;
    }


    @Override
    public boolean canApplyUpdateEffect(int d, int p) {
        return d % 15 == 0;
    }
}