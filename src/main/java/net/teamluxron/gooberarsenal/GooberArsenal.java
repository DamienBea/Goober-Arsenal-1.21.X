package net.teamluxron.gooberarsenal;

import net.fabricmc.api.ModInitializer;

import net.teamluxron.gooberarsenal.block.ModBlocks;
import net.teamluxron.gooberarsenal.item.ModItemGroups;
import net.teamluxron.gooberarsenal.item.ModItems;
import net.teamluxron.gooberarsenal.util.ModLootTableModifiers;
import net.teamluxron.gooberarsenal.world.ModOrePlacement;
import net.teamluxron.gooberarsenal.world.ModPlacedFeatures;
import net.teamluxron.gooberarsenal.world.gen.ModOreGeneration;
import net.teamluxron.gooberarsenal.world.gen.ModWorldGeneration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class GooberArsenal implements ModInitializer {
	public static final String MOD_ID = "gooberarsenal";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModItemGroups.registerItemGroups();
		ModWorldGeneration.generateModWordGen();
		ModOreGeneration.generateOres();

		ModItems.registerModItems();
		ModBlocks.registerModBlocks();
		ModLootTableModifiers.modifyLootTables();

	}
}