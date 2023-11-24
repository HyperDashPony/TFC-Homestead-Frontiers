package com.alekiponi.homestead.client.renderers;

import net.minecraftforge.eventbus.api.IEventBus;


import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;


public class ClientEvents {
    public static void init() {
        final IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
    }

    //TODO fix 1.20
    /*
    public static void addTooltipsToItem(ItemTooltipEvent event) {
        ItemStack stack = event.getItemStack();
        stack.getCapability(CapabilityFluidHandler.FLUID_HANDLER_ITEM_CAPABILITY).ifPresent(cap -> {
            FluidStack fluidStack = cap.getFluidInTank(0);
            if(!fluidStack.isEmpty()) {
                event.getToolTip().add(new TranslatableComponent(fluidStack.getTranslationKey()).withStyle(ChatFormatting.GRAY));
                var fluid = HomesteadFluid.AGED_ALCOHOL.inverse().keySet().stream().filter(f ->
                    f.getSource() == fluidStack.getFluid()
                ).findAny();
                fluid.ifPresent(f -> {
                    event.getToolTip().add(HomesteadFluid.AGED_ALCOHOL.inverse().get(f).getTooltip());
                });
            }
        });
    }*/
}
