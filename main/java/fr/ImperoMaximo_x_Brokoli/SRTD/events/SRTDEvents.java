package fr.ImperoMaximo_x_Brokoli.SRTD.events;

import java.util.UUID;

import fr.ImperoMaximo_x_Brokoli.SRTD.items.SRTDItems;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.ai.attributes.AttributeModifier.Operation;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraftforge.event.entity.living.LivingEquipmentChangeEvent;
import net.minecraftforge.event.entity.living.LivingFallEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class SRTDEvents {

	//private double gammaDefault = Minecraft.getInstance().gameSettings.gamma;

	public void init() {
	}
	
	@SuppressWarnings("resource")
	@SubscribeEvent
	public void onLivingEquipmentChange(LivingEquipmentChangeEvent event) {
		LivingEntity player = event.getEntityLiving();
		
		if(event.getEntityLiving().getItemStackFromSlot(EquipmentSlotType.HEAD).getItem() == SRTDItems.Night_helmet.get()) Minecraft.getInstance().gameSettings.gamma = 9.0;
		else Minecraft.getInstance().gameSettings.gamma = 1;

		if(player.getHeldItemOffhand().getItem() == SRTDItems.Totem_of_rapidity.get()) player.getAttribute(Attributes.MOVEMENT_SPEED).applyNonPersistentModifier(new AttributeModifier(UUID.randomUUID(), "movementspeed", 0.05D, Operation.ADDITION));
		else event.getEntityLiving().getAttribute(Attributes.MOVEMENT_SPEED).removeAllModifiers();

		if(player.getHeldItemOffhand().getItem() == SRTDItems.Totem_of_health.get()) player.getAttribute(Attributes.MAX_HEALTH).applyNonPersistentModifier(new AttributeModifier(UUID.randomUUID(), "movementspeed", 10.0D, Operation.ADDITION));
		else event.getEntityLiving().getAttribute(Attributes.MAX_HEALTH).removeAllModifiers();
		
		//if(player.getHeldItemOffhand().getItem() == SRTDItems.Totem_of_regeneration.get()) player.addPotionEffect(new EffectInstance(Effect.get(10), 1, Integer.MAX_VALUE, true, false));
		//else event.getEntityLiving().removePotionEffect(Effect.get(10));
		
		
	}
	
	@SubscribeEvent
	public void onLivingFall(LivingFallEvent event) {
		if(event.getEntityLiving().getHeldItemOffhand().getItem() == SRTDItems.Totem_of_fall.get()) event.setDamageMultiplier(0.75F);
	}
}