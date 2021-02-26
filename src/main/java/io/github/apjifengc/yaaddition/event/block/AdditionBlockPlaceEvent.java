package io.github.apjifengc.yaaddition.event.block;

import io.github.apjifengc.yaaddition.addition.AdditionBlock;
import io.github.apjifengc.yaaddition.addition.AdditionItemStack;
import lombok.Getter;

import org.bukkit.entity.Player;
import org.bukkit.event.HandlerList;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.inventory.EquipmentSlot;
import org.jetbrains.annotations.NotNull;

public class AdditionBlockPlaceEvent extends BlockPlaceEvent {

    private static final HandlerList handlers = new HandlerList();
    @Getter
    private final AdditionBlock additionPlacedBlock;
    @Getter
    private final AdditionBlock additionPlacedAgainst;
    @Getter
    private final AdditionItemStack additionItemInHand;

    public AdditionBlockPlaceEvent(@NotNull AdditionBlock placedBlock, @NotNull AdditionBlock placedAgainst,
            @NotNull AdditionItemStack additionItemInHand, Player thePlayer, boolean canBuild, EquipmentSlot hand) {
        super(placedBlock.getBlock(), placedBlock.getBlock().getState(), placedAgainst.getBlock(),
                AdditionItemStack.asBukkitCopy(additionItemInHand), thePlayer, canBuild, hand);
        this.additionPlacedBlock = placedBlock;
        this.additionPlacedAgainst = placedAgainst;
        this.additionItemInHand = additionItemInHand;
    }

    @Override
    @NotNull
    public HandlerList getHandlers() {
        return handlers;
    }
}
