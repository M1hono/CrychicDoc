package vectorwing.farmersdelight.common.item;

import com.google.common.collect.Lists;
import java.util.List;
import javax.annotation.Nullable;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffectUtil;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.TamableAnimal;
import net.minecraft.world.entity.animal.Wolf;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import vectorwing.farmersdelight.common.Configuration;
import vectorwing.farmersdelight.common.registry.ModItems;
import vectorwing.farmersdelight.common.registry.ModParticleTypes;
import vectorwing.farmersdelight.common.tag.ModTags;
import vectorwing.farmersdelight.common.utility.MathUtils;
import vectorwing.farmersdelight.common.utility.TextUtils;

public class DogFoodItem extends ConsumableItem {

    public static final List<MobEffectInstance> EFFECTS = Lists.newArrayList(new MobEffectInstance[] { new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 6000, 0), new MobEffectInstance(MobEffects.DAMAGE_BOOST, 6000, 0), new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 6000, 0) });

    public DogFoodItem(Item.Properties properties) {
        super(properties);
    }

    @Override
    public void appendHoverText(ItemStack stack, @Nullable Level level, List<Component> tooltip, TooltipFlag isAdvanced) {
        if (Configuration.FOOD_EFFECT_TOOLTIP.get()) {
            MutableComponent textWhenFeeding = TextUtils.getTranslation("tooltip.dog_food.when_feeding");
            tooltip.add(textWhenFeeding.withStyle(ChatFormatting.GRAY));
            for (MobEffectInstance effectInstance : EFFECTS) {
                MutableComponent effectDescription = Component.literal(" ");
                MutableComponent effectName = Component.translatable(effectInstance.getDescriptionId());
                effectDescription.append(effectName);
                MobEffect effect = effectInstance.getEffect();
                if (effectInstance.getAmplifier() > 0) {
                    effectDescription.append(" ").append(Component.translatable("potion.potency." + effectInstance.getAmplifier()));
                }
                if (effectInstance.getDuration() > 20) {
                    effectDescription.append(" (").append(MobEffectUtil.formatDuration(effectInstance, 1.0F)).append(")");
                }
                tooltip.add(effectDescription.withStyle(effect.getCategory().getTooltipFormatting()));
            }
        }
    }

    @Override
    public InteractionResult interactLivingEntity(ItemStack stack, Player playerIn, LivingEntity target, InteractionHand hand) {
        if (target instanceof Wolf wolf && wolf.m_6084_() && wolf.m_21824_()) {
            return InteractionResult.SUCCESS;
        }
        return InteractionResult.PASS;
    }

    @EventBusSubscriber(modid = "farmersdelight", bus = Bus.FORGE)
    public static class DogFoodEvent {

        @SubscribeEvent
        public static void onDogFoodApplied(PlayerInteractEvent.EntityInteract event) {
            Player player = event.getEntity();
            Entity target = event.getTarget();
            ItemStack itemStack = event.getItemStack();
            if (target instanceof LivingEntity entity && target.getType().is(ModTags.DOG_FOOD_USERS)) {
                boolean isTameable = entity instanceof TamableAnimal;
                if (entity.isAlive() && (!isTameable || ((TamableAnimal) entity).isTame()) && itemStack.getItem().equals(ModItems.DOG_FOOD.get())) {
                    entity.setHealth(entity.getMaxHealth());
                    for (MobEffectInstance effect : DogFoodItem.EFFECTS) {
                        entity.addEffect(new MobEffectInstance(effect));
                    }
                    entity.m_9236_().playSound(null, target.blockPosition(), SoundEvents.GENERIC_EAT, SoundSource.PLAYERS, 0.8F, 0.8F);
                    for (int i = 0; i < 5; i++) {
                        double xSpeed = MathUtils.RAND.nextGaussian() * 0.02;
                        double ySpeed = MathUtils.RAND.nextGaussian() * 0.02;
                        double zSpeed = MathUtils.RAND.nextGaussian() * 0.02;
                        entity.m_9236_().addParticle(ModParticleTypes.STAR.get(), entity.m_20208_(1.0), entity.m_20187_() + 0.5, entity.m_20262_(1.0), xSpeed, ySpeed, zSpeed);
                    }
                    if (itemStack.getCraftingRemainingItem() != ItemStack.EMPTY && !player.isCreative()) {
                        player.addItem(itemStack.getCraftingRemainingItem());
                        itemStack.shrink(1);
                    }
                    event.setCancellationResult(InteractionResult.SUCCESS);
                    event.setCanceled(true);
                }
            }
        }
    }
}