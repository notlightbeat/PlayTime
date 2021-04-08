package xyz.notlightbeat.playtime.util;

import me.clip.placeholderapi.PlaceholderAPI;
import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.Statistic;
import org.bukkit.entity.Player;
import xyz.notlightbeat.playtime.PlayTime;

public class PlayerUtils {

    public static String getPlaytime(Player player) {

        String[] time;

        if (ReflectionUtils.isVersion("v1_12_", "v1_11_", "v1_10_", "v1_9_")) {
            time = getTimeFromSeconds(player.getStatistic(Statistic.valueOf("PLAY_ONE_TICK")) / 20);
        }
        else {
            time = getTimeFromSeconds(player.getStatistic(Statistic.valueOf("PLAY_ONE_MINUTE")) / 20);
        }

        String msg = PlayTime.getPlugin().getConfig().getString("messages.play-time");
        return PlaceholderAPI.setPlaceholders(player, msg.replaceAll("%hours%", time[0]).replaceAll("%minutes%", time[1]).replaceAll("%seconds%", time[2]));

    }

    public static String getOfflinePlaytime(OfflinePlayer player) {

        String msg = PlayTime.getPlugin().getConfig().getString("messages.offline-play-time");
        return PlaceholderAPI.setPlaceholders(player, msg);

    }

    public static String[] getTimeFromSeconds(int seconds) {
        String[] time = new String[3];
        time[0] = String.valueOf(seconds / 3600);
        time[1] = String.valueOf((seconds / 60) % 60);
        time[2] = String.valueOf(seconds % 60);
        return time;
    }

}