package com.alekiponi.homestead.common.item;

import com.alekiponi.homestead.Homestead;
import com.alekiponi.homestead.common.HomesteadTabs;
import net.dries007.tfc.common.items.ToolItem;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.*;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class HomesteadItems {
    public static DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, Homestead.MOD_ID);

    public static RegistryObject<Item> WALKING_CANE = ITEMS.register(
            "walking_cane",
            () -> new ToolItem(
                    Tiers.WOOD,
                    0,
                    0,
                    TagKey.create(Registry.BLOCK_REGISTRY, new ResourceLocation("tfchomestead", "mineable/walking_cane")),
                    new Item.Properties().tab(HomesteadTabs.MAIN)
            )
    );

    public static RegistryObject<Item> REFINED_WALKING_CANE = ITEMS.register(
            "refined_walking_cane",
            () -> new ToolItem(
                    Tiers.IRON,
                    0,
                    0,
                    TagKey.create(Registry.BLOCK_REGISTRY, new ResourceLocation("tfchomestead", "mineable/walking_cane")),
                    new Item.Properties().tab(HomesteadTabs.MAIN)
            )
    );

}
