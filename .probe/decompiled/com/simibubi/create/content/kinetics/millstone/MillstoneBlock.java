package com.simibubi.create.content.kinetics.millstone;

import com.simibubi.create.AllBlockEntityTypes;
import com.simibubi.create.AllShapes;
import com.simibubi.create.content.kinetics.base.KineticBlock;
import com.simibubi.create.content.kinetics.simpleRelays.ICogWheel;
import com.simibubi.create.foundation.block.IBE;
import com.simibubi.create.foundation.utility.Iterate;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.pathfinder.PathComputationType;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.minecraftforge.common.capabilities.ForgeCapabilities;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.IItemHandlerModifiable;
import net.minecraftforge.items.ItemStackHandler;

public class MillstoneBlock extends KineticBlock implements IBE<MillstoneBlockEntity>, ICogWheel {

    public MillstoneBlock(BlockBehaviour.Properties properties) {
        super(properties);
    }

    @Override
    public VoxelShape getShape(BlockState state, BlockGetter worldIn, BlockPos pos, CollisionContext context) {
        return AllShapes.MILLSTONE;
    }

    @Override
    public boolean hasShaftTowards(LevelReader world, BlockPos pos, BlockState state, Direction face) {
        return face == Direction.DOWN;
    }

    @Override
    public InteractionResult use(BlockState state, Level worldIn, BlockPos pos, Player player, InteractionHand handIn, BlockHitResult hit) {
        if (!player.m_21120_(handIn).isEmpty()) {
            return InteractionResult.PASS;
        } else if (worldIn.isClientSide) {
            return InteractionResult.SUCCESS;
        } else {
            this.withBlockEntityDo(worldIn, pos, millstone -> {
                boolean emptyOutput = true;
                IItemHandlerModifiable inv = millstone.outputInv;
                for (int slot = 0; slot < inv.getSlots(); slot++) {
                    ItemStack stackInSlot = inv.getStackInSlot(slot);
                    if (!stackInSlot.isEmpty()) {
                        emptyOutput = false;
                    }
                    player.getInventory().placeItemBackInInventory(stackInSlot);
                    inv.setStackInSlot(slot, ItemStack.EMPTY);
                }
                if (emptyOutput) {
                    inv = millstone.inputInv;
                    for (int slot = 0; slot < inv.getSlots(); slot++) {
                        player.getInventory().placeItemBackInInventory(inv.getStackInSlot(slot));
                        inv.setStackInSlot(slot, ItemStack.EMPTY);
                    }
                }
                millstone.m_6596_();
                millstone.sendData();
            });
            return InteractionResult.SUCCESS;
        }
    }

    @Override
    public void updateEntityAfterFallOn(BlockGetter worldIn, Entity entityIn) {
        super.m_5548_(worldIn, entityIn);
        if (!entityIn.level().isClientSide) {
            if (entityIn instanceof ItemEntity) {
                if (entityIn.isAlive()) {
                    MillstoneBlockEntity millstone = null;
                    for (BlockPos pos : Iterate.hereAndBelow(entityIn.blockPosition())) {
                        if (millstone == null) {
                            millstone = this.getBlockEntity(worldIn, pos);
                        }
                    }
                    if (millstone != null) {
                        ItemEntity itemEntity = (ItemEntity) entityIn;
                        LazyOptional<IItemHandler> capability = millstone.getCapability(ForgeCapabilities.ITEM_HANDLER);
                        if (capability.isPresent()) {
                            ItemStack remainder = capability.orElse(new ItemStackHandler()).insertItem(0, itemEntity.getItem(), false);
                            if (remainder.isEmpty()) {
                                itemEntity.m_146870_();
                            }
                            if (remainder.getCount() < itemEntity.getItem().getCount()) {
                                itemEntity.setItem(remainder);
                            }
                        }
                    }
                }
            }
        }
    }

    @Override
    public Direction.Axis getRotationAxis(BlockState state) {
        return Direction.Axis.Y;
    }

    @Override
    public Class<MillstoneBlockEntity> getBlockEntityClass() {
        return MillstoneBlockEntity.class;
    }

    @Override
    public BlockEntityType<? extends MillstoneBlockEntity> getBlockEntityType() {
        return (BlockEntityType<? extends MillstoneBlockEntity>) AllBlockEntityTypes.MILLSTONE.get();
    }

    @Override
    public boolean isPathfindable(BlockState state, BlockGetter reader, BlockPos pos, PathComputationType type) {
        return false;
    }
}