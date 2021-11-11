package ml.jozefpeeterslaan72wuustwezel.pepsimc.block;

import net.minecraft.block.Block;
//import net.minecraft.block.FlowingFluidBlock;
//import ml.jozefpeeterslaan72wuustwezel.pepsimc.block.fluid.PepsiMcFluid;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class PepsiMcBlock {
	
	public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, "pepsimc");

	
			// regular blocks
	public static final RegistryObject<Block> PEPSITEBLOCK = BLOCKS.register("pepsite_block",PepsiteBlock::new);
	
	public static final RegistryObject<Block> PEPSITEORE = BLOCKS.register("pepsite_ore", 
			()-> new Block(AbstractBlock.Properties.of(Material.STONE).harvestLevel(2).strength(4.5f, 15).sound(SoundType.STONE).requiresCorrectToolForDrops().harvestTool(ToolType.PICKAXE)));

	
			// special blocks

	/*public static final RegistryObject<FlowingFluidBlock> PEPSI_FLUID_BLOCK = BLOCKS.register("pepsi", 
			()-> new FlowingFluidBlock(()->PepsiMcFluid.PEPSI_FLUID.get(), AbstractBlock.Properties.of(Material.WATER).strength(100f).noDrops()));
	
	public static final RegistryObject<FlowingFluidBlock> PEPSI_MAX_FLUID_BLOCK = BLOCKS.register("pepsi_max", 
			()-> new FlowingFluidBlock(()->PepsiMcFluid.PEPSI_MAX_FLUID.get(), AbstractBlock.Properties.of(Material.WATER).strength(100f).noDrops()));
	*/
	public static final RegistryObject<Block> BOTTLER = BLOCKS.register("bottler",BottlerBlock::new);

	public static void register(IEventBus bus) {
		BLOCKS.register(bus);
	}
}
