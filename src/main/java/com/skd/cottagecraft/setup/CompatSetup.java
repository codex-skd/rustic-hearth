package com.skd.cottagecraft.setup;

import net.neoforged.bus.api.IEventBus;

/**
 * Optional mod integrations (JEI and Quark load through their own plugin discovery; any hook that
 * needs code on our side goes here). Guard every call with {@code ModList.get().isLoaded(...)}.
 */
public final class CompatSetup {
	private CompatSetup() {
	}

	public static void init(IEventBus modBus) {
	}

	public static void commonSetup() {
	}
}
