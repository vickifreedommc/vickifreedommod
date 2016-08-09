package me.totalfreedom.totalfreedommod.command;

import me.totalfreedom.totalfreedommod.admin.Admin;
import me.totalfreedom.totalfreedommod.banning.Ban;
import me.totalfreedom.totalfreedommod.rank.Rank;
import me.totalfreedom.totalfreedommod.util.FUtil;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

@CommandPermissions(level = Rank.SUPER_ADMIN, source = SourceType.BOTH)
@CommandParameters(description = "Banish players for five minutes", usage = "/<command> <player>", aliases = "banishplayer,gtho,leavebitch")
public class Command_banish extends FreedomCommand
{

    @Override
    public boolean run(CommandSender sender, Player playerSender, Command cmd, String commandLabel, String[] args, boolean senderIsConsole)
    {
        Player player = (Player) sender;
        if (args.length < 1) {
            return false;
        }
        if (player == null) {
            msg(PLAYER_NOT_FOUND);
        }
        player.sendMessage(ChatColor.RED + "LEAVE NOW I, " + sender.getName() + " BANISH THEE " + player.getName() + "!");
        try {
    Thread.sleep(1000);                 //1000 milliseconds is one second.
} catch(InterruptedException ex) {
    Thread.currentThread().interrupt();
}
        FUtil.bcastMsg(ChatColor.RED + sender.getName() + " - banishing " + player.getName() + " for five minutes");
        try {
    Thread.sleep(1000);                 //1000 milliseconds is one second.
} catch(InterruptedException ex) {
    Thread.currentThread().interrupt();
}
       //deop
       player.setOp(false);
       //set invulnerable off
       player.setInvulnerable(false);
       //close inventory
       player.closeInventory();
       //set gamemode to survival
       player.setGameMode(GameMode.SURVIVAL);
       //strike lightning on location
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
       try {
    Thread.sleep(1000);                 //1000 milliseconds is one second.
} catch(InterruptedException ex) {
    Thread.currentThread().interrupt();
}
       //ban dem 
       Ban ban = Ban.forPlayer(player, sender);
        ban.setReason("&cYou have been banished from the server for 5 minutes. Return then.");
        for (String playerIp : plugin.pl.getData(player).getIps())
        {
            ban.addIp(playerIp);
        }
        plugin.bm.addBan(ban);
        //kick dem 
        player.kickPlayer(ChatColor.RED + "You have been banished from the server for 5 minutes. Return then.");
        
        
        
     return true;   
    }
    }
