package me.jellysquid.mods.sodium.mixin.features.render.gui.font;

import java.util.function.IntFunction;
import net.minecraft.client.gui.font.CodepointMap;
import net.minecraft.client.gui.font.FontSet;
import net.minecraft.client.gui.font.glyphs.BakedGlyph;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(value = { FontSet.class }, priority = 500)
public abstract class FontSetMixin {

    @Shadow
    protected abstract FontSet.GlyphInfoFilter computeGlyphInfo(int var1);

    @Shadow
    protected abstract BakedGlyph computeBakedGlyph(int var1);

    @Redirect(method = { "getGlyphInfo" }, at = @At(value = "INVOKE", target = "Lnet/minecraft/client/gui/font/CodepointMap;computeIfAbsent(ILjava/util/function/IntFunction;)Ljava/lang/Object;"))
    private Object getGlyphInfoFast(CodepointMap<FontSet.GlyphInfoFilter> instance, int i, IntFunction<FontSet.GlyphInfoFilter> methodRef) {
        FontSet.GlyphInfoFilter info = instance.get(i);
        if (info == null) {
            info = this.computeGlyphInfo(i);
            instance.put(i, info);
        }
        return info;
    }

    @Redirect(method = { "getGlyph" }, at = @At(value = "INVOKE", target = "Lnet/minecraft/client/gui/font/CodepointMap;computeIfAbsent(ILjava/util/function/IntFunction;)Ljava/lang/Object;"))
    private Object getGlyphFast(CodepointMap<BakedGlyph> instance, int i, IntFunction<BakedGlyph> methodRef) {
        BakedGlyph glyph = instance.get(i);
        if (glyph == null) {
            glyph = this.computeBakedGlyph(i);
            instance.put(i, glyph);
        }
        return glyph;
    }
}