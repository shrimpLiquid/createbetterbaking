/*
 * MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.createbetterbaking.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.api.distmarker.Dist;

import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.material.FlowingFluid;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.ItemBlockRenderTypes;

import net.mcreator.createbetterbaking.fluid.FrostingFluid;
import net.mcreator.createbetterbaking.fluid.BatterFluid;
import net.mcreator.createbetterbaking.CrbebaMod;

public class CrbebaModFluids {
	public static final DeferredRegister<Fluid> REGISTRY = DeferredRegister.create(BuiltInRegistries.FLUID, CrbebaMod.MODID);
	public static final DeferredHolder<Fluid, FlowingFluid> FROSTING = REGISTRY.register("frosting", () -> new FrostingFluid.Source());
	public static final DeferredHolder<Fluid, FlowingFluid> FLOWING_FROSTING = REGISTRY.register("flowing_frosting", () -> new FrostingFluid.Flowing());
	public static final DeferredHolder<Fluid, FlowingFluid> BATTER = REGISTRY.register("batter", () -> new BatterFluid.Source());
	public static final DeferredHolder<Fluid, FlowingFluid> FLOWING_BATTER = REGISTRY.register("flowing_batter", () -> new BatterFluid.Flowing());

	@EventBusSubscriber(Dist.CLIENT)
	public static class FluidsClientSideHandler {
		@SubscribeEvent
		public static void clientSetup(FMLClientSetupEvent event) {
			ItemBlockRenderTypes.setRenderLayer(FROSTING.get(), RenderType.translucent());
			ItemBlockRenderTypes.setRenderLayer(FLOWING_FROSTING.get(), RenderType.translucent());
			ItemBlockRenderTypes.setRenderLayer(BATTER.get(), RenderType.translucent());
			ItemBlockRenderTypes.setRenderLayer(FLOWING_BATTER.get(), RenderType.translucent());
		}
	}
}