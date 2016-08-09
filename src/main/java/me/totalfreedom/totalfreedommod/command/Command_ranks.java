
package me.totalfreedom.totalfreedommod.command;

import me.totalfreedom.totalfreedommod.rank.Rank;
import org.apache.commons.lang.ArrayUtils;
import org.apache.commons.lang.StringUtils;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;


@CommandPermissions(level = Rank.OP, source = SourceType.BOTH)
@CommandParameters(description="Shows all the ranks as of 8/7/16", usage="/<command>")
public class Command_ranks  extends FreedomCommand {
public boolean run(CommandSender sender, Player sender_p, Command cmd, String commandLabel, String[] args, boolean senderIsConsole)
    {

    msg(ChatColor.GREEN + "This is a list of all the ranks as of 8/7/16");
     try {
    Thread.sleep(3000);                 //1000 milliseconds is one second.
} catch(InterruptedException ex) {
    Thread.currentThread().interrupt();
}
    msg(ChatColor.RED + "[WARNING] This will spam you!");
     try {
    Thread.sleep(3000);                 //1000 milliseconds is one second.
} catch(InterruptedException ex) {
    Thread.currentThread().interrupt();
}
    msg(ChatColor.GREEN + "Imposter");
    msg(ChatColor.GREEN + "Non-OP");
    msg(ChatColor.GREEN + "OP");
    msg(ChatColor.GREEN + "Super Admin");
    msg(ChatColor.GREEN + "Telnet Admin");
    msg(ChatColor.GREEN + "Telnet Clan Admin");
    msg(ChatColor.GREEN + "Senior Admin");
    msg(ChatColor.GREEN + "Executive");
    msg(ChatColor.GREEN + "System Admin");
    msg(ChatColor.GREEN + "Owner");
    msg(ChatColor.GREEN + "Master Builder");
    msg(ChatColor.GREEN + "Security Officer");
    msg(ChatColor.GREEN + "Developer");
    msg(ChatColor.RED + "Custom Ranks:");
     try {
    Thread.sleep(2000);                 //1000 milliseconds is one second.
} catch(InterruptedException ex) {
    Thread.currentThread().interrupt();
}
    msg(ChatColor.AQUA + "Chip: for " + ChatColor.GREEN + "Chippyio");
     try {
    Thread.sleep(3000);                 //1000 milliseconds is one second.
} catch(InterruptedException ex) {
    Thread.currentThread().interrupt();
}
    msg(ChatColor.AQUA + "Pug: for " + ChatColor.GREEN + "rovertdude");
    msg(ChatColor.GREEN + "Made by - " + ChatColor.RED + "NotAnOperator");
 return true;
}
}
