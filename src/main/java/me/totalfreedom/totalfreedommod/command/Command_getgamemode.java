package me.totalfreedom.totalfreedommod.command;

import me.totalfreedom.totalfreedommod.rank.Rank;
import org.bukkit.ChatColor;
import static org.bukkit.GameMode.CREATIVE;
import static org.bukkit.GameMode.SURVIVAL;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

@CommandPermissions(level = Rank.SUPER_ADMIN, source = SourceType.BOTH)
@CommandParameters(description = "Get the gamemode of any player", usage = "/<command> [player]")
public class Command_getgamemode extends FreedomCommand
{
    @Override
    public boolean run(CommandSender sender, Player playerSender, Command cmd, String commandLabel, String[] args, boolean senderIsConsole)
    {
    
    final Player player = getPlayer(args[0]);
        
            if (player == null) {
                sender.sendMessage(FreedomCommand.PLAYER_NOT_FOUND);
            }
            if (player.getGameMode() == CREATIVE) {
               sender.sendMessage(ChatColor.DARK_RED + player.getName() + ChatColor.RED + " is in Creative."); 
            } else if (player.getGameMode() == SURVIVAL) {
               sender.sendMessage(ChatColor.DARK_RED + player.getName() + ChatColor.RED + " is in Survival."); 
            }
            

        return true;
    }
}
