package me.totalfreedom.totalfreedommod.command;

import me.totalfreedom.totalfreedommod.rank.Rank;
import me.totalfreedom.totalfreedommod.util.FUtil;
import org.apache.commons.lang3.StringUtils;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

@CommandPermissions(level = Rank.OP, source = SourceType.BOTH)
@CommandParameters(description = "How to apply for admin", usage = "/<command>", aliases = "cry")
public class Command_cry extends FreedomCommand
{
    public boolean run(CommandSender sender, Player sender_p, Command cmd, String commandLabel, String[] args, boolean senderIsConsole)
    {
        if (sender.getName().equalsIgnoreCase("Loooll")) 
        if (sender.getName().equalsIgnoreCase("NotAnOperator"))
    {
    }
      else
      {
          sender.sendMessage(ChatColor.RED + "YOU AINT HAVE ANY PERMISSION BOI.");
          
          return true;
      }
        
        FUtil.bcastMsg(sender_p.getName() + " is crying.", ChatColor.RED);
        return true;
    }
}