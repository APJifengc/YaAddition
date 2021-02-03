package io.github.apjifengc.yaaddition.addition;

import org.bukkit.Location;

public class AdditionBlock {
    private AdditionMaterial type;
    private final Location location;

    public AdditionBlock(AdditionMaterial type, Location location) {
        this.type = type;
        this.location = location;
    }

    public AdditionMaterial getType() {
        return type;
    }

    public void setType(AdditionMaterial type) {
        this.type = type;
    }

    public Location getLocation() {
        return location;
    }
}
