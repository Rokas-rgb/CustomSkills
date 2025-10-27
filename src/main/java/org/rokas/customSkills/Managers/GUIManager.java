package org.rokas.customSkills.Managers;

import org.bukkit.entity.Player;
import org.rokas.customSkills.GUI.SkillsGUI;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class GUIManager {

    private final SkillManager skillManager;
    private final Map<UUID, SkillsGUI> openGUIs = new HashMap<>();

    public GUIManager(SkillManager skillManager) {
        this.skillManager = skillManager;
    }

    public void openSkillsGUI(Player player) {
        SkillsGUI gui = new SkillsGUI(skillManager, player);
        openGUIs.put(player.getUniqueId(), gui);
        player.openInventory(gui.getInventory());
    }

    public void refreshIfOpen(Player player) {
        SkillsGUI gui = openGUIs.get(player.getUniqueId());
        if (gui != null) {
            gui.refresh();
            player.openInventory(gui.getInventory());
            }
        }
    public void close(Player player) {
        openGUIs.remove(player.getUniqueId());
    }
}
