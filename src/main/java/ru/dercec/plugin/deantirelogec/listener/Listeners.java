package ru.dercec.plugin.deantirelogec.listener;

import me.katze.powerantirelog.manager.PvPManager;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import ru.dercec.plugin.deantirelogec.deAntiRelogEC;

public class Listeners implements Listener {

    private deAntiRelogEC plugin;
    private PvPManager manager;

    public Listeners(deAntiRelogEC var1, PvPManager var2){
        this.plugin = var1;
        this.manager = var2;
    }

    @EventHandler(priority = EventPriority.LOWEST)
    public void onBlockPlace(BlockPlaceEvent event){
        event.getPlayer().sendMessage(event.getBlock().getType().toString());
        if((event.getBlock().getType() == Material.ENDER_CHEST) && (manager.isPvP(event.getPlayer()) && manager != null)) {
            if (!event.getPlayer().hasPermission("deantirelogec.bypass")) {
                event.getPlayer().sendMessage(plugin.config.TRY_TO_PLACE);
                event.setCancelled(true);
            }
        }
    }

    @EventHandler(priority = EventPriority.LOWEST)
    public void onInteract(PlayerInteractEvent event){
        if(event.getClickedBlock() != null) {
            if ((event.getClickedBlock().getType() == Material.ENDER_CHEST) && (manager.isPvP(event.getPlayer()) && manager != null)) {
                if (!event.getPlayer().hasPermission("deantirelogec.bypass")) {
                    event.getPlayer().sendMessage(plugin.config.TRY_TO_INTERACT);
                    event.setCancelled(true);
                }
            }
        }
    }

}
