package net.berber.berbersbrews.effect;

import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;

public class SilenceEffect extends StatusEffect {
    public SilenceEffect(StatusEffectCategory statusEffectCategory, int color) {
        super(statusEffectCategory, color);
    }

    //All of the code of this effect is in EntityMixin.
}
