package com.projectreddog.machinemod.init;

import com.projectreddog.machinemod.block.BlockMachineAssemblyTable;
import com.projectreddog.machinemod.block.BlockMachineMod;
import com.projectreddog.machinemod.reference.Reference;

import cpw.mods.fml.common.registry.GameRegistry;


@GameRegistry.ObjectHolder(Reference.MOD_ID)
public class ModBlocks {
	public static final BlockMachineMod machineassemblytable= new BlockMachineAssemblyTable();
	public static void init()
	{
		GameRegistry.registerBlock(machineassemblytable, "machineassemblytable");
	}
}
