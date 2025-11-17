package net.berber.berbersbrews.config;

import net.berber.berbersbrews.BerbersBrews;
import com.mojang.datafixers.util.Pair;

public class ModConfigs {
    public static SimpleConfig CONFIG;
    private static ModConfigProvider configs;
    public static boolean RECIPES_ENABLED;
    public static boolean TELEPORT_RECIPES_ENABLED;
    public static boolean SILENCE_RECIPES_ENABLED;
    public static boolean CLAIRVOYANCE_RECIPES_ENABLED;
    public static boolean REACH_RECIPES_ENABLED;
    public static boolean PEACE_RECIPES_ENABLED;
    public static boolean SONAR_RECIPES_ENABLED;
    public static boolean PERCEPTION_RECIPES_ENABLED;
    public static String PERCEPTION_SOUND;

    public static void registerConfigs() {
        configs = new ModConfigProvider();
        createConfigs();

        CONFIG = SimpleConfig.of(BerbersBrews.MOD_ID + "config").provider(configs).request();

        assignConfigs();
    }

    private static void createConfigs() {
        configs.addKeyValuePair(new Pair<>("recipes.enabled", "true"), "boolean");
        configs.addKeyValuePair(new Pair<>("recipes.teleportrecallreturn.enabled", "true"), "boolean");
        configs.addKeyValuePair(new Pair<>("recipes.silence.enabled", "true"), "boolean");
        configs.addKeyValuePair(new Pair<>("recipes.clairvoyance.enabled", "true"), "boolean");
        configs.addKeyValuePair(new Pair<>("recipes.reach.enabled", "true"), "boolean");
        configs.addKeyValuePair(new Pair<>("recipes.sonar.enabled", "true"), "boolean");
        configs.addKeyValuePair(new Pair<>("recipes.peace.enabled", "true"), "boolean");
        configs.addKeyValuePair(new Pair<>("recipes.perception.enabled", "true"), "boolean");
        configs.addKeyValuePair(new Pair<>("sound.perception", "bit"), "string");
    }

    private static void assignConfigs() {
        RECIPES_ENABLED = CONFIG.getOrDefault("recipes.enabled", true);
        TELEPORT_RECIPES_ENABLED = CONFIG.getOrDefault("recipes.teleportrecallreturn.enabled", true);
        SILENCE_RECIPES_ENABLED = CONFIG.getOrDefault("recipes.silence.enabled", true);
        CLAIRVOYANCE_RECIPES_ENABLED = CONFIG.getOrDefault("recipes.clairvoyance.enabled", true);
        REACH_RECIPES_ENABLED = CONFIG.getOrDefault("recipes.reach.enabled", true);
        SONAR_RECIPES_ENABLED = CONFIG.getOrDefault("recipes.sonar.enabled", true);
        PEACE_RECIPES_ENABLED = CONFIG.getOrDefault("recipes.peace.enabled", true);
        PERCEPTION_RECIPES_ENABLED = CONFIG.getOrDefault("recipes.perception.enabled", true);
        PERCEPTION_SOUND = CONFIG.getOrDefault("sound.perception", "bit");
        System.out.println("All " + configs.getConfigsList().size() + " have been set properly!");
    }
}
