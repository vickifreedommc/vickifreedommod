package me.totalfreedom.totalfreedommod.command;

import me.totalfreedom.totalfreedommod.rank.Rank;
import org.apache.commons.lang3.StringUtils;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

@CommandPermissions(level = Rank.OP, source = SourceType.BOTH)
@CommandParameters(description = "How to apply for admin", usage = "/<command>", aliases = "ai")
public class Command_admininformation extends FreedomCommand
{
    public boolean run(CommandSender sender, Player sender_p, Command cmd, String commandLabel, String[] args, boolean senderIsConsole)
    {
        sender.sendMessage(ChatColor.AQUA + "So you want to be an admin?");
        sender.sendMessage(ChatColor.RED + "First of all, there are a few things to note.");
        sender.sendMessage(ChatColor.BLUE + "You must be registered to our forum for at least 30 days");
        sender.sendMessage(ChatColor.DARK_PURPLE + "You must also be helpful and have gained a recommendation from an active admin.");
        sender.sendMessage(ChatColor.GOLD + "After you've gained knowledge of most of the players,");
        sender.sendMessage(ChatColor.DARK_GRAY + "and admins, go to the forum and create a Admin Application thread");
        sender.sendMessage(ChatColor.YELLOW + "using the Admin Application template and patiently wait for it to be responded to.");         
        return true;
    }
}
