package com.projectreddog.machinemod;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

@Mod (modid="MachineMod", name="MachineMod",version="1.7.10-1.0-Pre-ALPHA")
public class MachineMod {

	
	@Mod.Instance("MachineMod")
	public static MachineMod instance; // an instance back to this mod
	
	@Mod.EventHandler
	public void preInit(FMLPreInitializationEvent event){
	//net handling mod config init items & blocks	
	}
	@Mod.EventHandler 
	public void init(FMLInitializationEvent event){
		// register gui, tile entites , crafting recipies (general event hanlders)
	}
	
	@Mod.EventHandler
	public void postInit(FMLPostInitializationEvent event){
		// wrap things up .. runs after other mods do there init steps
	}
}
