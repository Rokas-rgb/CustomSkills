package org.rokas.customSkills.Listeners;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.rokas.customSkills.Managers.SkillManager;
import org.rokas.customSkills.Models.PlayerData;

import java.util.UUID;

public class PlayerDataListener implements Listener {

    private final SkillManager skillManager;

    public PlayerDataListener(SkillManager skillManager) {
        this.skillManager = skillManager;
    }

    @EventHandler
    public void onJoin(PlayerJoinEvent e) {
        UUID uuid = e.getPlayer().getUniqueId();
        skillManager.getPlayerData(uuid);
        skillManager.savePlayerData(uuid);
    }

    @EventHandler
    public void onQuit(PlayerQuitEvent e) {
        UUID uuid = e.getPlayer().getUniqueId();
        PlayerData playerData = skillManager.getPlayerData(uuid);

        if (playerData.hasAnyProgress()) {
            skillManager.savePlayerData(uuid);
        }
    }

}
