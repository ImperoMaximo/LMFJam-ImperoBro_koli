package fr.ImperoMaximo_x_Brokoli.SRTD.events;

import java.util.UUID;

import fr.ImperoMaximo_x_Brokoli.SRTD.items.SRTDItems;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.ai.attributes.AttributeModifier.Operation;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.Item;
import net.minecraftforge.event.entity.living.LivingEquipmentChangeEvent;
import net.minecraftforge.event.entity.living.LivingFallEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.RegistryObject;

public class SRTDEvents {

	public void init() {
	}
	
	@SuppressWarnings("resource")
	@SubscribeEvent
	public void onLivingEquipmentChange(LivingEquipmentChangeEvent event) {
		LivingEntity player = event.getEntityLiving();
		
		if(event.getEntityLiving().getItemStackFromSlot(EquipmentSlotType.HEAD).getItem() == SRTDItems.Night_helmet.get()) Minecraft.getInstance().gameSettings.gamma = 9.0D;
		else Minecraft.getInstance().gameSettings.gamma = 0.0D;

		if(ifFromTo(event, SRTDItems.Totem_of_rapidity) == 1) player.getAttribute(Attributes.MOVEMENT_SPEED).applyNonPersistentModifier(new AttributeModifier(UUID.randomUUID(), "movementspeed", 0.05D, Operation.ADDITION));
		else if(ifFromTo(event, SRTDItems.Totem_of_rapidity) == 0);
		else event.getEntityLiving().getAttribute(Attributes.MOVEMENT_SPEED).removeAllModifiers();
		
		if(ifFromTo(event, SRTDItems.Totem_of_health) == 1) player.getAttribute(Attributes.MAX_HEALTH).applyNonPersistentModifier(new AttributeModifier(UUID.randomUUID(), "maxhealth", 20.0D, Operation.ADDITION));
		else if(ifFromTo(event, SRTDItems.Totem_of_health) == 0);
		else event.getEntityLiving().getAttribute(Attributes.MAX_HEALTH).removeAllModifiers();
	}
	
	@SubscribeEvent
	public void onLivingFall(LivingFallEvent event) {
		if(event.getEntityLiving().getHeldItemOffhand().getItem() == SRTDItems.Totem_of_fall.get()) event.setDamageMultiplier(0.75F);
	}
	
	private int ifFromTo(LivingEquipmentChangeEvent event, RegistryObject<Item> item) {
		if(event.getSlot() == EquipmentSlotType.OFFHAND && event.getFrom().getItem() != item.get() && item.get() == event.getTo().getItem()) return 1;
		else if(event.getSlot() == EquipmentSlotType.OFFHAND && event.getFrom() == event.getTo()) return 0;
		else return 2;
	}
}