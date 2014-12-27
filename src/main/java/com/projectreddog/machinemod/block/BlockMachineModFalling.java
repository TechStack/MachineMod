package com.projectreddog.machinemod.block;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.item.EntityFallingBlock;
import net.minecraft.init.Blocks;
import net.minecraft.world.Explosion;
import net.minecraft.world.World;

import com.projectreddog.machinemod.creativetab.CreativeTabMachineMod;
import com.projectreddog.machinemod.reference.Reference;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockMachineModFalling  extends BlockMachineMod {
    public static boolean fallInstantly;

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
	        if (canFallMore(world, x, y - 1, z) && y >= 0)
	        {
	            byte b0 = 32;

	            if (!fallInstantly && world.checkChunksExist(x - b0, y - b0, z - b0, x + b0, y + b0, z + b0))
	            {
	                if (!world.isRemote)
	                {
	                    EntityFallingBlock entityfallingblock = new EntityFallingBlock(world, (double)((float)x + 0.5F), (double)((float)y + 0.5F), (double)((float)z + 0.5F), this, world.getBlockMetadata(x, y, z));
	                    //TS removed
	                   // this.func_149829_a(entityfallingblock);
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

	    
	    
	    
	    public static boolean canFallMore(World p_149831_0_, int p_149831_1_, int p_149831_2_, int p_149831_3_)
	    {
	        Block block = p_149831_0_.getBlock(p_149831_1_, p_149831_2_, p_149831_3_);

	        if (block.isAir(p_149831_0_, p_149831_1_, p_149831_2_, p_149831_3_))
	        {
	            return true;
	        }
	        else if (block == Blocks.fire)
	        {
	            return true;
	        }
	        else
	        {
	        	//TS
	            // its not air or fire so it can't fall anymore 
	            
	            return false;
	        }
	    }
	    
	    
	    
	    
	    
	    

	
	  /**
	     * How many world ticks before ticking
	     */
	    public int tickRate(World world)
	    {
	        return 2;
	    }
	
}
