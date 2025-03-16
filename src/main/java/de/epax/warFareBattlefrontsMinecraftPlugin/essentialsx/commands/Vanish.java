package de.epax.warFareBattlefrontsMinecraftPlugin.essentialsx.commands;

import de.epax.warFareBattlefrontsMinecraftPlugin.values.Strings;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;


public class Vanish implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {
        if(sender instanceof Player p){
            if (p.isOp()){
               if (p.isInvisible()){
                   p.setInvisible(false);
                   p.sendMessage(Strings.prefix+Strings.disabledVanish);
               }else {
                   p.setInvisible(true);
                   p.sendMessage(Strings.prefix+Strings.enabeldVanish);
               }
            }else {
                p.sendMessage(Strings.prefix+Strings.notAllowed);
            }
        }else {
            sender.sendMessage(Strings.prefix+Strings.nonPlayer);
        }
        return false;
    }
}
