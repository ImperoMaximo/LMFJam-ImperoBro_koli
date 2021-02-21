package fr.ImperoMaximo_x_Brokoli.SRTD.blocks;

import java.util.function.Supplier;

import fr.ImperoMaximo_x_Brokoli.SRTD.srtd;
import fr.ImperoMaximo_x_Brokoli.SRTD.items.SRTDItems;
import fr.ImperoMaximo_x_Brokoli.SRTD.utils.SRTDItemsGroup;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class SRTDBlocks {
	
    public static final DeferredRegister<Block> Blocks = DeferredRegister.create(ForgeRegistries.BLOCKS, srtd.MOD_ID);

    public static final RegistryObject<Block> bamboo_ladder_vine = createBlock("bamboo_ladder_vine", () -> new bambooLadderVine(AbstractBlock.Properties.create(Material.TALL_PLANTS).doesNotBlockMovement().tickRandomly().hardnessAndResistance(0.2F).sound(SoundType.VINE)));

    public static RegistryObject<Block> createBlock(String name, Supplier<? extends Block> supplier)
    {
        RegistryObject<Block> block = Blocks.register(name, supplier);
        SRTDItems.Items.register(name, () -> new BlockItem(block.get(), new Item.Properties().maxStackSize(1).group(SRTDItemsGroup.srtd)));
        return block;
    }
}