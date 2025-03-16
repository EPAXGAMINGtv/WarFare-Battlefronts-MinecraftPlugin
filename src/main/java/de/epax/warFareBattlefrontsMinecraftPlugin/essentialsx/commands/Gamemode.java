package de.epax.warFareBattlefrontsMinecraftPlugin.essentialsx.commands;

import de.epax.warFareBattlefrontsMinecraftPlugin.values.Strings;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;



public class Gamemode implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {
        if (sender instanceof Player player) {
            if (player.hasPermission("Gamemode:change")) {
                if (args.length > 0) {
                    if (args[0].equalsIgnoreCase("0")) {
                        player.setGameMode(GameMode.SURVIVAL);
                        player.sendMessage(Strings.prefix+ Strings.survivalMode);
                    } else if (args[0].equalsIgnoreCase("1")) {
                        player.setGameMode(GameMode.CREATIVE);
                        player.sendMessage(Strings.prefix+ Strings.creativeMode);
                    } else if (args[0].equalsIgnoreCase("2")) {
                        player.setGameMode(GameMode.ADVENTURE);
                        player.sendMessage(Strings.prefix+ Strings.adventureMode);
                    } else if (args[0].equalsIgnoreCase("3")) {
                        player.setGameMode(GameMode.SPECTATOR);
                        player.sendMessage(Strings.prefix+ Strings.spectatorMode);
                    } if (args[0].equalsIgnoreCase("survival")) {
                        player.setGameMode(GameMode.SURVIVAL);
                        player.sendMessage(Strings.prefix+Strings.survivalMode);
                    } else if (args[0].equalsIgnoreCase("creative")) {
                        player.setGameMode(GameMode.CREATIVE);
                        player.sendMessage(Strings.prefix+Strings.creativeMode);
                    } else if (args[0].equalsIgnoreCase("adventure")) {
                        player.setGameMode(GameMode.ADVENTURE);
                        player.sendMessage(Strings.prefix+Strings.adventureMode);
                    } else if (args[0].equalsIgnoreCase("spectator")) {
                        player.setGameMode(GameMode.SPECTATOR);
                        player.sendMessage(Strings.prefix+Strings.spectatorMode);
                    }
                } else {
                    player.sendMessage(Strings.prefix+ Strings.notAllowed);
                }
            } else {
                sender.sendMessage(Strings.prefix+ Strings.nonPlayer);
            }

        }
        return false;
    }
}
