package me.qubique.lobbycore;

import com.alonsoaliaga.alonsolevels.AlonsoLevels;
import me.qubique.lobbycore.armorStands.ArmorStandPlace;
import me.qubique.lobbycore.blockCommands.BlockCommands;
import me.qubique.lobbycore.board.QubiqueBoard;
import me.qubique.lobbycore.doublejump.DoubleJumpListener;
import me.qubique.lobbycore.joinEvents.JoinListener;
import me.qubique.lobbycore.menus.GuiInventory;
import net.luckperms.api.LuckPerms;
import org.bukkit.Bukkit;
import org.bukkit.entity.Entity;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;


public final class LobbyCore extends JavaPlugin implements Listener {

    public QubiqueBoard qubiqueBoard = new QubiqueBoard();

    private static LobbyCore instance;
    private static AlonsoLevels alonsoLevels;

    public ArmorStandPlace asPlace = new ArmorStandPlace();
    public static LuckPerms luckPerms;
    @Override
    public void onEnable() {
        for(Entity e : Bukkit.getWorld("world").getEntities()) {
            e.remove();
        }
        Bukkit.getPluginManager().registerEvents(new JoinListener(),this);
        Bukkit.getPluginManager().registerEvents(new GuiInventory(), this);
        Bukkit.getPluginManager().registerEvents(new DoubleJumpListener(), this);
        Bukkit.getPluginManager().registerEvents(new BlockCommands(), this);
        ArmorStandPlace.PlaceAS();
        instance = this;
        Bukkit.getPluginManager().registerEvents(this, this);
        /*if (Bukkit.getPluginManager().getPlugin("ProtocolLib") != null) {
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
        }*/

    }

    public static LobbyCore getInstance() {
        return instance;
    }

}
