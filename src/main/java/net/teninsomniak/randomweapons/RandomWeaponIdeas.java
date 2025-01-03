package net.teninsomniak.randomweapons;

import net.fabricmc.api.ModInitializer;

import net.teninsomniak.randomweapons.item.ModItemGroups;
import net.teninsomniak.randomweapons.item.ModItems;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RandomWeaponIdeas implements ModInitializer {
	public static final String MOD_ID = "random-weapons";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModItemGroups.registerItemGroups();
		ModItems.registerModItems();
	}
}