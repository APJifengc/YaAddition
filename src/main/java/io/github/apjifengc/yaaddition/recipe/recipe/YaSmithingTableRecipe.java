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

import io.github.apjifengc.yaaddition.recipe.excption.IncompleteRecipeException;
import io.github.apjifengc.yaaddition.recipe.excption.WrongRecipeTypeException;
import io.github.apjifengc.yaaddition.recipe.util.RecipeType;

public class YaSmithingTableRecipe extends YaRecipe {

    @Getter
    @Setter
    protected ItemStack smithingBase;
    @Getter
    @Setter
    protected ItemStack smithingAddition;

    /**
     * 新建空的锻造配方
     */
    public YaSmithingTableRecipe() {
        this.type = RecipeType.SMITHING_TABLE_RECIPE;
    }

    /**
     * 新建锻造配方
     *
     * @param smithingBase 基础物品
     * @param smithingAddition 附加物品
     * @param smithingResult 产品
     */
    public YaSmithingTableRecipe(@NonNull ItemStack smithingBase, @NonNull ItemStack smithingAddition,
            @NonNull ItemStack smithingResult) {
        this.smithingBase = smithingBase;
        this.smithingAddition = smithingAddition;
        this.result = smithingResult;
        this.type = RecipeType.SMITHING_TABLE_RECIPE;
        namespacedKeyGen(this.result, this.type);
    }

    /**
     * 将配方保存为文件，路径为{@link RecipeType#getPath()}
     */
    public void save() throws IOException {
        HashMap<String, Object> map = new HashMap<>();
        map.put("type", this.type);
        map.put("result", this.result);
        map.put("smithingBase", this.smithingBase);
        map.put("smithingAddition", this.smithingAddition);
        save(map);
    }

    /**
     * 从文件名加载配方，路径为{@link RecipeType#getPath()}
     * 
     * @param fileName 配方文件名
     */
    public void load(@NonNull String fileName) throws Exception {
        String path = this.type.getPath() + fileName;
        File file = new File(path);
        load(file);
    }

    /**
     * 从文件加载配方
     * 
     * @param file 配方文件
     */
    public void load(@NonNull File file) throws Exception {
        try (BukkitObjectInputStream ois = new BukkitObjectInputStream(new FileInputStream(file));) {
            HashMap<String, Object> map = new HashMap<>();
            Object readMap = ois.readObject();

            if (readMap instanceof HashMap) {
                map.putAll((HashMap) readMap);
                setResult((ItemStack) map.get("result"));
                this.smithingBase = (ItemStack) map.get("smithingBase");
                this.smithingAddition = (ItemStack) map.get("smithingAddition");
                this.type = (RecipeType) map.get("type");
                if (!this.type.equals(RecipeType.STONE_CUTTER_RECIPE)) {
                    throw new WrongRecipeTypeException(file.getAbsolutePath());
                } else if (isIncomplete()) {
                    throw new IncompleteRecipeException(file.getAbsolutePath());
                }
            }
        }
    }

    /**
     * 检测配方是否完整
     * 
     * @return 如果完整返回true否则返回false
     */
    private boolean isIncomplete() {
        return this.smithingBase == null || this.smithingAddition == null || this.result == null;
    }
}
