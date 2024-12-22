package net.teamluxron.gooberarsenal.world;

import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.structure.rule.RuleTest;
import net.minecraft.structure.rule.TagMatchRuleTest;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.FeatureConfig;
import net.minecraft.world.gen.feature.OreFeatureConfig;
import net.teamluxron.gooberarsenal.GooberArsenal;
import net.teamluxron.gooberarsenal.block.ModBlocks;

import java.util.List;

public class ModConfiguredFeatures {
//    public static final RegistryKey<ConfiguredFeature<?, ?>> KEVIN_ORE_KEY = registerKey("kevin_ore_key");
//    public static final RegistryKey<ConfiguredFeature<?, ?>> ANCIENT_CAGITE_KEY = registerKey("ancient_cagite_key");

    public static void bootstrap(Registerable<ConfiguredFeature<?, ?>> context) {
        RuleTest stoneReplaceables = new TagMatchRuleTest(BlockTags.STONE_ORE_REPLACEABLES);
        RuleTest deepslateReplaceables = new TagMatchRuleTest(BlockTags.DEEPSLATE_ORE_REPLACEABLES);
        RuleTest netherReplaceables = new TagMatchRuleTest(BlockTags.BASE_STONE_NETHER);

//        List<OreFeatureConfig.Target> KevinOres =
//                List.of(OreFeatureConfig.createTarget(stoneReplaceables, ModBlocks.KEVIN_ORE.getDefaultState()),
//                        OreFeatureConfig.createTarget(deepslateReplaceables, ModBlocks.DEEPSLATE_KEVIN_ORE.getDefaultState()));
//        List<OreFeatureConfig.Target> AncientCagite =
//                List.of(OreFeatureConfig.createTarget(netherReplaceables, ModBlocks.ANCIENT_CAGE.getDefaultState()));

//        register(context, KEVIN_ORE_KEY, Feature.ORE, new OreFeatureConfig(KevinOres, 8));
//        register(context, ANCIENT_CAGITE_KEY, Feature.ORE, new OreFeatureConfig(AncientCagite, 4));
    }

    public static RegistryKey<ConfiguredFeature<?, ?>> registerKey(String name) {
        return RegistryKey.of(RegistryKeys.CONFIGURED_FEATURE, Identifier.of(GooberArsenal.MOD_ID, name));
    }

    private static <FC extends FeatureConfig, F extends Feature<FC>> void register
            (Registerable<ConfiguredFeature<?, ?>> context,
             RegistryKey<ConfiguredFeature<?, ?>> key, F feature, FC configuration) {
        context.register(key, new ConfiguredFeature<>(feature, configuration));
    }
}
