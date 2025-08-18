package ru.dercec.plugin.deantirelogec.config;

import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.file.FileConfiguration;
import ru.dercec.plugin.deantirelogec.deAntiRelogEC;
import ru.dercec.plugin.deantirelogec.util.HexUtil;

public class Config {
    private final deAntiRelogEC plugin;

    public Config(deAntiRelogEC var1) {
        this.plugin = var1;
        plugin.saveDefaultConfig();
        load();
    }

    private String tryToPlaceMessage, tryToInteractMessage, noPermsMessage, reloadMessage;

    //Лучше использовать геттеры, можно найти информацию в интернете
    //Как поймёшь что это можно использовать lombok для автоматической генерации
    public String getTryToPlaceMessage() {
        return tryToPlaceMessage;
    }

    public String getTryToInteractMessage() {
        return tryToInteractMessage;
    }

    public String getNoPermsMessage() {
        return noPermsMessage;
    }

    public String getReloadMessage() {
        return reloadMessage;
    }

    public void reload() {
        plugin.reloadConfig();
        load();
    }

    public void load() {
        FileConfiguration config = plugin.getConfig();
        // 1 раз получаем секцию, можно посмотреть как всё устроенно под капотом
        ConfigurationSection section = config.getConfigurationSection("messages");
        tryToPlaceMessage = HexUtil.colorize(section.getString("on-place"));
        tryToInteractMessage = HexUtil.colorize(section.getString("on-interact"));
        noPermsMessage = HexUtil.colorize(section.getString("no-perms"));
        reloadMessage = HexUtil.colorize(section.getString("reload"));
    }
}
