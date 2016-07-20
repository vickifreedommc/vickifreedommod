package me.totalfreedom.totalfreedommod.command;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import me.totalfreedom.totalfreedommod.TotalFreedomMod;
import me.totalfreedom.totalfreedommod.admin.Admin;
import me.totalfreedom.totalfreedommod.banning.Ban;
import me.totalfreedom.totalfreedommod.command.CommandParameters;
import me.totalfreedom.totalfreedommod.command.CommandPermissions;
import me.totalfreedom.totalfreedommod.command.FreedomCommand;
import me.totalfreedom.totalfreedommod.command.SourceType;
import me.totalfreedom.totalfreedommod.config.ConfigEntry;
import me.totalfreedom.totalfreedommod.player.FPlayer;
import me.totalfreedom.totalfreedommod.player.PlayerData;
import me.totalfreedom.totalfreedommod.rank.Rank;
import me.totalfreedom.totalfreedommod.util.FUtil;
import net.pravian.aero.util.ChatUtils;
import net.pravian.aero.util.Ips;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import me.totalfreedom.totalfreedommod.admin.Admin;
import me.totalfreedom.totalfreedommod.rank.Rank;
import me.totalfreedom.totalfreedommod.util.FUtil;
import net.pravian.aero.util.ChatUtils;
import net.pravian.aero.util.Ips;
import org.apache.commons.lang3.StringUtils;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

@CommandPermissions(level=Rank.SUPER_ADMIN, source=SourceType.BOTH)
@CommandParameters(description="Manage admins.", usage="/<command> <list | info | unban <username> | ban <username> [reason] | setlogin <message> ")
public class Command_atools
extends FreedomCommand {
    @Override
    public boolean run(CommandSender sender, Player playerSender, Command cmd, String commandLabel, String[] args, boolean senderIsConsole)
    
    {
        
        
        if (args.length < 1) {
            return false;
        }
        
        Player init = null;
        Admin target = getAdmin(playerSender);
        Player targetPlayer = playerSender;
        String targetIp = Ips.getIp(targetPlayer);
        Player player = getPlayer(args[0]);
        switch (args[0]) {
            case "list": {
                this.msg("Superadmins: " + StringUtils.join(((TotalFreedomMod)this.plugin).al.getAdminNames(), (String)", "), ChatColor.GOLD);
                return true;
            }
            
            case "info": {
                if (args.length < 2) {
                    return false;
                }
                this.checkRank(Rank.SUPER_ADMIN);
                Admin admin = ((TotalFreedomMod)this.plugin).al.getEntryByName(args[1]);
                if (admin == null && (player = this.getPlayer(args[1])) != null) {
                    admin = ((TotalFreedomMod)this.plugin).al.getAdmin(player);
                }
                if (admin == null) {
                    this.msg("Superadmin not found: " + args[1]);
                } else {
                    this.msg(admin.toString());
                }
                return true;
            }
            
           
            case "unban": 
            {
                String username;
        final List<String> ips = new ArrayList<>();
        if (player == null)
        {
            final PlayerData entry = plugin.pl.getData(args[1]);

            if (entry == null)
            {
                msg("Can't find that user. If target is not logged in, make sure that you spelled the name exactly.");
                return true;
            }

            username = entry.getUsername();
            ips.addAll(entry.getIps());
        }
        else
        {
            final PlayerData entry = plugin.pl.getData(player);
            username = player.getName();
            ips.addAll(entry.getIps());
        }
                
                FUtil.adminAction(sender.getName(), "Unbanning " + username + " and IPs: " + StringUtils.join(ips, ", "), true);
            plugin.bm.removeBan(plugin.bm.getByUsername(username));

            for (String ip : ips)
            {
                Ban ban = plugin.bm.getByIp(ip);
                if (ban != null)
                {
                    plugin.bm.removeBan(ban);
                }
                ban = plugin.bm.getByIp(FUtil.getFuzzyIp(ip));
                if (ban != null)
                {
                    plugin.bm.removeBan(ban);
                }
                return true;
            }
            }
            
            case "ban":
            {
                if (args.length == 1)
        {
            return false;
        }
                
                if (player == null)
        {
            msg(FreedomCommand.PLAYER_NOT_FOUND, ChatColor.RED);
            return true;
        }
                
          if (isAdmin(player))
        {
            msg(player.getName() + " is an admin and cannot be banned. -.-");
            return true;
        }

        String reason = null;
        if (args.length >= 2)
        {
            reason = StringUtils.join(ArrayUtils.subarray(args, 1, args.length), " ");
        } 
        
        try
        {
            plugin.web.undo(player, 15);
        }
        catch (NoClassDefFoundError ex)
        {
        }

        plugin.rb.rollback(player.getName());

        player.setOp(false);

        player.setGameMode(GameMode.SURVIVAL);

        player.getInventory().clear();
        
        final Location targetPos = player.getLocation();
        for (int x = -1; x <= 1; x++)
        {
            for (int z = -1; z <= 1; z++)
            {
                final Location strike_pos = new Location(targetPos.getWorld(), targetPos.getBlockX() + x, targetPos.getBlockY(), targetPos.getBlockZ() + z);
                targetPos.getWorld().strikeLightning(strike_pos);
            }
        }

        String ip = FUtil.getFuzzyIp(Ips.getIp(player));

        // Broadcast
        final StringBuilder bcast = new StringBuilder()
                .append(ChatColor.RED)
                .append("Banning: ")
                .append(player.getName())
                .append(", IP: ")
                .append(ip);
        if (reason != null)
        {
            bcast.append(" - Reason: ").append(ChatColor.YELLOW).append(reason);
        }
        FUtil.bcastMsg(bcast.toString());

        // Ban player
        plugin.bm.addBan(Ban.forPlayerFuzzy(player, sender, null, reason));

        // Kick player
        player.kickPlayer(ChatColor.RED + "GTFO");

                return true;
            }
             case "rollback":
             {
                 msg(ChatColor.RED + "Do /rollback instead <3");
                 return true;
             }
        case "setlogin":
            {
                if (args.length < 2)
                {
                    return false;
                }

                String msg = StringUtils.join(args, " ", 1, args.length);
                FUtil.adminAction(sender.getName(), "Setting personal login message" + (init == null ? "" : " for " + targetPlayer.getName()), false);
                target.setLoginMessage(msg);
                msg((init == null ? "Your" : targetPlayer.getName() + "'s") + " login message is now: ");
                msg("> " + ChatColor.AQUA + targetPlayer.getName() + " is " + ChatUtils.colorize(target.getLoginMessage()));
                plugin.al.save();
                plugin.al.updateTables();
                return true;
            }
        }
            
        return false;
        }
    }

    
