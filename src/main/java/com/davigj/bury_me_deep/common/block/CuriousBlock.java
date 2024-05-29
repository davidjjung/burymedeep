package com.davigj.bury_me_deep.common.block;

import com.davigj.bury_me_deep.common.block.entity.CuriousBlockEntity;
import com.davigj.bury_me_deep.core.registry.BMDBlockEntityTypes;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.BlockParticleOption;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nullable;

public class CuriousBlock extends Block implements EntityBlock, Fallable {
    public static final IntegerProperty DUSTED = BlockStateProperties.DUSTED;
    Block sad;
    Block sus;

    public CuriousBlock(Properties p_49795_, Block sad, Block sus) {
        super(p_49795_);
        this.sad = sad;
        this.sus = sus;
        this.registerDefaultState(this.stateDefinition.any().setValue(DUSTED, 3));
    }

    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> p_277623_) {
        p_277623_.add(DUSTED);
    }

    public Block getSad() {
        return this.sad;
    }

    public Block getSus() {
        return this.sus;
    }

    public void animateTick(BlockState p_277390_, Level p_277525_, BlockPos p_278107_, RandomSource p_277574_) {
        if (p_277574_.nextInt(16) == 0) {
            BlockPos blockpos = p_278107_.below();
            if (FallingBlock.isFree(p_277525_.getBlockState(blockpos))) {
                double d0 = (double)p_278107_.getX() + p_277574_.nextDouble();
                double d1 = (double)p_278107_.getY() - 0.05D;
                double d2 = (double)p_278107_.getZ() + p_277574_.nextDouble();
                p_277525_.addParticle(new BlockParticleOption(ParticleTypes.FALLING_DUST, p_277390_), d0, d1, d2, 0.0D, 0.0D, 0.0D);
            }
        }

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
