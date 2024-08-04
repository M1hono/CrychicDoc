package me.jellysquid.mods.lithium.mixin.math.sine_lut;

import me.jellysquid.mods.lithium.common.util.math.CompactSineLUT;
import net.minecraft.util.Mth;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;

@Mixin({ Mth.class })
public class MixinMathHelper {

    @Overwrite
    public static float sin(float f) {
        return CompactSineLUT.sin(f);
    }

    @Overwrite
    public static float cos(float f) {
        return CompactSineLUT.cos(f);
    }
}