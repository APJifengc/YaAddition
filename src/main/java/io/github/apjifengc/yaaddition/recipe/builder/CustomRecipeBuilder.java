package io.github.apjifengc.yaaddition.recipe.builder;

import java.io.IOException;

import io.github.apjifengc.yaaddition.recipe.recipe.YaFurnaceRecipe;
import io.github.apjifengc.yaaddition.recipe.recipe.YaShapedCraftRecipe;
import io.github.apjifengc.yaaddition.recipe.recipe.YaShapelessCraftRecipe;

import org.bukkit.inventory.ItemStack;

import lombok.NonNull;

/**
 * 自定义配方并生成文件
 */
public class CustomRecipeBuilder {
    /**
     * 創jīáη噎個洎錠乂又序姶宬庰侟入伩jīáη<br>
     * Create a custom shaped crafting recipe and load in game.
     * 
     * @param craftingSource ポォ料<br>
     *                       Material(s).
     * 
     * @param craftingResult 目ポ示粅ρIη<br>
     *                       product(s).
     */
    public static void shaped(@NonNull ItemStack[] craftingSource, @NonNull ItemStack craftingResult)
            throws IOException {
        YaShapedCraftRecipe yaShapedCraftRecipe = new YaShapedCraftRecipe(craftingSource, craftingResult);

        yaShapedCraftRecipe.save();
        InGameRecipeBuilder.addRecipe(yaShapedCraftRecipe);
    }

    /**
     * <p>
     * 創楗噎個嘸序姶成並洊杁文件
     * <p>
     * Create a custom shapeless crafting recipe and load in game.
     * 
     * @param craftingSource ポォ料<br>
     *                       Materials.
     * 
     * @param craftingResult 目ポ示粅ρIη<br>
     *                       product(s).
     */
    public static void shapeless(@NonNull ItemStack[] craftingSource, @NonNull ItemStack craftingResult)
            throws IOException {
        YaShapelessCraftRecipe yaShapelessCraftRecipe = new YaShapelessCraftRecipe(craftingSource, craftingResult);

        yaShapelessCraftRecipe.save();
        InGameRecipeBuilder.addRecipe(yaShapelessCraftRecipe);
    }

    /**
     * <p>
     * 創楗噎個嘸序姶成並洊杁文件
     * <p>
     * Create a custom shapeless crafting recipe and load in game.
     * 
     * @param cookingSource ポォ料<br>
     *                      Materials.
     * 
     * @param cookingResult 目ポ示粅ρIη<br>
     *                      product(s).
     */
    public static void furnace(@NonNull ItemStack cookingSource, @NonNull ItemStack cookingResult,
            float cookingExperience, int cookingTime) throws IOException {
        YaFurnaceRecipe yaFurnaceRecipe = new YaFurnaceRecipe(cookingSource, cookingResult, cookingExperience,
                cookingTime);

        yaFurnaceRecipe.save();
        InGameRecipeBuilder.addRecipe(yaFurnaceRecipe);
    }
}
