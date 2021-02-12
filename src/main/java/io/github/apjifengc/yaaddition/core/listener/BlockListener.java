package io.github.apjifengc.yaaddition.core.listener;

import io.github.apjifengc.yaaddition.YaAddition;
import io.github.apjifengc.yaaddition.addition.AdditionBlock;
import io.github.apjifengc.yaaddition.addition.AdditionItemStack;
import io.github.apjifengc.yaaddition.addition.AdditionMaterial;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockCanBuildEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCreativeEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerItemHeldEvent;
import org.bukkit.inventory.ItemStack;

public class BlockListener implements Listener {
    public BlockListener(YaAddition plugin) {
        Bukkit.getPluginManager().registerEvents(this, plugin);
    }

    @EventHandler
    public void onBlockPlace(BlockPlaceEvent event) {
        ItemStack itemStack = event.getItemInHand();
        if (AdditionItemStack.isAddition(itemStack)) {
            Block block = event.getBlock();
            Player player = event.getPlayer();
            AdditionItemStack additionItemStack = AdditionItemStack.asAdditionCopy(itemStack);
            AdditionMaterial material = additionItemStack.getMaterial();
            material.getState().setData(block);
            new AdditionBlock(material, block, additionItemStack.getData()).setAdditionData();
        }
    }

    @EventHandler(priority = EventPriority.LOW)
    public void onBlockBreak(BlockBreakEvent event) {
        Block block = event.getBlock();
        if (AdditionBlock.isAddition(block)) {
            event.setDropItems(false);
            AdditionBlock additionBlock = AdditionBlock.asAdditionCopy(block);
            AdditionItemStack itemStack = new AdditionItemStack(
                    additionBlock.getMaterial(),
                    additionBlock.getAdditionData()
            );
            if (event.getPlayer().getGameMode() != GameMode.CREATIVE)
                event.getBlock().getWorld().dropItemNaturally(event.getBlock().getLocation(), itemStack.asBukkitCopy());
        }
    }
}
