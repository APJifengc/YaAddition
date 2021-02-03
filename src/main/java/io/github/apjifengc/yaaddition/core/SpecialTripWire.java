package io.github.apjifengc.yaaddition.core;

import io.github.apjifengc.yaaddition.YaAddition;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.block.data.type.Tripwire;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPhysicsEvent;
import org.bukkit.event.block.BlockPlaceEvent;
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

    @EventHandler
    void onPlace(BlockPlaceEvent event) {
        if (event.getBlock().getType() == Material.TRIPWIRE) {
            faceTripWire(event.getBlock());
        }
    }

    @EventHandler
    void onBreak(BlockBreakEvent event) {
        if (event.getBlock().getType() == Material.TRIPWIRE) {
            faceTripWire(event.getBlock());
        }
    }

    @EventHandler
    void onBlockPhysics(BlockPhysicsEvent event) {
        if (event.getBlock().getType() == Material.TRIPWIRE) {
            faceTripWire(event.getBlock());
        }
    }

    void faceTripWire(Block block) {
        Location location = block.getLocation();
        Tripwire tripwire = (Tripwire) block.getBlockData();
        Set<BlockFace> faces = tripwire.getFaces();
        if (faces.contains(BlockFace.SOUTH)) tripwire.setFace(BlockFace.NORTH, true);
        if (faces.contains(BlockFace.NORTH)) tripwire.setFace(BlockFace.SOUTH, true);
        if (faces.contains(BlockFace.EAST)) tripwire.setFace(BlockFace.WEST, true);
        if (faces.contains(BlockFace.WEST)) tripwire.setFace(BlockFace.EAST, true);
        tripwire.setPowered(false);
        tripwire.setDisarmed(false);
        tripwire.setAttached(false);
        Bukkit.getOnlinePlayers().forEach(player -> {
            player.sendBlockChange(location, tripwire);
        });
    }
    /*public void entityInside(BlockState blockState, Level world, BlockPos location, Entity entity) {
        if (world.isClientSide)
            return;
        if (blockState.getValue(POWERED))
            return;
        checkPressed(world, location);
    }*/
}
