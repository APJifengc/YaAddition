package io.github.apjifengc.yaaddition.recipe.recipe;

import org.bukkit.inventory.ItemStack;
import org.bukkit.util.io.BukkitObjectInputStream;
import org.bukkit.util.io.BukkitObjectOutputStream;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.FileAlreadyExistsException;
import java.util.HashMap;

import io.github.apjifengc.yaaddition.recipe.excption.IncompleteRecipeException;
import io.github.apjifengc.yaaddition.recipe.excption.WrongRecipeTypeException;
import io.github.apjifengc.yaaddition.recipe.util.RecipeType;

public class YaStoneCutterRecipe extends YaRecipe {

    @Getter
    @Setter
    protected ItemStack cuttingSource;

    /**
     * 新建空的切石配方
     */
    public YaStoneCutterRecipe() {
        this.type = RecipeType.STONE_CUTTER_RECIPE;
    }

    /**
     * 新建切石配方
     * 
     * @param cuttingSource 材料
     * @param cuttingResult 产品
     */
    public YaStoneCutterRecipe(@NonNull ItemStack cuttingSource, @NonNull ItemStack cuttingResult) {
        this.cuttingSource = cuttingSource;
        this.result = cuttingResult;
        this.type = RecipeType.STONE_CUTTER_RECIPE;
        namespacedKeyGen(this.result, this.type);
    }

    /**
     * 将配方保存为文件，路径为{@link RecipeType#getPath()}
     */
    public void save() throws IOException {
        HashMap<String, Object> map = new HashMap<>();
        map.put("type", this.type);
        map.put("result", this.result);
        map.put("cuttingSource", this.cuttingSource);
        save(map);
    }

    /**
     * 从文件名加载配方，路径为{@link RecipeType#getPath()}
     * 
     * @param fileName 配方文件名
     */
    public void load(@NonNull String fileName) throws Exception {
        String path = this.type.getPath() + fileName;
        load(new File(path));
    }

    /**
     * 从文件加载配方
     * 
     * @param file 配方文件
     */
    public void load(@NonNull File file) throws Exception {
        try (BukkitObjectInputStream ois = new BukkitObjectInputStream(new FileInputStream(file));) {
            HashMap<String, Object> map = new HashMap<>();
            Object readMap = ois.readObject();

            if (readMap instanceof HashMap) {
                map.putAll((HashMap) readMap);
                setResult((ItemStack) map.get("result"));
                this.cuttingSource = (ItemStack) map.get("cuttingSource");
                this.type = (RecipeType) map.get("type");
                if (!this.type.equals(RecipeType.STONE_CUTTER_RECIPE)) {
                    throw new WrongRecipeTypeException(file.getAbsolutePath());
                } else if (isIncomplete()) {
                    throw new IncompleteRecipeException(file.getAbsolutePath());
                }
            }
        }
    }

    /**
     * 检测配方是否完整
     * 
     * @return 如果完整返回true否则返回false
     */
    private boolean isIncomplete() {
        return this.cuttingSource == null || this.result == null;
    }
}
