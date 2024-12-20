package net.teamluxron.gooberarsenal.item;

import net.fabricmc.fabric.api.item.v1.FabricItem;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.teamluxron.gooberarsenal.GooberArsenal;

public class ModItems {

    //Weapons

    public static final Item FRYING_PAN = registerItem("frying_pan",
            new SwordItem(ToolMaterials.IRON, new Item.Settings()
                    .attributeModifiers(SwordItem.createAttributeModifiers(ToolMaterials.IRON, 3, -2.4f))));
    public static final Item STEEL_PIPE = registerItem("steel_pipe",
            new SwordItem(ToolMaterials.IRON, new Item.Settings()
                    .attributeModifiers(SwordItem.createAttributeModifiers(ToolMaterials.IRON, 3, -2.4f))));
    public static final Item CHAIR = registerItem("chair",
            new SwordItem(ToolMaterials.IRON, new Item.Settings()
                    .attributeModifiers(SwordItem.createAttributeModifiers(ToolMaterials.IRON, 3, -2.4f))));
    public static final Item DIAMOND_SWORDED = registerItem("diamond_sworded",
            new SwordItem(ToolMaterials.DIAMOND, new Item.Settings()
                    .attributeModifiers(SwordItem.createAttributeModifiers(ToolMaterials.DIAMOND, 5, -2.4f))));
    public static final Item BEE_BUNNY_BASHER = registerItem("bee_bunny_basher",
            new SwordItem(ToolMaterials.DIAMOND, new Item.Settings()
                    .attributeModifiers(SwordItem.createAttributeModifiers(ToolMaterials.DIAMOND, 4, -2.4f))));
    public static final Item STAHP_SIGN = registerItem("stahp_sign",
            new SwordItem(ToolMaterials.DIAMOND, new Item.Settings()
                    .attributeModifiers(SwordItem.createAttributeModifiers(ToolMaterials.DIAMOND, 4, -2.4f))));
    public static final Item WOODEN_BAT = registerItem("wooden_bat",
            new SwordItem(ToolMaterials.WOOD, new Item.Settings()
                    .attributeModifiers(SwordItem.createAttributeModifiers(ToolMaterials.DIAMOND, 4, -2.4f))));
    public static final Item IRON_BAT = registerItem("iron_bat",
            new SwordItem(ToolMaterials.IRON, new Item.Settings()
                    .attributeModifiers(SwordItem.createAttributeModifiers(ToolMaterials.DIAMOND, 4, -2.4f))));
    public static final Item GOLDEN_BAT = registerItem("golden_bat",
            new SwordItem(ToolMaterials.GOLD, new Item.Settings()
                    .attributeModifiers(SwordItem.createAttributeModifiers(ToolMaterials.DIAMOND, 4, -2.4f))));
    public static final Item DIAMOND_BAT = registerItem("diamond_bat",
            new SwordItem(ToolMaterials.DIAMOND, new Item.Settings()
                    .attributeModifiers(SwordItem.createAttributeModifiers(ToolMaterials.DIAMOND, 4, -2.4f))));
    public static final Item NETHERITE_BAT = registerItem("netherite_bat",
            new SwordItem(ToolMaterials.NETHERITE, new Item.Settings()
                    .attributeModifiers(SwordItem.createAttributeModifiers(ToolMaterials.DIAMOND, 4, -2.4f))));


    //Crafting Ingredients
    public static final Item OBSIDIAN_HILT = registerItem("obsidian_hilt", new Item(new Item.Settings()));
    public static final Item OBSIDIAN_HANDGUARD = registerItem("obsidian_handguard", new Item(new Item.Settings()));
    public static final Item CAGITE_UPGRADE_TEMPLATE = registerItem("cagite_upgrade_template", new Item(new Item.Settings()));
    public static final Item CAGITE_SCRAP = registerItem("cagite_scrap", new Item(new Item.Settings()));
    public static final Item CAGITE_INGOT = registerItem("cagite_ingot", new Item(new Item.Settings()));
    public static final Item KEVIN_SHARD = registerItem("kevin_shard", new Item(new Item.Settings()));
    public static final Item IRON_PLATE = registerItem("iron_plate", new Item(new Item.Settings()));
public static final Item SWITCH_CARTRIDGE = registerItem("switch_cartridge", new Item(new Item.Settings().food(ModFoodComponents.SWITCH_CARTRIDGE)));

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, Identifier.of(GooberArsenal.MOD_ID, name), item);
    }

    public static void registerModItems() {
        GooberArsenal.LOGGER.info("Registering Mod Items for " + GooberArsenal.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(entries ->  {
            entries.add(KEVIN_SHARD);
            entries.add(OBSIDIAN_HILT);
            entries.add(OBSIDIAN_HANDGUARD);
            entries.add(CAGITE_UPGRADE_TEMPLATE);
            entries.add(CAGITE_SCRAP);
            entries.add(CAGITE_INGOT);
            entries.add(IRON_PLATE);
            entries.add(SWITCH_CARTRIDGE);
            entries.add(FRYING_PAN);
            entries.add(DIAMOND_SWORDED);
            entries.add(BEE_BUNNY_BASHER);
            entries.add(STAHP_SIGN);
            entries.add(STEEL_PIPE);
            entries.add(CHAIR);
            entries.add(WOODEN_BAT);
            entries.add(IRON_BAT);
            entries.add(GOLDEN_BAT);
            entries.add(DIAMOND_BAT);
            entries.add(NETHERITE_BAT);
        });
    }
}
