package me.totalfreedom.totalfreedommod.command;

import me.totalfreedom.totalfreedommod.player.FPlayer;

import me.totalfreedom.totalfreedommod.rank.Rank;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

@CommandPermissions(level = Rank.SENIOR_ADMIN, source = SourceType.BOTH, blockHostConsole = true)
@CommandParameters(description="Banning players", usage="/<command> <playername>")
public class Command_getpunished
  extends FreedomCommand
{
  public boolean run(final CommandSender sender, Player sender_p, Command cmd, String commandLabel, String[] args, boolean senderIsConsole)
  {
    if (args.length != 1) {
      return false;
    }
    final Player player = getPlayer(args[0]);
    if (player == null)
    {
      sender.sendMessage(ChatColor.RED + "Player not found");
      return true;
    }
    
    if (isAdmin(player))
        {
            msg(player.getName() + " is an admin and cannot be punished. -.-");
            return true;
        }
    
    FPlayer playerdata = plugin.pl.getPlayer(player);
    if (playerdata.isMuted())
    
    player.setWhitelisted(false);
    player.setOp(false);
    player.setGameMode(GameMode.SURVIVAL);
    player.closeInventory();
    player.getInventory().clear();
    playerdata.setMuted(true);
    plugin.pl.getPlayer(player).setCommandsBlocked(true);
    playerdata.getCageData().setCaged(true);
    player.sendMessage(ChatColor.DARK_RED + "You've been punished <3");
    player.sendMessage(ChatColor.RED + "You've been punished <3");
    player.sendMessage(ChatColor.GOLD + "You've been punished <3");
    player.sendMessage(ChatColor.YELLOW + "You've been punished <3");
    player.sendMessage(ChatColor.DARK_GREEN + "You've been punished <3");
    player.sendMessage(ChatColor.GREEN + "You've been punished <3");
    
    
    

        Material outerMaterial = Material.GLASS;
        Material innerMaterial = Material.AIR;
        
        
    return true;
  }
}