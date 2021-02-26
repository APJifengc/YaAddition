package io.github.apjifengc.yaaddition.model.recipe.recipe;

import io.github.apjifengc.yaaddition.addition.AdditionItemStack;
import io.github.apjifengc.yaaddition.model.recipe.util.RecipeType;

import lombok.NonNull;

/**
 * 无序合成
 */
public class AdditionShapelessCraftRecipe extends AdditionCraftingRecipe {

    /**
     * 新建空的无序合成
     */
    public AdditionShapelessCraftRecipe() {
        super(RecipeType.SHAPELESS_CRAFT);
    }

    /**
     * 新建无序合成
     * 
     * @param craftingSource 材料，最多九堆
     * @param craftingResult 产品
     */
    public AdditionShapelessCraftRecipe(@NonNull AdditionItemStack[] craftingSource, @NonNull AdditionItemStack craftingResult) {
        super(craftingSource, craftingResult, RecipeType.SHAPELESS_CRAFT);
    }

    @Override
    public boolean isIncorrectType() {
        return isIncorrectType(RecipeType.SHAPELESS_CRAFT);
    }
}
