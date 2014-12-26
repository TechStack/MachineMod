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
	protected void readEntityFromNBT(NBTTagCompound p_70037_1_) {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void writeEntityToNBT(NBTTagCompound p_70014_1_) {
		// TODO Auto-generated method stub
		
	}
	

}
