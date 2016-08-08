package me.totalfreedom.totalfreedommod.command;

import me.totalfreedom.totalfreedommod.rank.Rank;
import me.totalfreedom.totalfreedommod.util.DepreciationAggregator;
import me.totalfreedom.totalfreedommod.util.FUtil;
import org.bukkit.ChatColor;
import org.bukkit.OfflinePlayer;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

@CommandPermissions(level = Rank.SUPER_ADMIN, source = SourceType.BOTH)
@CommandParameters(description = "A totalfreedom remake of /reload", usage = "/<command>", aliases = "rl, rel")
public class Command_reload extends FreedomCommand
{

    @Override
    public boolean run(CommandSender sender, Player playerSender, Command cmd, String commandLabel, String[] args, boolean senderIsConsole)
    {
        if (args.length == 2) {
            return false;
        }
        FUtil.bcastMsg(ChatColor.RED + sender.getName() + " - Reloading the server");
        server.reload();
        FUtil.bcastMsg(ChatColor.AQUA + "Reload complete!");
        msg(ChatColor.RED + "Reload Successful");
        
        return true;
    }

    }
