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


		if (!world.isRemote){


			Explosion explosion = world.createExplosion( (Entity)null, x,y,z, 4.0F, true );
			//		explosion.affectedBlockPositions



			world.setBlockToAir(x,y,z);
		}


	}


}
