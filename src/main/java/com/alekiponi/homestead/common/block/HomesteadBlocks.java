package com.alekiponi.homestead.common.block;

import com.alekiponi.homestead.Homestead;
import com.alekiponi.homestead.common.item.HomesteadItems;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.eventbus.api.IEventBus;
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

    /*
    public static final Map<AgedAlcohol, RegistryObject<LiquidBlock>> AGED_ALCOHOLS =
        Helpers.mapOfKeys(AgedAlcohol.class, (fluid) -> {
            return register("fluid/" + fluid.getId(), () -> {
                return new LiquidBlock(
                    ((FlowingFluidRegistryObject) HomesteadFluid.AGED_ALCOHOL.get(fluid)).source(),
                    BlockBehaviour.Properties.of(Material.WATER).noCollission().strength(100.0F).noDrops()
                );
            });
        });;

     */

    private static <T extends Block> RegistryObject<T> registerBlockWithoutItem(String name, Supplier<T> block) {
        return BLOCKS.register(name, block);
    }

    private static <T extends Block> RegistryObject<T> registerBlockWithItem(String name, Supplier<T> block) {
        RegistryObject<T> blockRegistryObject = BLOCKS.register(name, block);
        registerBlockItem(name, blockRegistryObject);
        return blockRegistryObject;
    }

    private static <T extends Block> void registerBlockItem(String name, RegistryObject<T> block) {
        HomesteadItems.ITEMS.register(name, () -> new BlockItem(block.get(),
                new Item.Properties()));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }

}
