package fr.ImperoMaximo_x_Brokoli.SRTD;

import fr.ImperoMaximo_x_Brokoli.SRTD.blocks.SRTDBlocks;
import fr.ImperoMaximo_x_Brokoli.SRTD.events.SRTDEvents;
import fr.ImperoMaximo_x_Brokoli.SRTD.items.SRTDItems;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLDedicatedServerSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(srtd.MOD_ID)
public class srtd {
		
	public static final String MOD_ID = "srtd";
		
	public srtd() {
		
		FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
		FMLJavaModLoadingContext.get().getModEventBus().addListener(this::clientSetup);
		FMLJavaModLoadingContext.get().getModEventBus().addListener(this::serverSetup);
		
		IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
		SRTDItems.Items.register(bus);
		SRTDBlocks.Blocks.register(bus);
		
		
		
	}
 
	private void setup(final FMLCommonSetupEvent event) {
		SRTDEvents Events = new SRTDEvents();
		
		Events.init();
		
		MinecraftForge.EVENT_BUS.register(Events);
		
	}
 
	private void clientSetup(final FMLClientSetupEvent event) {
	}
	
	private void serverSetup(final FMLDedicatedServerSetupEvent event) {
	}
}