package com.alekiponi.homestead;

import com.alekiponi.homestead.client.renderers.ClientEvents;
import com.alekiponi.homestead.common.HomesteadTabs;
import com.alekiponi.homestead.common.block.HomesteadBlocks;
import com.alekiponi.homestead.common.entity.HomesteadEntities;
import com.alekiponi.homestead.common.item.HomesteadItems;
import com.alekiponi.homestead.common.villagers.HomesteadVillager;
import com.alekiponi.homestead.common.villagers.HomesteadVillagerProfessions;
import com.alekiponi.homestead.common.world.HomesteadFeatures;
import com.mojang.logging.LogUtils;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.InterModComms;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.InterModEnqueueEvent;
import net.minecraftforge.fml.event.lifecycle.InterModProcessEvent;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fml.loading.FMLEnvironment;
import org.slf4j.Logger;

import java.util.stream.Collectors;

// The value here should match an entry in the META-INF/mods.toml file
@Mod("homestead")
public class Homestead
{
    public static final String MOD_ID = "homestead";
    private static final Logger LOGGER = LogUtils.getLogger();

    public Homestead()
    {

        IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();

        if(FMLEnvironment.dist == Dist.CLIENT) {
            ClientEvents.init();
        }
        // Register the setup method for modloading
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
        // Register the enqueueIMC method for modloading
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::enqueueIMC);
        // Register the processIMC method for modloading
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::processIMC);

        HomesteadVillagerProfessions.POI_TYPES.register(eventBus);
        HomesteadVillagerProfessions.VILLAGER_PROFESSIONS.register(eventBus);
        HomesteadFeatures.FEATURES.register(eventBus);
        HomesteadTabs.register(eventBus);
        HomesteadItems.register(eventBus);
        HomesteadBlocks.register(eventBus);
        //HomesteadEntities.register(eventBus);
        HomesteadEntities.ENTITY_TYPES.register(eventBus);

        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);
    }

    private void setup(final FMLCommonSetupEvent event)
    {
        // some preinit code
        LOGGER.info("HELLO FROM PREINIT");
        LOGGER.info("DIRT BLOCK >> {}", Blocks.DIRT.getName());
    }

    private void enqueueIMC(final InterModEnqueueEvent event)
    {
        // Some example code to dispatch IMC to another mod
        InterModComms.sendTo("homestead", "helloworld", () -> { LOGGER.info("Hello world from the MDK"); return "Hello world";});
    }

    private void processIMC(final InterModProcessEvent event)
    {
        // Some example code to receive and process InterModComms from other mods
        LOGGER.info("Got IMC {}", event.getIMCStream().
                map(m->m.messageSupplier().get()).
                collect(Collectors.toList()));
    }

    // You can use SubscribeEvent and let the Event Bus discover methods to call
    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event)
    {
        // Do something when the server starts
        LOGGER.info("HELLO from server starting");
    }

}
