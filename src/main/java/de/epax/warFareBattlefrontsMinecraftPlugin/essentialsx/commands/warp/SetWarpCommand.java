package de.epax.warFareBattlefrontsMinecraftPlugin.essentialsx.commands.warp;

import de.epax.warFareBattlefrontsMinecraftPlugin.essentialsx.Config.Strings;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.configuration.file.FileConfiguration;

public class SetWarpCommand implements CommandExecutor {
    private final FileConfiguration config;

    public SetWarpCommand(FileConfiguration config) {
        this.config = config;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage(Strings.getMessage("prefix")+Strings.getMessage("only_player_warp"));
            return false;
        }

        Player player = (Player) sender;

        if (args.length != 1) {
            player.sendMessage(Strings.getMessage("prefix")+Strings.getMessage("warp_name"));
            return false;
        }

        String warpName = args[0];


        config.set("warps." + warpName + ".name", warpName);
        config.set("warps." + warpName + ".world", player.getWorld().getName());
        config.set("warps." + warpName + ".x", player.getLocation().getX());
        config.set("warps." + warpName + ".y", player.getLocation().getY());
        config.set("warps." + warpName + ".z", player.getLocation().getZ());
        config.set("warps." + warpName + ".yaw", player.getLocation().getYaw());
        config.set("warps." + warpName + ".pitch", player.getLocation().getPitch());

        Bukkit.getPluginManager().getPlugin("WarFare-Battlefronts-MinecraftPlugin").saveConfig();

        player.sendMessage( Strings.getMessage("prefix")+Strings.getMessage("setted_warp")+ warpName );
        return true;
    }
    public Location getWarpname(String warpName) {
        if (!config.contains("warps." + warpName)) {
            return null;
        }

        String worldName = config.getString("warps." + warpName + ".world");
        double x = config.getDouble("warps." + warpName + ".x");
        double y = config.getDouble("warps." + warpName + ".y");
        double z = config.getDouble("warps." + warpName + ".z");
        float yaw = (float) config.getDouble("warps." + warpName + ".yaw");
        float pitch = (float) config.getDouble("warps." + warpName + ".pitch");


        return new Location(Bukkit.getWorld(worldName), x, y, z, yaw, pitch);
    }
}
