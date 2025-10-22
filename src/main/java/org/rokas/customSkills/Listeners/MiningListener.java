package org.rokas.customSkills.Listeners;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.Tag;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

import java.util.Set;

public class MiningListener implements Listener {



    @EventHandler
    public void onBlockBreak(BlockBreakEvent e) {

        Player player = e.getPlayer();
        Material type = e.getBlock().getType();

        if (type.name().endsWith("_ORE")) {
            player.sendMessage(ChatColor.GREEN + "You got 10 exp towards your mining skill!");
        }

        else if (type == Material.ANCIENT_DEBRIS) {
            player.sendMessage(ChatColor.GREEN + "You got 20 exp towards your mining skill!");

        }

        else {
            player.sendMessage(ChatColor.GREEN + "You got 1 exp towards your mining skill!");
        }
    }
}
