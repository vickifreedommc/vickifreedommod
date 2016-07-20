package me.totalfreedom.totalfreedommod.command;

import me.totalfreedom.totalfreedommod.rank.Rank;
import me.totalfreedom.totalfreedommod.util.FUtil;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

@CommandPermissions(level = Rank.OP, source = SourceType.BOTH)
@CommandParameters(description = "Let people know that you will be right back!!", usage = "/<command>", aliases = "berightback")


public class Command_brb extends FreedomCommand
{
    

    @Override
    public boolean run(CommandSender sender, Player playerSender, Command cmd, String commandLabel, String[] args, boolean senderIsConsole)
    {
       FUtil.bcastMsg(sender.getName() + " - will be right back!", ChatColor.GREEN);
            try {
    Thread.sleep(1000);                 //1000 milliseconds is one second.
} catch(InterruptedException ex) {
    Thread.currentThread().interrupt();
}
       
       FUtil.bcastMsg(sender.getName() + " is now afk.", ChatColor.GRAY);
        return true;
    
    
    }   
}
