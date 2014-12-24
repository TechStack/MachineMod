package com.projectreddog.machinemod.block;

public class BlockMachineAssemblyTable extends BlockMachineMod{

	public BlockMachineAssemblyTable()
	{
		super();
		this.setBlockName("machineassemblytable");
		this.setBlockTextureName("machineassemblytable");
		this.setHardness(15f);// not sure on the hardness
		this.setStepSound(soundTypeMetal);
		
	}
}
