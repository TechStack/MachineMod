package com.projectreddog.machinemod.tileentities;

import net.minecraft.server.gui.IUpdatePlayerListBox;
import net.minecraft.tileentity.TileEntity;

import com.projectreddog.machinemod.utility.LogHelper;

public class TileEntityDrilingRig extends TileEntity  implements IUpdatePlayerListBox{

	private int current_drilling_level =0;
	private int EnergyLevel =0;
	
	public TileEntityDrilingRig(){
		
	}
	
	public TileEntityDrilingRig(int currentDrillingLevel){
		this.current_drilling_level = currentDrillingLevel;
	}
	
	@Override
    public void update(){

		LogHelper.info("TE update entity called");
	}
	
}
