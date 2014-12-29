package com.projectreddog.machinemod.entity;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

import com.projectreddog.machinemod.init.ModNetwork;
import com.projectreddog.machinemod.network.MachineModMessageEntityToClient;
import com.projectreddog.machinemod.utility.LogHelper;

import cpw.mods.fml.common.network.NetworkRegistry.TargetPoint;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class EntityMachineModRideable extends Entity {

	public double velocity;
	public float yaw;

	public boolean isPlayerAccelerating=false;
	public boolean isPlayerBreaking =false;
	public boolean isPlayerTurningRight=false;
	public boolean isPlayerTurningLeft=false;

	public double TargetposX;
	public double TargetposY;
	public double TargetposZ;
	public float TargetYaw;
    public int MoveTickCount;
	public int YawTickCount;
	public EntityMachineModRideable(World world){
		super(world);
		setSize (1.5F , 0.6F); // should be overridden in Extened version.

	}

	public double getMaxVelocity(){
		// created as method so extending class can easily override to allow for different speeds per machine
		return 0.2d;
	}
	@Override
	public AxisAlignedBB getBoundingBox(){
		return boundingBox;
	}

	@Override 
	public AxisAlignedBB getCollisionBox(Entity entity){
		if (entity != riddenByEntity){
			return entity.boundingBox; 
		}
		else{
			return null;// do not colide with the rider
		}
	}

	@Override 
	public boolean canBeCollidedWith(){
		return !isDead;
	}

	@Override
	public boolean interactFirst(EntityPlayer player) // should be proper class
	{
		if (!worldObj.isRemote && riddenByEntity==null){
			// server side and no rider
			player.mountEntity(this);
		}
		return true;
	}

	@Override
	public double getMountedYOffset(){
		// should be overriden in exteneded class if not default;
		return -0.15;
	}
	
	
	
	public void updateServer() {
		if ( isPlayerAccelerating){
			this.velocity += .1d;
		}
		if ( isPlayerBreaking){
			this.velocity -= .1d;
		}
		if (isPlayerTurningRight){
			yaw +=1.5d;
		}
		if (isPlayerTurningLeft){
			yaw -=1.5d;
		}
		//end take user input
		
		// Clamp values to max / min values as needed 
		if (this.velocity> this.getMaxVelocity()){
			this.velocity = this.getMaxVelocity();
		}else if(this.velocity < this.getMaxVelocity()*-1){
			this.velocity=this.getMaxVelocity()*-1; 
		}
		if (this.velocity <0.0001d && this.velocity > 0.0d){
			this.velocity=0d;
			
		}else if (this.velocity >-0.0001d && this.velocity < 0.0d){
			this.velocity=0d;
		}
		if (this.yaw>360 ){
			this.yaw =this.yaw-360;
		}else  if (this.yaw<0 ){
			this.yaw =360-this.yaw;
		}
		//END Clamp values to max / min values as needed
		
		// calc x & Z offsets needed for the given rotation & velocity
		double speedX =(velocity * MathHelper.cos((float) ((yaw+90) * Math.PI / 180.0D)));
		double speedZ= (velocity * MathHelper.sin((float) ((yaw+90)* Math.PI / 180.0D))); 
		double speedY=0;
		
		motionY= speedY;
		motionX = speedX;
		motionZ = speedZ;
		this.velocity*=.90;// apply friction
		setRotation(this.yaw, this.rotationPitch);
		if (worldObj.isAirBlock((int) posX, (int) posY -1, (int)posZ )){
			speedY= -0.15;
		}else{
			speedY =0;
		}
		setPosition( posX+speedX,posY+motionY, posZ+speedZ);
		//moveEntity( motionX,motionY,  motionZ);
		
		

		
		
        ModNetwork.simpleNetworkWrapper.sendToAllAround((new MachineModMessageEntityToClient( this.getEntityId(),this.posX,this.posY,this.posZ,this.yaw)), new TargetPoint(worldObj.provider.dimensionId, posX, posY, posZ, 80));
	}
	
	public void updateClient(){
		//updateServer();
		
		this.noClip = true;
		this.motionX = 0;
		this.motionY = 0;
		this.motionZ = 0;
		  
	
//		
//		if(TargetYaw!=yaw){
//			YawTickCount=3;
//		}
//		
		
			this.motionX = (this.TargetposX -this.posX )/(3);
			this.motionY = (this.TargetposY -this.posY )/(3);
			this.motionZ = (this.TargetposZ -this.posZ )/(3);
			setPosition( posX+motionX,posY+motionY, posZ+motionZ);

//
//		
//		if(YawTickCount>0){
//			
//			this.rotationYaw += (TargetYaw -yaw)/YawTickCount;
//			YawTickCount--;
//		}
//		if (YawTickCount==0){
//			this.rotationYaw=TargetYaw;
//		}
	}
	
	 @SideOnly(Side.CLIENT)
	    public void setPositionAndRotation2(double p_70056_1_, double p_70056_3_, double p_70056_5_, float p_70056_7_, float p_70056_8_, int p_70056_9_)
	    {
		 
	    }
	 @SideOnly(Side.CLIENT)
	    public void setPositionAndRotation(double p_70056_1_, double p_70056_3_, double p_70056_5_, float p_70056_7_, float p_70056_8_, int p_70056_9_)
	    {
		 
	    }
	 
	
	@Override
	public void onUpdate(){
		if (riddenByEntity != null){
			if(!worldObj.isRemote){
				//server side
				updateServer();
			
			}else{
				// client

				updateClient();
			}
		
		}
		
		
		
		//set position on both sides for visual (less jerky) on client & server
		if (riddenByEntity != null){
   LogHelper.info ("X: "+ posX +" Y: "+ posY + "Z " + posZ +" yaw:"+ yaw +" speedx:" + motionX + "speedZ: "+ motionZ);
		}

	}
	
	
	public void updateRiderPosition()
	{
		if (this.riddenByEntity != null)
		{
			double d0 = Math.cos((double)this.rotationYaw * Math.PI / 180.0D) * this.velocity;
			double d1 = Math.sin((double)this.rotationYaw * Math.PI / 180.0D) * this.velocity;
			this.riddenByEntity.setPosition(this.posX + d0, this.posY + this.getMountedYOffset() + this.riddenByEntity.getYOffset(), this.posZ + d1);
			this.riddenByEntity.setRotationYawHead(this.yaw);
		}
	}

	@Override
	protected void entityInit() {
		// TODO Auto-generated method stub

	}

	@Override
	protected void readEntityFromNBT(NBTTagCompound p_70037_1_) {
		// TODO Auto-generated method stub

	}

	@Override
	protected void writeEntityToNBT(NBTTagCompound p_70014_1_) {
		// TODO Auto-generated method stub

	}
}
