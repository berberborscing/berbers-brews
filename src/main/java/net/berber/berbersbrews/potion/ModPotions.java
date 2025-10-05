package net.berber.berbersbrews.potion;

import net.berber.berbersbrews.config.ModConfigs;
import net.berber.berbersbrews.effect.ModEffects;
import net.fabricmc.fabric.api.registry.FabricBrewingRecipeRegistryBuilder;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.item.Items;
import net.minecraft.potion.Potion;
import net.minecraft.potion.Potions;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.berber.berbersbrews.BerbersBrews;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.Identifier;

public class ModPotions {

    public static RegistryEntry<Potion> TELEPORT_POTION;
    public static RegistryEntry<Potion> STRONG_TELEPORT_POTION;
    public static RegistryEntry<Potion> RECALL_POTION;

    public static RegistryEntry<Potion> RETURN_POTION;
    public static RegistryEntry<Potion> LONG_RETURN_POTION;

    public static RegistryEntry<Potion> SILENCE_POTION;
    public static RegistryEntry<Potion> LONG_SILENCE_POTION;

    public static RegistryEntry<Potion> PRIVY_POTION;
    public static RegistryEntry<Potion> LONG_PRIVY_POTION;
    public static RegistryEntry<Potion> STRONG_PRIVY_POTION;

    public static RegistryEntry<Potion> REACH_POTION;
    public static RegistryEntry<Potion> LONG_REACH_POTION;
    public static RegistryEntry<Potion> STRONG_REACH_POTION;

    public static RegistryEntry<Potion> ABLE_POTION;
    public static RegistryEntry<Potion> LONG_ABLE_POTION;
    public static RegistryEntry<Potion> STRONG_ABLE_POTION;

    public static RegistryEntry<Potion> SONAR_POTION;
    public static RegistryEntry<Potion> LONG_SONAR_POTION;

    public static RegistryEntry<Potion> AMETHYSTPERCEPTION_POTION;
    public static RegistryEntry<Potion> LONG_AMETHYSTPERCEPTION_POTION;
    public static RegistryEntry<Potion> STRONG_AMETHYSTPERCEPTION_POTION;

    public static RegistryEntry<Potion> COALPERCEPTION_POTION;
    public static RegistryEntry<Potion> LONG_COALPERCEPTION_POTION;
    public static RegistryEntry<Potion> STRONG_COALPERCEPTION_POTION;

    public static RegistryEntry<Potion> COPPERPERCEPTION_POTION;
    public static RegistryEntry<Potion> LONG_COPPERPERCEPTION_POTION;
    public static RegistryEntry<Potion> STRONG_COPPERPERCEPTION_POTION;

    public static RegistryEntry<Potion> DIAMONDPERCEPTION_POTION;
    public static RegistryEntry<Potion> LONG_DIAMONDPERCEPTION_POTION;
    public static RegistryEntry<Potion> STRONG_DIAMONDPERCEPTION_POTION;

    public static RegistryEntry<Potion> EMERALDPERCEPTION_POTION;
    public static RegistryEntry<Potion> LONG_EMERALDPERCEPTION_POTION;
    public static RegistryEntry<Potion> STRONG_EMERALDPERCEPTION_POTION;

    public static RegistryEntry<Potion> GOLDPERCEPTION_POTION;
    public static RegistryEntry<Potion> LONG_GOLDPERCEPTION_POTION;
    public static RegistryEntry<Potion> STRONG_GOLDPERCEPTION_POTION;

    public static RegistryEntry<Potion> IRONPERCEPTION_POTION;
    public static RegistryEntry<Potion> LONG_IRONPERCEPTION_POTION;
    public static RegistryEntry<Potion> STRONG_IRONPERCEPTION_POTION;

    public static RegistryEntry<Potion> LAPISPERCEPTION_POTION;
    public static RegistryEntry<Potion> LONG_LAPISPERCEPTION_POTION;
    public static RegistryEntry<Potion> STRONG_LAPISPERCEPTION_POTION;

    public static RegistryEntry<Potion> MISCPERCEPTION_POTION;
    public static RegistryEntry<Potion> LONG_MISCPERCEPTION_POTION;
    public static RegistryEntry<Potion> STRONG_MISCPERCEPTION_POTION;

    public static RegistryEntry<Potion> NETHERITEPERCEPTION_POTION;
    public static RegistryEntry<Potion> LONG_NETHERITEPERCEPTION_POTION;
    public static RegistryEntry<Potion> STRONG_NETHERITEPERCEPTION_POTION;

    public static RegistryEntry<Potion> REDSTONEPERCEPTION_POTION;
    public static RegistryEntry<Potion> LONG_REDSTONEPERCEPTION_POTION;
    public static RegistryEntry<Potion> STRONG_REDSTONEPERCEPTION_POTION;
    //Register potions
    public static void registerPotions() {

        TELEPORT_POTION = Registry.registerReference(Registries.POTION, Identifier.of(BerbersBrews.MOD_ID, "teleport_potion"),
                new Potion(new StatusEffectInstance(ModEffects.TELEPORT, 1, 0)));
        STRONG_TELEPORT_POTION = Registry.registerReference(Registries.POTION, Identifier.of(BerbersBrews.MOD_ID, "strong_teleport_potion"),
                new Potion(new StatusEffectInstance(ModEffects.TELEPORT, 1, 1)));
        RECALL_POTION = Registry.registerReference(Registries.POTION, Identifier.of(BerbersBrews.MOD_ID, "recall_potion"),
                new Potion(new StatusEffectInstance(ModEffects.RECALL, 1, 0)));

        RETURN_POTION = Registry.registerReference(Registries.POTION, Identifier.of(BerbersBrews.MOD_ID, "return_potion"),
                new Potion(new StatusEffectInstance(ModEffects.RETURN, 6000, 0)));
        LONG_RETURN_POTION = Registry.registerReference(Registries.POTION, Identifier.of(BerbersBrews.MOD_ID, "long_return_potion"),
                new Potion(new StatusEffectInstance(ModEffects.RETURN, 12000, 0)));

        SILENCE_POTION = Registry.registerReference(Registries.POTION, Identifier.of(BerbersBrews.MOD_ID, "silence_potion"),
                new Potion(new StatusEffectInstance(ModEffects.SILENCE, 3600, 0)));
        LONG_SILENCE_POTION = Registry.registerReference(Registries.POTION, Identifier.of(BerbersBrews.MOD_ID, "long_silence_potion"),
                new Potion(new StatusEffectInstance(ModEffects.SILENCE, 9600, 0)));

        PRIVY_POTION = Registry.registerReference(Registries.POTION, Identifier.of(BerbersBrews.MOD_ID, "privy_potion"),
                new Potion(new StatusEffectInstance(ModEffects.PRIVY, 3600, 0)));
        LONG_PRIVY_POTION = Registry.registerReference(Registries.POTION, Identifier.of(BerbersBrews.MOD_ID, "long_privy_potion"),
                new Potion(new StatusEffectInstance(ModEffects.PRIVY, 9600, 0)));
        STRONG_PRIVY_POTION = Registry.registerReference(Registries.POTION, Identifier.of(BerbersBrews.MOD_ID, "strong_privy_potion"),
                new Potion(new StatusEffectInstance(ModEffects.PRIVY, 1800, 1)));

        REACH_POTION = Registry.registerReference(Registries.POTION, Identifier.of(BerbersBrews.MOD_ID, "reach_potion"),
                new Potion(new StatusEffectInstance(ModEffects.REACH, 3600, 0)));
        LONG_REACH_POTION = Registry.registerReference(Registries.POTION, Identifier.of(BerbersBrews.MOD_ID, "long_reach_potion"),
                new Potion(new StatusEffectInstance(ModEffects.REACH, 9600, 0)));
        STRONG_REACH_POTION = Registry.registerReference(Registries.POTION, Identifier.of(BerbersBrews.MOD_ID, "strong_reach_potion"),
                new Potion(new StatusEffectInstance(ModEffects.REACH, 1800, 1)));

        ABLE_POTION = Registry.registerReference(Registries.POTION, Identifier.of(BerbersBrews.MOD_ID, "able_potion"),
                new Potion(new StatusEffectInstance(ModEffects.ABLE, 3600, 0)));
        LONG_ABLE_POTION = Registry.registerReference(Registries.POTION, Identifier.of(BerbersBrews.MOD_ID, "long_able_potion"),
                new Potion(new StatusEffectInstance(ModEffects.ABLE, 9600, 0)));
        STRONG_ABLE_POTION = Registry.registerReference(Registries.POTION, Identifier.of(BerbersBrews.MOD_ID, "strong_able_potion"),
                new Potion(new StatusEffectInstance(ModEffects.ABLE, 1800, 1)));

        SONAR_POTION = Registry.registerReference(Registries.POTION, Identifier.of(BerbersBrews.MOD_ID, "sonar_potion"),
                new Potion(new StatusEffectInstance(ModEffects.SONAR, 3600, 0)));
        LONG_SONAR_POTION = Registry.registerReference(Registries.POTION, Identifier.of(BerbersBrews.MOD_ID, "long_sonar_potion"),
                new Potion(new StatusEffectInstance(ModEffects.SONAR, 9600, 0)));

        AMETHYSTPERCEPTION_POTION = Registry.registerReference(Registries.POTION, Identifier.of(BerbersBrews.MOD_ID, "amethystperception_potion"),
                new Potion(new StatusEffectInstance(ModEffects.AMETHYSTPERCEPTION, 1800, 0)));
        LONG_AMETHYSTPERCEPTION_POTION = Registry.registerReference(Registries.POTION, Identifier.of(BerbersBrews.MOD_ID, "long_amethystperception_potion"),
                new Potion(new StatusEffectInstance(ModEffects.AMETHYSTPERCEPTION, 4800, 0)));
        STRONG_AMETHYSTPERCEPTION_POTION = Registry.registerReference(Registries.POTION, Identifier.of(BerbersBrews.MOD_ID, "strong_amethystperception_potion"),
                new Potion(new StatusEffectInstance(ModEffects.AMETHYSTPERCEPTION, 900, 1)));

        COALPERCEPTION_POTION = Registry.registerReference(Registries.POTION, Identifier.of(BerbersBrews.MOD_ID, "coalperception_potion"),
                new Potion(new StatusEffectInstance(ModEffects.COALPERCEPTION, 1800, 0)));
        LONG_COALPERCEPTION_POTION = Registry.registerReference(Registries.POTION, Identifier.of(BerbersBrews.MOD_ID, "long_coalperception_potion"),
                new Potion(new StatusEffectInstance(ModEffects.COALPERCEPTION, 4800, 0)));
        STRONG_COALPERCEPTION_POTION = Registry.registerReference(Registries.POTION, Identifier.of(BerbersBrews.MOD_ID, "strong_coalperception_potion"),
                new Potion(new StatusEffectInstance(ModEffects.COALPERCEPTION, 900, 1)));

        COPPERPERCEPTION_POTION = Registry.registerReference(Registries.POTION, Identifier.of(BerbersBrews.MOD_ID, "copperperception_potion"),
                new Potion(new StatusEffectInstance(ModEffects.COPPERPERCEPTION, 1800, 0)));
        LONG_COPPERPERCEPTION_POTION = Registry.registerReference(Registries.POTION, Identifier.of(BerbersBrews.MOD_ID, "long_copperperception_potion"),
                new Potion(new StatusEffectInstance(ModEffects.COPPERPERCEPTION, 4800, 0)));
        STRONG_COPPERPERCEPTION_POTION = Registry.registerReference(Registries.POTION, Identifier.of(BerbersBrews.MOD_ID, "strong_copperperception_potion"),
                new Potion(new StatusEffectInstance(ModEffects.COPPERPERCEPTION, 900, 1)));

        DIAMONDPERCEPTION_POTION = Registry.registerReference(Registries.POTION, Identifier.of(BerbersBrews.MOD_ID, "diamondperception_potion"),
                new Potion(new StatusEffectInstance(ModEffects.DIAMONDPERCEPTION, 1800, 0)));
        LONG_DIAMONDPERCEPTION_POTION = Registry.registerReference(Registries.POTION, Identifier.of(BerbersBrews.MOD_ID, "long_diamondperception_potion"),
                new Potion(new StatusEffectInstance(ModEffects.DIAMONDPERCEPTION, 4800, 0)));
        STRONG_DIAMONDPERCEPTION_POTION = Registry.registerReference(Registries.POTION, Identifier.of(BerbersBrews.MOD_ID, "strong_diamondperception_potion"),
                new Potion(new StatusEffectInstance(ModEffects.DIAMONDPERCEPTION, 900, 1)));

        EMERALDPERCEPTION_POTION = Registry.registerReference(Registries.POTION, Identifier.of(BerbersBrews.MOD_ID, "emeraldperception_potion"),
                new Potion(new StatusEffectInstance(ModEffects.EMERALDPERCEPTION, 1800, 0)));
        LONG_EMERALDPERCEPTION_POTION = Registry.registerReference(Registries.POTION, Identifier.of(BerbersBrews.MOD_ID, "long_emeraldperception_potion"),
                new Potion(new StatusEffectInstance(ModEffects.EMERALDPERCEPTION, 4800, 0)));
        STRONG_EMERALDPERCEPTION_POTION = Registry.registerReference(Registries.POTION, Identifier.of(BerbersBrews.MOD_ID, "strong_emeraldperception_potion"),
                new Potion(new StatusEffectInstance(ModEffects.EMERALDPERCEPTION, 900, 1)));

        GOLDPERCEPTION_POTION = Registry.registerReference(Registries.POTION, Identifier.of(BerbersBrews.MOD_ID, "goldperception_potion"),
                new Potion(new StatusEffectInstance(ModEffects.GOLDPERCEPTION, 1800, 0)));
        LONG_GOLDPERCEPTION_POTION = Registry.registerReference(Registries.POTION, Identifier.of(BerbersBrews.MOD_ID, "long_goldperception_potion"),
                new Potion(new StatusEffectInstance(ModEffects.GOLDPERCEPTION, 4800, 0)));
        STRONG_GOLDPERCEPTION_POTION = Registry.registerReference(Registries.POTION, Identifier.of(BerbersBrews.MOD_ID, "strong_goldperception_potion"),
                new Potion(new StatusEffectInstance(ModEffects.GOLDPERCEPTION, 900, 1)));

        IRONPERCEPTION_POTION = Registry.registerReference(Registries.POTION, Identifier.of(BerbersBrews.MOD_ID, "ironperception_potion"),
                new Potion(new StatusEffectInstance(ModEffects.IRONPERCEPTION, 1800, 0)));
        LONG_IRONPERCEPTION_POTION = Registry.registerReference(Registries.POTION, Identifier.of(BerbersBrews.MOD_ID, "long_ironperception_potion"),
                new Potion(new StatusEffectInstance(ModEffects.IRONPERCEPTION, 4800, 0)));
        STRONG_IRONPERCEPTION_POTION = Registry.registerReference(Registries.POTION, Identifier.of(BerbersBrews.MOD_ID, "strong_ironperception_potion"),
                new Potion(new StatusEffectInstance(ModEffects.IRONPERCEPTION, 900, 1)));

        LAPISPERCEPTION_POTION = Registry.registerReference(Registries.POTION, Identifier.of(BerbersBrews.MOD_ID, "lapisperception_potion"),
                new Potion(new StatusEffectInstance(ModEffects.LAPISPERCEPTION, 1800, 0)));
        LONG_LAPISPERCEPTION_POTION = Registry.registerReference(Registries.POTION, Identifier.of(BerbersBrews.MOD_ID, "long_lapisperception_potion"),
                new Potion(new StatusEffectInstance(ModEffects.LAPISPERCEPTION, 4800, 0)));
        STRONG_LAPISPERCEPTION_POTION = Registry.registerReference(Registries.POTION, Identifier.of(BerbersBrews.MOD_ID, "strong_lapisperception_potion"),
                new Potion(new StatusEffectInstance(ModEffects.LAPISPERCEPTION, 900, 1)));

        MISCPERCEPTION_POTION = Registry.registerReference(Registries.POTION, Identifier.of(BerbersBrews.MOD_ID, "miscperception_potion"),
                new Potion(new StatusEffectInstance(ModEffects.MISCPERCEPTION, 1800, 0)));
        LONG_MISCPERCEPTION_POTION = Registry.registerReference(Registries.POTION, Identifier.of(BerbersBrews.MOD_ID, "long_miscperception_potion"),
                new Potion(new StatusEffectInstance(ModEffects.MISCPERCEPTION, 4800, 0)));
        STRONG_MISCPERCEPTION_POTION = Registry.registerReference(Registries.POTION, Identifier.of(BerbersBrews.MOD_ID, "strong_miscperception_potion"),
                new Potion(new StatusEffectInstance(ModEffects.MISCPERCEPTION, 900, 1)));

        NETHERITEPERCEPTION_POTION = Registry.registerReference(Registries.POTION, Identifier.of(BerbersBrews.MOD_ID, "netheriteperception_potion"),
                new Potion(new StatusEffectInstance(ModEffects.NETHERITEPERCEPTION, 1800, 0)));
        LONG_NETHERITEPERCEPTION_POTION = Registry.registerReference(Registries.POTION, Identifier.of(BerbersBrews.MOD_ID, "long_netheriteperception_potion"),
                new Potion(new StatusEffectInstance(ModEffects.NETHERITEPERCEPTION, 4800, 0)));
        STRONG_NETHERITEPERCEPTION_POTION = Registry.registerReference(Registries.POTION, Identifier.of(BerbersBrews.MOD_ID, "strong_netheriteperception_potion"),
                new Potion(new StatusEffectInstance(ModEffects.NETHERITEPERCEPTION, 900, 1)));

        REDSTONEPERCEPTION_POTION = Registry.registerReference(Registries.POTION, Identifier.of(BerbersBrews.MOD_ID, "redstoneperception_potion"),
                new Potion(new StatusEffectInstance(ModEffects.REDSTONEPERCEPTION, 1800, 0)));
        LONG_REDSTONEPERCEPTION_POTION = Registry.registerReference(Registries.POTION, Identifier.of(BerbersBrews.MOD_ID, "long_redstoneperception_potion"),
                new Potion(new StatusEffectInstance(ModEffects.REDSTONEPERCEPTION, 4800, 0)));
        STRONG_REDSTONEPERCEPTION_POTION = Registry.registerReference(Registries.POTION, Identifier.of(BerbersBrews.MOD_ID, "strong_redstoneperception_potion"),
                new Potion(new StatusEffectInstance(ModEffects.REDSTONEPERCEPTION, 900, 1)));

        registerPotionRecipes();
    }

    //Brewing recipes
    private static void registerPotionRecipes() {
        if(ModConfigs.RECIPES_ENABLED) {
            if(ModConfigs.TELEPORT_RECIPES_ENABLED) {
                FabricBrewingRecipeRegistryBuilder.BUILD.register(builder->{builder.registerPotionRecipe(Potions.AWKWARD, Items.CHORUS_FRUIT, ModPotions.TELEPORT_POTION);});
                FabricBrewingRecipeRegistryBuilder.BUILD.register(builder->{builder.registerPotionRecipe(ModPotions.TELEPORT_POTION, Items.GLOWSTONE_DUST, ModPotions.STRONG_TELEPORT_POTION);});
                FabricBrewingRecipeRegistryBuilder.BUILD.register(builder->{builder.registerPotionRecipe(ModPotions.TELEPORT_POTION, Items.FERMENTED_SPIDER_EYE, ModPotions.RECALL_POTION);});

                FabricBrewingRecipeRegistryBuilder.BUILD.register(builder->{builder.registerPotionRecipe(ModPotions.RECALL_POTION, Items.CLOCK, ModPotions.RETURN_POTION);});
                FabricBrewingRecipeRegistryBuilder.BUILD.register(builder->{builder.registerPotionRecipe(ModPotions.RETURN_POTION, Items.REDSTONE, ModPotions.LONG_RETURN_POTION);});
            }

            if(ModConfigs.SILENCE_RECIPES_ENABLED) {
                FabricBrewingRecipeRegistryBuilder.BUILD.register(builder->{builder.registerPotionRecipe(Potions.AWKWARD, Items.ECHO_SHARD, ModPotions.SILENCE_POTION);});
                FabricBrewingRecipeRegistryBuilder.BUILD.register(builder->{builder.registerPotionRecipe(ModPotions.SILENCE_POTION, Items.REDSTONE, ModPotions.LONG_SILENCE_POTION);});
            }

            if(ModConfigs.CLAIRVOYANCE_RECIPES_ENABLED) {
                FabricBrewingRecipeRegistryBuilder.BUILD.register(builder->{builder.registerPotionRecipe(Potions.AWKWARD, Items.GLOW_BERRIES, ModPotions.PRIVY_POTION);});
                FabricBrewingRecipeRegistryBuilder.BUILD.register(builder->{builder.registerPotionRecipe(ModPotions.PRIVY_POTION, Items.REDSTONE, ModPotions.LONG_PRIVY_POTION);});
                FabricBrewingRecipeRegistryBuilder.BUILD.register(builder->{builder.registerPotionRecipe(ModPotions.PRIVY_POTION, Items.GLOWSTONE_DUST, ModPotions.STRONG_PRIVY_POTION);});
            }

            if(ModConfigs.REACH_RECIPES_ENABLED) {
            FabricBrewingRecipeRegistryBuilder.BUILD.register(builder->{builder.registerPotionRecipe(Potions.AWKWARD, Items.ENDER_PEARL, ModPotions.REACH_POTION);});
            FabricBrewingRecipeRegistryBuilder.BUILD.register(builder->{builder.registerPotionRecipe(ModPotions.REACH_POTION, Items.REDSTONE, ModPotions.LONG_REACH_POTION);});
            FabricBrewingRecipeRegistryBuilder.BUILD.register(builder->{builder.registerPotionRecipe(ModPotions.REACH_POTION, Items.GLOWSTONE_DUST, ModPotions.STRONG_REACH_POTION);});
            }

            if(ModConfigs.ABILITY_RECIPES_ENABLED) {
            FabricBrewingRecipeRegistryBuilder.BUILD.register(builder->{builder.registerPotionRecipe(Potions.AWKWARD, Items.SLIME_BALL, ModPotions.ABLE_POTION);});
            FabricBrewingRecipeRegistryBuilder.BUILD.register(builder->{builder.registerPotionRecipe(ModPotions.ABLE_POTION, Items.REDSTONE, ModPotions.LONG_ABLE_POTION);});
            FabricBrewingRecipeRegistryBuilder.BUILD.register(builder->{builder.registerPotionRecipe(ModPotions.ABLE_POTION, Items.GLOWSTONE_DUST, ModPotions.STRONG_ABLE_POTION);});
            }

            if(ModConfigs.SONAR_RECIPES_ENABLED) {
                FabricBrewingRecipeRegistryBuilder.BUILD.register(builder->{builder.registerPotionRecipe(Potions.AWKWARD, Items.PRISMARINE_CRYSTALS, ModPotions.SONAR_POTION);});
                FabricBrewingRecipeRegistryBuilder.BUILD.register(builder->{builder.registerPotionRecipe(ModPotions.SONAR_POTION, Items.REDSTONE, ModPotions.LONG_SONAR_POTION);});
            }

            if(ModConfigs.PERCEPTION_RECIPES_ENABLED) {
                FabricBrewingRecipeRegistryBuilder.BUILD.register(builder->{builder.registerPotionRecipe(Potions.THICK, Items.AMETHYST_SHARD, ModPotions.AMETHYSTPERCEPTION_POTION);});
                FabricBrewingRecipeRegistryBuilder.BUILD.register(builder->{builder.registerPotionRecipe(ModPotions.AMETHYSTPERCEPTION_POTION, Items.REDSTONE, ModPotions.LONG_AMETHYSTPERCEPTION_POTION);});
                FabricBrewingRecipeRegistryBuilder.BUILD.register(builder->{builder.registerPotionRecipe(ModPotions.AMETHYSTPERCEPTION_POTION, Items.GLOWSTONE_DUST, ModPotions.STRONG_AMETHYSTPERCEPTION_POTION);});

                FabricBrewingRecipeRegistryBuilder.BUILD.register(builder->{builder.registerPotionRecipe(Potions.THICK, Items.COAL, ModPotions.COALPERCEPTION_POTION);});
                FabricBrewingRecipeRegistryBuilder.BUILD.register(builder->{builder.registerPotionRecipe(ModPotions.COALPERCEPTION_POTION, Items.REDSTONE, ModPotions.LONG_COALPERCEPTION_POTION);});
                FabricBrewingRecipeRegistryBuilder.BUILD.register(builder->{builder.registerPotionRecipe(ModPotions.COALPERCEPTION_POTION, Items.GLOWSTONE_DUST, ModPotions.STRONG_COALPERCEPTION_POTION);});

                FabricBrewingRecipeRegistryBuilder.BUILD.register(builder->{builder.registerPotionRecipe(Potions.THICK, Items.RAW_COPPER, ModPotions.COPPERPERCEPTION_POTION);});
                FabricBrewingRecipeRegistryBuilder.BUILD.register(builder->{builder.registerPotionRecipe(ModPotions.COPPERPERCEPTION_POTION, Items.REDSTONE, ModPotions.LONG_COPPERPERCEPTION_POTION);});
                FabricBrewingRecipeRegistryBuilder.BUILD.register(builder->{builder.registerPotionRecipe(ModPotions.COPPERPERCEPTION_POTION, Items.GLOWSTONE_DUST, ModPotions.STRONG_COPPERPERCEPTION_POTION);});

                FabricBrewingRecipeRegistryBuilder.BUILD.register(builder->{builder.registerPotionRecipe(Potions.THICK, Items.DIAMOND, ModPotions.DIAMONDPERCEPTION_POTION);});
                FabricBrewingRecipeRegistryBuilder.BUILD.register(builder->{builder.registerPotionRecipe(ModPotions.DIAMONDPERCEPTION_POTION, Items.REDSTONE, ModPotions.LONG_DIAMONDPERCEPTION_POTION);});
                FabricBrewingRecipeRegistryBuilder.BUILD.register(builder->{builder.registerPotionRecipe(ModPotions.DIAMONDPERCEPTION_POTION, Items.GLOWSTONE_DUST, ModPotions.STRONG_DIAMONDPERCEPTION_POTION);});

                FabricBrewingRecipeRegistryBuilder.BUILD.register(builder->{builder.registerPotionRecipe(Potions.THICK, Items.EMERALD, ModPotions.EMERALDPERCEPTION_POTION);});
                FabricBrewingRecipeRegistryBuilder.BUILD.register(builder->{builder.registerPotionRecipe(ModPotions.EMERALDPERCEPTION_POTION, Items.REDSTONE, ModPotions.LONG_EMERALDPERCEPTION_POTION);});
                FabricBrewingRecipeRegistryBuilder.BUILD.register(builder->{builder.registerPotionRecipe(ModPotions.EMERALDPERCEPTION_POTION, Items.GLOWSTONE_DUST, ModPotions.STRONG_EMERALDPERCEPTION_POTION);});

                FabricBrewingRecipeRegistryBuilder.BUILD.register(builder->{builder.registerPotionRecipe(Potions.THICK, Items.RAW_GOLD, ModPotions.GOLDPERCEPTION_POTION);});
                FabricBrewingRecipeRegistryBuilder.BUILD.register(builder->{builder.registerPotionRecipe(ModPotions.GOLDPERCEPTION_POTION, Items.REDSTONE, ModPotions.LONG_GOLDPERCEPTION_POTION);});
                FabricBrewingRecipeRegistryBuilder.BUILD.register(builder->{builder.registerPotionRecipe(ModPotions.GOLDPERCEPTION_POTION, Items.GLOWSTONE_DUST, ModPotions.STRONG_GOLDPERCEPTION_POTION);});

                FabricBrewingRecipeRegistryBuilder.BUILD.register(builder->{builder.registerPotionRecipe(Potions.THICK, Items.RAW_IRON, ModPotions.IRONPERCEPTION_POTION);});
                FabricBrewingRecipeRegistryBuilder.BUILD.register(builder->{builder.registerPotionRecipe(ModPotions.IRONPERCEPTION_POTION, Items.REDSTONE, ModPotions.LONG_IRONPERCEPTION_POTION);});
                FabricBrewingRecipeRegistryBuilder.BUILD.register(builder->{builder.registerPotionRecipe(ModPotions.IRONPERCEPTION_POTION, Items.GLOWSTONE_DUST, ModPotions.STRONG_IRONPERCEPTION_POTION);});

                FabricBrewingRecipeRegistryBuilder.BUILD.register(builder->{builder.registerPotionRecipe(Potions.THICK, Items.LAPIS_LAZULI, ModPotions.LAPISPERCEPTION_POTION);});
                FabricBrewingRecipeRegistryBuilder.BUILD.register(builder->{builder.registerPotionRecipe(ModPotions.LAPISPERCEPTION_POTION, Items.REDSTONE, ModPotions.LONG_LAPISPERCEPTION_POTION);});
                FabricBrewingRecipeRegistryBuilder.BUILD.register(builder->{builder.registerPotionRecipe(ModPotions.LAPISPERCEPTION_POTION, Items.GLOWSTONE_DUST, ModPotions.STRONG_LAPISPERCEPTION_POTION);});

                FabricBrewingRecipeRegistryBuilder.BUILD.register(builder->{builder.registerPotionRecipe(Potions.THICK, Items.QUARTZ, ModPotions.MISCPERCEPTION_POTION);});
                FabricBrewingRecipeRegistryBuilder.BUILD.register(builder->{builder.registerPotionRecipe(ModPotions.MISCPERCEPTION_POTION, Items.REDSTONE, ModPotions.LONG_MISCPERCEPTION_POTION);});
                FabricBrewingRecipeRegistryBuilder.BUILD.register(builder->{builder.registerPotionRecipe(ModPotions.MISCPERCEPTION_POTION, Items.GLOWSTONE_DUST, ModPotions.STRONG_MISCPERCEPTION_POTION);});

                FabricBrewingRecipeRegistryBuilder.BUILD.register(builder->{builder.registerPotionRecipe(Potions.THICK, Items.NETHERITE_SCRAP, ModPotions.NETHERITEPERCEPTION_POTION);});
                FabricBrewingRecipeRegistryBuilder.BUILD.register(builder->{builder.registerPotionRecipe(ModPotions.NETHERITEPERCEPTION_POTION, Items.REDSTONE, ModPotions.LONG_NETHERITEPERCEPTION_POTION);});
                FabricBrewingRecipeRegistryBuilder.BUILD.register(builder->{builder.registerPotionRecipe(ModPotions.NETHERITEPERCEPTION_POTION, Items.GLOWSTONE_DUST, ModPotions.STRONG_NETHERITEPERCEPTION_POTION);});

                FabricBrewingRecipeRegistryBuilder.BUILD.register(builder->{builder.registerPotionRecipe(Potions.THICK, Items.REDSTONE, ModPotions.REDSTONEPERCEPTION_POTION);});
                FabricBrewingRecipeRegistryBuilder.BUILD.register(builder->{builder.registerPotionRecipe(ModPotions.REDSTONEPERCEPTION_POTION, Items.REDSTONE, ModPotions.LONG_REDSTONEPERCEPTION_POTION);});
                FabricBrewingRecipeRegistryBuilder.BUILD.register(builder->{builder.registerPotionRecipe(ModPotions.REDSTONEPERCEPTION_POTION, Items.GLOWSTONE_DUST, ModPotions.STRONG_REDSTONEPERCEPTION_POTION);});
            }
        }
    }
}
