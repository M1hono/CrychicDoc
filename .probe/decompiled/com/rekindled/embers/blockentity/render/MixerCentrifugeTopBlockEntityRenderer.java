package com.rekindled.embers.blockentity.render;

import com.mojang.blaze3d.vertex.PoseStack;
import com.rekindled.embers.blockentity.MixerCentrifugeTopBlockEntity;
import com.rekindled.embers.render.FluidCuboid;
import com.rekindled.embers.render.FluidRenderer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraftforge.fluids.FluidStack;
import org.joml.Vector3f;

public class MixerCentrifugeTopBlockEntityRenderer implements BlockEntityRenderer<MixerCentrifugeTopBlockEntity> {

    FluidCuboid cube = new FluidCuboid(new Vector3f(3.0F, 2.0F, 3.0F), new Vector3f(13.0F, 5.0F, 13.0F), FluidCuboid.DEFAULT_FACES);

    public MixerCentrifugeTopBlockEntityRenderer(BlockEntityRendererProvider.Context pContext) {
    }

    public void render(MixerCentrifugeTopBlockEntity blockEntity, float partialTick, PoseStack poseStack, MultiBufferSource bufferSource, int packedLight, int packedOverlay) {
        if (blockEntity != null) {
            FluidStack fluidStack = blockEntity.getFluidStack();
            int capacity = blockEntity.getCapacity();
            if (!fluidStack.isEmpty() && capacity > 0) {
                float offset = blockEntity.renderOffset;
                if (!(offset > 1.2F) && !(offset < -1.2F)) {
                    blockEntity.renderOffset = 0.0F;
                } else {
                    offset -= (offset / 12.0F + 0.1F) * partialTick;
                    blockEntity.renderOffset = offset;
                }
                FluidRenderer.renderScaledCuboid(poseStack, bufferSource, this.cube, fluidStack, offset, capacity, packedLight, packedOverlay, false);
            } else {
                blockEntity.renderOffset = 0.0F;
            }
        }
    }
}