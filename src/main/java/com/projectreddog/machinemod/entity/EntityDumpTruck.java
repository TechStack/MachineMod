
	
	package com.projectreddog.machinemod.entity;

	import net.minecraft.entity.player.EntityPlayer;
	import net.minecraft.util.DamageSource;
	import net.minecraft.world.World;

public class EntityDumpTruck extends EntityMachineModRideable {

		
		public EntityDumpTruck(World world){
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


	
	
}
