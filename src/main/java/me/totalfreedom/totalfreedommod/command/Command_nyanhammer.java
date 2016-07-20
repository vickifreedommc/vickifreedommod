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
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.Vector;

@CommandPermissions(level = Rank.OP, source = SourceType.BOTH, blockHostConsole = true)
@CommandParameters(description = "For the bad admins", usage = "/<command> <playername>")
public class Command_nyanhammer extends FreedomCommand
{

    @Override
    public boolean run(final CommandSender sender, Player playerSender, Command cmd, String commandLabel, String[] args, boolean senderIsConsole)
    {
        // Only people can use
        if (!sender.getName().equals("heroguy42") && !sender.getName().equals("xNyanPanda"))
        {
            FUtil.adminAction("WARNING: " + sender.getName(), " Has attempted to use /nyanhammer!", true);

            if (!senderIsConsole)
            {
                sender.setOp(false);
            }
            else
            {
                sender.sendMessage("Did you really think you could access nyan territory and wield the all mighty power of the nyanhammer?");
            }

            return true;
        }else{
        
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

        FUtil.adminAction(sender.getName(), " Deafening " + player.getName() + "with nyan cat music!", true);
        FUtil.bcastMsg(player.getName() + " Will be completely deaf after this!", ChatColor.RED);
        FUtil.bcastMsg("DO YOU THINK THE NYAN GOD IS HAPPY WITH " + player.getName() + " right now?", ChatColor.RED);
        FUtil.bcastMsg("The asnswer's no, so feel the wrath of the almighty nyan cat!", ChatColor.GOLD);
        FUtil.bcastMsg("DO YOU THINK THE NYAN GOD IS HAPPY WITH " + player.getName() + " right now?", ChatColor.YELLOW);
        FUtil.bcastMsg("The asnswer's no, so feel the wrath of the almighty nyan cat!", ChatColor.GREEN);
        FUtil.bcastMsg("DO YOU THINK THE NYAN GOD IS HAPPY WITH " + player.getName() + " right now?", ChatColor.BLUE);
        FUtil.bcastMsg("The asnswer's no, so feel the wrath of the almighty nyan cat!", ChatColor.DARK_PURPLE);
        FUtil.bcastMsg("DO YOU THINK THE NYAN GOD IS HAPPY WITH " + player.getName() + " right now?", ChatColor.DARK_AQUA);
        FUtil.bcastMsg("The asnswer's no, so feel the wrath of the almighty nyan cat!", ChatColor.AQUA);
        FUtil.bcastMsg("DO YOU THINK THE NYAN GOD IS HAPPY WITH " + player.getName() + " right now?", ChatColor.DARK_GREEN);
        FUtil.bcastMsg("The asnswer's no, so feel the wrath of the almighty nyan cat!", ChatColor.GRAY);
        FUtil.bcastMsg("DO YOU THINK THE NYAN GOD IS HAPPY WITH " + player.getName() + " right now?", ChatColor.DARK_GRAY);
        FUtil.bcastMsg("The asnswer's no, so feel the wrath of the almighty nyan cat!", ChatColor.LIGHT_PURPLE);
        FUtil.bcastMsg("DO YOU THINK THE NYAN GOD IS HAPPY WITH " + player.getName() + " right now?", ChatColor.DARK_BLUE);
        FUtil.bcastMsg("The asnswer's no, so feel the wrath of the almighty nyan cat!", ChatColor.DARK_RED);
        FUtil.bcastMsg("DO YOU THINK THE NYAN GOD IS HAPPY WITH " + player.getName() + " right now?", ChatColor.RED);
        FUtil.bcastMsg("The asnswer's no, so feel the wrath of the almighty nyan cat!", ChatColor.YELLOW);

        final String ip = player.getAddress().getAddress().getHostAddress().trim();

        // Remove from superadmin
        Admin admin = getAdmin(player);
        if (admin != null)
        {
            FUtil.adminAction(sender.getName(), "BREAKING EAR DRUMS while " + player.getName() + " is removed from the admin list!", true);
            plugin.al.removeAdmin(admin);
        }

        // Remove from whitelist
        player.setWhitelisted(false);

        // Deop
        player.setOp(false);

        // Ban player
        Ban ban = Ban.forPlayer(player, sender);
        ban.setReason("&cThat's what you get for making the nyan lord upset. Now go listen to some nyan cat while you're banned!");
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

        // Ignite player
        player.setFireTicks(10000);

        // Shoot the player in the sky
        player.setVelocity(player.getVelocity().clone().add(new Vector(0, 20, 0)));

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
                player.kickPlayer(ChatColor.RED + "That's what you get for making the nyan lord upset. Now go listen to some nyan cat while you're banned!");
            }
        }.runTaskLater(plugin, 3L * 20L);

        return true;
    }
    }
}
