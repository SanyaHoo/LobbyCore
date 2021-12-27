package me.qubique.lobbycore.board;

import com.alonsoaliaga.alonsolevels.api.AlonsoLevelsAPI;
import me.qubique.lobbycore.LobbyCore;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.*;
import org.bukkit.Statistic;
import org.bukkit.entity.Player;
import java.util.ArrayList;
import java.util.List;

public class QubiqueBoard {

    public void setScoreBoard(Player p) {
        Scoreboard board = Bukkit.getScoreboardManager().getNewScoreboard();
        Objective obj = board.registerNewObjective("Qubique","dummy");
        obj.setDisplaySlot(DisplaySlot.SIDEBAR);
        obj.setDisplayName("§bQubique");

        Team privelege = board.registerNewTeam("privelegia");

        obj.getScore("§bИнфо").setScore(9);
        obj.getScore("Ник §8» §f" + p.getDisplayName()).setScore(8);
        obj.getScore("Группа §8» §f").setScore(7);
        obj.getScore("Уровень §8» " + AlonsoLevelsAPI.getLevel(p.getUniqueId())).setScore(6);
        obj.getScore("Опыт" + AlonsoLevelsAPI.getProgressBar(p.getUniqueId())).setScore(5);
        obj.getScore("§1").setScore(4);
        obj.getScore("§bОнлайн").setScore(3);
        obj.getScore("Сервер §8» §f2532").setScore(2);
        obj.getScore("Хаб §8» §f14").setScore(1);
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
