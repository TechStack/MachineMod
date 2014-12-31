package com.projectreddog.machinemod.init;

import net.minecraftforge.fml.common.registry.GameRegistry;

import com.projectreddog.machinemod.item.ItemBulldozer;
import com.projectreddog.machinemod.item.ItemDrillingRig;
import com.projectreddog.machinemod.item.ItemDumpTruck;
import com.projectreddog.machinemod.item.ItemMachineMod;
import com.projectreddog.machinemod.reference.Reference;


@GameRegistry.ObjectHolder(Reference.MOD_ID)
public class ModItems {

	public static final ItemMachineMod bulldozer = new ItemBulldozer();

	public static final ItemMachineMod drillingrig = new ItemDrillingRig();
	public static final ItemMachineMod dumptruck= new ItemDumpTruck();
	public static void init()
	{
		GameRegistry.registerItem(bulldozer,"bulldozer");
		GameRegistry.registerItem(drillingrig,"drillingrig");
		GameRegistry.registerItem(dumptruck,"dumptruck");


	}
}
