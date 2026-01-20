package com.davigj.bury_me_deep.core;

import com.davigj.bury_me_deep.core.registry.BMDBlockEntityTypes;
import com.davigj.bury_me_deep.core.registry.BMDBlocks;
import com.teamabnormals.blueprint.core.util.registry.RegistryHelper;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.neoforge.data.event.GatherDataEvent;

import static com.davigj.bury_me_deep.core.other.BMDConstants.ctsMap;
import static com.davigj.bury_me_deep.core.other.BMDConstants.stcMap;

@Mod(BuryMeDeep.MOD_ID)
public class BuryMeDeep {
    public static final String MOD_ID = "bury_me_deep";
    public static final RegistryHelper REGISTRY_HELPER = new RegistryHelper(MOD_ID);

    public BuryMeDeep(IEventBus bus, ModContainer container) {
        BMDBlocks.BLOCKS.register(bus);
        BMDBlockEntityTypes.BLOCK_ENTITIES.register(bus);

        bus.addListener(this::commonSetup);
        bus.addListener(this::clientSetup);
        bus.addListener(this::dataSetup);

//        container.registerConfig(ModConfig.Type.COMMON, BMDConfig.COMMON_SPEC);
    }

    private void commonSetup(FMLCommonSetupEvent event) {
        event.enqueueWork(() -> {
            stcMap();
            ctsMap();
        });
    }

    private void clientSetup(FMLClientSetupEvent event) {
    }

    private void dataSetup(GatherDataEvent event) {
    }

    public static ResourceLocation location(String path) {
        return ResourceLocation.fromNamespaceAndPath(MOD_ID, path);
    }
}