package com.projectreddog.machinemod.item;

import com.projectreddog.machinemod.creativetab.CreativeTabMachineMod;
import com.projectreddog.machinemod.entity.EntityBulldozer;
import com.projectreddog.machinemod.init.ModEntities;
import com.projectreddog.machinemod.utility.LogHelper;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.item.EntityBoat;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemBulldozer extends ItemMachineMod {

	 public ItemBulldozer(){
		 super();
		 this.setUnlocalizedName("bulldozer");
		 this.maxStackSize =1;
		 
	 }
	 
	 @Override
	    public ItemStack onItemRightClick(ItemStack itemStack, World world, EntityPlayer player){
		 
		 
		 LogHelper.info("Right Click on Bulldozer!");
		 EntityBulldozer entityBulldozer = new EntityBulldozer(world);
		 boolean result = world.spawnEntityInWorld(entityBulldozer);
		 LogHelper.info("Spawn entity resutl:" + result );


         return itemStack;

	 }
}
