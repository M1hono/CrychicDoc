package org.violetmoon.zetaimplforge.event.play.entity.living;

import net.minecraft.world.entity.AgeableMob;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.event.entity.living.BabyEntitySpawnEvent;
import org.violetmoon.zeta.event.play.entity.living.ZBabyEntitySpawn;

public class ForgeZBabyEntitySpawn implements ZBabyEntitySpawn {

    private final BabyEntitySpawnEvent e;

    public ForgeZBabyEntitySpawn(BabyEntitySpawnEvent e) {
        this.e = e;
    }

    @Override
    public Mob getParentA() {
        return this.e.getParentA();
    }

    @Override
    public Mob getParentB() {
        return this.e.getParentB();
    }

    @Override
    public Player getCausedByPlayer() {
        return this.e.getCausedByPlayer();
    }

    @Override
    public AgeableMob getChild() {
        return this.e.getChild();
    }

    @Override
    public void setChild(AgeableMob proposedChild) {
        this.e.setChild(proposedChild);
    }

    public static class Lowest extends ForgeZBabyEntitySpawn implements ZBabyEntitySpawn.Lowest {

        public Lowest(BabyEntitySpawnEvent e) {
            super(e);
        }
    }
}