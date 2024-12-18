package net.teamluxron.gooberarsenal.block;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.teamluxron.gooberarsenal.GooberArsenal;

public class ModBlocks {

    public static final Block KEVIN_ORE = registerBlock("kevin_ore",
            new Block(AbstractBlock.Settings.create()
                    .strength(2f)
                    .requiresTool()
                    .sounds(BlockSoundGroup.STONE)
            ));
    public static final Block KEVIN_BLOCK = registerBlock("kevin_block",
            new Block(AbstractBlock.Settings.create()
                    .strength(2f)
                    .requiresTool()
                    .sounds(BlockSoundGroup.AMETHYST_BLOCK)
            ));
    public static final Block ANCIENT_CAGE = registerBlock("ancient_cage",
            new Block(AbstractBlock.Settings.create()
                    .strength(4f)
                    .requiresTool()
                    .sounds(BlockSoundGroup.ANCIENT_DEBRIS)
            ));
    public static final Block CAGITE_BLOCK = registerBlock("cagite_block",
            new Block(AbstractBlock.Settings.create()
                    .strength(4f)
                    .requiresTool()
                    .sounds(BlockSoundGroup.NETHERITE)
            ));

    private static Block registerBlock(String name, Block block) {
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, Identifier.of(GooberArsenal.MOD_ID, name), block);
    }

    private static void registerBlockItem(String name, Block block) {
        Registry.register(Registries.ITEM, Identifier.of(GooberArsenal.MOD_ID, name),
            new BlockItem(block, new Item.Settings()));
    }


    public static void registerModBlocks() {
        GooberArsenal.LOGGER.info("Registering Mod Blocks for" + GooberArsenal.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.BUILDING_BLOCKS).register(entries -> {
            entries.add(ModBlocks.KEVIN_ORE);
            entries.add(ModBlocks.KEVIN_BLOCK);
            entries.add(ModBlocks.ANCIENT_CAGE);
            entries.add(ModBlocks.CAGITE_BLOCK);
        });
    }
}
