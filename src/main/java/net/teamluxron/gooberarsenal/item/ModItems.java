package net.teamluxron.gooberarsenal.item;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.teamluxron.gooberarsenal.GooberArsenal;

public class ModItems {

    //Crafting Ingredients
    public static final Item OBSIDIAN_HILT = registerItem("obsidian_hilt", new Item(new Item.Settings()));
    public static final Item OBSIDIAN_HANDGUARD = registerItem("obsidian_handguard", new Item(new Item.Settings()));
    public static final Item CAGITE_UPGRADE_TEMPLATE = registerItem("cagite_upgrade_template", new Item(new Item.Settings()));
    public static final Item CAGITE_SCRAP = registerItem("cagite_scrap", new Item(new Item.Settings()));
    public static final Item CAGITE_INGOT = registerItem("cagite_ingot", new Item(new Item.Settings()));
    public static final Item KEVIN = registerItem("kevin", new Item(new Item.Settings()));

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, Identifier.of(GooberArsenal.MOD_ID, name), item);
    }

    public static void registerModItems() {
        GooberArsenal.LOGGER.info("Registering Mod Items for " + GooberArsenal.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(entries ->  {
            entries.add(KEVIN);
            entries.add(OBSIDIAN_HILT);
            entries.add(OBSIDIAN_HANDGUARD);
            entries.add(CAGITE_UPGRADE_TEMPLATE);
            entries.add(CAGITE_SCRAP);
            entries.add(CAGITE_INGOT);
        });
    }
}
