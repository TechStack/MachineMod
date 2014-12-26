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

public class BlockMachineDrilledStone extends BlockMachineMod{

	public BlockMachineDrilledStone()
	{
		super();
		this.setBlockName(Reference.MODBLOCK_MACHINE_DRILLED_STONE);
		this.setBlockTextureName(Reference.MODBLOCK_MACHINE_DRILLED_STONE);
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

		
		if (!world.isRemote){
			

		Explosion explosion = world.createExplosion( (Entity)null, x,y,z, 4.0F, true );
		//		explosion.affectedBlockPositions

		ChunkPosition chunkposition;
		int i;
		int j;
		int k;
		Block block;
		LogHelper.info("in Detonate for X,Y,Z: "+  x + " " + y + " " + z );

		Iterator<ChunkPosition> iterator = explosion.affectedBlockPositions.iterator();
		while (iterator.hasNext()){

			chunkposition =iterator.next();
			i = chunkposition.chunkPosX;
			j = chunkposition.chunkPosY;
			k = chunkposition.chunkPosZ;

			
			LogHelper.info("in Detonate for i,j,k: "+  i + " " + j + " " + k );

			block = world.getBlock(i, j,k);
			if (block instanceof  BlockMachineDrilledStone ){
				 ( (BlockMachineDrilledStone) block).detonate(world, i, j,k );
			}
			LogHelper.info( block);
			if (block instanceof BlockStone || block instanceof BlockDirt || block instanceof BlockGrass)
			{

				LogHelper.info("TYPE DIRT LIKE");
				if (j > y) // block is above the detonation point!
				{
					// turn to entity falling sand type?
					LogHelper.info("ITS HIGER");

					world.setBlock(i,j,k,  Blocks.anvil);
					
				}
			}

		}
		explosion.affectedBlockPositions.clear();
		

		world.setBlockToAir(x,y,z);
		}


	}

}
