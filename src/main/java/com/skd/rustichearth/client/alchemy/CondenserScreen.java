package com.skd.rustichearth.client.alchemy;

import com.skd.rustichearth.RusticHearth;
import com.skd.rustichearth.menu.alchemy.CondenserMenu;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;

/**
 * Basic condenser GUI (legacy GuiCondenser).
 */
public class CondenserScreen extends AbstractCondenserScreen<CondenserMenu> {
	private static final ResourceLocation TEXTURE = RusticHearth.id("textures/gui/condenser.png");
	public static final int PROGRESS_Y = 29;
	public static final int PROGRESS_HEIGHT = 28;

	public CondenserScreen(CondenserMenu menu, Inventory playerInventory, Component title) {
		super(menu, playerInventory, title, TEXTURE, PROGRESS_Y, PROGRESS_HEIGHT);
	}
}
