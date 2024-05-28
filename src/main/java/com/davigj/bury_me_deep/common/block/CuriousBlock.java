package com.davigj.bury_me_deep.common.block;

import com.davigj.bury_me_deep.common.block.entity.CuriousBlockEntity;
import com.davigj.bury_me_deep.core.registry.BMDBlockEntityTypes;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.EntityBlock;
import net.minecraft.world.level.block.Fallable;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nullable;

public class CuriousBlock extends Block implements EntityBlock, Fallable {
    Block sad;
    Block sus;

    public CuriousBlock(Properties p_49795_, Block sad, Block sus) {
        super(p_49795_);
        this.sad = sad;
        this.sus = sus;
    }

    public Block getSad() {
        return this.sad;
    }

    public Block getSus() {
        return this.sus;
    }

    @org.jetbrains.annotations.Nullable
    @Override
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return new CuriousBlockEntity(pos, state);
    }

    @SuppressWarnings("unchecked")
    @javax.annotation.Nullable
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(@NotNull Level level, @NotNull BlockState state, @NotNull BlockEntityType<T> type) {
        return createTickerHelper(type, BMDBlockEntityTypes.CURIOUS_BLOCK.get(),
                CuriousBlockEntity::tick);
    }

    @SuppressWarnings("unchecked")
    @Nullable
    private static <E extends BlockEntity, A extends BlockEntity> BlockEntityTicker<A>
    createTickerHelper(BlockEntityType<A> entityType, BlockEntityType<E> otherEntity, BlockEntityTicker<? super E> ticker) {
        return otherEntity == entityType ? (BlockEntityTicker<A>) ticker : null;
    }
}
