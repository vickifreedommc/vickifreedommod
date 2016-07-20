package me.totalfreedom.totalfreedommod.command;

import static com.earth2me.essentials.commands.EssentialsCommand.getFinalArg;
import me.totalfreedom.totalfreedommod.rank.Rank;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

@CommandPermissions(level = Rank.SYSADMIN, source = SourceType.BOTH)
@CommandParameters(description = "Say something in the text of the target player!", usage = "/<command> [player]")
public class Command_forcesay extends FreedomCommand
{

    @Override
    public boolean run(CommandSender sender, Player playerSender, Command cmd, String commandLabel, String[] args, boolean senderIsConsole)
    {
        final Player player = getPlayer(args[0]);
			player.chat(getFinalArg(args, 1).substring(2));

        return true;
    }
}
