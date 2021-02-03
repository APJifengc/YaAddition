package io.github.apjifengc.yaaddition.recipe.recipe;

import io.github.apjifengc.yaaddition.recipe.util.RecipeType;

import org.bukkit.inventory.ItemStack;

import lombok.NonNull;

/**
 * 无序合成
 */
public class YaShapelessCraftRecipe extends YaCraftingRecipe {

    /**
     * 新建空的无序合成
     */
    public YaShapelessCraftRecipe() {
        super(RecipeType.SHAPELESS_CRAFT);
    }

    /**
     * 新建无序合成
     * 
     * @param craftingSource 材料，最多九堆
     * @param craftingResult 产品
     */
    public YaShapelessCraftRecipe(@NonNull ItemStack[] craftingSource, @NonNull ItemStack craftingResult) {
        super(craftingSource, craftingResult, RecipeType.SHAPELESS_CRAFT);
    }

    @Override
    public boolean isIncorrectType() {
        return isIncorrectType(RecipeType.SHAPELESS_CRAFT);
    }
}
