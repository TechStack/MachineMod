package com.projectreddog.machinemod.proxy;

import com.projectreddog.machinemod.entity.EntityBulldozer;
import com.projectreddog.machinemod.entity.EntityDrillingRig;
import com.projectreddog.machinemod.entity.EntityDumpTruck;
import com.projectreddog.machinemod.render.RenderBulldozer;
import com.projectreddog.machinemod.render.RenderDrillingRig;
import com.projectreddog.machinemod.render.RenderDumpTruck;
import com.projectreddog.machinemod.utility.LogHelper;

import cpw.mods.fml.client.registry.RenderingRegistry;

public class ClientProxy extends CommonProxy {
	@Override
	public void registerRenderers()
	{
		
		LogHelper.info("in register Renderers");
		RenderingRegistry.registerEntityRenderingHandler(EntityBulldozer.class, new RenderBulldozer());
		RenderingRegistry.registerEntityRenderingHandler(EntityDrillingRig.class, new RenderDrillingRig());
		RenderingRegistry.registerEntityRenderingHandler(EntityDumpTruck.class, new RenderDumpTruck());

	}
	
	
}
