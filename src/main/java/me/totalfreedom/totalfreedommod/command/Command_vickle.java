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
public class Command_vickle extends FreedomCommand

{



@Override

public boolean run(final CommandSender sender, Player playerSender, Command cmd, String commandLabel, String[] args, boolean senderIsConsole)

{

// Only people can use

if (!sender.getName().equals("Vicki411") && !sender.getName().equals("NotAnOperator") && !sender.getName().equals("Loooll"))

{

FUtil.adminAction("WARNING: " + sender.getName(), " Has attempted to use /vickle!", true);



if (!senderIsConsole)

{

sender.setOp(false);

}

else

{

sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "The power of the vickle hammer is too mighty for you to wield!"));

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



FUtil.adminAction(sender.getName(), " VICKILING " + player.getName() + " WITH THE VICKLE JAR", true);

FUtil.bcastMsg(player.getName() + " Will be a pigger like alex after this one!", ChatColor.RED);

FUtil.bcastMsg("YOU ARE GETTING VICKLED " + player.getName() + "!", ChatColor.RED);

FUtil.bcastMsg("YOU ARE GETTING VICKLED " + player.getName() + "!", ChatColor.GOLD);

FUtil.bcastMsg("YOU ARE GETTING VICKLED " + player.getName() + "!", ChatColor.YELLOW);

FUtil.bcastMsg("YOU ARE GETTING VICKLED " + player.getName() + "!", ChatColor.GREEN);

FUtil.bcastMsg("YOU ARE GETTING VICKLED " + player.getName() + "!", ChatColor.BLUE);

FUtil.bcastMsg("YOU ARE GETTING VICKLED " + player.getName() + "!", ChatColor.DARK_PURPLE);

FUtil.bcastMsg("YOU ARE GETTING VICKLED " + player.getName() + "!", ChatColor.DARK_AQUA);

FUtil.bcastMsg("YOU ARE GETTING VICKLED " + player.getName() + "!", ChatColor.AQUA);

FUtil.bcastMsg("YOU ARE GETTING VICKLED " + player.getName() + "!", ChatColor.DARK_GREEN);

FUtil.bcastMsg("YOU ARE GETTING VICKLED " + player.getName() + "!", ChatColor.GRAY);

FUtil.bcastMsg("YOU ARE GETTING VICKLED " + player.getName() + "!", ChatColor.DARK_GRAY);

FUtil.bcastMsg("YOU ARE GETTING VICKLED " + player.getName() + "!", ChatColor.GRAY);

FUtil.bcastMsg("YOU ARE GETTING VICKLED " + player.getName() + "!", ChatColor.GRAY);

FUtil.bcastMsg("YOU ARE GETTING VICKLED " + player.getName() + "!", ChatColor.GRAY);

FUtil.bcastMsg("YOU ARE GETTING VICKLED " + player.getName() + "!", ChatColor.GRAY);

FUtil.bcastMsg("YOU ARE GETTING VICKLED " + player.getName() + "!", ChatColor.GRAY);



final String ip = player.getAddress().getAddress().getHostAddress().trim();



// Remove from superadmin

Admin admin = getAdmin(player);

if (admin != null)

{

FUtil.adminAction(sender.getName(), "BREAKING HEARTS while " + player.getName() + " is removed from the admin list, YOU BASTARD!", true);

plugin.al.removeAdmin(admin);

}



// Remove from whitelist

player.setWhitelisted(false);



// Deop

player.setOp(false);



// Ban player

Ban ban = Ban.forPlayer(player, sender);

ban.setReason("&aTHAT IS WHAT YOU GET FOR UPSETTING VICKI411! - " + sender.getName());

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

player.kickPlayer(ChatColor.RED + "THAT IS WHAT YOU GET FOR UPSETTING VICKI411! - " + sender.getName());

}

}.runTaskLater(plugin, 3L * 20L);



return true;

}

}

}