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
	public boolean onItemUse(ItemStack stack, EntityPlayer player, World world, int x, int y, int z, int side, float xOff, float yOff, float zOff)
	{
		boolean result = false;
		
		if (!world.isRemote)/// only run on server
		{
		LogHelper.info("Item used on Bulldozer!");


		EntityBulldozer entityBulldozer = new EntityBulldozer(world);
		entityBulldozer.setPosition(x+.5d,y+1.0d,z+.5d);
		result = world.spawnEntityInWorld(entityBulldozer);
		LogHelper.info("Spawn entity resutl:" + result );
		}
		return result;
	}
}
