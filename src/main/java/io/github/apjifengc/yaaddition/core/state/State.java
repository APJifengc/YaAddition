package io.github.apjifengc.yaaddition.core.state;

import lombok.Getter;
import lombok.Setter;
import org.bukkit.block.Block;

/**
 * Block's state.
 *
 * @author APJifengc
 */
public class State {
    static int currentID = 0;
    @Getter @Setter int id;

    public State(int id) {
        this.setId(id);
    }

    public State() {
        this.setId(nextId());
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
