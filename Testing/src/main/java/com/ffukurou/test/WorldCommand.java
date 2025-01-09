package com.ffukurou.test;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class WorldCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if (commandSender instanceof Player) {
            Player player = (Player) commandSender;
            if (strings.length == 1) {
                // STORM ARGUMENT
                if (strings[0].equalsIgnoreCase("storm")) {
                    if (player.getWorld().hasStorm()) {
                        player.getWorld().setStorm(false);
                    } else {
                        player.getWorld().setStorm(true);
                    }
                }

            }
            else if (strings.length == 2) {
                // TIME ARGUMENT
                if (strings[0].equalsIgnoreCase("time") && strings[1].matches("\\d+")) {
                    player.getWorld().setTime(Long.parseLong(strings[1]));
                }
            }
        }




        return false;
    }
}
