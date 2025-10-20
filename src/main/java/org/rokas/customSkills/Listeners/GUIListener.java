//package org.rokas.customSkills.Listeners;

//import org.bukkit.ChatColor;
//import org.bukkit.event.EventHandler;
//import org.bukkit.event.Listener;
//import org.bukkit.event.inventory.InventoryClickEvent;
//import org.bukkit.event.inventory.InventoryDragEvent;
//import org.rokas.customSkills.GUI.SkillsGUI;

//public class GUIListener implements Listener {

    private SkillsGUI gui;

    public GUIListener() {
        this.gui = gui;
    }


    @EventHandler
    public void onInventoryClick(InventoryClickEvent e) {

        if(e.getView().getTitle().equalsIgnoreCase(ChatColor.BLUE + "Skills")) {
            e.setCancelled(true);

            if(e.getCurrentItem() == null) return;

            switch(e.getSlot()) {
                case 26:
                    e.getWhoClicked().closeInventory();
                    break;
            }
        }
    }

    @EventHandler
    public void onInventoryDrag(InventoryDragEvent e) {
        if(e.getView().getTitle().equalsIgnoreCase(ChatColor.BLUE + "Skills")) {
            e.setCancelled(true);
        }
    }
}
