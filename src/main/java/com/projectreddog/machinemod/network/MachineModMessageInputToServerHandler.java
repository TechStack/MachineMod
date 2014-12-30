package com.projectreddog.machinemod.network;

import net.minecraft.entity.Entity;

import com.projectreddog.machinemod.entity.EntityMachineModRideable;

import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.IMessageHandler;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;

public class MachineModMessageInputToServerHandler  implements IMessageHandler<MachineModMessageInputToServer,IMessage>{


	@Override
	public IMessage onMessage(MachineModMessageInputToServer message, MessageContext ctx) {
		
	   Entity entity=	ctx.getServerHandler().playerEntity.worldObj.getEntityByID(message.entityid);
		if (entity instanceof EntityMachineModRideable )
		{
			if (( (EntityMachineModRideable) entity).riddenByEntity == ctx.getServerHandler().playerEntity)
			{
				//its ridden by this player (avoid some hacks) 
				( (EntityMachineModRideable) entity).isPlayerAccelerating= message.isPlayerAccelerating;
				( (EntityMachineModRideable) entity).isPlayerBreaking = message.isPlayerBreaking;
				( (EntityMachineModRideable) entity).isPlayerTurningLeft = message.isPlayerTurningLeft;
				( (EntityMachineModRideable) entity).isPlayerTurningRight = message.isPlayerTurningRight;
				( (EntityMachineModRideable) entity).isPlayerPushingSprintButton = message.isPlayerPushingSprintButton;
				
			}
		}
		
		return null;
	}
}
