
package io.github.apjifengc.yaaddition.recipe.builder;

import java.io.File;

import io.github.apjifengc.yaaddition.YaAddition;
import io.github.apjifengc.yaaddition.recipe.recipe.YaBlastFurnaceRecipe;
import io.github.apjifengc.yaaddition.recipe.recipe.YaCampfireRecipe;
import io.github.apjifengc.yaaddition.recipe.recipe.YaFurnaceRecipe;
import io.github.apjifengc.yaaddition.recipe.recipe.YaShapedCraftRecipe;
import io.github.apjifengc.yaaddition.recipe.recipe.YaShapelessCraftRecipe;
import io.github.apjifengc.yaaddition.recipe.recipe.YaSmithingTableRecipe;
import io.github.apjifengc.yaaddition.recipe.recipe.YaSmokerRecipe;
import io.github.apjifengc.yaaddition.recipe.recipe.YaStoneCutterRecipe;
import io.github.apjifengc.yaaddition.recipe.util.RecipeType;

import org.bukkit.Bukkit;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.BlastingRecipe;
import org.bukkit.inventory.CampfireRecipe;
import org.bukkit.inventory.FurnaceRecipe;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.RecipeChoice;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.ShapelessRecipe;
import org.bukkit.inventory.SmithingRecipe;
import org.bukkit.inventory.SmokingRecipe;
import org.bukkit.inventory.StonecuttingRecipe;

import lombok.NonNull;

/**
 * 向游戏中添加配方
 */
public class InGameRecipeBuilder {

    private static final char[] alphabet = { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I' };

    /**
     * 从配方添加有序合成
     * 
     * @param recipe {@link YaShapedCraftRecipe}有序合成
     */
    public static void addRecipe(YaShapedCraftRecipe yaShapedCraftRecipeya) {
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
    public static void shaped(@NonNull ItemStack[] craftingSource, @NonNull ItemStack craftingResult,
            @NonNull String namespacedKey) {
        NamespacedKey targetKey = new NamespacedKey(YaAddition.getInstance(), namespacedKey);
        ShapedRecipe targetRecipe = new ShapedRecipe(targetKey, craftingResult);
        targetRecipe.shape("ABC", "DEF", "GHI");

        for (int i = 0; i < 9; i++) {
            if (craftingSource[i] != null) {
                targetRecipe.setIngredient(alphabet[i], craftingSource[i].getType());
            }
        }

        Bukkit.addRecipe(targetRecipe);
    }

    /**
     * 从配方添加无序合成
     * 
     * @param recipe {@link YaShapelessCraftRecipe}无序合成
     */
    public static void addRecipe(YaShapelessCraftRecipe yaShapelessCraftRecipe) {
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
    public static void shapeless(@NonNull ItemStack[] craftingSource, @NonNull ItemStack craftingResult,
            @NonNull String namespacedKey) {
        NamespacedKey targetKey = new NamespacedKey(YaAddition.getInstance(), namespacedKey);
        ShapelessRecipe targetRecipe = new ShapelessRecipe(targetKey, craftingResult);

        for (int i = 0; i < 9; i++) {
            if (craftingSource[i] != null) {
                targetRecipe.addIngredient(craftingSource[i].getType());
            }
        }

        Bukkit.addRecipe(targetRecipe);
    }

    /**
     * 从配方添加熔炉配方
     * 
     * @param recipe {@link YaFurnaceRecipe}熔炉配方
     */
    public static void addRecipe(YaFurnaceRecipe yaFurnaceRecipe) {
        furnace(yaFurnaceRecipe.getResult(), yaFurnaceRecipe.getCookingSource(), yaFurnaceRecipe.getCookingExperience(),
                yaFurnaceRecipe.getCookingTime(), yaFurnaceRecipe.getNamespacedKey());
    }

    /**
     * 手动添加熔炉配方
     * 
     * @param cookingResult     产物
     * @param cookingSource     材料
     * @param cookingExperience 获得的经验
     * @param cookingTime       烧制时间
     * @param namespacedKey     命名空间
     */
    public static void furnace(@NonNull ItemStack cookingSource, @NonNull ItemStack cookingResult,
            float cookingExperience, int cookingTime, @NonNull String namespacedKey) {
        NamespacedKey targetKey = new NamespacedKey(YaAddition.getInstance(), namespacedKey);
        FurnaceRecipe furnaceRecipe = new FurnaceRecipe(targetKey, cookingSource, cookingResult.getType(),
                cookingExperience, cookingTime);
        Bukkit.addRecipe(furnaceRecipe);
    }

    public static void furnace(@NonNull ItemStack cookingSource, @NonNull ItemStack cookingResult,
            float cookingExperience, @NonNull String namespacedKey) {
        furnace(cookingSource, cookingResult, cookingExperience, 200, namespacedKey);
    }

    public static void furnace(@NonNull ItemStack cookingSource, @NonNull ItemStack cookingResult, int cookingTime,
            @NonNull String namespacedKey) {
        furnace(cookingSource, cookingResult, 0, cookingTime, namespacedKey);
    }

    public static void furnace(@NonNull ItemStack cookingSource, @NonNull ItemStack cookingResult,
            @NonNull String namespacedKey) {
        furnace(cookingSource, cookingResult, 0, 200, namespacedKey);
    }

    /**
     * 从配方添加高炉配方
     * 
     * @param recipe {@link YaBlastFurnaceRecipe}高炉配方
     */
    public static void addRecipe(YaBlastFurnaceRecipe yaBlastFurnaceRecipe) {
        blastFurnace(yaBlastFurnaceRecipe.getResult(), yaBlastFurnaceRecipe.getCookingSource(),
                yaBlastFurnaceRecipe.getCookingExperience(), yaBlastFurnaceRecipe.getCookingTime(),
                yaBlastFurnaceRecipe.getNamespacedKey());
    }

    /**
     * 手动添加高炉配方
     * 
     * @param cookingResult     产物
     * @param cookingSource     材料
     * @param cookingExperience 获得的经验
     * @param cookingTime       熔炼时间
     * @param namespacedKey     命名空间
     */
    public static void blastFurnace(@NonNull ItemStack cookingSource, @NonNull ItemStack cookingResult,
            float cookingExperience, int cookingTime, @NonNull String namespacedKey) {
        NamespacedKey targetKey = new NamespacedKey(YaAddition.getInstance(), namespacedKey);
        BlastingRecipe blastingRecipe = new BlastingRecipe(targetKey, cookingSource, cookingResult.getType(),
                cookingExperience, cookingTime);
        Bukkit.addRecipe(blastingRecipe);
    }

    public static void blastFurnace(@NonNull ItemStack cookingSource, @NonNull ItemStack cookingResult,
            float cookingExperience, @NonNull String namespacedKey) {
        blastFurnace(cookingSource, cookingResult, cookingExperience, 100, namespacedKey);
    }

    public static void blastFurnace(@NonNull ItemStack cookingSource, @NonNull ItemStack cookingResult, int cookingTime,
            @NonNull String namespacedKey) {
        blastFurnace(cookingSource, cookingResult, 0, cookingTime, namespacedKey);
    }

    public static void blastFurnace(@NonNull ItemStack cookingSource, @NonNull ItemStack cookingResult,
            @NonNull String namespacedKey) {
        blastFurnace(cookingSource, cookingResult, 0, 100, namespacedKey);
    }

    /**
     * 从配方添加烟熏炉配方
     * 
     * @param recipe {@link YaSmokerRecipe}烟熏炉配方
     */
    public static void addRecipe(YaSmokerRecipe yaSmokerRecipe) {
        smoker(yaSmokerRecipe.getResult(), yaSmokerRecipe.getCookingSource(), yaSmokerRecipe.getCookingExperience(),
                yaSmokerRecipe.getCookingTime(), yaSmokerRecipe.getNamespacedKey());
    }

    /**
     * 手动添加烟熏炉配方
     * 
     * @param cookingResult     产物
     * @param cookingSource     材料
     * @param cookingExperience 获得的经验
     * @param cookingTime       烹饪时间
     * @param namespacedKey     命名空间
     */
    public static void smoker(@NonNull ItemStack cookingSource, @NonNull ItemStack cookingResult,
            float cookingExperience, int cookingTime, @NonNull String namespacedKey) {
        NamespacedKey targetKey = new NamespacedKey(YaAddition.getInstance(), namespacedKey);
        SmokingRecipe smokingRecipe = new SmokingRecipe(targetKey, cookingSource, cookingResult.getType(),
                cookingExperience, cookingTime);
        Bukkit.addRecipe(smokingRecipe);
    }

    public static void smoker(@NonNull ItemStack cookingSource, @NonNull ItemStack cookingResult,
            float cookingExperience, @NonNull String namespacedKey) {
        smoker(cookingSource, cookingResult, cookingExperience, 100, namespacedKey);
    }

    public static void smoker(@NonNull ItemStack cookingSource, @NonNull ItemStack cookingResult, int cookingTime,
            @NonNull String namespacedKey) {
        smoker(cookingSource, cookingResult, 0, cookingTime, namespacedKey);
    }

    public static void smoker(@NonNull ItemStack cookingSource, @NonNull ItemStack cookingResult,
            @NonNull String namespacedKey) {
        smoker(cookingSource, cookingResult, 0, 100, namespacedKey);
    }

    /**
     * 从配方添加篝火配方
     * 
     * @param recipe {@link YaCampfireRecipe}篝火配方
     */
    public static void addRecipe(YaCampfireRecipe yaCampfireRecipe) {
        campfire(yaCampfireRecipe.getResult(), yaCampfireRecipe.getCookingSource(),
                yaCampfireRecipe.getCookingExperience(), yaCampfireRecipe.getCookingTime(),
                yaCampfireRecipe.getNamespacedKey());
    }

    /**
     * 手动添加篝火配方
     * 
     * @param cookingResult     产物
     * @param cookingSource     材料
     * @param cookingExperience 获得的经验
     * @param cookingTime       烹饪时间
     * @param namespacedKey     命名空间
     */
    public static void campfire(@NonNull ItemStack cookingSource, @NonNull ItemStack cookingResult,
            float cookingExperience, int cookingTime, @NonNull String namespacedKey) {
        NamespacedKey targetKey = new NamespacedKey(YaAddition.getInstance(), namespacedKey);
        CampfireRecipe campfireRecipe = new CampfireRecipe(targetKey, cookingSource, cookingResult.getType(),
                cookingExperience, cookingTime);
        Bukkit.addRecipe(campfireRecipe);
    }

    public static void campfire(@NonNull ItemStack cookingSource, @NonNull ItemStack cookingResult,
            float cookingExperience, @NonNull String namespacedKey) {
        campfire(cookingSource, cookingResult, cookingExperience, 100, namespacedKey);
    }

    public static void campfire(@NonNull ItemStack cookingSource, @NonNull ItemStack cookingResult, int cookingTime,
            @NonNull String namespacedKey) {
        campfire(cookingSource, cookingResult, 0, cookingTime, namespacedKey);
    }

    public static void campfire(@NonNull ItemStack cookingSource, @NonNull ItemStack cookingResult,
            @NonNull String namespacedKey) {
        campfire(cookingSource, cookingResult, 0, 100, namespacedKey);
    }

    /**
     * 从配方添加切石机配方
     * 
     * @param recipe {@link YaStoneCutterRecipe}切石机配方
     */
    public static void addRecipe(YaStoneCutterRecipe yaStoneCutterRecipe) {
        stoneCutter(yaStoneCutterRecipe.getCuttingSource(), yaStoneCutterRecipe.getResult(),
                yaStoneCutterRecipe.getNamespacedKey());
    }

    /**
     * 手动添加切石机配方
     * 
     * @param cuttingResult 产物
     * @param cuttingSource 材料
     * @param namespacedKey 命名空间
     */
    public static void stoneCutter(@NonNull ItemStack cuttingSource, @NonNull ItemStack cuttingResult,
            @NonNull String namespacedKey) {
        NamespacedKey targetKey = new NamespacedKey(YaAddition.getInstance(), namespacedKey);
        StonecuttingRecipe stonecuttingRecipe = new StonecuttingRecipe(targetKey, cuttingResult,
                cuttingSource.getType());
        Bukkit.addRecipe(stonecuttingRecipe);
    }

    /**
     * 从配方添加锻造台配方
     * 
     * @param recipe {@link YaSmithingTableRecipe}锻造台配方
     */
    public static void addRecipe(YaSmithingTableRecipe yaSmithingTableRecipe) {
        smithingTable(yaSmithingTableRecipe.getSmithingBase(), yaSmithingTableRecipe.getSmithingAddition(),
                yaSmithingTableRecipe.getResult(), yaSmithingTableRecipe.getNamespacedKey());
    }

    /**
     * 手动添加锻造台配方
     * 
     * @param smithingResult   产物
     * @param smithingBase     基础物品
     * @param smithingAddition 附加物品
     * @param namespacedKey    命名空间
     */
    public static void smithingTable(@NonNull ItemStack smithingBase, @NonNull ItemStack smithingAddition,
            @NonNull ItemStack smithingResult, @NonNull String namespacedKey) {
        NamespacedKey targetKey = new NamespacedKey(YaAddition.getInstance(), namespacedKey);
        SmithingRecipe smithingRecipe = new SmithingRecipe(targetKey, smithingResult,
                new RecipeChoice.MaterialChoice(smithingBase.getType()),
                new RecipeChoice.MaterialChoice(smithingAddition.getType()));
        Bukkit.addRecipe(smithingRecipe);
    }

    /**
     * 从配置文件加载所有配方
     */
    public static void buildAll() {
        String[] recipes = new File(RecipeType.SHAPED_CRAFT_RECIPE.getPath()).list();

        if (recipes != null) {

            for (String recipe : recipes) {
                YaShapedCraftRecipe yaShapedCraftRecipe = new YaShapedCraftRecipe();

                try {
                    yaShapedCraftRecipe.load(recipe);
                } catch (Exception e) {
                    System.err.println("[YaRecipeManager] Error qwq " + e);
                }

                addRecipe(yaShapedCraftRecipe);
            }
        }

        recipes = new File(RecipeType.SHAPELESS_CRAFT_RECIPE.getPath()).list();

        if (recipes != null) {

            for (String recipe : recipes) {
                YaShapelessCraftRecipe yaShapelessCraftRecipe = new YaShapelessCraftRecipe();

                try {
                    yaShapelessCraftRecipe.load(recipe);
                } catch (Exception e) {
                    System.err.println("[YaRecipeManager] Error qwq " + e);
                }

                addRecipe(yaShapelessCraftRecipe);
            }
        }

        recipes = new File(RecipeType.FURNACE_RECIPE.getPath()).list();

        if (recipes != null) {

            for (String recipe : recipes) {
                YaFurnaceRecipe yaFurnaceRecipe = new YaFurnaceRecipe();

                try {
                    yaFurnaceRecipe.load(recipe);
                } catch (Exception e) {
                    System.err.println("[YaRecipeManager] Error qwq " + e);
                }

                addRecipe(yaFurnaceRecipe);
            }
        }

        recipes = new File(RecipeType.SMOKER_RECIPE.getPath()).list();

        if (recipes != null) {

            for (String recipe : recipes) {
                YaSmokerRecipe yaSmokerRecipe = new YaSmokerRecipe();

                try {
                    yaSmokerRecipe.load(recipe);
                } catch (Exception e) {
                    System.err.println("[YaRecipeManager] Error qwq " + e);
                }

                addRecipe(yaSmokerRecipe);
            }
        }

        recipes = new File(RecipeType.BLAST_FURNACE_RECIPE.getPath()).list();

        if (recipes != null) {

            for (String recipe : recipes) {
                YaBlastFurnaceRecipe yabBlastFurnaceRecipe = new YaBlastFurnaceRecipe();

                try {
                    yabBlastFurnaceRecipe.load(recipe);
                } catch (Exception e) {
                    System.err.println("[YaRecipeManager] Error qwq " + e);
                }

                addRecipe(yabBlastFurnaceRecipe);
            }
        }

        recipes = new File(RecipeType.CAMPFIRE_RECIPE.getPath()).list();

        if (recipes != null) {

            for (String recipe : recipes) {
                YaCampfireRecipe yaCampfireRecipe = new YaCampfireRecipe();

                try {
                    yaCampfireRecipe.load(recipe);
                } catch (Exception e) {
                    System.err.println("[YaRecipeManager] Error qwq " + e);
                }

                addRecipe(yaCampfireRecipe);
            }
        }

        recipes = new File(RecipeType.STONE_CUTTER_RECIPE.getPath()).list();

        if (recipes != null) {

            for (String recipe : recipes) {
                YaStoneCutterRecipe yaStoneCutterRecipe = new YaStoneCutterRecipe();

                try {
                    yaStoneCutterRecipe.load(recipe);
                } catch (Exception e) {
                    System.err.println("[YaRecipeManager] Error qwq " + e);
                }

                addRecipe(yaStoneCutterRecipe);
            }
        }

        recipes = new File(RecipeType.SMITHING_TABLE_RECIPE.getPath()).list();

        if (recipes != null) {

            for (String recipe : recipes) {
                YaSmithingTableRecipe yaSmithingTableRecipe = new YaSmithingTableRecipe();

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
