package com.skd.cottagecraft.client.alchemy;

import com.skd.cottagecraft.Cottagecraft;
import com.skd.cottagecraft.menu.alchemy.AdvancedCondenserMenu;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;

/**
 * Advanced condenser GUI (legacy GuiCondenserAdvanced): taller progress arrow, no labels.
 */
public class AdvancedCondenserScreen extends AbstractCondenserScreen<AdvancedCondenserMenu> {
	private static final ResourceLocation TEXTURE = Cottagecraft.id("textures/gui/condenser_advanced.png");
	public static final int PROGRESS_Y = 17;
	public static final int PROGRESS_HEIGHT = 53;

	public AdvancedCondenserScreen(AdvancedCondenserMenu menu, Inventory playerInventory, Component title) {
		super(menu, playerInventory, title, TEXTURE, PROGRESS_Y, PROGRESS_HEIGHT);
	}

	@Override
	protected void renderLabels(GuiGraphics graphics, int mouseX, int mouseY) {
		// the advanced GUI texture has no room for labels
	}
}
