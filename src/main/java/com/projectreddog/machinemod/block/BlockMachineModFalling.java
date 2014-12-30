package com.projectreddog.machinemod.block;

import java.util.Random;

import com.projectreddog.machinemod.init.ModBlocks;
import com.projectreddog.machinemod.utility.LogHelper;

import net.minecraft.block.Block;
import net.minecraft.entity.item.EntityFallingBlock;
import net.minecraft.init.Blocks;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class BlockMachineModFalling  extends BlockMachineMod {
	public static boolean fallInstantly;

	private float motionX=0f;
	private float motionZ=0f;
	private float motionY=0f;

	public BlockMachineModFalling()
	{
		super();

	}

	public void onBlockAdded(World world, int x, int y, int z)
	{
		world.scheduleBlockUpdate(x, y, z, this, this.tickRate(world));
	}
	/**
	 * Lets the block know when one of its neighbor changes. Doesn't know which neighbor changed (coordinates passed are
	 * their own) Args: x, y, z, neighbor Block
	 */
	public void onNeighborBlockChange(World world, int x, int y, int z, Block block)
	{
		world.scheduleBlockUpdate(x, y, z, this, this.tickRate(world));
		if (world.getBlock(x,y+1, z)== ModBlocks.machinemodblastesStone){
			world.scheduleBlockUpdate(x, y+1, z, this, this.tickRate(world));
		}
	}



	/**
	 * Ticks the block if it's been scheduled
	 */
	public void updateTick(World world, int x, int y, int z, Random p_149674_5_)
	{
		if (!world.isRemote)
		{
			this.fall(world, x, y, z);
		}
	}

	private void fall(World world, int x, int y, int z)
	{
		if (canFallMore(world, x, y , z) && y >= 0)
		{
			byte b0 = 32;

			if (!fallInstantly && world.checkChunksExist(x - b0, y - b0, z - b0, x + b0, y + b0, z + b0))
			{
				if (!world.isRemote)
				{
					
					LogHelper.info("X:" + this.motionX + " Y:" + this.motionY + " Z:"+ this.motionZ);
					EntityFallingBlock entityfallingblock = new EntityFallingBlock(world, (double)((float)x + 0.5F), (double)((float)y + 0.5F), (double)((float)z + 0.5F), this);
					//TS removed
					// this.func_149829_a(entityfallingblock);
					
					entityfallingblock.motionX+=this.motionX;
					entityfallingblock.motionY+=this.motionY;
					entityfallingblock.motionZ+=this.motionZ;
				
					//world.setBlockToAir(x, y, z);


					world.spawnEntityInWorld(entityfallingblock);
				}
			}
			else
			{
				world.setBlockToAir(x, y, z);

				while (canFallMore(world, x, y - 1, z) && y > 0)
				{
					--y;
				}

				if (y > 0)
				{
					world.setBlock(x, y, z, this);
				}
			}
		}
	}
	//TS removed
	//protected void func_149829_a(EntityFallingBlock p_149829_1_) {}


	public  boolean canFallMore(World world, int x, int y, int z)
	{
		this.motionX =0;
		this.motionZ =0;
		this.motionY=0;
		Block block2 ;
		Block block = world.getBlock(x, y-1, z);
		if (block== Blocks.air ||block == Blocks.fire)// test fall down this x z
		{

			return true;
		}

		for (int i=-1; i<2 ; i++){
			for (int j=-1; j<2 ; j++){

				if ((MathHelper.abs_int(i) ==1 && j==0) || (i ==0 && MathHelper.abs_int(j)==1) )
				{
					block = world.getBlock(x+i, y, z+j);
					if (block== Blocks.air ||block == Blocks.fire)// test fall down this x+1 z
					{
						block2 = world.getBlock(x+i, y-1, z+j);
						if (block2== Blocks.air ||block2 == Blocks.fire)
						{

//							this.motionX =i*1f;
//							this.motionZ =j*1f;
//							this.motionY =1f;
							world.setBlockToAir(x, y, z);
							world.setBlock(x+i, y-1, z+j, this);
							return false;
						}		
					}
				}
			}
		}


		return false;

	}







	/**
	 * How many world ticks before ticking
	 */
	public int tickRate(World world)
	{
		return 2;
	}

}
