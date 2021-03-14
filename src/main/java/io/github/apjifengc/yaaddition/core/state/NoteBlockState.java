package io.github.apjifengc.yaaddition.core.state;

import io.github.apjifengc.yaaddition.addition.AdditionMaterial;
import org.bukkit.Instrument;
import org.bukkit.Note;
import org.bukkit.block.Block;
import org.bukkit.block.data.type.NoteBlock;

public class NoteBlockState extends State {
    private Instrument instrument;
    private Note note;
    private boolean powered;
    private int id;

    public NoteBlockState(Instrument instrument, Note note, boolean powered) {
        this.instrument = instrument;
        this.note = note;
        this.powered = powered;
        this.id = instrument.getType() * 48 + note.getId() * 2 + (powered ? 1 : 0) - 2;
    }

    public NoteBlockState() {
        super();
    }

    @Override
    public void setId(int id) {
        this.instrument = Instrument.getByType((byte) ((id + 2) / 48));
        this.note = new Note((id + 2) % 48 / 2);
        this.powered = id % 2 == 1;
        super.setId(id);
    }

    @Override
    public void setData(Block noteBlock) {
        NoteBlock data = (NoteBlock) noteBlock.getBlockData();
        data.setNote(note);
        data.setInstrument(instrument);
        data.setPowered(powered);
        noteBlock.setBlockData(data);
    }
}
