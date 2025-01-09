package com.ffukurou.test;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;

public class TestCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {

        if (commandSender instanceof Player) {
            // if first argument == 'hello', then send hello back
            if (strings.length == 1) {
                if (strings[0].equalsIgnoreCase("hello")) {
                    ((Player) commandSender).sendMessage("Hello!");
                }
            }
        } else {
            System.out.println("Hello dev!");
        }

        return false;
    }
}
