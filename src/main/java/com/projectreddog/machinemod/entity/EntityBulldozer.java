package com.projectreddog.machinemod.entity;

import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class EntityBulldozer extends EntityMachineModRideable {

	public double bladeOffset = 2.0d;
	
	public EntityBulldozer(World world){
		super(world);
	}
	 
   @Override
   /**
    * Returns the Y offset from the entity's position for any entity riding this one.
    */
   public double getMountedYOffset()
   {
       return (double)this.height * 0.35D;
   }

   
  
  @Override
  public void onUpdate(){
	  super.onUpdate();
	  if (!worldObj.isRemote){
		  digMethodA();
			
	  }
  }

  
  public void digMethodA(){

	   
	    int yOffset =0;
		double bladeOffsetX =(bladeOffset * MathHelper.cos((float) ((yaw+90) * Math.PI / 180.0D)));
		double bladeOffsetZ= (bladeOffset * MathHelper.sin((float) ((yaw+90) * Math.PI / 180.0D))); 
	  
		if (this.riddenByEntity != null && this.isPlayerPushingSprintButton){
			yOffset=-1;
		}
		
		
		int x =(int)(this.posX+bladeOffsetX-.5d);
		int y = (int)Math.round(this.posY +yOffset);
		int z= (int)(this.posZ+bladeOffsetZ+.5);
		if (worldObj.getBlock(x,y,z).getMaterial() == Material.grass || worldObj.getBlock(x,y,z).getMaterial() == Material.ground || worldObj.getBlock(x,y,z).getMaterial() == Material.sand ){
			worldObj.getBlock(x,y,z).dropBlockAsItem(worldObj, x, y, z, worldObj.getBlockMetadata(x, y, z) , 0);
			worldObj.setBlockToAir(x,y,z);
		}
		

		double bladeOffsetX2 =(1 * MathHelper.cos((float) ((yaw+90+90) * Math.PI / 180.0D)));
		double bladeOffsetZ2= (1 * MathHelper.sin((float) ((yaw+90+90) * Math.PI / 180.0D))); 
	  
		x =(int)(this.posX+bladeOffsetX+bladeOffsetX2-.5d );
		z= (int)(this.posZ+bladeOffsetZ+bladeOffsetZ2+.5);
		if (worldObj.getBlock(x,y,z).getMaterial() == Material.grass ||worldObj.getBlock(x,y,z).getMaterial() == Material.ground|| worldObj.getBlock(x,y,z).getMaterial() == Material.sand){
			worldObj.getBlock(x,y,z).dropBlockAsItem(worldObj, x, y, z, worldObj.getBlockMetadata(x, y, z) , 0);
			worldObj.setBlockToAir(x,y,z);
		}
		x =(int)(this.posX+bladeOffsetX-bladeOffsetX2-.5d);
		 z= (int)(this.posZ+bladeOffsetZ-bladeOffsetZ2+.5);
		if (worldObj.getBlock(x,y,z).getMaterial() == Material.grass|| worldObj.getBlock(x,y,z).getMaterial() == Material.ground|| worldObj.getBlock(x,y,z).getMaterial() == Material.sand){
			worldObj.getBlock(x,y,z).dropBlockAsItem(worldObj, x, y, z, worldObj.getBlockMetadata(x, y, z) , 0);

			worldObj.setBlockToAir(x,y,z);
		}
		
  }
  
  public int BladePos1X;
  public int BladePos1Z;
  public int BladePos2X;
  public int BladePos2Z;
  public int BladePos3X;
  public int BladePos3Z;
  

  public void setBladePosFromYaw()
  {
	  if ((yaw >=0 && yaw < 23) || yaw >337  ){
		  BladePos1X = (int) Math.round(posX );
		  BladePos1Z = (int) Math.round(posZ+bladeOffset);
		  BladePos2X = (int) Math.round(posX +1);
		  BladePos2Z = (int) Math.round(posZ+bladeOffset);
		  BladePos3X = (int) Math.round(posX -1);
		  BladePos3Z = (int) Math.round(posZ+bladeOffset);
	  }
	  else if (yaw >=23 && yaw < 69){
		  
		  
		  BladePos1X = (int) Math.round(posX +bladeOffset);
		  BladePos1Z = (int) Math.round(posZ+bladeOffset);
		  BladePos2X = (int) Math.round(posX +bladeOffset)+1;
		  BladePos2Z = (int) Math.round(posZ+bladeOffset)+1;
		  BladePos3X = (int) Math.round(posX +bladeOffset-1);
		  BladePos3Z = (int) Math.round(posZ+bladeOffset)-1;
		  
	  }
  }
  
  public void digMethodB()
  {
	  
	  setBladePosFromYaw();
	  
		
		
		int x =BladePos1X;
		int y =(int) posY;
		int z= BladePos1Z;
		if (worldObj.getBlock(x,y,z).getMaterial() == Material.grass || worldObj.getBlock(x,y,z).getMaterial() == Material.ground || worldObj.getBlock(x,y,z).getMaterial() == Material.sand ){
			worldObj.getBlock(x,y,z).dropBlockAsItem(worldObj, x, y, z, worldObj.getBlockMetadata(x, y, z) , 0);
			worldObj.setBlockToAir(x,y,z);
		}
		
		x =BladePos2X;
		 y =(int) posY;
		 z= BladePos2Z;
		if (worldObj.getBlock(x,y,z).getMaterial() == Material.grass ||worldObj.getBlock(x,y,z).getMaterial() == Material.ground|| worldObj.getBlock(x,y,z).getMaterial() == Material.sand){
			worldObj.getBlock(x,y,z).dropBlockAsItem(worldObj, x, y, z, worldObj.getBlockMetadata(x, y, z) , 0);
			worldObj.setBlockToAir(x,y,z);
		}
		x =BladePos3X;
		 y =(int) posY;
		 z= BladePos3Z;
		if (worldObj.getBlock(x,y,z).getMaterial() == Material.grass|| worldObj.getBlock(x,y,z).getMaterial() == Material.ground|| worldObj.getBlock(x,y,z).getMaterial() == Material.sand){
			worldObj.getBlock(x,y,z).dropBlockAsItem(worldObj, x, y, z, worldObj.getBlockMetadata(x, y, z) , 0);

			worldObj.setBlockToAir(x,y,z);
		}
		
  }
	
//	  /**
//     * Sets the forward direction of the entity.
//     */
//    public void setForwardDirection(int value)
//    {
//        this.dataWatcher.updateObject(18, Integer.valueOf(value));
//    }
//
//    /**
//     * Gets the forward direction of the entity.
//     */
//    public int getForwardDirection()
//    {
//        return this.dataWatcher.getWatchableObjectInt(18);
//    }
}
