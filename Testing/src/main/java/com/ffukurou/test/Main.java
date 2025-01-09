package com.ffukurou.test;

import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.boss.BarColor;
import org.bukkit.boss.BarFlag;
import org.bukkit.boss.BarStyle;
import org.bukkit.boss.BossBar;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.CreatureSpawnEvent;
import org.bukkit.event.player.PlayerEggThrowEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.BookMeta;
import org.bukkit.inventory.meta.LeatherArmorMeta;
import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin implements Listener {


    private BossBar bossBar;
    @Override
    public void onEnable() {
        // Plugin startup logic
        getConfig().options().copyDefaults();
        saveDefaultConfig();


        Bukkit.getPluginManager().registerEvents(this, this);

        getCommand("heal").setExecutor(new HealCommand());
        getCommand("test").setExecutor(new TestCommand());
        getCommand("config").setExecutor(new ConfigCommand(this));
        getCommand("permissions").setExecutor(new TestPermission());
        getCommand("spawn").setExecutor(new SpawnCommand());

        bossBar = Bukkit.createBossBar(ChatColor.LIGHT_PURPLE + "Awesome server!...",
                BarColor.PINK,
                BarStyle.SEGMENTED_6);





    }

//    @EventHandler
//    public void onPlayerMove(PlayerMoveEvent e) {
//        e.setCancelled(true);
//        e.getPlayer().sendMessage(ChatColor.RED + "Lmao you can't move 😂");
//    }

    @EventHandler
    public void onPlayerEggThrow(PlayerEggThrowEvent e) {
        e.getPlayer().sendMessage("BRUH YOU JUST WASTED THAT EGG!?");
    }

    @EventHandler
    public void onJoin(PlayerJoinEvent e) {

        // ADD LEATHER ARMOR TO PLAYERS
        ItemStack helmet = new ItemStack(Material.LEATHER_HELMET);
        LeatherArmorMeta helmetMeta = (LeatherArmorMeta) helmet.getItemMeta();
        helmetMeta.setColor(Color.GREEN);
        helmet.setItemMeta(helmetMeta);

        e.getPlayer().getInventory().addItem(helmet);

        ItemStack chestPlate = new ItemStack(Material.LEATHER_CHESTPLATE);
        LeatherArmorMeta chestPlateMeta = (LeatherArmorMeta) chestPlate.getItemMeta();
        chestPlateMeta.setColor(org.bukkit.Color.fromRGB(179, 255, 255));
        chestPlate.setItemMeta(chestPlateMeta);

        e.getPlayer().getInventory().addItem(chestPlate);

        // SEND TITLE
        e.getPlayer().sendTitle(ChatColor.RED + "Hello!",
                ChatColor.GREEN +  "Welcome to the server!",
                30,100, 40);

        // SEND ACTION BAR
        e.getPlayer().spigot().sendMessage(ChatMessageType.ACTION_BAR,
                TextComponent.fromLegacyText("§4§lHELLO MY FRIEND!"));

        // SET TAB LAYOUT
        e.getPlayer().setPlayerListHeaderFooter(ChatColor.RED + "fFukurou's server",
                "Nothing to say\nNothing to show");

        // SET BOSS BAR
        bossBar.addPlayer(e.getPlayer());
    }



//    @Override
//    public void onDisable() {
//        // Plugin shutdown logic
//        System.out.println("THE PLUGIN FUCKING DIED!");
//    }
}
