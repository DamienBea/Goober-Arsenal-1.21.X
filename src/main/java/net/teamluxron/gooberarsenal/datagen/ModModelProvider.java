package net.teamluxron.gooberarsenal.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.client.Models;
import net.teamluxron.gooberarsenal.block.ModBlocks;
import net.teamluxron.gooberarsenal.item.ModItems;

public class ModModelProvider extends FabricModelProvider {
    public ModModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.ANCIENT_CAGE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.CAGITE_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.KEVIN_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.KEVIN_BLOCK);

    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        itemModelGenerator.register(ModItems.OBSIDIAN_HILT, Models.GENERATED);
        itemModelGenerator.register(ModItems.OBSIDIAN_HANDGUARD, Models.GENERATED);

        itemModelGenerator.register(ModItems.KEVIN_SHARD, Models.GENERATED);
        itemModelGenerator.register(ModItems.CAGITE_SCRAP, Models.GENERATED);
        itemModelGenerator.register(ModItems.CAGITE_UPGRADE_TEMPLATE, Models.GENERATED);
        itemModelGenerator.register(ModItems.CAGITE_INGOT, Models.GENERATED);
        itemModelGenerator.register(ModItems.IRON_PLATE, Models.GENERATED);
        itemModelGenerator.register(ModItems.SWITCH_CARTRIDGE, Models.GENERATED);
    }
}
