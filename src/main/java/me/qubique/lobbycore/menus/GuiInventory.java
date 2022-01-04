package me.qubique.lobbycore.menus;

import org.bukkit.*;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryDragEvent;
import org.bukkit.event.inventory.InventoryInteractEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;

import java.util.ArrayList;
import java.util.List;


public class GuiInventory implements Listener {

    ItemStack playerskull;

    @EventHandler
    public void join(PlayerJoinEvent event){

        Player player = event.getPlayer();


    }


    @EventHandler
    public void onJoin(PlayerJoinEvent e){
        Player p = e.getPlayer();
//      початок
        playerskull = new ItemStack(Material.SKULL_ITEM,1, (short) SkullType.PLAYER.ordinal());

        SkullMeta meta = (SkullMeta) playerskull.getItemMeta();

        meta.setOwner(p.getName());
        meta.setDisplayName("§6Профиль §7" + p.getDisplayName());
        playerskull.setItemMeta(meta);

        p.getInventory().addItem(playerskull);
        p.sendMessage(ChatColor.DARK_AQUA + "Please refer to your player heard for Player Info.");
//      Кінець



        Inventory inv = p.getInventory();
        inv.clear();
        addItemToInv(inv, Material.COMPASS, "§6Режим", 0, "");
//        addItemToInv(inv, playerskull.getType().getData(), "§6Профиль §7" + p.getDisplayName(), 1,"");
        inv.setItem(1,playerskull);

        addItemToInv(inv, Material.GOLD_BLOCK, "§6Привилегии", 2,"");
        addItemToInv(inv, Material.LIME_SHULKER_BOX, "§6Скрыть игроков", 8,"");
    }

    private void addItemToInv(Inventory inv, Material material, String name, Integer slot, String lore){
        ItemStack mode = new ItemStack(material, 1);
        ItemMeta im = mode.getItemMeta();
        List<String> loreList = new ArrayList<>();
        String[] lores = lore.split("\n");
        for (String addlore : lores) {
            loreList.add(addlore);
        }
        im.setLore(loreList);
        im.setDisplayName(name);
        mode.setItemMeta(im);
        inv.setItem(slot, mode);
    }

    @EventHandler
    public void openGui(PlayerInteractEvent e) {
        Player p = e.getPlayer();
        Inventory inv = p.getInventory();
        if(e.getAction().equals(Action.RIGHT_CLICK_AIR) ||  e.getAction().equals(Action.RIGHT_CLICK_BLOCK)) {
            if( p.getInventory().getItemInMainHand().getItemMeta().getDisplayName().equalsIgnoreCase("§6Режим")) {
                Inventory gui = Bukkit.createInventory(p, 9*3, "§8Режим");
                addItemToInv(gui, Material.GOLD_PICKAXE, "§bPrison", 11,"§cОписание режима:" +
                        "\n§c→ §7На режиме §nPrison§7 " +
                        "\n§7предстоит копать, зарабатывая деньги. " +
                        "\n§7Прокачивать инструменты, уровень, " +
                        "\n§7убивать боссов и открывать для себя новые шахты. " +
                        "\n§7В течении игры вы будете получать бесплатные кейсы, " +
                        "\n§7из которых можно получить много интересных предметов. " +
                        "\n " +
                        "\n§aИграет §e2000 из 2000 §aигроков." +
                        "\n " +
                        "\n§a→ Нажмите чтобы подключиться");
                addItemToInv(gui, Material.IRON_SWORD, "§bGTM", 13,"§cОписание режима:" +
                        "\n§c→ §7Приятный сервер с §nGTA-подобным геймплеем. " +
                        "\n§7Достаточно высокий онлайн, много видов " +
                        "\n§7оружия, брони, профессий. " +
                        "\n§7Для игры английский знать не обязательно – " +
                        "\n§7стрелять друг в друга из пушек можно без слов :)" +
                        "\n " +
                        "\n§aИграет §e2000 из 2000 §aигроков." +
                        "\n " +
                        "\n§a→ Нажмите чтобы подключиться");
                addItemToInv(gui, Material.RED_SANDSTONE, "§bJediCraft", 15,"§cОписание режима:" +
                        "\n§c→ §7Почувствуйте себя настоящим §nДжедаем§7 " +
                        "\n§7выбрав соответствующую фракцию" +
                        "\n§7или убивайте всё что движется " +
                        "\n§7выбрав фракцию Ситхи!" +
                        "\n§6Решать только тебе!" +
                        "\n " +
                        "\n§aИграет §e2000 из 2000 §aигроков." +
                        "\n " +
                        "\n§a→ Нажмите чтобы подключиться");
                p.openInventory(gui);
            } else if (p.getInventory().getItemInMainHand().getItemMeta().getDisplayName().equalsIgnoreCase("§6Профиль §7" + p.getDisplayName())) {
                Inventory gui1 = Bukkit.createInventory(p, 9*3, "§8Мой профиль");
                addItemToInv(gui1, Material.STAINED_GLASS_PANE, "", 0,"");
                addItemToInv(gui1, Material.STAINED_GLASS_PANE, "", 8,"");
                addItemToInv(gui1, Material.STAINED_GLASS_PANE, "", 9,"");
                addItemToInv(gui1, Material.STAINED_GLASS_PANE, "", 17,"");
                addItemToInv(gui1, Material.STAINED_GLASS_PANE, "", 18,"");
                addItemToInv(gui1, Material.STAINED_GLASS_PANE, "", 26,"");
                addItemToInv(gui1, Material.ENCHANTED_BOOK, "§aУровень", 4,"§7Играя в наши миниигры, " +
                        "\n§7вы будете получать опыт, необходимый для " +
                        "\n§7повышения уровня, за который полагаются " +
                        "\n§7различные приятные бонусы и награды" +
                        "\n " +
                        "\n§b→ Нажми для перехода к списку наград");
                addItemToInv(gui1, Material.BOOK, "§aДостижения", 12,"§7Нажми чтобы увидеть свой " +
                        "\n§7прогресс выполнения достижений");


                SkullMeta meta = (SkullMeta) playerskull.getItemMeta();
                meta.setOwner(p.getName());
                meta.setDisplayName("§aИнформация о профиле");
                ArrayList<String> lore=new ArrayList<>();
                lore.add("§7Ник: §b"+ p.getDisplayName());
                lore.add("§7Уровень: §btest");
                lore.add("§7Опыт: §btest");
                meta.setLore(lore);
                playerskull.setItemMeta(meta);


                gui1.setItem(13, playerskull);
//                addItemToInv(gui1, playerskull.getType(), "§aИнформация о профиле", 13,"§7Ник: §b" + p.getDisplayName() +
//                        "\n§7Уровень: §btest" +
//                        "\n§7Опыт: §btest");
                addItemToInv(gui1, Material.BREWING_STAND_ITEM, "§aМодификатор серебра", 14,"§7Увеличивает количество серебра, " +
                        "\n§7которое вы получаете, играя в наши минирежимы" +
                        "\n" +
                        "\n§7Модификатор: §6х0.00 " +
                        "\n" +
                        "\n§6х0.00 §7от уровня " +
                        "\n§6х0.00 §7от гильдии " +
                        "\n§6х0.00 §7от активного бустера");
                addItemToInv(gui1, Material.ENDER_CHEST, "§aКосметика", 22,"§7Находите кучу косметических предметов, " +
                        "\n§7которые сделают вас по-настоящему " +
                        "\n§7неотразимым на серверах нашего проекта. " +
                        "\n " +
                        "\n§7Новые предметы можно найти, " +
                        "\n§7открывая §bДревние Сундуки§7, " +
                        "\n§7которые, в свою очередь, можно получить, " +
                        "\n§7играя на серверах нашего " +
                        "\n§7проекта или же купив в магазине на сайте. " +
                        "\n " +
                        "\n§bНажми для перехода к своей коллекции.");

                p.openInventory(gui1);
            } else if (p.getInventory().getItemInMainHand().getItemMeta().getDisplayName().equalsIgnoreCase("§6Привилегии")) {
                Inventory gui2 = Bukkit.createInventory(p, 9*5, "§8Привилегии");
                addItemToInv(gui2, Material.DIRT, "§aБомжарик", 20,"§7Получаете доступ до:  " +
                        "\n§a→§7 Отпугивания людей вокруг себя(можно откл в настройках наверное)"+
                        "\n§a→§7 Получения 1 вещи раз в день"+
                        "\n§a→§7 Доступ до двойного прыжка"+
                        "\n "+
                        "\n§7 Стоимость: §aБесплатная привилегия!");

                addItemToInv(gui2, Material.IRON_BLOCK, "§bВип", 22,"§7Получаете доступ до:  " +
                        "\n§b→§7 Получаете в 0,0001 болольше уровня"+
                        "\n§b→§7 Получения 3 вещи раз в день"+
                        "\n§b→§7 Доступ до парочку команд(смотрите в...)"+
                        "\n "+
                        "\n§7Стоимость: §b 50руб");

                addItemToInv(gui2, Material.GOLD_BLOCK, "§6Админ", 24,"§7Получаете доступ до:  " +
                        "\n§6→§7 Получения в 5 болольше уровня"+
                        "\n§6→§7 Получения 6 вещи раз в день"+
                        "\n§6→§7 Доступ до админского чату"+
                        "\n "+
                        "\n§7Стоимость: §6 99руб");
                        p.openInventory(gui2);
            } else if (p.getInventory().getItemInMainHand().getItemMeta().getDisplayName().equalsIgnoreCase("§6Скрыть игроков")) {

                    for(Player ps : Bukkit.getServer().getOnlinePlayers()) {
                        p.hidePlayer(ps);
                    }
                    addItemToInv(inv, Material.GRAY_SHULKER_BOX, "§6Показать игроков", 8,"");
                    p.sendMessage("§6Игроки скрыты");
            } else if (p.getInventory().getItemInMainHand().getItemMeta().getDisplayName().equalsIgnoreCase("§6Показать игроков")){
                    for(Player ps : Bukkit.getServer().getOnlinePlayers()) {
                        p.showPlayer(ps);
                    }
                    addItemToInv(inv, Material.LIME_SHULKER_BOX, "§6Скрыть игроков", 8,"");
                    p.sendMessage("§6Игроки снова видны");
            }

        }
    }

    @EventHandler
    public void onInventoryClick(InventoryClickEvent e) {
        Player p = (Player) e.getWhoClicked();
        if(p.getGameMode() != GameMode.CREATIVE) {
            e.setCancelled(true);
        }
    }

}
