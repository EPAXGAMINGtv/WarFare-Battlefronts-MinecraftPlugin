package de.epax.warFareBattlefrontsMinecraftPlugin;

import de.epax.warFareBattlefrontsMinecraftPlugin.essentialsx.Config.Strings;
import de.epax.warFareBattlefrontsMinecraftPlugin.essentialsx.commands.*;
import de.epax.warFareBattlefrontsMinecraftPlugin.essentialsx.commands.homes.Home;
import de.epax.warFareBattlefrontsMinecraftPlugin.essentialsx.commands.homes.SetHome;

import de.epax.warFareBattlefrontsMinecraftPlugin.essentialsx.commands.warp.SetWarp;
import de.epax.warFareBattlefrontsMinecraftPlugin.essentialsx.commands.warp.Warp;
import de.epax.warFareBattlefrontsMinecraftPlugin.essentialsx.tabcompleter.GamemodeTabCompleter;
import de.epax.warFareBattlefrontsMinecraftPlugin.essentialsx.tabcompleter.HomeTabCompleter;
import de.epax.warFareBattlefrontsMinecraftPlugin.essentialsx.tabcompleter.UnbanTabCompleter;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.*;

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
        getCommand("sethome").setExecutor(new SetHome());
        getCommand("home").setExecutor(new Home());

        getCommand("setwarp").setExecutor(new SetWarp());
        getCommand("warp").setExecutor(new Warp());
        //TabCompleter from EssentialsX
        getCommand("gm").setTabCompleter(new GamemodeTabCompleter());
        getCommand("gamemode").setTabCompleter(new GamemodeTabCompleter());
        getCommand("unban").setTabCompleter(new UnbanTabCompleter());
        getCommand("home").setTabCompleter(new HomeTabCompleter());


        //config
        saveDefaultConfig();
        Strings.load(this);


    }



}

