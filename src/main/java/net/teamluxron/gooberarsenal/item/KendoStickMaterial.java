package net.teamluxron.gooberarsenal.item;

import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.item.Items;
import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;
import net.minecraft.registry.tag.TagKey;

public class KendoStickMaterial implements ToolMaterial {

    @Override
    public int getDurability() {
        return 3;
    }

    @Override
    public float getMiningSpeedMultiplier() {
        return 2.0f;
    }

    @Override
    public float getAttackDamage() {
        return 8.0f;
    }

    @Override
    public TagKey<Block> getInverseTag() {
        return null;
    }

    @Override
    public int getEnchantability() {
        return 5;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return Ingredient.ofItems(Items.BAMBOO);
    }

    public static final KendoStickMaterial INSTANCE = new KendoStickMaterial();

}

