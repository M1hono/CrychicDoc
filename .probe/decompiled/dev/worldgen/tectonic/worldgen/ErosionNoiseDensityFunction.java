package dev.worldgen.tectonic.worldgen;

import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import dev.worldgen.tectonic.config.ConfigHandler;
import net.minecraft.util.KeyDispatchDataCodec;
import net.minecraft.world.level.levelgen.DensityFunction;
import org.jetbrains.annotations.NotNull;

public record ErosionNoiseDensityFunction(DensityFunction.NoiseHolder noise, DensityFunction shiftX, DensityFunction shiftZ) implements DensityFunction {

    public static MapCodec<ErosionNoiseDensityFunction> DATA_CODEC = RecordCodecBuilder.mapCodec(instance -> instance.group(DensityFunction.NoiseHolder.CODEC.fieldOf("noise").forGetter(ErosionNoiseDensityFunction::noise), DensityFunction.HOLDER_HELPER_CODEC.fieldOf("shift_x").forGetter(ErosionNoiseDensityFunction::shiftX), DensityFunction.HOLDER_HELPER_CODEC.fieldOf("shift_z").forGetter(ErosionNoiseDensityFunction::shiftZ)).apply(instance, ErosionNoiseDensityFunction::new));

    public static KeyDispatchDataCodec<ErosionNoiseDensityFunction> CODEC_HOLDER = KeyDispatchDataCodec.of(DATA_CODEC);

    @Override
    public double compute(@NotNull DensityFunction.FunctionContext context) {
        double xzScale = ConfigHandler.getConfig().getValue("horizontal_mountain_scale");
        return this.noise.getValue((double) context.blockX() * xzScale + this.shiftX().compute(context), 0.0, (double) context.blockZ() * xzScale + this.shiftZ().compute(context));
    }

    @Override
    public void fillArray(@NotNull double[] doubles, DensityFunction.ContextProvider contextProvider) {
        contextProvider.fillAllDirectly(doubles, this);
    }

    @NotNull
    @Override
    public DensityFunction mapAll(DensityFunction.Visitor visitor) {
        return visitor.apply(new ErosionNoiseDensityFunction(visitor.visitNoise(this.noise), this.shiftX, this.shiftZ));
    }

    @Override
    public double minValue() {
        return -this.maxValue();
    }

    @Override
    public double maxValue() {
        return this.noise.maxValue();
    }

    @NotNull
    @Override
    public KeyDispatchDataCodec<? extends DensityFunction> codec() {
        return CODEC_HOLDER;
    }
}