package com.skd.rustichearth.registry;

import com.skd.rustichearth.RusticHearth;
import com.skd.rustichearth.entity.ChairSeatEntity;
import com.skd.rustichearth.entity.TomatoEntity;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public final class ModEntities {
	public static final DeferredRegister<EntityType<?>> ENTITIES = DeferredRegister.create(Registries.ENTITY_TYPE, RusticHearth.NAMESPACE);

	public static final DeferredHolder<EntityType<?>, EntityType<TomatoEntity>> TOMATO = ENTITIES.register("tomato",
			() -> EntityType.Builder.<TomatoEntity>of(TomatoEntity::new, MobCategory.MISC).sized(0.25F, 0.25F)
					.clientTrackingRange(4).updateInterval(10).build(RusticHearth.NAMESPACE + ":tomato"));

	public static final DeferredHolder<EntityType<?>, EntityType<ChairSeatEntity>> CHAIR = ENTITIES.register("chair",
			() -> EntityType.Builder.<ChairSeatEntity>of(ChairSeatEntity::new, MobCategory.MISC).sized(0.0001F, 0.0001F)
					.noSummon().fireImmune().clientTrackingRange(8).updateInterval(Integer.MAX_VALUE).build(RusticHearth.NAMESPACE + ":chair"));

	private ModEntities() {
	}
}
