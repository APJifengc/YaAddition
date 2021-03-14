package io.github.apjifengc.yaaddition.command;

import com.rabbitown.yalib.module.command.CommandSenderType;
import com.rabbitown.yalib.module.command.SimpleCommandRemote;
import com.rabbitown.yalib.module.command.annotation.*;
import io.github.apjifengc.yaaddition.YaAddition;
import io.github.apjifengc.yaaddition.addition.AdditionItemStack;
import io.github.apjifengc.yaaddition.core.state.TripWireState;
import org.bukkit.entity.Player;

import java.util.Arrays;

@Path(path = "debug")
public class CommandDebug extends SimpleCommandRemote {
    public CommandDebug() {
        super("yaaddition", YaAddition.getInstance(), Arrays.asList("yadd"), "The main command for yaaddition.", "/yaaddition help");
    }

    @Action(action = "setId")
    @Parameter(params = {"sender", "id"})
    @Access(sender = {CommandSenderType.PLAYER})
    public void setId(Player sender, int id) {
        new TripWireState(id).setData(sender.getLocation().getBlock());
    }

    @Action(action = "testItem {id}")
    @Parameter(params = {"sender", "id"})
    @Access(sender = {CommandSenderType.PLAYER})
    public void testItem(Player sender, String id) {
        AdditionItemStack itemStack = new AdditionItemStack(id);
        sender.getInventory().addItem(itemStack.asBukkitCopy());
    }
}
