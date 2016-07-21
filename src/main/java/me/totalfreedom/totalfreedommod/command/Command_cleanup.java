package me.totalfreedom.totalfreedommod.command;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import me.totalfreedom.totalfreedommod.player.FPlayer;
import me.totalfreedom.totalfreedommod.rank.Rank;
import me.totalfreedom.totalfreedommod.util.FUtil;
import org.apache.commons.lang3.StringUtils;
import org.bukkit.Bukkit;
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
        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "opall");
            Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "nickclean");
            Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "purgeall");
            Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "rd");
            Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "mp");
            Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "setl");
            Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "potion clearall");
            Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "invis smite");
        
        // msg
        Player p = (Player) sender;
        
        p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&eNOTE: If you spam this, you will be suspended!"));


        return true;
    }
}
