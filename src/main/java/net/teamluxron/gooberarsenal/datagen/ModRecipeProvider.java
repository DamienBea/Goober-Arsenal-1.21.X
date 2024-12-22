package net.teamluxron.gooberarsenal.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.command.argument.ItemStringReader;
import net.minecraft.data.server.recipe.*;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.ItemTags;
import net.minecraft.util.Identifier;
import net.teamluxron.gooberarsenal.GooberArsenal;
import net.teamluxron.gooberarsenal.block.ModBlocks;
import net.teamluxron.gooberarsenal.item.ModItems;


import javax.xml.transform.Result;
import java.util.List;
import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends FabricRecipeProvider {
    public ModRecipeProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    public void generate(RecipeExporter exporter) {

        List<ItemConvertible> WOODSTUFF = List.of(Blocks.ACACIA_LOG, Blocks.ACACIA_WOOD, Blocks.BIRCH_LOG, Blocks.BIRCH_WOOD,
                Blocks.OAK_LOG, Blocks.OAK_WOOD, Blocks.SPRUCE_LOG, Blocks.SPRUCE_WOOD, Blocks.JUNGLE_LOG, Blocks.JUNGLE_WOOD,
                Blocks.DARK_OAK_LOG, Blocks.DARK_OAK_WOOD, Blocks.MANGROVE_LOG, Blocks.MANGROVE_WOOD, Blocks.CHERRY_LOG,
                Blocks.CHERRY_WOOD, Blocks.CRIMSON_STEM, Blocks.CRIMSON_HYPHAE, Blocks.WARPED_HYPHAE, Blocks.WARPED_STEM,
                Blocks.STRIPPED_ACACIA_LOG, Blocks.STRIPPED_ACACIA_WOOD, Blocks.STRIPPED_BIRCH_LOG, Blocks.STRIPPED_BIRCH_WOOD,
                Blocks.STRIPPED_OAK_LOG, Blocks.STRIPPED_OAK_WOOD, Blocks.STRIPPED_SPRUCE_LOG, Blocks.STRIPPED_SPRUCE_WOOD,
                Blocks.STRIPPED_JUNGLE_LOG, Blocks.STRIPPED_JUNGLE_WOOD, Blocks.STRIPPED_DARK_OAK_LOG, Blocks.STRIPPED_DARK_OAK_WOOD,
                Blocks.STRIPPED_MANGROVE_LOG, Blocks.STRIPPED_MANGROVE_WOOD, Blocks.STRIPPED_CHERRY_LOG,
                Blocks.STRIPPED_CHERRY_WOOD, Blocks.STRIPPED_CRIMSON_STEM, Blocks.STRIPPED_CRIMSON_HYPHAE, Blocks.STRIPPED_WARPED_HYPHAE,
                Blocks.STRIPPED_WARPED_STEM
                );

        //Smelting Recipes
        List<ItemConvertible> ANCIENT_CAGITE_SMELTABLE = List.of(ModBlocks.ANCIENT_CAGE);
        offerSmelting(exporter, ANCIENT_CAGITE_SMELTABLE, RecipeCategory.MISC, ModItems.CAGITE_SCRAP,
                0.5f, 200, "ancient_cagite_smeltable");
        offerBlasting(exporter, ANCIENT_CAGITE_SMELTABLE, RecipeCategory.MISC, ModItems.CAGITE_SCRAP,
                0.5f, 100, "ancient_cagite_smeltable");

        List<ItemConvertible> KEVIN_SMELTABLE = List.of(ModBlocks.KEVIN_ORE);
        offerSmelting(exporter, KEVIN_SMELTABLE, RecipeCategory.MISC, ModItems.KEVIN_SHARD,
                0.5f, 200, "kevin_smeltable");
        offerBlasting(exporter, KEVIN_SMELTABLE, RecipeCategory.MISC, ModItems.KEVIN_SHARD,
                0.5f, 100, "kevin_smeltable");

        offerReversibleCompactingRecipes(exporter, RecipeCategory.BUILDING_BLOCKS, ModItems.CAGITE_INGOT, RecipeCategory.DECORATIONS, ModBlocks.CAGITE_BLOCK);
        offerReversibleCompactingRecipes(exporter, RecipeCategory.BUILDING_BLOCKS, ModItems.KEVIN_SHARD, RecipeCategory.DECORATIONS, ModBlocks.KEVIN_BLOCK);

        //Shapless Recipes
        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.CAGITE_INGOT, 9)
                .input(ModBlocks.CAGITE_BLOCK)
                .criterion(hasItem(ModBlocks.CAGITE_BLOCK), conditionsFromItem(ModBlocks.CAGITE_BLOCK))
                .offerTo(exporter, Identifier.of(GooberArsenal.MOD_ID, "cagite_from_block"));

        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.CAGITE_INGOT, 1)
                .input(ModItems.CAGITE_SCRAP, 4)
                .input(ModItems.KEVIN_SHARD, 4)
                .criterion(hasItem(ModItems.CAGITE_SCRAP), conditionsFromItem(ModItems.CAGITE_SCRAP))
                .offerTo(exporter, Identifier.of(GooberArsenal.MOD_ID, "cagite_from_scrap"));

        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.OBSIDIAN_HILT)
                .input(ModItems.OBSIDIAN_HANDGUARD)
                .input(Items.BLAZE_ROD)
                .criterion(hasItem(ModItems.OBSIDIAN_HANDGUARD), conditionsFromItem(Items.BLAZE_ROD))
                .offerTo(exporter, Identifier.of(GooberArsenal.MOD_ID, "obsidian_hilt"));

        //Shaped Recipes
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.IRON_PLATE, 3)
                .pattern("RRR")
                .input('R', Items.IRON_INGOT)
                .criterion(hasItem(Items.IRON_INGOT), conditionsFromItem(Items.IRON_INGOT))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.OBSIDIAN_HANDGUARD)
//                .pattern("   ")
                .pattern("OCO")
//                .pattern("   ")
                .input('O', Items.OBSIDIAN)
                .input('C', ModItems.CAGITE_INGOT)
                .criterion(hasItem(ModItems.CAGITE_INGOT), conditionsFromItem(Blocks.OBSIDIAN))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.STEEL_PIPE)
                .pattern(" II")
                .pattern(" I ")
                .pattern(" D ")
                .input('I', Items.IRON_INGOT)
                .input('D', Items.DRIED_KELP)
                .criterion(hasItem(Items.IRON_INGOT), conditionsFromItem(Items.DRIED_KELP))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.CHAIR)
                .pattern("PPP")
                .pattern("PIP")
                .pattern("P P")
                .input('I', Items.IRON_INGOT)
                .input('P', ModItems.IRON_PLATE)
                .criterion(hasItem(Items.IRON_INGOT), conditionsFromItem(ModItems.IRON_PLATE))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.FRYING_PAN)
                .pattern(" I ")
                .pattern("IPI")
                .pattern("DI ")
                .input('I', Items.IRON_INGOT)
                .input('P', ModItems.IRON_PLATE)
                .input('D', Items.DRIED_KELP)
                .criterion(hasItem(Items.IRON_INGOT), conditionsFromItem(ModItems.IRON_PLATE))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.WOODEN_BAT)
                .pattern("  L")
                .pattern(" L ")
                .pattern("D  ")
                .input('L', ItemTags.LOGS)
                .input('D', Items.DRIED_KELP)
                .criterion(hasItem(Items.DRIED_KELP), conditionsFromItem(Items.DRIED_KELP))
                .offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.IRON_BAT)
                .pattern("  L")
                .pattern(" L ")
                .pattern("D  ")
                .input('L', Items.IRON_INGOT)
                .input('D', Items.DRIED_KELP)
                .criterion(hasItem(Items.IRON_INGOT), conditionsFromItem(Items.IRON_INGOT))
                .offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.GOLDEN_BAT)
                .pattern("  L")
                .pattern(" L ")
                .pattern("D  ")
                .input('L', Items.GOLD_INGOT)
                .input('D', Items.DRIED_KELP)
                .criterion(hasItem(Items.GOLD_INGOT), conditionsFromItem(Items.GOLD_INGOT))
                .offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.DIAMOND_BAT)
                .pattern("  L")
                .pattern(" L ")
                .pattern("D  ")
                .input('L', Items.DIAMOND)
                .input('D', Items.DRIED_KELP)
                .criterion(hasItem(Items.DIAMOND), conditionsFromItem(Items.DIAMOND))
                .offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.GOOBER_UPGRADE_TEMPLATE, 2)
                .pattern("KKK")
                .pattern("KGK")
                .pattern("KNK")
                .input('K', ModItems.KEVIN_SHARD)
                .input('G', ModItems.GOOBER_UPGRADE_TEMPLATE)
                .input('N', Items.NETHERRACK)
                .criterion(hasItem(ModItems.GOOBER_UPGRADE_TEMPLATE), conditionsFromItem(ModItems.GOOBER_UPGRADE_TEMPLATE))
                .offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.SPOON)
                .pattern(" P ")
                .pattern(" I ")
                .pattern(" I ")
                .input('P', ModItems.IRON_PLATE)
                .input('I', Items.IRON_INGOT)
                .criterion(hasItem(ModItems.IRON_PLATE), conditionsFromItem(Items.IRON_INGOT))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.LIFE_SABER)
                .pattern("GKB")
                .pattern("KLK")
                .pattern("BKG")
                .input('L', ModItems.LIFE_SAVER)
                .input('K', ModBlocks.KEVIN_BLOCK)
                .input('B', Items.BLUE_DYE)
                .input('G', Items.GREEN_DYE)
                .criterion(hasItem(ModItems.LIFE_SAVER), conditionsFromItem(ModBlocks.KEVIN_BLOCK))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.KENDO_STICK)
                .pattern(" B ")
                .pattern(" B ")
                .pattern(" S ")
                .input('B', Items.BAMBOO)
                .input('S', Items.STRING)
                .criterion(hasItem(Items.BAMBOO), conditionsFromItem(Items.STRING))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.BUSINESS_CASE)
                .pattern(" P ")
                .pattern("P P")
                .pattern(" P ")
                .input('P', ModItems.IRON_PLATE)
                .criterion(hasItem(ModItems.IRON_PLATE), conditionsFromItem(ModItems.IRON_PLATE))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.CONTRABAND_CASE)
                .pattern("KKK")
                .pattern("KCK")
                .pattern("KKK")
                .input('K', ModBlocks.KEVIN_BLOCK)
                .input('C', ModItems.BUSINESS_CASE)
                .criterion(hasItem(ModBlocks.KEVIN_BLOCK), conditionsFromItem(ModBlocks.KEVIN_BLOCK))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.SANDVICH)
                .pattern(" B ")
                .pattern("CPS")
                .pattern(" B ")
                .input('B', Items.BREAD)
                .input('C', Items.COOKED_PORKCHOP)
                .input('P', Items.BAKED_POTATO)
                .input('S', Items.COOKED_BEEF)
                .criterion(hasItem(Items.BREAD), conditionsFromItem(Items.BREAD))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.CHOCOLATE_CHIP_PANCAKES)
                .pattern("SCS")
                .pattern("WWW")
                .pattern("   ")
                .input('W', Items.WHEAT)
                .input('C', Items.COCOA_BEANS)
                .input('S', Items.SUGAR)
                .criterion(hasItem(Items.WHEAT), conditionsFromItem(Items.WHEAT))
                .offerTo(exporter);

        //Smithing Recipes
        SmithingTransformRecipeJsonBuilder.create(
                Ingredient.ofItems(ModItems.GOOBER_UPGRADE_TEMPLATE),
                Ingredient.ofItems(ModItems.NETHERITE_BAT),
                Ingredient.ofItems(Items.BEE_NEST),
                RecipeCategory.MISC,
                ModItems.BEE_BUNNY_BASHER)
                .criterion(hasItem(ModItems.NETHERITE_BAT), conditionsFromItem(ModItems.NETHERITE_BAT))
                .offerTo(exporter, "bbb_from_nest");

        SmithingTransformRecipeJsonBuilder.create(
                        Ingredient.ofItems(ModItems.GOOBER_UPGRADE_TEMPLATE),
                        Ingredient.ofItems(ModItems.NETHERITE_BAT),
                        Ingredient.ofItems(Items.BEEHIVE),
                        RecipeCategory.MISC,
                        ModItems.BEE_BUNNY_BASHER)
                .criterion(hasItem(ModItems.NETHERITE_BAT), conditionsFromItem(ModItems.NETHERITE_BAT))
                .offerTo(exporter, "bbb_from_hive");

        SmithingTransformRecipeJsonBuilder.create(
                        Ingredient.ofItems(ModItems.GOOBER_UPGRADE_TEMPLATE),
                        Ingredient.ofItems(ModItems.NETHERITE_BAT),
                        Ingredient.ofItems(Items.RABBIT_FOOT),
                        RecipeCategory.MISC,
                        ModItems.BEE_BUNNY_BASHER)
                .criterion(hasItem(ModItems.NETHERITE_BAT), conditionsFromItem(ModItems.NETHERITE_BAT))
                .offerTo(exporter, "bbb_from_foot");

        SmithingTransformRecipeJsonBuilder.create(
                        Ingredient.ofItems(ModItems.GOOBER_UPGRADE_TEMPLATE),
                        Ingredient.ofItems(ModItems.OBSIDIAN_HILT),
                        Ingredient.ofItems(Items.LAVA_BUCKET),
                        RecipeCategory.MISC,
                        ModItems.OBSIDIAN_SWORD)
                .criterion(hasItem(ModItems.OBSIDIAN_HANDGUARD), conditionsFromItem(ModItems.OBSIDIAN_HANDGUARD))
                .offerTo(exporter, "obsidian_sword_smithing");

        SmithingTransformRecipeJsonBuilder.create(
                        Ingredient.ofItems(ModItems.GOOBER_UPGRADE_TEMPLATE),
                        Ingredient.ofItems(ModItems.NETHERITE_BAT),
                        Ingredient.ofItems(ModItems.RUBBER_CHICKEN),
                        RecipeCategory.MISC,
                        ModItems.SLAPSTICK_SWORD)
                .criterion(hasItem(ModItems.RUBBER_CHICKEN), conditionsFromItem(ModItems.RUBBER_CHICKEN))
                .offerTo(exporter, "slapstick_sword_smithing");

        SmithingTransformRecipeJsonBuilder.create(
                        Ingredient.ofItems(ModItems.GOOBER_UPGRADE_TEMPLATE),
                        Ingredient.ofItems(Items.DIAMOND_AXE),
                        Ingredient.ofItems(Items.CAKE),
                        RecipeCategory.MISC,
                        ModItems.FESTIVE_AXE)
                .criterion(hasItem(Items.DIAMOND_AXE), conditionsFromItem(Items.DIAMOND_AXE))
                .offerTo(exporter, "festive_axe_smithing");

        SmithingTransformRecipeJsonBuilder.create(
                        Ingredient.ofItems(Items.NETHERITE_UPGRADE_SMITHING_TEMPLATE),
                        Ingredient.ofItems(ModItems.DIAMOND_BAT),
                        Ingredient.ofItems(Items.NETHERITE_INGOT),
                        RecipeCategory.MISC,
                        ModItems.NETHERITE_BAT)
                .criterion(hasItem(ModItems.DIAMOND_BAT), conditionsFromItem(ModItems.DIAMOND_BAT))
                .offerTo(exporter, "netherite_bat_smithing");

        SmithingTransformRecipeJsonBuilder.create(
                        Ingredient.ofItems(ModItems.GOOBER_UPGRADE_TEMPLATE),
                        Ingredient.ofItems(ModItems.STEEL_PIPE),
                        Ingredient.ofItems(ModItems.CAGITE_INGOT),
                        RecipeCategory.MISC,
                        ModItems.STAHP_SIGN)
                .criterion(hasItem(ModItems.CAGITE_INGOT), conditionsFromItem(ModItems.CAGITE_INGOT))
                .offerTo(exporter, "stahp_sign_smithing");

        SmithingTransformRecipeJsonBuilder.create(
                        Ingredient.ofItems(ModItems.GOOBER_UPGRADE_TEMPLATE),
                        Ingredient.ofItems(Items.DIAMOND_HELMET),
                        Ingredient.ofItems(ModItems.CAGITE_INGOT),
                        RecipeCategory.MISC,
                        ModItems.CAGITE_HELMET)
                .criterion(hasItem(Items.DIAMOND_HELMET), conditionsFromItem(Items.DIAMOND_HELMET))
                .offerTo(exporter, "cagite_helmet_smithing");

        SmithingTransformRecipeJsonBuilder.create(
                        Ingredient.ofItems(ModItems.GOOBER_UPGRADE_TEMPLATE),
                        Ingredient.ofItems(Items.DIAMOND_CHESTPLATE),
                        Ingredient.ofItems(ModItems.CAGITE_INGOT),
                        RecipeCategory.MISC,
                        ModItems.CAGITE_CHESTPLATE)
                .criterion(hasItem(Items.DIAMOND_CHESTPLATE), conditionsFromItem(Items.DIAMOND_CHESTPLATE))
                .offerTo(exporter, "cagite_chestplate_smithing");

        SmithingTransformRecipeJsonBuilder.create(
                        Ingredient.ofItems(ModItems.GOOBER_UPGRADE_TEMPLATE),
                        Ingredient.ofItems(Items.DIAMOND_LEGGINGS),
                        Ingredient.ofItems(ModItems.CAGITE_INGOT),
                        RecipeCategory.MISC,
                        ModItems.CAGITE_LEGGINGS)
                .criterion(hasItem(Items.DIAMOND_LEGGINGS), conditionsFromItem(Items.DIAMOND_LEGGINGS))
                .offerTo(exporter, "cagite_leggings_smithing");

        SmithingTransformRecipeJsonBuilder.create(
                        Ingredient.ofItems(ModItems.GOOBER_UPGRADE_TEMPLATE),
                        Ingredient.ofItems(Items.DIAMOND_BOOTS),
                        Ingredient.ofItems(ModItems.CAGITE_INGOT),
                        RecipeCategory.MISC,
                        ModItems.CAGITE_BOOTS)
                .criterion(hasItem(Items.DIAMOND_BOOTS), conditionsFromItem(Items.DIAMOND_BOOTS))
                .offerTo(exporter, "cagite_boots_smithing");














    }
}
