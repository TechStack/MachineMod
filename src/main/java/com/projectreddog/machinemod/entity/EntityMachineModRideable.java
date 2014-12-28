package com.projectreddog.machinemod.entity;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.World;

public class EntityMachineModRideable extends Entity {

	public float velocity;
	public float yaw;

	public boolean isPlayerAccelerating=false;
	public boolean isPlayerBreaking =false;
	public boolean isPlayerTurningRight=false;
	public boolean isPlayerTurningLeft=false;


	public EntityMachineModRideable(World world){
		super(world);
		setSize (1.5F , 0.6F); // should be overridden in Extened version.

	}

	public float getMaxVelocity(){
		// created as method so extending class can easily override to allow for different speeds per machine
		return 1;
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
	@Override
	public void onUpdate(){
		if(!worldObj.isRemote){//server side
			if (riddenByEntity != null){
				
			}else{
				// no rider


			}
			if (worldObj.isAirBlock((int) posX, (int) posY -1, (int)posZ )){
				motionY= -0.15;
			}else{
				motionY =0;
			}
		}
		//take user input
		if ( isPlayerAccelerating){
			this.velocity +=+.5;
		}
		if ( isPlayerBreaking){
			this.velocity -= .5;
		}
		if (isPlayerTurningRight){
			yaw +=1;
		}
		if (isPlayerTurningLeft){
			yaw -=1;
		}
		//end take user input
		
		// Clamp values to max / min values as needed 
		if (this.velocity> this.getMaxVelocity()){
			this.velocity = this.getMaxVelocity();
		}else if(this.velocity < this.getMaxVelocity()*-1){
			this.velocity=this.getMaxVelocity()*-1; 
		}
		if (this.yaw>360 ){
			this.yaw =0;
		}else  if (this.yaw<0 ){
			this.yaw =360;
		}
		//END Clamp values to max / min values as needed
		
		// calc x & Z offsets needed for the given rotation & velocity
		float speedX = (float) (velocity * Math.cos((double)yaw+90));
		float speedZ= (float) (velocity * Math.sin((double)yaw+90)); 
		motionX=speedX;
		motionZ=speedZ;
		this.velocity*=.90;// apply friction
		//set position on both sides for visual (less jerky) on client & server
		setRotation(this.yaw, this.rotationPitch);
		setPosition( posX+motionX, posY+motionY, posZ+motionZ);


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
