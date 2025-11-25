package org.rokas.customSkills.GUI;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.rokas.customSkills.Managers.SkillManager;
import org.rokas.customSkills.Models.PlayerData;
import org.rokas.customSkills.Models.SkillTypes;

import java.util.ArrayList;
import java.util.List;

public class SkillsGUI implements InventoryHolder {

    private Inventory inventory;
    private final SkillManager skillManager;
    private final Player player;

    private List<String> miningLore;
    private List<String> fightingLore;
    private List<String> fishingLore;
    private List<String> barrierLore;

    public SkillsGUI(SkillManager skillManager, Player player) {
        this.skillManager = skillManager;
        this.player = player;
        this.inventory = Bukkit.createInventory(this, 27, ChatColor.BLUE + "Skills");
        createInv();
    }

    public void refresh() {
        inventory.clear();
        createInv(); // just rebuilds all items
    }


    private void createInv() {

        //Player data
        PlayerData data = skillManager.getPlayerData(player.getUniqueId());
        int miningLevel = data.getLevel(SkillTypes.MINING);
        double miningXp = data.getXP(SkillTypes.MINING);

        //Creates the item
        double requiredXp = skillManager.getRequiredXp(miningLevel);
        ItemStack pick = new ItemStack(Material.DIAMOND_PICKAXE);
        ItemMeta meta = pick.getItemMeta();


        if (meta != null) {
            meta.setDisplayName(ChatColor.BLUE + "⛏Mining skills");
            miningLore = new ArrayList<>();
            miningLore.add(ChatColor.WHITE + "--------------------");
            miningLore.add(ChatColor.GRAY + "Level: " + ChatColor.GREEN + miningLevel);
            miningLore.add(ChatColor.GRAY + "XP: " + ChatColor.GREEN + miningXp + ChatColor.GRAY + " / " + ChatColor.GREEN + requiredXp);
            meta.setUnbreakable(true);
            meta.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
            meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
            meta.setLore(miningLore);
            pick.setItemMeta(meta);

        }
        inventory.setItem(11, pick);

        ItemStack sword = new ItemStack(Material.IRON_SWORD);
        meta = sword.getItemMeta();
        if (meta != null) {
            meta.setDisplayName(ChatColor.BLUE + "Fighting skill ");
            fightingLore = new ArrayList<>();
            fightingLore.add(ChatColor.WHITE + "--------------------");
            fightingLore.add(ChatColor.GRAY + "Level: "); // Add the level later
            meta.setUnbreakable(true);
            meta.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
            meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
            meta.setLore(fightingLore);
            sword.setItemMeta(meta);
        }
        inventory.setItem(13, sword);



        ItemStack rod = new ItemStack(Material.FISHING_ROD);
        meta = rod.getItemMeta();
        if (meta != null) {
            meta.setDisplayName(ChatColor.BLUE + "Fishing skill: ");
            fishingLore = new ArrayList<>();
            fishingLore.add(ChatColor.WHITE + "--------------------");
            fishingLore.add(ChatColor.GRAY + "Level: "); // Add the level later
            meta.setUnbreakable(true);
            meta.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
            meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
            meta.setLore(fishingLore);
            rod.setItemMeta(meta);
        }
        inventory.setItem(15, rod);

        ItemStack barrier = new ItemStack(Material.BARRIER);
        meta = barrier.getItemMeta();
        if (meta != null) {
            meta.setDisplayName(ChatColor.RED + "Close GUI");
            barrierLore = new ArrayList<>();
            barrierLore.add(ChatColor.GRAY + "Closes the GUI");
            meta.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
            meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
            meta.setLore(barrierLore);
            barrier.setItemMeta(meta);
        }
        inventory.setItem(26, barrier);


    }

    @Override
    public Inventory getInventory() {
        return inventory;
    }
}
