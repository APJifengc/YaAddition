
package io.github.apjifengc.yaaddition.recipe.recipe;

import io.github.apjifengc.yaaddition.recipe.util.RecipeType;

import org.bukkit.inventory.ItemStack;

import lombok.NonNull;

/**
 * 高炉配方
 */
public class YaBlastFurnaceRecipe extends YaCookingRecipe {
    /**
     * 新建空的高炉配方
     */
    public YaBlastFurnaceRecipe() {
        super(RecipeType.BLAST_FURNACE);
    }

    /**
     * 新建高炉配方
     * 
     * @param cookingResult     产品
     * @param cookingSource     材料
     * @param cookingExperience 经验
     * @param cookingTime       熔炼时间
     */
    public YaBlastFurnaceRecipe(@NonNull ItemStack cookingSource, @NonNull ItemStack cookingResult,
            float cookingExperience, int cookingTime) {
        super(cookingSource, cookingResult, cookingExperience, cookingTime, RecipeType.BLAST_FURNACE);
    }

    public YaBlastFurnaceRecipe(@NonNull ItemStack cookingSource, @NonNull ItemStack cookingResult,
            float cookingExperience) {
        super(cookingSource, cookingResult, cookingExperience, 100, RecipeType.BLAST_FURNACE);
    }

    public YaBlastFurnaceRecipe(@NonNull ItemStack cookingSource, @NonNull ItemStack cookingResult, int cookingTime) {
        super(cookingSource, cookingResult, 0, cookingTime, RecipeType.BLAST_FURNACE);
    }

    public YaBlastFurnaceRecipe(@NonNull ItemStack cookingResult, @NonNull ItemStack cookingSource) {
        super(cookingSource, cookingResult, 0, 100, RecipeType.BLAST_FURNACE);
    }

    @Override
    public boolean isIncorrectType() {
        return isIncorrectType(RecipeType.BLAST_FURNACE);
    }
}
