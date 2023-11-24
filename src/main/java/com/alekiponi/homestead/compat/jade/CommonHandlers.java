package com.alekiponi.homestead.compat.jade;

import net.dries007.tfc.compat.jade.common.BlockEntityTooltip;
import net.minecraft.world.level.block.Block;

import java.util.LinkedList;
import java.util.List;
import java.util.function.BiConsumer;

public class CommonHandlers {
    public static void register(BiConsumer<BlockEntityTooltip, Class<? extends Block>> registerBlock)
    {
        //registerBlock.accept(FOOD_HOLDER, HomesteadBlock.class);
    }

    //TODO fix 1.20
    /*
    public static final BlockEntityTooltip FOOD_HOLDER = (level, state, pos, entity, tooltip) -> {
        if (entity instanceof FoodHolderBlockEntity holder && !holder.getStack().isEmpty())
        {
            holder.getStack().getCapability(FoodCapability.CAPABILITY).ifPresent(cap -> {
                List<Component> components = new LinkedList<>();
                holder.updatePreservation();
                tooltip.accept(new TextComponent(holder.getStack().getDisplayName().getString() + " x " + holder.getStack().getCount()));
                if(ClientHelpers.hasShiftDown()) {
                    cap.addTooltipInfo(holder.getStack(), components);
                    for(var component : components) {
                        tooltip.accept(component);
                    }
                }
            });
        }
    };*/
}
