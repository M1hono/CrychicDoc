package malte0811.ferritecore.util;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import net.minecraft.client.renderer.block.model.multipart.Condition;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;

public class PredicateHelper {

    public static List<Predicate<BlockState>> toCanonicalList(Iterable<? extends Condition> conditions, StateDefinition<Block, BlockState> stateContainer) {
        List<Predicate<BlockState>> list = new ArrayList();
        for (Condition cond : conditions) {
            list.add(cond.getPredicate(stateContainer));
        }
        canonize(list);
        return list;
    }

    public static <T> void canonize(List<Predicate<T>> input) {
        input.sort(Comparator.comparingInt(Object::hashCode));
        if (input instanceof ArrayList<Predicate<T>> arrayList) {
            arrayList.trimToSize();
        }
    }

    public static <T> Predicate<T> and(List<Predicate<T>> list) {
        return state -> {
            for (Predicate<T> predicate : list) {
                if (!predicate.test(state)) {
                    return false;
                }
            }
            return true;
        };
    }

    public static <T> Predicate<T> or(List<Predicate<T>> list) {
        return state -> {
            for (Predicate<T> predicate : list) {
                if (predicate.test(state)) {
                    return true;
                }
            }
            return false;
        };
    }
}