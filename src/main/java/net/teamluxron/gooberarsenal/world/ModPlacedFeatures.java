package net.teamluxron.gooberarsenal.world;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.YOffset;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.FeatureConfig;
import net.minecraft.world.gen.feature.PlacedFeature;
import net.minecraft.world.gen.placementmodifier.HeightRangePlacementModifier;
import net.minecraft.world.gen.placementmodifier.PlacementModifier;
import net.teamluxron.gooberarsenal.GooberArsenal;

import java.util.List;

public class ModPlacedFeatures {
//    public static final RegistryKey<PlacedFeature> KEVIN_ORE_PLACED_KEY = registerKey("kevin_ore_placed");
//    public static final RegistryKey<PlacedFeature> ANCIENT_CAGITE_PLACED_KEY = registerKey("ancient_cagite_placed");



    public static void bootstrap(Registerable<PlacedFeature> context) {
        var configuredFeatures = context.getRegistryLookup(RegistryKeys.CONFIGURED_FEATURE);

//        register(context, KEVIN_ORE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.KEVIN_ORE_KEY),
//                ModOrePlacement.modifiersWithCount(7,
//                        HeightRangePlacementModifier.uniform(YOffset.fixed(-100), YOffset.fixed(14))));
//        register(context, ANCIENT_CAGITE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.ANCIENT_CAGITE_KEY),
//                ModOrePlacement.modifiersWithCount(2,
//                        HeightRangePlacementModifier.uniform(YOffset.fixed(0), YOffset.fixed(12))));


    }

    public static RegistryKey<PlacedFeature> registerKey(String name) {
        return RegistryKey.of(RegistryKeys.PLACED_FEATURE, Identifier.of(GooberArsenal.MOD_ID, name));
    }

    private static void register(Registerable<PlacedFeature> context, RegistryKey<PlacedFeature> key, RegistryEntry<ConfiguredFeature<?, ?>> configuration,
                                 List<PlacementModifier> modifiers) {
        context.register(key, new PlacedFeature(configuration, List.copyOf(modifiers)));
    }

    private static <FC extends FeatureConfig, F extends Feature<FC>> void register(Registerable<PlacedFeature> context, RegistryKey<PlacedFeature> key,
                                                                                   RegistryEntry<ConfiguredFeature<?, ?>> configuration,
                                                                                   PlacementModifier... modifiers) {
        register(context, key, configuration, List.of(modifiers));
    }
}
