package com.projectreddog.machinemod.init;

import com.projectreddog.machinemod.network.MachineModMessage;
import com.projectreddog.machinemod.network.MachineModMessageHandler;
import com.projectreddog.machinemod.reference.Reference;

import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import cpw.mods.fml.relauncher.Side;

public class ModNetwork {

	public static SimpleNetworkWrapper simpleNetworkWrapper;
	
	public static void init(){
		simpleNetworkWrapper = NetworkRegistry.INSTANCE.newSimpleChannel(Reference.MOD_ID);
		simpleNetworkWrapper.registerMessage(MachineModMessageHandler.class, MachineModMessage.class, 0, Side.SERVER);// message to server
	}
}
