package com.blackoutburst.workshop.core.events;

import com.blackoutburst.workshop.core.WSPlayer;
import org.bukkit.event.player.PlayerDropItemEvent;

public class ItemDrop {

    public static void execute(PlayerDropItemEvent event) {
        WSPlayer player = WSPlayer.getFromPlayer(event.getPlayer());
        if (player != null)
            event.setCancelled(player.isInGame());
    }
}
