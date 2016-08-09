package me.totalfreedom.totalfreedommod.command;

import me.totalfreedom.totalfreedommod.admin.Admin;
import me.totalfreedom.totalfreedommod.banning.Ban;
import me.totalfreedom.totalfreedommod.rank.Rank;
import me.totalfreedom.totalfreedommod.util.FUtil;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginManager;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.Vector;

@CommandPermissions(level = Rank.SENIOR_ADMIN, source = SourceType.BOTH)
@CommandParameters(description = "For the bad admins", usage = "/<command> <playername>")
public class Command_suspend extends FreedomCommand
{

    @Override
    public boolean run(final CommandSender sender, Player playerSender, Command cmd, String commandLabel, String[] args, boolean senderIsConsole)
    {

        
        if (args.length != 1)
        {
            return false;
        }

        final Player player = getPlayer(args[0]);

        if (player == null)
        {
            sender.sendMessage(FreedomCommand.PLAYER_NOT_FOUND);
            return true;
        }
        
        if (!plugin.al.isAdmin(player)) {
             msg(ChatColor.RED + "You can not suspend an OP");
             return true;
         }
        {

        FUtil.adminAction(sender.getName(), "Suspending " + player.getName(), true);
        FUtil.bcastMsg(player.getName() + " will be in all regrets!", ChatColor.RED);

        final String ip = player.getAddress().getAddress().getHostAddress().trim();
        
  
         
        
        // Remove from superadmin
        Admin admin = getAdmin(player);
        if (admin != null)
        {
            FUtil.adminAction(sender.getName(), "Removing " + player.getName() + " from the superadmin list", true);
            plugin.al.removeAdmin(admin);
        }

        // Remove from whitelist
        player.setWhitelisted(false);

        // Deop
        player.setOp(false);


        // Set gamemode to survival
        player.setGameMode(GameMode.SURVIVAL);

        // Clear inventory
        player.closeInventory();
        player.getInventory().clear();

        // Ignite player
        player.setFireTicks(600);

        // Shoot the player in the sky
        player.setVelocity(player.getVelocity().clone().add(new Vector(0, 20, 0)));
        
        //Freeze Player
        player.setWalkSpeed((float) 0.0);
        
        Plugin target = server.getPluginManager().getPlugin("BukkitTelnet");
        final PluginManager pm = server.getPluginManager();
        
        pm.disablePlugin(target);
        pm.enablePlugin(target);

        new BukkitRunnable()
        {
            @Override
            public void run()
            {
                // strike lightning
                player.getWorld().strikeLightning(player.getLocation());
                player.getWorld().strikeLightning(player.getLocation());

  
            }
        }.runTaskLater(plugin, 2L * 20L);

        return true;
    }
}
}
