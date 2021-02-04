package io.github.apjifengc.yaaddition.core.state;

import io.github.apjifengc.yaaddition.addition.AdditionMaterial;
import org.bukkit.block.Block;
import org.bukkit.block.data.type.Tripwire;

/**
 * Block's state.
 *
 * @author APJifengc
 */
public class State {
    static int currentID = 0;
    int id;

    public State(int id) {
        this.setId(id);
    }

    public State() {
        this.setId(nextId());
    }

    /**
     * Set the custom block's ID.
     *
     * @param id The id.
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Set the block data.
     *
     * @param block The block.
     */
    public void setData(Block block) {
        throw new UnsupportedOperationException("Not supported.");
    }

    /**
     * Get the next ID.
     *
     * @return The ID.
     */
    public int nextId() {
        return ++currentID;
    }
}
