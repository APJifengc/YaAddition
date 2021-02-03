package io.github.apjifengc.yaaddition;

import io.github.apjifengc.yaaddition.recipe.builder.InGameRecipeBuilder;

import org.bukkit.plugin.java.JavaPlugin;

import lombok.Getter;

public final class YaAddition extends JavaPlugin {
    @Getter
    private static YaAddition instance;

    @Override
    public void onEnable() {
        instance = this;
        // 加载本插件所有配方
        InGameRecipeBuilder.buildAll();
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

}
