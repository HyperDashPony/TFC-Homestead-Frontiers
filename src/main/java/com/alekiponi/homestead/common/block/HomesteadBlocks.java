package com.alekiponi.homestead.common.block;

import com.alekiponi.homestead.Homestead;
import com.alekiponi.homestead.common.item.HomesteadItems;
import com.alekiponi.homestead.common.drinks.AgedAlcohol;
import com.alekiponi.homestead.common.drinks.HomesteadFluid;
import net.dries007.tfc.common.blocks.ExtendedProperties;
import net.dries007.tfc.common.fluids.FlowingFluidRegistryObject;
import net.dries007.tfc.common.items.TFCItems;
import net.dries007.tfc.util.Helpers;
import net.dries007.tfc.util.registry.RegistrationHelpers;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.LiquidBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import org.jetbrains.annotations.Nullable;

import java.util.Map;
import java.util.function.Function;
import java.util.function.Supplier;

public abstract class HomesteadBlocks {
    public static DeferredRegister<Block> BLOCKS =
        DeferredRegister.create(ForgeRegistries.BLOCKS, Homestead.MOD_ID);

    public static final Map<AgedAlcohol, RegistryObject<LiquidBlock>> AGED_ALCOHOLS =
        Helpers.mapOfKeys(AgedAlcohol.class, (fluid) -> {
            return register("fluid/" + fluid.getId(), () -> {
                return new LiquidBlock(
                    ((FlowingFluidRegistryObject) HomesteadFluid.AGED_ALCOHOL.get(fluid)).source(),
                    BlockBehaviour.Properties.of(Material.WATER).noCollission().strength(100.0F).noDrops()
                );
            });
        });;

    private static <T extends Block> RegistryObject<T> register(String name, Supplier<T> blockSupplier) {
        return register(name, blockSupplier, (Function<T, ? extends BlockItem>) null);
    }
    private static <T extends Block> RegistryObject<T> register(String name, Supplier<T> blockSupplier, CreativeModeTab tab) {
        return register(name, blockSupplier, block -> new BlockItem(block, new Item.Properties().tab(tab)));
    }
    private static <T extends Block> RegistryObject<T> register(String name, Supplier<T> blockSupplier, @Nullable Function<T, ? extends BlockItem> blockItemFactory) {
        return RegistrationHelpers.registerBlock(BLOCKS, HomesteadItems.ITEMS, name, blockSupplier, blockItemFactory);
    }

    /*
    public static final Map<Grain, RegistryObject<Block>> GRAIN_PILES = Helpers.mapOfKeys(Grain.class, grain ->
        register("grain_pile/" + grain.name(), () -> new GrainPileBlock(grainPileProperties(), TFCItems.FOOD.get(grain.getFood())))
    );*/

    /*
    public static ExtendedProperties grainPileProperties()
    {
        return ExtendedProperties.of(BlockBehaviour.Properties.of(Material.GRASS).strength(0.3F).sound(SoundType.GRASS).noOcclusion()
                .isValidSpawn((a, b, c, d) -> false)
                .isRedstoneConductor((a, b, c) -> false)
                .isSuffocating((a, b, c) -> false)
                .destroyTime(3.5f)
                .isViewBlocking((a, b, c) -> false)).blockEntity(() -> HomesteadBlockEntities.GRAIN_PILE.get());
    }*/

}
