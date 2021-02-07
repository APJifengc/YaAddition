package io.github.apjifengc.yaaddition;

import com.rabbitown.yalib.module.command.SimpleCommandRemote;
import io.github.apjifengc.yaaddition.addition.AdditionMaterial;
import io.github.apjifengc.yaaddition.command.CommandDebug;
import io.github.apjifengc.yaaddition.core.SpecialNoteBlock;
import io.github.apjifengc.yaaddition.core.SpecialTripWire;
import io.github.apjifengc.yaaddition.core.state.TripWireState;
import io.github.apjifengc.yaaddition.exception.MaterialAlreadyRegisteredException;
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
        new SpecialNoteBlock(this);
        new SpecialTripWire(this);
        new CommandDebug().register();
        AdditionMaterial test = new AdditionMaterial(AdditionMaterial.AdditionMaterialType.ITEM, "TEST_ITEM", null, null, null);
        try {
            test.register();
        } catch (MaterialAlreadyRegisteredException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
