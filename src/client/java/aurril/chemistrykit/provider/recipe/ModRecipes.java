package aurril.chemistrykit.provider.recipe;

import aurril.chemistrykit.registry.ModBlocks;
import aurril.chemistrykit.registry.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.data.server.recipe.RecipeJsonProvider;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.data.server.recipe.ShapelessRecipeJsonBuilder;
import net.minecraft.recipe.book.RecipeCategory;

import java.util.function.Consumer;

public class ModRecipes extends FabricRecipeProvider {
    public ModRecipes(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generate(Consumer<RecipeJsonProvider> consumer) {
        ModRecipes.addSulfurBlockRecipe(consumer);
        ModRecipes.addSulfurShardRecipe(consumer);
        ModRecipes.addSulfurPowderRecipe(consumer);
    }

    private static void addSulfurBlockRecipe(Consumer<RecipeJsonProvider> consumer) {
        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.SULFUR_BLOCK)
                .pattern("###")
                .pattern("###")
                .pattern("###")
                .input('#', ModItems.SULFUR_SHARD)
                .criterion(FabricRecipeProvider.hasItem(ModBlocks.SULFUR_BLOCK), FabricRecipeProvider.conditionsFromItem(ModBlocks.SULFUR_BLOCK))
                .criterion(FabricRecipeProvider.hasItem(ModItems.SULFUR_SHARD), FabricRecipeProvider.conditionsFromItem(ModItems.SULFUR_SHARD))
                .showNotification(true)
                .offerTo(consumer);
    }

    private static void addSulfurShardRecipe(Consumer<RecipeJsonProvider> consumer) {
        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.SULFUR_SHARD, 9)
                .input(ModBlocks.SULFUR_BLOCK)
                .criterion(FabricRecipeProvider.hasItem(ModBlocks.SULFUR_BLOCK), FabricRecipeProvider.conditionsFromItem(ModBlocks.SULFUR_BLOCK))
                .criterion(FabricRecipeProvider.hasItem(ModItems.SULFUR_SHARD), FabricRecipeProvider.conditionsFromItem(ModItems.SULFUR_SHARD))
                .offerTo(consumer);
    }

    private static void addSulfurPowderRecipe(Consumer<RecipeJsonProvider> consumer) {
        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.SULFUR_POWDER, 2)
                .input(ModItems.SULFUR_SHARD)
                .criterion(FabricRecipeProvider.hasItem(ModItems.SULFUR_POWDER), FabricRecipeProvider.conditionsFromItem(ModItems.SULFUR_POWDER))
                .criterion(FabricRecipeProvider.hasItem(ModItems.SULFUR_SHARD), FabricRecipeProvider.conditionsFromItem(ModItems.SULFUR_SHARD))
                .offerTo(consumer);
    }
}
