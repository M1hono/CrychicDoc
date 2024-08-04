package io.redspace.ironsspellbooks.mixin;

import io.redspace.ironsspellbooks.config.ClientConfigs;
import io.redspace.ironsspellbooks.gui.overlays.ManaBarOverlay;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.GuiGraphics;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin({ Gui.class })
public class GuiMixin {

    @Inject(method = { "renderExperienceBar" }, at = { @At("HEAD") }, cancellable = true)
    public void renderExperienceBar(GuiGraphics guiGraphics, int pXPos, CallbackInfo ci) {
        if (ClientConfigs.MANA_BAR_ANCHOR.get() == ManaBarOverlay.Anchor.XP && Minecraft.getInstance().player != null && ManaBarOverlay.shouldShowManaBar(Minecraft.getInstance().player)) {
            ci.cancel();
        }
    }
}