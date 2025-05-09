package net.berber.berbersbrews.config;

import net.berber.berbersbrews.BerbersBrews;
import com.mojang.datafixers.util.Pair;

public class ModConfigs {
    public static SimpleConfig CONFIG;
    private static ModConfigProvider configs;
    public static boolean RECIPES_ENABLED;

    public static void registerConfigs() {
        configs = new ModConfigProvider();
        createConfigs();

        CONFIG = SimpleConfig.of(BerbersBrews.MOD_ID + "config").provider(configs).request();

        assignConfigs();
    }

    private static void createConfigs() {
        configs.addKeyValuePair(new Pair<>("recipes.enabled", "true"), "boolean");
    }

    private static void assignConfigs() {
        RECIPES_ENABLED = CONFIG.getOrDefault("recipes.enabled", true);
        System.out.println("All " + configs.getConfigsList().size() + " have been set properly!");
    }
}
