package ml.jozefpeeterslaan72wuustwezel.pepsimc.client.screen;

import java.util.ArrayList;
import java.util.Optional;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.systems.RenderSystem;

import ml.jozefpeeterslaan72wuustwezel.pepsimc.common.container.RecyclerContainer;
import ml.jozefpeeterslaan72wuustwezel.pepsimc.common.data.recipes.PepsiMcRecipeType;
import ml.jozefpeeterslaan72wuustwezel.pepsimc.common.data.recipes.RecyclerRecipe;
import ml.jozefpeeterslaan72wuustwezel.pepsimc.common.entity.blockentity.RecyclerEntity;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiComponent;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;


public class RecyclerScreen extends AbstractContainerScreen<RecyclerContainer>{

	public RecyclerScreen(RecyclerContainer BC, Inventory plrInv, Component Text) {
		super(BC, plrInv, Text);
	}

	private static final ResourceLocation GUI = new ResourceLocation("pepsimc","textures/gui/recycler_gui.png");

	public void containerTick() {
	      super.containerTick();
	      if (hasRecipe()) {
				this.addRenderableWidget(new ConfirmButton(this.getGuiLeft()+77,this.getGuiTop()+28,176,0,18,15,this.menu.TE.getBlockPos(),GUI));
	      } else {
	  		this.clearWidgets();
	      }
	   }
	
	@Override
	public void render(PoseStack stack, int mouseX, int mouseY, float Ptick) {
		this.renderBackground(stack);
		super.render(stack, mouseX, mouseY, Ptick);
		this.renderTooltip(stack, mouseX, mouseY);
		if (hasRecipe()) {
			if(this.isHovering(77,28, 18, 15, mouseX, mouseY)) {

				if(this.createTooltip()!=null) {

					this.renderTooltip(stack, this.createTooltip(), mouseX,mouseY);
				}
			}			
			if(!this.menu.slotHasItem(2))
			Minecraft.getInstance().getItemRenderer().renderAndDecorateFakeItem(RecipeResult(), this.getGuiLeft()+80, this.getGuiTop()+53);
			for (int i = 0; i < 3; i++) {
		        RenderSystem.depthFunc(516+i);
				if(!this.menu.slotHasItem(2))
					GuiComponent.fill(stack, this.getGuiLeft()+80, this.getGuiTop()+53, this.getGuiLeft()+96, this.getGuiTop()+69,822083583);
				
			}
	        RenderSystem.depthFunc(515);
		}
	}
	
	private Component createTooltip() {
        ArrayList<Component> text = new ArrayList<Component>();
        if(RecipeResult() != null) {
        	text.add(RecipeResult().getHoverName());
			return text.get(0);
		}
		return null;
    }
	private boolean hasRecipe() {
		RecyclerEntity TE = (RecyclerEntity) RecyclerScreen.this.menu.TE;
        Level world = TE.getLevel();
        SimpleContainer inv = new SimpleContainer(TE.itemHandler.getSlots());
        
		for(int i=0;i<TE.itemHandler.getSlots();i++) {
			inv.setItem(i, TE.itemHandler.getStackInSlot(i));
		}
		
		Optional<RecyclerRecipe> recipe = world.getRecipeManager().getRecipeFor(PepsiMcRecipeType.RECYCLER_RECIPE, inv, world);

		return recipe.isPresent();
		
	}
	private ItemStack RecipeResult() {
		RecyclerEntity TE = (RecyclerEntity) RecyclerScreen.this.menu.TE;
        Level world = TE.getLevel();
        SimpleContainer inv = new SimpleContainer(TE.itemHandler.getSlots());
        ArrayList<ItemStack> result = new ArrayList<ItemStack>();
		for(int i=0;i<TE.itemHandler.getSlots();i++) {
			inv.setItem(i, TE.itemHandler.getStackInSlot(i));
		}
		
		Optional<RecyclerRecipe> recipe = world.getRecipeManager().getRecipeFor(PepsiMcRecipeType.RECYCLER_RECIPE, inv, world);
		recipe.ifPresent(i->{
			result.add(i.getResultItem());
		});
		return result.get(0);
		
	}
	
	@Override
	protected void renderBg(PoseStack stack, float Ptick, int X, int Y) {
		RenderSystem.setShader(GameRenderer::getPositionTexShader);
		RenderSystem.setShaderColor(1f, 1f, 1f, 1f);
		RenderSystem.setShaderTexture(0, GUI);
        int x = this.getGuiLeft();
        int y = this.getGuiTop();
        this.blit(stack, x, y, 0, 0, 176, 167);
	}
	

}
	 
