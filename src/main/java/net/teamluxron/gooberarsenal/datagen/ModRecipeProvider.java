package net.teamluxron.gooberarsenal.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.item.ItemConvertible;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.RegistryWrapper;
import net.teamluxron.gooberarsenal.block.ModBlocks;
import net.teamluxron.gooberarsenal.item.ModItems;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends FabricRecipeProvider {
    public ModRecipeProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    public void generate(RecipeExporter exporter) {

        List<ItemConvertible> ANCIENT_CAGITE_SMELTABLE = List.of(ModBlocks.ANCIENT_CAGE);
        offerSmelting(exporter, ANCIENT_CAGITE_SMELTABLE, RecipeCategory.MISC, ModItems.CAGITE_SCRAP,
                0.5f, 200, "ancient_cagite_smeltable");
        offerBlasting(exporter, ANCIENT_CAGITE_SMELTABLE, RecipeCategory.MISC, ModItems.CAGITE_SCRAP,
                0.5f, 100, "ancient_cagite_smeltable");

        List<ItemConvertible> KEVIN_SMELTABLE = List.of(ModBlocks.KEVIN_ORE);
        offerSmelting(exporter, KEVIN_SMELTABLE, RecipeCategory.MISC, ModItems.KEVIN,
                0.5f, 200, "kevin_smeltable");
        offerBlasting(exporter, KEVIN_SMELTABLE, RecipeCategory.MISC, ModItems.KEVIN,
                0.5f, 100, "kevin_smeltable");

        offerReversibleCompactingRecipes(exporter, RecipeCategory.BUILDING_BLOCKS, ModItems.CAGITE_INGOT, RecipeCategory.DECORATIONS, ModBlocks.CAGITE_BLOCK);


//        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModBlocks.RAW_PINK_GARNET_BLOCK)
//                .pattern("RRR")
//                .pattern("RRR")
//                .pattern("RRR")
//                .input('R', ModItems.RAW_PINK_GARNET)
//                .criterion(hasItem(ModItems.RAW_PINK_GARNET), conditionsFromItem(ModItems.RAW_PINK_GARNET))
//                .offerTo(exporter);
//
//        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.RAW_PINK_GARNET, 9)
//                .input(ModBlocks.RAW_PINK_GARNET_BLOCK)
//                .criterion(hasItem(ModBlocks.RAW_PINK_GARNET_BLOCK), conditionsFromItem(ModBlocks.RAW_PINK_GARNET_BLOCK))
//                .offerTo(exporter);
//
//        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.RAW_PINK_GARNET, 32)
//                .input(ModBlocks.MAGIC_BLOCK)
//                .criterion(hasItem(ModBlocks.MAGIC_BLOCK), conditionsFromItem(ModBlocks.MAGIC_BLOCK))
//                .offerTo(exporter, Identifier.of(TutorialMod.MOD_ID, "raw_pink_garnet_from_magic_block"));


    }
}
