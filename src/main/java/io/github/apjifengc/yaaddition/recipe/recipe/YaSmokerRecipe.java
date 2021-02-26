
package io.github.apjifengc.yaaddition.recipe.recipe;

import java.io.File;

import io.github.apjifengc.yaaddition.recipe.excption.IncompleteRecipeException;
import io.github.apjifengc.yaaddition.recipe.excption.WrongRecipeTypeException;
import io.github.apjifengc.yaaddition.recipe.util.RecipeType;

import org.bukkit.inventory.ItemStack;

import lombok.NonNull;

/**
 * 烟熏炉配方
 */
public class YaSmokerRecipe extends YaCookingRecipe {
    /**
     * 新建空的烟熏炉配方
     */
    public YaSmokerRecipe() {
        super(RecipeType.SMOKER);
    }

    /**
     * 新建烟熏炉配方
     * 
     * @param cookingResult     产品
     * @param cookingSource     材料
     * @param cookingExperience 经验
     * @param cookingTime       烹饪时间
     */
    public YaSmokerRecipe(@NonNull ItemStack cookingSource, @NonNull ItemStack cookingResult, float cookingExperience,
            int cookingTime) {
        super(cookingResult, cookingSource, cookingExperience, cookingTime, RecipeType.SMOKER);
    }

    public YaSmokerRecipe(@NonNull ItemStack cookingSource, @NonNull ItemStack cookingResult, float cookingExperience) {
        super(cookingResult, cookingSource, cookingExperience, 100, RecipeType.SMOKER);
    }

    public YaSmokerRecipe(@NonNull ItemStack cookingSource, @NonNull ItemStack cookingResult, int cookingTime) {
        super(cookingResult, cookingSource, 0, cookingTime, RecipeType.SMOKER);
    }

    public YaSmokerRecipe(@NonNull ItemStack cookingResult, @NonNull ItemStack cookingSource) {
        super(cookingResult, cookingSource, 0, 100, RecipeType.SMOKER);
    }

    @Override
    public boolean isIncorrectType() {
        return isIncorrectType(RecipeType.SMOKER);
    }
}
