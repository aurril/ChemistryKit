package aurril.chemistrykit.provider.translation;

import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;

public interface TranslationProvider {
    void provideTranslations(FabricLanguageProvider.TranslationBuilder translationBuilder);
}
