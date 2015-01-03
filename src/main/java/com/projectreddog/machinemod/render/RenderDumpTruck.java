package com.projectreddog.machinemod.render;

import net.minecraft.client.Minecraft;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderItem;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

import com.projectreddog.machinemod.entity.EntityDumpTruck;
import com.projectreddog.machinemod.model.ModelDumpTruck;
import com.projectreddog.machinemod.reference.Reference;
import com.projectreddog.machinemod.utility.LogHelper;

public class RenderDumpTruck extends Render {


	protected ModelBase  modelDumpTruck ;

private RenderItem itemRenderer;

	public RenderDumpTruck(RenderManager renderManager)
	{

		super(renderManager);

		LogHelper.info("in RenderDumpTruck constructor");
		shadowSize = 1F;
		this.modelDumpTruck = new ModelDumpTruck();
		 itemRenderer = Minecraft.getMinecraft().getRenderItem();
		 
	}



	@Override
	public void doRender(Entity entity, double x, double y, double z, float yaw, float pitch)
	{


		GL11.glPushMatrix();
		GL11.glTranslatef((float)x, (float)y, (float)z);
		GL11.glRotatef(180.0F - yaw, 0.0F, 1.0F, 0.0F);
		float f2 =  pitch;
		float f3 = pitch;

		if (f3 < 0.0F)
		{
			f3 = 0.0F;
		}

		if (f2 > 0.0F)
		{
			//			GL11.glRotatef(MathHelper.sin(f2) * f2 * f3 / 10.0F * (float)((EntityBulldozer) entity).getForwardDirection(), 1.0F, 0.0F, 0.0F);
		}

		float f4 = 0.75F;
		GL11.glScalef(f4, f4, f4);
		GL11.glScalef(1.0F / f4, 1.0F / f4, 1.0F / f4);
		this.bindEntityTexture(entity);
		GL11.glScalef(-1.0F, -1.0F, 1.0F);
		this.modelDumpTruck.render(entity, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, 0.0625F);
		EntityDumpTruck edt =((EntityDumpTruck) entity);
		Item item;
		Minecraft minecraft = Minecraft.getMinecraft();
		for (int i =0; i< edt.getSizeInventory() ; i++){
			if (edt.getStackInSlot(i)!= null  ){
				//TODO TS- ADD RENDERING Of items in dumptruck
				

			}
		}
		GL11.glPopMatrix();
	}

	@Override
	protected ResourceLocation getEntityTexture(Entity entity)
	{
		return   new ResourceLocation(   "machinemod",Reference.MODEL_DUMPTRUCK_TEXTURE_LOCATION); 
	}

}
