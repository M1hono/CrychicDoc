package snownee.lychee.core.contextual;

import com.google.gson.JsonObject;
import com.mojang.brigadier.ParseResults;
import net.minecraft.advancements.critereon.MinMaxBounds;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.util.GsonHelper;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.storage.loot.parameters.LootContextParams;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.phys.Vec3;
import snownee.lychee.ContextualConditionTypes;
import snownee.lychee.core.LycheeContext;
import snownee.lychee.core.recipe.ILycheeRecipe;

public record Execute(String command, MinMaxBounds.Ints bounds) implements ContextualCondition {

    public static final MinMaxBounds.Ints DEFAULT_RANGE = MinMaxBounds.Ints.atLeast(1);

    public static final Execute DUMMY = new Execute("", DEFAULT_RANGE);

    @Override
    public ContextualConditionType<? extends ContextualCondition> getType() {
        return ContextualConditionTypes.EXECUTE;
    }

    @Override
    public int test(ILycheeRecipe<?> recipe, LycheeContext ctx, int times) {
        if (!this.command.isEmpty() && !ctx.getLevel().isClientSide) {
            Vec3 pos = ctx.getParam(LootContextParams.ORIGIN);
            Entity entity = ctx.getParamOrNull(LootContextParams.THIS_ENTITY);
            Vec2 rotation = Vec2.ZERO;
            Component displayName = snownee.lychee.core.post.Execute.DEFAULT_NAME;
            String name = "lychee";
            if (entity != null) {
                rotation = entity.getRotationVector();
                displayName = entity.getDisplayName();
                name = entity.getName().getString();
            }
            CommandSourceStack sourceStack = new CommandSourceStack(CommandSource.NULL, pos, rotation, ctx.getServerLevel(), 2, name, displayName, ctx.getLevel().getServer(), entity);
            Commands cmds = ctx.getLevel().getServer().getCommands();
            ParseResults<CommandSourceStack> results = cmds.getDispatcher().parse(this.command, sourceStack);
            int i = cmds.performCommand(results, this.command);
            return this.bounds.matches(i) ? times : 0;
        } else {
            return 0;
        }
    }

    @Override
    public MutableComponent getDescription(boolean inverted) {
        return Component.translatable(this.makeDescriptionId(false));
    }

    public static class Type extends ContextualConditionType<Execute> {

        public Execute fromJson(JsonObject o) {
            MinMaxBounds.Ints bounds = Execute.DEFAULT_RANGE;
            if (o.has("value")) {
                bounds = MinMaxBounds.Ints.fromJson(o.get("value"));
            }
            return new Execute(GsonHelper.getAsString(o, "command"), bounds);
        }

        public void toJson(Execute condition, JsonObject o) {
            o.addProperty("command", condition.command());
            if (condition.bounds() != Execute.DEFAULT_RANGE) {
                o.add("value", condition.bounds().m_55328_());
            }
        }

        public Execute fromNetwork(FriendlyByteBuf buf) {
            return Execute.DUMMY;
        }

        public void toNetwork(Execute condition, FriendlyByteBuf buf) {
        }
    }
}