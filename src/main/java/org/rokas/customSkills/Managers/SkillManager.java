package org.rokas.customSkills.Managers;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.rokas.customSkills.CustomSkills;
import org.rokas.customSkills.Events.SkillLevelUpEvent;
import org.rokas.customSkills.GUI.SkillsGUI;
import org.rokas.customSkills.Models.PlayerData;
import org.rokas.customSkills.Models.SkillTypes;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class SkillManager {

    private final Map<UUID, PlayerData> playerDataMap = new HashMap<>();
    private final PlayerDataStorage storage;

    public SkillManager(File pluginFolder) {
        this.storage = new PlayerDataStorage(pluginFolder);
    }

    public PlayerData getPlayerData(UUID uuid) {
        return playerDataMap.computeIfAbsent(uuid, id -> storage.loadPlayerData(id));
    }

    public void savePlayerData(UUID uuid) {
        PlayerData playerData = playerDataMap.get(uuid);
        if (playerData != null) {
            storage.savePlayerData(playerData);
        }
    }

    public void addXp(UUID uuid, SkillTypes skill, double amount) {
        PlayerData playerData = getPlayerData(uuid);

        int oldLevel = playerData.getLevel(skill);
        playerData.addXP(skill, amount);

        double currentXp = playerData.getXP(skill);
        int currentLevel = playerData.getLevel(skill);
        double requiredXp = getRequiredXp(currentLevel);

        if (currentXp >= requiredXp) {
            playerData.levelUp(skill);
        }
        savePlayerData(uuid);

        int newLevel = playerData.getLevel(skill);
        boolean leveledUp = newLevel > oldLevel;

        savePlayerData(uuid);

        Player player = Bukkit.getPlayer(uuid);

        if (player != null && player.isOnline()) {
            CustomSkills plugin = CustomSkills.getInstance();
            plugin.getGuiManager().refreshIfOpen(player);

            if (leveledUp) {
                Bukkit.getPluginManager().callEvent(new SkillLevelUpEvent(player, skill, newLevel));
            }
        }

        Player player = Bukkit.getPlayer(uuid);
        if (player != null && player.isOnline() && player.getOpenInventory().getTopInventory().getHolder() instanceof SkillsGUI)
        {
            CustomSkills plugin = CustomSkills.getInstance();
            plugin.getGuiManager().refreshIfOpen(player);
        }
    }

    public double getRequiredXp(int level) {
        return 100*level;
    }
}
