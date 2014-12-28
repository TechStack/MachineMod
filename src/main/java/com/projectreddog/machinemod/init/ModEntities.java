package com.projectreddog.machinemod.init;

import com.projectreddog.machinemod.entity.EntityBulldozer;
import com.projectreddog.machinemod.entity.EntityDrillingRig;
import com.projectreddog.machinemod.reference.Reference;

import cpw.mods.fml.common.registry.EntityRegistry;
import cpw.mods.fml.common.registry.GameRegistry;

@GameRegistry.ObjectHolder(Reference.MOD_ID)

public class ModEntities {

	
	//public static final EntityBulldozer entityBulldozer= new EntityBulldozer(new World);
	public static void init(Object mod)
	{
		EntityRegistry.registerModEntity(EntityDrillingRig.class, "drillingrig", 1,mod , 80,3,  true);
			EntityRegistry.registerModEntity(EntityBulldozer.class, "bulldozer",2 ,mod , 80,3, true);

	}
}
