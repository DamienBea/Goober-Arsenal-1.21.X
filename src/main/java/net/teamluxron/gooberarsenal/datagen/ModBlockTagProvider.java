package net.teamluxron.gooberarsenal.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.BlockTags;
import net.teamluxron.gooberarsenal.block.ModBlocks;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagProvider extends FabricTagProvider.BlockTagProvider {

    public ModBlockTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup wrapperLookup) {
        getOrCreateTagBuilder(BlockTags.PICKAXE_MINEABLE)
                .add(ModBlocks.KEVIN_ORE)
                .add(ModBlocks.KEVIN_BLOCK)
                .add(ModBlocks.DEEPSLATE_KEVIN_ORE)
                .add(ModBlocks.ANCIENT_CAGE)
                .add(ModBlocks.CAGITE_BLOCK)

        ;

        getOrCreateTagBuilder(BlockTags.NEEDS_IRON_TOOL)
                .add(ModBlocks.KEVIN_ORE)
                .add(ModBlocks.DEEPSLATE_KEVIN_ORE)
                .add(ModBlocks.KEVIN_BLOCK)

        ;

        getOrCreateTagBuilder(BlockTags.NEEDS_DIAMOND_TOOL)
                .add(ModBlocks.ANCIENT_CAGE)
                .add(ModBlocks.CAGITE_BLOCK)
        ;
    }
}
