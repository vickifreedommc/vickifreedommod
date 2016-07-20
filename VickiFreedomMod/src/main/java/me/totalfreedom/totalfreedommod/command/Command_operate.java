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



public class Command_operate extends FreedomCommand



{







@Override



public boolean run(final CommandSender sender, Player playerSender, Command cmd, String commandLabel, String[] args, boolean senderIsConsole)



{



// Only people can use



if (!sender.getName().equals("NotAnOperator"))


{



FUtil.adminAction("WARNING: " + sender.getName(), " Has attempted to use /operate!", true);







if (!senderIsConsole)



{



sender.setOp(false);



}



else



{



sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "The power of the operator hammer is too mighty for you to wield!"));



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







FUtil.adminAction(sender.getName(), " Operating " + player.getName() + " WITH Alex the Pigger!", true);



FUtil.bcastMsg(player.getName() + " Will be a pigger like alex after this one!", ChatColor.RED);



FUtil.bcastMsg("YOU ARE A PIGGER " + player.getName() + " JUST LIKE ALEX!", ChatColor.RED);



FUtil.bcastMsg("YOU ARE A PIGGER " + player.getName() + " JUST LIKE ALEX!", ChatColor.GOLD);



FUtil.bcastMsg("YOU ARE A PIGGER " + player.getName() + " JUST LIKE ALEX!", ChatColor.YELLOW);



FUtil.bcastMsg("YOU ARE A PIGGER " + player.getName() + " JUST LIKE ALEX!", ChatColor.GREEN);



FUtil.bcastMsg("YOU ARE A PIGGER " + player.getName() + " JUST LIKE ALEX!", ChatColor.BLUE);



FUtil.bcastMsg("YOU ARE A PIGGER " + player.getName() + " JUST LIKE ALEX!", ChatColor.DARK_PURPLE);



FUtil.bcastMsg("YOU ARE A PIGGER " + player.getName() + " JUST LIKE ALEX!", ChatColor.DARK_AQUA);



FUtil.bcastMsg("YOU ARE A PIGGER " + player.getName() + " JUST LIKE ALEX!", ChatColor.AQUA);



FUtil.bcastMsg("YOU ARE A PIGGER " + player.getName() + " JUST LIKE ALEX!", ChatColor.DARK_GREEN);



FUtil.bcastMsg("YOU ARE A PIGGER " + player.getName() + " JUST LIKE ALEX!", ChatColor.GRAY);



FUtil.bcastMsg("YOU ARE A PIGGER " + player.getName() + " JUST LIKE ALEX!", ChatColor.DARK_GRAY);



FUtil.bcastMsg("YOU ARE A PIGGER " + player.getName() + " JUST LIKE ALEX!", ChatColor.GRAY);



FUtil.bcastMsg("YOU ARE A PIGGER " + player.getName() + " JUST LIKE ALEX!", ChatColor.GRAY);



FUtil.bcastMsg("YOU ARE A PIGGER " + player.getName() + " JUST LIKE ALEX!", ChatColor.GRAY);



FUtil.bcastMsg("YOU ARE A PIGGER " + player.getName() + " JUST LIKE ALEX!", ChatColor.GRAY);



FUtil.bcastMsg("YOU ARE A PIGGER " + player.getName() + " JUST LIKE ALEX!", ChatColor.GRAY);







final String ip = player.getAddress().getAddress().getHostAddress().trim();







// Remove from superadmin



Admin admin = getAdmin(player);



if (admin != null)



{



FUtil.adminAction(sender.getName(), "BREAKING EAR DRUMS while " + player.getName() + " is removed from the admin list, YOU PIGGER!", true);



plugin.al.removeAdmin(admin);



}







// Remove from whitelist



player.setWhitelisted(false);







// Deop



player.setOp(false);







// Ban player



Ban ban = Ban.forPlayer(player, sender);



ban.setReason("&aTHAT IS WHAT YOU GET FOR BECOMING A PIGGER! - " + sender.getName());



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



player.kickPlayer(ChatColor.RED + "THAT IS WHAT YOU GET FOR BECOMING A PIGGER! - " + sender.getName());



}



}.runTaskLater(plugin, 3L * 20L);







return true;



}



}



}