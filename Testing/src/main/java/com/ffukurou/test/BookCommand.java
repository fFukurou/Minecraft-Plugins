package com.ffukurou.test;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.BookMeta;

public class BookCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if (commandSender instanceof Player) {
            Player player = (Player) commandSender;

            ItemStack book = new ItemStack(Material.WRITTEN_BOOK);
            BookMeta meta = (BookMeta) book.getItemMeta();
            meta.setTitle(ChatColor.RED + "My epic Book!");
            meta.setAuthor(ChatColor.GOLD + "fFukurou");
            meta.addPage(ChatColor.DARK_BLUE + "I wake up to the sound\n" +
                    "\n Of the silence that allows,\n" +
                    "For my mind to run about,\n" +
                    "With my ear up to the ground.");

            meta.setGeneration(BookMeta.Generation.TATTERED);

            book.setItemMeta(meta);

            player.getInventory().addItem(book);

        }


        return false;
    }
}
