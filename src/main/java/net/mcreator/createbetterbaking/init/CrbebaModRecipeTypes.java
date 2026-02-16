package net.mcreator.createbetterbaking.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.fml.event.lifecycle.FMLConstructModEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.ModList;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.IEventBus;

import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.core.registries.BuiltInRegistries;

import net.mcreator.createbetterbaking.recipe.BigBakingRecipe;
import net.mcreator.createbetterbaking.CrbebaMod;

@EventBusSubscriber(modid = CrbebaMod.MODID)
public class CrbebaModRecipeTypes {
	public static final DeferredRegister<RecipeType<?>> RECIPE_TYPES = DeferredRegister.create(BuiltInRegistries.RECIPE_TYPE, "crbeba");
	public static final DeferredRegister<RecipeSerializer<?>> SERIALIZERS = DeferredRegister.create(BuiltInRegistries.RECIPE_SERIALIZER, "crbeba");

	@SubscribeEvent
	public static void register(FMLConstructModEvent event) {
		IEventBus bus = ModList.get().getModContainerById("crbeba").get().getEventBus();
		event.enqueueWork(() -> {
			RECIPE_TYPES.register(bus);
			SERIALIZERS.register(bus);
			// Recipe Types
			RECIPE_TYPES.register("big_baking", () -> BigBakingRecipe.Type.INSTANCE);
			// Recipe Serializer
			SERIALIZERS.register("big_baking", () -> BigBakingRecipe.Serializer.INSTANCE);
		});
	}
}