package com.almostreliable.lootjs.forge.mixin;

import com.almostreliable.lootjs.LootJS;
import com.almostreliable.lootjs.LootModificationsAPI;
import com.almostreliable.lootjs.core.ILootContextData;
import com.almostreliable.lootjs.core.LootJSParamSets;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraftforge.common.ForgeHooks;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin({ ForgeHooks.class })
public class ForgeHooksMixin {

    @Inject(method = { "modifyLoot(Lnet/minecraft/resources/ResourceLocation;Lit/unimi/dsi/fastutil/objects/ObjectArrayList;Lnet/minecraft/world/level/storage/loot/LootContext;)Lit/unimi/dsi/fastutil/objects/ObjectArrayList;" }, at = { @At("RETURN") }, remap = false)
    private static void invokeActions(ResourceLocation lootTableID, ObjectArrayList<ItemStack> loot, LootContext context, CallbackInfoReturnable<ObjectArrayList<ItemStack>> cir) {
        ILootContextData data = context.getParamOrNull(LootJSParamSets.DATA);
        if (data == null) {
            LootJS.LOG.debug("LootJS: No data found in context, skipping loot modifiers. Reason is probably that context was not created through LootContext$Builder");
        } else {
            LootModificationsAPI.invokeActions(loot, context);
        }
    }
}