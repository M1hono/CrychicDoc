package dev.latvian.mods.kubejs.recipe.filter;

import dev.latvian.mods.rhino.Context;
import java.util.List;
import java.util.Map;

public interface RecipeFilterParseEvent {

    void parse(Context var1, List<RecipeFilter> var2, Map<?, ?> var3);
}