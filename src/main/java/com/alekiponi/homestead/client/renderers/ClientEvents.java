package com.alekiponi.homestead.client.renderers;

import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.event.entity.player.ItemTooltipEvent;
import net.minecraftforge.eventbus.api.IEventBus;


import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

import net.dries007.tfc.common.capabilities.Capabilities;


public class ClientEvents {
    public static void init() {
        final IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
    }

    //TODO fix 1.20
//    public static void addTooltipsToItem(ItemTooltipEvent event) {
//        ItemStack stack = event.getItemStack();
//        stack.getCapability(Capabilities.FLUID_ITEM).ifPresent(cap -> {
//            FluidStack fluidStack = cap.getFluidInTank(0);
//            if(!fluidStack.isEmpty()) {
//                event.getToolTip().add(Component.translatable(fluidStack.getTranslationKey()).withStyle(ChatFormatting.GRAY));
//                var fluid = HomesteadFluid.AGED_ALCOHOL.inverse().keySet().stream().filter(f ->
//                    f.getSource() == fluidStack.getFluid()
//                ).findAny();
//                fluid.ifPresent(f -> {
//                    event.getToolTip().add(HomesteadFluid.AGED_ALCOHOL.inverse().get(f).getTooltip());
//                });
//            }
//        });
//    }
}
