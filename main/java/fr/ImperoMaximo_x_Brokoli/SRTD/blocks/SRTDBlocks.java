package fr.ImperoMaximo_x_Brokoli.SRTD.blocks;

import java.util.function.Supplier;

import fr.ImperoMaximo_x_Brokoli.SRTD.srtd;
import fr.ImperoMaximo_x_Brokoli.SRTD.items.SRTDItems;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.LadderBlock;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class SRTDBlocks {
	
    public static final DeferredRegister<Block> Blocks = DeferredRegister.create(ForgeRegistries.BLOCKS, srtd.MOD_ID);

    public static final RegistryObject<Block> srtd_block = createBlock("srtd_block", () -> new Block(AbstractBlock.Properties.create(Material.IRON).hardnessAndResistance(7f, 15f).harvestTool(ToolType.PICKAXE).harvestLevel(2)));
    public static final RegistryObject<Block> srtd_ore = createBlock("srtd_ore", () -> new Block(AbstractBlock.Properties.create(Material.ROCK).hardnessAndResistance(5f, 15f).harvestTool(ToolType.PICKAXE).harvestLevel(3)));
    public static final RegistryObject<Block> rift_string = createBlock("rift_string", () -> new LadderBlock(AbstractBlock.Properties.create(Material.MISCELLANEOUS).doesNotBlockMovement().sound(SoundType.LADDER)));

    
    
    public static RegistryObject<Block> createBlock(String name, Supplier<? extends Block> supplier)
    {
        RegistryObject<Block> block = Blocks.register(name, supplier);
        SRTDItems.Items.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
        return block;
    }
}