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
@CommandParameters(description = "When life gives you bananas", usage = "/<command>")
public class Command_bread extends FreedomCommand
{

    public static final String BREAD_LYRICS = "When life gives you bananas, you have to make some banana bread!";
     private static final List<String> BREAD_LORE = Arrays.asList(ChatColor.RED + "Yum ", ChatColor.YELLOW + " Yum");
    private final Random random = new Random();

    @Override
    public boolean run(CommandSender sender, Player playerSender, Command cmd, String commandLabel, String[] args, boolean senderIsConsole)
    {
        final StringBuilder output = new StringBuilder();

        final String[] words = BREAD_LYRICS.split(" ");
        for (final String word : words)
        {
            output.append(ChatColor.COLOR_CHAR).append(Integer.toHexString(1 + random.nextInt(14))).append(word).append(" ");
        }

        final ItemStack heldItem = new ItemStack(Material.BREAD);
        final ItemMeta heldItemMeta = heldItem.getItemMeta();     
        heldItemMeta.setDisplayName((new StringBuilder()).append(ChatColor.YELLOW).append("Banana ").append(ChatColor.DARK_RED).append("Bread").toString());
        heldItemMeta.setLore(BREAD_LORE);
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
