package com.chromaticrestored;

import java.util.List;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;

/**
 * Puts Create's legacy items back into Create's creative tab. JEI lists whatever is in the creative tabs,
 * so this also makes them visible in JEI. The crafting recipes live in this mod's data folder.
 *
 * Create is not a compile-time dependency: items are looked up by registry ID at runtime.
 */
@Mod(ChromaticRestored.MODID)
public class ChromaticRestored {
    public static final String MODID = "create_chromatic_restored";

    private static final ResourceKey<CreativeModeTab> CREATE_BASE_TAB = ResourceKey.create(
            Registries.CREATIVE_MODE_TAB, ResourceLocation.fromNamespaceAndPath("create", "base"));

    private static final List<String> LEGACY_ITEMS = List.of(
            "chromatic_compound",
            "shadow_steel",
            "refined_radiance",
            "shadow_steel_casing",
            "refined_radiance_casing");

    public ChromaticRestored(IEventBus modEventBus) {
        modEventBus.addListener(ChromaticRestored::addToCreativeTab);
    }

    private static void addToCreativeTab(BuildCreativeModeTabContentsEvent event) {
        if (!event.getTabKey().equals(CREATE_BASE_TAB)) {
            return;
        }
        for (String path : LEGACY_ITEMS) {
            ResourceLocation id = ResourceLocation.fromNamespaceAndPath("create", path);
            BuiltInRegistries.ITEM.getOptional(id).ifPresent(event::accept);
        }
    }
}
