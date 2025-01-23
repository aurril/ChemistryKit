package aurril.chemistrykit.registry;

import aurril.chemistrykit.ChemistryKit;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.feature.ConfiguredFeature;

public class ModConfiguredFeatures {
    public static void initialize() {}

    public static RegistryKey<ConfiguredFeature<?, ?>> of(String id) {
        return RegistryKey.of(RegistryKeys.CONFIGURED_FEATURE, new Identifier(ChemistryKit.MOD_ID, id));
    }

    public static final RegistryKey<ConfiguredFeature<?, ?>> SULFUR_GEODE = of("sulfur_geode");
}
