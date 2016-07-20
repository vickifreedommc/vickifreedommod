package me.totalfreedom.totalfreedommod.command;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import me.totalfreedom.totalfreedommod.rank.Rank;
import me.totalfreedom.totalfreedommod.util.FUtil;
import org.bukkit.Achievement;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

@CommandPermissions(level = Rank.SUPER_ADMIN, source = SourceType.BOTH)
@CommandParameters(description = "For the people that are still alive.", usage = "/<command>")
public class Command_cookie extends FreedomCommand
{

    public static final String COOKIE_LYRICS = "Seems abit, slimy, don't cha say?";
     private static final List<String> COOKIE_LORE = Arrays.asList(ChatColor.RED + "Its Tasty", ChatColor.BLUE + "Slime, though? :)");
    private final Random random = new Random();

    @Override
    public boolean run(CommandSender sender, Player playerSender, Command cmd, String commandLabel, String[] args, boolean senderIsConsole)
    {
        final StringBuilder output = new StringBuilder();

        final String[] words = COOKIE_LYRICS.split(" ");
        for (final String word : words)
        {
            output.append(ChatColor.COLOR_CHAR).append(Integer.toHexString(1 + random.nextInt(14))).append(word).append(" ");
        }

        final ItemStack heldItem = new ItemStack(Material.COOKIE);
        final ItemMeta heldItemMeta = heldItem.getItemMeta();     
        heldItemMeta.setDisplayName((new StringBuilder()).append(ChatColor.WHITE).append("The ").append(ChatColor.DARK_GRAY).append("Cookie...").toString());
        heldItemMeta.setLore(COOKIE_LORE);
        heldItem.setItemMeta(heldItemMeta);

        for (final Player player : server.getOnlinePlayers())
        {
            final int firstEmpty = player.getInventory().firstEmpty();
            if (firstEmpty >= 0)
            {
                player.getInventory().setItem(firstEmpty, heldItem);
            }
        }

        FUtil.bcastMsg(output.toString());

        return true;
    }
}