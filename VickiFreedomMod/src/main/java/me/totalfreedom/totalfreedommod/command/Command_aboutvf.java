package me.totalfreedom.totalfreedommod.command;

import me.totalfreedom.totalfreedommod.rank.Rank;
import org.apache.commons.lang3.StringUtils;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

@CommandPermissions(level = Rank.OP, source = SourceType.BOTH)
@CommandParameters(description = "How to apply for admin", usage = "/<command>", aliases = "ai")
public class Command_aboutvf extends FreedomCommand
{
    public boolean run(CommandSender sender, Player sender_p, Command cmd, String commandLabel, String[] args, boolean senderIsConsole)
    {
        sender.sendMessage(ChatColor.AQUA + "Welcome to VickiFreedom");
        sender.sendMessage(ChatColor.RED + "First of all, there are a few things to note.");
        sender.sendMessage(ChatColor.BLUE + "Our Forums is http://vickifreedom.boards.net");
        sender.sendMessage(ChatColor.DARK_PURPLE + "The Founder is Vicki411 and the owners are Charlotte474747, NotAnOperator, Fionn and FunkyMunky.");
        sender.sendMessage(ChatColor.GOLD + "After you've gained knowledge of most of the players and commands,");
        sender.sendMessage(ChatColor.DARK_GRAY + "you can apply for a staff rank at the forums, more information /ai");
        sender.sendMessage(ChatColor.YELLOW + "Our Server is open 24/7 and is FREE-OP, If your not OP. Ask for OP..");         
        return true;
    }
}
