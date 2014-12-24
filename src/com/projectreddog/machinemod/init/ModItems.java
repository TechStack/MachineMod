package com.projectreddog.machinemod.init;

import com.projectreddog.machinemod.item.ItemBulldozer;
import com.projectreddog.machinemod.item.ItemMachineMod;

import cpw.mods.fml.common.registry.GameRegistry;

public class ModItems {

	public static final ItemMachineMod bulldozer = new ItemBulldozer();
	
	public static void init()
	{
		GameRegistry.registerItem(bulldozer,"bulldozer");
	}
}
