package com.alekiponi.homestead.common;

import com.alekiponi.homestead.common.drinks.AgedAlcohol;
import com.alekiponi.homestead.common.drinks.HomesteadFluid;
import com.alekiponi.homestead.common.item.HomesteadItems;
import net.dries007.tfc.common.items.TFCItems;
import net.minecraft.core.NonNullList;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fluids.capability.CapabilityFluidHandler;
import net.minecraftforge.fluids.capability.IFluidHandler;

public class HomesteadTabs {
    public static CreativeModeTab MAIN = new CreativeModeTab("tfchomestead") {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(HomesteadItems.WALKING_CANE.get(), 1);
        }

        @Override
        public void fillItemList(NonNullList<ItemStack> pItems) {
            super.fillItemList(pItems);
            for(var alcohol : AgedAlcohol.values()) {
                pItems.add(getJugWith(alcohol));
            }
        }
    };

    private static ItemStack getJugWith(AgedAlcohol alcohol) {
        ItemStack stack = new ItemStack(TFCItems.JUG.get(), 1);
        stack.getCapability(CapabilityFluidHandler.FLUID_HANDLER_ITEM_CAPABILITY).ifPresent(cap -> {
            cap.fill(new FluidStack(HomesteadFluid.AGED_ALCOHOL.get(alcohol).source().get(), 100), IFluidHandler.FluidAction.EXECUTE);
        });
        return stack;
    }
}
