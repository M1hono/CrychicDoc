package com.rekindled.embers.block;

import com.rekindled.embers.RegistryManager;
import com.rekindled.embers.api.block.IPipeConnection;
import com.rekindled.embers.blockentity.ItemTransferBlockEntity;
import com.rekindled.embers.blockentity.PipeBlockEntityBase;
import com.rekindled.embers.util.Misc;
import javax.annotation.Nullable;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.BaseEntityBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Mirror;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.block.SimpleWaterloggedBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.minecraftforge.common.capabilities.ForgeCapabilities;
import net.minecraftforge.items.IItemHandler;

public class ItemTransferBlock extends BaseEntityBlock implements SimpleWaterloggedBlock, IPipeConnection {

    protected static final VoxelShape UP_AABB = Shapes.or(Block.box(0.0, 0.0, 0.0, 4.0, 16.0, 4.0), Block.box(0.0, 0.0, 12.0, 4.0, 16.0, 16.0), Block.box(12.0, 0.0, 0.0, 16.0, 16.0, 4.0), Block.box(12.0, 0.0, 12.0, 16.0, 16.0, 16.0), m_49796_(4.0, 0.0, 4.0, 12.0, 4.0, 12.0), m_49796_(2.0, 4.0, 2.0, 14.0, 12.0, 14.0), m_49796_(0.0, 12.0, 0.0, 16.0, 16.0, 16.0));

    protected static final VoxelShape DOWN_AABB = Shapes.or(Block.box(0.0, 0.0, 0.0, 4.0, 16.0, 4.0), Block.box(0.0, 0.0, 12.0, 4.0, 16.0, 16.0), Block.box(12.0, 0.0, 0.0, 16.0, 16.0, 4.0), Block.box(12.0, 0.0, 12.0, 16.0, 16.0, 16.0), m_49796_(4.0, 4.0, 4.0, 12.0, 16.0, 12.0), m_49796_(2.0, 4.0, 2.0, 14.0, 12.0, 14.0), m_49796_(0.0, 0.0, 0.0, 16.0, 4.0, 16.0));

    protected static final VoxelShape NORTH_AABB = Shapes.or(Block.box(0.0, 0.0, 0.0, 4.0, 4.0, 16.0), Block.box(0.0, 12.0, 0.0, 4.0, 16.0, 16.0), Block.box(12.0, 0.0, 0.0, 16.0, 4.0, 16.0), Block.box(12.0, 12.0, 0.0, 16.0, 16.0, 16.0), m_49796_(4.0, 4.0, 4.0, 12.0, 12.0, 16.0), m_49796_(2.0, 2.0, 4.0, 14.0, 14.0, 12.0), m_49796_(0.0, 0.0, 0.0, 16.0, 16.0, 4.0));

    protected static final VoxelShape SOUTH_AABB = Shapes.or(Block.box(0.0, 0.0, 0.0, 4.0, 4.0, 16.0), Block.box(0.0, 12.0, 0.0, 4.0, 16.0, 16.0), Block.box(12.0, 0.0, 0.0, 16.0, 4.0, 16.0), Block.box(12.0, 12.0, 0.0, 16.0, 16.0, 16.0), m_49796_(4.0, 4.0, 0.0, 12.0, 12.0, 4.0), m_49796_(2.0, 2.0, 4.0, 14.0, 14.0, 12.0), m_49796_(0.0, 0.0, 12.0, 16.0, 16.0, 16.0));

    protected static final VoxelShape WEST_AABB = Shapes.or(Block.box(0.0, 0.0, 0.0, 16.0, 4.0, 4.0), Block.box(0.0, 0.0, 12.0, 16.0, 4.0, 16.0), Block.box(0.0, 12.0, 0.0, 16.0, 16.0, 4.0), Block.box(0.0, 12.0, 12.0, 16.0, 16.0, 16.0), m_49796_(4.0, 4.0, 4.0, 16.0, 12.0, 12.0), m_49796_(4.0, 2.0, 2.0, 12.0, 14.0, 14.0), m_49796_(0.0, 0.0, 0.0, 4.0, 16.0, 16.0));

    protected static final VoxelShape EAST_AABB = Shapes.or(Block.box(0.0, 0.0, 0.0, 16.0, 4.0, 4.0), Block.box(0.0, 0.0, 12.0, 16.0, 4.0, 16.0), Block.box(0.0, 12.0, 0.0, 16.0, 16.0, 4.0), Block.box(0.0, 12.0, 12.0, 16.0, 16.0, 16.0), m_49796_(0.0, 4.0, 4.0, 4.0, 12.0, 12.0), m_49796_(4.0, 2.0, 2.0, 12.0, 14.0, 14.0), m_49796_(12.0, 0.0, 0.0, 16.0, 16.0, 16.0));

    public static final BooleanProperty FILTER = BooleanProperty.create("filter");

    public ItemTransferBlock(BlockBehaviour.Properties properties) {
        super(properties);
        this.m_49959_((BlockState) ((BlockState) ((BlockState) ((BlockState) this.f_49792_.any()).m_61124_(BlockStateProperties.FACING, Direction.UP)).m_61124_(FILTER, false)).m_61124_(BlockStateProperties.WATERLOGGED, false));
    }

    @Override
    public VoxelShape getShape(BlockState pState, BlockGetter pLevel, BlockPos pPos, CollisionContext pContext) {
        switch((Direction) pState.m_61143_(BlockStateProperties.FACING)) {
            case UP:
                return UP_AABB;
            case DOWN:
                return DOWN_AABB;
            case EAST:
                return EAST_AABB;
            case WEST:
                return WEST_AABB;
            case SOUTH:
                return SOUTH_AABB;
            case NORTH:
            default:
                return NORTH_AABB;
        }
    }

    @Override
    public InteractionResult use(BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hit) {
        if (level.getBlockEntity(pos) instanceof ItemTransferBlockEntity transfer) {
            ItemStack heldItem = player.m_21120_(hand);
            if (!heldItem.isEmpty()) {
                transfer.filterItem = heldItem.copy();
                level.setBlock(pos, (BlockState) state.m_61124_(FILTER, true), 10);
            } else {
                transfer.filterItem = ItemStack.EMPTY;
                level.setBlock(pos, (BlockState) state.m_61124_(FILTER, false), 10);
            }
            transfer.setupFilter();
            transfer.syncFilter = true;
            transfer.m_6596_();
            return InteractionResult.SUCCESS;
        } else {
            return InteractionResult.PASS;
        }
    }

    @Override
    public void onRemove(BlockState pState, Level level, BlockPos pos, BlockState pNewState, boolean pIsMoving) {
        if (!pState.m_60713_(pNewState.m_60734_())) {
            BlockEntity blockEntity = level.getBlockEntity(pos);
            if (blockEntity != null) {
                IItemHandler handler = (IItemHandler) blockEntity.getCapability(ForgeCapabilities.ITEM_HANDLER, null).orElse(null);
                if (handler != null) {
                    Misc.spawnInventoryInWorld(level, (double) pos.m_123341_() + 0.5, (double) pos.m_123342_() + 0.5, (double) pos.m_123343_() + 0.5, handler);
                    level.updateNeighbourForOutputSignal(pos, this);
                }
            }
            super.m_6810_(pState, level, pos, pNewState, pIsMoving);
        }
    }

    @Override
    public RenderShape getRenderShape(BlockState pState) {
        return RenderShape.MODEL;
    }

    @Nullable
    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        Direction facing = context.m_43723_().isSecondaryUseActive() ? context.getNearestLookingDirection().getOpposite() : context.getNearestLookingDirection();
        return (BlockState) ((BlockState) this.m_49966_().m_61124_(BlockStateProperties.FACING, facing)).m_61124_(BlockStateProperties.WATERLOGGED, context.m_43725_().getFluidState(context.getClickedPos()).getType() == Fluids.WATER);
    }

    @Override
    public BlockState updateShape(BlockState pState, Direction pFacing, BlockState pFacingState, LevelAccessor pLevel, BlockPos pCurrentPos, BlockPos pFacingPos) {
        if ((Boolean) pState.m_61143_(BlockStateProperties.WATERLOGGED)) {
            pLevel.scheduleTick(pCurrentPos, Fluids.WATER, Fluids.WATER.m_6718_(pLevel));
        }
        return super.m_7417_(pState, pFacing, pFacingState, pLevel, pCurrentPos, pFacingPos);
    }

    @Override
    public BlockState rotate(BlockState pState, Rotation pRot) {
        return (BlockState) pState.m_61124_(BlockStateProperties.FACING, pRot.rotate((Direction) pState.m_61143_(BlockStateProperties.FACING)));
    }

    @Override
    public BlockState mirror(BlockState pState, Mirror pMirror) {
        return pState.m_60717_(pMirror.getRotation((Direction) pState.m_61143_(BlockStateProperties.FACING)));
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> pBuilder) {
        pBuilder.add(BlockStateProperties.FACING).add(FILTER).add(BlockStateProperties.WATERLOGGED);
    }

    @Override
    public BlockEntity newBlockEntity(BlockPos pPos, BlockState pState) {
        return RegistryManager.ITEM_TRANSFER_ENTITY.get().create(pPos, pState);
    }

    @Override
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level pLevel, BlockState pState, BlockEntityType<T> pBlockEntityType) {
        return pLevel.isClientSide ? null : m_152132_(pBlockEntityType, RegistryManager.ITEM_TRANSFER_ENTITY.get(), ItemTransferBlockEntity::serverTick);
    }

    @Override
    public FluidState getFluidState(BlockState pState) {
        return pState.m_61143_(BlockStateProperties.WATERLOGGED) ? Fluids.WATER.getSource(false) : super.m_5888_(pState);
    }

    @Override
    public PipeBlockEntityBase.PipeConnection getPipeConnection(BlockState state, Direction direction) {
        return PipeBlockEntityBase.PipeConnection.PIPE;
    }
}