package org.rokas.customSkills.Models;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class PlayerData {

    private final UUID uuid;
    private final Map<SkillTypes, Integer> levels = new HashMap<>();
    private final Map<SkillTypes, Double> xp =  new HashMap<>();

    public PlayerData(UUID uuid) {
        this.uuid = uuid;
    }

    public UUID getUUID() {
        return uuid;
    }

    public int getLevel(SkillTypes skill) {
        return levels.getOrDefault(skill,1);
    }

    public double getXP(SkillTypes skill) {
        return xp.getOrDefault(skill,0.0);
    }

    public void addXP(SkillTypes skill, double amount) {
        xp.put(skill, getXP(skill) + amount);
    }

    public void levelUp(SkillTypes skill) {
        levels.put(skill, getLevel(skill) + 1);
        xp.put(skill, 0.0);
    }

    public boolean hasAnyProgress() {
        for (SkillTypes skill : SkillTypes.values()) {
            if (getXP(skill) > 0 || getLevel(skill) > 1) return true;
        }
        return false;
    }

}
