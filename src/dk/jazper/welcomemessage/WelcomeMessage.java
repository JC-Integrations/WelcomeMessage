package dk.jazper.welcomemessage;

import dk.jazper.welcomemessage.events.WelcomeMessageEvents;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

public class WelcomeMessage extends JavaPlugin {

    private static WelcomeMessage plugin;

    @Override
    public void onEnable() {

        // Create config if it doesn't exist
        this.saveDefaultConfig();

        plugin = this;

        // Register all events
        Bukkit.getServer().getPluginManager().registerEvents(new WelcomeMessageEvents(), this);

        Bukkit.getServer().getConsoleSender().sendMessage(ChatColor.GREEN + "[WelcomeMessage] is enabled!");
    }

    @Override
    public void onDisable() {
        Bukkit.getServer().getConsoleSender().sendMessage(ChatColor.RED + "[WelcomeMessage] is disabled!");
    }

    public static Plugin getPlugin() {
        return plugin;
    }
}
