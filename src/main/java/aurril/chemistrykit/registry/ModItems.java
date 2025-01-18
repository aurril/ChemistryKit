package aurril.chemistrykit.registry;

import aurril.chemistrykit.ChemistryKit;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModItems {
    public static void initialize() {
        Registry.register(Registries.ITEM_GROUP, CUSTOM_ITEM_GROUP_KEY, CUSTOM_ITEM_GROUP);
        ItemGroupEvents.modifyEntriesEvent(CUSTOM_ITEM_GROUP_KEY).register(itemGroup -> {
            itemGroup.add(ModItems.SULFUR_SHARD);
            itemGroup.add(ModItems.SULFUR_POWDER);
        });
    }

    public static Item register(Item item, String id) {
        Identifier itemId = new Identifier(ChemistryKit.MOD_ID, id);

        return Registry.register(Registries.ITEM, itemId, item);
    }

    public static final RegistryKey<ItemGroup> CUSTOM_ITEM_GROUP_KEY = RegistryKey.of(Registries.ITEM_GROUP.getKey(), new Identifier(ChemistryKit.MOD_ID, "item_group"));
    public static final ItemGroup CUSTOM_ITEM_GROUP = FabricItemGroup.builder()
            .icon(() -> new ItemStack(ModItems.SULFUR_SHARD))
            .displayName(Text.translatable("itemGroup.chemistry-kit"))
            .build();

    // Items

    public static final Item SULFUR_SHARD = register(
            new Item(new FabricItemSettings()),
            "sulfur_shard"
    );

    public static final Item SULFUR_POWDER = register(
            new Item(new FabricItemSettings()),
            "sulfur_powder"
    );
}
