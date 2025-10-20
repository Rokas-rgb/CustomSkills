package org.rokas.customSkills.Commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.rokas.customSkills.GUI.SkillsGUI;


public class GUICommand implements CommandExecutor {

    private final SkillsGUI gui;

    public GUICommand(SkillsGUI gui) {
        this.gui = gui;
    }

    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        // /skills displays GUI with the players skills
            if (command.getName().equalsIgnoreCase("skills")) {

                if(!(sender instanceof Player)){
                    sender.sendMessage(ChatColor.RED + "Only players can use this command");

                }

                Player p = (Player) sender;
                p.openInventory(gui.getInv());
                return true;
            }
        return true;
    }
}
