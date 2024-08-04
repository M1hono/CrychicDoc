package org.violetmoon.zetaimplforge.event.play.loading;

import it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import java.util.List;
import net.minecraft.world.entity.npc.VillagerProfession;
import net.minecraft.world.entity.npc.VillagerTrades;
import net.minecraftforge.event.village.VillagerTradesEvent;
import org.violetmoon.zeta.event.play.loading.ZVillagerTrades;

public class ForgeZVillagerTrades implements ZVillagerTrades {

    private final VillagerTradesEvent e;

    public ForgeZVillagerTrades(VillagerTradesEvent e) {
        this.e = e;
    }

    @Override
    public Int2ObjectMap<List<VillagerTrades.ItemListing>> getTrades() {
        return this.e.getTrades();
    }

    @Override
    public VillagerProfession getType() {
        return this.e.getType();
    }
}