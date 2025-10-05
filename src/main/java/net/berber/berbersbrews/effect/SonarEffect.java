package net.berber.berbersbrews.effect;

import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;

public class SonarEffect extends StatusEffect {
    public SonarEffect(StatusEffectCategory statusEffectCategory, int color) {
        super(statusEffectCategory, color);
    }

    //All of the code of this effect is in FishingMixin.
}
