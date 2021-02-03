package io.github.apjifengc.yaaddition.core.state;

import io.github.apjifengc.yaaddition.addition.AdditionMaterial;
import org.bukkit.Instrument;
import org.bukkit.Note;
import org.bukkit.block.Block;
import org.bukkit.block.data.type.NoteBlock;
import org.bukkit.block.data.type.Tripwire;

public class TripWireState {
    private static int currentID = 0;


    public int id;

    public TripWireState(Instrument instrument, Note note, boolean powered) {
        this.id = instrument.getType() * 48 + note.getId() * 2 + (powered ? 1 : 0) - 2;
        Tripwire tripwire;

    }

    public TripWireState(int id) {
        this.setId(id);
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
     * Set the next free ID for the material.
     *
     * @param material The material.
     */
    public static void nextBlock(AdditionMaterial material) {
        ((NoteBlockState) material.state).setId(++currentID);
    }

    public static void setData(Block noteBlock, AdditionMaterial material) {
        NoteBlock data = (NoteBlock) noteBlock.getBlockData();
        NoteBlockState state = (NoteBlockState) material.state;
        data.setNote(state.note);
        data.setInstrument(state.instrument);
        data.setPowered(state.powered);
    }
}
