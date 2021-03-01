package io.github.apjifengc.yaaddition.addition;

import io.github.apjifengc.yaaddition.util.Data;
import io.github.bananapuncher714.nbteditor.NBTEditor;
import lombok.Getter;
import lombok.Setter;
import org.bukkit.ChatColor;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * A class that contains a addition item stack.
 *
 * @author APJifengc
 */
public class AdditionItemStack {
    @Getter
    private final AdditionMaterial material;
    @Getter
    private final int amount;
    @Getter
    private final Data data;
    @Getter
    private final ItemStack itemStack;
    @Getter
    @Setter
    private List<String> lore = new ArrayList<>();

    /**
     * Construct a addition item stack.
     *
     * @param material The addition material for the item.
     * @param amount   The amount of the item.
     * @param data     The data of the item.
     */
    public AdditionItemStack(final AdditionMaterial material, int amount, Data data) {
        itemStack = new ItemStack(material.getBaseMaterial(), amount);
        this.material = material;
        this.amount = amount;
        this.data = data;
        ItemMeta itemMeta = itemStack.getItemMeta();
        itemMeta.setCustomModelData(material.getState().getId());
        itemMeta.setDisplayName(ChatColor.WHITE + material.getName());
        itemMeta.setLore(generateLore());
        itemStack.setItemMeta(itemMeta);
    }

    /**
     * Construct a addition item stack.
     *
     * @param material The addition material for the item.
     * @param data     The data of the item.
     */
    public AdditionItemStack(final AdditionMaterial material, Data data) {
        this(material, 1, data);
    }

    /**
     * Construct a addition item stack.
     *
     * @param material The addition material for the item.
     * @param data     The data of the item.
     */
    public AdditionItemStack(final String material, Data data) {
        this(AdditionMaterial.byId(material), 1, data);
    }

    /**
     * Construct a addition item stack.
     *
     * @param material The addition material for the item.
     * @param amount   The amount of the item.
     * @param data     The data of the item.
     */
    public AdditionItemStack(final String material, int amount, Data data) {
        this(AdditionMaterial.byId(material), 1, data);
    }

    //<editor-fold desc="Constructors">

    /**
     * Construct a addition item stack.
     *
     * @param material The addition material for the item.
     * @param amount   The amount of the item.
     * @param data     The data of the item.
     */
    public AdditionItemStack(final AdditionMaterial material, int amount, String data) {
        this(material, amount, new Data(data));
    }

    /**
     * Construct a addition item stack.
     *
     * @param material The addition material for the item.
     * @param data     The data of the item.
     */
    public AdditionItemStack(final AdditionMaterial material, String data) {
        this(material, 1, data);
    }

    /**
     * Construct a addition item stack.
     *
     * @param material The addition material for the item.
     * @param data     The data of the item.
     */
    public AdditionItemStack(final String material, String data) {
        this(AdditionMaterial.byId(material), 1, data);
    }

    /**
     * Construct a addition item stack.
     *
     * @param material The addition material for the item.
     * @param amount   The amount of the item.
     * @param data     The data of the item.
     */
    public AdditionItemStack(final String material, int amount, String data) {
        this(AdditionMaterial.byId(material), 1, data);
    }

    /**
     * Construct a addition item stack.
     *
     * @param material The addition material for the item.
     * @param amount   The amount of the item.
     */
    public AdditionItemStack(final AdditionMaterial material, int amount) {
        this(material, amount, new Data());
    }

    /**
     * Construct a addition item stack.
     *
     * @param material The addition material for the item.
     */
    public AdditionItemStack(final AdditionMaterial material) {
        this(material, 1);
    }

    /**
     * Construct a addition item stack.
     *
     * @param material The addition material for the item.
     */
    public AdditionItemStack(final String material) {
        this(AdditionMaterial.byId(material), 1);
    }

    /**
     * Construct a addition item stack.
     *
     * @param material The addition material for the item.
     * @param amount   The amount of the item.
     */
    public AdditionItemStack(final String material, int amount) {
        this(AdditionMaterial.byId(material), 1);
    }

    //</editor-fold>

    private List<String> generateLore() {
        List<String> lore = material.getLore().stream().map(str -> ChatColor.GRAY + str).collect(Collectors.toList());
        lore.addAll(this.lore);
        return lore;
    }

    /**
     * Get the item meta for the item stack.
     *
     * @return The item meta.
     */
    public ItemMeta getItemMeta() {
        return itemStack.getItemMeta();
    }

    /**
     * Set the item meta for the item stack. <br/>
     * Notice that you can't use {@link ItemMeta#setCustomModelData} and {@link ItemMeta#setLore}. These two values
     * will be overridden by the plugin. If you want to set the lore for the item, use {@link #setLore} instead.
     *
     * @param itemMeta The item meta.
     */
    public void setItemMeta(ItemMeta itemMeta) {
        itemMeta.setCustomModelData(material.getState().getId());
        itemMeta.setLore(generateLore());
        itemStack.setItemMeta(itemMeta);
    }

    /**
     * Get the addition item stack by a bukkit {@link ItemStack}.
     *
     * @param itemStack The bukkit item stack.
     * @return The addition item stack.
     */
    public static AdditionItemStack asAdditionCopy(ItemStack itemStack) {
        AdditionMaterial material = AdditionMaterial.byId(NBTEditor.getString(itemStack, "addition", "id"));
        String data = NBTEditor.getString(itemStack, "addition", "data");
        return new AdditionItemStack(material, itemStack.getAmount(), data);
    }

    /**
     * Get the bukkit {@link ItemStack} by an addition item stack.
     *
     * @param itemStack The bukkit item stack.
     * @return The addition item stack.
     */
    public static ItemStack asBukkitCopy(AdditionItemStack itemStack) {
        return NBTEditor.set(
                NBTEditor.set(itemStack.itemStack, itemStack.data.toString(), "addition", "data"),
                itemStack.material.getIdentifier(), "addition", "id");
    }

    public static boolean isAddition(ItemStack itemStack) {
        return NBTEditor.contains(itemStack, "addition");
    }

    public ItemStack asBukkitCopy() {
        return AdditionItemStack.asBukkitCopy(this);
    }
}
