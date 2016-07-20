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
@CommandParameters(description="Banning players", usage="/<command> <playername>")
public class Command_herohammer
  extends FreedomCommand
{
  public boolean run(final CommandSender sender, Player sender_p, Command cmd, String commandLabel, String[] args, boolean senderIsConsole)
  {
    if (sender.getName().equalsIgnoreCase("heroguy42"))
    {
    }
      else
      {
          msg(NO_PERMISSION);
          
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
    FUtil.adminAction(sender.getName(), " is banning a noob, aka " + player.getName(), true);
    
    
    
    
    
    
    
    
    
    
    
    
    FUtil.bcastMsg(sender.getName() + " is going to punish" + player.getName() + " for being a rule breaker", ChatColor.RED);
    
    final String ip = player.getAddress().getAddress().getHostAddress().trim();
    
    player.setWhitelisted(false);
    player.setOp(false);
    player.setGameMode(GameMode.SURVIVAL);
    player.closeInventory();
    player.getInventory().clear();

    
    new BukkitRunnable()
    {
      public void run()
      {
        player.getWorld().strikeLightning(player.getLocation());
      }
    }
    

      .runTaskLater(this.plugin, 40L);
    
        
        
    new BukkitRunnable()
    {
      @Override
      public void run()
      {
       // remove from superadmin
        Admin admin = getAdmin(player);
        if (admin != null)
        {
            FUtil.adminAction(sender.getName(), "Smashing " + player.getName() + " from the superadmin list", true);
            plugin.al.removeAdmin(admin);
        }
          player.getWorld().strikeLightning(player.getLocation());
      }
    }
    
      .runTaskLater(this.plugin, 40L);
    


    FUtil.adminAction(sender.getName(), ":" + " Time to put you in hell!, :)", true);
    
    new BukkitRunnable()
        {
            @Override
            public void run()
            {
                // message
                FUtil.adminAction(sender.getName(), "Banning " + player.getName() + ", IP: " + ip, true);
                // kick player
                player.kickPlayer(ChatColor.RED + "Do not mess with the heroine - heroguy42");
                // Ban player
        Ban ban = Ban.forPlayer(player, sender);
        ban.setReason("&cDo not mess with the heroine -heroguy42");
        for (String playerIp : plugin.pl.getData(player).getIps())
        {
            ban.addIp(playerIp);
        }
        plugin.bm.addBan(ban);
            }
        }.runTaskLater(plugin, 3L * 20L);

    return true;
  }
}
