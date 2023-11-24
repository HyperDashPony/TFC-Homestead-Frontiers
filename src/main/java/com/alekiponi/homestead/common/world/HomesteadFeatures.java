package com.alekiponi.homestead.common.world;

import com.alekiponi.homestead.Homestead;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class HomesteadFeatures {
    public static final DeferredRegister<Feature<?>> FEATURES = DeferredRegister.create(
        ForgeRegistries.FEATURES,
        Homestead.MOD_ID
    );

    public static final RegistryObject<VillagerHomesteadFeature> MUD_HUT_FEATURE =
        FEATURES.register("villager_homestead", () -> new VillagerHomesteadFeature(VillagerHomesteadConfig.CODEC));

}
