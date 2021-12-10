package ml.jozefpeeterslaan72wuustwezel.pepsimc.common.entity.blockentity;


import java.util.Optional;

import javax.annotation.Nonnull;

import ml.jozefpeeterslaan72wuustwezel.pepsimc.common.data.recipes.ExtractorRecipe;
import ml.jozefpeeterslaan72wuustwezel.pepsimc.common.data.recipes.PepsiMcRecipeType;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.item.ItemStack;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.items.ItemStackHandler;

public class ExtractorEntity extends ProcessingBlockEntity{
	
	public ExtractorEntity(BlockPos pos, BlockState state) {
		super(PepsiMcBlockEntity.EXTRACTOR_TILE.get(), pos, state);
	}

	@Override
	public void process(Level world) {
		Optional<ExtractorRecipe> recipe = world.getRecipeManager().getRecipeFor(PepsiMcRecipeType.EXTRACTOR_RECIPE, getSimpleInv(), world);

		recipe.ifPresent(iRecipe->{
			itemHandler.extractItem(0, 1, false);
			itemHandler.insertItem(1, iRecipe.getResultItem(), false);
			setChanged();
		});	

	}
	
	@Override
	public void processAll(Level world) {
		Optional<ExtractorRecipe> recipe = world.getRecipeManager().getRecipeFor(PepsiMcRecipeType.EXTRACTOR_RECIPE, getSimpleInv(), world);
		while (recipe.isPresent()) {
			recipe.ifPresent(iRecipe->{
				itemHandler.extractItem(0, 1, false);
				itemHandler.insertItem(1, iRecipe.getResultItem(), false);
				setChanged();
			});	
			recipe = world.getRecipeManager().getRecipeFor(PepsiMcRecipeType.EXTRACTOR_RECIPE, getSimpleInv(), world);
		}
		

	}
	
	@Override
	protected ItemStackHandler createHandler() {

		return new ItemStackHandler(2) {
			
			@Override
			protected void onContentsChanged(int slot) {
				setChanged();
			}

			@Override 
			public int getSlotLimit(int slot){
				return 64;	
			}
			

			@Override
			public boolean isItemValid(int slot, @Nonnull ItemStack stack) {
				switch (slot) {
					case 0: return true;
					case 1: return stack.getItem().getTags().contains(new ResourceLocation("pepsimc", "extracted"));
					default:
						return false;
				
				}
			}
			@Override
			@Nonnull
			public ItemStack insertItem(int slot, @Nonnull ItemStack stack, boolean simulate) {
				if(!isItemValid(slot, stack)) {
					return stack;
				}
				return super.insertItem(slot, stack, simulate);
			}
		};
	}
}