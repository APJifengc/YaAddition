package io.github.apjifengc.yaaddition.addition;

import io.github.bananapuncher714.nbteditor.NBTEditor;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Map;

public class AdditionItemStack {
    private final YamlConfiguration data = new YamlConfiguration();
    private final AdditionMaterial material;
    private final int amount;

    public AdditionItemStack(final AdditionMaterial material, int amount) {
        this.material = material;
        this.amount = amount;
    }

    public AdditionItemStack(final AdditionMaterial material) {
        this(material, 1);
    }

    public AdditionItemStack(final String material) {
        this(AdditionMaterial.byId(material), 1);
    }

    public AdditionItemStack(final String material, int amount) {
        this(AdditionMaterial.byId(material), 1);
    }

    public ItemStack asBukkitCopy() {
        ItemStack itemStack = new ItemStack(material.getBaseMaterial(), amount);
        ItemMeta itemMeta = itemStack.getItemMeta();
        itemMeta.setCustomModelData(material.getState().getId());

    }

    public static AdditionItemStack fromBukkitCopy() {

    }

    private ItemStack saveDataToNBT(ItemStack stack) {
        for (Map.Entry<String, Object> entry : data.getValues(true).entrySet()) {
            stack = NBTEditor.set(stack, entry.getValue(), entry.getKey());
        }
        return stack;
    }

    private void saveNBTToData(ItemStack stack, String path) {
        NBTEditor.getKeys()
    }
}
