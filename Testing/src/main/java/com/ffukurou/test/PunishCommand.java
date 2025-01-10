package com.ffukurou.test;

import org.bukkit.BanList;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.Calendar;

public class PunishCommand implements CommandExecutor {
        // /punish <player name> <kick/ban/tempban>


    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if (commandSender instanceof Player) {
            Player player = (Player) commandSender;

            if (strings.length == 2) {
                if (Bukkit.getPlayer(strings[0]) != null) {
                    Player target = Bukkit.getPlayer(strings[0]);

                    switch (strings[1].toLowerCase()) {
                        case "kick":
                            target.kickPlayer(ChatColor.RED + "You garbage\nKEKW");
                            break;
                        case "ban":
                            Bukkit.getBanList(BanList.Type.NAME).addBan(target.getName(), ChatColor.RED + "Being a bad player\nAppeal if you want :D", null, null);
                            target.kickPlayer(ChatColor.RED + "You have been banned.\nKEKW");
                            break;
                        case "tempban":
                            Calendar cal = Calendar.getInstance();
                            cal.add(Calendar.HOUR, 12);

                            Bukkit.getBanList(BanList.Type.NAME).addBan(target.getName(), ChatColor.RED + "Being a bad player\nAppeal if you want :D", cal.getTime(), null);
                            target.kickPlayer(ChatColor.RED + "You have been temporarily banned.\nKEKW");
                            break;
                        default:
                            player.sendMessage(ChatColor.RED + "You did not specify whether to kick, ban or tempban...");
                            return false;
                    }

                } else {
                    player.sendMessage(ChatColor.RED + "This player is not online.");
                }

            } else {
                player.sendMessage(ChatColor.RED + "Invalid Usage! Use /punish <player name> <kick/ban/tempban>");
            }

        }


        return false;
    }
}
