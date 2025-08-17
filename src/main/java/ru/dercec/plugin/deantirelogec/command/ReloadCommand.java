package ru.dercec.plugin.deantirelogec.command;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.NotNull;
import ru.dercec.plugin.deantirelogec.config.Config;

public class ReloadCommand implements CommandExecutor {
    private final Config config;

    public ReloadCommand(Config config) {
        this.config = config;
    }

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String s, @NotNull String[] args) {
        if (sender.hasPermission("deantirelogec.reload")) {
            config.reload();
            sender.sendMessage(config.getReloadMessage());
            return true;
        }
        sender.sendMessage(config.getNoPermsMessage());
        return true;
    }
}
