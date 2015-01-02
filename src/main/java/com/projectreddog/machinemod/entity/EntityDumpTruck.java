
	
	package com.projectreddog.machinemod.entity;

	import com.projectreddog.machinemod.init.ModItems;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;

public class EntityDumpTruck extends EntityMachineModRideable implements IInventory {

		ItemStack items [] = new ItemStack[36];
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

	@Override
	public int getSizeInventory() {
		return 36;
	}

	@Override
	public ItemStack getStackInSlot(int index) {
		
		return items[index];
	}

	@Override
	public ItemStack decrStackSize(int index, int count) {
		// TODO Auto-generated method stub
		 if (items[index].stackSize > count){
			 items[index].stackSize -= count;
			 
			 return new ItemStack(items[index].getItem(), count);
		 }else if ( items[index].stackSize == count){
			 items[index] = null;
			 return items[index];
		 }else {
			 items[index] = null;
			 return items[index];
			 
		 }
		 
		return null;
	}

	@Override
	public ItemStack getStackInSlotOnClosing(int index) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setInventorySlotContents(int index, ItemStack stack) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int getInventoryStackLimit() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void markDirty() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean isUseableByPlayer(EntityPlayer playerIn) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void openInventory(EntityPlayer playerIn) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void closeInventory(EntityPlayer playerIn) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean isItemValidForSlot(int index, ItemStack stack) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int getField(int id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void setField(int id, int value) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int getFieldCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		
	}
	
}

