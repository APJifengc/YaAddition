package io.github.apjifengc.yaaddition.event.block;

import io.github.apjifengc.yaaddition.addition.AdditionBlock;
import lombok.Getter;

import org.bukkit.entity.Player;
import org.bukkit.event.HandlerList;
import org.bukkit.event.block.BlockBreakEvent;
import org.jetbrains.annotations.NotNull;

public class AdditionBlockBreakEvent extends BlockBreakEvent {
    private static final HandlerList handlers = new HandlerList();
    private boolean cancelled;
    @Getter
    private final AdditionBlock additionBlock;

    public AdditionBlockBreakEvent(@NotNull AdditionBlock additionBlock, @NotNull Player player) {
        super(additionBlock.getBlock(), player);
        this.additionBlock = additionBlock;
    }

    @Override
    @NotNull
    public HandlerList getHandlers() {
        return handlers;
    }

    @Override
    public boolean isCancelled() {
        return cancelled;
    }

    @Override
    public void setCancelled(boolean cancel) {
        this.cancelled = cancel;
    }
}
