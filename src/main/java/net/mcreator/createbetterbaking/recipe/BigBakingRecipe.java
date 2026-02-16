package net.mcreator.createbetterbaking.recipe;

import org.jetbrains.annotations.NotNull;

import net.neoforged.neoforge.fluids.FluidStack;

import net.minecraft.world.level.Level;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.RecipeInput;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.ItemStack;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.core.NonNullList;
import net.minecraft.core.HolderLookup;

import javax.annotation.Nonnull;

import com.mojang.serialization.codecs.RecordCodecBuilder;
import com.mojang.serialization.MapCodec;

public record BigBakingRecipe(Ingredient blockItemInput, ItemStack newItemOutput) implements Recipe<RecipeInput> {
	public @NotNull ItemStack getItemStackResult(String output) {
		if (output.equals("new")) {
			return newItemOutput;
		}
		return ItemStack.EMPTY;
	}

	public @NotNull FluidStack getFluidStackResult(String output) {
		return FluidStack.EMPTY;
	}

	public @NotNull boolean getBooleanResult(String output) {
		return false;
	}

	public @NotNull double getDoubleResult(String output) {
		return 0.0d;
	}

	public @NotNull String getStringResult(String output) {
		return "";
	}

	public static class Type implements RecipeType<BigBakingRecipe> {
		private Type() {
		}

		public static final RecipeType<BigBakingRecipe> INSTANCE = new Type();
	}

	public static class Serializer implements RecipeSerializer<BigBakingRecipe> {
		public static final Serializer INSTANCE = new Serializer();
		public final MapCodec<BigBakingRecipe> CODEC = RecordCodecBuilder.mapCodec(
				instance -> instance.group(Ingredient.CODEC.fieldOf("block").forGetter(BigBakingRecipe::blockItemInput), ItemStack.CODEC.fieldOf("new").forGetter(BigBakingRecipe::newItemOutput)).apply(instance, Serializer::createBigBakingRecipe));
		private static final StreamCodec<RegistryFriendlyByteBuf, BigBakingRecipe> STREAM_CODEC = StreamCodec.of(Serializer::write, Serializer::read);

		@Override
		public @NotNull MapCodec<BigBakingRecipe> codec() {
			return CODEC;
		}

		@Override
		public @NotNull StreamCodec<RegistryFriendlyByteBuf, BigBakingRecipe> streamCodec() {
			return STREAM_CODEC;
		}

		private static BigBakingRecipe read(RegistryFriendlyByteBuf buffer) {
			Ingredient blockItemInput = Ingredient.CONTENTS_STREAM_CODEC.decode(buffer);
			ItemStack newItemOutput = ItemStack.STREAM_CODEC.decode(buffer);
			return new BigBakingRecipe(blockItemInput, newItemOutput);
		}

		private static void write(RegistryFriendlyByteBuf buffer, BigBakingRecipe recipe) {
			Ingredient.CONTENTS_STREAM_CODEC.encode(buffer, recipe.blockItemInput());
			ItemStack.STREAM_CODEC.encode(buffer, recipe.newItemOutput());
		}

		static BigBakingRecipe createBigBakingRecipe(Ingredient blockItemInput, ItemStack newItemOutput) {
			return new BigBakingRecipe(blockItemInput, newItemOutput);
		}
	}

	// Unused
	@Override
	public @NotNull RecipeSerializer<?> getSerializer() {
		return Serializer.INSTANCE;
	}

	// Unused
	@Override
	public @NotNull RecipeType<?> getType() {
		return Type.INSTANCE;
	}

	// Unused
	@Override
	public @Nonnull NonNullList<Ingredient> getIngredients() {
		return NonNullList.withSize(1, Ingredient.EMPTY);
	}

	// Unused
	@Override
	public boolean matches(@NotNull RecipeInput pContainer, @NotNull Level Level) {
		return false;
	}

	// Unused
	@Override
	public boolean canCraftInDimensions(int pWidth, int pHeight) {
		return true;
	}

	// Unused
	@Override
	public @NotNull ItemStack getResultItem(HolderLookup.Provider provider) {
		return ItemStack.EMPTY;
	}

	// Unused
	@Override
	public ItemStack assemble(@NotNull RecipeInput input, @NotNull HolderLookup.Provider holder) {
		return ItemStack.EMPTY;
	}
}