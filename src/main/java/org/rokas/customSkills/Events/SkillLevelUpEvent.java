package org.rokas.customSkills.Events;

import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.rokas.customSkills.Models.SkillTypes;

public class SkillLevelUpEvent extends Event {

    private static final HandlerList handler = new HandlerList();

    private final Player player;
    private final SkillTypes skill;
    private final int newLevel;

    public  SkillLevelUpEvent(Player player, SkillTypes skill, int newLevel) {
        this.player = player;
        this.skill = skill;
        this.newLevel = newLevel;
    }

    public Player getPlayer() { return this.player; }
    public SkillTypes getSkill() { return this.skill; }
    public int getNewLevel() { return this.newLevel; }

    @Override
    public HandlerList getHandlers() { return handler; }

    public static HandlerList getHandlerList() { return handler; }
}
