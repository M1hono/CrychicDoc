package vectorwing.farmersdelight.client.model;

import com.mojang.blaze3d.vertex.PoseStack;
import java.util.List;
import net.minecraft.client.resources.model.BakedModel;
import net.minecraft.world.item.ItemDisplayContext;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.client.model.BakedModelWrapper;

public class WrappedItemModel<T extends BakedModel> extends BakedModelWrapper<T> {

    private final List<BakedModel> renderPasses = List.of(this);

    public WrappedItemModel(T originalModel) {
        super(originalModel);
    }

    @Override
    public boolean isCustomRenderer() {
        return true;
    }

    @Override
    public BakedModel applyTransform(ItemDisplayContext cameraTransformType, PoseStack poseStack, boolean applyLeftHandTransform) {
        BakedModel model = super.applyTransform(cameraTransformType, poseStack, applyLeftHandTransform);
        return !model.equals(this) && !(model instanceof WrappedItemModel) ? new WrappedItemModel<>(model) : this;
    }

    @Override
    public List<BakedModel> getRenderPasses(ItemStack itemStack, boolean fabulous) {
        return this.renderPasses;
    }
}