package com.alekiponi.homestead.common.villagers;

import com.alekiponi.homestead.Homestead;
import com.google.common.collect.ImmutableSet;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.ai.village.poi.PoiType;
import net.minecraft.world.entity.npc.VillagerProfession;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.Set;

public class HomesteadVillagerProfessions {
    public static DeferredRegister<VillagerProfession> VILLAGER_PROFESSIONS =
        DeferredRegister.create(ForgeRegistries.VILLAGER_PROFESSIONS, Homestead.MOD_ID);

    public static DeferredRegister<PoiType> POI_TYPES =
            DeferredRegister.create(ForgeRegistries.POI_TYPES, Homestead.MOD_ID);

    //TODO fix 1.20
    /*
    public static final RegistryObject<PoiType> PRIMITIVE_POI = POI_TYPES.register(
        "primitive_poi",
        () -> new PoiType(
            "primitive_poi",
            Set.of(Blocks.CRAFTING_TABLE.defaultBlockState()),
            50,
            50
        )
    );

    public static final RegistryObject <VillagerProfession> LUMBERJACK =
        VILLAGER_PROFESSIONS.register(
            "lumberjack",
            () -> new VillagerProfession(
                    "lumberjack",
                    PRIMITIVE_POI.get(),
                    ImmutableSet.of(),
                    ImmutableSet.of(),
                    SoundEvents.VILLAGER_WORK_ARMORER
            )
        );

    public static final RegistryObject <VillagerProfession> DIGGER =
            VILLAGER_PROFESSIONS.register(
                    "digger",
                    () -> new VillagerProfession(
                            "digger",
                            PRIMITIVE_POI.get(),
                            ImmutableSet.of(),
                            ImmutableSet.of(),
                            SoundEvents.VILLAGER_WORK_ARMORER
                    )
            );

    public static final RegistryObject <VillagerProfession> MINER =
            VILLAGER_PROFESSIONS.register(
                    "miner",
                    () -> new VillagerProfession(
                            "miner",
                            PRIMITIVE_POI.get(),
                            ImmutableSet.of(),
                            ImmutableSet.of(),
                            SoundEvents.VILLAGER_WORK_ARMORER
                    )
            );

    public static final RegistryObject <VillagerProfession> BUILDER =
            VILLAGER_PROFESSIONS.register(
                    "builder",
                    () -> new VillagerProfession(
                            "builder",
                            PRIMITIVE_POI.get(),
                            ImmutableSet.of(),
                            ImmutableSet.of(),
                            SoundEvents.VILLAGER_WORK_ARMORER
                    )
            );

    public static final RegistryObject <VillagerProfession> FARMER =
            VILLAGER_PROFESSIONS.register(
                    "farmer",
                    () -> new VillagerProfession(
                            "farmer",
                            PRIMITIVE_POI.get(),
                            ImmutableSet.of(),
                            ImmutableSet.of(),
                            SoundEvents.VILLAGER_WORK_ARMORER
                    )
            );

     */
}
