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

			double bladeOffsetX =(bladeOffset * MathHelper.cos((float) ((yaw+90) * Math.PI / 180.0D)));
			double bladeOffsetZ= (bladeOffset * MathHelper.sin((float) ((yaw+90) * Math.PI / 180.0D))); 
		  
			
			
			int x =(int)(this.posX+bladeOffsetX-.5d);
			int y = (int)this.posY;
			int z= (int)(this.posZ+bladeOffsetZ+.5);
			if (worldObj.getBlock(x,y,z).getMaterial() == Material.grass || worldObj.getBlock(x,y,z).getMaterial() == Material.ground || worldObj.getBlock(x,y,z).getMaterial() == Material.sand ){
				worldObj.setBlockToAir(x,y,z);
			}
			

			double bladeOffsetX2 =(1 * MathHelper.cos((float) ((yaw+90+90) * Math.PI / 180.0D)));
			double bladeOffsetZ2= (1 * MathHelper.sin((float) ((yaw+90+90) * Math.PI / 180.0D))); 
		  
			x =(int)(this.posX+bladeOffsetX+bladeOffsetX2-.5d );
			y = (int)this.posY;
			z= (int)(this.posZ+bladeOffsetZ+bladeOffsetZ2+.5);
			if (worldObj.getBlock(x,y,z).getMaterial() == Material.grass ||worldObj.getBlock(x,y,z).getMaterial() == Material.ground|| worldObj.getBlock(x,y,z).getMaterial() == Material.sand){
				worldObj.setBlockToAir(x,y,z);
			}
			x =(int)(this.posX+bladeOffsetX-bladeOffsetX2-.5d);
			 y = (int)this.posY;
			 z= (int)(this.posZ+bladeOffsetZ-bladeOffsetZ2+.5);
			if (worldObj.getBlock(x,y,z).getMaterial() == Material.grass|| worldObj.getBlock(x,y,z).getMaterial() == Material.ground|| worldObj.getBlock(x,y,z).getMaterial() == Material.sand){
				worldObj.setBlockToAir(x,y,z);
			}
			
			
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
