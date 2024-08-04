package fr.frinn.custommachinery.impl.requirement;

import fr.frinn.custommachinery.api.component.IMachineComponent;
import fr.frinn.custommachinery.api.crafting.ICraftingContext;
import fr.frinn.custommachinery.api.requirement.IChanceableRequirement;
import fr.frinn.custommachinery.api.requirement.RequirementIOMode;
import java.util.Random;
import net.minecraft.util.Mth;

public abstract class AbstractDelayedChanceableRequirement<T extends IMachineComponent> extends AbstractDelayedRequirement<T> implements IChanceableRequirement<T> {

    private double chance = 1.0;

    public AbstractDelayedChanceableRequirement(RequirementIOMode mode) {
        super(mode);
    }

    @Override
    public void setChance(double chance) {
        this.chance = Mth.clamp(chance, 0.0, 1.0);
    }

    public double getChance() {
        return this.chance;
    }

    @Override
    public boolean shouldSkip(T component, Random rand, ICraftingContext context) {
        double chance = context.getModifiedValue(this.chance, this, "chance");
        return rand.nextDouble() > chance;
    }
}