package fr.frinn.custommachinery.common.crafting;

import com.mojang.datafixers.util.Pair;
import fr.frinn.custommachinery.api.crafting.ICraftingContext;
import fr.frinn.custommachinery.api.crafting.IMachineRecipe;
import fr.frinn.custommachinery.api.crafting.IProcessor;
import fr.frinn.custommachinery.api.machine.MachineTile;
import fr.frinn.custommachinery.api.requirement.IRequirement;
import fr.frinn.custommachinery.api.requirement.ITickableRequirement;
import fr.frinn.custommachinery.api.requirement.RequirementIOMode;
import fr.frinn.custommachinery.api.requirement.RequirementType;
import fr.frinn.custommachinery.api.upgrade.IMachineUpgradeManager;
import fr.frinn.custommachinery.api.upgrade.IRecipeModifier;
import fr.frinn.custommachinery.common.init.Registration;
import java.util.Collections;
import java.util.List;
import org.jetbrains.annotations.Nullable;

public class CraftingContext implements ICraftingContext {

    private final IProcessor manager;

    private final IMachineUpgradeManager upgrades;

    private final IMachineRecipe recipe;

    private final List<Pair<IRecipeModifier, Integer>> fixedModifiers;

    private double baseSpeed = 1.0;

    public CraftingContext(IProcessor manager, IMachineUpgradeManager upgrades, IMachineRecipe recipe) {
        this.manager = manager;
        this.upgrades = upgrades;
        this.recipe = recipe;
        this.fixedModifiers = Collections.unmodifiableList(upgrades.getAllModifiers());
    }

    @Override
    public MachineTile getMachineTile() {
        return this.manager.getTile();
    }

    @Override
    public IMachineRecipe getRecipe() {
        return this.recipe;
    }

    @Override
    public double getRemainingTime() {
        return this.getRecipe() == null ? 0.0 : (double) this.getRecipe().getRecipeTime() - this.manager.getRecipeProgressTime();
    }

    @Override
    public double getBaseSpeed() {
        return this.baseSpeed;
    }

    @Override
    public void setBaseSpeed(double baseSpeed) {
        this.baseSpeed = baseSpeed;
    }

    @Override
    public double getModifiedSpeed() {
        if (this.getRecipe() == null) {
            return this.baseSpeed;
        } else {
            int baseTime = this.getRecipe().getRecipeTime();
            double modifiedTime = this.getModifiedValue((double) baseTime, (RequirementType<?>) Registration.SPEED_REQUIREMENT.get(), null, null);
            double speed = (double) baseTime * this.baseSpeed / modifiedTime;
            return Math.max(0.01, speed);
        }
    }

    @Override
    public long getIntegerModifiedValue(double value, IRequirement<?> requirement, @Nullable String target) {
        return Math.round(this.getModifiedValue(value, requirement, target));
    }

    @Override
    public long getPerTickIntegerModifiedValue(double value, IRequirement<?> requirement, @Nullable String target) {
        return Math.round(this.getPerTickModifiedValue(value, requirement, target));
    }

    @Override
    public double getModifiedValue(double value, IRequirement<?> requirement, @Nullable String target) {
        return this.getModifiedValue(value, requirement.getType(), target, requirement.getMode());
    }

    @Override
    public double getPerTickModifiedValue(double value, IRequirement<?> requirement, @Nullable String target) {
        return this.getRemainingTime() > 0.0 ? this.getModifiedValue(value, requirement, target) * Math.min(this.getModifiedSpeed(), this.getRemainingTime()) : this.getModifiedValue(value, requirement, target) * this.getModifiedSpeed();
    }

    private double getModifiedValue(double value, RequirementType<?> type, @Nullable String target, @Nullable RequirementIOMode mode) {
        double modified = value;
        for (Pair<IRecipeModifier, Integer> pair : type instanceof ITickableRequirement ? this.upgrades.getAllModifiers() : this.fixedModifiers) {
            if (((IRecipeModifier) pair.getFirst()).shouldApply(type, mode, target)) {
                modified = ((IRecipeModifier) pair.getFirst()).apply(modified, (Integer) pair.getSecond());
            }
        }
        return modified;
    }

    public static class Mutable extends CraftingContext {

        private IMachineRecipe recipe;

        public Mutable(IProcessor manager, IMachineUpgradeManager upgrades) {
            super(manager, upgrades, null);
        }

        public CraftingContext.Mutable setRecipe(IMachineRecipe recipe) {
            this.recipe = recipe;
            return this;
        }

        @Override
        public IMachineRecipe getRecipe() {
            return this.recipe;
        }
    }
}