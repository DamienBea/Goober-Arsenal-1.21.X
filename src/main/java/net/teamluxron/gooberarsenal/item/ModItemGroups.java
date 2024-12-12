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
    public static final ItemGroup GOOBERARSENAL_ITEMS = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(GooberArsenal.MOD_ID, "gooberarsenal_items"),
            FabricItemGroup.builder()
                    .icon(() -> new ItemStack(ModItems.CAGITE_UPGRADE_TEMPLATE))
                    .displayName(Text.translatable("itemgroup.gooberarsenal.gooberarsenal_items"))
                    .entries((displayContext, entries) -> {
                        entries.add(ModItems.OBSIDIAN_HILT);
                        entries.add(ModItems.OBSIDIAN_HANDGUARD);
                        entries.add(ModItems.CAGITE_UPGRADE_TEMPLATE);
                        entries.add(ModItems.CAGITE_SCRAP);
                        entries.add(ModItems.CAGITE_INGOT);
                        entries.add(ModItems.KEVIN);
                    })
                    .build());

    public static final ItemGroup GOOBERARSENAL_BLOCKS = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(GooberArsenal.MOD_ID, "gooberarsenal_blocks"),
            FabricItemGroup.builder()
                    .icon(() -> new ItemStack(ModItems.CAGITE_UPGRADE_TEMPLATE))
                    .displayName(Text.translatable("itemgroup.gooberarsenal.gooberarsenal_blocks"))
                    .entries((displayContext, entries) -> {
                        entries.add(ModBlocks.ANCIENT_CAGE);
                        entries.add(ModBlocks.CAGITE_BLOCK);
                        entries.add(ModBlocks.KEVIN_ORE);
                    })
                    .build());




    public static void registerItemGroups() {
        GooberArsenal.LOGGER.info("Registering Item Groups for" + GooberArsenal.MOD_ID);
    }
}
