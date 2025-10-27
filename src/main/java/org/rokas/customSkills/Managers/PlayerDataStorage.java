package org.rokas.customSkills.Managers;

import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.rokas.customSkills.Models.PlayerData;
import org.rokas.customSkills.Models.SkillTypes;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

public class PlayerDataStorage {

    private final File dataFolder;

    public PlayerDataStorage(File pluginFolder) {
        this.dataFolder = new File(pluginFolder, "playerData");
        if(!dataFolder.exists()) {
            boolean created = dataFolder.mkdirs();
            if(!created) {
                System.out.println(ChatColor.RED + "Failed to create player data folder!");
            }
            else {
                System.out.println(ChatColor.GREEN + "Created player data folder!");
            }
        }
    }

    public void savePlayerData(PlayerData playerData) {
        File file = new File(dataFolder, playerData.getUUID() + ".yml");
        FileConfiguration config = new YamlConfiguration();

        for (SkillTypes skill : SkillTypes.values()) {
            config.set("xp. " + skill.name(), playerData.getXP(skill));
            config .set("level " + skill.name(), playerData.getLevel(skill));
        }

        try {
            config.save(file);
        } catch (IOException e) {
            System.out.println("Failed to save player data for " +  playerData.getUUID());
            e.printStackTrace();
        }
    }

    public PlayerData loadPlayerData(UUID uuid) {
        File file = new File(dataFolder, uuid + ".yml");
        PlayerData playerData = new PlayerData(uuid);

        if (!file.exists()) return playerData;

        FileConfiguration config = YamlConfiguration.loadConfiguration(file);

        for (SkillTypes skill : SkillTypes.values()) {
            double xp = config.getDouble("xp. " + skill.name(), 0.0);
            int level = config.getInt("level " + skill.name(), 1);
            playerData.addXP(skill, xp);

            for (int i = 1; i <= level; i++);
        }

        return playerData;
    }
}
