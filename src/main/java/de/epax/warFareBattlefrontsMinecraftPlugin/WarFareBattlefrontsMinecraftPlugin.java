package de.epax.warFareBattlefrontsMinecraftPlugin;

import de.epax.warFareBattlefrontsMinecraftPlugin.essentialsx.commands.Fly;
import de.epax.warFareBattlefrontsMinecraftPlugin.essentialsx.commands.Gamemode;
import de.epax.warFareBattlefrontsMinecraftPlugin.essentialsx.commands.Vanish;
import de.epax.warFareBattlefrontsMinecraftPlugin.essentialsx.commands.unban;
import de.epax.warFareBattlefrontsMinecraftPlugin.essentialsx.tabcompleter.GamemodeTabCompleter;
import de.epax.warFareBattlefrontsMinecraftPlugin.essentialsx.tabcompleter.UnbanTabCompleter;
import org.bukkit.plugin.java.JavaPlugin;

public final class WarFareBattlefrontsMinecraftPlugin extends JavaPlugin {

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
        //TabCompleter from EssentialsX
        getCommand("gm").setTabCompleter(new GamemodeTabCompleter());
        getCommand("gamemode").setTabCompleter(new GamemodeTabCompleter());
        getCommand("unban").setTabCompleter(new UnbanTabCompleter());


    }

    @Override
    public void onDisable() {

    }
}
