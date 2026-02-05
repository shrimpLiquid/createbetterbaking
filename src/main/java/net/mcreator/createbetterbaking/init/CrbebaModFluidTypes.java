/*
 * MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.createbetterbaking.init;

import net.neoforged.neoforge.registries.NeoForgeRegistries;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.fluids.FluidType;

import net.mcreator.createbetterbaking.fluid.types.FrostingFluidType;
import net.mcreator.createbetterbaking.fluid.types.BatterFluidType;
import net.mcreator.createbetterbaking.CrbebaMod;

public class CrbebaModFluidTypes {
	public static final DeferredRegister<FluidType> REGISTRY = DeferredRegister.create(NeoForgeRegistries.FLUID_TYPES, CrbebaMod.MODID);
	public static final DeferredHolder<FluidType, FluidType> FROSTING_TYPE = REGISTRY.register("frosting", () -> new FrostingFluidType());
	public static final DeferredHolder<FluidType, FluidType> BATTER_TYPE = REGISTRY.register("batter", () -> new BatterFluidType());
}