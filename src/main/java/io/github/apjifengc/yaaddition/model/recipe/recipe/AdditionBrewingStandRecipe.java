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
 * 酿造配方
 */
public class AdditionBrewingStandRecipe extends AdditionRecipe {

    @Getter
    @Setter
    private AdditionItemStack ingredient;
    @Getter
    @Setter
    private AdditionItemStack potion;

    /**
     * 新建空的酿造配方
     */
    public AdditionBrewingStandRecipe() {
        this.type = RecipeType.BREWING_STAND;
    }

    /**
     * 新建酿造配方
     */
    public AdditionBrewingStandRecipe(@NonNull AdditionItemStack ingredient, @NonNull AdditionItemStack potion,
            @NonNull AdditionItemStack brewingResult) {
        this.ingredient = ingredient;
        this.potion = potion;
        this.result = brewingResult;
        this.type = RecipeType.BREWING_STAND;
        namespacedKeyGen(this.result, this.type);
    }

    @Override
    public void save() throws IOException, RecipeException {
        selfCheck();
        HashMap<String, Object> map = new HashMap<>();
        map.put("type", this.type);
        map.put("result", this.result);
        map.put("ingredient", this.ingredient);
        map.put("potion", this.potion);
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
                this.ingredient = (AdditionItemStack) map.get("ingredient");
                this.potion = (AdditionItemStack) map.get("potion");
                this.type = (RecipeType) map.get("type");
            }
        }
        selfCheck();
    }

    @Override
    public boolean isIncomplete() {
        return this.ingredient == null || this.potion == null || this.result == null;
    }

    @Override
    public boolean isIncorrectType() {
        return isIncorrectType(RecipeType.BREWING_STAND);
    }
}
