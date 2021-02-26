
package io.github.apjifengc.yaaddition.recipe.recipe;

import io.github.apjifengc.yaaddition.recipe.util.RecipeType;

import org.bukkit.inventory.ItemStack;

import lombok.NonNull;

/**
 * 熔炉配方
 */
public class YaFurnaceRecipe extends YaCookingRecipe {
    /**
     * 新建空的熔炉配方
     */
    public YaFurnaceRecipe() {
        super(RecipeType.FURNACE);
    }

    /**
     * 新建熔炉配方
     * 
     * @param cookingResult     产品
     * @param cookingSource     材料
     * @param cookingExperience 经验
     * @param cookingTime       烧制时间
     */
    public YaFurnaceRecipe(@NonNull ItemStack cookingSource, @NonNull ItemStack cookingResult, float cookingExperience,
            int cookingTime) {
        super(cookingSource, cookingResult, cookingExperience, cookingTime, RecipeType.FURNACE);
    }

    public YaFurnaceRecipe(@NonNull ItemStack cookingSource, @NonNull ItemStack cookingResult,
            float cookingExperience) {
        super(cookingSource, cookingResult, cookingExperience, 200, RecipeType.FURNACE);
    }

    public YaFurnaceRecipe(@NonNull ItemStack cookingSource, @NonNull ItemStack cookingResult, int cookingTime) {
        super(cookingSource, cookingResult, 0, cookingTime, RecipeType.FURNACE);
    }

    public YaFurnaceRecipe(@NonNull ItemStack cookingSource, @NonNull ItemStack cookingResult) {
        super(cookingSource, cookingResult, 0, 200, RecipeType.FURNACE);
    }

    @Override
    public boolean isIncorrectType() {
        return isIncorrectType(RecipeType.FURNACE);
    }
}
