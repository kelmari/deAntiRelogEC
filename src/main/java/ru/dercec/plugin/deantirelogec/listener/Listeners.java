package ru.dercec.plugin.deantirelogec.listener;

import me.katze.powerantirelog.manager.PvPManager;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import ru.dercec.plugin.deantirelogec.config.Config;

public class Listeners implements Listener {

    private final Config config;
    //private PvPManager manager;

    public Listeners(Config config) {
        this.config = config;
        //this.manager = var2;
    }

    @EventHandler(priority = EventPriority.LOWEST)
    public void onBlockPlace(BlockPlaceEvent event) {
        //Зачем?
        //event.getPlayer().sendMessage(event.getBlock().getType().toString());

        //Получаем игрока и блок 1 раз, используя локальную переменную
        Player player = event.getPlayer();
        //Вынесем проверку на право до обработки условий
        if (player.hasPermission("deantirelogec.bypass")) return;

        Block block = event.getBlock();

        // Метод PvPManager#isPvP - статичный
        if (block.getType() == Material.ENDER_CHEST && PvPManager.isPvP(player)) {
            player.sendMessage(config.getTryToPlaceMessage());
            event.setCancelled(true);
        }
    }

    @EventHandler(priority = EventPriority.LOWEST)
    public void onInteract(PlayerInteractEvent event) {
        Player player = event.getPlayer();
        if (player.hasPermission("deantirelogec.bypass")) return;

        Block block = event.getClickedBlock();
        if (block == null) return;

        if (block.getType() == Material.ENDER_CHEST && PvPManager.isPvP(player)) {
            player.sendMessage(config.getTryToInteractMessage());
            event.setCancelled(true);
        }
    }

}
