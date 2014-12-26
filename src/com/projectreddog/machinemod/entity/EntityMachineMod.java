package com.projectreddog.machinemod.entity;



import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;

public class EntityMachineMod extends Entity {

	
	


	public EntityMachineMod(World world)
	{
		
		super(world);
	}

	@Override
	protected void entityInit() {
		// TODO Auto-generated method stub
	}

	@Override
	public boolean shouldRiderSit()
	{
		return true;
	}
	
	@Override
	public boolean canBeCollidedWith()
	  {
	  return true;
	  }
	
	public boolean isMountable()
	  {
	  return true;
	  }
	

	@Override
	public boolean interactFirst(EntityPlayer player)
	  {  
		if (this.riddenByEntity ==null){
			// nothing riding this entity so mount this entity
			player.mountEntity(this);
		}
	  return true;
	  }

	
	  @Override
	  public void moveEntity(double d, double d1, double d2)
	  {
	    if (riddenByEntity != null)
	    {
	      this.prevRotationYaw = this.rotationYaw = this.riddenByEntity.rotationYaw;
	      this.rotationPitch = this.riddenByEntity.rotationPitch * 0.5F;
	      this.setRotation(this.rotationYaw, this.rotationPitch);
	      motionX += riddenByEntity.motionX * .05; // * 0.05000000000000001D;
	      motionZ += riddenByEntity.motionZ * .05; // * 0.05000000000000001D;
	     
	      if (motionX > 1)
	      {
	    	  motionX=1;
	      }

	      if (motionZ > 1)
	      {
	    	  motionZ=1;
	      }
	      
	      
	      super.moveEntity(motionX, motionY, motionZ);
	    }
	    else
	    {
	      super.moveEntity(d, d1, d2);
	    }
	  }
	  
	  @Override
	  public void onUpdate() 
	  {
	    super.onUpdate();
	    if (riddenByEntity != null) //check if there is a rider
	    {
	      //currentTarget = this;
	       this.rotationYaw = riddenByEntity.rotationYaw;
	       this.motionX*=.95d;
	       this.motionZ *=.95d;
           this.moveEntity(this.motionX, this.motionY, this.motionZ);

	    }
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
