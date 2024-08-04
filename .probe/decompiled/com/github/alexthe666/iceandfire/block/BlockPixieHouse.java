package com.github.alexthe666.iceandfire.block;

import com.github.alexthe666.iceandfire.entity.tile.IafTileEntityRegistry;
import com.github.alexthe666.iceandfire.entity.tile.TileEntityPixieHouse;
import java.util.Random;
import java.util.function.Consumer;
import javax.annotation.Nullable;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.BaseEntityBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.material.MapColor;
import net.minecraftforge.client.extensions.common.IClientBlockExtensions;
import org.jetbrains.annotations.NotNull;

public class BlockPixieHouse extends BaseEntityBlock {

    public static final DirectionProperty FACING = DirectionProperty.create("facing", Direction.Plane.HORIZONTAL);

    public BlockPixieHouse() {
        super(BlockBehaviour.Properties.of().mapColor(MapColor.WOOD).instrument(NoteBlockInstrument.BASS).ignitedByLava().noOcclusion().dynamicShape().strength(2.0F, 5.0F).randomTicks());
        this.m_49959_((BlockState) ((BlockState) this.m_49965_().any()).m_61124_(FACING, Direction.NORTH));
    }

    static String name(String type) {
        return "pixie_house_%s".formatted(type);
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(FACING);
    }

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        return (BlockState) this.m_49966_().m_61124_(FACING, context.m_8125_().getOpposite());
    }

    @Override
    public void onRemove(@NotNull BlockState state, @NotNull Level worldIn, @NotNull BlockPos pos, @NotNull BlockState newState, boolean isMoving) {
        this.dropPixie(worldIn, pos);
        m_49840_(worldIn, pos, new ItemStack(this, 0));
        super.m_6810_(state, worldIn, pos, newState, isMoving);
    }

    public void updateTick(Level worldIn, BlockPos pos, BlockState state, Random rand) {
        this.checkFall(worldIn, pos);
    }

    private boolean checkFall(Level worldIn, BlockPos pos) {
        if (!this.canPlaceBlockAt(worldIn, pos)) {
            worldIn.m_46961_(pos, true);
            this.dropPixie(worldIn, pos);
            return false;
        } else {
            return true;
        }
    }

    public void initializeClient(@NotNull Consumer<IClientBlockExtensions> consumer) {
        super.initializeClient(consumer);
    }

    @NotNull
    @Override
    public RenderShape getRenderShape(@NotNull BlockState state) {
        return RenderShape.MODEL;
    }

    private boolean canPlaceBlockAt(Level worldIn, BlockPos pos) {
        return true;
    }

    public void dropPixie(Level world, BlockPos pos) {
        if (world.getBlockEntity(pos) != null && world.getBlockEntity(pos) instanceof TileEntityPixieHouse && ((TileEntityPixieHouse) world.getBlockEntity(pos)).hasPixie) {
            ((TileEntityPixieHouse) world.getBlockEntity(pos)).releasePixie();
        }
    }

    @Nullable
    @Override
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level level, @NotNull BlockState state, @NotNull BlockEntityType<T> entityType) {
        return level.isClientSide ? m_152132_(entityType, IafTileEntityRegistry.PIXIE_HOUSE.get(), TileEntityPixieHouse::tickClient) : m_152132_(entityType, IafTileEntityRegistry.PIXIE_HOUSE.get(), TileEntityPixieHouse::tickServer);
    }

    @Nullable
    @Override
    public BlockEntity newBlockEntity(@NotNull BlockPos pos, @NotNull BlockState state) {
        return new TileEntityPixieHouse(pos, state);
    }
}