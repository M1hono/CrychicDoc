package mezz.jei.library.plugins.vanilla.cooking;

import mezz.jei.api.constants.RecipeTypes;
import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.recipe.RecipeType;
import net.minecraft.world.item.crafting.BlastingRecipe;
import net.minecraft.world.level.block.Blocks;

public class BlastingCategory extends AbstractCookingCategory<BlastingRecipe> {

    public BlastingCategory(IGuiHelper guiHelper) {
        super(guiHelper, Blocks.BLAST_FURNACE, "gui.jei.category.blasting", 100);
    }

    @Override
    public RecipeType<BlastingRecipe> getRecipeType() {
        return RecipeTypes.BLASTING;
    }
}