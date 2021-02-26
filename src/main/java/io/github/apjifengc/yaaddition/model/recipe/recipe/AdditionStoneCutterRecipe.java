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
 * 切石机配方
 */
public class AdditionStoneCutterRecipe extends AdditionRecipe {

    @Getter
    @Setter
    private AdditionItemStack cuttingSource;

    /**
     * 新建空的切石配方
     */
    public AdditionStoneCutterRecipe() {
        this.type = RecipeType.STONE_CUTTER;
    }

    /**
     * 新建切石配方
     * 
     * @param cuttingSource 材料
     * @param cuttingResult 产品
     */
    public AdditionStoneCutterRecipe(@NonNull AdditionItemStack cuttingSource, @NonNull AdditionItemStack cuttingResult) {
        this.cuttingSource = cuttingSource;
        this.result = cuttingResult;
        this.type = RecipeType.STONE_CUTTER;
        namespacedKeyGen(this.result, this.type);
    }

    @Override
    public void save() throws IOException, RecipeException {
        selfCheck();
        HashMap<String, Object> map = new HashMap<>();
        map.put("type", this.type);
        map.put("result", this.result);
        map.put("cuttingSource", this.cuttingSource);
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
                this.cuttingSource = (AdditionItemStack) map.get("cuttingSource");
                this.type = (RecipeType) map.get("type");
            }
        }
        selfCheck();
    }

    @Override
    public boolean isIncomplete() {
        return this.cuttingSource == null || this.result == null;
    }

    @Override
    public boolean isIncorrectType() {
        return isIncorrectType(RecipeType.STONE_CUTTER);
    }
}
