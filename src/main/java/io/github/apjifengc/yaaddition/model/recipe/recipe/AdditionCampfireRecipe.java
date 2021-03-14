
package io.github.apjifengc.yaaddition.model.recipe.recipe;

import org.bukkit.inventory.ItemStack;

import io.github.apjifengc.yaaddition.model.recipe.util.RecipeType;

import lombok.NonNull;

/**
 * 篝火配方
 */
public class AdditionCampfireRecipe extends AdditionCookingRecipe {
    /**
     * 新建空的篝火配方
     */
    public AdditionCampfireRecipe() {
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
    public AdditionCampfireRecipe(@NonNull ItemStack cookingSource, @NonNull ItemStack cookingResult, float cookingExperience,
            int cookingTime) {
        super(cookingSource, cookingResult, cookingExperience, cookingTime, RecipeType.CAMPFIRE);
    }

    public AdditionCampfireRecipe(@NonNull ItemStack cookingSource, @NonNull ItemStack cookingResult,
            float cookingExperience) {
        super(cookingSource, cookingResult, cookingExperience, 200, RecipeType.CAMPFIRE);
    }

    public AdditionCampfireRecipe(@NonNull ItemStack cookingSource, @NonNull ItemStack cookingResult, int cookingTime) {
        super(cookingSource, cookingResult, 0, cookingTime, RecipeType.CAMPFIRE);
    }

    public AdditionCampfireRecipe(@NonNull ItemStack cookingResult, @NonNull ItemStack cookingSource) {
        super(cookingSource, cookingResult, 0, 200, RecipeType.CAMPFIRE);
    }

    @Override
    public boolean isIncorrectType() {
        return isIncorrectType(RecipeType.CAMPFIRE);
    }
}
