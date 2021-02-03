package io.github.apjifengc.yaaddition.recipe.recipe;

import java.io.File;

import io.github.apjifengc.yaaddition.recipe.excption.IncompleteRecipeException;
import io.github.apjifengc.yaaddition.recipe.excption.WrongRecipeTypeException;
import io.github.apjifengc.yaaddition.recipe.util.RecipeType;

import org.bukkit.inventory.ItemStack;

import lombok.NonNull;

public class YaCampfireRecipe extends YaCookingRecipe {
    /**
     * 新建空的篝火配方
     */
    public YaCampfireRecipe() {
        super(RecipeType.CAMPFIRE_RECIPE);
    }

    /**
     * 新建篝火配方
     * 
     * @param cookingResult     产品
     * @param cookingSource     材料
     * @param cookingExperience 经验
     * @param cookingTime       烹饪时间
     */
    public YaCampfireRecipe(@NonNull ItemStack cookingResult, @NonNull ItemStack cookingSource, float cookingExperience,
            int cookingTime) {
        super(cookingResult, cookingSource, cookingExperience, cookingTime, RecipeType.CAMPFIRE_RECIPE);
    }

    public YaCampfireRecipe(@NonNull ItemStack cookingResult, @NonNull ItemStack cookingSource,
            float cookingExperience) {
        super(cookingResult, cookingSource, cookingExperience, 200, RecipeType.CAMPFIRE_RECIPE);
    }

    public YaCampfireRecipe(@NonNull ItemStack cookingResult, @NonNull ItemStack cookingSource, int cookingTime) {
        super(cookingResult, cookingSource, 0, cookingTime, RecipeType.CAMPFIRE_RECIPE);
    }

    public YaCampfireRecipe(@NonNull ItemStack cookingResult, @NonNull ItemStack cookingSource) {
        super(cookingResult, cookingSource, 0, 200, RecipeType.CAMPFIRE_RECIPE);
    }

    /**
     * 从文件名加载配方，路径为{@link RecipeType#getPath()}
     * 
     * @param fileName 配方文件名
     */
    @Override
    public void load(@NonNull String fileName) throws Exception {
        super.load(fileName);
        if (this.cookingSource == null || this.result == null || !this.type.equals(RecipeType.CAMPFIRE_RECIPE)) {
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
        if (this.cookingSource == null || this.result == null || !this.type.equals(RecipeType.CAMPFIRE_RECIPE)) {
            throw new WrongRecipeTypeException(file.getAbsolutePath());
        } else if (super.isIncomplete()) {
            throw new IncompleteRecipeException(file.getAbsolutePath());
        }
    }
}
