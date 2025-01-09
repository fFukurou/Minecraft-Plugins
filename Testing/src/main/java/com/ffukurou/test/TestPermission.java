package com.ffukurou.test;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class TestPermission implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {

        if (commandSender instanceof Player) {
            Player player = (Player) commandSender;

            if (player.hasPermission("testplugin.use")) {
                player.sendMessage(ChatColor.GREEN + "You have permission to use this command!");
            } else {
                player.sendMessage(ChatColor.RED + "You don't have permission to use this comman!");
            }
        }



        return false;
    }
}
