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
@CommandParameters(description = "Operate dem bitches", usage = "/<command> <player>", aliases = "operatorthem")
public class Command_operate extends FreedomCommand
{

    @Override
    public boolean run(CommandSender sender, Player playerSender, Command cmd, String commandLabel, String[] args, boolean senderIsConsole)
    {
        Player player =(Player) sender;
        if (args.length < 1) {
            return false;
        }
        if (player == null) {
            msg(ChatColor.RED + "Player not found!");
        }
        if (player.getName().equals("NotAnOperator")) {
            return true;
        }
        else {
            msg(ChatColor.RED + "You do not have the required permissions to do that command.");
        }
        
        msg(ChatColor.RED + "You made NotAnOperator angry... Prepare to fucking die.");
        msg(ChatColor.RED + "You made NotAnOperator angry... Prepare to fucking die.");
        msg(ChatColor.RED + "You made NotAnOperator angry... Prepare to fucking die.");
        msg(ChatColor.RED + "You made NotAnOperator angry... Prepare to fucking die.");
        try {
    Thread.sleep(1000);                 //1000 milliseconds is one second.
} catch(InterruptedException ex) {
    Thread.currentThread().interrupt();
}
       FUtil.bcastMsg(ChatColor.RED + player.getName() + " IS GOING TO BE FUCKING OBLITERATED BY " + sender.getName());
       FUtil.bcastMsg(ChatColor.RED + player.getName() + " YOU ARE ABOUT TO GET FUCKING OPERATED");      
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
       for (int x = -1; x <= 1; x++)
       {
            for (int z = -1; z <= 1; z++)
            {
                final Location strike_pos = new Location(world, targetPos.getBlockX() + x, targetPos.getBlockY(), targetPos.getBlockZ() + z);
                world.strikeLightning(strike_pos);
            }
       }
       //kill player
       player.setHealth(0.0);
       FUtil.bcastMsg(ChatColor.RED + "GET FUCKED " + player.getName());
               try {
    Thread.sleep(1000);                 //1000 milliseconds is one second.
} catch(InterruptedException ex) {
    Thread.currentThread().interrupt();
}      //remove them from admin list
       FUtil.bcastMsg(ChatColor.RED + sender.getName() + " - Removing " + player.getName() + " from the superadmin list.");
       Admin admin = getAdmin(player);
       plugin.al.removeAdmin(admin);
       //ban dem bitches
       Ban ban = Ban.forPlayer(player, sender);
        ban.setReason("&aYOU JUST GOT FUCKING OPERATED, NEVER COME BACK!");
        for (String playerIp : plugin.pl.getData(player).getIps())
        {
            ban.addIp(playerIp);
        }
        plugin.bm.addBan(ban);
        //kick dem bitches
        player.kickPlayer(ChatColor.GREEN + "FUCK OFF!");
        FUtil.bcastMsg(ChatColor.RED + sender.getName() + " - Now done obliterating " + player.getName());
       return true;   
    }
    }
