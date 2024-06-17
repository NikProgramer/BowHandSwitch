package net.nikhard.mainhandswitch;

import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.*;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Arm;
import org.lwjgl.glfw.GLFW;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MainhandSwitch implements ModInitializer {
	public static final KeyBinding BINDING = KeyBindingHelper.registerKeyBinding(
			new KeyBinding("Switch main hand", GLFW.GLFW_KEY_CAPS_LOCK, KeyBinding.INVENTORY_CATEGORY)
	);

	@Override
	public void onInitialize() {
		ClientTickEvents.END_CLIENT_TICK.register(client -> {
			if (MinecraftClient.getInstance().world != null){
				try {
					if (client.player.getInventory().getMainHandStack().getItem().asItem() == Items.BOW) {
						client.player.setMainArm(Arm.LEFT);
					}
					else {
						client.player.setMainArm(Arm.RIGHT);
					}
				}
				finally {

				}
			}
		});
	}
}
