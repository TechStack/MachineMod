package com.projectreddog.machinemod.init;

import com.projectreddog.machinemod.network.MachineModMessageEntityToClient;
import com.projectreddog.machinemod.network.MachineModMessageEntityToClientHandler;
import com.projectreddog.machinemod.network.MachineModMessageInputToServer;
import com.projectreddog.machinemod.network.MachineModMessageInputToServerHandler;
import com.projectreddog.machinemod.reference.Reference;

import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import cpw.mods.fml.relauncher.Side;

public class ModNetwork {

	public static SimpleNetworkWrapper simpleNetworkWrapper;
	
	public static void init(){
		simpleNetworkWrapper = NetworkRegistry.INSTANCE.newSimpleChannel(Reference.MOD_ID);
		simpleNetworkWrapper.registerMessage(MachineModMessageInputToServerHandler.class, MachineModMessageInputToServer.class, 0, Side.SERVER);// message to server
		
		
		simpleNetworkWrapper.registerMessage(MachineModMessageEntityToClientHandler.class, MachineModMessageEntityToClient.class, 1, Side.CLIENT);// message to server

	}
}
