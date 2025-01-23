package aurril.chemistrykit;

import aurril.chemistrykit.provider.loottable.ModBlocksLootTables;
import aurril.chemistrykit.provider.model.ModModels;
import aurril.chemistrykit.provider.recipe.ModRecipes;
import aurril.chemistrykit.provider.tag.ModBlockTags;
import aurril.chemistrykit.provider.translation.EnglishEnUs;
import aurril.chemistrykit.provider.translation.GermanDeDe;
import aurril.chemistrykit.provider.translation.TranslationProvider;
import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;

public class ChemistryKitDataGenerator implements DataGeneratorEntrypoint {
	@Override
	public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
		FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();
		pack.addProvider(ModBlocksLootTables::new);
		pack.addProvider(ModRecipes::new);
		pack.addProvider(ModBlockTags::new);
		pack.addProvider(ModModels::new);
		pack.addProvider(ModEnglishLangProvider::new);
		pack.addProvider(ModGermanLangProvider::new);
	}

	private static class ModEnglishLangProvider extends FabricLanguageProvider {
		private final TranslationProvider translationProvider;

		protected ModEnglishLangProvider(FabricDataOutput dataOutput) {
			super(dataOutput, "en_us");
			this.translationProvider = new EnglishEnUs();
		}

		@Override
		public void generateTranslations(TranslationBuilder translationBuilder) {
			this.translationProvider.provideTranslations(translationBuilder);
		}
	}

	private static class ModGermanLangProvider extends FabricLanguageProvider {
		private final TranslationProvider translationProvider;

		protected ModGermanLangProvider(FabricDataOutput dataOutput) {
			super(dataOutput, "de_de");
			this.translationProvider = new GermanDeDe();
		}

		@Override
		public void generateTranslations(TranslationBuilder translationBuilder) {
			this.translationProvider.provideTranslations(translationBuilder);
		}
	}
}
