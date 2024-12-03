package net.teninsomniak.moretools.item;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ToolMaterials;
import net.teninsomniak.moretools.MoreTools;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModItems {

    public static final Item WOODEN_SCYTHE = registerItem("wooden_scythe",
            new ScytheItem(ToolMaterials.WOOD, 4, -3.2f, new FabricItemSettings().group(ModItemGroup.SCYTHES)));

    public static final Item STONE_SCYTHE = registerItem("stone_scythe",
            new ScytheItem(ToolMaterials.STONE, 4, -3.2f, new FabricItemSettings().group(ModItemGroup.SCYTHES)));

    public static final Item IRON_SCYTHE = registerItem("iron_scythe",
            new ScytheItem(ToolMaterials.IRON, 4, -3.1f, new FabricItemSettings().group(ModItemGroup.SCYTHES)));

    public static final Item GOLD_SCYTHE = registerItem("gold_scythe",
            new ScytheItem(ToolMaterials.GOLD, 4, -3f, new FabricItemSettings().group(ModItemGroup.SCYTHES)));

    public static final Item DIAMOND_SCYTHE = registerItem("diamond_scythe",
            new ScytheItem(ToolMaterials.DIAMOND, 4, -3f, new FabricItemSettings().group(ModItemGroup.SCYTHES)));

    public static final Item NETHERITE_SCYTHE = registerItem("netherite_scythe",
            new ScytheItem(ToolMaterials.NETHERITE, 4, -3f, new FabricItemSettings().group(ModItemGroup.SCYTHES)));



    public static final Item ASTRALYTE_INGOT = registerItem("astralyte_ingot",
            new Item(new FabricItemSettings().group(ItemGroup.MATERIALS)));
    public static final Item DISTILLED_CHORUS = registerItem("distilled_chorus",
            new Item(new FabricItemSettings().group(ModItemGroup.SCYTHES)));


    public static final Item TEST_ITEM = registerItem("test_item",
            new ScytheItem(ToolMaterials.WOOD, 2, -2.8f, new FabricItemSettings().group(ModItemGroup.SCYTHES)));



    private static Item registerItem(String name, Item item) {
        return Registry.register(Registry.ITEM, new Identifier(MoreTools.MOD_ID, name), item);
    }

    public static void registerModItems() {
        MoreTools.LOGGER.debug("Registering Mod Items for " + MoreTools.MOD_ID);
    }
}