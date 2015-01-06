package com.projectreddog.machinemod.tileentities;

import com.projectreddog.machinemod.utility.LogHelper;

import net.minecraft.tileentity.TileEntity;

public class TileEntityDrilingRig extends TileEntity {

	private int current_drilling_level =0;
	private int EnergyLevel =0;
	
	public TileEntityDrilingRig(){
		
	}
	
	public TileEntityDrilingRig(int currentDrillingLevel){
		this.current_drilling_level = currentDrillingLevel;
	}
	
	public void update(){
		LogHelper.info("TE update entity called");
	}
	
}
