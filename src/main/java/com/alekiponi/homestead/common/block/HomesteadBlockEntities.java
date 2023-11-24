package com.alekiponi.homestead.common.block;

import com.alekiponi.homestead.common.blockentity.GrainPileBlockEntity;
import net.dries007.tfc.util.Helpers;
import net.dries007.tfc.util.registry.RegistrationHelpers;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;
import java.util.stream.Stream;

import static com.alekiponi.homestead.Homestead.MOD_ID;

public abstract class HomesteadBlockEntities {
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES =
        DeferredRegister.create(ForgeRegistries.BLOCK_ENTITIES, MOD_ID);

    /*
    public static RegistryObject<BlockEntityType<GrainPileBlockEntity>> GRAIN_PILE =
        RegistrationHelpers.register(
            BLOCK_ENTITIES,
            "grain_pile",
            GrainPileBlockEntity::new,
            Stream.of(
                HomesteadBlocks.GRAIN_PILES.values()
            ).<Supplier<? extends Block>>flatMap(Helpers::flatten)
        );*/
}
