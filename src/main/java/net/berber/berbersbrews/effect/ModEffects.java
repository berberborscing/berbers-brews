package net.berber.berbersbrews.effect;

import net.berber.berbersbrews.BerbersBrews;
import net.berber.berbersbrews.effect.perception.*;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.Identifier;

public class ModEffects {
    public static RegistryEntry<StatusEffect> TELEPORT;
    public static RegistryEntry<StatusEffect> RECALL;
    public static RegistryEntry<StatusEffect> SILENCE;
    public static RegistryEntry<StatusEffect> PRIVY;
    public static RegistryEntry<StatusEffect> REACH;
    public static RegistryEntry<StatusEffect> ABLE;
    public static RegistryEntry<StatusEffect> RETURN;

    //Perception effects
    public static RegistryEntry<StatusEffect> AMETHYSTPERCEPTION;
    public static RegistryEntry<StatusEffect> COPPERPERCEPTION;
    public static RegistryEntry<StatusEffect> COALPERCEPTION;
    public static RegistryEntry<StatusEffect> REDSTONEPERCEPTION;
    public static RegistryEntry<StatusEffect> MISCPERCEPTION;
    public static RegistryEntry<StatusEffect> IRONPERCEPTION;
    public static RegistryEntry<StatusEffect> LAPISPERCEPTION;
    public static RegistryEntry<StatusEffect> GOLDPERCEPTION;
    public static RegistryEntry<StatusEffect> EMERALDPERCEPTION;
    public static RegistryEntry<StatusEffect> DIAMONDPERCEPTION;
    public static RegistryEntry<StatusEffect> NETHERITEPERCEPTION;

    public static void registerEffects() {
        TELEPORT = Registry.registerReference(Registries.STATUS_EFFECT, Identifier.of(BerbersBrews.MOD_ID, "teleport"),
                new TeleportEffect(StatusEffectCategory.NEUTRAL, 9830550));
        RECALL = Registry.registerReference(Registries.STATUS_EFFECT, Identifier.of(BerbersBrews.MOD_ID, "recall"),
                new RecallEffect(StatusEffectCategory.BENEFICIAL, 13158600));
        SILENCE = Registry.registerReference(Registries.STATUS_EFFECT, Identifier.of(BerbersBrews.MOD_ID, "silence"),
                new SilenceEffect(StatusEffectCategory.BENEFICIAL, 25720));
        PRIVY = Registry.registerReference(Registries.STATUS_EFFECT, Identifier.of(BerbersBrews.MOD_ID, "privy"),
                new PrivyEffect(StatusEffectCategory.BENEFICIAL, 16425120));
        REACH = Registry.registerReference(Registries.STATUS_EFFECT, Identifier.of(BerbersBrews.MOD_ID, "reach"),
                new ReachEffect(StatusEffectCategory.BENEFICIAL, 6579255)
                        .addAttributeModifier(EntityAttributes.PLAYER_BLOCK_INTERACTION_RANGE, Identifier.ofVanilla("block_reach"), 0.5f, EntityAttributeModifier.Operation.ADD_MULTIPLIED_BASE)
                        .addAttributeModifier(EntityAttributes.PLAYER_ENTITY_INTERACTION_RANGE, Identifier.ofVanilla("entity_reach"), 0.5f, EntityAttributeModifier.Operation.ADD_MULTIPLIED_BASE));
        ABLE = Registry.registerReference(Registries.STATUS_EFFECT, Identifier.of(BerbersBrews.MOD_ID, "able"),
                new AbleEffect(StatusEffectCategory.BENEFICIAL, 3669815)
                        .addAttributeModifier(EntityAttributes.GENERIC_STEP_HEIGHT, Identifier.ofVanilla("able"), 2f, EntityAttributeModifier.Operation.ADD_MULTIPLIED_BASE));
        RETURN = Registry.registerReference(Registries.STATUS_EFFECT, Identifier.of(BerbersBrews.MOD_ID, "return"),
                new ReturnEffect(StatusEffectCategory.NEUTRAL, 16777130));

        AMETHYSTPERCEPTION = Registry.registerReference(Registries.STATUS_EFFECT, Identifier.of(BerbersBrews.MOD_ID, "amethystperception"),
                new AmethystPerceptionEffect(StatusEffectCategory.BENEFICIAL, 11767539));
        COPPERPERCEPTION = Registry.registerReference(Registries.STATUS_EFFECT, Identifier.of(BerbersBrews.MOD_ID, "copperperception"),
                new CopperPerceptionEffect(StatusEffectCategory.BENEFICIAL, 15301202));
        COALPERCEPTION = Registry.registerReference(Registries.STATUS_EFFECT, Identifier.of(BerbersBrews.MOD_ID, "coalperception"),
                new CoalPerceptionEffect(StatusEffectCategory.BENEFICIAL, 3289650));
        REDSTONEPERCEPTION = Registry.registerReference(Registries.STATUS_EFFECT, Identifier.of(BerbersBrews.MOD_ID, "redstoneperception"),
                new RedstonePerceptionEffect(StatusEffectCategory.BENEFICIAL, 16711680));
        MISCPERCEPTION = Registry.registerReference(Registries.STATUS_EFFECT, Identifier.of(BerbersBrews.MOD_ID, "miscperception"),
                new MiscPerceptionEffect(StatusEffectCategory.BENEFICIAL, 15065046));
        IRONPERCEPTION = Registry.registerReference(Registries.STATUS_EFFECT, Identifier.of(BerbersBrews.MOD_ID, "ironperception"),
                new IronPerceptionEffect(StatusEffectCategory.BENEFICIAL, 16703176));
        LAPISPERCEPTION = Registry.registerReference(Registries.STATUS_EFFECT, Identifier.of(BerbersBrews.MOD_ID, "lapisperception"),
                new LapisPerceptionEffect(StatusEffectCategory.BENEFICIAL, 5931746));
        GOLDPERCEPTION = Registry.registerReference(Registries.STATUS_EFFECT, Identifier.of(BerbersBrews.MOD_ID, "goldperception"),
                new GoldPerceptionEffect(StatusEffectCategory.BENEFICIAL, 16443950));
        EMERALDPERCEPTION = Registry.registerReference(Registries.STATUS_EFFECT, Identifier.of(BerbersBrews.MOD_ID, "emeraldperception"),
                new EmeraldPerceptionEffect(StatusEffectCategory.BENEFICIAL, 4322180));
        DIAMONDPERCEPTION = Registry.registerReference(Registries.STATUS_EFFECT, Identifier.of(BerbersBrews.MOD_ID, "diamondperception"),
                new DiamondPerceptionEffect(StatusEffectCategory.BENEFICIAL, 4910553));
        NETHERITEPERCEPTION = Registry.registerReference(Registries.STATUS_EFFECT, Identifier.of(BerbersBrews.MOD_ID, "netheriteperception"),
                new NetheritePerceptionEffect(StatusEffectCategory.BENEFICIAL, 6637376));
    }
}
