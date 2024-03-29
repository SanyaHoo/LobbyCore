package me.qubique.lobbycore.board;

import com.alonsoaliaga.alonsolevels.api.AlonsoLevelsAPI;
import me.qubique.lobbycore.LobbyCore;
import net.luckperms.api.LuckPerms;
import net.luckperms.api.LuckPermsProvider;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.*;
import org.bukkit.Statistic;
import org.bukkit.entity.Player;
import java.util.ArrayList;
import java.util.List;

public class QubiqueBoard {

    public void setScoreBoard(Player p) {
        LuckPerms api = LuckPermsProvider.get();
        String prefix = api.getGroupManager().getGroup(api.getUserManager().getUser(p.getPlayer().getUniqueId()).getPrimaryGroup()).getCachedData().getMetaData().getPrefix();

        Scoreboard board = Bukkit.getScoreboardManager().getNewScoreboard();
        Objective obj = board.registerNewObjective("Qubique","dummy");
        obj.setDisplaySlot(DisplaySlot.SIDEBAR);
        obj.setDisplayName("§bQubique");

        Team privelege = board.registerNewTeam("privelegia");

        obj.getScore("§bИнфо").setScore(8);
        obj.getScore("Ник §8» §f" + p.getDisplayName()).setScore(7);
        obj.getScore("Группа §8» " + prefix).setScore(6);
        obj.getScore("Уровень §8» §f" + AlonsoLevelsAPI.getLevel(p.getUniqueId())).setScore(5);
        obj.getScore("§1").setScore(4);
        obj.getScore("§bОнлайн").setScore(3);
        obj.getScore("Сервер §8» §f2532").setScore(2);
        obj.getScore("Хаб §8» §f" + Bukkit.getOnlinePlayers().size()).setScore(1);
        obj.getScore("    www.qubique.ru").setScore(0);
        privelege.addEntry("§e");
        privelege.setPrefix("§e");

        p.setScoreboard(board);
    }
    public void updateBoard(Player p) {
        Scoreboard board = p.getScoreboard();
        Team privelege = board.getTeam("privelege");
    }
}