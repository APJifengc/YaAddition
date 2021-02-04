package io.github.apjifengc.yaaddition.core.state;

import com.sun.source.tree.BinaryTree;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.block.data.type.Tripwire;

import javax.naming.BinaryRefAddr;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class TripWireState extends State {
    private final List<Integer> NOT_AVAILABLE_ID = Arrays.asList(
            0b00000,
            0b00011,
            0b01100,
            0b01111,
            0b10000,
            0b10011,
            0b11100,
            0b11111
    );

    private boolean north;
    private boolean south;
    private boolean west;
    private boolean east;
    private boolean powered;
    private boolean attached;
    private boolean disarmed;

    public TripWireState(boolean north, boolean south, boolean west, boolean east, boolean powered, boolean attached,
                         boolean disarmed) {
        this.north = north;
        this.south = south;
        this.west = west;
        this.east = east;
        this.powered = powered;
        this.attached = attached;
        this.disarmed = disarmed;
        this.id = (north?1:0) |
                (south?1:0) << 1 |
                (west?1:0) << 2 |
                (east?1:0) << 3 |
                (powered?1:0) << 4 |
                (attached?1:0) << 5 |
                (disarmed?1:0) << 6;
    }

    public TripWireState(int id) {
        this.setId(id);
    }

    public TripWireState() {
        super();
    }

    @Override
    public void setId(int id) {
        north = (id & 1) == 1;
        south = (id >> 1 & 1) == 1;
        west = (id >> 2 & 1) == 1;
        east = (id >> 3 & 1) == 1;
        powered = (id >> 4 & 1) == 1;
        attached = (id >> 5 & 1) == 1;
        disarmed = (id >> 6 & 1) == 1;
        super.setId(id);
    }

    @Override
    public void setData(Block tripWireBlock) {
        Tripwire data = (Tripwire) tripWireBlock.getBlockData();
        data.setPowered(powered);
        data.setAttached(attached);
        data.setDisarmed(disarmed);
        data.setFace(BlockFace.NORTH, north);
        data.setFace(BlockFace.SOUTH, south);
        data.setFace(BlockFace.EAST, east);
        data.setFace(BlockFace.WEST, west);
        tripWireBlock.setBlockData(data);
    }

    @Override
    public int nextId() {
        ++currentID;
        if (NOT_AVAILABLE_ID.contains(currentID)) currentID++;
        return currentID;
    }
}
