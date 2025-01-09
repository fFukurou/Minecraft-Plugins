package com.ffukurou.test;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;

public class SpawnCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {

        if (strings.length == 1) {
            switch (strings[0].toLowerCase()) {
                case "polarbear":
                    Entity polarBear = Bukkit.getWorld("world").spawnEntity(new Location(Bukkit.getWorld("world"), 660, 64, -21), EntityType.POLAR_BEAR);
                    polarBear.setGlowing(true);
                    break;

                case "stand":
                    ArmorStand stand = (ArmorStand) Bukkit.getWorld("world").spawnEntity(new Location(Bukkit.getWorld("world"), 660, 64, -21), EntityType.ARMOR_STAND);
                    break;

            }

        }



        return false;
    }
}
