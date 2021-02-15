package fr.ImperoMaximo_x_Brokoli.SRTD.events;

import fr.ImperoMaximo_x_Brokoli.SRTD.blocks.SRTDBlocks;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.WorldGenRegistries;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.IFeatureConfig;
import net.minecraft.world.gen.feature.OreFeatureConfig;
import net.minecraftforge.common.world.BiomeGenerationSettingsBuilder;
import net.minecraftforge.event.world.BiomeLoadingEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class SRTDFeatures {

	private ConfiguredFeature<?, ?> srtd_ore_Feature;
	
	
	public void init() {
		srtd_ore_Feature = register("srtd_ore", Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.BASE_STONE_OVERWORLD, SRTDBlocks.srtd_ore.get().getDefaultState(), 4))
		.square()
		.range(0)
		.func_242731_b(0));

	}

	public <FC extends IFeatureConfig> ConfiguredFeature<FC, ?> register(String name, ConfiguredFeature<FC, ?> feature) {
		return Registry.register(WorldGenRegistries.CONFIGURED_FEATURE, name, feature);
	}
	
	@SubscribeEvent
	public void biomeLoading(BiomeLoadingEvent event) {
		BiomeGenerationSettingsBuilder generation = event.getGeneration();
		if(event.getCategory() != Biome.Category.NETHER) {
			generation.withFeature(GenerationStage.Decoration.UNDERGROUND_ORES, srtd_ore_Feature);
		}
	}
}
