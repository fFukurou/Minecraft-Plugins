package com.ffukurou.test;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class VanishCommand implements CommandExecutor {

    private List<UUID> vanished = new ArrayList<>();
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if (commandSender instanceof Player) {
            Player player = (Player) commandSender;

            if (vanished.contains(player.getUniqueId())) { // they are vanished
                vanished.remove(player.getUniqueId());
                for (Player target : Bukkit.getOnlinePlayers()) {
                    target.showPlayer(player);
                }
                player.sendMessage("You are now visible.");

            } else { // they are not vanished
                    vanished.add(player.getUniqueId());
                    for (Player target : Bukkit.getOnlinePlayers()) { // hiding the players from all the other players in the online list
                        target.hidePlayer(player);
                    }
                    player.sendMessage("You are now invisible!");
                }




        }
        return false;
    }
}
