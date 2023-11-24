package com.alekiponi.homestead.common;

import com.alekiponi.homestead.Homestead;
import com.alekiponi.homestead.common.drinks.AgedAlcohol;
import com.alekiponi.homestead.common.drinks.HomesteadFluid;
import com.alekiponi.homestead.common.item.HomesteadItems;
import net.dries007.tfc.common.items.TFCItems;
import net.minecraft.core.NonNullList;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fluids.capability.IFluidHandler;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class HomesteadTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, Homestead.MOD_ID);


    public static final RegistryObject<CreativeModeTab> HOMESTEAD_TAB = CREATIVE_MODE_TABS.register("homestead_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(HomesteadItems.WALKING_CANE.get()))
                    .title(Component.translatable("creativetab.homestead_tab"))
                    .displayItems((pParameters, pOutput) -> {
                        //pOutput.accept(HomesteadItems.ITEM.get());

                    }).build());


    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register((eventBus));
    }

    //TODO Fix 1.20
    /*
    private static ItemStack getJugWith(AgedAlcohol alcohol) {
        ItemStack stack = new ItemStack(TFCItems.JUG.get(), 1);
        stack.getCapability(CapabilityFluidHandler.FLUID_HANDLER_ITEM_CAPABILITY).ifPresent(cap -> {
            cap.fill(new FluidStack(HomesteadFluid.AGED_ALCOHOL.get(alcohol).source().get(), 100), IFluidHandler.FluidAction.EXECUTE);
        });
        return stack;
    }*/
}
