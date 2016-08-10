package me.totalfreedom.totalfreedommod.command;

import me.totalfreedom.totalfreedommod.rank.Rank;
import me.totalfreedom.totalfreedommod.util.FUtil;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import static org.bukkit.GameMode.CREATIVE;
import static org.bukkit.GameMode.SURVIVAL;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

@CommandPermissions(level = Rank.SYSADMIN, source = SourceType.BOTH)
@CommandParameters(description = "Crash someone with an error message", usage = "/<command> [player] [error message]")
public class Command_crash extends FreedomCommand
{
    @Override
    public boolean run(CommandSender sender, Player sender_p, Command cmd, String commandLabel, String[] args, boolean senderIsConsole)
    {
        if (args.length < 1) {
            return false;
        }
        if (args.length == 2) {
            msg(ChatColor.RED + "You must provide an error message!");
        }
        
        String errorMessage = null;
        if (args.length >= 2)
        {
            errorMessage = StringUtils.join(ArrayUtils.subarray(args, 1, args.length), " ");
        }
        final Player player = getPlayer(args[0]);
        if (player == null) {
            msg(ChatColor.RED + "Player not found!");
        }
       player.kickPlayer(ChatColor.RED + "Error: " + errorMessage);
       msg(ChatColor.RED + "Successfully crashed/kicked " + player.getName());

       
        
     return true;   
    }
    }
