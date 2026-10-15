package com.skd.rustichearth.network;

import com.skd.rustichearth.RusticHearth;
import com.skd.rustichearth.effect.EffectEvents;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.neoforged.neoforge.network.handling.IPayloadContext;

/**
 * Client to server: the player left clicked while under Fire Power.
 */
public record FirePowerAttackPayload() implements CustomPacketPayload {
	public static final Type<FirePowerAttackPayload> TYPE = new Type<>(RusticHearth.id("fire_power_attack"));
	public static final StreamCodec<RegistryFriendlyByteBuf, FirePowerAttackPayload> STREAM_CODEC = StreamCodec.unit(new FirePowerAttackPayload());

	@Override
	public Type<? extends CustomPacketPayload> type() {
		return TYPE;
	}

	public static void handle(FirePowerAttackPayload payload, IPayloadContext context) {
		EffectEvents.doFirePowerAttack(context.player());
	}
}
