package com.ffukurou.test;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.List;

public class ConfigCommand implements CommandExecutor {

    private Main main;
    public ConfigCommand(Main main) {
        this.main = main;
    }
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {

        if (commandSender instanceof Player) {
            Player player = (Player) commandSender;
            if (strings.length == 0) {


                player.sendMessage(main.getConfig().getString("Word"));
                player.sendMessage(main.getConfig().getInt("Number") + "");

                if (main.getConfig().getBoolean("Boolean") == true) {
                    player.sendMessage("This feature is enabled!");
                }

                for (String string : main.getConfig().getStringList("String-list")) {
                    player.sendMessage(string);
                }

            } else if (strings.length == 1) {
                if (strings[0].equalsIgnoreCase("change")) {
                    main.getConfig().set("Word", "Cake");

                    List<String> list = main.getConfig().getStringList("String-list");
                    if (list.size() == 3)
                        list.add("who do you think i am");
                    main.getConfig().set("String-list", list);

                    main.saveConfig();
                }
            }
        }



        return false;
    }
}
