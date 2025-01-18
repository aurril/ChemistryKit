package aurril.chemistrykit.registry;

import aurril.chemistrykit.ChemistryKit;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItems {
    public static void initialize() {
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS)
                .register((itemGroup) -> itemGroup.add(ModItems.SULFUR_SHARD));
    }

    public static Item register(Item item, String id) {
        Identifier itemId = new Identifier(ChemistryKit.MOD_ID, id);

        return Registry.register(Registries.ITEM, itemId, item);
    }

    public static final Item SULFUR_SHARD = register(
            new Item(new FabricItemSettings()),
            "sulfur_shard"
    );
}
