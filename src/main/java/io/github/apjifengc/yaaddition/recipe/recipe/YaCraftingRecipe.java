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
 * 有序和无序合成配方的父类
 */
public class YaCraftingRecipe extends YaRecipe {

    @Getter
    @Setter
    protected ItemStack[] craftingSource;

    protected YaCraftingRecipe(@NonNull RecipeType type) {
        this.type = type;
    }

    protected YaCraftingRecipe(ItemStack[] craftingSource, ItemStack craftingResult, @NonNull RecipeType type) {
        this.craftingSource = craftingSource;
        this.result = craftingResult;
        this.type = type;
        namespacedKeyGen(this.result, this.type);
    }

    /**
     * 将配方保存为文件，路径为{@link RecipeType#getPath()}
     */
    public void save() throws IOException {
        HashMap<String, Object> map = new HashMap<>();
        map.put("type", this.type);
        map.put("result", this.result);
        map.put("craftingSource", this.craftingSource);
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
     */
    protected void load(@NonNull File file) throws Exception {
        try (BukkitObjectInputStream ois = new BukkitObjectInputStream(new FileInputStream(file));) {
            HashMap<String, Object> map = new HashMap<>();
            Object readMap = ois.readObject();

            if (readMap instanceof HashMap) {
                map.putAll((HashMap) readMap);
                setResult((ItemStack) map.get("result"));
                this.craftingSource = (ItemStack[]) map.get("craftingSource");
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
        return this.craftingSource == null || this.result == null;
    }
}
