package io.github.apjifengc.yaaddition.recipe.recipe;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.FileAlreadyExistsException;
import java.util.Map;

import io.github.apjifengc.yaaddition.recipe.util.RecipeType;

import org.bukkit.inventory.ItemStack;
import org.bukkit.util.io.BukkitObjectOutputStream;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

/**
 * 所有配方的父类
 */
public class YaRecipe {

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
