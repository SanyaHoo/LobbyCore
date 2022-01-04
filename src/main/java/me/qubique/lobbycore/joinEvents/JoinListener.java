package me.qubique.lobbycore.joinEvents;

import me.qubique.lobbycore.LobbyCore;
import me.qubique.lobbycore.board.QubiqueBoard;
import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.*;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Hanging;
import org.bukkit.entity.LargeFireball;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.entity.*;
import org.bukkit.event.hanging.HangingBreakEvent;
import org.bukkit.event.inventory.CraftItemEvent;
import org.bukkit.event.inventory.InventoryDragEvent;
import org.bukkit.event.inventory.InventoryEvent;
import org.bukkit.event.player.*;
import org.bukkit.event.weather.WeatherChangeEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import javax.management.Notification;

public class JoinListener implements Listener {

    @EventHandler
    public void onJoin(PlayerJoinEvent e){
        Player player = e.getPlayer();
        Location loc = new Location(Bukkit.getWorld("world"), 384.5, 8, 517.5, 135, 0);
        player.teleport(loc);
        player.setGameMode(GameMode.ADVENTURE);
        e.setJoinMessage("");
        player.setHealth(1);
        player.setMaxHealth(1);
        player.setFoodLevel(20);
        LobbyCore.getInstance().qubiqueBoard.setScoreBoard(player);

      /*  Bukkit.getScheduler().runTaskTimer(LobbyCore.getInstance(), () -> {
            LobbyCore.getInstance().qubiqueBoard
        },0,20);
        */

    }

    @EventHandler
    public void onDropItem(PlayerDropItemEvent e){
        e.setCancelled(true);
    }

    @EventHandler
    public void onCraft(CraftItemEvent e) {
        e.setCancelled(true);
    }

    @EventHandler
    public void onFall(EntityDamageEvent e) {
        if (e.getCause() == EntityDamageEvent.DamageCause.FALL) {
            e.setCancelled(true);
        }
    }

    @EventHandler
    public void titlesOnJoin(PlayerJoinEvent e) {
        Player p = e.getPlayer();
        p.sendTitle("Добро пожаловать на",ChatColor.AQUA + "Qubique");
        p.spigot().sendMessage(ChatMessageType.ACTION_BAR,new TextComponent("Рады вас видеть!"));
    }

    @EventHandler
    public void onWeatherChange(WeatherChangeEvent e) {
        if(e.toWeatherState()) {
            e.setCancelled(true);
        }
    }
    @EventHandler
    public void onPlayerPlaceBlock(BlockPlaceEvent e){
        if(e.getPlayer().getGameMode() != GameMode.CREATIVE) {
            e.setCancelled(true);
        }
    }
    @EventHandler
    public void onPlayerBreakBlock(BlockBreakEvent e) {
        if(e.getPlayer().getGameMode() == GameMode.CREATIVE) {
            e.setCancelled(true);
        }
    }
    @EventHandler
    public void onHangingBreak(HangingBreakEvent e) {
        Hanging en = e.getEntity();
        switch (en.getType()) {
            case ITEM_FRAME:
            case PAINTING:
                e.setCancelled(true);
                break;
        }
    }

    @EventHandler
    public void joinMessageDeny(PlayerQuitEvent e ) {
        e.setQuitMessage("");
    }

    @EventHandler
    public void damageByPlayer(EntityDamageEvent e){
        if (e.getEntity() instanceof Player) e.setCancelled(true);
    }
    @EventHandler
    public void mobSpawn(EntitySpawnEvent e) {
        if(e.getEntity().getType() != EntityType.ARMOR_STAND){
            e.setCancelled(true);
        }
    }

    @EventHandler(priority = EventPriority.LOWEST, ignoreCancelled = false)
    public void opsaSpawnEvent(CreatureSpawnEvent event) {
        if(event.getSpawnReason()== CreatureSpawnEvent.SpawnReason.EGG) {
            event.setCancelled(true);
        }
    }
    @EventHandler
    public void disableAchievement(PlayerAchievementAwardedEvent e) {
        e.setCancelled(true);
    }
    @EventHandler
    public void foodLevel(FoodLevelChangeEvent e) {
        e.setCancelled(true);
    }
    @EventHandler
    public void onCreatureSpawn(CreatureSpawnEvent event) {
        if (event.getSpawnReason().equals(CreatureSpawnEvent.SpawnReason.NATURAL)) event.setCancelled(true);
    }
    @EventHandler
    public void onClickChests(PlayerInteractEvent event) {
        Player p = event.getPlayer();
        if (p.getGameMode() != GameMode.CREATIVE) {
            event.setCancelled(true);
        }
    }
}
