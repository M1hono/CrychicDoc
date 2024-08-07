package net.liopyu.entityjs.client.nonliving;

import net.liopyu.entityjs.builders.nonliving.entityjs.ArrowEntityBuilder;
import net.liopyu.entityjs.entities.nonliving.entityjs.IArrowEntityJS;
import net.minecraft.client.renderer.entity.ArrowRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.projectile.AbstractArrow;

public class KubeJSArrowEntityRenderer<T extends AbstractArrow & IArrowEntityJS> extends ArrowRenderer<T> {

    private final ArrowEntityBuilder<T> builder;

    public KubeJSArrowEntityRenderer(EntityRendererProvider.Context renderManager, ArrowEntityBuilder<T> builder) {
        super(renderManager);
        this.builder = builder;
    }

    public ResourceLocation getTextureLocation(T entity) {
        return (ResourceLocation) this.builder.textureLocation.apply(entity);
    }
}