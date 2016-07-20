
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
import org.bukkit.scheduler.BukkitRunnable;



@CommandPermissions(level = Rank.SUPER_ADMIN, source = SourceType.ONLY_IN_GAME)
@CommandParameters(description = "WHAT IS UP DRAMAALERT NATION", usage = "/<command>")
public class Command_dramaalert extends FreedomCommand
{

    @Override
       public boolean run(final CommandSender sender, Player playerSender, Command cmd, String commandLabel, String[] args, boolean senderIsConsole)
    {
 {
     
     new BukkitRunnable()
    {
      public void run()
      {
        msg(ChatColor.translateAlternateColorCodes('&', "&aPREPARE FOR SPAM!!!!!!"));
      }
    }
    

      .runTaskLater(this.plugin, 20L);
     
     new BukkitRunnable()
    {
      public void run()
      {
        msg(ChatColor.translateAlternateColorCodes('&', "&aWHAT IS UPP DRAMAALERT NATIONNNN"));
      }
    }
    

      .runTaskLater(this.plugin, 30L);
    
     new BukkitRunnable()
    {
      public void run()
      {
       msg(ChatColor.translateAlternateColorCodes('&', "&aI'M YOUR HOST, " + sender.getName() + "!!!!!"));
      }
    }
    

      .runTaskLater(this.plugin, 40L);
    

    new BukkitRunnable()
    {
      public void run()
      {
        msg(ChatColor.translateAlternateColorCodes('&', "&aLET'S GET RIIIIIIIGGGHHTTT INTO THE NEWS!"));
      }
    }
    

      .runTaskLater(this.plugin, 50L);
    
       
  
    return true;
    
    }
    }
}
         
