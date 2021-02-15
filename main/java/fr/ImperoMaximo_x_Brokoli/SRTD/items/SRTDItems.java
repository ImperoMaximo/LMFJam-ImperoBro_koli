package fr.ImperoMaximo_x_Brokoli.SRTD.items;

import fr.ImperoMaximo_x_Brokoli.SRTD.srtd;
import fr.ImperoMaximo_x_Brokoli.SRTD.utils.SRTDItemsGroup;
import net.minecraft.item.Item;
import net.minecraft.item.ItemTier;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class SRTDItems	{
	
	public static final DeferredRegister<Item> Items = DeferredRegister.create(ForgeRegistries.ITEMS, srtd.MOD_ID);	
    public static final RegistryObject<Item> srtd_Icon = Items.register("srtd_icon", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> hoe = Items.register("hoe", () -> new SRTDHoeItem(ItemTier.DIAMOND, -3, 0.0F, new Item.Properties().group(SRTDItemsGroup.srtd)));
    public static final RegistryObject<Item> rope = Items.register("rope", () -> new Item(new Item.Propreties().maxStackSize(64).group(ItemGroup.MISC)));
}
