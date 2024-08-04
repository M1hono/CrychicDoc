package net.minecraft.world.level.block;

import javax.annotation.Nullable;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.stats.Stats;
import net.minecraft.util.RandomSource;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.entity.SmokerBlockEntity;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;

public class SmokerBlock extends AbstractFurnaceBlock {

    protected SmokerBlock(BlockBehaviour.Properties blockBehaviourProperties0) {
        super(blockBehaviourProperties0);
    }

    @Override
    public BlockEntity newBlockEntity(BlockPos blockPos0, BlockState blockState1) {
        return new SmokerBlockEntity(blockPos0, blockState1);
    }

    @Nullable
    @Override
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level level0, BlockState blockState1, BlockEntityType<T> blockEntityTypeT2) {
        return m_151987_(level0, blockEntityTypeT2, BlockEntityType.SMOKER);
    }

    @Override
    protected void openContainer(Level level0, BlockPos blockPos1, Player player2) {
        BlockEntity $$3 = level0.getBlockEntity(blockPos1);
        if ($$3 instanceof SmokerBlockEntity) {
            player2.openMenu((MenuProvider) $$3);
            player2.awardStat(Stats.INTERACT_WITH_SMOKER);
        }
    }

    @Override
    public void animateTick(BlockState blockState0, Level level1, BlockPos blockPos2, RandomSource randomSource3) {
        if ((Boolean) blockState0.m_61143_(f_48684_)) {
            double $$4 = (double) blockPos2.m_123341_() + 0.5;
            double $$5 = (double) blockPos2.m_123342_();
            double $$6 = (double) blockPos2.m_123343_() + 0.5;
            if (randomSource3.nextDouble() < 0.1) {
                level1.playLocalSound($$4, $$5, $$6, SoundEvents.SMOKER_SMOKE, SoundSource.BLOCKS, 1.0F, 1.0F, false);
            }
            level1.addParticle(ParticleTypes.SMOKE, $$4, $$5 + 1.1, $$6, 0.0, 0.0, 0.0);
        }
    }
}