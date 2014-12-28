package com.projectreddog.machinemod.entity;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;

public class EntityBulldozer extends EntityMachineModRideable {

	
	
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
