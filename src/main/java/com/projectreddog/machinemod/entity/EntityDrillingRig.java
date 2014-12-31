
	
	
	package com.projectreddog.machinemod.entity;

	import com.projectreddog.machinemod.init.ModBlocks;
import com.projectreddog.machinemod.utility.LogHelper;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;

public class EntityDrillingRig extends EntityMachineModRideable {

		
		public EntityDrillingRig(World world){
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


	   public void onUpdate(){
			  super.onUpdate();
			  if (!worldObj.isRemote){
				  digMethodA();
					
			  }
		  }
	   
	   public void digMethodA(){
		   if ( this.isPlayerPushingSprintButton ){
			   int i = 0;
			   while (i <posY || worldObj.getBlock((int) (this.posX +.5d),(int) (this.posY-i), (int)(this.posZ+.5d))== ModBlocks.machinedrilledstone ||
					   worldObj.isAirBlock((int) (this.posX +.5d),(int) (this.posY-i), (int)(this.posZ+.5d)) ||
					   worldObj.getBlock((int) (this.posX +.5d),(int) (this.posY-i), (int)(this.posZ+.5d))== Blocks.dirt)
			   {
				   LogHelper.info("Drilling rig checked Y of:" + (int) (posY-i));
				   ++i;
				   
			   }
			   
			   if (worldObj.getBlock((int) (this.posX +.5d),(int) (this.posY-i), (int)(this.posZ+.5d))== Blocks.stone){
				   worldObj.setBlock((int) (this.posX +.5d),(int) (this.posY-i), (int)(this.posZ+.5d),ModBlocks.machinedrilledstone);
			   }
		   }
	   }
	
}
