package com.github.alexthe666.alexsmobs.client.particle;

import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.particle.Particle;
import net.minecraft.client.particle.ParticleProvider;
import net.minecraft.client.particle.ParticleRenderType;
import net.minecraft.client.particle.SpriteSet;
import net.minecraft.client.particle.TextureSheetParticle;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class ParticleGusterSandShot extends TextureSheetParticle {

    private ParticleGusterSandShot(ClientLevel world, double x, double y, double z, double motionX, double motionY, double motionZ, int variant) {
        super(world, x, y, z);
        int color = ParticleGusterSandSpin.selectColor(variant, this.f_107223_);
        float lvt_18_1_ = (float) (color >> 16 & 0xFF) / 255.0F;
        float lvt_19_1_ = (float) (color >> 8 & 0xFF) / 255.0F;
        float lvt_20_1_ = (float) (color & 0xFF) / 255.0F;
        this.m_107253_(lvt_18_1_, lvt_19_1_, lvt_20_1_);
        this.f_107215_ = (double) ((float) motionX);
        this.f_107216_ = (double) ((float) motionY);
        this.f_107217_ = (double) ((float) motionZ);
        this.f_107663_ = this.f_107663_ * (0.6F + this.f_107223_.nextFloat() * 1.4F);
        this.f_107225_ = 10 + this.f_107223_.nextInt(15);
        this.f_107226_ = 0.5F;
    }

    @Override
    public void tick() {
        super.m_5989_();
        this.f_107216_ = this.f_107216_ - (0.004 + 0.04 * (double) this.f_107226_);
    }

    @Override
    public ParticleRenderType getRenderType() {
        return ParticleRenderType.PARTICLE_SHEET_OPAQUE;
    }

    @OnlyIn(Dist.CLIENT)
    public static class Factory implements ParticleProvider<SimpleParticleType> {

        private final SpriteSet spriteSet;

        public Factory(SpriteSet spriteSet) {
            this.spriteSet = spriteSet;
        }

        public Particle createParticle(SimpleParticleType typeIn, ClientLevel worldIn, double x, double y, double z, double xSpeed, double ySpeed, double zSpeed) {
            ParticleGusterSandShot p = new ParticleGusterSandShot(worldIn, x, y, z, xSpeed, ySpeed, zSpeed, 0);
            p.m_108335_(this.spriteSet);
            return p;
        }
    }

    @OnlyIn(Dist.CLIENT)
    public static class FactoryRed implements ParticleProvider<SimpleParticleType> {

        private final SpriteSet spriteSet;

        public FactoryRed(SpriteSet spriteSet) {
            this.spriteSet = spriteSet;
        }

        public Particle createParticle(SimpleParticleType typeIn, ClientLevel worldIn, double x, double y, double z, double xSpeed, double ySpeed, double zSpeed) {
            ParticleGusterSandShot p = new ParticleGusterSandShot(worldIn, x, y, z, xSpeed, ySpeed, zSpeed, 1);
            p.m_108335_(this.spriteSet);
            return p;
        }
    }

    @OnlyIn(Dist.CLIENT)
    public static class FactorySoul implements ParticleProvider<SimpleParticleType> {

        private final SpriteSet spriteSet;

        public FactorySoul(SpriteSet spriteSet) {
            this.spriteSet = spriteSet;
        }

        public Particle createParticle(SimpleParticleType typeIn, ClientLevel worldIn, double x, double y, double z, double xSpeed, double ySpeed, double zSpeed) {
            ParticleGusterSandShot p = new ParticleGusterSandShot(worldIn, x, y, z, xSpeed, ySpeed, zSpeed, 2);
            p.m_108335_(this.spriteSet);
            return p;
        }
    }
}