
package io.github.apjifengc.yaaddition.model.recipe.builder;

import io.github.apjifengc.yaaddition.addition.AdditionItemStack;
import io.github.apjifengc.yaaddition.exception.RecipeException;
import io.github.apjifengc.yaaddition.model.recipe.recipe.AdditionBlastFurnaceRecipe;
import io.github.apjifengc.yaaddition.model.recipe.recipe.AdditionCampfireRecipe;
import io.github.apjifengc.yaaddition.model.recipe.recipe.AdditionFurnaceRecipe;
import io.github.apjifengc.yaaddition.model.recipe.recipe.AdditionShapedCraftRecipe;
import io.github.apjifengc.yaaddition.model.recipe.recipe.AdditionShapelessCraftRecipe;
import io.github.apjifengc.yaaddition.model.recipe.recipe.AdditionSmithingTableRecipe;
import io.github.apjifengc.yaaddition.model.recipe.recipe.AdditionSmokerRecipe;
import io.github.apjifengc.yaaddition.model.recipe.recipe.AdditionStoneCutterRecipe;

import java.io.IOException;

import org.bukkit.inventory.ItemStack;

import lombok.NonNull;

/**
 * 自定义配方并生成文件
 */
public class CustomRecipeBuilder {
    
    /**
     * 添加有序合成并保存文件
     * 
     * @param craftingSource 材料
     * @param craftingResult 产物
     * @param namespacedKey  命名空间
     * @deprecated
     */
    @Deprecated
    public static void shaped(@NonNull AdditionItemStack[] craftingSource, @NonNull AdditionItemStack craftingResult)
            throws IOException, RecipeException {
        ItemStack[] bukkitCraftingSource = new ItemStack[9];
        for (int i = 0; i < craftingSource.length; i++) {
            bukkitCraftingSource[i] = craftingSource[i].asBukkitCopy();
        }
        AdditionShapedCraftRecipe yaShapedCraftRecipe = new AdditionShapedCraftRecipe(bukkitCraftingSource,
                craftingResult.asBukkitCopy());

        yaShapedCraftRecipe.save();
        InGameRecipeBuilder.addRecipe(yaShapedCraftRecipe);
    }

    /**
     * 添加有序合成并保存文件
     * 
     * @param craftingSource 材料
     * @param craftingResult 产物
     * @param namespacedKey  命名空间
     */
    public static void shaped(@NonNull ItemStack[] craftingSource, @NonNull ItemStack craftingResult)
            throws IOException, RecipeException {
        AdditionShapedCraftRecipe yaShapedCraftRecipe = new AdditionShapedCraftRecipe(craftingSource, craftingResult);

        yaShapedCraftRecipe.save();
        InGameRecipeBuilder.addRecipe(yaShapedCraftRecipe);
    }

    /**
     * 手动添加无序合成并保存文件
     * 
     * @param craftingSource 材料
     * @param craftingResult 成品
     * @param namespacedKey  命名空间
     * @deprecated
     */
    @Deprecated
    public static void shapeless(@NonNull AdditionItemStack[] craftingSource, @NonNull AdditionItemStack craftingResult)
            throws IOException, RecipeException {
        ItemStack[] bukkitCraftingSource = new ItemStack[9];
        for (int i = 0; i < craftingSource.length; i++) {
            bukkitCraftingSource[i] = craftingSource[i].asBukkitCopy();
        }
        AdditionShapelessCraftRecipe yaShapelessCraftRecipe = new AdditionShapelessCraftRecipe(bukkitCraftingSource,
                craftingResult.asBukkitCopy());

        yaShapelessCraftRecipe.save();
        InGameRecipeBuilder.addRecipe(yaShapelessCraftRecipe);
    }

    /**
     * 手动添加无序合成并保存文件
     * 
     * @param craftingSource 材料
     * @param craftingResult 成品
     * @param namespacedKey  命名空间
     */
    public static void shapeless(@NonNull ItemStack[] craftingSource, @NonNull ItemStack craftingResult)
            throws IOException, RecipeException {
        AdditionShapelessCraftRecipe yaShapelessCraftRecipe = new AdditionShapelessCraftRecipe(craftingSource,
                craftingResult);

        yaShapelessCraftRecipe.save();
        InGameRecipeBuilder.addRecipe(yaShapelessCraftRecipe);
    }

    /**
     * 添加熔炉配方并保存文件
     * 
     * @param cookingSource     材料
     * @param cookingResult     产物
     * @param cookingExperience 获得的经验
     * @param cookingTime       烧制时间
     * @param namespacedKey     命名空间
     */
    public static void furnace(@NonNull ItemStack cookingSource, @NonNull ItemStack cookingResult,
            float cookingExperience, int cookingTime) throws IOException, RecipeException {
        AdditionFurnaceRecipe yaFurnaceRecipe = new AdditionFurnaceRecipe(cookingSource, cookingResult,
                cookingExperience, cookingTime);

        yaFurnaceRecipe.save();
        InGameRecipeBuilder.addRecipe(yaFurnaceRecipe);
    }

    /**
     * 添加高炉配方并保存文件
     * 
     * @param cookingSource     材料
     * @param cookingResult     产物
     * @param cookingExperience 获得的经验
     * @param cookingTime       熔炼时间
     * @param namespacedKey     命名空间
     */
    public static void blastFurnace(@NonNull ItemStack cookingSource, @NonNull ItemStack cookingResult,
            float cookingExperience, int cookingTime) throws IOException, RecipeException {
        AdditionBlastFurnaceRecipe yaBlastFurnaceRecipe = new AdditionBlastFurnaceRecipe(cookingSource, cookingResult,
                cookingExperience, cookingTime);

        yaBlastFurnaceRecipe.save();
        InGameRecipeBuilder.addRecipe(yaBlastFurnaceRecipe);
    }

    /**
     * 添加烟熏炉配方并保存文件
     * 
     * @param cookingSource     材料
     * @param cookingResult     产物
     * @param cookingExperience 获得的经验
     * @param cookingTime       烹饪时间
     * @param namespacedKey     命名空间
     */
    public static void smoker(@NonNull ItemStack cookingSource, @NonNull ItemStack cookingResult,
            float cookingExperience, int cookingTime) throws IOException, RecipeException {
        AdditionSmokerRecipe yaSmokerRecipe = new AdditionSmokerRecipe(cookingSource, cookingResult, cookingExperience,
                cookingTime);

        yaSmokerRecipe.save();
        InGameRecipeBuilder.addRecipe(yaSmokerRecipe);
    }

    /**
     * 添加篝火配方并保存文件
     * 
     * @param cookingSource     材料
     * @param cookingResult     产物
     * @param cookingExperience 获得的经验
     * @param cookingTime       烹饪时间
     * @param namespacedKey     命名空间
     */
    public static void campfire(@NonNull ItemStack cookingSource, @NonNull ItemStack cookingResult,
            float cookingExperience, int cookingTime) throws IOException, RecipeException {
        AdditionCampfireRecipe yaCampfireRecipe = new AdditionCampfireRecipe(cookingSource, cookingResult,
                cookingExperience, cookingTime);

        yaCampfireRecipe.save();
        InGameRecipeBuilder.addRecipe(yaCampfireRecipe);
    }

    /**
     * 添加切石机配方并保存文件
     * 
     * @param cuttingSource 材料
     * @param cuttingResult 产物
     * @param namespacedKey 命名空间
     */
    public static void stoneCutter(@NonNull ItemStack cuttingSource, @NonNull ItemStack cuttingResult)
            throws IOException, RecipeException {
        AdditionStoneCutterRecipe yaStoneCutterRecipe = new AdditionStoneCutterRecipe(cuttingSource, cuttingResult);

        yaStoneCutterRecipe.save();
        InGameRecipeBuilder.addRecipe(yaStoneCutterRecipe);
    }

    /**
     * 添加锻造台配方并保存文件
     * 
     * @param smithingBase     基础物品
     * @param smithingAddition 附加物品
     * @param smithingResult   产物
     * @param namespacedKey    命名空间
     */
    public static void smithingTable(@NonNull ItemStack smithingBase, @NonNull ItemStack smithingAddition,
            @NonNull ItemStack smithingResult) throws IOException, RecipeException {
        AdditionSmithingTableRecipe yaSmithingTableRecipe = new AdditionSmithingTableRecipe(smithingBase,
                smithingAddition, smithingResult);

        yaSmithingTableRecipe.save();
        InGameRecipeBuilder.addRecipe(yaSmithingTableRecipe);
    }
}
