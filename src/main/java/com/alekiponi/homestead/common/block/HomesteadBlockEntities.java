package com.alekiponi.homestead.common.block;

import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import static com.alekiponi.homestead.Homestead.MOD_ID;

public abstract class HomesteadBlockEntities {
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITY_TYPES =
        DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, MOD_ID);

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
