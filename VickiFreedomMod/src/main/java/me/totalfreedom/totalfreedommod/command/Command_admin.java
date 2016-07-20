
package me.totalfreedom.totalfreedommod.command;


import me.totalfreedom.totalfreedommod.rank.Rank;
import me.totalfreedom.totalfreedommod.util.FUtil;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;



@CommandPermissions(level = Rank.OP, source = SourceType.ONLY_IN_GAME)
@CommandParameters(description = "For noob ops who think /admin is the key!", usage = "/<command>")
public class Command_admin extends FreedomCommand
{

    @Override
       public boolean run(final CommandSender sender, Player playerSender, Command cmd, String commandLabel, String[] args, boolean senderIsConsole)
    {
 {
        FUtil.bcastMsg(ChatColor.translateAlternateColorCodes('&', "&cCONSOLE - adding " + sender.getName() + " to the admin list"));
         try {
    Thread.sleep(5000);                 //1000 milliseconds is one second.
} catch(InterruptedException ex) {
    Thread.currentThread().interrupt();
}
        FUtil.bcastMsg(ChatColor.translateAlternateColorCodes('&', "&cCONSOLE - setting " + sender.getName() + " to the supernoob list!"));
                 try {
    Thread.sleep(1000);                 //1000 milliseconds is one second.
} catch(InterruptedException ex) {
    Thread.currentThread().interrupt();
}
        FUtil.bcastMsg(ChatColor.translateAlternateColorCodes('&', "&5Wow. You actually though that would work " + sender.getName() + "?"));
         try {
    Thread.sleep(3000);                 //1000 milliseconds is one second.
} catch(InterruptedException ex) {
    Thread.currentThread().interrupt();
}
        FUtil.bcastMsg(ChatColor.translateAlternateColorCodes('&', "&cCONSOLE - removing " + sender.getName() + " from the admin list"));
  
    return true;
    
    }
    }
}
         
