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
        hologram.setCustomNameVisible(true);
        hologram.setCustomName(name);
    }

    public static void PlaceAS() {
        Place(381.5, 8, 514.5, "test");
    }
}
