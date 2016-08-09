package me.totalfreedom.totalfreedommod.command;

import me.totalfreedom.totalfreedommod.command.CommandParameters;
import me.totalfreedom.totalfreedommod.command.CommandPermissions;
import me.totalfreedom.totalfreedommod.command.FreedomCommand;
import me.totalfreedom.totalfreedommod.command.SourceType;
import me.totalfreedom.totalfreedommod.rank.Rank;
import me.totalfreedom.totalfreedommod.util.FUtil;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import static sun.audio.AudioPlayer.player;

@CommandParameters(description = ";D", usage = "/<command> <playername>" , aliases = "emf")
@CommandPermissions(level = Rank.SUPER_ADMIN, source = SourceType.BOTH)
public class Command_englishmotherfucker extends FreedomCommand
{

    @Override
    public boolean run(CommandSender sender, Player sender_p, Command cmd, String commandLabel, String[] args, boolean senderIsConsole)
    {
        
        if (args.length < 1) {
            return false;
        }
        final Player player = getPlayer(args[0]);
        if (player == null)
        {
            msg(FreedomCommand.PLAYER_NOT_FOUND);
            return true;
        }
         if (isAdmin(player))
        {
            msg(ChatColor.RED + "You can not EMF administrators");
            return true;
        }
        
        FUtil.bcastMsg(ChatColor.RED + sender.getName() + " is sick of " + player.getName() + " not speaking english!");
        player.setOp(false);
        player.setGameMode(GameMode.SURVIVAL);
        player.getInventory().clear();

        final Location targetPos = player.getLocation();
        final World world = player.getWorld();
        for (int x = -1; x <= 1; x++)
        {
            for (int z = -1; z <= 1; z++)
            {
                final Location strike_pos = new Location(world, targetPos.getBlockX() + x, targetPos.getBlockY(), targetPos.getBlockZ() + z);
                world.strikeLightning(strike_pos);
            }
        }
        player.setHealth(0.0);
        msg(ChatColor.RED + "ENGLISH MOTHER FUCKER! DO YOU SPEAK IT?!");
        msg(ChatColor.RED + "ENGLISH MOTHER FUCKER! DO YOU SPEAK IT?!");
        msg(ChatColor.RED + "ENGLISH MOTHER FUCKER! DO YOU SPEAK IT?!");
        msg(ChatColor.RED + "ENGLISH MOTHER FUCKER! DO YOU SPEAK IT?!");
        FUtil.bcastMsg(ChatColor.RED + sender.getName() + " is now done obliterating " + player.getName());
        
       return true;
    }
    
}
