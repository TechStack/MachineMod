
	
	
	package com.projectreddog.machinemod.entity;

	import net.minecraft.init.Blocks;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;

import com.projectreddog.machinemod.init.ModBlocks;
import com.projectreddog.machinemod.utility.LogHelper;

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
			   while (i <posY || worldObj.getBlockState(new BlockPos( (int) (this.posX +.5d),(int) (this.posY-i), (int)(this.posZ+.5d)))== ModBlocks.machinedrilledstone ||
					   worldObj.isAirBlock(new BlockPos( (int) (this.posX +.5d),(int) (this.posY-i), (int)(this.posZ+.5d))) ||
					   worldObj.getBlockState(new BlockPos( (int) (this.posX +.5d),(int) (this.posY-i), (int)(this.posZ+.5d))).getBlock()== Blocks.dirt)
			   {
				   LogHelper.info("Drilling rig checked Y of:" + (int) (posY-i));
				   ++i;
				   
			   }
			   
			   if (worldObj.getBlockState(new BlockPos((int) (this.posX +.5d),(int) (this.posY-i), (int)(this.posZ+.5d))) == Blocks.stone){
				   worldObj.setBlockState(new BlockPos((int) (this.posX +.5d),(int) (this.posY-i), (int)(this.posZ+.5d)),   ModBlocks.machinedrilledstone.getDefaultState());
			   }
		   }
	   }
	
}
