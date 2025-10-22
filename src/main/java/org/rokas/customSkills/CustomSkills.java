package org.rokas.customSkills;

import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;
import org.rokas.customSkills.Commands.GUICommand;
import org.rokas.customSkills.GUI.SkillsGUI;
import org.rokas.customSkills.Listeners.FightingListener;
import org.rokas.customSkills.Listeners.FishingListener;
import org.rokas.customSkills.Listeners.GUIListener;
import org.rokas.customSkills.Listeners.MiningListener;

public final class CustomSkills extends JavaPlugin {

    private SkillsGUI skillsGUI;
    private MiningListener miningListener;


    @Override
    public void onEnable() {
        skillsGUI = new SkillsGUI();

        getServer().getPluginManager().registerEvents(new GUIListener(), this);
        getServer().getPluginManager().registerEvents(new MiningListener(), this);
        getServer().getPluginManager().registerEvents(new FightingListener(), this);
        getServer().getPluginManager().registerEvents(new FishingListener(), this);
        getCommand("skills").setExecutor(new GUICommand(skillsGUI));

        getServer().getConsoleSender().sendMessage(ChatColor.GREEN + "CustomSkills Enabled!");
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
