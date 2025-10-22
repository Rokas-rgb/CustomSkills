package org.rokas.customSkills.Listeners;

import org.bukkit.ChatColor;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.entity.Projectile;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

public class FightingListener implements Listener {

    @EventHandler
    public void onEntityDamage(EntityDamageByEntityEvent e) {

        if (!(e.getDamager() instanceof Player player)) return;

        Entity damaged = e.getEntity();

        if (damaged instanceof LivingEntity && !(damaged instanceof org.bukkit.entity.ArmorStand)) {
            player.sendMessage(ChatColor.RED + "You damaged an entity!");
        }

        if (e.getDamager() instanceof Projectile projectile) {
            if (projectile.getShooter() instanceof Player) {
                player.sendMessage(ChatColor.RED + "You damaged an entity!");
            }
        }
    }
}
