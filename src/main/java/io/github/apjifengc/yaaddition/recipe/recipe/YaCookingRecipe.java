package io.github.apjifengc.yaaddition.recipe.recipe;

import org.bukkit.inventory.ItemStack;
import org.bukkit.util.io.BukkitObjectInputStream;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;

import io.github.apjifengc.yaaddition.recipe.excption.RecipeException;
import io.github.apjifengc.yaaddition.recipe.util.RecipeType;

/**
 * 所有烧制配方的父类
 */
public abstract class YaCookingRecipe extends YaRecipe {

    @Getter
    @Setter
    protected ItemStack cookingSource;
    @Getter
    @Setter
    protected float cookingExperience = 0;
    @Getter
    @Setter
    protected int cookingTime = 200;

    protected YaCookingRecipe(RecipeType type) {
        this.type = type;
    }

    protected YaCookingRecipe(ItemStack cookingSource, ItemStack cookingResult, float cookingExperience,
            int cookingTime, RecipeType type) {
        this.cookingSource = cookingSource;
        setResult(cookingResult);
        this.cookingExperience = cookingExperience;
        this.cookingTime = cookingTime;
        this.type = type;
    }

    @Override
    public void save() throws IOException, RecipeException {
        selfCheck();
        HashMap<String, Object> map = new HashMap<>();
        map.put("type", this.type);
        map.put("result", this.result);
        map.put("cookingSource", this.cookingSource);
        map.put("cookingExperience", this.cookingExperience);
        map.put("cookingTime", this.cookingTime);
        save(map);
    }

    /**
     * @param file 配方文件
     */
    @Override
    public void load(@NonNull File file) throws IOException, RecipeException, ClassNotFoundException {
        try (BukkitObjectInputStream ois = new BukkitObjectInputStream(new FileInputStream(file));) {
            HashMap<String, Object> map = new HashMap<>();
            Object readMap = ois.readObject();

            if (readMap instanceof HashMap) {
                map.putAll((HashMap) readMap);
                this.cookingExperience = (float) map.get("cookingExperience");
                this.cookingTime = (int) map.get("cookingTime");
                this.cookingSource = (ItemStack) map.get("cookingSource");
                setResult((ItemStack) map.get("result"));
                this.type = (RecipeType) map.get("type");
            }
        }
        selfCheck();
    }

    @Override
    public boolean isIncomplete() {
        return this.cookingSource == null || this.result == null;
    }
}
