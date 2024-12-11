package net.teamluxron.gooberarsenal;

import net.fabricmc.api.ModInitializer;

import net.teamluxron.gooberarsenal.item.ModItems;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class GooberArsenal implements ModInitializer {
	public static final String MOD_ID = "gooberarsenal";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModItems.registerModItems();
	}
}