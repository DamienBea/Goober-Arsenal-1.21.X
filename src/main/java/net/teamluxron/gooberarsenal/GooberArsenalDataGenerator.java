package net.teamluxron.gooberarsenal;

import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.minecraft.registry.RegistryBuilder;
import net.minecraft.registry.RegistryKeys;
import net.teamluxron.gooberarsenal.datagen.*;
import net.teamluxron.gooberarsenal.util.ModLootTableModifiers;
import net.teamluxron.gooberarsenal.world.ModConfiguredFeatures;
import net.teamluxron.gooberarsenal.world.ModPlacedFeatures;
import net.teamluxron.gooberarsenal.datagen.ModWordGenerator;

public class GooberArsenalDataGenerator implements DataGeneratorEntrypoint {
	@Override
	public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
		FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();

		pack.addProvider(ModBlockTagProvider::new);
		pack.addProvider(ModItemTagProvider::new);
		pack.addProvider(ModLootTableProvider::new);
		pack.addProvider(ModModelProvider::new);
		pack.addProvider(ModRecipeProvider::new);
		pack.addProvider(ModWordGenerator::new);
	}

	@Override
	public void buildRegistry(RegistryBuilder registryBuilder) {


		registryBuilder.addRegistry(RegistryKeys.CONFIGURED_FEATURE, ModConfiguredFeatures::bootstrap);
		registryBuilder.addRegistry(RegistryKeys.PLACED_FEATURE, ModPlacedFeatures::bootstrap);
	}
}
