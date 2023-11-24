package com.alekiponi.homestead.common.entity;

import com.alekiponi.homestead.Homestead;
import com.alekiponi.homestead.common.villagers.HomesteadVillager;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.entity.*;
import net.minecraft.world.item.Item;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.event.entity.EntityJoinLevelEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class HomesteadEntities {
    public static DeferredRegister<EntityType<?>> ENTITY_TYPES =
        DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, Homestead.MOD_ID);

    public static RegistryObject<EntityType<HomesteadVillager>> VILLAGER =
        ENTITY_TYPES.register(
            "villager",
                () -> EntityType.Builder.of(HomesteadVillager::new, MobCategory.CREATURE)
                    .sized(1, 2)
                    .clientTrackingRange(10)
                    .build("tfchomestead:villager")
        );

    public static void registerAttributes(EntityAttributeCreationEvent event) {
        event.put(VILLAGER.get(), HomesteadVillager.createAttributes().build());
    }

    public static void register(IEventBus eventBus) {
        ENTITY_TYPES.register(eventBus);
    }

    public static void resetTradesOnSpawn(EntityJoinLevelEvent event) {
        //TODO fix 1.20
        /*
        if(!event.loadedFromDisk() && event.getEntity() instanceof HomesteadVillager villager) {
            villager.randomizeData();
        }*/
    }

}
