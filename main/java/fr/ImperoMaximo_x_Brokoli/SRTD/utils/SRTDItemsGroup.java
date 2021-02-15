package fr.ImperoMaximo_x_Brokoli.SRTD.utils;

import fr.ImperoMaximo_x_Brokoli.SRTD.items.SRTDItems;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;

public class SRTDItemsGroup {

    public static final ItemGroup srtd = new ItemGroup("srtd") {
        @Override
        public ItemStack createIcon() {
            return new ItemStack(SRTDItems.srtd_Icon.get());
        }
    };

}