package com.alekiponi.homestead.common;

import com.alekiponi.homestead.Homestead;
import com.alekiponi.homestead.common.item.HomesteadItems;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class HomesteadTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, Homestead.MOD_ID);


    public static final RegistryObject<CreativeModeTab> HOMESTEAD_TAB = CREATIVE_MODE_TABS.register("homestead_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(HomesteadItems.WALKING_CANE.get()))
                    .title(Component.translatable("creativetab.homestead_tab"))
                    .displayItems((pParameters, pOutput) -> {
                        pOutput.accept(HomesteadItems.WALKING_CANE.get());
                        pOutput.accept(HomesteadItems.REFINED_WALKING_CANE.get());

                    }).build());


    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register((eventBus));
    }
}
