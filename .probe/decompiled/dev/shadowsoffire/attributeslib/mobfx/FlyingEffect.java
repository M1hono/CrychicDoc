package dev.shadowsoffire.attributeslib.mobfx;

import dev.shadowsoffire.attributeslib.api.ALObjects;
import net.minecraft.ChatFormatting;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;

public class FlyingEffect extends MobEffect {

    public FlyingEffect() {
        super(MobEffectCategory.BENEFICIAL, ChatFormatting.RED.getColor());
        this.m_19472_(ALObjects.Attributes.CREATIVE_FLIGHT.get(), "ea575584-4ff4-4c96-a1a3-f2024d9fd898", 1.0, AttributeModifier.Operation.ADDITION);
    }

    @Override
    public double getAttributeModifierValue(int pAmplifier, AttributeModifier pModifier) {
        return 1.0;
    }
}