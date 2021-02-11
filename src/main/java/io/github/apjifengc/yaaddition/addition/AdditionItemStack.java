package io.github.apjifengc.yaaddition.addition;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import io.github.apjifengc.yaaddition.util.Data;
import io.github.bananapuncher714.nbteditor.NBTEditor;
import lombok.Getter;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Map;

public class AdditionItemStack {
    @Getter private final AdditionMaterial material;
    @Getter private final int amount;
    @Getter private final Data data;
    private final ItemStack itemStack;

    public AdditionItemStack(final AdditionMaterial material, int amount, Data data) {
        itemStack = new ItemStack(material.getBaseMaterial(), amount);
        this.material = material;
        this.amount = amount;
        this.data = data;
        ItemMeta itemMeta = itemStack.getItemMeta();
        itemMeta.setCustomModelData(material.getState().getId());
        itemMeta.setDisplayName(material.getName());
        itemMeta.setLore(material.getLore());
        itemStack.setItemMeta(itemMeta);
    }

    //<editor-fold desc="Constructors">
    public AdditionItemStack(final AdditionMaterial material, Data data) {
        this(material, 1, data);
    }

    public AdditionItemStack(final String material, Data data) {
        this(AdditionMaterial.byId(material), 1, data);
    }

    public AdditionItemStack(final String material, int amount, Data data) {
        this(AdditionMaterial.byId(material), 1, data);
    }

    public AdditionItemStack(final AdditionMaterial material, int amount, String data) {
        this(material, amount, new Data(data));
    }

    public AdditionItemStack(final AdditionMaterial material, String data) {
        this(material, 1, data);
    }

    public AdditionItemStack(final String material, String data) {
        this(AdditionMaterial.byId(material), 1, data);
    }

    public AdditionItemStack(final String material, int amount, String data) {
        this(AdditionMaterial.byId(material), 1, data);
    }

    public AdditionItemStack(final AdditionMaterial material, int amount) {
        this(material, amount, new Data());
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
    //</editor-fold>

    public static AdditionItemStack asAdditionCopy(ItemStack itemStack) {
        AdditionMaterial material = AdditionMaterial.byId(NBTEditor.getString(itemStack, "addition", "id"));
        String data = NBTEditor.getString(itemStack, "addition", "data");
        return new AdditionItemStack(material, itemStack.getAmount(), data);
    }

    public ItemStack asBukkitCopy() {
        return AdditionItemStack.asBukkitCopy(this);
    }

    public static ItemStack asBukkitCopy(AdditionItemStack itemStack) {
        return NBTEditor.set(
                NBTEditor.set(itemStack.itemStack, itemStack.data.toString(), "addition", "data"),
                itemStack.material.getIdentifier(), "addition", "id");
    }

    public static boolean isAddition(ItemStack itemStack) {
        return NBTEditor.contains(itemStack, "addition");
    }
}
