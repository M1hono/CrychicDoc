package dev.xkmc.modulargolems.compat.materials.botania;

import dev.xkmc.modulargolems.content.core.StatFilterType;
import dev.xkmc.modulargolems.content.entity.common.AbstractGolemEntity;
import dev.xkmc.modulargolems.content.modifier.base.GolemModifier;
import dev.xkmc.modulargolems.init.data.MGConfig;
import java.util.List;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import vazkii.botania.common.entity.PixieEntity;

public class PixieCounterattackModifier extends GolemModifier {

    public PixieCounterattackModifier() {
        super(StatFilterType.HEALTH, 5);
    }

    @Override
    public void onHurt(AbstractGolemEntity<?, ?> entity, LivingHurtEvent event, int level) {
        if (event.getSource().getEntity() instanceof LivingEntity le) {
            double prob = MGConfig.COMMON.pixieCounterattackProb.get() * (double) level;
            if (entity.m_217043_().nextDouble() < prob) {
                PixieEntity pixie = new PixieEntity(entity.m_9236_());
                pixie.m_6034_(entity.m_20185_(), entity.m_20186_() + 2.0, entity.m_20189_());
                float dmg = (float) (4 + 2 * (Integer) entity.getModifiers().getOrDefault(BotCompatRegistry.PIXIE_ATTACK.get(), 0));
                pixie.setProps(le, entity, 0, dmg);
                pixie.m_6518_((ServerLevelAccessor) entity.m_9236_(), entity.m_9236_().getCurrentDifficultyAt(pixie.m_20183_()), MobSpawnType.EVENT, null, null);
                entity.m_9236_().m_7967_(pixie);
            }
        }
    }

    @Override
    public List<MutableComponent> getDetail(int v) {
        int prob = (int) Math.round(MGConfig.COMMON.pixieCounterattackProb.get() * (double) v * 100.0);
        return List.of(Component.translatable(this.getDescriptionId() + ".desc", prob).withStyle(ChatFormatting.GREEN));
    }
}