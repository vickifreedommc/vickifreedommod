package me.totalfreedom.totalfreedommod.command;

import me.totalfreedom.totalfreedommod.rank.Rank;
import org.apache.commons.lang3.StringUtils;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

@CommandPermissions(level = Rank.OP, source = SourceType.ONLY_IN_GAME)
@CommandParameters(description = "You have diabetes", usage = "/<command>", aliases = "dia")
public class Command_diabetes extends FreedomCommand
{
    @Override
    public boolean run(CommandSender sender, Player sender_p, Command cmd, String commandLabel, String[] args, boolean senderIsConsole)
    {
        sender.sendMessage(ChatColor.AQUA + "Bad news: You were just diagnosed with diabetes.");
        sender.sendMessage(ChatColor.DARK_RED + "and as hard as the bad news has to be broken to, you will die in...");
        sender_p.setHealth(0.0);
        sender.sendMessage(ChatColor.DARK_RED + "Rest in pepperoni...");
       
      
        return true;
    }
}