package com.projectreddog.machinemod;

import com.projectreddog.machinemod.proxy.IProxy;
import com.projectreddog.machinemod.reference.Reference;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

@Mod (modid= Reference.MOD_ID, name= Reference.MOD_NAME,version=Reference.VERSION)
public class MachineMod {

	@SidedProxy(clientSide=Reference.CLIENT_PROXY_CLASS,serverSide=Reference.SERVER_PROXY_CLASS)
	public static IProxy proxy;
	
	@Mod.Instance( Reference.MOD_ID)
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
