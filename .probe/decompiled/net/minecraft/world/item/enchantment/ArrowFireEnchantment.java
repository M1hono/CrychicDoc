package net.minecraft.world.item.enchantment;

import net.minecraft.world.entity.EquipmentSlot;

public class ArrowFireEnchantment extends Enchantment {

    public ArrowFireEnchantment(Enchantment.Rarity enchantmentRarity0, EquipmentSlot... equipmentSlot1) {
        super(enchantmentRarity0, EnchantmentCategory.BOW, equipmentSlot1);
    }

    @Override
    public int getMinCost(int int0) {
        return 20;
    }

    @Override
    public int getMaxCost(int int0) {
        return 50;
    }
}