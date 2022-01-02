package me.qubique.lobbycore.blockCommands;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;

import java.util.Arrays;

public class BlockCommands implements Listener {
    static String[] blockedEquals = {
            "/pl",
            "/plugins",
            "/help",
            "/bukkit:help",
            "/version",
            "/bungee",
            "/bukkit:?"
    };

    static String[] blockedStarts = {
            "/bukkit",
            "/minecraft:"
    };

    @EventHandler
    public static void onCommand(PlayerCommandPreprocessEvent e){
        String message = e.getMessage();
        String[] args = message.split(" ");
        Player p = e.getPlayer();

        boolean blocked = false;

        if(Arrays.asList(blockedEquals).contains(args[0])) {
            blocked = true;
        }

        for(String st : blockedStarts) {
            if(args[0].toLowerCase().startsWith(st)) {
                blocked = true;
            }
        }

        if (blocked) {
            e.setCancelled(true);
        }
    }
}
