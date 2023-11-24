package com.alekiponi.homestead.common.item;

import com.alekiponi.homestead.Homestead;
import com.alekiponi.homestead.common.HomesteadTabs;
import net.dries007.tfc.common.items.ToolItem;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.*;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class HomesteadItems {
    public static DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, Homestead.MOD_ID);

    public static final RegistryObject<Item> WALKING_CANE = ITEMS.register("walking_cane",
            () -> new Item(new Item.Properties().stacksTo(1).durability(100)));

    public static final RegistryObject<Item> REFINED_WALKING_CANE = ITEMS.register("refined_walking_cane",
            () -> new Item(new Item.Properties().stacksTo(1).durability(400)));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }


}
