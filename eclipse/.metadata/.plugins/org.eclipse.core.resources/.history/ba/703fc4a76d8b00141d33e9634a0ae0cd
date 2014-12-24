package com.projectreddog.machinemod;

import com.projectreddog.machinemod.handler.ConfigurationHandler;
import com.projectreddog.machinemod.init.ModBlocks;
import com.projectreddog.machinemod.init.ModItems;
import com.projectreddog.machinemod.proxy.IProxy;
import com.projectreddog.machinemod.reference.Reference;
import com.projectreddog.machinemod.utility.LogHelper;

import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

@Mod (modid= Reference.MOD_ID, name= Reference.MOD_NAME,version=Reference.VERSION, guiFactory = Reference.GUI_FACTORY_CLASS)
public class MachineMod {

	@SidedProxy(clientSide=Reference.CLIENT_PROXY_CLASS,serverSide=Reference.SERVER_PROXY_CLASS)
	public static IProxy proxy;
	
	@Mod.Instance( Reference.MOD_ID)
	public static MachineMod instance; // an instance back to this mod
	
	@Mod.EventHandler
	public void preInit(FMLPreInitializationEvent event){
	//net handling mod config init items & blocks	
		
		ConfigurationHandler.init(event.getSuggestedConfigurationFile());
		FMLCommonHandler.instance().bus().register(new ConfigurationHandler());
		ModItems.init();
		ModBlocks.init();
	}
	@Mod.EventHandler 
	public void init(FMLInitializationEvent event){
		// register gui, tile entites , crafting recipies (general event hanlders)
	}
	
	@Mod.EventHandler
	public void postInit(FMLPostInitializationEvent event){
		// wrap things up .. runs after other mods do there init steps
		
		LogHelper.debug("Is Bulldozer Enabled: " + Reference.enableBulldozer);
	}
}
