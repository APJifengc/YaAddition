package io.github.apjifengc.yaaddition.model.recipe.recipe;

import org.bukkit.util.io.BukkitObjectInputStream;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;

import io.github.apjifengc.yaaddition.addition.AdditionItemStack;
import io.github.apjifengc.yaaddition.exception.RecipeException;
import io.github.apjifengc.yaaddition.model.recipe.util.RecipeType;

/**
 * 有序和无序合成配方的父类
 */
public abstract class AdditionCraftingRecipe extends AdditionRecipe {

    @Getter
    @Setter
    protected AdditionItemStack[] craftingSource;

    protected AdditionCraftingRecipe(@NonNull RecipeType type) {
        this.type = type;
    }

    protected AdditionCraftingRecipe(AdditionItemStack[] craftingSource, AdditionItemStack craftingResult, @NonNull RecipeType type) {
        this.craftingSource = craftingSource;
        this.result = craftingResult;
        this.type = type;
        namespacedKeyGen(this.result, this.type);
    }

    @Override
    public void save() throws IOException, RecipeException {
        selfCheck();
        HashMap<String, Object> map = new HashMap<>();
        map.put("type", this.type);
        map.put("result", this.result);
        map.put("craftingSource", this.craftingSource);
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
                setResult((AdditionItemStack) map.get("result"));
                this.craftingSource = (AdditionItemStack[]) map.get("craftingSource");
                this.type = (RecipeType) map.get("type");
            }
        }
        selfCheck();
    }

    @Override
    public boolean isIncomplete() {
        return this.craftingSource == null || this.result == null;
    }
}
