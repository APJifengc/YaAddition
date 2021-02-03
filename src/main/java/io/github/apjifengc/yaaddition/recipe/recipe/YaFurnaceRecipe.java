
package io.github.apjifengc.yaaddition.recipe.recipe;

import java.io.File;

import io.github.apjifengc.yaaddition.recipe.excption.IncompleteRecipeException;
import io.github.apjifengc.yaaddition.recipe.excption.WrongRecipeTypeException;
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
        super(RecipeType.FURNACE_RECIPE);
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
        super(cookingSource, cookingResult, cookingExperience, cookingTime, RecipeType.FURNACE_RECIPE);
    }

    public YaFurnaceRecipe(@NonNull ItemStack cookingSource, @NonNull ItemStack cookingResult,
            float cookingExperience) {
        super(cookingSource, cookingResult, cookingExperience, 200, RecipeType.FURNACE_RECIPE);
    }

    public YaFurnaceRecipe(@NonNull ItemStack cookingSource, @NonNull ItemStack cookingResult, int cookingTime) {
        super(cookingSource, cookingResult, 0, cookingTime, RecipeType.FURNACE_RECIPE);
    }

    public YaFurnaceRecipe(@NonNull ItemStack cookingSource, @NonNull ItemStack cookingResult) {
        super(cookingSource, cookingResult, 0, 200, RecipeType.FURNACE_RECIPE);
    }

    /**
     * 从文件名加载配方，路径为{@link RecipeType#getPath()}
     * 
     * @param fileName 配方文件名
     */
    @Override
    public void load(@NonNull String fileName) throws Exception {
        super.load(fileName);
        if (this.cookingSource == null || this.result == null || !this.type.equals(RecipeType.FURNACE_RECIPE)) {
            throw new WrongRecipeTypeException(fileName);
        }
    }

    /**
     * 从文件加载配方
     * 
     * @param file 配方文件
     */
    @Override
    public void load(@NonNull File file) throws Exception {
        super.load(file);
        if (this.cookingSource == null || this.result == null || !this.type.equals(RecipeType.FURNACE_RECIPE)) {
            throw new WrongRecipeTypeException(file.getAbsolutePath());
        } else if (super.isIncomplete()) {
            throw new IncompleteRecipeException(file.getAbsolutePath());
        }
    }
}
