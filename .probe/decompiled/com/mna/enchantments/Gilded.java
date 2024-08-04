package com.mna.enchantments;

import com.mna.enchantments.base.MAEnchantmentBase;
import com.mna.items.artifice.ItemSpectralElytra;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentCategory;

public class Gilded extends MAEnchantmentBase {

    public Gilded() {
        super(Enchantment.Rarity.UNCOMMON, EnchantmentCategory.ARMOR, new EquipmentSlot[] { EquipmentSlot.CHEST, EquipmentSlot.FEET, EquipmentSlot.HEAD, EquipmentSlot.LEGS });
    }

    @Override
    public boolean canEnchant(ItemStack stack) {
        return stack.getItem() instanceof ArmorItem || stack.getItem() instanceof ItemSpectralElytra;
    }
}