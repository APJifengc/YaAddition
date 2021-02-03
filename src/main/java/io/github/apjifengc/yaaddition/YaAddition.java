package io.github.apjifengc.yaaddition;

import com.rabbitown.yalib.module.command.SimpleCommandRemote;
import io.github.apjifengc.yaaddition.core.SpecialNoteBlock;
import io.github.apjifengc.yaaddition.core.SpecialTripWire;
import io.github.apjifengc.yaaddition.core.state.TripWireState;
import org.bukkit.plugin.java.JavaPlugin;

public final class YaAddition extends JavaPlugin {
    static YaAddition instance;

    public YaAddition() {
        instance = this;
    }

    public static YaAddition getInstance() {
        return instance;
    }

    @Override
    public void onEnable() {

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
