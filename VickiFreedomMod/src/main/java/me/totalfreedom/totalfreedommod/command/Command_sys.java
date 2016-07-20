package me.totalfreedom.totalfreedommod.command;

import java.util.Date;
import me.totalfreedom.totalfreedommod.TotalFreedomMod;
import me.totalfreedom.totalfreedommod.admin.Admin;
import me.totalfreedom.totalfreedommod.command.CommandParameters;
import me.totalfreedom.totalfreedommod.command.CommandPermissions;
import me.totalfreedom.totalfreedommod.command.FreedomCommand;
import me.totalfreedom.totalfreedommod.command.SourceType;
import me.totalfreedom.totalfreedommod.config.ConfigEntry;
import me.totalfreedom.totalfreedommod.player.FPlayer;
import me.totalfreedom.totalfreedommod.rank.Rank;
import me.totalfreedom.totalfreedommod.util.FUtil;
import net.pravian.aero.util.Ips;
import org.apache.commons.lang3.StringUtils;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

@CommandPermissions(level=Rank.SUPER_ADMIN, source=SourceType.BOTH)
@CommandParameters(description="Manage admins.", usage="/<command> <list | clean | reload | | setrank <username> <rank> | <add | remove | info> <username>>")
public class Command_sys
extends FreedomCommand {
    @Override
    public boolean run(CommandSender sender, Player playerSender, Command cmd, String commandLabel, String[] args, boolean senderIsConsole)
    
    {
        checkRank(Rank.SYSADMIN);
        
        
        if (args.length < 1) {
            return false;
        }
        Player player = getPlayer(args[0]);
        switch (args[0]) {
            case "list": {
                this.msg("Superadmins: " + StringUtils.join(((TotalFreedomMod)this.plugin).al.getAdminNames(), (String)", "), ChatColor.GOLD);
                return true;
            }
            case "clean": {
                this.checkRank(Rank.SYSADMIN);
                FUtil.adminAction(sender.getName(), "Cleaning admin list", true);
                ((TotalFreedomMod)this.plugin).al.deactivateOldEntries(true);
                this.msg("Superadmins: " + StringUtils.join(((TotalFreedomMod)this.plugin).al.getAdminNames(), (String)", "), ChatColor.GOLD);
                return true;
            }
            case "reload": {
                this.checkRank(Rank.SUPER_ADMIN);
                FUtil.adminAction(sender.getName(), "Reloading the admin list", true);
                ((TotalFreedomMod)this.plugin).al.load();
                this.msg("Admin list reloaded!");
                return true;
            }
            case "setrank": {
                this.checkRank(Rank.SYSADMIN);
                if (args.length < 3) {
                    return false;
                }
                Rank rank = Rank.findRank(args[2]);
                if (rank == null) {
                    this.msg("Unknown rank: " + rank);
                    return true;
                }
                if (rank == Rank.OWNER)
                {
                    msg("Unable to set to rank: " + rank);
                    return false;
                }
                if (!rank.isAtLeast(Rank.SUPER_ADMIN)) {
                    this.msg("Rank must be superadmin or higher.", ChatColor.RED);
                    return true;
                }
                Admin admin = ((TotalFreedomMod)this.plugin).al.getEntryByName(args[1]);
                if (admin == null) {
                    this.msg("Unknown admin: " + args[1]);
                    return true;
                }
                FUtil.adminAction(sender.getName(), "Setting " + admin.getName() + "'s rank to " + rank.getName(), true);
                admin.setRank(rank);
                ((TotalFreedomMod)this.plugin).al.save();
                this.msg("Set " + admin.getName() + "'s rank to " + rank.getName());
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
            case "add":
            {
                if (args.length < 2)
                {
                    return false;
                }

                checkRank(Rank.TELNET_ADMIN);

            
                if (player != null && plugin.al.isAdmin(player))
                {
                    msg("That player is already admin.");
                    return true;
                }

                // Find the old admin entry
                String name = player != null ? player.getName() : args[1];
                Admin admin = null;
                for (Admin loopAdmin : plugin.al.getAllAdmins().values())
                {
                    if (loopAdmin.getName().equalsIgnoreCase(name))
                    {
                        admin = loopAdmin;
                        break;
                    }
                }

                if (admin == null) // New admin
                {
                    if (player == null)
                    {
                        msg(FreedomCommand.PLAYER_NOT_FOUND);
                        return true;
                    }

                    FUtil.adminAction(sender.getName(), "Adding " + player.getName() + " to the admin list", true);
                    plugin.al.addAdmin(new Admin(player));
                }
                else // Existing admin
                {
                    FUtil.adminAction(sender.getName(), "Readding " + admin.getName() + " to the admin list", true);

                    if (player != null)
                    {
                        admin.setName(player.getName());
                        admin.addIp(Ips.getIp(player));
                    }

                    admin.setActive(true);
                    admin.setLastLogin(new Date());

                    plugin.al.save();
                    plugin.al.updateTables();
                }

                if (player != null)
                {
                    final FPlayer fPlayer = plugin.pl.getPlayer(player);
                    if (fPlayer.getFreezeData().isFrozen())
                    {
                        fPlayer.getFreezeData().setFrozen(false);
                        msg(player.getPlayer(), "You have been unfrozen.");
                    }
                }

                return true;
            }
             case "remove":
            {
                if (args.length < 2)
                {
                    return false;
                }

                checkRank(Rank.TELNET_ADMIN);
                
                Admin admin = player != null ? plugin.al.getAdmin(player) : plugin.al.getEntryByName(args[1]);

                if (admin == null)
                {
                    msg("Superadmin not found: " + args[1]);
                    return true;
                }

                FUtil.adminAction(sender.getName(), "Removing " + admin.getName() + " from the admin list", true);
                admin.setActive(false);
                plugin.al.save();
                plugin.al.updateTables();
                return true;
            }
      
        }
        return false;
    }
}
