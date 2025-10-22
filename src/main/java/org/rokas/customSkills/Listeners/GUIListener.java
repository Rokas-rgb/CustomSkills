package org.rokas.customSkills.Listeners;

import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryDragEvent;
import org.bukkit.inventory.Inventory;
import org.rokas.customSkills.GUI.SkillsGUI;

public class GUIListener implements Listener {

    private SkillsGUI gui;

    public GUIListener() {
        this.gui = gui;
    }


    @EventHandler
    public void onInventoryClick(InventoryClickEvent e) {

        Inventory top = e.getView().getTopInventory();

        if(top.getHolder() instanceof SkillsGUI) {
            e.setCancelled(true);
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
    public void onBarrierClick(InventoryClickEvent e) {
        if (e.getSlot() == 26) {
            e.getWhoClicked().closeInventory();
        }
    }
}
