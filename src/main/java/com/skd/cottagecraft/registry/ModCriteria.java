package com.skd.cottagecraft.registry;

import com.skd.cottagecraft.Cottagecraft;
import com.skd.cottagecraft.advancement.BoozeItemPredicate;
import net.minecraft.advancements.CriterionTrigger;
import net.minecraft.advancements.critereon.ItemSubPredicate;
import net.minecraft.core.registries.Registries;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.RegisterEvent;

/**
 * Advancement criteria triggers and item sub predicates (legacy AlcoholItemPredicate).
 */
@EventBusSubscriber(modid = Cottagecraft.MODID, bus = EventBusSubscriber.Bus.MOD)
public final class ModCriteria {
	public static final DeferredRegister<CriterionTrigger<?>> TRIGGERS = DeferredRegister.create(Registries.TRIGGER_TYPE, Cottagecraft.NAMESPACE);

	/** {@code cottagecraft:booze}: booze containers by fluid and quality (used with inventory_changed). */
	public static final ItemSubPredicate.Type<BoozeItemPredicate> BOOZE = new ItemSubPredicate.Type<>(BoozeItemPredicate.CODEC);

	private ModCriteria() {
	}

	@SubscribeEvent
	public static void registerItemSubPredicates(RegisterEvent event) {
		event.register(Registries.ITEM_SUB_PREDICATE_TYPE, helper -> helper.register(Cottagecraft.id("booze"), BOOZE));
	}
}
