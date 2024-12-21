package net.teamluxron.gooberarsenal.item;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.teamluxron.gooberarsenal.GooberArsenal;
import net.teamluxron.gooberarsenal.block.ModBlocks;

public class ModItemGroups {
    public static final ItemGroup GOOBERARSENAL_WEAPONS = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(GooberArsenal.MOD_ID, "gooberarsenal_weapons"),
            FabricItemGroup.builder()
                    .icon(() -> new ItemStack(ModItems.FRYING_PAN))
                    .displayName(Text.translatable("itemgroup.gooberarsenal.gooberarsenal_weapons"))
                    .entries((displayContext, entries) -> {
                        entries.add(ModItems.WOODEN_BAT);
                        entries.add(ModItems.IRON_BAT);
                        entries.add(ModItems.GOLDEN_BAT);
                        entries.add(ModItems.DIAMOND_BAT);
                        entries.add(ModItems.NETHERITE_BAT);
                        entries.add(ModItems.BEE_BUNNY_BASHER);
                        entries.add(ModItems.SPOON);
                        entries.add(ModItems.FRYING_PAN);
                        entries.add(ModItems.STEEL_PIPE);
                        entries.add(ModItems.CHAIR);
                        entries.add(ModItems.FESTIVE_AXE);
                        entries.add(ModItems.LIFE_SABER);
                        entries.add(ModItems.OBSIDIAN_SWORD);
                        entries.add(ModItems.STAHP_SIGN);

                        //entries.add(ModItems.BANANADE);
                    })
                    .build());
    public static final ItemGroup GOOBERARSENAL_ITEMS = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(GooberArsenal.MOD_ID, "gooberarsenal_items"),
            FabricItemGroup.builder()
                    .icon(() -> new ItemStack(ModItems.GOOBER_UPGRADE_TEMPLATE))
                    .displayName(Text.translatable("itemgroup.gooberarsenal.gooberarsenal_items"))
                    .entries((displayContext, entries) -> {
                        entries.add(ModItems.GOOBER_UPGRADE_TEMPLATE);
                        entries.add(ModItems.IRON_PLATE);
                        entries.add(ModItems.KEVIN_SHARD);
                        entries.add(ModItems.CAGITE_SCRAP);
                        entries.add(ModItems.CAGITE_INGOT);
                        entries.add(ModItems.OBSIDIAN_HANDGUARD);
                        entries.add(ModItems.OBSIDIAN_HILT);
                        entries.add(ModItems.LIFE_SAVER);
                    })
                    .build());

    public static final ItemGroup GOOBERARSENAL_BLOCKS = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(GooberArsenal.MOD_ID, "gooberarsenal_blocks"),
            FabricItemGroup.builder()
                    .icon(() -> new ItemStack(ModBlocks.KEVIN_BLOCK))
                    .displayName(Text.translatable("itemgroup.gooberarsenal.gooberarsenal_blocks"))
                    .entries((displayContext, entries) -> {
                        entries.add(ModBlocks.KEVIN_ORE);
                        entries.add(ModBlocks.KEVIN_BLOCK);
                        entries.add(ModBlocks.ANCIENT_CAGE);
                        entries.add(ModBlocks.CAGITE_BLOCK);
                    })
                    .build());

    public static final ItemGroup GOOBERARSENAL_CONSUMABLES = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(GooberArsenal.MOD_ID, "gooberarsenal_consumables"),
            FabricItemGroup.builder()
                    .icon(() -> new ItemStack(ModItems.SWITCH_CARTRIDGE))
                    .displayName(Text.translatable("itemgroup.gooberarsenal.gooberarsenal_consumables"))
                    .entries((displayContext, entries) -> {
                        entries.add(ModItems.SWITCH_CARTRIDGE);
                    })
                    .build());






    public static void registerItemGroups() {
        GooberArsenal.LOGGER.info("Registering Item Groups for" + GooberArsenal.MOD_ID);
    }
}
