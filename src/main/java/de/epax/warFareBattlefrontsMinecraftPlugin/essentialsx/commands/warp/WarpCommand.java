package de.epax.warFareBattlefrontsMinecraftPlugin.essentialsx.commands.warp;

import de.epax.warFareBattlefrontsMinecraftPlugin.essentialsx.Config.Strings;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.configuration.file.FileConfiguration;

public class WarpCommand implements CommandExecutor {
    private final FileConfiguration config;

    public WarpCommand(FileConfiguration config) {
        this.config = config;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage(Strings.getMessage("prefix") + Strings.getMessage("non_player"));
            return false;
        }

        Player player = (Player) sender;

        if (args.length != 1) {
            player.sendMessage(Strings.getMessage("prefix") + Strings.getMessage("warp_usage"));
            return false;
        }

        String warpName = args[0];
        if (!config.contains("warps." + warpName)) {
            player.sendMessage(Strings.getMessage("prefix") + Strings.getMessage("non_existent_warp"));
            return false;
        }

        World world = Bukkit.getWorld(config.getString("warps." + warpName + ".world"));
        double x = config.getDouble("warps." + warpName + ".x");
        double y = config.getDouble("warps." + warpName + ".y");
        double z = config.getDouble("warps." + warpName + ".z");
        float yaw = (float) config.getDouble("warps." + warpName + ".yaw");
        float pitch = (float) config.getDouble("warps." + warpName + ".pitch");

        if (world != null) {
            Location warpLocation = new Location(world, x, y, z, yaw, pitch);
            player.teleport(warpLocation);
            player.sendMessage(Strings.getMessage("prefix") + Strings.getMessage("succeful_warp_teleport") + warpName);
        } else {
            player.sendMessage(Strings.getMessage("prefix") + Strings.getMessage("world_not_found"));
        }
        return true;
    }
}
