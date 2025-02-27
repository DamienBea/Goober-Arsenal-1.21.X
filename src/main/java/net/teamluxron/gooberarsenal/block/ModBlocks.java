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
    public static final Block DEEPSLATE_KEVIN_ORE = registerBlock("deepslate_kevin_ore",
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
    //These have the "registerFireBlock" thingy so their items are fireproof
    public static final Block ANCIENT_CAGE = registerFireBlock("ancient_cage",
            new Block(AbstractBlock.Settings.create()
                    .strength(4f, 6000f)
                    .requiresTool()
                    .sounds(BlockSoundGroup.ANCIENT_DEBRIS)

            ));
    public static final Block CAGITE_BLOCK = registerFireBlock("cagite_block",
            new Block(AbstractBlock.Settings.create()
                    .strength(4f, 6000f)
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
    //This is for fireproof Block Items
    private static Block registerFireBlock(String name, Block block) {
        registerFireproofBlockItem(name, block);
        return Registry.register(Registries.BLOCK, Identifier.of(GooberArsenal.MOD_ID, name), block);
    }
    private static void registerFireproofBlockItem(String name, Block block) {
        Registry.register(Registries.ITEM, Identifier.of(GooberArsenal.MOD_ID, name),
                new BlockItem(block, new Item.Settings().fireproof()));
    }


    public static void registerModBlocks() {
        GooberArsenal.LOGGER.info("Registering Mod Blocks for" + GooberArsenal.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.BUILDING_BLOCKS).register(entries -> {

        });
    }
}
