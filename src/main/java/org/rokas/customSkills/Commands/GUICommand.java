package org.rokas.customSkills.Commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.rokas.customSkills.GUI.SkillsGUI;
import org.rokas.customSkills.Managers.GUIManager;
import org.rokas.customSkills.Managers.SkillManager;


public class GUICommand implements CommandExecutor {

    private final GUIManager guiManager;
    private final SkillManager skillManager;

    public GUICommand(GUIManager guiManager, SkillManager skillManager) {
        this.guiManager = guiManager;
        this.skillManager = skillManager;
    }

    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        // /skills displays GUI with the players skills
            if (command.getName().equalsIgnoreCase("skills")) {

                if(!(sender instanceof Player)){
                    sender.sendMessage(ChatColor.RED + "Only players can use this command");

                }

                Player player = (Player) sender;
                guiManager.openSkillsGUI(player);
                return true;
            }
        return true;
    }
}
