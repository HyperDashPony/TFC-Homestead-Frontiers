package com.alekiponi.homestead;

import com.alekiponi.homestead.client.renderers.ClientEvents;
import com.alekiponi.homestead.common.HomesteadTabs;
import com.alekiponi.homestead.common.api.StoredTrait;
import com.alekiponi.homestead.common.block.HomesteadBlocks;
import com.alekiponi.homestead.common.entity.HomesteadEntities;
import com.alekiponi.homestead.common.item.HomesteadItems;
import com.alekiponi.homestead.common.villagers.HomesteadVillagerProfessions;
import com.alekiponi.homestead.common.world.HomesteadFeatures;
import com.mojang.logging.LogUtils;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fml.loading.FMLEnvironment;
import org.slf4j.Logger;

@Mod("homestead")
public class Homestead
{
    public static final String MOD_ID = "homestead";
    private static final Logger LOGGER = LogUtils.getLogger();

    public Homestead()
    {
        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
        bus.addListener(this::setup);

        if (FMLEnvironment.dist == Dist.CLIENT)
        {
            ClientEvents.init();
        }
        HomesteadVillagerProfessions.POI_TYPES.register(bus);
        HomesteadVillagerProfessions.VILLAGER_PROFESSIONS.register(bus);
        HomesteadFeatures.FEATURES.register(bus);
        HomesteadTabs.register(bus);
        HomesteadItems.register(bus);
        HomesteadBlocks.register(bus);
        //HomesteadEntities.register(eventBus);
        HomesteadEntities.ENTITY_TYPES.register(bus);

        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);
    }

    public void setup(FMLCommonSetupEvent event)
    {
        StoredTrait.init();
    }

    public static ResourceLocation identifier(String path)
    {
        return new ResourceLocation(MOD_ID, path);
    }
}
