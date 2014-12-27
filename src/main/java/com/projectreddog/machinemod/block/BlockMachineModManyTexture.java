package com.projectreddog.machinemod.block;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.util.IIcon;

public class BlockMachineModManyTexture extends BlockMachineMod {
	public IIcon[] icons = new IIcon[6];
	
	@Override
	public void registerBlockIcons(IIconRegister reg) {
	    for (int i = 0; i < 6; i ++) {
	        this.icons[i] = reg.registerIcon(this.getUnlocalizedName().substring(this.getUnlocalizedName().indexOf(".")+1) + "_" + i);
	    }
	}
	
	
	@Override
	public IIcon getIcon(int side, int meta) {
	    return this.icons[side];
	}
	
	
}
