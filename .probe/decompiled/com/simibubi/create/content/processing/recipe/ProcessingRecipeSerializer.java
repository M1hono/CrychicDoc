package com.simibubi.create.content.processing.recipe;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.simibubi.create.foundation.fluid.FluidHelper;
import com.simibubi.create.foundation.fluid.FluidIngredient;
import javax.annotation.ParametersAreNonnullByDefault;
import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.NonNullList;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.GsonHelper;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraftforge.fluids.FluidStack;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault
public class ProcessingRecipeSerializer<T extends ProcessingRecipe<?>> implements RecipeSerializer<T> {

    private final ProcessingRecipeBuilder.ProcessingRecipeFactory<T> factory;

    public ProcessingRecipeSerializer(ProcessingRecipeBuilder.ProcessingRecipeFactory<T> factory) {
        this.factory = factory;
    }

    protected void writeToJson(JsonObject json, T recipe) {
        JsonArray jsonIngredients = new JsonArray();
        JsonArray jsonOutputs = new JsonArray();
        recipe.ingredients.forEach(i -> jsonIngredients.add(i.toJson()));
        recipe.fluidIngredients.forEach(i -> jsonIngredients.add(i.serialize()));
        recipe.results.forEach(o -> jsonOutputs.add(o.serialize()));
        recipe.fluidResults.forEach(o -> jsonOutputs.add(FluidHelper.serializeFluidStack(o)));
        json.add("ingredients", jsonIngredients);
        json.add("results", jsonOutputs);
        int processingDuration = recipe.getProcessingDuration();
        if (processingDuration > 0) {
            json.addProperty("processingTime", processingDuration);
        }
        HeatCondition requiredHeat = recipe.getRequiredHeat();
        if (requiredHeat != HeatCondition.NONE) {
            json.addProperty("heatRequirement", requiredHeat.serialize());
        }
        recipe.writeAdditional(json);
    }

    protected T readFromJson(ResourceLocation recipeId, JsonObject json) {
        ProcessingRecipeBuilder<T> builder = new ProcessingRecipeBuilder<>(this.factory, recipeId);
        NonNullList<Ingredient> ingredients = NonNullList.create();
        NonNullList<FluidIngredient> fluidIngredients = NonNullList.create();
        NonNullList<ProcessingOutput> results = NonNullList.create();
        NonNullList<FluidStack> fluidResults = NonNullList.create();
        for (JsonElement je : GsonHelper.getAsJsonArray(json, "ingredients")) {
            if (FluidIngredient.isFluidIngredient(je)) {
                fluidIngredients.add(FluidIngredient.deserialize(je));
            } else {
                ingredients.add(Ingredient.fromJson(je));
            }
        }
        for (JsonElement jex : GsonHelper.getAsJsonArray(json, "results")) {
            JsonObject jsonObject = jex.getAsJsonObject();
            if (GsonHelper.isValidNode(jsonObject, "fluid")) {
                fluidResults.add(FluidHelper.deserializeFluidStack(jsonObject));
            } else {
                results.add(ProcessingOutput.deserialize(jex));
            }
        }
        builder.withItemIngredients(ingredients).withItemOutputs(results).withFluidIngredients(fluidIngredients).withFluidOutputs(fluidResults);
        if (GsonHelper.isValidNode(json, "processingTime")) {
            builder.duration(GsonHelper.getAsInt(json, "processingTime"));
        }
        if (GsonHelper.isValidNode(json, "heatRequirement")) {
            builder.requiresHeat(HeatCondition.deserialize(GsonHelper.getAsString(json, "heatRequirement")));
        }
        T recipe = builder.build();
        recipe.readAdditional(json);
        return recipe;
    }

    protected void writeToBuffer(FriendlyByteBuf buffer, T recipe) {
        NonNullList<Ingredient> ingredients = recipe.ingredients;
        NonNullList<FluidIngredient> fluidIngredients = recipe.fluidIngredients;
        NonNullList<ProcessingOutput> outputs = recipe.results;
        NonNullList<FluidStack> fluidOutputs = recipe.fluidResults;
        buffer.writeVarInt(ingredients.size());
        ingredients.forEach(i -> i.toNetwork(buffer));
        buffer.writeVarInt(fluidIngredients.size());
        fluidIngredients.forEach(i -> i.write(buffer));
        buffer.writeVarInt(outputs.size());
        outputs.forEach(o -> o.write(buffer));
        buffer.writeVarInt(fluidOutputs.size());
        fluidOutputs.forEach(o -> o.writeToPacket(buffer));
        buffer.writeVarInt(recipe.getProcessingDuration());
        buffer.writeVarInt(recipe.getRequiredHeat().ordinal());
        recipe.writeAdditional(buffer);
    }

    protected T readFromBuffer(ResourceLocation recipeId, FriendlyByteBuf buffer) {
        NonNullList<Ingredient> ingredients = NonNullList.create();
        NonNullList<FluidIngredient> fluidIngredients = NonNullList.create();
        NonNullList<ProcessingOutput> results = NonNullList.create();
        NonNullList<FluidStack> fluidResults = NonNullList.create();
        int size = buffer.readVarInt();
        for (int i = 0; i < size; i++) {
            ingredients.add(Ingredient.fromNetwork(buffer));
        }
        size = buffer.readVarInt();
        for (int i = 0; i < size; i++) {
            fluidIngredients.add(FluidIngredient.read(buffer));
        }
        size = buffer.readVarInt();
        for (int i = 0; i < size; i++) {
            results.add(ProcessingOutput.read(buffer));
        }
        size = buffer.readVarInt();
        for (int i = 0; i < size; i++) {
            fluidResults.add(FluidStack.readFromPacket(buffer));
        }
        T recipe = new ProcessingRecipeBuilder<>(this.factory, recipeId).withItemIngredients(ingredients).withItemOutputs(results).withFluidIngredients(fluidIngredients).withFluidOutputs(fluidResults).duration(buffer.readVarInt()).requiresHeat(HeatCondition.values()[buffer.readVarInt()]).build();
        recipe.readAdditional(buffer);
        return recipe;
    }

    public final void write(JsonObject json, T recipe) {
        this.writeToJson(json, recipe);
    }

    public final T fromJson(ResourceLocation id, JsonObject json) {
        return this.readFromJson(id, json);
    }

    public final void toNetwork(FriendlyByteBuf buffer, T recipe) {
        this.writeToBuffer(buffer, recipe);
    }

    public final T fromNetwork(ResourceLocation id, FriendlyByteBuf buffer) {
        return this.readFromBuffer(id, buffer);
    }

    public ProcessingRecipeBuilder.ProcessingRecipeFactory<T> getFactory() {
        return this.factory;
    }
}