package com.ffukurou.test;

import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.*;
import org.bukkit.Color;
import org.bukkit.boss.BarColor;
import org.bukkit.boss.BarFlag;
import org.bukkit.boss.BarStyle;
import org.bukkit.boss.BossBar;
import org.bukkit.entity.Egg;
import org.bukkit.entity.Firework;
import org.bukkit.FireworkEffect.Type;
import org.bukkit.entity.Player;
import org.bukkit.entity.Snowball;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.CreatureSpawnEvent;
import org.bukkit.event.entity.ProjectileLaunchEvent;
import org.bukkit.event.player.*;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.BookMeta;
import org.bukkit.inventory.meta.FireworkMeta;
import org.bukkit.inventory.meta.LeatherArmorMeta;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public final class Main extends JavaPlugin implements Listener {

    private boolean enabled = true;
    private BossBar bossBar;
    @Override
    public void onEnable() {
        // Plugin startup logic
        getConfig().options().copyDefaults();
        saveDefaultConfig();


        Bukkit.getPluginManager().registerEvents(this, this);
        Bukkit.getPluginManager().registerEvents(new ToggleListener(), this);

        getCommand("heal").setExecutor(new HealCommand());
        getCommand("test").setExecutor(new TestCommand());
        getCommand("config").setExecutor(new ConfigCommand(this));
        getCommand("permissions").setExecutor(new TestPermission());
        getCommand("spawn").setExecutor(new SpawnCommand());
        getCommand("world").setExecutor(new WorldCommand());
        getCommand("music").setExecutor(new PlayMusicCommand());
        getCommand("vanish").setExecutor(new VanishCommand());
        getCommand("book").setExecutor(new BookCommand());
        getCommand("banner").setExecutor(new BannerCommand());
        getCommand("punish").setExecutor(new PunishCommand());

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

        // POTION EFFECT
        for (PotionEffect effect : e.getPlayer().getActivePotionEffects()) {
             e.getPlayer().removePotionEffect(effect.getType());
        }

        e.getPlayer().addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 400, 2, true, true));

        // RESOURCE PACK
//        e.getPlayer().setResourcePack("https://download1500.mediafire.com/xc4khd3as7xgWxe79pPLShvPJ5ks5j5CHE2Cv9d12_Eejo9TP8pTK8p1rm1w7-1E0q2fhOzl7Fp_0Q-PdoPLJ5roiHOilNKrjbqbs-s6TRCIWZ6o6bpcFFJ4h-B-kVFwoAe2x4HdwdzF6zvpnYqiwGxJb35V57gtReoKR1FEN8PnENHt/pbk9jqhwl6xxmeo/Equanimity.zip");

        // STATISTICS
        System.out.println(e.getPlayer().getStatistic(Statistic.CRAFT_ITEM, Material.IRON_LEGGINGS));
        e.getPlayer().incrementStatistic(Statistic.DROP_COUNT, 1);
        System.out.println(e.getPlayer().getStatistic(Statistic.DROP_COUNT));


    }


    @EventHandler
    public void onResourceStatus(PlayerResourcePackStatusEvent e) {
        //
    }

    @EventHandler
    public void onSneak(PlayerToggleSneakEvent e) {
        // FIREWORKS
//        Firework firework = e.getPlayer().getWorld().spawn(e.getPlayer().getLocation(), Firework.class);
//        FireworkMeta meta = (FireworkMeta) firework.getFireworkMeta();
//        meta.addEffect(FireworkEffect.builder().withColor(Color.RED).withColor(Color.BLUE).with(Type.BALL_LARGE).withFlicker().build());
//        meta.setPower(2);
//        firework.setFireworkMeta(meta);

        if (e.isSneaking()) {
            // Play sound block note when SNEAKING
            e.getPlayer().playSound(e.getPlayer().getLocation(), Sound.BLOCK_NOTE_BLOCK_BANJO, 1, 0.79f);
            // Play particle
            e.getPlayer().spawnParticle(Particle.EXPLOSION, e.getPlayer().getLocation(), 25);
        }


    }

    @EventHandler
    public void onJump(PlayerDropItemEvent e) {
        // SOUNDS
        e.getPlayer().playSound(e.getPlayer().getLocation(), Sound.ENTITY_ARMOR_STAND_FALL, 5.0F, 1.0F);
    }

    @EventHandler
    public void onPlayerInteract(PlayerInteractEvent e) {
        Player player = e.getPlayer();
        // Checks to see if it's the Right Hand
        if (e.getHand().equals(EquipmentSlot.HAND)) {
            // Checks to see if the player is either clicking a block or air
            if (e.getAction().equals(Action.RIGHT_CLICK_AIR) || e.getAction().equals(Action.RIGHT_CLICK_BLOCK)) {
                // If it is a diamond hoe, throw an egg
                if (player.getInventory().getItemInMainHand() != null && player.getInventory().getItemInMainHand().getType().equals(Material.DIAMOND_HOE)) {
                    player.launchProjectile(Egg.class, player.getLocation().getDirection());
                }
                // If it is an Iron hoe, throw an snowball
                else if (player.getInventory().getItemInMainHand() != null && player.getInventory().getItemInMainHand().getType().equals(Material.IRON_HOE)) {
                    player.launchProjectile(Snowball.class, player.getLocation().getDirection());
                }
            }



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

//    @EventHandler
//    public void onPlayerInteract(PlayerInteractEvent e) {
//        Player player = e.getPlayer();
//
//        if (e.getPlayer().equals(EquipmentSlot.HAND)) {
//
//        }
//    }



    @EventHandler
    public void onChat(AsyncPlayerChatEvent e) {
        if (!enabled) {
            e.setCancelled(true);
            e.getPlayer().sendMessage("Chat is disabled right now...");
        }

    }


    @EventHandler
    public void onEntityInteract(PlayerInteractEntityEvent e) {
        if (e.getPlayer().isSneaking()) {
            e.getPlayer().addPassenger(e.getRightClicked());
        } else {
            e.getRightClicked().addPassenger(e.getPlayer());
        }
    }

//    @Override
//    public void onDisable() {
//        // Plugin shutdown logic
//        System.out.println("THE PLUGIN FUCKING DIED!");
//    }


}
