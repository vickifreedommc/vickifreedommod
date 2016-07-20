
package me.totalfreedom.totalfreedommod.command;

import me.totalfreedom.totalfreedommod.admin.Admin;
import me.totalfreedom.totalfreedommod.banning.Ban;
import me.totalfreedom.totalfreedommod.player.FPlayer;
import me.totalfreedom.totalfreedommod.rank.Rank;
import me.totalfreedom.totalfreedommod.util.FUtil;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.Vector;

@CommandPermissions(level = Rank.SENIOR_ADMIN, source = SourceType.BOTH, blockHostConsole = true)
@CommandParameters(description = "For the bad Superadmins", usage = "/<command> <playername>")
public class Command_bananahammer extends FreedomCommand
{

    @Override
    public boolean run(final CommandSender sender, Player playerSender, Command cmd, String commandLabel, String[] args, boolean senderIsConsole)
    {   
        if (args.length < 1)
        {
            return false;
        }
        final Player player = getPlayer(args[0]);

        if (player == null)
        {
            sender.sendMessage(FreedomCommand.PLAYER_NOT_FOUND);
            return true;
        }
        final Location targetPos = player.getLocation();
        FUtil.adminAction(sender.getName(), "Bananahammering " + player.getName(), true);
        FUtil.bcastMsg(player.getName() + ", You shouldnt have done this...", ChatColor.RED);
        
        FUtil.bcastMsg(sender.getName() + " is so fucking mad right now, prepare to get fucked through the roof!", ChatColor.DARK_RED);
        FUtil.bcastMsg(sender.getName() + " is so fucking mad right now, prepare to get fucked through the roof!", ChatColor.RED);
        FUtil.bcastMsg(sender.getName() + " is so fucking mad right now, prepare to get fucked through the roof!", ChatColor.GOLD);
        FUtil.bcastMsg(sender.getName() + " is so fucking mad right now, prepare to get fucked through the roof!", ChatColor.YELLOW);
        FUtil.bcastMsg(sender.getName() + " is so fucking mad right now, prepare to get fucked through the roof!", ChatColor.GREEN);
        FUtil.bcastMsg(sender.getName() + " is so fucking mad right now, prepare to get fucked through the roof!", ChatColor.DARK_GREEN);
        FUtil.bcastMsg(sender.getName() + " is so fucking mad right now, prepare to get fucked through the roof!", ChatColor.DARK_BLUE);
        FUtil.bcastMsg(sender.getName() + " is so fucking mad right now, prepare to get fucked through the roof!", ChatColor.BLUE);
        FUtil.bcastMsg(sender.getName() + " is so fucking mad right now, prepare to get fucked through the roof!", ChatColor.DARK_AQUA);
        FUtil.bcastMsg(sender.getName() + " is so fucking mad right now, prepare to get fucked through the roof!", ChatColor.AQUA);
        FUtil.bcastMsg(sender.getName() + " is so fucking mad right now, prepare to get fucked through the roof!", ChatColor.LIGHT_PURPLE);
        FUtil.bcastMsg(sender.getName() + " is so fucking mad right now, prepare to get fucked through the roof!", ChatColor.DARK_PURPLE);
        FUtil.adminAction(sender.getName(), "Deopping " + player.getName(),false);
        player.setOp(false);
        player.setGameMode(GameMode.SURVIVAL);
        FUtil.bcastMsg("KAPOW!", ChatColor.RED);
        player.getWorld().createExplosion(targetPos, 0.0f, false);
        FUtil.bcastMsg("WAZAM!", ChatColor.YELLOW);
        player.getWorld().strikeLightning(targetPos);
        FUtil.bcastMsg("WOOSH!", ChatColor.AQUA);
        player.setVelocity(new Vector(0, 10, 0));
        FUtil.bcastMsg("You having fun? Cuz you'll regret that.", ChatColor.RED);
        FUtil.bcastMsg("FUCK YOU!", ChatColor.RED);
        FUtil.adminAction(sender.getName(), "Fucking " + player.getName() + " up the roof.", true);
        FUtil.adminAction(sender.getName(), "GET REKT MOTHERFUCKER", true);
       
        
        player.getWorld().strikeLightning(targetPos);
        
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

        // Ban player
        Ban ban = Ban.forPlayer(player, sender);
        ban.setReason("&cYou regretting it yet?!??");
        for (String playerIp : plugin.pl.getData(player).getIps())
        {
            ban.addIp(playerIp);
        }
        plugin.bm.addBan(ban);

        // Set gamemode to survival
        player.setGameMode(GameMode.SURVIVAL);

        // Clear inventory
        player.closeInventory();
        player.getInventory().clear();

        new BukkitRunnable()
        {
            @Override
            public void run()
            {
                // strike lightning
                player.getWorld().strikeLightning(player.getLocation());

                // kill (if not done already)
                player.setHealth(0.0);
            }
        }.runTaskLater(plugin, 2L * 20L);

        new BukkitRunnable()
        {
            @Override
            public void run()
            {
                // message
                FUtil.adminAction(sender.getName(), "Banning " + player.getName() + ", IP: " + ip, true);


                // kick player
                player.kickPlayer(ChatColor.RED + "You will regret you made " + sender.getName() + " mad!!!");
            }
        }.runTaskLater(plugin, 3L * 20L);

        return true;
    }
}