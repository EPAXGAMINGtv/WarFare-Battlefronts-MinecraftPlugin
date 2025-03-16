package de.epax.warFareBattlefrontsMinecraftPlugin.essentialsx.commands;

import de.epax.warFareBattlefrontsMinecraftPlugin.values.Strings;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Fly implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if (commandSender instanceof Player p){
            if (p.isOp()){
                if (p.isFlying()==false){
                    p.setAllowFlight(true);
                    p.setFlying(true);
                    p.sendMessage(Strings.prefix+ Strings.activatedFly);
                }else {
                    p.setFlying(false);
                    p.setAllowFlight(false);
                    p.sendMessage(Strings.prefix+ Strings.deactivatedFly);
                }
            }else {
                p.sendMessage(Strings.prefix+ Strings.notAllowed);
            }
        }else {
            commandSender.sendMessage(Strings.prefix+ Strings.nonPlayer);
        }
        return false;
    }
}
