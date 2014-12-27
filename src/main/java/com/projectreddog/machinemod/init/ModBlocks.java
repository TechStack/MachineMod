package com.projectreddog.machinemod.init;

import com.projectreddog.machinemod.block.BlockMachineAssemblyTable;
import com.projectreddog.machinemod.block.BlockMachineDrilledStone;
import com.projectreddog.machinemod.block.BlockMachineExplosivePackedDrilledStone;
import com.projectreddog.machinemod.block.BlockMachineMod;
import com.projectreddog.machinemod.block.BlockMachineModBlastedStone;
import com.projectreddog.machinemod.reference.Reference;

import cpw.mods.fml.common.registry.GameRegistry;


@GameRegistry.ObjectHolder(Reference.MOD_ID)
public class ModBlocks {
	public static final BlockMachineMod machineassemblytable= new BlockMachineAssemblyTable();
	public static final BlockMachineMod machinedrilledstone= new BlockMachineDrilledStone();
	public static final BlockMachineMod machineexplosivepackeddrilledstone= new BlockMachineExplosivePackedDrilledStone();
	public static final BlockMachineMod machinemodblastesStone  = new BlockMachineModBlastedStone();
	public static void init()
	{
		GameRegistry.registerBlock(machineassemblytable,  Reference.MODBLOCK_MACHINE_ASSEMBLY_TABLE);
		GameRegistry.registerBlock(machinedrilledstone,  Reference.MODBLOCK_MACHINE_DRILLED_STONE);
		GameRegistry.registerBlock(machineexplosivepackeddrilledstone, Reference.MODBLOCK_MACHINE_EXPLOSIVE_PACKED_DRILLED_STONE);
		GameRegistry.registerBlock(machinemodblastesStone, Reference.MODBLOCK_MACHINE_BLASTED_STONE);

	}
}
