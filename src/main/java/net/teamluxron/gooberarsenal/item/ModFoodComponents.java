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

            .build()
            ;

//    public static final FoodComponent GRILLED_CHEESE

}
