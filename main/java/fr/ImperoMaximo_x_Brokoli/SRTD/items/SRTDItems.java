package fr.ImperoMaximo_x_Brokoli.SRTD.items;

import fr.ImperoMaximo_x_Brokoli.SRTD.srtd;
import fr.ImperoMaximo_x_Brokoli.SRTD.utils.SRTDItemsGroup;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.item.Food;
import net.minecraft.item.Item;
import net.minecraft.item.ItemTier;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class SRTDItems	{
	public static final DeferredRegister<Item> Items = DeferredRegister.create(ForgeRegistries.ITEMS, srtd.MOD_ID);	
	
    public static final RegistryObject<Item> SRTDIcon = Items.register("srtd_icon", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> Hoe = Items.register("hoe", () -> new SRTDHoeItem(ItemTier.DIAMOND, -3, 0.0F, new Item.Properties().group(SRTDItemsGroup.srtd)));
    public static final RegistryObject<Item> Totem_of_rapidity = Items.register("totem_of_rapidity", () -> new Item(new Item.Properties().maxStackSize(1).group(SRTDItemsGroup.srtd)));
    //public static final RegistryObject<Item> Totem_of_regeneration = Items.register("totem_of_regeneration", () -> new Item(new Item.Properties().maxStackSize(1).group(SRTDItemsGroup.srtd)));
    public static final RegistryObject<Item> Totem_of_fall = Items.register("totem_of_fall", () -> new Item(new Item.Properties().maxStackSize(1).group(SRTDItemsGroup.srtd)));
    public static final RegistryObject<Item> Totem_of_health = Items.register("totem_of_health", () -> new Item(new Item.Properties().maxStackSize(1).group(SRTDItemsGroup.srtd)));
    public static final RegistryObject<Item> Cereal = Items.register("cereal", () -> new Item(new Item.Properties().group(SRTDItemsGroup.srtd)));
    public static final RegistryObject<Item> Chocolate_bar = Items.register("chocolate_bar", () -> new Item(new Item.Properties().group(SRTDItemsGroup.srtd).food(new Food.Builder().hunger(5).saturation(0.9F).effect(() -> new EffectInstance(Effects.SPEED, 20*120, 0), 1f).build())))));
    public static final RegistryObject<Item> Apple_bar = Items.register("apple_bar", () -> new Item(new Item.Properties().group(SRTDItemsGroup.srtd).food(new Food.Builder().hunger(5).saturation(0.9F).effect(() -> new EffectInstance(Effects.HASTE, 20*120, 0), 1f).build()))))); 
    public static final RegistryObject<Item> Night_helmet = Items.register("night_helmet", () -> new ArmorItem(ArmorMaterial.IRON, EquipmentSlotType.HEAD, new Item.Properties().group(SRTDItemsGroup.srtd)));
}