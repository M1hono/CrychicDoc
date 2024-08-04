package com.github.alexthe666.iceandfire.client.model;

import com.github.alexthe666.citadel.animation.IAnimatedEntity;
import com.github.alexthe666.citadel.client.model.AdvancedModelBox;
import com.github.alexthe666.citadel.client.model.ModelAnimator;
import com.github.alexthe666.citadel.client.model.basic.BasicModelPart;
import com.github.alexthe666.iceandfire.entity.EntityMyrmexQueen;
import com.google.common.collect.ImmutableList;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.Entity;

public class ModelMyrmexQueen extends ModelMyrmexBase {

    public AdvancedModelBox Body2;

    public AdvancedModelBox Body3;

    public AdvancedModelBox Body1;

    public AdvancedModelBox legTopR2;

    public AdvancedModelBox legTopR2_1;

    public AdvancedModelBox Body4;

    public AdvancedModelBox legTopR3;

    public AdvancedModelBox legTopR3_1;

    public AdvancedModelBox Body5;

    public AdvancedModelBox Tail1;

    public AdvancedModelBox Tail2;

    public AdvancedModelBox Tail3;

    public AdvancedModelBox Stinger;

    public AdvancedModelBox legMidR3;

    public AdvancedModelBox legBottomR3;

    public AdvancedModelBox legMidR3_1;

    public AdvancedModelBox legBottomR3_1;

    public AdvancedModelBox Neck1;

    public AdvancedModelBox legTopR1;

    public AdvancedModelBox legTopR1_1;

    public AdvancedModelBox HeadBase;

    public AdvancedModelBox EyeR;

    public AdvancedModelBox MandibleL;

    public AdvancedModelBox MandibleR;

    public AdvancedModelBox EyeL;

    public AdvancedModelBox crestbase;

    public AdvancedModelBox crest1;

    public AdvancedModelBox crest2;

    public AdvancedModelBox legMidR1;

    public AdvancedModelBox legBottomR1;

    public AdvancedModelBox legMidR1_1;

    public AdvancedModelBox legBottomR1_1;

    public AdvancedModelBox legMidR2;

    public AdvancedModelBox legBottomR2;

    public AdvancedModelBox legMidR2_1;

    public AdvancedModelBox legBottomR2_1;

    private final ModelAnimator animator;

    public ModelMyrmexQueen() {
        this.texWidth = 128;
        this.texHeight = 128;
        this.Tail3 = new AdvancedModelBox(this, 55, 12);
        this.Tail3.setPos(0.0F, 0.3F, 11.0F);
        this.Tail3.addBox(-4.0F, -2.7F, -0.1F, 8.0F, 8.0F, 11.0F, 0.0F);
        this.setRotateAngle(this.Tail3, -0.22759093F, 0.0F, 0.0F);
        this.crest1 = new AdvancedModelBox(this, 0, 88);
        this.crest1.mirror = true;
        this.crest1.setPos(-1.2F, -0.1F, -1.0F);
        this.crest1.addBox(-1.5F, -2.51F, -0.1F, 3.0F, 1.0F, 6.0F, 0.0F);
        this.setRotateAngle(this.crest1, 0.4098033F, (float) (-Math.PI / 18), -0.27925268F);
        this.legBottomR3_1 = new AdvancedModelBox(this, 22, 51);
        this.legBottomR3_1.mirror = true;
        this.legBottomR3_1.setPos(0.0F, 10.4F, 0.0F);
        this.legBottomR3_1.addBox(-1.01F, 0.0F, -0.9F, 2.0F, 13.0F, 2.0F, 0.0F);
        this.setRotateAngle(this.legBottomR3_1, 0.0F, 0.0F, 1.3203416F);
        this.Stinger = new AdvancedModelBox(this, 60, 0);
        this.Stinger.setPos(0.0F, 1.6F, 11.0F);
        this.Stinger.addBox(-1.0F, -2.7F, -1.7F, 2.0F, 8.0F, 2.0F, 0.0F);
        this.setRotateAngle(this.Stinger, 0.63739425F, 0.0F, 0.0F);
        this.Body1 = new AdvancedModelBox(this, 34, 47);
        this.Body1.setPos(0.0F, -0.7F, -1.0F);
        this.Body1.addBox(-3.5F, -2.1F, -6.3F, 7.0F, 8.0F, 9.0F, 0.0F);
        this.setRotateAngle(this.Body1, 0.045553092F, 0.0F, 0.0F);
        this.Body2 = new AdvancedModelBox(this, 70, 53);
        this.Body2.setPos(0.0F, 10.0F, -6.0F);
        this.Body2.addBox(-3.0F, -2.7F, -0.1F, 6.0F, 7.0F, 4.0F, 0.0F);
        this.setRotateAngle(this.Body2, -0.045553092F, 0.0F, 0.0F);
        this.legTopR2_1 = new AdvancedModelBox(this, 0, 54);
        this.legTopR2_1.mirror = true;
        this.legTopR2_1.setPos(-3.3F, 1.0F, 1.6F);
        this.legTopR2_1.addBox(-1.0F, 0.0F, -1.5F, 2.0F, 7.0F, 3.0F, 0.0F);
        this.setRotateAngle(this.legTopR2_1, 0.0F, 0.0F, (float) (Math.PI * 2.0 / 9.0));
        this.legBottomR1_1 = new AdvancedModelBox(this, 22, 51);
        this.legBottomR1_1.mirror = true;
        this.legBottomR1_1.setPos(0.0F, 10.4F, 0.0F);
        this.legBottomR1_1.addBox(-1.01F, 0.0F, -0.9F, 2.0F, 13.0F, 2.0F, 0.0F);
        this.setRotateAngle(this.legBottomR1_1, 0.0F, 0.0F, 1.3203416F);
        this.Tail2 = new AdvancedModelBox(this, 80, 76);
        this.Tail2.setPos(0.0F, 0.3F, 12.2F);
        this.Tail2.addBox(-5.0F, -2.7F, -0.1F, 10.0F, 10.0F, 13.0F, 0.0F);
        this.setRotateAngle(this.Tail2, -0.091106184F, 0.0F, 0.0F);
        this.legMidR1 = new AdvancedModelBox(this, 11, 50);
        this.legMidR1.setPos(0.0F, 6.4F, 0.1F);
        this.legMidR1.addBox(-1.5F, 0.0F, -1.0F, 3.0F, 12.0F, 2.0F, 0.0F);
        this.setRotateAngle(this.legMidR1, 0.0F, 0.0F, 1.1383038F);
        this.MandibleL = new AdvancedModelBox(this, 0, 25);
        this.MandibleL.setPos(3.4F, 3.7F, -7.7F);
        this.MandibleL.addBox(-2.0F, -2.51F, -5.1F, 4.0F, 2.0F, 6.0F, 0.0F);
        this.setRotateAngle(this.MandibleL, (float) (Math.PI / 18), 0.18203785F, 0.0F);
        this.legBottomR2 = new AdvancedModelBox(this, 22, 51);
        this.legBottomR2.mirror = true;
        this.legBottomR2.setPos(0.0F, 10.4F, 0.0F);
        this.legBottomR2.addBox(-1.01F, 0.0F, -0.9F, 2.0F, 13.0F, 2.0F, 0.0F);
        this.setRotateAngle(this.legBottomR2, 0.0F, 0.0F, 1.3203416F);
        this.legMidR3 = new AdvancedModelBox(this, 11, 50);
        this.legMidR3.setPos(0.0F, 6.4F, 0.1F);
        this.legMidR3.addBox(-1.5F, 0.0F, -1.0F, 3.0F, 12.0F, 2.0F, 0.0F);
        this.setRotateAngle(this.legMidR3, 0.0F, 0.0F, 1.1383038F);
        this.EyeL = new AdvancedModelBox(this, 40, 0);
        this.EyeL.setPos(4.0F, -0.3F, -3.5F);
        this.EyeL.addBox(-1.5F, -1.0F, -3.0F, 3.0F, 2.0F, 6.0F, 0.0F);
        this.setRotateAngle(this.EyeL, 0.2268928F, -0.08726646F, (float) (Math.PI / 2));
        this.Body4 = new AdvancedModelBox(this, 58, 35);
        this.Body4.setPos(0.0F, -0.4F, 7.3F);
        this.Body4.addBox(-3.0F, -2.7F, -1.5F, 6.0F, 7.0F, 4.0F, 0.0F);
        this.setRotateAngle(this.Body4, 0.13665928F, 0.0F, 0.0F);
        this.Neck1 = new AdvancedModelBox(this, 32, 22);
        this.Neck1.setPos(0.0F, 0.0F, -6.0F);
        this.Neck1.addBox(-2.5F, -2.0F, -3.5F, 5.0F, 5.0F, 4.0F, 0.0F);
        this.setRotateAngle(this.Neck1, -0.27314404F, 0.0F, 0.0F);
        this.legMidR2_1 = new AdvancedModelBox(this, 11, 50);
        this.legMidR2_1.setPos(0.0F, 6.4F, 0.1F);
        this.legMidR2_1.addBox(-1.5F, 0.0F, -1.0F, 3.0F, 12.0F, 2.0F, 0.0F);
        this.setRotateAngle(this.legMidR2_1, 0.0F, 0.0F, 1.1383038F);
        this.legTopR3 = new AdvancedModelBox(this, 0, 54);
        this.legTopR3.mirror = true;
        this.legTopR3.setPos(-3.3F, 1.0F, 1.6F);
        this.legTopR3.addBox(-1.0F, 0.0F, -1.5F, 2.0F, 7.0F, 3.0F, 0.0F);
        this.setRotateAngle(this.legTopR3, 0.5009095F, 0.22759093F, 0.7740535F);
        this.Tail1 = new AdvancedModelBox(this, 80, 51);
        this.Tail1.setPos(0.0F, -0.4F, 1.2F);
        this.Tail1.addBox(-5.5F, -2.7F, -0.1F, 11.0F, 11.0F, 13.0F, 0.0F);
        this.setRotateAngle(this.Tail1, -0.091106184F, 0.0F, 0.0F);
        this.Body5 = new AdvancedModelBox(this, 82, 35);
        this.Body5.setPos(0.0F, -0.4F, 4.2F);
        this.Body5.addBox(-3.5F, -2.5F, -2.1F, 7.0F, 8.0F, 6.0F, 0.0F);
        this.setRotateAngle(this.Body5, -0.045553092F, 0.0F, 0.0F);
        this.crest2 = new AdvancedModelBox(this, 0, 88);
        this.crest2.setPos(1.2F, -0.1F, -1.0F);
        this.crest2.addBox(-1.5F, -2.51F, -0.1F, 3.0F, 1.0F, 6.0F, 0.0F);
        this.setRotateAngle(this.crest2, 0.4098033F, (float) (Math.PI / 18), 0.27925268F);
        this.legTopR2 = new AdvancedModelBox(this, 0, 54);
        this.legTopR2.setPos(3.3F, 1.0F, 1.6F);
        this.legTopR2.addBox(-1.0F, 0.0F, -1.5F, 2.0F, 7.0F, 3.0F, 0.0F);
        this.setRotateAngle(this.legTopR2, 0.0F, 0.0F, (float) (-Math.PI * 2.0 / 9.0));
        this.Body3 = new AdvancedModelBox(this, 0, 67);
        this.Body3.setPos(0.0F, 0.2F, 4.1F);
        this.Body3.addBox(-4.5F, -3.4F, -1.4F, 9.0F, 9.0F, 9.0F, 0.0F);
        this.legMidR1_1 = new AdvancedModelBox(this, 11, 50);
        this.legMidR1_1.mirror = true;
        this.legMidR1_1.setPos(0.0F, 6.4F, 0.1F);
        this.legMidR1_1.addBox(-1.5F, 0.0F, -1.0F, 3.0F, 12.0F, 2.0F, 0.0F);
        this.setRotateAngle(this.legMidR1_1, 0.0F, 0.0F, -1.1383038F);
        this.HeadBase = new AdvancedModelBox(this, 0, 0);
        this.HeadBase.setPos(0.0F, -0.1F, -2.4F);
        this.HeadBase.addBox(-4.0F, -2.51F, -10.1F, 8.0F, 6.0F, 10.0F, 0.0F);
        this.setRotateAngle(this.HeadBase, 0.63739425F, 0.0F, 0.0F);
        this.crestbase = new AdvancedModelBox(this, 0, 100);
        this.crestbase.setPos(0.0F, -2.9F, 1.0F);
        this.crestbase.addBox(-3.5F, -2.51F, -6.1F, 7.0F, 2.0F, 6.0F, 0.0F);
        this.setRotateAngle(this.crestbase, 0.4553564F, 0.0F, 0.0F);
        this.legBottomR2_1 = new AdvancedModelBox(this, 22, 51);
        this.legBottomR2_1.setPos(0.0F, 10.4F, 0.0F);
        this.legBottomR2_1.addBox(-1.01F, 0.0F, -0.9F, 2.0F, 13.0F, 2.0F, 0.0F);
        this.setRotateAngle(this.legBottomR2_1, 0.0F, 0.0F, -1.3203416F);
        this.legTopR3_1 = new AdvancedModelBox(this, 0, 54);
        this.legTopR3_1.setPos(3.3F, 1.0F, 1.6F);
        this.legTopR3_1.addBox(-1.0F, 0.0F, -1.5F, 2.0F, 7.0F, 3.0F, 0.0F);
        this.setRotateAngle(this.legTopR3_1, 0.5009095F, -0.22759093F, -0.7740535F);
        this.legBottomR1 = new AdvancedModelBox(this, 22, 51);
        this.legBottomR1.setPos(0.0F, 10.4F, 0.0F);
        this.legBottomR1.addBox(-1.01F, 0.0F, -0.9F, 2.0F, 13.0F, 2.0F, 0.0F);
        this.setRotateAngle(this.legBottomR1, 0.0F, 0.0F, -1.3203416F);
        this.legBottomR3 = new AdvancedModelBox(this, 22, 51);
        this.legBottomR3.setPos(0.0F, 10.4F, 0.0F);
        this.legBottomR3.addBox(-1.01F, 0.0F, -0.9F, 2.0F, 13.0F, 2.0F, 0.0F);
        this.setRotateAngle(this.legBottomR3, 0.0F, 0.0F, -1.3203416F);
        this.EyeR = new AdvancedModelBox(this, 40, 0);
        this.EyeR.mirror = true;
        this.EyeR.setPos(-4.0F, -0.3F, -3.5F);
        this.EyeR.addBox(-1.5F, -1.0F, -3.0F, 3.0F, 2.0F, 6.0F, 0.0F);
        this.setRotateAngle(this.EyeR, 0.2268928F, 0.08726646F, (float) (-Math.PI / 2));
        this.legMidR2 = new AdvancedModelBox(this, 11, 50);
        this.legMidR2.mirror = true;
        this.legMidR2.setPos(0.0F, 6.4F, 0.1F);
        this.legMidR2.addBox(-1.5F, 0.0F, -1.0F, 3.0F, 12.0F, 2.0F, 0.0F);
        this.setRotateAngle(this.legMidR2, 0.0F, 0.0F, -1.1383038F);
        this.legTopR1_1 = new AdvancedModelBox(this, 0, 54);
        this.legTopR1_1.setPos(3.3F, 1.0F, -1.4F);
        this.legTopR1_1.addBox(-1.0F, 0.0F, -1.5F, 2.0F, 7.0F, 3.0F, 0.0F);
        this.setRotateAngle(this.legTopR1_1, -0.5009095F, 0.22759093F, (float) (-Math.PI * 2.0 / 9.0));
        this.legMidR3_1 = new AdvancedModelBox(this, 11, 50);
        this.legMidR3_1.mirror = true;
        this.legMidR3_1.setPos(0.0F, 6.4F, 0.1F);
        this.legMidR3_1.addBox(-1.5F, 0.0F, -1.0F, 3.0F, 12.0F, 2.0F, 0.0F);
        this.setRotateAngle(this.legMidR3_1, 0.0F, 0.0F, -1.1383038F);
        this.legTopR1 = new AdvancedModelBox(this, 0, 54);
        this.legTopR1.mirror = true;
        this.legTopR1.setPos(-3.3F, 1.0F, -1.4F);
        this.legTopR1.addBox(-1.0F, 0.0F, -1.5F, 2.0F, 7.0F, 3.0F, 0.0F);
        this.setRotateAngle(this.legTopR1, -0.5009095F, -0.22759093F, (float) (Math.PI * 2.0 / 9.0));
        this.MandibleR = new AdvancedModelBox(this, 0, 25);
        this.MandibleR.mirror = true;
        this.MandibleR.setPos(-3.4F, 3.7F, -7.7F);
        this.MandibleR.addBox(-2.0F, -2.51F, -5.1F, 4.0F, 2.0F, 6.0F, 0.0F);
        this.setRotateAngle(this.MandibleR, (float) (Math.PI / 18), -0.18203785F, 0.0F);
        this.Tail2.addChild(this.Tail3);
        this.crestbase.addChild(this.crest1);
        this.legMidR3_1.addChild(this.legBottomR3_1);
        this.Tail3.addChild(this.Stinger);
        this.Body2.addChild(this.Body1);
        this.Body2.addChild(this.legTopR2_1);
        this.legMidR1_1.addChild(this.legBottomR1_1);
        this.Tail1.addChild(this.Tail2);
        this.legTopR1.addChild(this.legMidR1);
        this.HeadBase.addChild(this.MandibleL);
        this.legMidR2.addChild(this.legBottomR2);
        this.legTopR3.addChild(this.legMidR3);
        this.HeadBase.addChild(this.EyeL);
        this.Body3.addChild(this.Body4);
        this.Body1.addChild(this.Neck1);
        this.legTopR2_1.addChild(this.legMidR2_1);
        this.Body3.addChild(this.legTopR3);
        this.Body5.addChild(this.Tail1);
        this.Body4.addChild(this.Body5);
        this.crestbase.addChild(this.crest2);
        this.Body2.addChild(this.legTopR2);
        this.Body2.addChild(this.Body3);
        this.legTopR1_1.addChild(this.legMidR1_1);
        this.Neck1.addChild(this.HeadBase);
        this.HeadBase.addChild(this.crestbase);
        this.legMidR2_1.addChild(this.legBottomR2_1);
        this.Body3.addChild(this.legTopR3_1);
        this.legMidR1.addChild(this.legBottomR1);
        this.legMidR3.addChild(this.legBottomR3);
        this.HeadBase.addChild(this.EyeR);
        this.legTopR2.addChild(this.legMidR2);
        this.Body1.addChild(this.legTopR1_1);
        this.legTopR3_1.addChild(this.legMidR3_1);
        this.Body1.addChild(this.legTopR1);
        this.HeadBase.addChild(this.MandibleR);
        this.animator = ModelAnimator.create();
        this.updateDefaultPose();
    }

    @Override
    public Iterable<BasicModelPart> parts() {
        return ImmutableList.of(this.Body2);
    }

    @Override
    public Iterable<AdvancedModelBox> getAllParts() {
        return ImmutableList.of(this.Body2, this.Body3, this.Body1, this.legTopR2, this.legTopR2_1, this.Body4, this.legTopR3, this.legTopR3_1, this.Body5, this.Tail1, this.Tail2, this.Tail3, new AdvancedModelBox[] { this.Stinger, this.legMidR3, this.legBottomR3, this.legMidR3_1, this.legBottomR3_1, this.Neck1, this.legTopR1, this.legTopR1_1, this.HeadBase, this.EyeR, this.MandibleL, this.MandibleR, this.EyeL, this.crestbase, this.crest1, this.crest2, this.legMidR1, this.legBottomR1, this.legMidR1_1, this.legBottomR1_1, this.legMidR2, this.legBottomR2, this.legMidR2_1, this.legBottomR2_1 });
    }

    public void animate(IAnimatedEntity entity, float f, float f1, float f2, float f3, float f4, float f5) {
        this.resetToDefaultPose();
        this.animator.update(entity);
        if (this.animator.setAnimation(EntityMyrmexQueen.ANIMATION_DIGNEST)) {
            this.animator.startKeyframe(15);
            ModelUtils.rotateFrom(this.animator, this.Body2, 26.0F, 0.0F, 0.0F);
            ModelUtils.rotateFrom(this.animator, this.Neck1, -5.0F, 0.0F, 0.0F);
            ModelUtils.rotateFrom(this.animator, this.Body4, -8.0F, 0.0F, 0.0F);
            ModelUtils.rotateFrom(this.animator, this.Body5, -2.0F, 0.0F, 0.0F);
            ModelUtils.rotateFrom(this.animator, this.Tail1, -13.0F, 0.0F, 0.0F);
            ModelUtils.rotateFrom(this.animator, this.Tail2, -18.0F, 0.0F, 0.0F);
            ModelUtils.rotateFrom(this.animator, this.Tail3, -13.0F, 0.0F, 0.0F);
            this.digPose();
            this.animator.endKeyframe();
            this.animator.startKeyframe(10);
            this.animator.move(this.Body2, 0.0F, 5.0F, 0.0F);
            ModelUtils.rotateFrom(this.animator, this.Body2, 45.0F, 0.0F, 0.0F);
            ModelUtils.rotateFrom(this.animator, this.Neck1, -5.0F, 0.0F, 0.0F);
            ModelUtils.rotateFrom(this.animator, this.Body4, -8.0F, 0.0F, 0.0F);
            ModelUtils.rotateFrom(this.animator, this.Body5, -2.0F, 0.0F, 0.0F);
            ModelUtils.rotateFrom(this.animator, this.Tail1, -13.0F, 0.0F, 0.0F);
            ModelUtils.rotateFrom(this.animator, this.Tail2, -18.0F, 0.0F, 0.0F);
            ModelUtils.rotateFrom(this.animator, this.Tail3, -13.0F, 0.0F, 0.0F);
            this.digPose();
            this.animator.endKeyframe();
            this.animator.startKeyframe(5);
            this.animator.move(this.Body2, 0.0F, 30.0F, 0.0F);
            ModelUtils.rotateFrom(this.animator, this.Body2, 78.0F, 0.0F, 0.0F);
            this.digPose();
            this.animator.endKeyframe();
            this.animator.startKeyframe(5);
            this.animator.move(this.Body2, 0.0F, 80.0F, 0.0F);
            ModelUtils.rotateFrom(this.animator, this.Body2, 90.0F, 0.0F, 0.0F);
            this.digPose();
            this.animator.endKeyframe();
            this.animator.startKeyframe(10);
            this.animator.move(this.Body2, 0.0F, 80.0F, 0.0F);
            ModelUtils.rotateFrom(this.animator, this.Body2, 90.0F, 0.0F, 0.0F);
            this.digPose();
            this.animator.endKeyframe();
            this.animator.resetKeyframe(5);
        }
        if (this.animator.setAnimation(EntityMyrmexQueen.ANIMATION_BITE)) {
            this.animator.startKeyframe(5);
            ModelUtils.rotate(this.animator, this.Neck1, -50.0F, 0.0F, 0.0F);
            ModelUtils.rotate(this.animator, this.HeadBase, 50.0F, 0.0F, 0.0F);
            ModelUtils.rotate(this.animator, this.MandibleR, 0.0F, 35.0F, 0.0F);
            ModelUtils.rotate(this.animator, this.MandibleL, 0.0F, -35.0F, 0.0F);
            this.animator.endKeyframe();
            this.animator.startKeyframe(5);
            ModelUtils.rotate(this.animator, this.Neck1, 30.0F, 0.0F, 0.0F);
            ModelUtils.rotate(this.animator, this.HeadBase, -30.0F, 0.0F, 0.0F);
            ModelUtils.rotate(this.animator, this.MandibleR, 0.0F, -50.0F, 0.0F);
            ModelUtils.rotate(this.animator, this.MandibleL, 0.0F, 50.0F, 0.0F);
            this.animator.endKeyframe();
            this.animator.resetKeyframe(5);
        }
        if (this.animator.setAnimation(EntityMyrmexQueen.ANIMATION_STING)) {
            this.animator.startKeyframe(5);
            this.animator.move(this.Body2, 0.0F, -10.0F, 0.0F);
            ModelUtils.rotate(this.animator, this.Body3, -35.0F, 0.0F, 0.0F);
            ModelUtils.rotate(this.animator, this.Body4, -49.0F, 0.0F, 0.0F);
            ModelUtils.rotate(this.animator, this.Body5, -25.0F, 0.0F, 0.0F);
            ModelUtils.rotate(this.animator, this.Tail1, -25.0F, 0.0F, 0.0F);
            ModelUtils.rotate(this.animator, this.Tail2, -40.0F, 0.0F, 0.0F);
            ModelUtils.rotate(this.animator, this.Tail3, -40.0F, 0.0F, 0.0F);
            ModelUtils.rotate(this.animator, this.Stinger, 90.0F, 0.0F, 0.0F);
            ModelUtils.rotateFrom(this.animator, this.legTopR3, 64.0F, -7.0F, 44.0F);
            ModelUtils.rotateFrom(this.animator, this.legTopR3_1, 64.0F, 7.0F, -44.0F);
            ModelUtils.rotateFrom(this.animator, this.legMidR3, 0.0F, 0.0F, 30.0F);
            ModelUtils.rotateFrom(this.animator, this.legMidR2, 0.0F, 0.0F, -25.0F);
            ModelUtils.rotateFrom(this.animator, this.legMidR1, 0.0F, 0.0F, 25.0F);
            ModelUtils.rotateFrom(this.animator, this.legMidR3_1, 0.0F, 0.0F, -30.0F);
            ModelUtils.rotateFrom(this.animator, this.legMidR2_1, 0.0F, 0.0F, 25.0F);
            ModelUtils.rotateFrom(this.animator, this.legMidR1_1, 0.0F, 0.0F, -25.0F);
            this.animator.endKeyframe();
            this.animator.resetKeyframe(10);
        }
        EntityMyrmexQueen myrmexQueen = (EntityMyrmexQueen) entity;
        if (myrmexQueen.getAnimation() == EntityMyrmexQueen.ANIMATION_EGG) {
            int animationTick = Mth.clamp(myrmexQueen.getAnimationTick(), 0, 20);
            float swellToPi = (float) ((double) ((float) animationTick / 20.0F) * Math.PI);
            this.increaseScale(this.Body5, 0.5F * Math.abs(Mth.sin(swellToPi + 0.5F)));
            this.increaseScale(this.Tail1, 0.75F * Math.abs(Mth.sin(swellToPi)));
            this.increaseScale(this.Tail2, 0.75F * Math.abs(Mth.sin(swellToPi - 0.5F)));
            this.increaseScale(this.Tail3, 0.75F * Math.abs(Mth.sin(swellToPi - 1.0F)));
            this.Stinger.rotationPointZ = this.Stinger.rotationPointZ + 10.0F * Math.abs(Mth.sin(swellToPi - 1.0F));
        }
    }

    @Override
    public void setupAnim(Entity entity, float f, float f1, float f2, float f3, float f4) {
        this.animate((IAnimatedEntity) entity, f, f1, f2, f3, f4, 1.0F);
        this.Body5.setScale(1.0F, 1.0F, 1.0F);
        this.Tail1.setScale(1.0F, 1.0F, 1.0F);
        this.Tail2.setScale(1.0F, 1.0F, 1.0F);
        this.Tail3.setScale(1.0F, 1.0F, 1.0F);
        AdvancedModelBox[] GASTER = new AdvancedModelBox[] { this.Body4, this.Body5, this.Tail1, this.Tail2, this.Tail3, this.Stinger };
        AdvancedModelBox[] NECK = new AdvancedModelBox[] { this.Neck1, this.HeadBase };
        AdvancedModelBox[] LEGR1 = new AdvancedModelBox[] { this.legTopR1, this.legMidR1, this.legBottomR1 };
        AdvancedModelBox[] LEGR2 = new AdvancedModelBox[] { this.legTopR2, this.legMidR2, this.legBottomR2 };
        AdvancedModelBox[] LEGR3 = new AdvancedModelBox[] { this.legTopR3, this.legMidR3, this.legBottomR3 };
        AdvancedModelBox[] LEGL1 = new AdvancedModelBox[] { this.legTopR1_1, this.legMidR1_1, this.legBottomR1_1 };
        AdvancedModelBox[] LEGL2 = new AdvancedModelBox[] { this.legTopR2_1, this.legMidR2_1, this.legBottomR2_1 };
        AdvancedModelBox[] LEGL3 = new AdvancedModelBox[] { this.legTopR3_1, this.legMidR3_1, this.legBottomR3_1 };
        float speed_walk = 1.8F;
        float speed_idle = 0.05F;
        float degree_walk = 0.7F;
        float degree_idle = 0.15F;
        float gasterSwell1 = -0.05F + 0.2F * Math.abs(Mth.sin((float) entity.tickCount * 0.15F + 1.0F));
        float gasterSwell2 = -0.05F + 0.2F * Math.abs(Mth.sin((float) entity.tickCount * 0.15F + 0.5F));
        float gasterSwell3 = -0.05F + 0.2F * Math.abs(Mth.sin((float) entity.tickCount * 0.15F));
        EntityMyrmexQueen myrmexQueen = (EntityMyrmexQueen) entity;
        if (myrmexQueen.getAnimation() != EntityMyrmexQueen.ANIMATION_EGG) {
            this.increaseScale(this.Tail1, gasterSwell1);
            this.increaseScale(this.Tail2, gasterSwell2);
            this.increaseScale(this.Tail3, gasterSwell3);
            this.Stinger.rotationPointZ += 20.0F * gasterSwell3;
        }
        if (myrmexQueen.getAnimation() == EntityMyrmexQueen.ANIMATION_DIGNEST) {
            this.animateLeg(LEGR1, speed_walk * 0.5F, degree_walk * 0.5F, false, 0.0F, 1.0F, f2, 1.0F);
            this.animateLeg(LEGR3, speed_walk * 0.5F, degree_walk * 0.5F, false, 0.0F, 1.0F, f2, 1.0F);
            this.animateLeg(LEGR2, speed_walk * 0.5F, degree_walk * 0.5F, true, 0.0F, 1.0F, f2, 1.0F);
            this.animateLeg(LEGL1, speed_walk * 0.5F, degree_walk * 0.5F, false, 1.0F, -1.0F, f2, 1.0F);
            this.animateLeg(LEGL3, speed_walk * 0.5F, degree_walk * 0.5F, false, 1.0F, -1.0F, f2, 1.0F);
            this.animateLeg(LEGL2, speed_walk * 0.5F, degree_walk * 0.5F, true, 1.0F, -1.0F, f2, 1.0F);
        }
        if (entity.getPassengers().isEmpty()) {
            this.faceTarget(f3, f4, 2.0F, NECK);
        }
        this.chainWave(GASTER, speed_idle, degree_idle * 0.15F, 0.0, f2, 1.0F);
        this.chainWave(NECK, speed_idle, degree_idle * -0.15F, 2.0, f2, 1.0F);
        this.swing(this.MandibleR, speed_idle * 2.0F, degree_idle * -0.75F, false, 1.0F, 0.2F, f2, 1.0F);
        this.swing(this.MandibleL, speed_idle * 2.0F, degree_idle * -0.75F, true, 1.0F, 0.2F, f2, 1.0F);
        this.animateLeg(LEGR1, speed_walk, degree_walk, false, 0.0F, 1.0F, f, f1);
        this.animateLeg(LEGR3, speed_walk, degree_walk, false, 0.0F, 1.0F, f, f1);
        this.animateLeg(LEGR2, speed_walk, degree_walk, true, 0.0F, 1.0F, f, f1);
        this.animateLeg(LEGL1, speed_walk, degree_walk, false, 1.0F, -1.0F, f, f1);
        this.animateLeg(LEGL3, speed_walk, degree_walk, false, 1.0F, -1.0F, f, f1);
        this.animateLeg(LEGL2, speed_walk, degree_walk, true, 1.0F, -1.0F, f, f1);
    }

    private void animateLeg(AdvancedModelBox[] models, float speed, float degree, boolean reverse, float offset, float weight, float f, float f1) {
        this.flap(models[0], speed, degree * 0.4F, reverse, offset, weight * 0.2F, f, f1);
        this.flap(models[1], speed, degree * 2.0F, reverse, offset, weight * -0.4F, f, f1);
        this.flap(models[1], speed, -degree * 1.2F, reverse, offset, weight * 0.5F, f, f1);
        this.walk(models[0], speed, degree, reverse, offset, 0.0F, f, f1);
    }

    public void increaseScale(AdvancedModelBox box, float scale) {
        box.scaleX += scale;
        box.scaleY += scale;
        box.scaleZ += scale;
    }

    public AdvancedModelBox[] getHeadParts() {
        return new AdvancedModelBox[] { this.Neck1, this.HeadBase };
    }

    @Override
    public void renderStatue(PoseStack matrixStackIn, VertexConsumer bufferIn, int packedLightIn, Entity living) {
        this.m_7695_(matrixStackIn, bufferIn, packedLightIn, OverlayTexture.NO_OVERLAY, 1.0F, 1.0F, 1.0F, 1.0F);
        this.Body5.setScale(1.0F, 1.0F, 1.0F);
        this.Tail1.setScale(1.0F, 1.0F, 1.0F);
        this.Tail2.setScale(1.0F, 1.0F, 1.0F);
        this.Tail3.setScale(1.0F, 1.0F, 1.0F);
    }

    private void digPose() {
        ModelUtils.rotateFrom(this.animator, this.legTopR1, -28.0F, -13.0F, 36.0F);
        ModelUtils.rotateFrom(this.animator, this.legTopR2, -7.0F, 15.0F, -24.0F);
        ModelUtils.rotateFrom(this.animator, this.legTopR3, -2.0F, 31.0F, 13.0F);
        ModelUtils.rotateFrom(this.animator, this.legMidR1, 0.0F, 0.0F, 80.0F);
        ModelUtils.rotateFrom(this.animator, this.legMidR2, 0.0F, 0.0F, -83.0F);
        ModelUtils.rotateFrom(this.animator, this.legMidR3, 0.0F, 0.0F, 65.0F);
        ModelUtils.rotateFrom(this.animator, this.legBottomR1, 0.0F, 0.0F, -75.0F);
        ModelUtils.rotateFrom(this.animator, this.legBottomR2, 0.0F, 0.0F, 75.0F);
        ModelUtils.rotateFrom(this.animator, this.legBottomR3, 0.0F, 0.0F, -54.0F);
        ModelUtils.rotateFrom(this.animator, this.legTopR1_1, -28.0F, 13.0F, -36.0F);
        ModelUtils.rotateFrom(this.animator, this.legTopR2_1, -7.0F, -15.0F, 24.0F);
        ModelUtils.rotateFrom(this.animator, this.legTopR3_1, -2.0F, -31.0F, -13.0F);
        ModelUtils.rotateFrom(this.animator, this.legMidR1_1, 0.0F, 0.0F, -80.0F);
        ModelUtils.rotateFrom(this.animator, this.legMidR2_1, 0.0F, 0.0F, 83.0F);
        ModelUtils.rotateFrom(this.animator, this.legMidR3_1, 0.0F, 0.0F, -65.0F);
        ModelUtils.rotateFrom(this.animator, this.legBottomR1_1, 0.0F, 0.0F, 75.0F);
        ModelUtils.rotateFrom(this.animator, this.legBottomR2_1, 0.0F, 0.0F, -75.0F);
        ModelUtils.rotateFrom(this.animator, this.legBottomR3_1, 0.0F, 0.0F, 54.0F);
    }
}