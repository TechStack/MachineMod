package com.projectreddog.machinemod.block;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.world.Explosion;
import net.minecraft.world.World;

import com.projectreddog.machinemod.creativetab.CreativeTabMachineMod;
import com.projectreddog.machinemod.reference.Reference;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockMachineMod  extends Block {

	protected BlockMachineMod(Material material) {
		super(material);

		//can override later ;)
		this.setCreativeTab(CreativeTabMachineMod.MACHINEMOD_TAB);


	}
	public BlockMachineMod() {
		//Generic constructor (set to rock by default)
		this(Material.rock);
	}
	
	@Override
	public String getUnlocalizedName()
	{
		return String.format("tile.%s%s", Reference.MOD_ID.toLowerCase() +":", getUnwrappedUnlocalizedName(super.getUnlocalizedName()) );
	}

	
	@Override
	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister iconRegister)
	{
		blockIcon = iconRegister.registerIcon(this.getUnlocalizedName().substring(this.getUnlocalizedName().indexOf(".")+1));
	}
	
	protected String getUnwrappedUnlocalizedName(String unlocalizedName)
	{
		return unlocalizedName.substring(unlocalizedName.indexOf(".")+1);
	}
	
	@Override 
	public void onNeighborBlockChange(World world, int x, int y, int z, Block block)
	{
		
	}
	
	@Override
	public void onBlockDestroyedByExplosion(World world, int x, int y, int z, Explosion explosion){
	}

}
