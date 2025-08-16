package ru.dercec.plugin.deantirelogec.command;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.NotNull;
import ru.dercec.plugin.deantirelogec.deAntiRelogEC;

public class ReloadCommand implements CommandExecutor {

    private deAntiRelogEC plugin;

    public ReloadCommand(deAntiRelogEC var1){
        this.plugin = var1;
    }

    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {
        if(commandSender.hasPermission("deantirelogec.reload")){
            if(strings.length >= 1) {
                if(strings[0].equalsIgnoreCase("reload")){
                plugin.config.init();
                commandSender.sendMessage("Конфиг успешно перезагружен!");
                return true;
                }
            }
            plugin.config.init();
            commandSender.sendMessage("Конфиг успешно перезагружен!");
            return true;
        }
        return false;
    }
}
