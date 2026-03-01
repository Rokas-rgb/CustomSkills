package org.rokas.customSkills.Listeners;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.event.inventory.InventoryDragEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.rokas.customSkills.GUI.SkillsGUI;
import org.rokas.customSkills.Managers.GUIManager;

public class GUIListener implements Listener {

    private final GUIManager manager;

    public GUIListener(GUIManager manager) {
        this.manager  = manager;
    }

    @EventHandler
    public void onInventoryClose(InventoryCloseEvent e) {
        if (e.getInventory().getHolder() instanceof SkillsGUI) {
            manager.close((Player) e.getPlayer());
        }
    }

    @EventHandler
    public void onInventoryDrag(InventoryDragEvent e) {
        Inventory top = e.getView().getTopInventory();

        if(top.getHolder() instanceof SkillsGUI) {
            e.setCancelled(true);
        }
    }

   @EventHandler
    public void onInventoryClick(InventoryClickEvent e) {
        if(!(e.getWhoClicked() instanceof Player)) return;
        if (!(e.getInventory().getHolder() instanceof SkillsGUI)) return;

        Player player = (Player) e.getWhoClicked();
        ItemStack item = e.getCurrentItem();
        if(item == null) return;

        if(item.getType() == Material.BARRIER) {
            e.setCancelled(true);
            player.closeInventory();
            manager.close(player);
        }
   }
}
