package io.github.apjifengc.yaaddition;

import io.github.apjifengc.yaaddition.addition.AdditionMaterial;
import io.github.apjifengc.yaaddition.command.CommandDebug;
import io.github.apjifengc.yaaddition.core.SpecialNoteBlock;
import io.github.apjifengc.yaaddition.core.SpecialTripWire;
import io.github.apjifengc.yaaddition.core.listener.BlockListener;
import io.github.apjifengc.yaaddition.exception.MaterialAlreadyRegisteredException;
import io.github.apjifengc.yaaddition.model.recipe.builder.InGameRecipeBuilder;
import io.github.bananapuncher714.nbteditor.NBTEditor;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Collections;

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
        new BlockListener(this);
        new CommandDebug().register();
        AdditionMaterial test = new AdditionMaterial(AdditionMaterial.AdditionMaterialType.ITEM, "TEST_ITEM", null,
                "test", Collections.singletonList("YAY"));
        AdditionMaterial testBlock = new AdditionMaterial(AdditionMaterial.AdditionMaterialType.FULL_BLOCK,
                "TEST_BLOCK", null, "test block", Collections.singletonList("GREAT"));
        try {
            test.register();
            testBlock.register();
        } catch (MaterialAlreadyRegisteredException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

}
