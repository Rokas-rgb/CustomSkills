package org.rokas.customSkills.Listeners;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.rokas.customSkills.Managers.SkillManager;
import org.rokas.customSkills.Models.SkillTypes;


public class MiningListener implements Listener {

private SkillManager skillManager;
private SkillTypes skillType;


public MiningListener(SkillManager skillManager) {
    this.skillManager = skillManager;
}

    @EventHandler
    public void onBlockBreak(BlockBreakEvent e) {

        Player player = e.getPlayer();
        Material type = e.getBlock().getType();

        double oreXp = 5;
        double debrisXp = 25;
        double blockXp = 1;

        if (type.name().endsWith("_ORE")) {
            skillManager.addXp(player.getUniqueId(), SkillTypes.MINING, oreXp);
            int miningLevel = skillManager.getPlayerData(player.getUniqueId()).getLevel(SkillTypes.MINING);
            player.sendMessage(ChatColor.GREEN + "You got 5 exp towards your mining skill!");
        }

        else if (type == Material.ANCIENT_DEBRIS) {
            skillManager.addXp(player.getUniqueId(), SkillTypes.MINING, debrisXp);
            player.sendMessage(ChatColor.GREEN + "You got 25 exp towards your mining skill!");

        }

        else {
            skillManager.addXp(player.getUniqueId(), SkillTypes.MINING, blockXp);
            player.sendMessage(ChatColor.GREEN + "You got 1 exp towards your mining skill!");
        }
    }
}
