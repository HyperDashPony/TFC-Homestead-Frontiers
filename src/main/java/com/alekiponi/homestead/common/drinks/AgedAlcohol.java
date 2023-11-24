package com.alekiponi.homestead.common.drinks;

import net.dries007.tfc.util.Helpers;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.item.alchemy.Potions;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import java.util.Locale;

public enum AgedAlcohol {
    BEER(-3957193, MobEffects.ABSORPTION, 1, 24000),

    CIDER(-5198286, MobEffects.MOVEMENT_SPEED, 0, 6400),
    RUM(-9567965, MobEffects.MOVEMENT_SPEED, 1, 3200),

    SAKE(-4728388, MobEffects.DAMAGE_RESISTANCE, 0, 6400),
    VODKA(-2302756, MobEffects.DAMAGE_RESISTANCE, 1, 3200),

    WHISKEY(-10995943, MobEffects.DIG_SPEED, 1, 3200),
    CORN_WHISKEY(-2504777, MobEffects.DIG_SPEED, 0, 6400),
    RYE_WHISKEY(-3703471, MobEffects.DIG_SPEED, 0, 6400);

    private final String id;
    private final int color;
    private final MobEffect effect;
    private final int effectPotency;
    private final int effectDuration;

    AgedAlcohol(int color, MobEffect effect, int effectPotency, int effectDuration) {
        this.id = "aged_" + this.name().toLowerCase(Locale.ROOT);
        this.effect = effect;
        this.effectPotency = effectPotency;
        this.effectDuration = effectDuration;
        this.color = color;
    }

    public String getId() {
        return this.id;
    }

    public int getColor() {
        return this.color;
    }

    public MobEffect getEffect() {
        return effect;
    }

    public int getEffectDuration() {
        return effectDuration;
    }

    public int getEffectPotency() {
        return effectPotency;
    }

    private String toMinutes(int ticks) {
        int seconds = ticks / 20;
        int minutes = seconds / 60;
        int extraSeconds = seconds % 60;

        return minutes + ":" + extraSeconds;
    }

    public String displayedPotency() {
        return switch(effectPotency + 1) {
            case 1 -> "I";
            case 2 -> "II";
            case 3 -> "III";
            default -> "";
        };
    }

    //TODO fix 1.20
    /*
    @OnlyIn(Dist.CLIENT)
    public Component getTooltip() {

        return Helpers.literal(effect.getDisplayName().getString() + " " + (displayedPotency()) + " (" + toMinutes(effectDuration) + ")").withStyle(ChatFormatting.GRAY);
    }*/

    public MobEffectInstance getEffectInstance() {
        return new MobEffectInstance(this.effect, this.effectDuration, this.effectPotency);
    }
}
