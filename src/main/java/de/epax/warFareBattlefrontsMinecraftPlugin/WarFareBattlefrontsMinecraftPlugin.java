package de.epax.warFareBattlefrontsMinecraftPlugin;

import de.epax.warFareBattlefrontsMinecraftPlugin.essentialsx.Config.Strings;
import de.epax.warFareBattlefrontsMinecraftPlugin.essentialsx.commands.*;
import de.epax.warFareBattlefrontsMinecraftPlugin.essentialsx.commands.warp.SetWarpCommand;
import de.epax.warFareBattlefrontsMinecraftPlugin.essentialsx.commands.warp.WarpCommand;
import de.epax.warFareBattlefrontsMinecraftPlugin.essentialsx.tabcompleter.GamemodeTabCompleter;
import de.epax.warFareBattlefrontsMinecraftPlugin.essentialsx.tabcompleter.UnbanTabCompleter;
import org.bukkit.configuration.Configuration;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.io.ObjectInputFilter;
import java.net.spi.InetAddressResolverProvider;

public final class WarFareBattlefrontsMinecraftPlugin extends JavaPlugin {
    private FileConfiguration customConfig = null;
    private File customConfigFile = null;

    @Override
    public void onEnable() {
        getServer().broadcastMessage("WarFare-Battlefronts-MinecraftPlugin Initiliezt");
        //Commands from EssentialsX
        getCommand("gm").setExecutor(new Gamemode());
        getCommand("gamemode").setExecutor(new Gamemode());
        getCommand("fly").setExecutor(new Fly());
        getCommand("unban").setExecutor(new unban());
        getCommand("v").setExecutor(new Vanish());
        getCommand("vanish").setExecutor(new Vanish());
        getCommand("ec").setExecutor(new EnderChest());
        getCommand("enderchest").setExecutor(new EnderChest());
        getCommand("setwarp").setExecutor(new SetWarpCommand(this.getConfig()));
        getCommand("warp").setExecutor(new WarpCommand(this.getConfig()));
        //TabCompleter from EssentialsX
        getCommand("gm").setTabCompleter(new GamemodeTabCompleter());
        getCommand("gamemode").setTabCompleter(new GamemodeTabCompleter());
        getCommand("unban").setTabCompleter(new UnbanTabCompleter());

        //config
        saveDefaultConfig();
        Strings.load(this);


    }


}
