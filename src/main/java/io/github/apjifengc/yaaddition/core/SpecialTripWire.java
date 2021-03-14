package io.github.apjifengc.yaaddition.core;

import io.github.apjifengc.yaaddition.YaAddition;
import io.github.apjifengc.yaaddition.addition.AdditionMaterial;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.block.data.type.Tripwire;
import org.bukkit.block.data.type.TripwireHook;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPhysicsEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.List;
import java.util.Set;

public class SpecialTripWire implements Listener {
    private List<Block> tripWires;


    public SpecialTripWire(YaAddition plugin) {
        Bukkit.getPluginManager().registerEvents(this, plugin);
        new BukkitRunnable() {
            @Override
            public void run() {

            }
        }.runTaskTimer(plugin, 0, 1);
    }

    /*@EventHandler
    void onPlace(BlockPlaceEvent event) {
        if (event.getBlock().getType() == Material.TRIPWIRE) {
            correctTripWire(event.getBlock(), true);
        }
        if (event.getBlock().getType() == Material.TRIPWIRE_HOOK) {
            TripwireHook hook = (TripwireHook) event.getBlock().getBlockData();
            Block tripwire = event.getBlock().getRelative(hook.getFacing());
            if (tripwire.getType() == Material.TRIPWIRE) {
                correctTripWire(tripwire, false);
            }
        }
    }

    @EventHandler
    void onBreak(BlockBreakEvent event) {
        if (event.getBlock().getType() == Material.TRIPWIRE) {
            correctTripWire(event.getBlock(), true);
        }
        if (event.getBlock().getType() == Material.TRIPWIRE_HOOK) {
            TripwireHook hook = (TripwireHook) event.getBlock().getBlockData();
            Block tripwire = event.getBlock().getRelative(hook.getFacing());
            if (tripwire.getType() == Material.TRIPWIRE) {
                correctTripWire(tripwire, false);
            }
        }
    }*/

    @EventHandler
    void onBlockPhysics(BlockPhysicsEvent event) {
        if (event.getBlock().getType() == Material.TRIPWIRE) {

            String id = (String) BlockStorage.get(event.getBlock().getLocation(), "id");
            if (id == null) {
                correctTripWire(event.getBlock(), true);
            } else {
                AdditionMaterial.byId(id).getState().setData(event.getBlock());
            }
            event.setCancelled(true);
        }
    }

    void correctTripWire(Block block, boolean update) {
        Tripwire tripwire = (Tripwire) block.getBlockData();
        if (block.getRelative(BlockFace.NORTH).getType() == Material.TRIPWIRE ||
                block.getRelative(BlockFace.NORTH).getType() == Material.TRIPWIRE_HOOK ||
                block.getRelative(BlockFace.SOUTH).getType() == Material.TRIPWIRE ||
                block.getRelative(BlockFace.SOUTH).getType() == Material.TRIPWIRE_HOOK) {
            tripwire.setFace(BlockFace.NORTH, true);
            tripwire.setFace(BlockFace.SOUTH, true);
        } else {
            tripwire.setFace(BlockFace.NORTH, false);
            tripwire.setFace(BlockFace.SOUTH, false);
        }
        if (block.getRelative(BlockFace.EAST).getType() == Material.TRIPWIRE ||
                block.getRelative(BlockFace.EAST).getType() == Material.TRIPWIRE_HOOK ||
                block.getRelative(BlockFace.WEST).getType() == Material.TRIPWIRE ||
                block.getRelative(BlockFace.WEST).getType() == Material.TRIPWIRE_HOOK) {
            tripwire.setFace(BlockFace.EAST, true);
            tripwire.setFace(BlockFace.WEST, true);
        } else {
            tripwire.setFace(BlockFace.EAST, false);
            tripwire.setFace(BlockFace.WEST, false);
        }
        if (update) {
            if (block.getRelative(BlockFace.NORTH).getType() == Material.TRIPWIRE)
                correctTripWire(block.getRelative(BlockFace.NORTH), false);
            if (block.getRelative(BlockFace.SOUTH).getType() == Material.TRIPWIRE)
                correctTripWire(block.getRelative(BlockFace.SOUTH), false);
            if (block.getRelative(BlockFace.EAST).getType() == Material.TRIPWIRE)
                correctTripWire(block.getRelative(BlockFace.EAST), false);
            if (block.getRelative(BlockFace.WEST).getType() == Material.TRIPWIRE)
                correctTripWire(block.getRelative(BlockFace.WEST), false);
        }
        tripwire.setDisarmed(false);
        tripwire.setAttached(false);
        block.setBlockData(tripwire);
        /*Bukkit.getOnlinePlayers().forEach(player -> {
            player.sendBlockChange(location, tripwire);
        });*/
    }
    /*public void entityInside(BlockState blockState, Level world, BlockPos location, Entity entity) {
        if (world.isClientSide)
            return;
        if (blockState.getValue(POWERED))
            return;
        checkPressed(world, location);
    }*/
}
