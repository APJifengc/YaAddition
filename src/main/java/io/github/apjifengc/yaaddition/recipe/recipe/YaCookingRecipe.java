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

import io.github.apjifengc.yaaddition.recipe.util.RecipeType;

/**
 * 所有烧制配方的父类
 */
public class YaCookingRecipe extends YaRecipe {

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

    /**
     * 将配方保存为文件，路径为{@link RecipeType#getPath()}
     */
    public void save() throws IOException {
        HashMap<String, Object> map = new HashMap<>();
        map.put("type", this.type);
        map.put("result", this.result);
        map.put("cookingSource", this.cookingSource);
        map.put("cookingExperience", this.cookingExperience);
        map.put("cookingTime", this.cookingTime);
        save(map);
    }

    /**
     * 从文件名加载配方，路径为{@link RecipeType#getPath()}
     * 
     * @param fileName 配方文件名
     */
    protected void load(@NonNull String fileName) throws Exception {
        String path = this.type.getPath() + fileName;
        load(new File(path));
    }

    /**
     * 从文件加载配方
     * 
     * @param file 配方文件
     * @throws Exception
     */
    protected void load(@NonNull File file) throws Exception {
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
    }

    /**
     * 检测配方是否完整
     * 
     * @return 如果完整返回true否则返回false
     */
    protected boolean isIncomplete() {
        return this.cookingSource == null || this.result == null;
    }
}
