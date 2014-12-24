package com.projectreddog.machinemod.proxy;

import com.projectreddog.machinemod.entity.EntityBulldozer;
import com.projectreddog.machinemod.render.RenderBulldozer;
import com.projectreddog.machinemod.utility.LogHelper;

import cpw.mods.fml.client.registry.RenderingRegistry;

public class ClientProxy extends CommonProxy {
	@Override
	public void registerRenderers()
	{
		
		LogHelper.info("in register Renderers");
		RenderingRegistry.registerEntityRenderingHandler(EntityBulldozer.class, new RenderBulldozer());
	
	}
}
