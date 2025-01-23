package aurril.chemistrykit.provider.translation;

import aurril.chemistrykit.registry.ModBlocks;
import aurril.chemistrykit.registry.ModItems;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;

public class EnglishEnUs implements TranslationProvider{
    @Override
    public void provideTranslations(FabricLanguageProvider.TranslationBuilder translationBuilder) {
        EnglishEnUs.addItemTranslations(translationBuilder);
        EnglishEnUs.addBlockTranslations(translationBuilder);
        translationBuilder.add(ModItems.CUSTOM_ITEM_GROUP_KEY, "Chemistry Kit");
    }

    private static void addItemTranslations(FabricLanguageProvider.TranslationBuilder translationBuilder) {
        translationBuilder.add(ModItems.SULFUR_POWDER, "Sulfur Powder");
        translationBuilder.add(ModItems.SULFUR_SHARD, "Sulfur Shard");
    }

    private static void addBlockTranslations(FabricLanguageProvider.TranslationBuilder translationBuilder) {
        translationBuilder.add(ModBlocks.SULFUR_BLOCK, "Sulfur Block");
        translationBuilder.add(ModBlocks.SULFUR_CLUSTER, "Sulfur Cluster");
        translationBuilder.add(ModBlocks.SMALL_SULFUR_BUD, "Small Sulfur Bud");
        translationBuilder.add(ModBlocks.MEDIUM_SULFUR_BUD, "Medium Sulfur Bud");
        translationBuilder.add(ModBlocks.LARGE_SULFUR_BUD, "Large Sulfur Bud");
        translationBuilder.add(ModBlocks.BUDDING_SULFUR_BLOCK, "Budding Sulfur");
    }
}
