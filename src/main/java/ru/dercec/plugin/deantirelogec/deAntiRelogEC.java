package ru.dercec.plugin.deantirelogec;

import me.katze.powerantirelog.manager.PvPManager;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;
import me.katze.powerantirelog.AntiRelog;
import ru.dercec.plugin.deantirelogec.command.ReloadCommand;
import ru.dercec.plugin.deantirelogec.config.ConfigData;
import ru.dercec.plugin.deantirelogec.listener.Listeners;

public final class deAntiRelogEC extends JavaPlugin {

    public PvPManager pvpManager;
    public ConfigData config;

    @Override
    public void onEnable() {
        saveDefaultConfig();
        config = new ConfigData(this);
        if(Bukkit.getServer().getPluginManager().getPlugin("powerantirelog").isEnabled()){
            AntiRelog antiRelog = (AntiRelog) Bukkit.getPluginManager().getPlugin("powerantirelog");
            pvpManager = antiRelog.pvpmanager;
        } else {
            Bukkit.getLogger().info("Плагин был выключен из-за того что отсутствует плагин PowerAntiRelog");
            getServer().getPluginManager().disablePlugin(this);
        }
        config.init();
        Bukkit.getPluginManager().registerEvents(new Listeners(this, pvpManager), this);
        getCommand("deantirelogec").setExecutor(new ReloadCommand(this));

    }

    @Override
    public void onDisable() {

    }
}
