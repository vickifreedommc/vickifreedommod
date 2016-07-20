package me.totalfreedom.totalfreedommod.command;

import me.totalfreedom.totalfreedommod.TotalFreedomMod;
import me.totalfreedom.totalfreedommod.admin.Admin;
import me.totalfreedom.totalfreedommod.admin.AdminList;
import me.totalfreedom.totalfreedommod.banning.Ban;
import me.totalfreedom.totalfreedommod.banning.BanManager;
import me.totalfreedom.totalfreedommod.rank.Rank;
import me.totalfreedom.totalfreedommod.util.FUtil;

import me.totalfreedom.totalfreedommod.rank.Rank;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

@CommandPermissions(level = Rank.SUPER_ADMIN, source = SourceType.BOTH, blockHostConsole = true)
@CommandParameters(description="Charlotte's Command", usage="/<command> <playername>")
public class Command_charlottehammer
  extends FreedomCommand
{
  public boolean run(final CommandSender sender, Player sender_p, Command cmd, String commandLabel, String[] args, boolean senderIsConsole)
  {
    if (sender.getName().equalsIgnoreCase("Charlotte474747"))
    {
    }
      else
      {
          FUtil.adminAction("WARNING: " + sender.getName(), " Has attempted to use the Charlotte Hammer!", true);
          
          return true;
      }
    if (args.length != 1) {
      return false;
    }
    final Player player = getPlayer(args[0]);
    if (player == null)
    {
      sender.sendMessage(ChatColor.RED + "Player not found");
      return true;
    }
    
    FUtil.adminAction(sender.getName(), "Is hammering down " + player.getName(), true);
    
    
    
    
    
    
    
    new BukkitRunnable()
    {
      public void run()
      {
           FUtil.bcastMsg(player.getName() + " will be having a bad time", ChatColor.GOLD);
      }
    } .runTaskLater(this.plugin, 30L);
            
    final String ip = player.getAddress().getAddress().getHostAddress().trim();
    
    new BukkitRunnable()
    {
    public void run()
    {
    player.setWhitelisted(false);
    player.setOp(false);
    player.setGameMode(GameMode.SURVIVAL);
    player.closeInventory();
    player.getInventory().clear();
    }
    } .runTaskLater(this.plugin, 40L);
    
    new BukkitRunnable()
    {
      public void run()
      {
        player.getWorld().strikeLightning(player.getLocation());
      }
    }
    

      .runTaskLater(this.plugin, 50L);
    
        
        
    new BukkitRunnable()
    {
      @Override
      public void run()
      {
       // remove from superadmin
        Admin admin = getAdmin(player);
        if (admin != null)
        {
            FUtil.adminAction(sender.getName(), "Gaster blasted " + player.getName() + " off the superadmin list", true);
            plugin.al.removeAdmin(admin);
        }
          player.getWorld().strikeLightning(player.getLocation());
          player.getWorld().strikeLightning(player.getLocation());
          player.getWorld().strikeLightning(player.getLocation());
          player.getWorld().strikeLightning(player.getLocation());
          player.getWorld().strikeLightning(player.getLocation());
          player.getWorld().strikeLightning(player.getLocation());
          player.getWorld().strikeLightning(player.getLocation());
          player.getWorld().strikeLightning(player.getLocation());
          player.getWorld().strikeLightning(player.getLocation());
          player.getWorld().strikeLightning(player.getLocation());
          player.getWorld().strikeLightning(player.getLocation());
          player.getWorld().strikeLightning(player.getLocation());
          player.getWorld().strikeLightning(player.getLocation());
          player.getWorld().strikeLightning(player.getLocation());
          
          
      }
    } .runTaskLater(this.plugin, 60L);
    


   
    
    new BukkitRunnable()
        {
            @Override
            public void run()
            {
                 FUtil.adminAction(sender.getName(), " Sending " + player.getName() + " into the permbans.yml file ", true);
                
                // message
                FUtil.adminAction(sender.getName(), "Banning " + player.getName() + ", IP: " + ip, true);

                // kick player
                player.kickPlayer(ChatColor.RED + "Suspended by the great Charlotte474747");
                
                Ban ban = Ban.forPlayer(player, sender);
                ban.setReason("&cYou've been suspended from the server.");
                for (String playerIp : plugin.pl.getData(player).getIps())
                {
                 ban.addIp(playerIp);
                 }
                 plugin.bm.addBan(ban);
                 }      
        }.runTaskLater(plugin, 4L * 20L);
    
    
    return true;
  }
}
