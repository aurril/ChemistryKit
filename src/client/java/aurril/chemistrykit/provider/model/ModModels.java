package aurril.chemistrykit.provider.model;

import aurril.chemistrykit.registry.ModBlocks;
import aurril.chemistrykit.registry.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.block.Block;
import net.minecraft.data.client.*;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;

public class ModModels extends FabricModelProvider {
    public ModModels(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        this.registerSimpleCubeBlocks(blockStateModelGenerator);
        this.registerSaltpeter(blockStateModelGenerator);
        this.registerCrossBlocksLikeAmethyst(blockStateModelGenerator);
    }

    private void registerSimpleCubeBlocks(BlockStateModelGenerator blockStateModelGenerator) {
        Block[] simpleCubeBlocks = {
            ModBlocks.SULFUR_BLOCK,
            ModBlocks.BUDDING_SULFUR_BLOCK
        };

        for (Block block : simpleCubeBlocks) {
            blockStateModelGenerator.registerSimpleCubeAll(block);
        }
    }

    private void registerSaltpeter(BlockStateModelGenerator blockStateModelGenerator) {
        Block block = ModBlocks.SALTPETER;
        TexturedModel texturedModel = TexturedModel.SIDE_TOP_BOTTOM_WALL.get(block);

        blockStateModelGenerator.new BlockTexturePool(texturedModel.getTextures()).base(block, texturedModel.getModel());
    }

    private void registerCrossBlocksLikeAmethyst(BlockStateModelGenerator blockStateModelGenerator) {
        Block[] crossBlocks = {
                ModBlocks.SULFUR_CLUSTER,
                ModBlocks.LARGE_SULFUR_BUD,
                ModBlocks.MEDIUM_SULFUR_BUD,
                ModBlocks.SMALL_SULFUR_BUD
        };

        for (Block block : crossBlocks) {
            blockStateModelGenerator.registerAmethyst(block);
            blockStateModelGenerator.registerParentedItemModel(block, Registries.BLOCK.getId(block).withPrefixedPath("block/"));
        }
    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        this.registerSimpleItems(itemModelGenerator);
    }

    private void registerSimpleItems(ItemModelGenerator itemModelGenerator) {
        Item[] simpleItems = {
                ModItems.SULFUR_SHARD,
                ModItems.SULFUR_POWDER
        };

        for (Item item : simpleItems) {
            itemModelGenerator.register(item, Models.GENERATED);
        }
    }
}
