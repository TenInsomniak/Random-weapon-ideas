package net.teninsomniak.randomweapons.item;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.teninsomniak.randomweapons.RandomWeaponIdeas;

public class ModItems {
    public static final Item DIAMOND_SCYTHE = registerItem("diamond_scythe", new Item(new FabricItemSettings()));
    public static final Item DEBUG_ITEM = registerItem("debug_item.json", new Item(new FabricItemSettings()));


    private static void addItemsToCombatItemGroup(FabricItemGroupEntries entries) {
        entries.add(DIAMOND_SCYTHE);
    }
    private static void addItemsToIngredientItemGroup(FabricItemGroupEntries entries) {
        entries.add(DEBUG_ITEM);
    }
    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, new Identifier(RandomWeaponIdeas.MOD_ID, name), item);
    }
    public static void registerModItems() {
        RandomWeaponIdeas.LOGGER.info("Registering Mod Items for " + RandomWeaponIdeas.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(ModItems::addItemsToIngredientItemGroup);
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.COMBAT).register(ModItems::addItemsToCombatItemGroup);
    }
}
