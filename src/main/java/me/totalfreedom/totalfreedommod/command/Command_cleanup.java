package me.totalfreedom.totalfreedommod.command;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import me.totalfreedom.totalfreedommod.player.FPlayer;
import me.totalfreedom.totalfreedommod.rank.Rank;
import me.totalfreedom.totalfreedommod.util.FUtil;
import org.apache.commons.lang3.StringUtils;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;

@CommandPermissions(level = Rank.SUPER_ADMIN, source = SourceType.BOTH)
@CommandParameters(description = "Do all admin commands at once", usage = "/<command>")
public class Command_cleanup extends FreedomCommand
{
    
    private static final ChatColor[] BLOCKED = new ChatColor[]
    {
        ChatColor.MAGIC,
        ChatColor.STRIKETHROUGH,
        ChatColor.ITALIC,
        ChatColor.UNDERLINE,
        ChatColor.BLACK
    };
    private static final Pattern REGEX = Pattern.compile(ChatColor.COLOR_CHAR + "[" + StringUtils.join(BLOCKED, "") + "]", Pattern.CASE_INSENSITIVE);

    @Override
    public boolean run(CommandSender sender, Player playerSender, Command cmd, String commandLabel, String[] args, boolean senderIsConsole)
    {
        // Opall
        FUtil.adminAction(sender.getName(), "Opping all players on the server", false);

        boolean doSetGamemode = false;
        GameMode targetGamemode = GameMode.CREATIVE;
        if (args.length != 0)
        {
            if (args[0].equals("-c"))
            {
                doSetGamemode = true;
                targetGamemode = GameMode.CREATIVE;
            }
            else if (args[0].equals("-s"))
            {
                doSetGamemode = true;
                targetGamemode = GameMode.SURVIVAL;
            }
        }

        for (Player player : server.getOnlinePlayers())
        {
            player.setOp(true);
            player.sendMessage(FreedomCommand.YOU_ARE_OP);

            if (doSetGamemode)
            {
                player.setGameMode(targetGamemode);
            }
        }
        
        // Clean nick
        FUtil.adminAction(sender.getName(), "Cleaning all nicknames", false);

        for (final Player player : server.getOnlinePlayers())
        {
            final String playerName = player.getName();
            final String nickName = plugin.esb.getNickname(playerName);
            if (nickName != null && !nickName.isEmpty() && !nickName.equalsIgnoreCase(playerName))
            {
                final Matcher matcher = REGEX.matcher(nickName);
                if (matcher.find())
                {
                    final String newNickName = matcher.replaceAll("");
                    msg(ChatColor.RESET + playerName + ": \"" + nickName + ChatColor.RESET + "\" -> \"" + newNickName + ChatColor.RESET + "\".");
                    plugin.esb.setNickname(playerName, newNickName);
                }
            }
        }
        
        // Purgeall
        FUtil.adminAction(sender.getName(), "Purging all player data", true);

        // Purge entities
        plugin.ew.wipeEntities(true, true);

        for (Player player : server.getOnlinePlayers())
        {
            FPlayer fPlayer = plugin.pl.getPlayer(player);

            // Unmute all players
            if (fPlayer.isMuted())
            {
                fPlayer.setMuted(false);
            }

            // Unblock all commands
            if (fPlayer.allCommandsBlocked())
            {
                fPlayer.setCommandsBlocked(false);
            }

            // Stop orbiting
            if (fPlayer.isOrbiting())
            {
                fPlayer.stopOrbiting();
            }

            // Unfreeze
            if (fPlayer.getFreezeData().isFrozen())
            {
                fPlayer.getFreezeData().setFrozen(false);
            }

            // Purge potion effects
            for (PotionEffect potion_effect : player.getActivePotionEffects())
            {
                player.removePotionEffect(potion_effect.getType());
            }

            // Uncage
            if (fPlayer.getCageData().isCaged())
            {
                fPlayer.getCageData().setCaged(false);
            }
        }

        // Unfreeze all players
        plugin.fm.setGlobalFreeze(false);

        // Remove all mobs
        Command_mobpurge.purgeMobs();
        
        // Entitywipe
        FUtil.adminAction(sender.getName(), "Removing all server entities.", true);
        msg((plugin.ew.wipeEntities(true, true)) + " entities removed.");
        
        // Setl
        FUtil.adminAction(sender.getName(), "Setting everyone's Worldedit block modification limit to 2500.", true);
        for (final Player player : server.getOnlinePlayers())
        {
            plugin.web.setLimit(player, 2500);
        }
        
        // msg
        Player p = (Player) sender;
        
        p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&eNOTE: If you spam this, you will be suspended!"));


        return true;
    }
}
