package com.projectreddog.machinemod.init;

import com.projectreddog.machinemod.item.ItemBulldozer;
import com.projectreddog.machinemod.item.ItemDrillingRig;
import com.projectreddog.machinemod.item.ItemMachineMod;
import com.projectreddog.machinemod.reference.Reference;

import cpw.mods.fml.common.registry.GameRegistry;


@GameRegistry.ObjectHolder(Reference.MOD_ID)
public class ModItems {

	public static final ItemMachineMod bulldozer = new ItemBulldozer();

	public static final ItemMachineMod drillingrig = new ItemDrillingRig();
	public static void init()
	{
		GameRegistry.registerItem(bulldozer,"bulldozer");
		GameRegistry.registerItem(drillingrig,"drillingrig");

	}
}
