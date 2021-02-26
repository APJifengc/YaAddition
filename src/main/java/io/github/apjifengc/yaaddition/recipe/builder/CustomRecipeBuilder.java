
package io.github.apjifengc.yaaddition.recipe.builder;

import io.github.apjifengc.yaaddition.addition.AdditionItemStack;
import io.github.apjifengc.yaaddition.recipe.excption.RecipeException;
import io.github.apjifengc.yaaddition.recipe.recipe.AdditionBlastFurnaceRecipe;
import io.github.apjifengc.yaaddition.recipe.recipe.AdditionCampfireRecipe;
import io.github.apjifengc.yaaddition.recipe.recipe.AdditionFurnaceRecipe;
import io.github.apjifengc.yaaddition.recipe.recipe.AdditionShapedCraftRecipe;
import io.github.apjifengc.yaaddition.recipe.recipe.AdditionShapelessCraftRecipe;
import io.github.apjifengc.yaaddition.recipe.recipe.AdditionSmithingTableRecipe;
import io.github.apjifengc.yaaddition.recipe.recipe.AdditionSmokerRecipe;
import io.github.apjifengc.yaaddition.recipe.recipe.AdditionStoneCutterRecipe;

import java.io.IOException;

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
     */
    public static void shaped(@NonNull AdditionItemStack[] craftingSource, @NonNull AdditionItemStack craftingResult)
            throws IOException, RecipeException
             {
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
     */
    public static void shapeless(@NonNull AdditionItemStack[] craftingSource, @NonNull AdditionItemStack craftingResult)
            throws IOException, RecipeException {
        AdditionShapelessCraftRecipe yaShapelessCraftRecipe = new AdditionShapelessCraftRecipe(craftingSource, craftingResult);

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
    public static void furnace(@NonNull AdditionItemStack cookingSource, @NonNull AdditionItemStack cookingResult,
            float cookingExperience, int cookingTime) throws IOException, RecipeException {
        AdditionFurnaceRecipe yaFurnaceRecipe = new AdditionFurnaceRecipe(cookingSource, cookingResult, cookingExperience,
                cookingTime);

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
    public static void blastFurnace(@NonNull AdditionItemStack cookingSource, @NonNull AdditionItemStack cookingResult,
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
    public static void smoker(@NonNull AdditionItemStack cookingSource, @NonNull AdditionItemStack cookingResult,
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
    public static void campfire(@NonNull AdditionItemStack cookingSource, @NonNull AdditionItemStack cookingResult,
            float cookingExperience, int cookingTime) throws IOException, RecipeException {
        AdditionCampfireRecipe yaCampfireRecipe = new AdditionCampfireRecipe(cookingSource, cookingResult, cookingExperience,
                cookingTime);

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
    public static void stoneCutter(@NonNull AdditionItemStack cuttingSource, @NonNull AdditionItemStack cuttingResult)
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
    public static void smithingTable(@NonNull AdditionItemStack smithingBase, @NonNull AdditionItemStack smithingAddition,
            @NonNull AdditionItemStack smithingResult) throws IOException, RecipeException {
        AdditionSmithingTableRecipe yaSmithingTableRecipe = new AdditionSmithingTableRecipe(smithingBase, smithingAddition,
                smithingResult);

        yaSmithingTableRecipe.save();
        InGameRecipeBuilder.addRecipe(yaSmithingTableRecipe);
    }
}
