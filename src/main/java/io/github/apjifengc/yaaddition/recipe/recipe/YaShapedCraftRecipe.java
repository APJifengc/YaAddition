package io.github.apjifengc.yaaddition.recipe.recipe;

import java.io.File;

import io.github.apjifengc.yaaddition.recipe.excption.IncompleteRecipeException;
import io.github.apjifengc.yaaddition.recipe.excption.WrongRecipeTypeException;
import io.github.apjifengc.yaaddition.recipe.util.RecipeType;

import org.bukkit.inventory.ItemStack;

import lombok.NonNull;

public class YaShapedCraftRecipe extends YaCraftingRecipe {
    /**
     * 新建空的有序合成
     */
    public YaShapedCraftRecipe() {
        super(RecipeType.SHAPED_CRAFT_RECIPE);
    }

    /**
     * 新建有序合成
     * 
     * @param craftingSource 材料，按九宫格从左到右从上到下的顺序，最多九堆
     * @param craftingResult 产品
     */
    public YaShapedCraftRecipe(@NonNull ItemStack[] craftingSource, @NonNull ItemStack craftingResult) {
        super(craftingSource, craftingResult, RecipeType.SHAPED_CRAFT_RECIPE);
    }

    /**
     * 从文件名加载配方，路径为{@link RecipeType#getPath()}
     * 
     * @param fileName 配方文件名
     */
    @Override
    public void load(@NonNull String fileName) throws Exception {
        super.load(fileName);
        if (this.craftingSource == null || this.result == null || !this.type.equals(RecipeType.SHAPED_CRAFT_RECIPE)) {
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
        if (!this.type.equals(RecipeType.SHAPED_CRAFT_RECIPE)) {
            throw new WrongRecipeTypeException(file.getAbsolutePath());
        } else if (super.isIncomplete()) {
            throw new IncompleteRecipeException(file.getAbsolutePath());
        }
    }
}
