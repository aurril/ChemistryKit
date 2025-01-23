package aurril.chemistrykit.provider.translation;

import aurril.chemistrykit.registry.ModBlocks;
import aurril.chemistrykit.registry.ModItems;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;

public class GermanDeDe implements TranslationProvider {
    @Override
    public void provideTranslations(FabricLanguageProvider.TranslationBuilder translationBuilder) {
        GermanDeDe.addItemTranslations(translationBuilder);
        GermanDeDe.addBlockTranslations(translationBuilder);
        translationBuilder.add(ModItems.CUSTOM_ITEM_GROUP_KEY, "Chemiebaukasten");
    }

    private static void addItemTranslations(FabricLanguageProvider.TranslationBuilder translationBuilder) {
        translationBuilder.add(ModItems.SULFUR_POWDER, "Schwefelpulver");
        translationBuilder.add(ModItems.SULFUR_SHARD, "Schwefelscherbe");
    }

    private static void addBlockTranslations(FabricLanguageProvider.TranslationBuilder translationBuilder) {
        translationBuilder.add(ModBlocks.SULFUR_BLOCK, "Schwefelblock");
        translationBuilder.add(ModBlocks.SULFUR_CLUSTER, "Schwefelhaufen");
        translationBuilder.add(ModBlocks.SMALL_SULFUR_BUD, "Kleine Schwefelknospe");
        translationBuilder.add(ModBlocks.MEDIUM_SULFUR_BUD, "Mittlere Schwefelknospe");
        translationBuilder.add(ModBlocks.LARGE_SULFUR_BUD, "Große Schwefelknospe");
        translationBuilder.add(ModBlocks.BUDDING_SULFUR_BLOCK, "Schwefelknospenblock");
    }
}
