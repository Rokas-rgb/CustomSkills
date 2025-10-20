package org.rokas.customSkills.GUI;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

public class SkillsGUI {

    private Inventory inventory;

    private List<String> miningLore;
    private List<String> fightingLore;
    private List<String> fishingLore;

    public SkillsGUI() {
        createInv();
    }


    public Inventory createInv() {

        inventory = Bukkit.createInventory(null, 27, "Skills");

        ItemStack item = new ItemStack(Material.DIAMOND_PICKAXE);
        ItemMeta meta = item.getItemMeta();

        meta.setDisplayName(ChatColor.BLUE + "Skills");
        miningLore = new ArrayList<>();
        miningLore.add(ChatColor.GRAY + "Mining Skill:");
        miningLore.add(ChatColor.GRAY + "Level: ");
        meta.setLore(miningLore);
        item.setItemMeta(meta);
        inventory.setItem(11, item);

        item = new ItemStack(Material.IRON_SWORD);
        meta.setDisplayName(ChatColor.BLUE + "Fighting skill: ");
        fightingLore = new ArrayList<>();
        fightingLore.add(ChatColor.GRAY + "Fighting Skill:");
        fightingLore.add(ChatColor.GRAY + "Level: ");
        meta.setLore(fightingLore);
        item.setItemMeta(meta);
        inventory.setItem(13, item);

        item = new ItemStack(Material.FISHING_ROD);
        meta.setDisplayName(ChatColor.BLUE + "Fishing skill: ");
        fishingLore = new ArrayList<>();
        fishingLore.add(ChatColor.GRAY + "Fishing Skill:");
        fishingLore.add(ChatColor.GRAY + "Level: ");
        meta.setLore(fishingLore);
        item.setItemMeta(meta);
        inventory.setItem(15, item);

        item = new ItemStack(Material.BARRIER);
        meta.setDisplayName(ChatColor.RED + "Close GUI");
        item.setItemMeta(meta);
        inventory.setItem(26, item);



    return inventory;
    }

    public Inventory getInv() {
        return inventory;
    }
}
