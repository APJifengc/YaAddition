package io.github.apjifengc.yaaddition.core;

import io.github.apjifengc.yaaddition.YaAddition;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;

public class BlockStorage {
    private static String serializeLocation(Location l) {
        return l.getWorld().getName() + ';' + l.getBlockX() + ';' + l.getBlockY() + ';' + l.getBlockZ();
    }

    private static String serializeChunk(World world, int x, int z) {
        return world.getName() + ";Chunk;" + x + ';' + z;
    }

    public static File getFile(Location location) {
        return new File(YaAddition.getInstance().getDataFolder() + "/data/" + serializeLocation(location) + ".yml");
    }

    public static YamlConfiguration getOrCreate(Location location) {
        try {
            File file = getFile(location);
            if (file.exists()) {
                YamlConfiguration yaml = new YamlConfiguration();
                yaml.load(file);
                return yaml;
            } else {
                if (!file.getParentFile().exists()) file.getParentFile().mkdirs();
                file.createNewFile();
                YamlConfiguration yaml = new YamlConfiguration();
                yaml.load(file);
                return yaml;
            }
        } catch (IOException | InvalidConfigurationException e) {
            e.printStackTrace();
            return new YamlConfiguration();
        }
    }

    public static void set(Location location, String path, Object value) {
        YamlConfiguration yaml = getOrCreate(location);
        yaml.set(path, value);
        try {
            yaml.save(getFile(location));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Object get(Location location, String path) {
        return getOrCreate(location).get(path);
    }

    public static boolean contains(Location location, String path) {
        return getOrCreate(location).contains(path);
    }

    public static void clear(Location location) {
        File file = getFile(location);
        if (file.exists()) {
            file.delete();
        }
    }
}
