package io.github.apjifengc.yaaddition.addition;

import com.rabbitown.yalib.module.locale.LocaleString;
import io.github.apjifengc.yaaddition.core.state.ItemState;
import io.github.apjifengc.yaaddition.core.state.NoteBlockState;
import io.github.apjifengc.yaaddition.core.state.State;
import io.github.apjifengc.yaaddition.core.state.TripWireState;
import io.github.apjifengc.yaaddition.exception.MaterialAlreadyRegisteredException;
import io.github.apjifengc.yaresourcepackmanager.component.Model;
import io.github.apjifengc.yaresourcepackmanager.component.Texture;
import lombok.Getter;
import org.bukkit.Material;

import java.util.HashMap;
import java.util.Map;

public class AdditionMaterial {
    @Getter private static final Map<String, AdditionMaterial> map = new HashMap<>();
    @Getter private final State state;
    @Getter private final Material baseMaterial;
    @Getter private final AdditionMaterialType type;
    @Getter private final String identifier;
    @Getter private final Model model;
    @Getter private final Map<String, Texture> textures;
    @Getter private final LocaleString name;
    @Getter private final LocaleString lore;

    public AdditionMaterial(AdditionMaterialType type, String identifier, Model model, LocaleString name, LocaleString lore) {
        this.type = type;
        this.identifier = identifier;
        this.baseMaterial = type.baseMaterial;
        this.model = model;
        this.name = name;
        this.lore = lore;
        this.textures = null;
        switch (type) {
            case FULL_BLOCK:
                state = new NoteBlockState();
                break;
            case DECORATIVE_BLOCK:
                state = new TripWireState();
                break;
            case ITEM:
                state = new ItemState();
                break;
            default:
                state = null;
        }
    }

    public AdditionMaterial(AdditionMaterialType type, String identifier, Model model, Map<String, Texture> textures, LocaleString name, LocaleString lore) {
        this.type = type;
        this.identifier = identifier;
        this.baseMaterial = type.baseMaterial;
        this.model = model;
        this.textures = textures;
        this.name = name;
        this.lore = lore;
        switch (type) {
            case FULL_BLOCK:
                state = new NoteBlockState();
                break;
            case DECORATIVE_BLOCK:
                state = new TripWireState();
                break;
            case ITEM:
                state = new ItemState();
                break;
            default:
                state = null;
        }
    }

    public static AdditionMaterial byId(String id) {
        return map.get(id);
    }

    public void register() throws MaterialAlreadyRegisteredException {
        if (map.containsKey(identifier)) {
            throw new MaterialAlreadyRegisteredException("The addition material " + identifier + " is already registered!");
        }
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
