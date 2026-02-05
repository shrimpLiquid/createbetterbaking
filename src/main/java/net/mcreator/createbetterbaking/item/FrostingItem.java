package net.mcreator.createbetterbaking.item;

import net.minecraft.world.item.Items;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.BucketItem;

import net.mcreator.createbetterbaking.init.CrbebaModFluids;

public class FrostingItem extends BucketItem {
	public FrostingItem() {
		super(CrbebaModFluids.FROSTING.get(), new Item.Properties().craftRemainder(Items.BUCKET).stacksTo(1)

		);
	}
}