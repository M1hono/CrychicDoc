package mezz.jei.library.plugins.vanilla.cooking;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import mezz.jei.api.gui.builder.IRecipeLayoutBuilder;
import mezz.jei.api.gui.drawable.IDrawable;
import mezz.jei.api.gui.drawable.IDrawableAnimated;
import mezz.jei.api.gui.ingredient.IRecipeSlotsView;
import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.recipe.IFocusGroup;
import mezz.jei.api.recipe.RecipeIngredientRole;
import mezz.jei.common.Constants;
import mezz.jei.library.util.RecipeUtil;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Font;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.AbstractCookingRecipe;
import net.minecraft.world.level.block.Block;

public abstract class AbstractCookingCategory<T extends AbstractCookingRecipe> extends FurnaceVariantCategory<T> {

    private final IDrawable background;

    private final int regularCookTime;

    private final IDrawable icon;

    private final Component localizedName;

    private final LoadingCache<Integer, IDrawableAnimated> cachedArrows;

    public AbstractCookingCategory(final IGuiHelper guiHelper, Block icon, String translationKey, int regularCookTime) {
        super(guiHelper);
        this.background = guiHelper.createDrawable(Constants.RECIPE_GUI_VANILLA, 0, 114, 82, 54);
        this.regularCookTime = regularCookTime;
        this.icon = guiHelper.createDrawableItemStack(new ItemStack(icon));
        this.localizedName = Component.translatable(translationKey);
        this.cachedArrows = CacheBuilder.newBuilder().maximumSize(25L).build(new CacheLoader<Integer, IDrawableAnimated>() {

            public IDrawableAnimated load(Integer cookTime) {
                return guiHelper.drawableBuilder(Constants.RECIPE_GUI_VANILLA, 82, 128, 24, 17).buildAnimated(cookTime, IDrawableAnimated.StartDirection.LEFT, false);
            }
        });
    }

    protected IDrawableAnimated getArrow(T recipe) {
        int cookTime = recipe.getCookingTime();
        if (cookTime <= 0) {
            cookTime = this.regularCookTime;
        }
        return (IDrawableAnimated) this.cachedArrows.getUnchecked(cookTime);
    }

    @Override
    public IDrawable getBackground() {
        return this.background;
    }

    @Override
    public IDrawable getIcon() {
        return this.icon;
    }

    public void draw(T recipe, IRecipeSlotsView recipeSlotsView, GuiGraphics guiGraphics, double mouseX, double mouseY) {
        this.animatedFlame.draw(guiGraphics, 1, 20);
        IDrawableAnimated arrow = this.getArrow(recipe);
        arrow.draw(guiGraphics, 24, 18);
        this.drawExperience(recipe, guiGraphics, 0);
        this.drawCookTime(recipe, guiGraphics, 45);
    }

    protected void drawExperience(T recipe, GuiGraphics guiGraphics, int y) {
        float experience = recipe.getExperience();
        if (experience > 0.0F) {
            Component experienceString = Component.translatable("gui.jei.category.smelting.experience", experience);
            Minecraft minecraft = Minecraft.getInstance();
            Font fontRenderer = minecraft.font;
            int stringWidth = fontRenderer.width(experienceString);
            guiGraphics.drawString(fontRenderer, experienceString, this.getWidth() - stringWidth, y, -8355712, false);
        }
    }

    protected void drawCookTime(T recipe, GuiGraphics guiGraphics, int y) {
        int cookTime = recipe.getCookingTime();
        if (cookTime > 0) {
            int cookTimeSeconds = cookTime / 20;
            Component timeString = Component.translatable("gui.jei.category.smelting.time.seconds", cookTimeSeconds);
            Minecraft minecraft = Minecraft.getInstance();
            Font fontRenderer = minecraft.font;
            int stringWidth = fontRenderer.width(timeString);
            guiGraphics.drawString(fontRenderer, timeString, this.getWidth() - stringWidth, y, -8355712, false);
        }
    }

    @Override
    public Component getTitle() {
        return this.localizedName;
    }

    public void setRecipe(IRecipeLayoutBuilder builder, T recipe, IFocusGroup focuses) {
        builder.addSlot(RecipeIngredientRole.INPUT, 1, 1).addIngredients(recipe.getIngredients().get(0));
        builder.addSlot(RecipeIngredientRole.OUTPUT, 61, 19).addItemStack(RecipeUtil.getResultItem(recipe));
    }

    public boolean isHandled(T recipe) {
        return !recipe.m_5598_();
    }
}