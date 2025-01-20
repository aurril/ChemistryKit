package aurril.chemistrykit;

import aurril.chemistrykit.provider.loottable.ModBlocksLootTables;
import aurril.chemistrykit.provider.model.ModModels;
import aurril.chemistrykit.provider.recipe.ModRecipes;
import aurril.chemistrykit.provider.tag.ModBlockTags;
import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;

public class ChemistryKitDataGenerator implements DataGeneratorEntrypoint {
	@Override
	public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
		FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();
		pack.addProvider(ModBlocksLootTables::new);
		pack.addProvider(ModRecipes::new);
		pack.addProvider(ModBlockTags::new);
		pack.addProvider(ModModels::new);
	}
}
