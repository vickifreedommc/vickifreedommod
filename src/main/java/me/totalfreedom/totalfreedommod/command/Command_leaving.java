package me.totalfreedom.totalfreedommod.command;

import me.totalfreedom.totalfreedommod.banning.Ban;
import me.totalfreedom.totalfreedommod.rank.Rank;
import me.totalfreedom.totalfreedommod.util.FUtil;
import org.apache.commons.lang.StringUtils;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

@CommandPermissions(level = Rank.ALL_PERMS, source = SourceType.BOTH)
@CommandParameters(description = "Another command to leave", usage = "/<command>", aliases = "leave")
public class Command_leaving extends FreedomCommand
{

    @Override
    public boolean run(CommandSender sender, Player sender_p, Command cmd, String commandLabel, String[] args, boolean senderIsConsole)
    {
        if (args.length > 2) {
            return false;
        }
       final Player player = getPlayer(args[0]);
       player.kickPlayer(ChatColor.RED + "Bye <3, we hope you enjoyed your stay");  
       FUtil.bcastMsg(ChatColor.RED + sender.getName() + " has left the game using the /leave command");
        
     return true;   
    }
    
}
