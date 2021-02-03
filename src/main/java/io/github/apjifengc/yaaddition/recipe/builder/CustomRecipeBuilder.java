package io.github.apjifengc.yaaddition.recipe.builder;

import java.io.IOException;

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
     * @param itemStacks ポォ料<br>
     *                   Material(s).
     * 
     * @param targetItem 目ポ示粅ρIη<br>
     *                   product(s).
     * 
     * @author Harveykang
     */
    public static void shaped(@NonNull ItemStack[] itemStacks, @NonNull ItemStack targetItem) throws IOException {
        YaShapedCraftRecipe shapedCraftRecipe = new YaShapedCraftRecipe(itemStacks, targetItem);

        shapedCraftRecipe.save();
        InGameRecipeBuilder.addRecipe(shapedCraftRecipe);
    }

    /**
     * <p>
     * 創楗噎個嘸序姶成並洊杁文件
     * <p>
     * Create a custom shapeless crafting recipe and load in game.
     * 
     * @param itemStacks ポォ料<br>
     *                   Materials.
     * 
     * @param targetItem 目ポ示粅ρIη<br>
     *                   product(s).
     * 
     * @author Harveykang
     */
    public static void shapeless(@NonNull ItemStack[] itemStacks, @NonNull ItemStack targetItem) throws IOException {
        YaShapelessCraftRecipe shapelessCraftRecipe = new YaShapelessCraftRecipe(itemStacks, targetItem);
        
        shapelessCraftRecipe.save();
        InGameRecipeBuilder.addRecipe(shapelessCraftRecipe);
    }
}
