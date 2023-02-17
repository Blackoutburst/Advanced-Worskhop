package com.blackoutburst.workshop.core;

import com.blackoutburst.workshop.utils.DBUtils;
import com.blackoutburst.workshop.utils.GameUtils;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import java.time.Instant;

public class GameStarter extends BukkitRunnable {
    private PlayArea area;
    private final WSPlayer wsplayer;

    Integer gameCount;

    Integer mapGameCount;

    public GameStarter(WSPlayer wsplayer, PlayArea area, Integer gameCount, Integer mapGameCount) {
        this.area = area;
        this.wsplayer = wsplayer;
        this.gameCount = gameCount;
        this.mapGameCount = mapGameCount;
    }

    @Override
    public void run() {
        if (!wsplayer.isInGame()) return;
        GameUtils.startRound(wsplayer);

        wsplayer.getTimers().setMapBegin(Instant.now());
        DBUtils.saveData(wsplayer.getPlayer(), "gameCount", gameCount != null ? gameCount + 1 : 1, Integer.class);
        DBUtils.saveData(wsplayer.getPlayer(), area.getType() + ".gameCount", mapGameCount != null ? mapGameCount + 1 : 1, Integer.class);
    }
}