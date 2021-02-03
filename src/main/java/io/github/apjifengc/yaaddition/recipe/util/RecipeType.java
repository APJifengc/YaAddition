package io.github.apjifengc.yaaddition.recipe.util;

/**
 * 枚举所有配方类型
 */
public enum RecipeType {
    SHAPED_CRAFT_RECIPE("crafting_table/shaped/", "shaped"),
    SHAPELESS_CRAFT_RECIPE("crafting_table/shapeless/", "shapless"), 
    FURNACE_RECIPE("furnace"), 
    SMOKER_RECIPE("smoker"),
    BLAST_FURNACE_RECIPE("blast_furnace"), 
    CAMPFIRE_RECIPE("campfire"), 
    STONE_CUTTER_RECIPE("stone_cutter"),
    SMITHING_TABLE_RECIPE("smithing_table");

    private final String parentPath = "plugins/YaAddition/recipes/";

    /**
     * @param path 配方保存路径
     */
    private String path;
    /**
     * @param type 配方种类
     */
    private String type;

    private RecipeType(String path, String type) {
        this.path = path;
        this.type = type;
    }

    private RecipeType(String type) {
        this.path = type + "/";
        this.type = type;
    }

    /**
     * @return 配方对应的文件夹路径{@link RecipeType#path}
     */
    public String getPath() {
        return parentPath + this.path;
    }

    /**
     * @return 配方对应的类型的字符串{@link RecipeType#type}
     */
    public String getType() {
        return this.type;
    }
}
