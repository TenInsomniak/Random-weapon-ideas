package net.teninsomniak.randomweapons.item;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.teninsomniak.randomweapons.RandomWeaponIdeas;

public class ModItemGroups {
    public static final ItemGroup SCYTHE_GROUP = Registry.register(Registries.ITEM_GROUP,
            new Identifier(RandomWeaponIdeas.MOD_ID, "scythes"),
            FabricItemGroup.builder().displayName(Text.translatable("itemGroup.scythes"))
                    .icon(() -> new ItemStack(ModItems.DIAMOND_SCYTHE)).entries(((displayContext, entries) -> {
                        entries.add(ModItems.DEBUG_ITEM);
                        entries.add(ModItems.DIAMOND_SCYTHE);
                    })).build());
    public static void registerItemGroups() {
        RandomWeaponIdeas.LOGGER.info("Registering Item Groups for " + RandomWeaponIdeas.MOD_ID);
    }
}
