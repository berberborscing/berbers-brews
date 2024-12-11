package net.berber.berbersbrews;

import net.berber.berbersbrews.effect.ModEffects;
import net.berber.berbersbrews.potion.ModPotions;
import net.fabricmc.api.ModInitializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BerbersBrews implements ModInitializer {
	public static final String MOD_ID = "berbersbrews";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModEffects.registerEffects();
		ModPotions.registerPotions();
	}
}