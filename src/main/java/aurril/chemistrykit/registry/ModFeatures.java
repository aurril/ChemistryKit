package aurril.chemistrykit.registry;

import aurril.chemistrykit.ChemistryKit;
import net.fabricmc.fabric.api.biome.v1.*;
import net.minecraft.registry.RegistryKey;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.feature.PlacedFeature;

import java.util.function.BiConsumer;

public class ModFeatures {
    public static void placeFeaturesInBiomes() {
        BiomeModification modification = BiomeModifications.create(
                new Identifier(ChemistryKit.MOD_ID, "biome_additions")
        );

        modification
                .add(
                        ModificationPhase.ADDITIONS,
                        BiomeSelectors.foundInOverworld(),
                        modifier(
                                ModPlacedFeatures.SULFUR_GEODE,
                                GenerationStep.Feature.UNDERGROUND_DECORATION
                        )
                );
    }

    private static BiConsumer<BiomeSelectionContext, BiomeModificationContext> modifier(
            RegistryKey<PlacedFeature> feature,
            GenerationStep.Feature step
    ) {
        return (biomeSelectionContext, biomeModificationContext) -> biomeModificationContext.getGenerationSettings().addFeature(
                step,
                feature
        );
    }
}
