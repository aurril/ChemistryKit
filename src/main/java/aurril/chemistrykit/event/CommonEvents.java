package aurril.chemistrykit.event;

import aurril.chemistrykit.ChemistryKit;
import net.fabricmc.fabric.api.resource.ResourceManagerHelper;
import net.fabricmc.fabric.api.resource.ResourcePackActivationType;
import net.fabricmc.loader.api.FabricLoader;
import net.fabricmc.loader.api.ModContainer;
import net.minecraft.util.Identifier;


public class CommonEvents {
    public static void register() {
        CommonEvents.addPackFinders();
    }

    private static void addPackFinders() {
        ModContainer create = FabricLoader.getInstance().getModContainer(ChemistryKit.MOD_ID)
                .orElseThrow(() -> new IllegalStateException("Chemistry-Kit's ModContainer couldn't be found!"));
        Identifier packId = new Identifier(ChemistryKit.MOD_ID, "patrix_1.20_chemistry-kit_addon");

        ResourceManagerHelper.registerBuiltinResourcePack(packId, create, "Create Legacy Copper", ResourcePackActivationType.NORMAL);
    }
}
