package me.totalfreedom.totalfreedommod.command;

import me.totalfreedom.totalfreedommod.rank.Rank;
import org.apache.commons.lang3.StringUtils;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

@CommandPermissions(level = Rank.SUPER_ADMIN, source = SourceType.BOTH)
@CommandParameters(description = "Admin reminders", usage = "/<command> 1 2 3 4", aliases = "ar")
public class Command_areminder extends FreedomCommand
{
    public boolean run(CommandSender sender, Player sender_p, Command cmd, String commandLabel, String[] args, boolean senderIsConsole)
    {
        if (args.length == 0)
        {
            msg("Do /areminder 1 or 2 or 3 or 4");
            return true;
        }
        
        if (args[0].equals("1"))
        {
            msg("Remember to do /gtfo if you wish to ban!", ChatColor.RED);
            msg("Remember to do /cmdspy if you realise you aren't seeing any player's command", ChatColor.RED);
            msg("Remember, OPs can only advertise once every 10 minutes. If they do it more than 3 times, give them a GTFO!", ChatColor.RED);
            msg("Remember, to mute, you use /stfu. :3", ChatColor.RED);
            msg("Remember to always treat OPS and Admins nicely!", ChatColor.RED);
            return true;
        }
        if (args[0].equals("2"))
        {
            msg("Soon to be implemented", ChatColor.RED);
            return true;
        }
        if (args[0].equals("3"))
        {
            msg("Soon to be implemented", ChatColor.RED);
            return true;
        }
        if (args[0].equals("4"))
        {
            msg("Soon to be implemented.", ChatColor.RED);
            return true;
        }
        return true;
    }
}