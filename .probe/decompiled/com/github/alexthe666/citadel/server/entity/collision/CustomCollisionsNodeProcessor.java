package com.github.alexthe666.citadel.server.entity.collision;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.pathfinder.BlockPathTypes;
import net.minecraft.world.level.pathfinder.WalkNodeEvaluator;

public class CustomCollisionsNodeProcessor extends WalkNodeEvaluator {

    public static BlockPathTypes getBlockPathTypeStatic(BlockGetter p_237231_0_, BlockPos.MutableBlockPos p_237231_1_) {
        int i = p_237231_1_.m_123341_();
        int j = p_237231_1_.m_123342_();
        int k = p_237231_1_.m_123343_();
        BlockPathTypes pathnodetype = getNodes(p_237231_0_, p_237231_1_);
        if (pathnodetype == BlockPathTypes.OPEN && j >= 1) {
            BlockPathTypes pathnodetype1 = getNodes(p_237231_0_, p_237231_1_.set(i, j - 1, k));
            pathnodetype = pathnodetype1 != BlockPathTypes.WALKABLE && pathnodetype1 != BlockPathTypes.OPEN && pathnodetype1 != BlockPathTypes.WATER && pathnodetype1 != BlockPathTypes.LAVA ? BlockPathTypes.WALKABLE : BlockPathTypes.OPEN;
            if (pathnodetype1 == BlockPathTypes.DAMAGE_FIRE) {
                pathnodetype = BlockPathTypes.DAMAGE_FIRE;
            }
            if (pathnodetype1 == BlockPathTypes.DAMAGE_OTHER) {
                pathnodetype = BlockPathTypes.DAMAGE_OTHER;
            }
            if (pathnodetype1 == BlockPathTypes.STICKY_HONEY) {
                pathnodetype = BlockPathTypes.STICKY_HONEY;
            }
        }
        if (pathnodetype == BlockPathTypes.WALKABLE) {
            pathnodetype = m_77607_(p_237231_0_, p_237231_1_.set(i, j, k), pathnodetype);
        }
        return pathnodetype;
    }

    protected static BlockPathTypes getNodes(BlockGetter p_237238_0_, BlockPos p_237238_1_) {
        BlockState blockstate = p_237238_0_.getBlockState(p_237238_1_);
        BlockPathTypes type = blockstate.getBlockPathType(p_237238_0_, p_237238_1_, null);
        if (type != null) {
            return type;
        } else if (blockstate.m_60795_()) {
            return BlockPathTypes.OPEN;
        } else {
            return blockstate.m_60734_() == Blocks.BAMBOO ? BlockPathTypes.OPEN : m_77643_(p_237238_0_, p_237238_1_);
        }
    }

    @Override
    public BlockPathTypes getBlockPathType(BlockGetter blockaccessIn, int x, int y, int z) {
        return getBlockPathTypeStatic(blockaccessIn, new BlockPos.MutableBlockPos(x, y, z));
    }

    @Override
    protected BlockPathTypes evaluateBlockPathType(BlockGetter world, BlockPos pos, BlockPathTypes nodeType) {
        BlockState state = world.getBlockState(pos);
        return ((ICustomCollisions) this.f_77313_).canPassThrough(pos, state, state.m_60816_(world, pos)) ? BlockPathTypes.OPEN : super.evaluateBlockPathType(world, pos, nodeType);
    }
}