package com.projectreddog.machinemod.block;

import java.util.Iterator;

import net.minecraft.block.Block;
import net.minecraft.block.BlockDirt;
import net.minecraft.block.BlockGrass;
import net.minecraft.block.BlockStone;
import net.minecraft.entity.Entity;
import net.minecraft.init.Blocks;
import net.minecraft.world.ChunkPosition; 
import net.minecraft.world.Explosion;
import net.minecraft.world.World;

import com.projectreddog.machinemod.reference.Reference;
import com.projectreddog.machinemod.utility.LogHelper;
import com.projectreddog.machinemod.world.ModExplosion;
public class BlockMachineExplosivePackedDrilledStone extends BlockMachineModManyTexture {
	public BlockMachineExplosivePackedDrilledStone()
	{
		super();
		this.setBlockName(Reference.MODBLOCK_MACHINE_EXPLOSIVE_PACKED_DRILLED_STONE);
		this.setBlockTextureName(Reference.MODBLOCK_MACHINE_EXPLOSIVE_PACKED_DRILLED_STONE);
		//this.setHardness(15f);// not sure on the hardness
		this.setStepSound(soundTypeStone);
	}

	@Override 
	public void onNeighborBlockChange(World world, int x, int y, int z, Block block)
	{
		if (world.isBlockIndirectlyGettingPowered(x ,y,z) ){
			detonate(world, x, y, z);		
		}
	}


	@Override
	public void onBlockDestroyedByExplosion(World world, int x, int y, int z, Explosion explosion){

		detonate(world, x, y, z);
	}


	public void detonate(World world,int x,int y,int z)
	{	


		//if (!world.isRemote){


			ModExplosion explosion = newExplosion( world, x,y,z, 4.0F, false,true);
			
			//world.createExplosion(p_72876_1_, p_72876_2_, p_72876_4_, p_72876_6_, p_72876_8_, p_72876_9_)
			//		explosion.affectedBlockPositions



			//world.setBlockToAir(x,y,z);
		//}


	}
	
	
	//	(World p_i1948_1_, Entity p_i1948_2_, double p_i1948_3_, 			double p_i1948_5_, double p_i1948_7_, float size)
	   /**
     * returns a new explosion. Does initiation (at time of writing Explosion is not finished)
     */
    public ModExplosion newExplosion(World world, double x, double y, double z, float size, boolean flameing, boolean smoking)
    {
    	
    	ModExplosion explosion = new ModExplosion( world,(Entity)null , x, y, z, size);
        explosion.isFlaming = flameing;
        explosion.isSmoking = smoking;
        explosion.doExplosionA();
        explosion.doExplosionB(true);
        return explosion;
    }


}
