package io.github.apjifengc.yaaddition.addition;

import io.github.apjifengc.yaaddition.core.state.NoteBlockState;
import io.github.apjifengc.yaaddition.core.state.State;
import io.github.apjifengc.yaaddition.core.state.TripWireState;
import org.bukkit.Material;

import java.util.HashMap;
import java.util.Map;

public class AdditionMaterial {
    public static final Map<String, AdditionMaterial> map = new HashMap<>();
    public final State state;
    public final Material baseMaterial;
    public final AdditionMaterialType type;
    public final String identifier;
    public AdditionMaterial(AdditionMaterialType type, String identifier) {
        this.type = type;
        this.identifier = identifier;
        this.baseMaterial = type.baseMaterial;
        switch (type) {
            case FULL_BLOCK:
                state = new NoteBlockState();
                break;
            case DECORATIVE_BLOCK:
                state = new TripWireState();
                break;
            default:
                state = null;
        }
    }

    public static AdditionMaterial byId(String id) {
        return map.get(id);
    }

    public void register() {
        map.put(identifier, this);
    }

    public boolean isItem() {
        return type == AdditionMaterialType.ITEM;
    }

    public boolean isBlock() {
        return type != AdditionMaterialType.ITEM;
    }

    public enum AdditionMaterialType {
        DECORATIVE_BLOCK(Material.STRING), FULL_BLOCK(Material.NOTE_BLOCK), ITEM(Material.PAPER);
        private AdditionMaterialType(Material baseMaterial) {
            this.baseMaterial = baseMaterial;
        }
        public final Material baseMaterial;
    }
}
