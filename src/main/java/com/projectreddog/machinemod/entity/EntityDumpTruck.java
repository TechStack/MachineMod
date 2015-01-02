
	
	package com.projectreddog.machinemod.entity;

	import com.projectreddog.machinemod.init.ModItems;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
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



	   @Override
	   public Item getItemToBeDropped()
	   {
		   return ModItems.dumptruck;
	   }
	
}

