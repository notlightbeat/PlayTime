package xyz.notlightbeat.playtime.command;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.OfflinePlayer;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import xyz.notlightbeat.playtime.PlayTime;
import xyz.notlightbeat.playtime.util.PlayerUtils;

public class UserInfoCommand implements CommandExecutor {

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        try {
            if (!sender.isOp()) {
                throw new ArrayIndexOutOfBoundsException();
            }
            Player player = Bukkit.getPlayer(args[0]);
            if (player == null) {
                OfflinePlayer offlinePlayer = Bukkit.getOfflinePlayer(args[0]);
                if (offlinePlayer != null) {
                    sender.sendMessage(ChatColor.translateAlternateColorCodes('&', PlayerUtils.getOfflinePlaytime(offlinePlayer)));
                    return true;
                }
                sender.sendMessage(ChatColor.translateAlternateColorCodes('&', PlayTime.getPlugin().getConfig().getString("messages.player-not-found")));
                return false;
            } else {
                String playTimeMsg = PlayerUtils.getPlaytime(player);
                sender.sendMessage(ChatColor.translateAlternateColorCodes('&', playTimeMsg));
                return true;
            }
        } catch (ArrayIndexOutOfBoundsException ex) {
            if (sender instanceof Player) {
                Player player = (Player)sender;
                player.sendMessage(ChatColor.translateAlternateColorCodes('&', PlayerUtils.getPlaytime(player)));
                return true;
            } else {
                sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&c/userinfo {player}"));
            }
        }
        return false;
    }

}
