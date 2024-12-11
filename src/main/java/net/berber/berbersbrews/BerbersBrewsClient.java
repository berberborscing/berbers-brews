package net.berber.berbersbrews;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;

public class BerbersBrewsClient implements ClientModInitializer {
    public static boolean isJumping = false;
    @Override
    public void onInitializeClient() {
        ClientTickEvents.END_CLIENT_TICK.register(client -> {
            if (client.player != null) {
                isJumping = client.options.jumpKey.isPressed();
            }
        });
    }
}
