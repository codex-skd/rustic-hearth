package com.skd.cottagecraft.datagen.providers;

import java.util.concurrent.CompletableFuture;

import com.skd.cottagecraft.datagen.providers.parts.AlchemyData;
import com.skd.cottagecraft.datagen.providers.parts.DecorData;
import com.skd.cottagecraft.datagen.providers.parts.FarmData;
import com.skd.cottagecraft.datagen.providers.parts.MiscData;
import com.skd.cottagecraft.datagen.providers.parts.StorageData;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.DataMapProvider;
import net.neoforged.neoforge.registries.datamaps.DataMapType;

/**
 * Data maps: furnace fuels (legacy IFuelHandler), compostables, ...
 */
public class RusticDataMapProvider extends DataMapProvider {
	public RusticDataMapProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookup) {
		super(output, lookup);
	}

	@Override
	protected void gather(HolderLookup.Provider provider) {
		DecorData.dataMaps(this);
		FarmData.dataMaps(this);
		StorageData.dataMaps(this);
		AlchemyData.dataMaps(this);
		MiscData.dataMaps(this);
	}

	public <T, R> Builder<T, R> map(DataMapType<R, T> type) {
		return builder(type);
	}
}
