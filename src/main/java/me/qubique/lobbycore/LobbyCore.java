package me.qubique.lobbycore;

import jdk.nashorn.internal.objects.annotations.Getter;
import me.qubique.lobbycore.board.QubiqueBoard;
import me.qubique.lobbycore.doublejump.DoubleJumpListener;
import me.qubique.lobbycore.joinEvents.JoinListener;
import me.qubique.lobbycore.menus.GuiInventory;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public final class LobbyCore extends JavaPlugin {

    public QubiqueBoard qubiqueBoard = new QubiqueBoard();

    private static LobbyCore instance;



    @Override
    public void onEnable() {
        Bukkit.getPluginManager().registerEvents(new JoinListener(),this);
        Bukkit.getPluginManager().registerEvents(new GuiInventory(), this);
        Bukkit.getPluginManager().registerEvents(new DoubleJumpListener(), this);
        instance = this;

    }

    public static LobbyCore getInstance() {
        return instance;
    }

}
