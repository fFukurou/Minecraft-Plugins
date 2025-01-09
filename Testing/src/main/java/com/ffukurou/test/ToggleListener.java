package com.ffukurou.test;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.EquipmentSlot;

public class ToggleListener implements Listener {

    private boolean enabled = true;

    @EventHandler
    public void onPlayerInteract(PlayerInteractEvent e) {
        Player player = e.getPlayer();

        if (e.getPlayer().equals(EquipmentSlot.HAND)) {
            if (e.getPlayer().getInventory().getItemInMainHand() != null & e.getPlayer().getInventory().getItemInMainHand().getType().equals(Material.NETHER_STAR)) {
                if (enabled) {
                    enabled = false;
                    player.sendMessage("You have disabled the chat!");
                } else {
                    enabled = true;
                    player.sendMessage("You have enabled the chat!");
                }
            }
        }
    }



    @EventHandler
    public void onChat(AsyncPlayerChatEvent e) {
        if (!enabled) {
            e.setCancelled(true);
            e.getPlayer().sendMessage("Chat is disabled right now...");
        }

    }
}
