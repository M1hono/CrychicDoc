package com.mna.entities.models.faction;

import com.mna.entities.faction.LanternWraith;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class LanternWraithModel extends GeoModel<LanternWraith> {

    private static final ResourceLocation modelFile = new ResourceLocation("mna", "geo/lantern_wraith.geo.json");

    private static final ResourceLocation animFile = new ResourceLocation("mna", "animations/lantern_wraith_anim.json");

    private static final ResourceLocation texFile_t1 = new ResourceLocation("mna", "textures/entity/lantern_wraith_t1.png");

    private static final ResourceLocation texFile_t2 = new ResourceLocation("mna", "textures/entity/lantern_wraith_t2.png");

    private static final ResourceLocation texFile_t3 = new ResourceLocation("mna", "textures/entity/lantern_wraith_t3.png");

    public ResourceLocation getAnimationResource(LanternWraith arg0) {
        return animFile;
    }

    public ResourceLocation getModelResource(LanternWraith arg0) {
        return modelFile;
    }

    public ResourceLocation getTextureResource(LanternWraith arg0) {
        switch(arg0.getTier()) {
            case 0:
                return texFile_t1;
            case 1:
                return texFile_t2;
            case 2:
                return texFile_t3;
            default:
                return texFile_t1;
        }
    }
}