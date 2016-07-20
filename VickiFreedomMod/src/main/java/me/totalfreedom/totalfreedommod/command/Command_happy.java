package me.totalfreedom.totalfreedommod.command;

import me.totalfreedom.totalfreedommod.rank.Rank;
import me.totalfreedom.totalfreedommod.util.FUtil;
import org.apache.commons.lang3.StringUtils;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

@CommandPermissions(level = Rank.OP, source = SourceType.BOTH)
@CommandParameters(description = "Happy People Only", usage = "/<command>", aliases = "cry")
public class Command_happy extends FreedomCommand
{
    public boolean run(CommandSender sender, Player sender_p, Command cmd, String commandLabel, String[] args, boolean senderIsConsole)
    {
        if (sender.getName().equalsIgnoreCase("Charlotte474747")) 
        if (sender.getName().equalsIgnoreCase("heroguy42"))
    {
    }
      else
      {
          sender.sendMessage(ChatColor.RED + "You are not happy enough to perform this command.");
          
          return true;
      }
        
        FUtil.bcastMsg(sender_p.getName() + " is SO HAPPY!.", ChatColor.GREEN);
        return true;
    }
}
