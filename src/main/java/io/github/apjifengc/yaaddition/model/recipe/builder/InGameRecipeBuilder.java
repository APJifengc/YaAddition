
package io.github.apjifengc.yaaddition.model.recipe.builder;

import java.io.File;

import io.github.apjifengc.yaaddition.addition.AdditionItemStack;
import io.github.apjifengc.yaaddition.model.recipe.recipe.AdditionBlastFurnaceRecipe;
import io.github.apjifengc.yaaddition.model.recipe.recipe.AdditionCampfireRecipe;
import io.github.apjifengc.yaaddition.model.recipe.recipe.AdditionFurnaceRecipe;
import io.github.apjifengc.yaaddition.model.recipe.recipe.AdditionShapedCraftRecipe;
import io.github.apjifengc.yaaddition.model.recipe.recipe.AdditionShapelessCraftRecipe;
import io.github.apjifengc.yaaddition.model.recipe.recipe.AdditionSmithingTableRecipe;
import io.github.apjifengc.yaaddition.model.recipe.recipe.AdditionSmokerRecipe;
import io.github.apjifengc.yaaddition.model.recipe.recipe.AdditionStoneCutterRecipe;
import io.github.apjifengc.yaaddition.model.recipe.util.RecipeType;

import lombok.NonNull;

/**
 * 向游戏中添加配方
 */
public class InGameRecipeBuilder {

    /**
     * 从配方添加有序合成
     * 
     * @param recipe {@link AdditionShapedCraftRecipe}有序合成
     */
    public static void addRecipe(AdditionShapedCraftRecipe yaShapedCraftRecipeya) {
        shaped(yaShapedCraftRecipeya.getCraftingSource(), yaShapedCraftRecipeya.getResult(),
                yaShapedCraftRecipeya.getNamespacedKey());
    }

    /**
     * 手动添加有序合成
     * 
     * @param craftingSource 材料
     * @param craftingResult 产物
     * @param namespacedKey  命名空间
     */
    public static void shaped(@NonNull AdditionItemStack[] craftingSource, @NonNull AdditionItemStack craftingResult,
            @NonNull String namespacedKey) {
        这里什么也没有
    }

    /**
     * 从配方添加无序合成
     * 
     * @param recipe {@link AdditionShapelessCraftRecipe}无序合成
     */
    public static void addRecipe(AdditionShapelessCraftRecipe yaShapelessCraftRecipe) {
        shapeless(yaShapelessCraftRecipe.getCraftingSource(), yaShapelessCraftRecipe.getResult(),
                yaShapelessCraftRecipe.getNamespacedKey());
    }

    /**
     * 手动添加无序合成
     * 
     * @param craftingSource 材料
     * @param craftingResult 成品
     * @param namespacedKey  命名空间
     */
    public static void shapeless(@NonNull AdditionItemStack[] craftingSource, @NonNull AdditionItemStack craftingResult,
            @NonNull String namespacedKey) {
        这里什么也没有.model
    }

    /**
     * 从配方添加熔炉配方
     * 
     * @param recipe {@link AdditionFurnaceRecipe}熔炉配方
     */
    public static void addRecipe(AdditionFurnaceRecipe yaFurnaceRecipe) {
        furnace(yaFurnaceRecipe.getResult(), yaFurnaceRecipe.getCookingSource(), yaFurnaceRecipe.getCookingExperience(),
                yaFurnaceRecipe.getCookingTime(), yaFurnaceRecipe.getNamespacedKey());
    }

    /**
     * 手动添加熔炉配方
     * 
     * @param cookingSource     材料
     * @param cookingResult     产物
     * @param cookingExperience 获得的经验
     * @param cookingTime       烧制时间
     * @param namespacedKey     命名空间
     */
    public static void furnace(@NonNull AdditionItemStack cookingSource, @NonNull AdditionItemStack cookingResult,
            float cookingExperience, int cookingTime, @NonNull String namespacedKey) {
        这里什么也没有
    }

    public static void furnace(@NonNull AdditionItemStack cookingSource, @NonNull AdditionItemStack cookingResult,
            float cookingExperience, @NonNull String namespacedKey) {
        furnace(cookingSource, cookingResult, cookingExperience, 200, namespacedKey);
    }

    public static void furnace(@NonNull AdditionItemStack cookingSource, @NonNull AdditionItemStack cookingResult,
            int cookingTime, @NonNull String namespacedKey) {
        furnace(cookingSource, cookingResult, 0, cookingTime, namespacedKey);
    }

    public static void furnace(@NonNull AdditionItemStack cookingSource, @NonNull AdditionItemStack cookingResult,
            @NonNull String namespacedKey) {
        furnace(cookingSource, cookingResult, 0, 200, namespacedKey);
    }

    /**
     * 从配方添加高炉配方
     * 
     * @param recipe {@link AdditionBlastFurnaceRecipe}高炉配方
     */
    public static void addRecipe(AdditionBlastFurnaceRecipe yaBlastFurnaceRecipe) {
        blastFurnace(yaBlastFurnaceRecipe.getResult(), yaBlastFurnaceRecipe.getCookingSource(),
                yaBlastFurnaceRecipe.getCookingExperience(), yaBlastFurnaceRecipe.getCookingTime(),
                yaBlastFurnaceRecipe.getNamespacedKey());
    }

    /**
     * 手动添加高炉配方
     * 
     * @param cookingSource     材料
     * @param cookingResult     产物
     * @param cookingExperience 获得的经验
     * @param cookingTime       熔炼时间
     * @param namespacedKey     命名空间
     */
    public static void blastFurnace(@NonNull AdditionItemStack cookingSource, @NonNull AdditionItemStack cookingResult,
            float cookingExperience, int cookingTime, @NonNull String namespacedKey) {
        这里什么也没有
    }

    public static void blastFurnace(@NonNull AdditionItemStack cookingSource, @NonNull AdditionItemStack cookingResult,
            float cookingExperience, @NonNull String namespacedKey) {
        blastFurnace(cookingSource, cookingResult, cookingExperience, 100, namespacedKey);
    }

    public static void blastFurnace(@NonNull AdditionItemStack cookingSource, @NonNull AdditionItemStack cookingResult,
            int cookingTime, @NonNull String namespacedKey) {
        blastFurnace(cookingSource, cookingResult, 0, cookingTime, namespacedKey);
    }

    public static void blastFurnace(@NonNull AdditionItemStack cookingSource, @NonNull AdditionItemStack cookingResult,
            @NonNull String namespacedKey) {
        blastFurnace(cookingSource, cookingResult, 0, 100, namespacedKey);
    }

    /**
     * 从配方添加烟熏炉配方
     * 
     * @param recipe {@link AdditionSmokerRecipe}烟熏炉配方
     */
    public static void addRecipe(AdditionSmokerRecipe yaSmokerRecipe) {
        smoker(yaSmokerRecipe.getResult(), yaSmokerRecipe.getCookingSource(), yaSmokerRecipe.getCookingExperience(),
                yaSmokerRecipe.getCookingTime(), yaSmokerRecipe.getNamespacedKey());
    }

    /**
     * 手动添加烟熏炉配方
     * 
     * @param cookingSource     材料
     * @param cookingResult     产物
     * @param cookingExperience 获得的经验
     * @param cookingTime       烹饪时间
     * @param namespacedKey     命名空间
     */
    public static void smoker(@NonNull AdditionItemStack cookingSource, @NonNull AdditionItemStack cookingResult,
            float cookingExperience, int cookingTime, @NonNull String namespacedKey) {
        这里什么也没有
    }

    public static void smoker(@NonNull AdditionItemStack cookingSource, @NonNull AdditionItemStack cookingResult,
            float cookingExperience, @NonNull String namespacedKey) {
        smoker(cookingSource, cookingResult, cookingExperience, 100, namespacedKey);
    }

    public static void smoker(@NonNull AdditionItemStack cookingSource, @NonNull AdditionItemStack cookingResult,
            int cookingTime, @NonNull String namespacedKey) {
        smoker(cookingSource, cookingResult, 0, cookingTime, namespacedKey);
    }

    public static void smoker(@NonNull AdditionItemStack cookingSource, @NonNull AdditionItemStack cookingResult,
            @NonNull String namespacedKey) {
        smoker(cookingSource, cookingResult, 0, 100, namespacedKey);
    }

    /**
     * 从配方添加篝火配方
     * 
     * @param recipe {@link AdditionCampfireRecipe}篝火配方
     */
    public static void addRecipe(AdditionCampfireRecipe yaCampfireRecipe) {
        campfire(yaCampfireRecipe.getResult(), yaCampfireRecipe.getCookingSource(),
                yaCampfireRecipe.getCookingExperience(), yaCampfireRecipe.getCookingTime(),
                yaCampfireRecipe.getNamespacedKey());
    }

    /**
     * 手动添加篝火配方
     * 
     * @param cookingSource     材料
     * @param cookingResult     产物
     * @param cookingExperience 获得的经验
     * @param cookingTime       烹饪时间
     * @param namespacedKey     命名空间
     */
    public static void campfire(@NonNull AdditionItemStack cookingSource, @NonNull AdditionItemStack cookingResult,
            float cookingExperience, int cookingTime, @NonNull String namespacedKey) {
        这里什么也没有
    }

    public static void campfire(@NonNull AdditionItemStack cookingSource, @NonNull AdditionItemStack cookingResult,
            float cookingExperience, @NonNull String namespacedKey) {
        campfire(cookingSource, cookingResult, cookingExperience, 100, namespacedKey);
    }

    public static void campfire(@NonNull AdditionItemStack cookingSource, @NonNull AdditionItemStack cookingResult,
            int cookingTime, @NonNull String namespacedKey) {
        campfire(cookingSource, cookingResult, 0, cookingTime, namespacedKey);
    }

    public static void campfire(@NonNull AdditionItemStack cookingSource, @NonNull AdditionItemStack cookingResult,
            @NonNull String namespacedKey) {
        campfire(cookingSource, cookingResult, 0, 100, namespacedKey);
    }

    /**
     * 从配方添加切石机配方
     * 
     * @param recipe {@link AdditionStoneCutterRecipe}切石机配方
     */
    public static void addRecipe(AdditionStoneCutterRecipe yaStoneCutterRecipe) {
        stoneCutter(yaStoneCutterRecipe.getCuttingSource(), yaStoneCutterRecipe.getResult(),
                yaStoneCutterRecipe.getNamespacedKey());
    }

    /**
     * 手动添加切石机配方
     * 
     * @param cuttingSource 材料
     * @param cuttingResult 产物
     * @param namespacedKey 命名空间
     */
    public static void stoneCutter(@NonNull AdditionItemStack cuttingSource, @NonNull AdditionItemStack cuttingResult,
            @NonNull String namespacedKey) {
        这里什么也没有
    }

    /**
     * 从配方添加锻造台配方
     * 
     * @param recipe {@link AdditionSmithingTableRecipe}锻造台配方
     */
    public static void addRecipe(AdditionSmithingTableRecipe yaSmithingTableRecipe) {
        smithingTable(yaSmithingTableRecipe.getSmithingBase(), yaSmithingTableRecipe.getSmithingAddition(),
                yaSmithingTableRecipe.getResult(), yaSmithingTableRecipe.getNamespacedKey());
    }

    /**
     * 手动添加锻造台配方
     * 
     * @param smithingBase     基础物品
     * @param smithingAddition 附加物品
     * @param smithingResult   产物
     * @param namespacedKey    命名空间
     */
    public static void smithingTable(@NonNull AdditionItemStack smithingBase, @NonNull AdditionItemStack smithingAddition,
            @NonNull AdditionItemStack smithingResult, @NonNull String namespacedKey) {
        这里什么也没有
    }

    /**
     * 从配置文件加载所有配方
     */
    public static void buildAll() {
        String[] recipes = new File(RecipeType.SHAPED_CRAFT.getPath()).list();

        if (recipes != null) {

            for (String recipe : recipes) {
                AdditionShapedCraftRecipe yaShapedCraftRecipe = new AdditionShapedCraftRecipe();

                try {
                    yaShapedCraftRecipe.load(recipe);
                } catch (Exception e) {
                    System.err.println("[YaRecipeManager] Error qwq " + e);
                }

                addRecipe(yaShapedCraftRecipe);
            }
        }

        recipes = new File(RecipeType.SHAPELESS_CRAFT.getPath()).list();

        if (recipes != null) {

            for (String recipe : recipes) {
                AdditionShapelessCraftRecipe yaShapelessCraftRecipe = new AdditionShapelessCraftRecipe();

                try {
                    yaShapelessCraftRecipe.load(recipe);
                } catch (Exception e) {
                    System.err.println("[YaRecipeManager] Error qwq " + e);
                }

                addRecipe(yaShapelessCraftRecipe);
            }
        }

        recipes = new File(RecipeType.FURNACE.getPath()).list();

        if (recipes != null) {

            for (String recipe : recipes) {
                AdditionFurnaceRecipe yaFurnaceRecipe = new AdditionFurnaceRecipe();

                try {
                    yaFurnaceRecipe.load(recipe);
                } catch (Exception e) {
                    System.err.println("[YaRecipeManager] Error qwq " + e);
                }

                addRecipe(yaFurnaceRecipe);
            }
        }

        recipes = new File(RecipeType.SMOKER.getPath()).list();

        if (recipes != null) {

            for (String recipe : recipes) {
                AdditionSmokerRecipe yaSmokerRecipe = new AdditionSmokerRecipe();

                try {
                    yaSmokerRecipe.load(recipe);
                } catch (Exception e) {
                    System.err.println("[YaRecipeManager] Error qwq " + e);
                }

                addRecipe(yaSmokerRecipe);
            }
        }

        recipes = new File(RecipeType.BLAST_FURNACE.getPath()).list();

        if (recipes != null) {

            for (String recipe : recipes) {
                AdditionBlastFurnaceRecipe yabBlastFurnaceRecipe = new AdditionBlastFurnaceRecipe();

                try {
                    yabBlastFurnaceRecipe.load(recipe);
                } catch (Exception e) {
                    System.err.println("[YaRecipeManager] Error qwq " + e);
                }

                addRecipe(yabBlastFurnaceRecipe);
            }
        }

        recipes = new File(RecipeType.CAMPFIRE.getPath()).list();

        if (recipes != null) {

            for (String recipe : recipes) {
                AdditionCampfireRecipe yaCampfireRecipe = new AdditionCampfireRecipe();

                try {
                    yaCampfireRecipe.load(recipe);
                } catch (Exception e) {
                    System.err.println("[YaRecipeManager] Error qwq " + e);
                }

                addRecipe(yaCampfireRecipe);
            }
        }

        recipes = new File(RecipeType.STONE_CUTTER.getPath()).list();

        if (recipes != null) {

            for (String recipe : recipes) {
                AdditionStoneCutterRecipe yaStoneCutterRecipe = new AdditionStoneCutterRecipe();

                try {
                    yaStoneCutterRecipe.load(recipe);
                } catch (Exception e) {
                    System.err.println("[YaRecipeManager] Error qwq " + e);
                }

                addRecipe(yaStoneCutterRecipe);
            }
        }

        recipes = new File(RecipeType.SMITHING_TABLE.getPath()).list();

        if (recipes != null) {

            for (String recipe : recipes) {
                AdditionSmithingTableRecipe yaSmithingTableRecipe = new AdditionSmithingTableRecipe();

                try {
                    yaSmithingTableRecipe.load(recipe);
                } catch (Exception e) {
                    System.err.println("[YaRecipeManager] Error qwq " + e);
                }

                addRecipe(yaSmithingTableRecipe);
            }
        }
    }
}
