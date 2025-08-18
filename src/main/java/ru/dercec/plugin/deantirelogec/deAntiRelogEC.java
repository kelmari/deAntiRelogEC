package ru.dercec.plugin.deantirelogec;

import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import ru.dercec.plugin.deantirelogec.command.ReloadCommand;
import ru.dercec.plugin.deantirelogec.config.Config;
import ru.dercec.plugin.deantirelogec.listener.Listeners;

public final class deAntiRelogEC extends JavaPlugin {

    @Override
    public void onEnable() {
        PluginManager pm = getServer().getPluginManager();
        // Эта проверка не имеет смысла, если плагин находится в depend и отсутствует
        // на сервере - исключение будет выброшено раньше, чем в onEnable
        //if (!pm.isPluginEnabled("powerantirelog")) {
        //    getLogger().info("Плагин был выключен из-за того, что отсутствует плагин PowerAntiRelog");
        //    pm.disablePlugin(this);
        //    return;
        //}
        Config config = new Config(this);
        pm.registerEvents(new Listeners(config), this);
        getCommand("deantirelogec").setExecutor(new ReloadCommand(config));

    }
}
