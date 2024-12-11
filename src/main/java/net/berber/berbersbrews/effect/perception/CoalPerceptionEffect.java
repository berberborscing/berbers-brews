package net.berber.berbersbrews.effect.perception;

import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.registry.Registries;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class CoalPerceptionEffect extends StatusEffect {
    public CoalPerceptionEffect(StatusEffectCategory statusEffectCategory, int color) {
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

            // Create a TagKey for ores
            TagKey<Block> coalOreTag = TagKey.of(Registries.BLOCK.getKey(), Identifier.of("minecraft", "coal_ores"));

            for (int x = -range; x <= range; x++) {
                for (int y = -range; y <= range; y++) {
                    for (int z = -range; z <= range; z++) {
                        BlockPos targetPos = playerPos.add(x, y, z);
                        Block block = world.getBlockState(targetPos).getBlock();
                        float pitch = (float) Math.pow(2, (16 - playerPos.getSquaredDistance(targetPos.toCenterPos())) / 16);
                        // Get the block's ID and check against the ore tag
                        Identifier blockId = Registries.BLOCK.getId(block);
                        if (block.getRegistryEntry().isIn(coalOreTag) || block == Blocks.COAL_BLOCK) {
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