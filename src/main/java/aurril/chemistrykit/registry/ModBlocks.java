package aurril.chemistrykit.registry;

import aurril.chemistrykit.ChemistryKit;
import aurril.chemistrykit.block.BuddingSulfurBlock;
import aurril.chemistrykit.block.SulfurBlock;
import aurril.chemistrykit.block.SulfurClusterBlock;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.block.*;
import net.minecraft.block.piston.PistonBehavior;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;

public class ModBlocks {
    public static void initialize() {
        ItemGroupEvents.modifyEntriesEvent(ModItems.CUSTOM_ITEM_GROUP_KEY).register((itemGroup) -> {
            itemGroup.add(ModBlocks.SULFUR_BLOCK.asItem());
            itemGroup.add(ModBlocks.SMALL_SULFUR_BUD.asItem());
            itemGroup.add(ModBlocks.MEDIUM_SULFUR_BUD.asItem());
            itemGroup.add(ModBlocks.LARGE_SULFUR_BUD.asItem());
            itemGroup.add(ModBlocks.SULFUR_CLUSTER.asItem());
            itemGroup.add(ModBlocks.BUDDING_SULFUR_BLOCK.asItem());
        });
    }

    public static Block register(Block block, String name, boolean shouldRegisterItem) {
        // Register the block and its item.
        Identifier id = new Identifier(ChemistryKit.MOD_ID, name);

        // Sometimes, you may not want to register an item for the block.
        // Eg: if it's a technical block like `minecraft:air` or `minecraft:end_gateway`
        if (shouldRegisterItem) {
            BlockItem blockItem = new BlockItem(block, new Item.Settings());
            Registry.register(Registries.ITEM, id, blockItem);
        }

        return Registry.register(Registries.BLOCK, id, block);
    }

    public static final Block SULFUR_BLOCK = register(
            new SulfurBlock(
                    AbstractBlock.Settings.create()
                            .mapColor(MapColor.EMERALD_GREEN)
                            .strength(1.5F)
                            .sounds(BlockSoundGroup.AMETHYST_BLOCK)
                            .requiresTool()
            ),
            "sulfur_block",
            true
    );

    public static final Block SULFUR_CLUSTER = register(
            new SulfurClusterBlock(
                    7,
                    3,
                    AbstractBlock.Settings.create()
                            .mapColor(MapColor.EMERALD_GREEN)
                            .solid()
                            .nonOpaque()
                            .ticksRandomly()
                            .sounds(BlockSoundGroup.AMETHYST_CLUSTER)
                            .strength(1.5F)
                            .luminance((state) -> 5)
                            .pistonBehavior(PistonBehavior.DESTROY)
            ),
            "sulfur_cluster",
            true
    );

    public static final Block SMALL_SULFUR_BUD = register(
            new SulfurClusterBlock(
                    3,
                    4,
                    AbstractBlock.Settings.copy(SULFUR_CLUSTER)
                            .sounds(BlockSoundGroup.SMALL_AMETHYST_BUD)
                            .solid()
                            .luminance((state) -> 1)
                            .pistonBehavior(PistonBehavior.DESTROY)
            ),
            "small_sulfur_bud",
            true
    );

    public static final Block MEDIUM_SULFUR_BUD = register(
            new SulfurClusterBlock(
                    4,
                    3,
                    AbstractBlock.Settings.copy(SULFUR_CLUSTER)
                            .sounds(BlockSoundGroup.MEDIUM_AMETHYST_BUD)
                            .solid()
                            .luminance((state) -> 4)
                            .pistonBehavior(PistonBehavior.DESTROY)
            ),
            "medium_sulfur_bud",
            true
    );

    public static final Block LARGE_SULFUR_BUD = register(
            new SulfurClusterBlock(
                    5,
                    3,
                    AbstractBlock.Settings.copy(SULFUR_CLUSTER)
                            .sounds(BlockSoundGroup.LARGE_AMETHYST_BUD)
                            .solid()
                            .luminance((state) -> 2)
                            .pistonBehavior(PistonBehavior.DESTROY)
            ),
            "large_sulfur_bud",
            true
    );

    public static final Block BUDDING_SULFUR_BLOCK = register(
            new BuddingSulfurBlock(
                    AbstractBlock.Settings.create()
                            .mapColor(MapColor.EMERALD_GREEN)
                            .ticksRandomly()
                            .strength(1.5F)
                            .sounds(BlockSoundGroup.AMETHYST_BLOCK)
                            .requiresTool()
                            .pistonBehavior(PistonBehavior.DESTROY)
            ),
            "budding_sulfur",
            true
    );
}
