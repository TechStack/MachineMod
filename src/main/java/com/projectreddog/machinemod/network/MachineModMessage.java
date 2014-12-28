package com.projectreddog.machinemod.network;

import io.netty.buffer.ByteBuf;
import cpw.mods.fml.common.network.simpleimpl.IMessage;

public class MachineModMessage implements IMessage{

	public int entityid;

	public boolean isPlayerAccelerating=false;
	public boolean isPlayerBreaking =false;
	public boolean isPlayerTurningRight=false;
	public boolean isPlayerTurningLeft=false;
	
	public MachineModMessage()
	{
		
	}
	
	public MachineModMessage(int entityId, boolean isPlayerAccelerating, boolean isPlayerBreaking, boolean isPlayerTurningRight,boolean isPlayerTurningLeft ) {
		super();
		this.isPlayerAccelerating = isPlayerAccelerating;
		this.isPlayerBreaking=isPlayerBreaking;
		this.isPlayerTurningRight=isPlayerTurningRight;
		this.isPlayerTurningLeft = isPlayerTurningLeft;
		this.entityid =entityId;
	}

	
	
	@Override
	public void fromBytes(ByteBuf buf) {
        this.entityid= buf.readInt();
        this.isPlayerAccelerating=buf.readBoolean();
        this.isPlayerBreaking =buf.readBoolean();
        this.isPlayerTurningRight=buf.readBoolean();
        this.isPlayerTurningLeft = buf.readBoolean();

	}

	@Override
	public void toBytes(ByteBuf buf) {
        buf.writeInt(entityid);
        buf.writeBoolean(isPlayerAccelerating);
        buf.writeBoolean(isPlayerBreaking);
        buf.writeBoolean(isPlayerTurningRight);
        buf.writeBoolean(isPlayerTurningLeft);

        
	}

}
