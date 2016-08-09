package me.totalfreedom.totalfreedommod.command;

import me.totalfreedom.totalfreedommod.rank.Rank;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import static org.spigotmc.SpigotConfig.config;

@CommandPermissions(level = Rank.OP, source = SourceType.ONLY_IN_GAME, blockHostConsole = true)
@CommandParameters(description = "Using @ for adminhelp", usage = "/<command>")
public class Command_owners extends FreedomCommand
{

    @Override
       public boolean run(final CommandSender sender, Player sender_p, Command cmd, String commandLabel, String[] args, boolean senderIsConsole)
    {
        Player player = (Player) sender;
        player.sendMessage(ChatColor.RED + "The current owners of VickiFreedom are:");
             try {
    Thread.sleep(3000);                 //1000 milliseconds is one second.
} catch(InterruptedException ex) {
    Thread.currentThread().interrupt();
}
             player.sendMessage(ChatColor.GREEN + "Vicki411");
             player.sendMessage(ChatColor.GREEN + "DarkPug108");
             player.sendMessage(ChatColor.GREEN + "BearzRAwesome");
             player.sendMessage(ChatColor.GREEN + "NotAnOperator");
             player.sendMessage(ChatColor.GREEN + "ArcticHumboldt");
        
        
        
        return true;
    }
       
    }
