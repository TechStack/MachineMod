package com.projectreddog.machinemod.world;

import java.util.Iterator;
import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityFallingBlock;
import net.minecraft.init.Blocks;
import net.minecraft.util.MathHelper;
import net.minecraft.world.ChunkPosition;
import net.minecraft.world.Explosion;
import net.minecraft.world.World;

import com.projectreddog.machinemod.init.ModBlocks;


public class ModExplosion extends Explosion {

	
    private World worldObj;
    private Random explosionRNG = new Random();

	public ModExplosion(World world, Entity p_i1948_2_, double p_i1948_3_,
			double p_i1948_5_, double p_i1948_7_, float p_i1948_9_) {
		super(world, p_i1948_2_, p_i1948_3_, p_i1948_5_, p_i1948_7_, p_i1948_9_);
		worldObj=world;
	}
	
	
	@Override
	 public void doExplosionB(boolean p_77279_1_)
	    {
	        this.worldObj.playSoundEffect(this.explosionX, this.explosionY, this.explosionZ, "random.explode", 4.0F, (1.0F + (this.worldObj.rand.nextFloat() - this.worldObj.rand.nextFloat()) * 0.2F) * 0.7F);

	        if (this.explosionSize >= 2.0F && this.isSmoking)
	        {
	            this.worldObj.spawnParticle("hugeexplosion", this.explosionX, this.explosionY, this.explosionZ, 1.0D, 0.0D, 0.0D);
	        }
	        else
	        {
	            this.worldObj.spawnParticle("largeexplode", this.explosionX, this.explosionY, this.explosionZ, 1.0D, 0.0D, 0.0D);
	        }

	        Iterator iterator;
	        ChunkPosition chunkposition;
	        int i;
	        int j;
	        int k;
	        Block block;

	        if (this.isSmoking)
	        {
	            iterator = this.affectedBlockPositions.iterator();

	            while (iterator.hasNext())
	            {
	                chunkposition = (ChunkPosition)iterator.next();
	                i = chunkposition.chunkPosX;
	                j = chunkposition.chunkPosY;
	                k = chunkposition.chunkPosZ;
	                block = this.worldObj.getBlock(i, j, k);

	                if (p_77279_1_)
	                {
	                    double d0 = (double)((float)i + this.worldObj.rand.nextFloat());
	                    double d1 = (double)((float)j + this.worldObj.rand.nextFloat());
	                    double d2 = (double)((float)k + this.worldObj.rand.nextFloat());
	                    double d3 = d0 - this.explosionX;
	                    double d4 = d1 - this.explosionY;
	                    double d5 = d2 - this.explosionZ;
	                    double d6 = (double)MathHelper.sqrt_double(d3 * d3 + d4 * d4 + d5 * d5);
	                    d3 /= d6;
	                    d4 /= d6;
	                    d5 /= d6;
	                    double d7 = 0.5D / (d6 / (double)this.explosionSize + 0.1D);
	                    d7 *= (double)(this.worldObj.rand.nextFloat() * this.worldObj.rand.nextFloat() + 0.3F);
	                    d3 *= d7;
	                    d4 *= d7;
	                    d5 *= d7;
	                    this.worldObj.spawnParticle("explode", (d0 + this.explosionX * 1.0D) / 2.0D, (d1 + this.explosionY * 1.0D) / 2.0D, (d2 + this.explosionZ * 1.0D) / 2.0D, d3, d4, d5);
	                    this.worldObj.spawnParticle("smoke", d0, d1, d2, d3, d4, d5);
	                }

	                if (block.getMaterial() != Material.air)
	                {
	                	
	                	//TS DO NOT DROP BLOCKS !
//	                    if (block.canDropFromExplosion(this))
//	                    {
//	                        block.dropBlockAsItemWithChance(this.worldObj, i, j, k, this.worldObj.getBlockMetadata(i, j, k), 1.0F / this.explosionSize, 0);
//	                    }
	                    // TS change next line where it actually breaks the block instead do my call to set the block to the proper type
	                    //block.onBlockExploded(this.worldObj, i, j, k, this);
	                    
	                    changeBlockType(i,j,k, block);
	                }
	            }
	        }

	        if (this.isFlaming)
	        {
	            iterator = this.affectedBlockPositions.iterator();

	            while (iterator.hasNext())
	            {
	                chunkposition = (ChunkPosition)iterator.next();
	                i = chunkposition.chunkPosX;
	                j = chunkposition.chunkPosY;
	                k = chunkposition.chunkPosZ;
	                block = this.worldObj.getBlock(i, j, k);
	                Block block1 = this.worldObj.getBlock(i, j - 1, k);

	                if (block.getMaterial() == Material.air && block1.func_149730_j() && this.explosionRNG.nextInt(3) == 0)
	                {
	                    this.worldObj.setBlock(i, j, k, Blocks.fire);
	                }
	            }
	        }
	    }


	private void changeBlockType( int x, int y, int z,
			Block block) {
				
		if (block ==ModBlocks.machineexplosivepackeddrilledstone){
			// do the explosion!  if it's blasted stone so we can propigate the explosion on to the next block !
			block.onBlockExploded(this.worldObj, x, y,z, this);
		}else {
			
			  if (!this.worldObj.isRemote)
              {
				  
				  //only spawn if its air above the block
//				  if (this.worldObj.isAirBlock(x,y+1, z)||this.worldObj.isAirBlock(x,y+2, z))
//				  {
//	                  EntityFallingBlock entityfallingblock = new EntityFallingBlock(this.worldObj, (double)((float)x + 0.5F), (double)((float)y + 0.7F), (double)((float)z + 0.5F), ModBlocks.machinemodblastesStone, 0);     
//	                  entityfallingblock.motionY=.6d;
//	                  this.worldObj.spawnEntityInWorld(entityfallingblock);
//				  }
    
  //              	 this.worldObj.setBlockToAir(x,y,z); 

                 this.worldObj.setBlock(x,y,z, ModBlocks.machinemodblastesStone,0,3); // may need 3 if still problems
                  
                  
              }
			  
		}	
		
	}


}
