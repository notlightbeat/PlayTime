package xyz.notlightbeat.playtime.util;

import org.bukkit.Bukkit;

public class ReflectionUtils {

    private static String currentVersion;

    public static String getVersion() {
        if (currentVersion == null) currentVersion = Bukkit.getServer().getClass().getPackage().getName().substring(Bukkit.getServer().getClass().getPackage().getName().lastIndexOf(".") + 1);
        return currentVersion;
    }

    public static boolean isVersion(String... prefixes) {
        String version = getVersion();

        for (String prefix: prefixes) {
            if (version.startsWith(prefix)) return true;
        }

        return false;
    }

}
