package de.epax.warFareBattlefrontsMinecraftPlugin.essentialsx.commands;

import de.epax.warFareBattlefrontsMinecraftPlugin.values.Strings;
import org.bukkit.BanList;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class unban implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] args) {
        if (commandSender.isOp()){
            String targetName = args[0];
            if (args.length != 1) {
                commandSender.sendMessage(Strings.prefix+Strings.unbanUsage);
                return true;
            }

            if (!Bukkit.getBanList(BanList.Type.NAME).isBanned(targetName)) {
                commandSender.sendMessage(Strings.prefix+Strings.nonBannedPlayer);
            }else {
                Bukkit.getBanList(BanList.Type.NAME).pardon(targetName);
                commandSender.sendMessage(Strings.prefix+Strings.unban+targetName +Strings.unban2);
            }
        }else {
            commandSender.sendMessage(Strings.notAllowed);
        }
        return false;
    }
}
