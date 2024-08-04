package org.violetmoon.zetaimplforge.event.play.entity;

import net.minecraft.world.entity.Entity;
import net.minecraftforge.event.entity.EntityJoinLevelEvent;
import org.violetmoon.zeta.event.play.entity.ZEntityJoinLevel;

public class ForgeZEntityJoinLevel implements ZEntityJoinLevel {

    private final EntityJoinLevelEvent e;

    public ForgeZEntityJoinLevel(EntityJoinLevelEvent e) {
        this.e = e;
    }

    @Override
    public Entity getEntity() {
        return this.e.getEntity();
    }

    @Override
    public boolean isCanceled() {
        return this.e.isCanceled();
    }

    @Override
    public void setCanceled(boolean cancel) {
        this.e.setCanceled(cancel);
    }
}