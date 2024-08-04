package com.github.alexthe666.iceandfire.block;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.material.PushReaction;
import org.jetbrains.annotations.NotNull;

public class BlockReturningState extends Block {

    public static final BooleanProperty REVERTS = BooleanProperty.create("revert");

    private final BlockState returnState;

    public static BlockReturningState builder(float hardness, float resistance, SoundType sound, boolean slippery, MapColor color, NoteBlockInstrument instrument, PushReaction reaction, boolean ignited, BlockState returnToState) {
        BlockBehaviour.Properties props = BlockBehaviour.Properties.of().mapColor(color).sound(sound).strength(hardness, resistance).friction(0.98F).randomTicks();
        if (instrument != null) {
            props.instrument(instrument);
        }
        if (reaction != null) {
            props.pushReaction(reaction);
        }
        if (ignited) {
            props.ignitedByLava();
        }
        return new BlockReturningState(props, returnToState);
    }

    public static BlockReturningState builder(float hardness, float resistance, SoundType sound, MapColor color, NoteBlockInstrument instrument, PushReaction reaction, boolean ignited, BlockState returnToState) {
        BlockBehaviour.Properties props = BlockBehaviour.Properties.of().mapColor(color).sound(sound).strength(hardness, resistance).randomTicks();
        if (instrument != null) {
            props.instrument(instrument);
        }
        if (reaction != null) {
            props.pushReaction(reaction);
        }
        if (ignited) {
            props.ignitedByLava();
        }
        return new BlockReturningState(props, returnToState);
    }

    public BlockReturningState(BlockBehaviour.Properties props, BlockState returnToState) {
        super(props);
        this.returnState = returnToState;
        this.m_49959_((BlockState) ((BlockState) this.f_49792_.any()).m_61124_(REVERTS, Boolean.FALSE));
    }

    @Override
    public void tick(@NotNull BlockState state, ServerLevel worldIn, @NotNull BlockPos pos, @NotNull RandomSource rand) {
        if (!worldIn.f_46443_) {
            if (!worldIn.isAreaLoaded(pos, 3)) {
                return;
            }
            if ((Boolean) state.m_61143_(REVERTS) && rand.nextInt(3) == 0) {
                worldIn.m_46597_(pos, this.returnState);
            }
        }
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(REVERTS);
    }
}