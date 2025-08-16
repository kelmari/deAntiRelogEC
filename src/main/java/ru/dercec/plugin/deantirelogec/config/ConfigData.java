package ru.dercec.plugin.deantirelogec.config;

import ru.dercec.plugin.deantirelogec.deAntiRelogEC;
import ru.dercec.plugin.deantirelogec.util.HexUtil;

public class ConfigData {

    private deAntiRelogEC plugin;

    public ConfigData(deAntiRelogEC var1){
        this.plugin = var1;
    }

    public String TRY_TO_PLACE;
    public String TRY_TO_INTERACT;

    public void init(){
        plugin.reloadConfig();
        TRY_TO_PLACE = HexUtil.colorize(plugin.getConfig().getString("messages.on-place"));
        TRY_TO_INTERACT = HexUtil.colorize(plugin.getConfig().getString("messages.on-interact"));
    }

}
