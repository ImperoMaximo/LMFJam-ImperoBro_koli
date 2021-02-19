package fr.ImperoMaximo_x_Brokoli.SRTD.events;

import java.util.UUID;

import fr.ImperoMaximo_x_Brokoli.SRTD.items.SRTDItems;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.ai.attributes.AttributeModifier.Operation;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.potion.Effect;
import net.minecraft.potion.EffectInstance;
import net.minecraftforge.event.entity.living.LivingEquipmentChangeEvent;
import net.minecraftforge.event.entity.living.LivingFallEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class SRTDEvents {

	private double gammaDefault = Minecraft.getInstance().gameSettings.gamma;

	public void init() {
	}
	
	@SuppressWarnings("resource")
	@SubscribeEvent
	public void onLivingEquipmentChange(LivingEquipmentChangeEvent event) {
		LivingEntity player = event.getEntityLiving();
		
		if(event.getEntityLiving().getItemStackFromSlot(EquipmentSlotType.HEAD).getItem() == SRTDItems.Night_helmet.get()) Minecraft.getInstance().gameSettings.gamma += 49;
		else Minecraft.getInstance().gameSettings.gamma = gammaDefault;

		if(player.getHeldItemOffhand().getItem() == SRTDItems.Totem_of_rapidity.get()) player.getAttribute(Attributes.MOVEMENT_SPEED).applyNonPersistentModifier(new AttributeModifier(UUID.randomUUID(), "movementspeed", 0.1D, Operation.ADDITION));
		else event.getEntityLiving().getAttribute(Attributes.MOVEMENT_SPEED).removeAllModifiers();

		if(player.getHeldItemOffhand().getItem() == SRTDItems.Totem_of_health.get()) player.getAttribute(Attributes.MAX_HEALTH).applyNonPersistentModifier(new AttributeModifier(UUID.randomUUID(), "movementspeed", 10.0D, Operation.ADDITION));
		else event.getEntityLiving().getAttribute(Attributes.MAX_HEALTH).removeAllModifiers();
		
		if(player.getHeldItemOffhand().getItem() == SRTDItems.Totem_of_regeneration.get()) player.addPotionEffect(new EffectInstance(Effect.get(10), 1, Integer.MAX_VALUE, false, false));
		else event.getEntityLiving().removePotionEffect(Effect.get(10));
		
		
	}
	
	@SubscribeEvent
	public void onLivingFall(LivingFallEvent event) {
		if(event.getEntityLiving().getHeldItemOffhand().getItem() == SRTDItems.Totem_of_fall.get()) event.setDamageMultiplier(0.75F);
	}
	/*
	public boolean ifHandItemCorrespondTo(LivingEntity player, RegistryObject<Item> item) {
		int a = 0;
		int b = 0;
		if(player.getHeldItemMainhand() != null) {
			if(player.getHeldItemMainhand().getItem() == item.get()) a = 1;
		}
		if(player.getHeldItemOffhand() != null) {
			if(player.getHeldItemOffhand().getItem() == item.get()) b = 1;
		}
		if(a == 1 || b ==1) return true;
		if(a == 1 && b == 1) return false;
		else return false;
	}*/
}