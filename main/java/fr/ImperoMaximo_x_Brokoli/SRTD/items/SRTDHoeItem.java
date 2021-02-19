package fr.ImperoMaximo_x_Brokoli.SRTD.items;

import java.util.Map;
import java.util.Set;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Maps;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.IItemTier;
import net.minecraft.item.Item;
import net.minecraft.item.ItemUseContext;
import net.minecraft.item.ToolItem;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Direction;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class SRTDHoeItem extends ToolItem {
	   private static final Set<Block> EFFECTIVE_ON_BLOCKS = ImmutableSet.of(Blocks.NETHER_WART_BLOCK, Blocks.WARPED_WART_BLOCK, Blocks.HAY_BLOCK, Blocks.DRIED_KELP_BLOCK, Blocks.TARGET, Blocks.SHROOMLIGHT, Blocks.SPONGE, Blocks.WET_SPONGE, Blocks.JUNGLE_LEAVES, Blocks.OAK_LEAVES, Blocks.SPRUCE_LEAVES, Blocks.DARK_OAK_LEAVES, Blocks.ACACIA_LEAVES, Blocks.BIRCH_LEAVES);
	   protected static final Map<Block, BlockState> HOE_LOOKUP = Maps.newHashMap(ImmutableMap.of(Blocks.GRASS_BLOCK, Blocks.FARMLAND.getDefaultState(), Blocks.GRASS_PATH, Blocks.FARMLAND.getDefaultState(), Blocks.DIRT, Blocks.FARMLAND.getDefaultState(), Blocks.COARSE_DIRT, Blocks.DIRT.getDefaultState()));
	   
	   public SRTDHoeItem(IItemTier itemTier, int attackDamage, float attackSpeed, Item.Properties properties) {
	      super((float)attackDamage, attackSpeed, itemTier, EFFECTIVE_ON_BLOCKS, properties.addToolType(net.minecraftforge.common.ToolType.HOE, itemTier.getHarvestLevel()));
	   }


	/**
	    * Called when this item is used when targetting a Block
	    */
	   public ActionResultType onItemUse(ItemUseContext context) {
		     World world = context.getWorld();
		     BlockPos blockpos = context.getPos();
		     BlockPos blockposEast = new BlockPos(blockpos.getX() + 1, blockpos.getY(), blockpos.getZ());
		     BlockPos blockposWest = new BlockPos(blockpos.getX() - 1, blockpos.getY(), blockpos.getZ());
		     BlockPos blockposNorth = new BlockPos(blockpos.getX(), blockpos.getY(), blockpos.getZ() + 1);
		     BlockPos blockposSouth = new BlockPos(blockpos.getX(), blockpos.getY(), blockpos.getZ() - 1);
		     BlockPos blockposNorthEast = new BlockPos(blockpos.getX() + 1, blockpos.getY(), blockpos.getZ() + 1);
		     BlockPos blockposSouthEast = new BlockPos(blockpos.getX() + 1, blockpos.getY(), blockpos.getZ() - 1);
		     BlockPos blockposNorthWest = new BlockPos(blockpos.getX() - 1, blockpos.getY(), blockpos.getZ() + 1);
		     BlockPos blockposSouthWest = new BlockPos(blockpos.getX() - 1, blockpos.getY(), blockpos.getZ() - 1);
		     
		     BlockState blockstate = world.getBlockState(blockpos).getToolModifiedState(world, blockpos, context.getPlayer(), context.getItem(), net.minecraftforge.common.ToolType.HOE);
		     BlockState blockstateEast = world.getBlockState(blockposEast).getToolModifiedState(world, blockposEast, context.getPlayer(), context.getItem(), net.minecraftforge.common.ToolType.HOE);
		     BlockState blockstateWest = world.getBlockState(blockposWest).getToolModifiedState(world, blockposWest, context.getPlayer(), context.getItem(), net.minecraftforge.common.ToolType.HOE);
		     BlockState blockstateNorth = world.getBlockState(blockposNorth).getToolModifiedState(world, blockposNorth, context.getPlayer(), context.getItem(), net.minecraftforge.common.ToolType.HOE);
		     BlockState blockstateSouth = world.getBlockState(blockposSouth).getToolModifiedState(world, blockposSouth, context.getPlayer(), context.getItem(), net.minecraftforge.common.ToolType.HOE);
		     BlockState blockstateNorthEast = world.getBlockState(blockposNorthEast).getToolModifiedState(world, blockposNorthEast, context.getPlayer(), context.getItem(), net.minecraftforge.common.ToolType.HOE);
		     BlockState blockstateSouthEast = world.getBlockState(blockposSouthEast).getToolModifiedState(world, blockposSouthEast, context.getPlayer(), context.getItem(), net.minecraftforge.common.ToolType.HOE);
		     BlockState blockstateNorthWest = world.getBlockState(blockposNorthWest).getToolModifiedState(world, blockposNorthWest, context.getPlayer(), context.getItem(), net.minecraftforge.common.ToolType.HOE);
		     BlockState blockstateSouthWest = world.getBlockState(blockposSouthWest).getToolModifiedState(world, blockposSouthWest, context.getPlayer(), context.getItem(), net.minecraftforge.common.ToolType.HOE);

			 if (context.getFace() != Direction.DOWN && world.isAirBlock(blockpos.up())) {
			 if (blockstate != null) {
				 PlayerEntity playerentity = context.getPlayer();
				 world.playSound(playerentity, blockpos, SoundEvents.ITEM_HOE_TILL, SoundCategory.BLOCKS, 1.0F, 1.0F);
				 if (!world.isRemote) {
					 world.setBlockState(blockpos, blockstate, 11);
					 if (blockstateEast != null && !world.isRemote) {world.setBlockState(blockposEast, blockstateEast, 11);}
					 if (blockstateWest != null && !world.isRemote) {world.setBlockState(blockposWest, blockstateWest, 11);}
					 if (blockstateNorth != null && !world.isRemote) {world.setBlockState(blockposNorth, blockstateNorth, 11);}
					 if (blockstateSouth != null && !world.isRemote) {world.setBlockState(blockposSouth, blockstateSouth, 11);}
					 if (blockstateNorthEast != null && !world.isRemote) {world.setBlockState(blockposNorthEast, blockstateNorthEast, 11);}
					 if (blockstateNorthWest != null && !world.isRemote) {world.setBlockState(blockposNorthWest, blockstateNorthWest, 11);}
					 if (blockstateSouthEast != null && !world.isRemote) {world.setBlockState(blockposSouthEast, blockstateSouthEast, 11);}
					 if (blockstateSouthWest != null && !world.isRemote) {world.setBlockState(blockposSouthWest, blockstateSouthWest, 11);}
					 if (playerentity != null) {context.getItem().damageItem(1, playerentity, (player) -> {player.sendBreakAnimation(context.getHand());});}
				 }
				 return ActionResultType.func_233537_a_(world.isRemote);
			 }
			 }
			 return ActionResultType.PASS;
	   }
	   
	   @javax.annotation.Nullable
	   public static BlockState getHoeTillingState(BlockState originalState) {
		   return HOE_LOOKUP.get(originalState.getBlock());
	   }
}