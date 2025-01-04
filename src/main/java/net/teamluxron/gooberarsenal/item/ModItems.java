package net.teamluxron.gooberarsenal.item;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.*;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import net.teamluxron.gooberarsenal.GooberArsenal;

import java.util.List;
import java.util.function.Consumer;

public class ModItems {

    //Weapons

    public static final Item FRYING_PAN = registerItem("frying_pan",
            new SwordItem(ToolMaterials.IRON, new Item.Settings()
                    .attributeModifiers(SwordItem.createAttributeModifiers(ToolMaterials.IRON, 9, -3.5f))));

    public static final Item STEEL_PIPE = registerItem("steel_pipe",
            new SwordItem(ToolMaterials.IRON, new Item.Settings()
                    .attributeModifiers(SwordItem.createAttributeModifiers(ToolMaterials.IRON, 5, -2.6f))));

    public static final Item CHAIR = registerItem("chair",
            new SwordItem(ChairMaterial.INSTANCE, new Item.Settings()
                    .attributeModifiers(SwordItem.createAttributeModifiers(ChairMaterial.INSTANCE, 1, -3f))));

    public static final Item BEE_BUNNY_BASHER = registerItem("bee_bunny_basher",
            new SwordItem(CagiteMaterial.INSTANCE, new Item.Settings().fireproof()
                    .attributeModifiers(SwordItem.createAttributeModifiers(CagiteMaterial.INSTANCE, 1, -2))){
                @Override
                public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, TooltipType type) {
                    tooltip.add(Text.translatable("tooltip.gooberarsenal.bee_bunny_basher"));
                    super.appendTooltip(stack, context, tooltip, type);
                }
                public boolean postHit(ItemStack stack, LivingEntity target, LivingEntity attacker) {
                    if (target instanceof LivingEntity) {
                        target.addStatusEffect(new StatusEffectInstance(StatusEffects.POISON, 40));
                        target.addStatusEffect(new StatusEffectInstance(StatusEffects.SLOW_FALLING, 40));
                        Vec3d direction = target.getPos().subtract(attacker.getPos()).normalize();
                        target.addVelocity(direction.x * 0.5, 0.1, direction.z * 0.5);
                    }
                    return super.postHit(stack, target, attacker);
                }
                public void inventoryTick(ItemStack stack, World world, Entity entity, int slot, boolean selected) {
                    if (entity instanceof PlayerEntity player && selected) {
                        player.addStatusEffect(new StatusEffectInstance(StatusEffects.SPEED, 20, 1, true, false));
                        player.addStatusEffect(new StatusEffectInstance(StatusEffects.JUMP_BOOST, 20, 0, true, false));
                    }
                    super.inventoryTick(stack, world, entity, slot, selected);
                }

            });

    public static final Item STAHP_SIGN = registerItem("stahp_sign",
            new SwordItem(CagiteMaterial.INSTANCE, new Item.Settings().fireproof()
                    .attributeModifiers(SwordItem.createAttributeModifiers(CagiteMaterial.INSTANCE, 1, -2.5f))){
    @Override
    public boolean postHit(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        if (target instanceof LivingEntity) {
            target.addStatusEffect(new StatusEffectInstance(StatusEffects.BLINDNESS, 60));
            target.addStatusEffect(new StatusEffectInstance(StatusEffects.SLOWNESS, 60));
        }
        return super.postHit(stack, target, attacker);
    }
});

    public static final Item WOODEN_BAT = registerItem("wooden_bat",
            new SwordItem(ToolMaterials.WOOD, new Item.Settings()
                    .attributeModifiers(SwordItem.createAttributeModifiers(ToolMaterials.WOOD, 2, -2))){

                @Override
                public boolean postHit(ItemStack stack, LivingEntity target, LivingEntity attacker) {
                    if (target instanceof LivingEntity) {
                        Vec3d direction = target.getPos().subtract(attacker.getPos()).normalize();
                        target.addVelocity(direction.x * 0.5, 0.1, direction.z * 0.5);
                    }
                    return super.postHit(stack, target, attacker);
                }
            });

    public static final Item IRON_BAT = registerItem("iron_bat",
            new SwordItem(ToolMaterials.IRON, new Item.Settings()
                    .attributeModifiers(SwordItem.createAttributeModifiers(ToolMaterials.IRON, 2, -2))){

        @Override
        public boolean postHit(ItemStack stack, LivingEntity target, LivingEntity attacker) {
            if (target instanceof LivingEntity) {
                Vec3d direction = target.getPos().subtract(attacker.getPos()).normalize();
                target.addVelocity(direction.x * 0.5, 0.1, direction.z * 0.5);
            }
            return super.postHit(stack, target, attacker);
        }
    });

    public static final Item GOLDEN_BAT = registerItem("golden_bat",
            new SwordItem(ToolMaterials.GOLD, new Item.Settings()
                    .attributeModifiers(SwordItem.createAttributeModifiers(ToolMaterials.GOLD, 2, -2))){

                @Override
                public boolean postHit(ItemStack stack, LivingEntity target, LivingEntity attacker) {
                    if (target instanceof LivingEntity) {
                        Vec3d direction = target.getPos().subtract(attacker.getPos()).normalize();
                        target.addVelocity(direction.x * 0.5, 0.1, direction.z * 0.5);
                    }
                    return super.postHit(stack, target, attacker);
                }
            });

    public static final Item DIAMOND_BAT = registerItem("diamond_bat",
            new SwordItem(ToolMaterials.DIAMOND, new Item.Settings()
                    .attributeModifiers(SwordItem.createAttributeModifiers(ToolMaterials.DIAMOND, 2, -2))){

                @Override
                public boolean postHit(ItemStack stack, LivingEntity target, LivingEntity attacker) {
                    if (target instanceof LivingEntity) {
                        Vec3d direction = target.getPos().subtract(attacker.getPos()).normalize();
                        target.addVelocity(direction.x * 0.5, 0.1, direction.z * 0.5);
                    }
                    return super.postHit(stack, target, attacker);
                }
            });

    public static final Item NETHERITE_BAT = registerItem("netherite_bat",
            new SwordItem(ToolMaterials.NETHERITE, new Item.Settings().fireproof()
                    .attributeModifiers(SwordItem.createAttributeModifiers(ToolMaterials.NETHERITE, 2, -2))){

                @Override
                public boolean postHit(ItemStack stack, LivingEntity target, LivingEntity attacker) {
                    if (target instanceof LivingEntity) {
                        Vec3d direction = target.getPos().subtract(attacker.getPos()).normalize();
                        target.addVelocity(direction.x * 0.5, 0.1, direction.z * 0.5);
                    }
                    return super.postHit(stack, target, attacker);
                }
            });

    public static final Item OBSIDIAN_SWORD = registerItem("obsidian_sword",
            new SwordItem(ObsidianSwordMaterial.INSTANCE, new Item.Settings().fireproof()
                    .attributeModifiers(SwordItem.createAttributeModifiers(ObsidianSwordMaterial.INSTANCE, 3, -3))) {
    @Override
    public void inventoryTick(ItemStack stack, World world, Entity entity, int slot, boolean selected) {
        if (entity instanceof PlayerEntity player && selected) {
            player.addStatusEffect(new StatusEffectInstance(StatusEffects.FIRE_RESISTANCE, 20, 0, true, false));
        }
        super.inventoryTick(stack, world, entity, slot, selected);
    }
                public boolean postHit(ItemStack stack, LivingEntity target, LivingEntity attacker) {
                    if (target instanceof LivingEntity) {
                        target.setOnFireFor(5);
                    }
                    return super.postHit(stack, target, attacker);
                }
});

    public static final Item SPOON = registerItem("spoon",
            new ShovelItem(ToolMaterials.IRON, new Item.Settings().fireproof()
                    .attributeModifiers(SwordItem.createAttributeModifiers(ToolMaterials.IRON, 5, -3f))));

    public static final Item FESTIVE_AXE = registerItem("festive_axe",
            new AxeItem(ToolMaterials.DIAMOND, new Item.Settings()
                    .attributeModifiers(SwordItem.createAttributeModifiers(ToolMaterials.DIAMOND, 5, -3f))){
                @Override
                public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, TooltipType type) {
                    tooltip.add(Text.translatable("tooltip.gooberarsenal.festive_axe"));
                    super.appendTooltip(stack, context, tooltip, type);
                }
            });

    public static final Item LIFE_SABER = registerItem("life_saber",
            new SwordItem(KevinMaterial.INSTANCE, new Item.Settings()
                    .attributeModifiers(SwordItem.createAttributeModifiers(KevinMaterial.INSTANCE, -1, 2))) {
                public void inventoryTick(ItemStack stack, World world, Entity entity, int slot, boolean selected) {
                if (entity instanceof PlayerEntity player && selected) {
                    player.addStatusEffect(new StatusEffectInstance(StatusEffects.WATER_BREATHING, 20, 0, true, false));
                    player.addStatusEffect(new StatusEffectInstance(StatusEffects.DOLPHINS_GRACE, 20, 1, true, false));
                }
                super.inventoryTick(stack, world, entity, slot, selected);
            }

            });

    public static final Item KENDO_STICK = registerItem("kendo_stick",
            new SwordItem(KendoStickMaterial.INSTANCE, new Item.Settings()
                    .attributeModifiers(SwordItem.createAttributeModifiers(KendoStickMaterial.INSTANCE, 0, -2.4f))));

    public static final Item SLAPSTICK_SWORD = registerItem("slapstick_sword",
            new SwordItem(CagiteMaterial.INSTANCE, new Item.Settings().fireproof()
                    .attributeModifiers(SwordItem.createAttributeModifiers(CagiteMaterial.INSTANCE, 1, -2))){
                @Override
                public boolean postHit(ItemStack stack, LivingEntity target, LivingEntity attacker) {
                    if (target instanceof LivingEntity) {
                        target.addStatusEffect(new StatusEffectInstance(StatusEffects.NAUSEA, 60));
                        target.addStatusEffect(new StatusEffectInstance(StatusEffects.SLOWNESS, 60));
                        target.addStatusEffect(new StatusEffectInstance(StatusEffects.JUMP_BOOST, 60, 2));
                    }
                    return super.postHit(stack, target, attacker);
                }
            });

    //Shields

    public static final Item ROSE_QUARTZ_SHIELD = registerItem("rose_quartz_shield",
            new RoseQuartzShield(new Item.Settings().maxDamage(500).fireproof()));







    //Crafting Ingredients
    public static final Item OBSIDIAN_HILT = registerItem("obsidian_hilt", new Item(new Item.Settings().fireproof()));
    public static final Item OBSIDIAN_HANDGUARD = registerItem("obsidian_handguard", new Item(new Item.Settings().fireproof()));
    public static final Item GOOBER_UPGRADE_TEMPLATE = registerItem("goober_upgrade_template", new Item(new Item.Settings().fireproof()));
    public static final Item CAGITE_SCRAP = registerItem("cagite_scrap", new Item(new Item.Settings().fireproof()));
    public static final Item CAGITE_INGOT = registerItem("cagite_ingot", new Item(new Item.Settings().fireproof()));
    public static final Item KEVIN_SHARD = registerItem("kevin_shard", new Item(new Item.Settings()));
    public static final Item IRON_PLATE = registerItem("iron_plate", new Item(new Item.Settings()));
    public static final Item LIFE_SAVER = registerItem("life_saver", new Item(new Item.Settings()));
    public static final Item RUBBER_CHICKEN = registerItem("rubber_chicken", new Item(new Item.Settings()));
//    public static final Item BUSINESS_CASE = registerItem("business_case", new Item(new Item.Settings()));

    //Armor
    public static final Item CAGITE_HELMET = registerItem("cagite_helmet",
            new ArmorItem(ModArmorMaterials.CAGITE_ARMOR_MATERIAL, ArmorItem.Type.HELMET, new Item.Settings()
                    .maxDamage(ArmorItem.Type.HELMET.getMaxDamage(37))));
    public static final Item CAGITE_CHESTPLATE = registerItem("cagite_chestplate",
            new ArmorItem(ModArmorMaterials.CAGITE_ARMOR_MATERIAL, ArmorItem.Type.CHESTPLATE, new Item.Settings()
                    .maxDamage(ArmorItem.Type.CHESTPLATE.getMaxDamage(37))));
    public static final Item CAGITE_LEGGINGS = registerItem("cagite_leggings",
            new ArmorItem(ModArmorMaterials.CAGITE_ARMOR_MATERIAL, ArmorItem.Type.LEGGINGS, new Item.Settings()
                    .maxDamage(ArmorItem.Type.LEGGINGS.getMaxDamage(37))));
    public static final Item CAGITE_BOOTS = registerItem("cagite_boots",
            new ArmorItem(ModArmorMaterials.CAGITE_ARMOR_MATERIAL, ArmorItem.Type.BOOTS, new Item.Settings()
                    .maxDamage(ArmorItem.Type.BOOTS.getMaxDamage(37))));

    //Consumables
    public static final Item SWITCH_CARTRIDGE = registerItem("switch_cartridge", new Item(new Item.Settings().food(ModFoodComponents.SWITCH_CARTRIDGE).fireproof()){
        @Override
        public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, TooltipType type) {
            tooltip.add(Text.translatable("tooltip.gooberarsenal.switch_cartridge"));
            super.appendTooltip(stack, context, tooltip, type);
        }});
    public static final Item ENERGY_BAR = registerItem("energy_bar", new Item(new Item.Settings().food(ModFoodComponents.ENERGY_BAR).rarity(Rarity.EPIC)));
    public static final Item SANDVICH = registerItem("sandvich", new Item(new Item.Settings().food(ModFoodComponents.SANDVICH)));
    public static final Item CHOCOLATE_CHIP_PANCAKES = registerItem("chocolate_chip_pancakes", new Item(new Item.Settings().food(ModFoodComponents.CHOCOLATE_CHIP_PANCAKES)));
    public static final Item COPPER_APPLE = registerItem("copper_apple", new Item(new Item.Settings().food(ModFoodComponents.COPPER_APPLE)));

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, Identifier.of(GooberArsenal.MOD_ID, name), item);
    }

    public static void registerModItems() {
        GooberArsenal.LOGGER.info("Registering Mod Items for " + GooberArsenal.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(entries ->  {
        });
    }
}
