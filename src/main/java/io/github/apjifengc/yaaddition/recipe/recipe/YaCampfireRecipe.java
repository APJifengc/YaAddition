
package io.github.apjifengc.yaaddition.recipe.recipe;

import io.github.apjifengc.yaaddition.recipe.util.RecipeType;

import org.bukkit.inventory.ItemStack;

import lombok.NonNull;

/**
 * 篝火配方
 */
public class YaCampfireRecipe extends YaCookingRecipe {
    /**
     * 新建空的篝火配方
     */
    public YaCampfireRecipe() {
        super(RecipeType.CAMPFIRE);
    }

    /**
     * 新建篝火配方
     * 
     * @param cookingResult     产品
     * @param cookingSource     材料
     * @param cookingExperience 经验
     * @param cookingTime       烹饪时间
     */
    public YaCampfireRecipe(@NonNull ItemStack cookingSource, @NonNull ItemStack cookingResult, float cookingExperience,
            int cookingTime) {
        super(cookingSource, cookingResult, cookingExperience, cookingTime, RecipeType.CAMPFIRE);
    }

    public YaCampfireRecipe(@NonNull ItemStack cookingSource, @NonNull ItemStack cookingResult,
            float cookingExperience) {
        super(cookingSource, cookingResult, cookingExperience, 200, RecipeType.CAMPFIRE);
    }

    public YaCampfireRecipe(@NonNull ItemStack cookingSource, @NonNull ItemStack cookingResult, int cookingTime) {
        super(cookingSource, cookingResult, 0, cookingTime, RecipeType.CAMPFIRE);
    }

    public YaCampfireRecipe(@NonNull ItemStack cookingResult, @NonNull ItemStack cookingSource) {
        super(cookingSource, cookingResult, 0, 200, RecipeType.CAMPFIRE);
    }

    @Override
    public boolean isIncorrectType() {
        return isIncorrectType(RecipeType.CAMPFIRE);
    }
}
