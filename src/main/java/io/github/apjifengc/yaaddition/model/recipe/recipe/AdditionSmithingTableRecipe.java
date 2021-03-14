package io.github.apjifengc.yaaddition.model.recipe.recipe;

import org.bukkit.inventory.ItemStack;
import org.bukkit.util.io.BukkitObjectInputStream;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;

import io.github.apjifengc.yaaddition.exception.RecipeException;
import io.github.apjifengc.yaaddition.model.recipe.util.RecipeType;

/**
 * 锻造配方
 */
public class AdditionSmithingTableRecipe extends AdditionRecipe {

    @Getter
    @Setter
    private ItemStack smithingBase;
    @Getter
    @Setter
    private ItemStack smithingAddition;

    /**
     * 新建空的锻造配方
     */
    public AdditionSmithingTableRecipe() {
        this.type = RecipeType.SMITHING_TABLE;
    }

    /**
     * 新建锻造配方
     *
     * @param smithingBase     基础物品
     * @param smithingAddition 附加物品
     * @param smithingResult   产品
     */
    public AdditionSmithingTableRecipe(@NonNull ItemStack smithingBase, @NonNull ItemStack smithingAddition,
            @NonNull ItemStack smithingResult) {
        this.smithingBase = smithingBase;
        this.smithingAddition = smithingAddition;
        this.result = smithingResult;
        this.type = RecipeType.SMITHING_TABLE;
        namespacedKeyGen(this.result, this.type);
    }

    @Override
    public void save() throws IOException, RecipeException {
        selfCheck();
        HashMap<String, Object> map = new HashMap<>();
        map.put("type", this.type);
        map.put("result", this.result);
        map.put("smithingBase", this.smithingBase);
        map.put("smithingAddition", this.smithingAddition);
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
                setResult((ItemStack) map.get("result"));
                this.smithingBase = (ItemStack) map.get("smithingBase");
                this.smithingAddition = (ItemStack) map.get("smithingAddition");
                this.type = (RecipeType) map.get("type");
            }
        }
        selfCheck();
    }

    @Override
    public boolean isIncomplete() {
        return this.smithingBase == null || this.smithingAddition == null || this.result == null;
    }

    @Override
    public boolean isIncorrectType() {
        return isIncorrectType(RecipeType.SMITHING_TABLE);
    }
}
