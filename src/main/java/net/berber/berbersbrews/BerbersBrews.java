package net.berber.berbersbrews;

import net.berber.berbersbrews.effect.ModEffects;
import net.berber.berbersbrews.potion.ModPotions;
import net.berber.berbersbrews.config.ModConfigs;
import net.fabricmc.api.ModInitializer;

import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.math.BlockPos;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BerbersBrews implements ModInitializer {
	public static final String MOD_ID = "berbersbrews";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModConfigs.registerConfigs();
		ModEffects.registerEffects();
		ModPotions.registerPotions();
	}

	//Used to calculate the distance between two points
	public static double calcDistance(BlockPos entityPos, BlockPos targetPos) {
		double deltaX = entityPos.getX() - targetPos.getX();
		double deltaY = entityPos.getY() - targetPos.getY();
		double deltaZ = entityPos.getZ() - targetPos.getZ();
		return Math.sqrt((deltaX * deltaX) + (deltaY * deltaY) + (deltaZ * deltaZ));
	}

	//Used to return the sound effect based on the config options
	public static SoundEvent getPerceptionSound(String config) {
        return switch (config) {
            case "bit" -> SoundEvents.BLOCK_NOTE_BLOCK_BIT.value();
            case "bass" -> SoundEvents.BLOCK_NOTE_BLOCK_BASS.value();
            case "snare" -> SoundEvents.BLOCK_NOTE_BLOCK_SNARE.value();
            case "hat" -> SoundEvents.BLOCK_NOTE_BLOCK_HAT.value();
            case "basedrum" -> SoundEvents.BLOCK_NOTE_BLOCK_BASEDRUM.value();
			case "bell" -> SoundEvents.BLOCK_NOTE_BLOCK_BELL.value();
			case "flute" -> SoundEvents.BLOCK_NOTE_BLOCK_FLUTE.value();
			case "chime" -> SoundEvents.BLOCK_NOTE_BLOCK_CHIME.value();
			case "guitar" -> SoundEvents.BLOCK_NOTE_BLOCK_GUITAR.value();
			case "xylophone" -> SoundEvents.BLOCK_NOTE_BLOCK_XYLOPHONE.value();
			case "iron_xylophone" -> SoundEvents.BLOCK_NOTE_BLOCK_IRON_XYLOPHONE.value();
            case "cow_bell" -> SoundEvents.BLOCK_NOTE_BLOCK_COW_BELL.value();
            case "didgeridoo" -> SoundEvents.BLOCK_NOTE_BLOCK_DIDGERIDOO.value();
            case "banjo" -> SoundEvents.BLOCK_NOTE_BLOCK_BANJO.value();
            case "pling" -> SoundEvents.BLOCK_NOTE_BLOCK_PLING.value();
            case "harp" -> SoundEvents.BLOCK_NOTE_BLOCK_HARP.value();
            default -> SoundEvents.BLOCK_NOTE_BLOCK_BIT.value();
        };
	}
}