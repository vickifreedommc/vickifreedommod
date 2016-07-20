package me.totalfreedom.totalfreedommod.command;

import me.totalfreedom.totalfreedommod.rank.Rank;
import org.apache.commons.lang3.StringUtils;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

@CommandPermissions(level = Rank.SUPER_ADMIN, source = SourceType.BOTH)
@CommandParameters(description = "VickiFreedom command list.", usage = "/<command> [p1] [p2] [p3] [p4] [p5]")
public class Command_vfmcmd extends FreedomCommand
{
    public boolean run(CommandSender sender, Player sender_p, Command cmd, String commandLabel, String[] args, boolean senderIsConsole)
    {
        if (args.length == 0)
        {
            sender.sendMessage(ChatColor.GOLD + "Do /vfmcmd [p1] [p2] [p3] [p4] [p5]");
            return true;
        }
        
        if (args[0].equals("p1"))
        { 
            sender.sendMessage(ChatColor.GRAY + "-=-=- " + ChatColor.GOLD + "VickiFreedomMod Page 1" + ChatColor.GRAY + " -=-=-");
            sender.sendMessage(ChatColor.GOLD + "1. " + ChatColor.LIGHT_PURPLE + "/adminchat or /o");
            sender.sendMessage(ChatColor.GOLD + "2. " + ChatColor.LIGHT_PURPLE + "/admininformation or /ai");
            sender.sendMessage(ChatColor.GOLD + "3. " + ChatColor.LIGHT_PURPLE + "/adminmode <on/off>" + ChatColor.GREEN + "(Telnet+ only)");
            sender.sendMessage(ChatColor.GOLD + "4. " + ChatColor.LIGHT_PURPLE + "/adminworld");
            sender.sendMessage(ChatColor.GOLD + "5. " + ChatColor.LIGHT_PURPLE + "/announce <message>");
            sender.sendMessage(ChatColor.RED + "Bonus!" + ChatColor.LIGHT_PURPLE + " /admintools");
            return true;
        }
        
        if (args[0].equals("p2"))
        {
            sender.sendMessage(ChatColor.GRAY + "-=-=- " + ChatColor.GOLD + "VickiFreedomMod Page 2" + ChatColor.GRAY + " -=-=-");
            sender.sendMessage(ChatColor.GOLD + "6. " + ChatColor.LIGHT_PURPLE + "/bacon");
            sender.sendMessage(ChatColor.GOLD + "7. " + ChatColor.LIGHT_PURPLE + "/bananahammer" + ChatColor.GOLD + "(Senior+ Only)");
            sender.sendMessage(ChatColor.GOLD + "8. " + ChatColor.LIGHT_PURPLE + "/banlist");
            sender.sendMessage(ChatColor.GOLD + "9. " + ChatColor.LIGHT_PURPLE + "/blockcmd");
            sender.sendMessage(ChatColor.GOLD + "10. " + ChatColor.LIGHT_PURPLE + "/cage");
            return true;
        }
        
        if (args[0].equals("p3"))
        {
            sender.sendMessage(ChatColor.GRAY + "-=-=- " + ChatColor.GOLD + "VickiFreedomMod Page 3" + ChatColor.GRAY + " -=-=-");
            sender.sendMessage(ChatColor.GOLD + "11. " + ChatColor.LIGHT_PURPLE + "/cake");
            sender.sendMessage(ChatColor.GOLD + "12. " + ChatColor.LIGHT_PURPLE + "/cartsit");
            sender.sendMessage(ChatColor.GOLD + "13. " + ChatColor.LIGHT_PURPLE + "/cbtool");
            sender.sendMessage(ChatColor.GOLD + "14. " + ChatColor.LIGHT_PURPLE + "/cmdspy");
            sender.sendMessage(ChatColor.GOLD + "15. " + ChatColor.LIGHT_PURPLE + "/colorme");
            return true;
        }
        
        if (args[0].equals("p4"))
        {
            sender.sendMessage(ChatColor.GRAY + "-=-=- " + ChatColor.GOLD + "VickiFreedomMod Page 4" + ChatColor.GRAY + " -=-=-");
            sender.sendMessage(ChatColor.GOLD + "16. " + ChatColor.LIGHT_PURPLE + "/commandlist or /cmdlist");
            sender.sendMessage(ChatColor.GOLD + "17. " + ChatColor.LIGHT_PURPLE + "/csay or /consolesay");
            sender.sendMessage(ChatColor.GOLD + "18. " + ChatColor.LIGHT_PURPLE + "/cookie");
            sender.sendMessage(ChatColor.GOLD + "19. " + ChatColor.LIGHT_PURPLE + "/creative");
            sender.sendMessage(ChatColor.GOLD + "20. " + ChatColor.LIGHT_PURPLE + "/deafen" + ChatColor.GOLD + "(Senior+ Only)");
            return true;
        }
        
        if (args[0].equals("p5"))
        {
            sender.sendMessage(ChatColor.GRAY + "-=-=- " + ChatColor.GOLD + "VickiFreedomMod Page 5" + ChatColor.GRAY + " -=-=-");
            sender.sendMessage(ChatColor.GOLD + "21. " + ChatColor.LIGHT_PURPLE + "/debug");
            sender.sendMessage(ChatColor.GOLD + "22. " + ChatColor.LIGHT_PURPLE + "/denick");
            sender.sendMessage(ChatColor.GOLD + "23. " + ChatColor.LIGHT_PURPLE + "/deop");
            sender.sendMessage(ChatColor.GOLD + "24. " + ChatColor.LIGHT_PURPLE + "/deopall");
            sender.sendMessage(ChatColor.GOLD + "25. " + ChatColor.LIGHT_PURPLE + "/diabetes");  
            return true;
        }
        return true;
    }
}
