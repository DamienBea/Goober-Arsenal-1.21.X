package net.teamluxron.gooberarsenal.item;

import net.minecraft.component.type.FoodComponent;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;

public class ModFoodComponents {
    public static final FoodComponent SWITCH_CARTRIDGE = new FoodComponent.Builder().nutrition(0).saturationModifier(0.25f).alwaysEdible()
            .statusEffect(new StatusEffectInstance(StatusEffects.POISON, 200), 0.70f)
            .statusEffect(new StatusEffectInstance(StatusEffects.DARKNESS, 200), 0.70f)
            .statusEffect(new StatusEffectInstance(StatusEffects.BLINDNESS, 200), 0.70f)
            .statusEffect(new StatusEffectInstance(StatusEffects.NAUSEA, 200), 0.70f)
            .statusEffect(new StatusEffectInstance(StatusEffects.SLOWNESS, 200), 0.70f)
            .build();

    public static final FoodComponent CONTRABAND_CASE = new FoodComponent.Builder().nutrition(6).saturationModifier(1f).alwaysEdible()
            .statusEffect(new StatusEffectInstance(StatusEffects.REGENERATION, 200, 1), 1)
            .statusEffect(new StatusEffectInstance(StatusEffects.ABSORPTION, 200, 1), 1)
            .statusEffect(new StatusEffectInstance(StatusEffects.SPEED, 400, 1), 1)
            .statusEffect(new StatusEffectInstance(StatusEffects.RESISTANCE, 400, 3), 1)
            .statusEffect(new StatusEffectInstance(StatusEffects.FIRE_RESISTANCE, 400, 0), 1)
            .build();

    public static final FoodComponent SANDVICH = new FoodComponent.Builder().nutrition(8).saturationModifier(1f).alwaysEdible()
            .statusEffect(new StatusEffectInstance(StatusEffects.INSTANT_HEALTH, 20, 1), 1)
            .build();

    public static final FoodComponent CHOCOLATE_CHIP_PANCAKES = new FoodComponent.Builder().nutrition(6).saturationModifier(1f)
            .build();

//    public static final FoodComponent GRILLED_CHEESE

}
