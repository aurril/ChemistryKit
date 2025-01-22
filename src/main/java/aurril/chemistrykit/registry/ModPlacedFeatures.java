package aurril.chemistrykit.registry;

import aurril.chemistrykit.ChemistryKit;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.feature.PlacedFeature;

public class ModPlacedFeatures {
    public static void initialize() {}

    public static RegistryKey<PlacedFeature> of(String id) {
        return RegistryKey.of(RegistryKeys.PLACED_FEATURE, new Identifier(ChemistryKit.MOD_ID, id));
    }

    public static RegistryKey<PlacedFeature> SULFUR_GEODE = of("sulfur_geode");
}
