package com.sihenzhang.crockpot.event;

import com.sihenzhang.crockpot.item.CrockPotItems;
import com.sihenzhang.crockpot.util.ItemUtils;
import java.util.Iterator;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.GameRules;
import net.minecraftforge.common.util.FakePlayer;
import net.minecraftforge.event.entity.living.LivingDropsEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.wrapper.PlayerMainInvWrapper;

@EventBusSubscriber(modid = "crockpot")
public class GnawsCoinSoulboundEvent {

    @SubscribeEvent(priority = EventPriority.HIGHEST)
    public static void onPlayerDrops(LivingDropsEvent event) {
        if (event.getEntity() instanceof Player player) {
            if (player instanceof FakePlayer || player.m_9236_().getGameRules().getBoolean(GameRules.RULE_KEEPINVENTORY)) {
                return;
            }
            Iterator<ItemEntity> iter = event.getDrops().iterator();
            while (iter.hasNext()) {
                ItemStack stack = ((ItemEntity) iter.next()).getItem();
                if (stack.is(CrockPotItems.GNAWS_COIN.get()) && ItemUtils.giveItemToPlayer(player, stack)) {
                    iter.remove();
                }
            }
        }
    }

    @SubscribeEvent(priority = EventPriority.HIGHEST)
    public static void onPlayerClone(PlayerEvent.Clone event) {
        if (event.isWasDeath()) {
            Player player = event.getEntity();
            Player oldPlayer = event.getOriginal();
            if (!(player instanceof FakePlayer) && !player.m_9236_().getGameRules().getBoolean(GameRules.RULE_KEEPINVENTORY)) {
                IItemHandler oldInventory = new PlayerMainInvWrapper(oldPlayer.getInventory());
                for (int i = 0; i < oldInventory.getSlots(); i++) {
                    ItemStack stack = oldInventory.getStackInSlot(i);
                    if (stack.is(CrockPotItems.GNAWS_COIN.get()) && ItemUtils.giveItemToPlayer(player, stack.copy())) {
                        stack.setCount(0);
                    }
                }
            }
        }
    }
}