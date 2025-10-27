package org.rokas.customSkills;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;
import org.rokas.customSkills.Commands.GUICommand;
import org.rokas.customSkills.GUI.SkillsGUI;
import org.rokas.customSkills.Listeners.*;
import org.rokas.customSkills.Managers.GUIManager;
import org.rokas.customSkills.Managers.SkillManager;

public final class CustomSkills extends JavaPlugin implements Listener {

    private SkillsGUI skillsGUI;
    private SkillManager skillManager;
    private GUIManager guiManager;
    private MiningListener miningListener;

    private static CustomSkills instance;


    @Override
    public void onEnable() {
        instance = this;
        skillManager = new SkillManager(getDataFolder());
        guiManager = new GUIManager(skillManager);

        //Listeners
        getServer().getPluginManager().registerEvents(this, this);
        getServer().getPluginManager().registerEvents(new GUIListener(), this);
        getServer().getPluginManager().registerEvents(new MiningListener(skillManager), this);
        getServer().getPluginManager().registerEvents(new FightingListener(), this);
        getServer().getPluginManager().registerEvents(new FishingListener(), this);
        getServer().getPluginManager().registerEvents(new PlayerDataListener(skillManager), this);

        //Commands
        getCommand("skills").setExecutor(new GUICommand(guiManager, skillManager));

        //Start up logic
        getServer().getConsoleSender().sendMessage(ChatColor.GREEN + "CustomSkills Enabled!");
    }

    @Override
    public void onDisable() {
        for (Player player : getServer().getOnlinePlayers()) {
            skillManager.savePlayerData(player.getUniqueId());
        }
    }

    public static CustomSkills getInstance() {
        return instance;
    }

    public SkillManager getSkillManager() {
        return skillManager;
    }

    public GUIManager getGuiManager() {
        return guiManager;
    }
}
