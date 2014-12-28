package com.projectreddog.machinemod.network;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;

import com.projectreddog.machinemod.entity.EntityMachineModRideable;
import com.projectreddog.machinemod.utility.LogHelper;

import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.IMessageHandler;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;

public class MachineModMessageEntityToClientHandler implements IMessageHandler<MachineModMessageEntityToClient,IMessage>{

	@Override
	public IMessage onMessage(MachineModMessageEntityToClient message, MessageContext ctx) {


		Entity entity=Minecraft.getMinecraft().theWorld.getEntityByID( message.entityid);


		if (entity instanceof EntityMachineModRideable )
		{
			//its ridden by this player (avoid some hacks) 
			( (EntityMachineModRideable) entity).TargetposX = message.posX;
			( (EntityMachineModRideable) entity).TargetposY = message.posY;
			( (EntityMachineModRideable) entity).TargetposZ = message.posZ;
			( (EntityMachineModRideable) entity).TargetYaw  =  message.yaw;


			LogHelper.info("RECIEVED ENTITY PACKET FROM SERVER" );
		}



		return null;
	}

}
