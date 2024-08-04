package com.mna.blocks.decoration;

import net.minecraft.core.Direction;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
import net.minecraft.world.level.block.Mirror;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.level.block.state.properties.IntegerProperty;

public class SimpleRotationalBlock extends Block {

    public static final IntegerProperty SURFACE_TYPE = IntegerProperty.create("surface", 1, 3);

    public static final DirectionProperty FACING = HorizontalDirectionalBlock.FACING;

    public SimpleRotationalBlock(BlockBehaviour.Properties p_i48377_1_) {
        super(p_i48377_1_);
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        super.createBlockStateDefinition(builder);
        builder.add(SURFACE_TYPE, FACING);
    }

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        int surfaceType;
        Direction face;
        if (context.m_43719_() == Direction.UP) {
            surfaceType = 1;
            face = context.m_8125_().getOpposite();
        } else if (context.m_43719_() == Direction.DOWN) {
            surfaceType = 2;
            face = context.m_8125_().getOpposite();
        } else {
            surfaceType = 3;
            face = context.m_43719_();
        }
        return (BlockState) ((BlockState) super.getStateForPlacement(context).m_61124_(FACING, face)).m_61124_(SURFACE_TYPE, surfaceType);
    }

    @Override
    public BlockState mirror(BlockState pState, Mirror pMirror) {
        return pState.m_60717_(pMirror.getRotation((Direction) pState.m_61143_(FACING)));
    }

    @Override
    public BlockState rotate(BlockState pState, Rotation pRotation) {
        return (BlockState) pState.m_61124_(FACING, pRotation.rotate((Direction) pState.m_61143_(FACING)));
    }
}