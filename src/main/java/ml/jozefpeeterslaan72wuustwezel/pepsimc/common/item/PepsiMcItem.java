package ml.jozefpeeterslaan72wuustwezel.pepsimc.common.item;

import ml.jozefpeeterslaan72wuustwezel.pepsimc.common.block.PepsiMcBlock;
import ml.jozefpeeterslaan72wuustwezel.pepsimc.common.block.fluid.PepsiMcFluid;
import ml.jozefpeeterslaan72wuustwezel.pepsimc.common.effect.PepsiMcEffect;
import ml.jozefpeeterslaan72wuustwezel.pepsimc.core.util.soundevent.PepsiMcSoundEvent;
import net.minecraft.item.BlockItem;
import net.minecraft.item.BucketItem;
import net.minecraft.item.Food;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.MusicDiscItem;
import net.minecraft.item.Rarity;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class PepsiMcItem {
	public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, "pepsimc");
	
	public static final RegistryObject<BeverageItem> PEPSI_CAN = ITEMS.register("pepsi_can", ()-> new BeverageItem(new Item.Properties()
			.tab(ItemGroup.TAB_FOOD)
			.craftRemainder(net.minecraft.item.Items.BUCKET)
			.food(new Food.Builder()
					.nutrition(2)
					.saturationMod(.2f)
					.effect(()->new EffectInstance(Effects.DAMAGE_BOOST, 1600, 2),1)
					.effect(()->new EffectInstance(Effects.HEALTH_BOOST, 1600, 2),1)
					.effect(()->new EffectInstance(Effects.LUCK, 1600, 2),1)
					.effect(()->new EffectInstance(Effects.DIG_SPEED, 1600, 2),1)
					.effect(()->new EffectInstance(Effects.REGENERATION, 1600, 2),1)
					.effect(()->new EffectInstance(Effects.ABSORPTION, 1600, 2),1)
					.effect(()->new EffectInstance(Effects.DAMAGE_RESISTANCE, 1600, 2),1)
					.effect(()->new EffectInstance(Effects.MOVEMENT_SPEED, 1600, 2),1)
					.effect(()->new EffectInstance(PepsiMcEffect.INSOMNIA.get(), 1600), .3f)
					.build()
					).fireResistant()));
	
	public static final RegistryObject<BeverageItem> PEPSI_BOTTLE = ITEMS.register("pepsi_bottle", ()-> new BeverageItem(new Item.Properties()
			.tab(ItemGroup.TAB_FOOD)
			.craftRemainder(net.minecraft.item.Items.BUCKET)
			.food(new Food.Builder()
					.nutrition(2)
					.saturationMod(.2f)
					.effect(()->new EffectInstance(Effects.DAMAGE_BOOST, 1600, 2),1)
					.effect(()->new EffectInstance(Effects.HEALTH_BOOST, 1600, 2),1)
					.effect(()->new EffectInstance(Effects.LUCK, 1600, 2),1)
					.effect(()->new EffectInstance(Effects.DIG_SPEED, 1600, 2),1)
					.effect(()->new EffectInstance(Effects.REGENERATION, 1600, 2),1)
					.effect(()->new EffectInstance(Effects.ABSORPTION, 1600, 2),1)
					.effect(()->new EffectInstance(Effects.DAMAGE_RESISTANCE, 1600, 2),1)
					.effect(()->new EffectInstance(Effects.MOVEMENT_SPEED, 1600, 2),1)
					.effect(()->new EffectInstance(PepsiMcEffect.INSOMNIA.get(), 1600), .3f)
					.build()
					).fireResistant()));
	
	public static final RegistryObject<Item> CARAMEL = ITEMS.register("caramel", ()-> new Item(new Item.Properties()
			.tab(ItemGroup.TAB_FOOD)
			.food(new Food.Builder()
					.effect(()->new EffectInstance(Effects.MOVEMENT_SPEED, 200, 1),1)
					.nutrition(2)
					.saturationMod(.2f)
					.build()
			).fireResistant()));
	
	public static final RegistryObject<Item> PHOSPHORIC_ACID = ITEMS.register("phosphoric_acid", ()-> new Item(new Item.Properties()
			.tab(ItemGroup.TAB_MISC)));
	
	public static final RegistryObject<Item> CAFFEINE = ITEMS.register("caffeine", ()-> new Item(new Item.Properties()
			.tab(ItemGroup.TAB_MISC).food(new Food.Builder()
					.nutrition(0)
					.saturationMod(0)
					.effect(()->new EffectInstance(PepsiMcEffect.INSOMNIA.get(), 3200), 1)
					.build()
					)));
	
	public static final RegistryObject<Item> STEVIA = ITEMS.register("stevia", ()-> new Item(new Item.Properties()
			.tab(ItemGroup.TAB_MISC)));
	
	public static final RegistryObject<Item> PEPSI_MAN_TUNE_DISC = ITEMS.register("pepsi_man_tune_disc", ()-> new MusicDiscItem(1,()->PepsiMcSoundEvent.PEPSI_MAN_TUNE.get(),new Item.Properties()
			.tab(ItemGroup.TAB_MISC).rarity(Rarity.RARE).stacksTo(1)));
	
	public static final RegistryObject<BeverageItem> PEPSI_MAX_BOTTLE = ITEMS.register("pepsi_max_bottle", ()-> new BeverageItem(new Item.Properties()
			.tab(ItemGroup.TAB_FOOD)
			.craftRemainder(net.minecraft.item.Items.BUCKET)
			.food(new Food.Builder()
					.nutrition(2)
					.saturationMod(.2f)
					.effect(()->new EffectInstance(Effects.DAMAGE_BOOST, 800, 2),1)
					.effect(()->new EffectInstance(Effects.HEALTH_BOOST, 800, 2),1)
					.effect(()->new EffectInstance(Effects.LUCK, 800, 2),1)
					.effect(()->new EffectInstance(Effects.DIG_SPEED, 800, 2),1)
					.effect(()->new EffectInstance(Effects.REGENERATION, 800, 2),1)
					.effect(()->new EffectInstance(Effects.ABSORPTION, 800, 2),1)
					.effect(()->new EffectInstance(Effects.DAMAGE_RESISTANCE, 800, 2),1)
					.effect(()->new EffectInstance(Effects.MOVEMENT_SPEED, 800, 2),1)
					.effect(()->new EffectInstance(PepsiMcEffect.INSOMNIA.get(), 1600), .3f)
					.build()
			).fireResistant()));
	
	public static final RegistryObject<BeverageItem> PEPSI_MAX_CAN = ITEMS.register("pepsi_max_can", ()-> new BeverageItem(new Item.Properties()
			.tab(ItemGroup.TAB_FOOD)
			.craftRemainder(net.minecraft.item.Items.BUCKET)
			.food(new Food.Builder()
					.nutrition(2)
					.saturationMod(.2f)
					.effect(()->new EffectInstance(Effects.DAMAGE_BOOST, 800, 2),1)
					.effect(()->new EffectInstance(Effects.HEALTH_BOOST, 800, 2),1)
					.effect(()->new EffectInstance(Effects.LUCK, 800, 2),1)
					.effect(()->new EffectInstance(Effects.DIG_SPEED, 800, 2),1)
					.effect(()->new EffectInstance(Effects.REGENERATION, 800, 2),1)
					.effect(()->new EffectInstance(Effects.ABSORPTION, 800, 2),1)
					.effect(()->new EffectInstance(Effects.DAMAGE_RESISTANCE, 800, 2),1)
					.effect(()->new EffectInstance(Effects.MOVEMENT_SPEED, 800, 2),1)
					.effect(()->new EffectInstance(PepsiMcEffect.INSOMNIA.get(), 1600), .3f)
					.build())));

	

	public static final RegistryObject<Item> PEPSITE_INGOT = ITEMS.register("pepsite_ingot", ()-> new Item(new Item.Properties()
			.tab(ItemGroup.TAB_MATERIALS)
			.fireResistant())); 
	
	public static final RegistryObject<Item> PEPSI_LABEL = ITEMS.register("pepsi_label", ()-> new Item(new Item.Properties()
			.tab(ItemGroup.TAB_MISC))); 
	
	public static final RegistryObject<Item> PEPSI_MAX_LABEL = ITEMS.register("pepsi_max_label", ()-> new Item(new Item.Properties()
			.tab(ItemGroup.TAB_MISC))); 
	
	public static final RegistryObject<Item> EMPTY_BOTTLE = ITEMS.register("empty_bottle", ()-> new Item(new Item.Properties()
			.tab(ItemGroup.TAB_MISC))); 
	
	public static final RegistryObject<Item> EMPTY_CAN = ITEMS.register("empty_can", ()-> new Item(new Item.Properties()
			.tab(ItemGroup.TAB_MISC))); 
	
	public static final RegistryObject<Item> PEPSI_FLUID_BUCKET = ITEMS.register("pepsi_bucket", ()-> new BucketItem(()->PepsiMcFluid.PEPSI_FLUID.get(),new Item.Properties()
			.tab(ItemGroup.TAB_MATERIALS)
			.stacksTo(16))); 
	public static final RegistryObject<Item> PEPSI_MAX_FLUID_BUCKET = ITEMS.register("pepsi_max_bucket", ()-> new BucketItem(()->PepsiMcFluid.PEPSI_MAX_FLUID.get(),new Item.Properties()
			.tab(ItemGroup.TAB_MATERIALS)
			.stacksTo(16))); 
	
	//blockItems
	
	public static final RegistryObject<Item> STEVIA_SEEDS = ITEMS.register("stevia_seeds", ()-> new BlockItem(PepsiMcBlock.STEVIA_CROP.get(),new Item.Properties()
			.tab(ItemGroup.TAB_MISC))); 
	
	public static final RegistryObject<BlockItem> PEPSITE_BLOCK = ITEMS.register("pepsite_block", ()-> new BlockItem(PepsiMcBlock.PEPSITEBLOCK.get(), new Item.Properties()
			.tab(ItemGroup.TAB_BUILDING_BLOCKS)
			.fireResistant()));
	
	public static final RegistryObject<BlockItem> STEVIA_PLANT = ITEMS.register("stevia_plant", ()-> new BlockItem(PepsiMcBlock.STEVIA_PLANT.get(), new Item.Properties()
			.tab(ItemGroup.TAB_DECORATIONS)));
	
	public static final RegistryObject<BlockItem> PEPSITE_ORE = ITEMS.register("pepsite_ore", ()-> new BlockItem(PepsiMcBlock.PEPSITEORE.get(), new Item.Properties()
			.tab(ItemGroup.TAB_BUILDING_BLOCKS)
			.fireResistant()));
	
	public static final RegistryObject<BlockItem> BOTTLER = ITEMS.register("bottler", ()-> new BlockItem(PepsiMcBlock.BOTTLER.get(), new Item.Properties()
			.tab(ItemGroup.TAB_DECORATIONS)));
	
	
	public static void register(IEventBus bus) {
		ITEMS.register(bus);
	
	}

	
}