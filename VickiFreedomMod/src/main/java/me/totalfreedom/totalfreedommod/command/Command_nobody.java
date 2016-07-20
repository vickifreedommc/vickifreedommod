package me.totalfreedom.totalfreedommod.command;

import me.totalfreedom.totalfreedommod.rank.Rank;
import me.totalfreedom.totalfreedommod.util.FUtil;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import static sun.audio.AudioPlayer.player;




@CommandPermissions(level=Rank.SUPER_ADMIN, source=SourceType.BOTH)
@CommandParameters(description="Don't like someone? This is the command for you!", usage="/<command> <player>", aliases = "nly")
public class Command_nobody extends FreedomCommand {
    @Override
    public boolean run(CommandSender sender, Player playerSender, Command cmd, String commandLabel, String[] args, boolean senderIsConsole)
    
    {
         FUtil.adminAction(sender.getName(), "Doesn't like " + player.getName() + "!", ChatColor.GOLD, true);
        return true;
    }
    
}