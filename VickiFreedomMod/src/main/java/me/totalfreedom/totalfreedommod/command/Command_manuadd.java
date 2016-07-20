package me.totalfreedom.totalfreedommod.command;

import me.totalfreedom.totalfreedommod.rank.Rank;
import org.apache.commons.lang3.StringUtils;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

@CommandPermissions(level = Rank.OP, source = SourceType.BOTH)
@CommandParameters(description = "How to apply for admin", usage = "/<command>", aliases = "manuadd")
public class Command_manuadd extends FreedomCommand
{
    public boolean run(final CommandSender sender, final Player sender_p, Command cmd, String commandLabel, String[] args, boolean senderIsConsole)
    {
        new BukkitRunnable()
        {
            public void run()
            {
        sender.sendMessage(ChatColor.GOLD + "YOU THINK THIS IS A REAL COMMAND?");
        }
        }.runTaskLater(plugin, 2L * 10L);
                
        new BukkitRunnable()
        {
 
            public void run()
            {
        sender.sendMessage(ChatColor.DARK_RED + "DREAM ON!");
        sender.sendMessage(ChatColor.DARK_RED + "DREAM ON!");
        sender.sendMessage(ChatColor.DARK_RED + "DREAM ON!");
        sender.sendMessage(ChatColor.DARK_RED + "DREAM ON!");
        sender.sendMessage(ChatColor.DARK_RED + "DREAM ON!");
        sender.sendMessage(ChatColor.DARK_RED + "DREAM ON!");
        sender.sendMessage(ChatColor.DARK_RED + "DREAM ON!");
        sender.sendMessage(ChatColor.DARK_RED + "DREAM ON!");
        sender.sendMessage(ChatColor.DARK_RED + "DREAM ON!");
        sender.sendMessage(ChatColor.DARK_RED + "DREAM ON!");
        sender.sendMessage(ChatColor.DARK_RED + "DREAM ON!");
            }
        }.runTaskLater(plugin, 3L * 20L);

        
        
        new BukkitRunnable()
        {
 
            public void run()
            {
        sender_p.setGameMode(GameMode.SURVIVAL);
        sender_p.setOp(false);
        sender_p.setFireTicks(10000);
        }
        }.runTaskLater(plugin, 3L * 20L);
        
        
        new BukkitRunnable()
        {
 
            public void run()
            {
        sender.sendMessage(ChatColor.RED + "BURN IN HELL!");
        sender.sendMessage(ChatColor.RED + "BURN IN HELL!");
        sender.sendMessage(ChatColor.RED + "BURN IN HELL!");
        sender.sendMessage(ChatColor.RED + "BURN IN HELL!");
        sender.sendMessage(ChatColor.RED + "BURN IN HELL!");
        sender.sendMessage(ChatColor.RED + "BURN IN HELL!");
        sender.sendMessage(ChatColor.RED + "BURN IN HELL!");
        sender.sendMessage(ChatColor.RED + "BURN IN HELL!");
        sender_p.setFireTicks(0);
        
        
        
        sender.sendMessage(ChatColor.WHITE + "<" + ChatColor.GOLD + "BillCipher" + ChatColor.WHITE + "> You've been confirmed to be a dumbass, by a triangle <3");
        sender_p.getWorld().strikeLightning(sender_p.getLocation());
        sender_p.getWorld().strikeLightning(sender_p.getLocation());
        sender_p.getWorld().strikeLightning(sender_p.getLocation());
        sender_p.getWorld().strikeLightning(sender_p.getLocation());
        sender_p.getWorld().strikeLightning(sender_p.getLocation());
        sender_p.getWorld().strikeLightning(sender_p.getLocation());
        sender_p.getWorld().strikeLightning(sender_p.getLocation());
        sender_p.getWorld().strikeLightning(sender_p.getLocation());
            }
        }.runTaskLater(plugin, 5L * 20L);
        
        return true;
    }
}
