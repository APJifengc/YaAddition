package io.github.apjifengc.yaaddition.addition;

import lombok.Getter;
import lombok.Setter;
import org.bukkit.Location;
import org.bukkit.block.Block;

public class AdditionBlock {
    @Getter @Setter private AdditionMaterial type;
    @Getter private final Location location;
    @Getter private final Block block;

    public AdditionBlock(AdditionMaterial type, Location location, Block block) {
        this.type = type;
        this.location = location;
        this.block = block;
    }
}
