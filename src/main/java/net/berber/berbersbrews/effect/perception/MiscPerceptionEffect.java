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

public class MiscPerceptionEffect extends StatusEffect {
    public MiscPerceptionEffect(StatusEffectCategory statusEffectCategory, int color) {
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
            TagKey<Block> diamondOreTag = TagKey.of(Registries.BLOCK.getKey(), Identifier.of("minecraft", "diamond_ores"));
            TagKey<Block> emeraldOreTag = TagKey.of(Registries.BLOCK.getKey(), Identifier.of("minecraft", "emerald_ores"));
            TagKey<Block> goldOreTag = TagKey.of(Registries.BLOCK.getKey(), Identifier.of("minecraft", "gold_ores"));
            TagKey<Block> lapisOreTag = TagKey.of(Registries.BLOCK.getKey(), Identifier.of("minecraft", "lapis_ores"));
            TagKey<Block> ironOreTag = TagKey.of(Registries.BLOCK.getKey(), Identifier.of("minecraft", "iron_ores"));
            TagKey<Block> redstoneOreTag = TagKey.of(Registries.BLOCK.getKey(), Identifier.of("minecraft", "redstone_ores"));
            TagKey<Block> coalOreTag = TagKey.of(Registries.BLOCK.getKey(), Identifier.of("minecraft", "coal_ores"));
            TagKey<Block> copperOreTag = TagKey.of(Registries.BLOCK.getKey(), Identifier.of("minecraft", "copper_ores"));
            TagKey<Block> oreTag = TagKey.of(Registries.BLOCK.getKey(), Identifier.of("c", "ores"));

            for (int x = -range; x <= range; x++) {
                for (int y = -range; y <= range; y++) {
                    for (int z = -range; z <= range; z++) {
                        BlockPos targetPos = playerPos.add(x, y, z);
                        Block block = world.getBlockState(targetPos).getBlock();
                        float pitch = (float) Math.pow(2, (16 - playerPos.getSquaredDistance(targetPos.toCenterPos())) / 16);
                        // Get the block's ID and check against the ore tag
                        Identifier blockId = Registries.BLOCK.getId(block);
                        //The following code here is to except these ores from being detected.
                        if(block == Blocks.ANCIENT_DEBRIS) {  }
                        else if (block.getRegistryEntry().isIn(diamondOreTag)) { }
                        else if (block.getRegistryEntry().isIn(emeraldOreTag)) { }
                        else if (block.getRegistryEntry().isIn(goldOreTag)) { }
                        else if (block.getRegistryEntry().isIn(lapisOreTag)) { }
                        else if (block.getRegistryEntry().isIn(ironOreTag)) { }
                        else if (block.getRegistryEntry().isIn(redstoneOreTag)) { }
                        else if (block.getRegistryEntry().isIn(coalOreTag)) { }
                        else if (block.getRegistryEntry().isIn(copperOreTag)) { }
                        //This covers all non-vanilla blocks marked as ores. Includes Nether Quartz ore, evolution stone ore from Cobblemon, etc.
                        else if (block.getRegistryEntry().isIn(oreTag) || block == Blocks.CHEST) { world.playSound(entity, targetPos, SoundEvents.BLOCK_NOTE_BLOCK_HARP.value(), SoundCategory.BLOCKS, 1f, pitch); }
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