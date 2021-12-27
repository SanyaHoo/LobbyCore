package me.qubique.lobbycore;

import com.comphenix.protocol.PacketType;
import com.comphenix.protocol.ProtocolLibrary;
import com.comphenix.protocol.events.PacketAdapter;
import com.comphenix.protocol.events.PacketEvent;
import jdk.nashorn.internal.objects.annotations.Getter;
import me.qubique.lobbycore.board.QubiqueBoard;
import me.qubique.lobbycore.doublejump.DoubleJumpListener;
import me.qubique.lobbycore.joinEvents.JoinListener;
import me.qubique.lobbycore.menus.GuiInventory;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Iterator;

public final class LobbyCore extends JavaPlugin implements Listener {

    public QubiqueBoard qubiqueBoard = new QubiqueBoard();

    private static LobbyCore instance;



    @Override
    public void onEnable() {
        Bukkit.getPluginManager().registerEvents(new JoinListener(),this);
        Bukkit.getPluginManager().registerEvents(new GuiInventory(), this);
        Bukkit.getPluginManager().registerEvents(new DoubleJumpListener(), this);
        instance = this;
        Bukkit.getPluginManager().registerEvents(this, this);
        if (Bukkit.getPluginManager().getPlugin("ProtocolLib") != null) {
            ProtocolLibrary.getProtocolManager().addPacketListener(new PacketAdapter(this, new PacketType[]{PacketType.Play.Server.PLAYER_INFO}) {
                public void onPacketSending(PacketEvent event) {
                    event.setCancelled(true);
                }

                @EventHandler(
                        priority = EventPriority.HIGHEST
                )
                public void onJoin(PlayerJoinEvent e) {
                    Player p = e.getPlayer();
                    Iterator var4 = Bukkit.getOnlinePlayers().iterator();

                    while(var4.hasNext()) {
                        Player x = (Player)var4.next();
                        if (x != p) {
                            p.hidePlayer(x);
                        }
                    }

                }
            });
        } else {
            this.getLogger().warning("ProtocolLib!");
        }

    }

    public static LobbyCore getInstance() {
        return instance;
    }

}
