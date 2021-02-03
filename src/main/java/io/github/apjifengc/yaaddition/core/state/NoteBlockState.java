package io.github.apjifengc.yaaddition.core.state;

import io.github.apjifengc.yaaddition.addition.AdditionMaterial;
import org.bukkit.Instrument;
import org.bukkit.Note;
import org.bukkit.block.Block;
import org.bukkit.block.data.type.NoteBlock;

public class NoteBlockState implements State {
    private static int currentID = 0;

    public Instrument instrument;
    public Note note;
    public boolean powered;
    public int id;

    public NoteBlockState(Instrument instrument, Note note, boolean powered) {
        this.instrument = instrument;
        this.note = note;
        this.powered = powered;
        this.id = instrument.getType() * 48 + note.getId() * 2 + (powered ? 1 : 0) - 2;
    }

    public NoteBlockState(int id) {
        this.setId(id);
    }

    /**
     * Set the custom block's ID.
     *
     * @param id The id.
     */
    public void setId(int id) {
        this.id = id;
        this.instrument = Instrument.getByType((byte) ((id + 2) / 48));
        this.note = new Note((id + 2) % 48 / 2);
        this.powered = id % 2 == 1;
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
