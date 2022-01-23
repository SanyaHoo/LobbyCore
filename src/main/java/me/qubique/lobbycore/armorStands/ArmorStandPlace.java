package me.qubique.lobbycore.armorStands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.EntityType;

public class ArmorStandPlace {

    public static void Place(double x, double y, double z, String name){
        World world = Bukkit.getWorld("world");
        Location loc = new Location(world, x, y, z);
        ArmorStand hologram = (ArmorStand) world.spawnEntity(loc, EntityType.ARMOR_STAND);
        hologram.setVisible(false);
        hologram.setGravity(false);
        hologram.setMarker(true);
        hologram.setCustomNameVisible(true);
        hologram.setCustomName(name);
    }

    public static void PlaceAS() {
        Place(0.5, 60, 3.5, "§n§l§cQubique.ru");
        Place(0.5, 59.5, 3.5, "§nНажимай на компас и начинай игру!");
        Place(0.5, 59.0, 3.5, "Покупка доната на сайте:");
        Place(0.5, 58.75, 3.5, "§n§l§cwww.Qubique.ru");
    }
}
