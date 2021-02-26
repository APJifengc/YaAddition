
package io.github.apjifengc.yaaddition.recipe.builder;

import io.github.apjifengc.yaaddition.recipe.recipe.YaBlastFurnaceRecipe;
import io.github.apjifengc.yaaddition.recipe.recipe.YaCampfireRecipe;
import io.github.apjifengc.yaaddition.recipe.recipe.YaFurnaceRecipe;
import io.github.apjifengc.yaaddition.recipe.recipe.YaShapedCraftRecipe;
import io.github.apjifengc.yaaddition.recipe.recipe.YaShapelessCraftRecipe;
import io.github.apjifengc.yaaddition.recipe.recipe.YaSmithingTableRecipe;
import io.github.apjifengc.yaaddition.recipe.recipe.YaSmokerRecipe;
import io.github.apjifengc.yaaddition.recipe.recipe.YaStoneCutterRecipe;

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
     */
    public static void shaped(@NonNull ItemStack[] craftingSource, @NonNull ItemStack craftingResult)
            throws Exception {
        YaShapedCraftRecipe yaShapedCraftRecipe = new YaShapedCraftRecipe(craftingSource, craftingResult);

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
    public static void shapeless(@NonNull ItemStack[] craftingSource, @NonNull ItemStack craftingResult)
            throws Exception {
        YaShapelessCraftRecipe yaShapelessCraftRecipe = new YaShapelessCraftRecipe(craftingSource, craftingResult);

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
            float cookingExperience, int cookingTime) throws Exception {
        YaFurnaceRecipe yaFurnaceRecipe = new YaFurnaceRecipe(cookingSource, cookingResult, cookingExperience,
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
    public static void blastFurnace(@NonNull ItemStack cookingSource, @NonNull ItemStack cookingResult,
            float cookingExperience, int cookingTime) throws Exception {
        YaBlastFurnaceRecipe yaBlastFurnaceRecipe = new YaBlastFurnaceRecipe(cookingSource, cookingResult,
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
            float cookingExperience, int cookingTime) throws Exception {
        YaSmokerRecipe yaSmokerRecipe = new YaSmokerRecipe(cookingSource, cookingResult, cookingExperience,
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
            float cookingExperience, int cookingTime) throws Exception {
        YaCampfireRecipe yaCampfireRecipe = new YaCampfireRecipe(cookingSource, cookingResult, cookingExperience,
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
    public static void stoneCutter(@NonNull ItemStack cuttingSource, @NonNull ItemStack cuttingResult)
            throws Exception {
        YaStoneCutterRecipe yaStoneCutterRecipe = new YaStoneCutterRecipe(cuttingSource, cuttingResult);

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
            @NonNull ItemStack smithingResult) throws Exception {
        YaSmithingTableRecipe yaSmithingTableRecipe = new YaSmithingTableRecipe(smithingBase, smithingAddition,
                smithingResult);

        yaSmithingTableRecipe.save();
        InGameRecipeBuilder.addRecipe(yaSmithingTableRecipe);
    }
}
