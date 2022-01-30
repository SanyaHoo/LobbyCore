package me.qubique.lobbycore.armorStands;

import org.bukkit.*;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.LeatherArmorMeta;
import org.bukkit.util.EulerAngle;

import java.util.ArrayList;

import static com.alonsoaliaga.alonsolevels.utils.LocalUtils.colorize;

public class ArmorStandCommands {

    public static void placeArmorStands(double x, double y, double z, float yaw, float pitch, double headxr,double headyr, double headzr, double bodyxr,double bodyyr, double bodyzr, double rightarmxr,double rightarmyr, double rightarmzr, double leftarmxr,double leftarmyr, double leftarmzr, double rightlegxr,double rightlegyr, double rightlegzr, double leftlegxr,double leftlegyr, double leftlegzr, Material materialinhand, Material halmet, Material chestplate, Material leggins, Material boots) {
        World world = Bukkit.getWorld("world");
        Location loc = new Location(world, x, y, z, yaw, pitch);
        ArmorStand armorstand = (ArmorStand) world.spawnEntity(loc,EntityType.ARMOR_STAND);
        armorstand.setHelmet(new ItemStack(halmet));
        armorstand.setChestplate(new ItemStack(chestplate));
        armorstand.setLeggings(new ItemStack(leggins));
        armorstand.setBoots(new ItemStack(boots));
        armorstand.setInvulnerable(false);
        armorstand.setBasePlate(false);
        armorstand.setItemInHand(new ItemStack(materialinhand));
        armorstand.setArms(true);
        armorstand.setBodyPose(new EulerAngle(Math.toRadians(bodyxr), Math.toRadians(bodyyr), Math.toRadians(bodyzr)));
        armorstand.setRightArmPose(new EulerAngle(Math.toRadians(rightarmxr), Math.toRadians(rightarmyr), Math.toRadians(rightarmzr)));
        armorstand.setLeftArmPose(new EulerAngle(Math.toRadians(leftarmxr), Math.toRadians(leftarmyr), Math.toRadians(leftarmzr)));
        armorstand.setRightLegPose(new EulerAngle(Math.toRadians(rightlegxr), Math.toRadians(rightlegyr), Math.toRadians(rightlegzr)));
        armorstand.setLeftLegPose(new EulerAngle(Math.toRadians(leftlegxr), Math.toRadians(leftlegyr), Math.toRadians(leftlegzr)));
        armorstand.setHeadPose(new EulerAngle(Math.toRadians(headxr), Math.toRadians(headyr), Math.toRadians(headzr)));

    }



    public static void armorStand(){
        placeArmorStands(-2.882,57,10.8,-160,-12, 346f, 0f, 0f, 0, 0, 0, 255f, 44f, 10f, 58f, 76f, 22f, 0f, 12f, 14f, 24f, 20f, 342f, Material.AIR, Material.PUMPKIN, Material.LEATHER_CHESTPLATE, Material.LEATHER_LEGGINGS, Material.LEATHER_BOOTS);
        placeArmorStands(3.3,57,10,162,-10, 346f, 0f, 0f, 0, 0, 0, 348f,72f,12f, 241f,310f,352f, 10f,348f,12f, 2f,76f,344f, Material.CARROT_STICK, Material.PUMPKIN, Material.LEATHER_CHESTPLATE, Material.LEATHER_LEGGINGS, Material.LEATHER_BOOTS);
        placeArmorStands(8.184,57,11.4,91,-7, 344f,346f,0f, 0, 0, 0, 6f,73f,22f, 10f,143f,336f,291f,34f,6f, 72f,141f,4f, Material.AIR, Material.PUMPKIN, Material.LEATHER_CHESTPLATE, Material.LEATHER_LEGGINGS, Material.LEATHER_BOOTS);
        placeArmorStands(20,57,47,174,1, 346f,0f,0f, 0, 0, 0,263f,48f,20f, 32f,20f,0f,22f,356f,0f, 305f,356f,0f, Material.AIR, Material.PUMPKIN, Material.LEATHER_CHESTPLATE, Material.LEATHER_LEGGINGS, Material.LEATHER_BOOTS);
        placeArmorStands(-19.4,96,54.4,-89,11, 6f,0f,0f, 0, 0, 0,185f,30f,302f, 251f,314f,356f,0f,12f,4f,0f,70f,356f, Material.AIR, Material.PUMPKIN, Material.LEATHER_CHESTPLATE, Material.LEATHER_LEGGINGS, Material.LEATHER_BOOTS);
        placeArmorStands(17.5,64.0,56.5,140,35, 20f,0f,0f, 0, 0, 0, 6f,73f,22f, 10f,143f,336f,291f,34f,6f, 72f,141f,4f, Material.AIR, Material.PUMPKIN, Material.LEATHER_CHESTPLATE, Material.LEATHER_LEGGINGS, Material.LEATHER_BOOTS);
        placeArmorStands(-7.1,57,42.6,-155,-4, 0f, 16f, 0f, 0, 0, 0, 255f, 44f, 10f, 18f,14f,0f, 14f,354f,0f, 338f,340f,0f, Material.AIR, Material.PUMPKIN, Material.LEATHER_CHESTPLATE, Material.LEATHER_LEGGINGS, Material.LEATHER_BOOTS);

    }
}
