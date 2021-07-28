package dk.jazper.welcomemessage.events;

import dk.jazper.welcomemessage.WelcomeMessage;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class WelcomeMessageEvents implements Listener {

    @EventHandler
    public static void onPlayerJoin(PlayerJoinEvent event) {
        try {
            String welcomeMessage;
            Player player = event.getPlayer();
            if (player.hasPlayedBefore()) {
                welcomeMessage = WelcomeMessage.getPlugin().getConfig().getString("welcome-message");
            } else {
                welcomeMessage = WelcomeMessage.getPlugin().getConfig().getString("first-join-message");
                if (welcomeMessage == null) {
                    welcomeMessage = WelcomeMessage.getPlugin().getConfig().getString("welcome-message");
                }
            }

            if (welcomeMessage == null) {
                return;
            }

            welcomeMessage = welcomeMessage.replaceAll("&", "§");
            welcomeMessage = welcomeMessage.replaceAll("\\[displayName\\]", player.getDisplayName());
            event.setJoinMessage(welcomeMessage);
        }
        catch (Exception e) {
            return;
        }
    }

    @EventHandler
    public static void onPlayerQuit(PlayerQuitEvent event) {
        try {
            String leaveMessage = WelcomeMessage.getPlugin().getConfig().getString("leave-message");

            Player player = event.getPlayer();

            leaveMessage = leaveMessage.replaceAll("&", "§");
            leaveMessage = leaveMessage.replaceAll("\\[displayName\\]", player.getDisplayName());
            event.setQuitMessage(leaveMessage);
        }
        catch (Exception e) {
            return;
        }
    }

}
