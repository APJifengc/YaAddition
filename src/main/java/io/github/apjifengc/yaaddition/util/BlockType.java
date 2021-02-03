package io.github.apjifengc.yaaddition.util;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class BlockType {
    public static final BlockType STONE = new BlockType(Arrays.asList(new ItemStack(Material.WOODEN_PICKAXE),new ItemStack(Material.STONE_PICKAXE),new ItemStack(Material.IRON_PICKAXE),new ItemStack(Material.DIAMOND_PICKAXE),new ItemStack(Material.GOLDEN_PICKAXE),new ItemStack(Material.NETHERITE_PICKAXE)));
    public static final BlockType WOOD = new BlockType(Arrays.asList(new ItemStack(Material.WOODEN_SHOVEL),new ItemStack(Material.STONE_SHOVEL),new ItemStack(Material.IRON_SHOVEL),new ItemStack(Material.DIAMOND_SHOVEL),new ItemStack(Material.GOLDEN_SHOVEL),new ItemStack(Material.NETHERITE_SHOVEL)));
    public static final BlockType DIRT = new BlockType(Arrays.asList(new ItemStack(Material.WOODEN_AXE),new ItemStack(Material.STONE_AXE),new ItemStack(Material.IRON_AXE),new ItemStack(Material.DIAMOND_AXE),new ItemStack(Material.GOLDEN_AXE),new ItemStack(Material.NETHERITE_AXE)));
    public static final BlockType WOOL = new BlockType(Arrays.asList(new ItemStack(Material.SHEARS)));
    public static final BlockType COMMON = new BlockType(Collections.emptyList());

    private final List<ItemStack> breakableItemList;
    public BlockType(List<ItemStack> breakableItemList) {
        this.breakableItemList = breakableItemList;
    }
}
