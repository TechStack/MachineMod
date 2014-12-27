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

public class BlockMachineDrilledStone extends BlockMachineModManyTexture{

	public BlockMachineDrilledStone()
	{
		super();
		this.setBlockName(Reference.MODBLOCK_MACHINE_DRILLED_STONE);
		this.setBlockTextureName(Reference.MODBLOCK_MACHINE_DRILLED_STONE);
		//this.setHardness(15f);// not sure on the hardness
		this.setStepSound(soundTypeStone);
	}

}
