package net.liopyu.entityjs.builders.living.entityjs;

import net.liopyu.entityjs.entities.living.entityjs.AnimalEntityJS;
import net.liopyu.entityjs.entities.living.entityjs.MobEntityJS;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;

public class AnimalEntityJSBuilder extends AnimalEntityBuilder<AnimalEntityJS> {

    public AnimalEntityJSBuilder(ResourceLocation i) {
        super(i);
    }

    @Override
    public EntityType.EntityFactory<AnimalEntityJS> factory() {
        return (type, level) -> new AnimalEntityJS(this, type, level);
    }

    @Override
    public AttributeSupplier.Builder getAttributeBuilder() {
        return MobEntityJS.m_21552_().add(Attributes.MAX_HEALTH).add(Attributes.FOLLOW_RANGE).add(Attributes.ATTACK_DAMAGE).add(Attributes.ARMOR).add(Attributes.ARMOR_TOUGHNESS).add(Attributes.ATTACK_SPEED).add(Attributes.ATTACK_KNOCKBACK).add(Attributes.LUCK).add(Attributes.MOVEMENT_SPEED);
    }
}