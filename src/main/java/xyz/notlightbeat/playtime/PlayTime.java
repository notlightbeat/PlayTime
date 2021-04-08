package xyz.notlightbeat.playtime;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;
import xyz.notlightbeat.playtime.command.UserInfoCommand;

public final class PlayTime extends JavaPlugin {

    @Override
    public void onEnable() {
        if (Bukkit.getPluginManager().getPlugin("PlaceholderAPI") != null) {
            getCommand("userinfo").setExecutor(new UserInfoCommand());
        } else {
            getLogger().warning("Could not find PlaceholderAPI! This plugin is required");
            Bukkit.getPluginManager().disablePlugin(this);
        }
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    public static PlayTime getPlugin() {
        return getPlugin(PlayTime.class);
    }

}
