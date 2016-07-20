
package me.totalfreedom.totalfreedommod.command;

import me.totalfreedom.totalfreedommod.TotalFreedomMod;
import me.totalfreedom.totalfreedommod.util.FUtil;
import me.totalfreedom.totalfreedommod.rank.Rank;
import me.totalfreedom.totalfreedommod.util.FLog;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

@CommandPermissions(level = Rank.NON_OP, source = SourceType.BOTH)
@CommandParameters(description = "Shows information about VickiFreedomMod!", usage = "/<command> [reload]", aliases = "vfm")
public class Command_vickifreedommod extends FreedomCommand
{
    @Override
    public boolean run(CommandSender sender, Player sender_p, Command cmd, String commandLabel, String[] args, boolean senderIsConsole)
    {
        if (args.length == 1)
        {
            if (!args[0].equals("reload"))
            {
                return false;
            }

            if (!plugin.al.isAdmin(sender))
            {
                noPerms();
                return true;
            }

            plugin.config.load();
            plugin.services.stop();
            plugin.services.start();

            final String message = String.format("%s v%s reloaded.",
                    TotalFreedomMod.pluginName,
                    TotalFreedomMod.pluginVersion);

            msg(message);
            FLog.info(message);
            return true;
        }
        FUtil.playerMsg(sender_p, ChatColor.BLUE + "VickiFreedomMod: ");
        FUtil.playerMsg(sender_p, ChatColor.RED + "VickiFreedomMod is" + ChatColor.BLUE + " compiled by" + ChatColor.GOLD + " The VickiFreedom Development Group.");
        FUtil.playerMsg(sender_p, ChatColor.DARK_GREEN + "Basically edited from TFM, but with more features!");
      

        return true;
    }
}