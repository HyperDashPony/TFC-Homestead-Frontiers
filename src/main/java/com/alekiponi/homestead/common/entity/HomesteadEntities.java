package com.alekiponi.homestead.common.entity;

import com.alekiponi.homestead.Homestead;
import com.alekiponi.homestead.common.villagers.HomesteadVillager;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.entity.*;
import net.minecraft.world.item.Item;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class HomesteadEntities {
    public static DeferredRegister<EntityType<?>> ENTITIES =
        DeferredRegister.create(ForgeRegistries.ENTITIES, Homestead.MOD_ID);

    public static RegistryObject<EntityType<HomesteadVillager>> VILLAGER =
        ENTITIES.register(
            "villager",
                () -> EntityType.Builder.of(HomesteadVillager::new, MobCategory.CREATURE)
                    .sized(1, 2)
                    .clientTrackingRange(10)
                    .build("tfchomestead:villager")
        );

    public static void registerAttributes(EntityAttributeCreationEvent event) {
        event.put(VILLAGER.get(), HomesteadVillager.createAttributes().build());
    }

    public static void resetTradesOnSpawn(EntityJoinWorldEvent event) {
        if(!event.loadedFromDisk() && event.getEntity() instanceof HomesteadVillager villager) {
            villager.randomizeData();
        }
    }

    public static final TagKey<Item> RAW_HIDES =
            TagKey.create(Registry.ITEM_REGISTRY, new ResourceLocation("tfc", "raw_hides"));

}
