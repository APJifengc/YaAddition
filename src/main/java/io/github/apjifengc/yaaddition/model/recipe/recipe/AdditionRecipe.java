package io.github.apjifengc.yaaddition.model.recipe.recipe;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.FileAlreadyExistsException;
import java.util.Map;

import io.github.apjifengc.yaaddition.exception.IncompleteRecipeException;
import io.github.apjifengc.yaaddition.exception.RecipeException;
import io.github.apjifengc.yaaddition.exception.WrongRecipeTypeException;
import io.github.apjifengc.yaaddition.model.recipe.util.RecipeType;

import org.bukkit.inventory.ItemStack;
import org.bukkit.util.io.BukkitObjectOutputStream;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

/**
 * 所有配方的父类
 */
public abstract class AdditionRecipe {

    @Getter
    @Setter
    protected RecipeType type;
    @Getter
    @Setter
    protected String namespacedKey;
    @Getter
    protected ItemStack result;

    /**
     * 设置产品并生成命名空间
     * 
     * @param result 产品
     */
    public void setResult(@NonNull ItemStack result) {
        this.result = result;
        namespacedKeyGen(this.result, this.type);
    }

    /**
     * 将配方保存为文件，路径为{@link RecipeType#getPath()}
     */
    public abstract void save() throws IOException, RecipeException;

    /**
     * 将参数保存为文件
     * 
     * @param map
     */
    protected void save(Map<String, Object> map) throws IOException {
        String filePath = this.type.getPath() + this.namespacedKey + ".recipe";
        File file = new File(filePath);
        if (file.exists()) {
            throw new FileAlreadyExistsException(filePath);
        } else {
            file.mkdirs();

            try (BukkitObjectOutputStream oos = new BukkitObjectOutputStream(new FileOutputStream(file));) {
                oos.writeObject(map);
            }
        }
    }

    /**
     * 从文件名加载配方，路径为{@link RecipeType#getPath()}
     * 
     * @param fileName 配方文件名
     */
    public void load(@NonNull String fileName) throws IOException, RecipeException, ClassNotFoundException {
        String path = this.type.getPath() + fileName;
        load(new File(path));
    }

    /**
     * 从文件加载配方
     * 
     * @param file 配方文件
     */
    public abstract void load(@NonNull File file) throws IOException, RecipeException, ClassNotFoundException;

    /**
     * 检测配方是否残缺
     * 
     * @return 如果残缺返回true否则返回false
     */
    public abstract boolean isIncomplete();

    /**
     * 检测配方类型是否错误
     * 
     * @return 如果错误返回true否则返回false
     */
    public abstract boolean isIncorrectType();

    /**
     * 检测配方类型是与输入的类型不符
     * 
     * @return 如果不符返回true否则返回false
     */
    protected boolean isIncorrectType(RecipeType recipeType) {
        return !this.type.equals(recipeType);
    }

    /**
     * 自检并抛出异常
     * 
     * @throws RecipeException
     */
    protected void selfCheck() throws RecipeException {
        if (isIncorrectType()) {
            throw new WrongRecipeTypeException(this.type.getType());
        }
        if (isIncomplete()) {
            throw new IncompleteRecipeException();
        }
    }

    /**
     * 通过产品和配方种类生成命名空间
     * 
     * @param result 产品
     * @param type   配方种类
     */
    protected void namespacedKeyGen(@NonNull ItemStack result, @NonNull RecipeType type) {
        // 生成NamespacedKey
        String recipeName = result.getType().name() + "_" + type.getType() + "_";

        for (int i = 0;; i++) {
            this.namespacedKey = recipeName + i;

            if (!new File(type.getPath() + this.namespacedKey + ".recipe").exists()) {
                break;
            }
        }
    }
}
