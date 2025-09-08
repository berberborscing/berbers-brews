package net.berber.berbersbrews.effect.perception;

import net.berber.berbersbrews.BerbersBrews;
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

import static net.berber.berbersbrews.config.ModConfigs.PERCEPTION_SOUND;

public class EmeraldPerceptionEffect extends StatusEffect {
    public EmeraldPerceptionEffect(StatusEffectCategory statusEffectCategory, int color) {
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
            TagKey<Block> emeraldOreTag = TagKey.of(Registries.BLOCK.getKey(), Identifier.of("minecraft", "emerald_ores"));

            for (int x = -range; x <= range; x++) {
                for (int y = -range; y <= range; y++) {
                    for (int z = -range; z <= range; z++) {
                        BlockPos targetPos = playerPos.add(x, y, z);
                        //Get the distance between player and this block. Don't bother running anything if > 16.
                        double distance = BerbersBrews.calcDistance(entity.getBlockPos(), targetPos);
                        if(distance <= 16) {
                            Block block = world.getBlockState(targetPos).getBlock();
                            float pitch = 2 - ((float) distance / 10f);
                            if (block.getRegistryEntry().isIn(emeraldOreTag) || block == Blocks.EMERALD_BLOCK) {
                                //Ping the ore faster the closer it is
                                if (entity.getWorld().getTime() % ((int) distance + 2) == 0) {
                                    //Use the configured sound
                                    world.playSound(entity, targetPos, BerbersBrews.getPerceptionSound(PERCEPTION_SOUND), SoundCategory.BLOCKS, 1f, pitch);
                                }
                            }
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