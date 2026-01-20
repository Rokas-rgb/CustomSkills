package org.rokas.customSkills.Titles;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.title.Title;
import org.bukkit.entity.Player;

import java.time.Duration;

public class TitleService {

    public void sendTitle(Player player, String title, String subtitle, int fadeIn, int stay, int fadeOut) {

        Title.Times times = Title.Times.times (
                Duration.ofMillis(fadeIn * 50L),
                Duration.ofMillis(stay * 50L),
                Duration.ofMillis(fadeOut * 50L)
        );
    }
}
