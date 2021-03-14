package io.github.apjifengc.yaaddition.core.listener;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.FurnaceSmeltEvent;

public class RecipeListener implements Listener {
    @EventHandler
    public void onFurnaceSmelt(FurnaceSmeltEvent event) {
        event.getSource();
    }
}
