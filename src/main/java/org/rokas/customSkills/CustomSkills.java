package org.rokas.customSkills;

import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;
import org.rokas.customSkills.Commands.GUICommand;
import org.rokas.customSkills.GUI.SkillsGUI;
import org.rokas.customSkills.Listeners.GUIListener;

public final class CustomSkills extends JavaPlugin {

    private SkillsGUI skillsGUI;


    @Override
    public void onEnable() {
        skillsGUI = new SkillsGUI();

        getServer().getPluginManager().registerEvents(new GUIListener(), this);

       getCommand("skills").setExecutor(new GUICommand(skillsGUI));

        getServer().getConsoleSender().sendMessage(ChatColor.GREEN + "CustomSkills Enabled!");
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
