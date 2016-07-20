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
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

@CommandPermissions(level = Rank.SUPER_ADMIN, source = SourceType.BOTH)
@CommandParameters(description = "Its tasty, why not?", usage = "/<command> [-a]")
public class Command_bacon extends FreedomCommand
{
    public static final String BACON_LYRICS = "Hmm, what's that smell? CHICKEN? BREAD? CAKE? COOKIE? NOPE IT'S BACON!";
    private static final List<String> BACON_LORE = Arrays.asList(ChatColor.RED + "Its Tasty", ChatColor.BLUE + "#BaconIsLoveBaconIsLife");
    private final Random random = new Random();

    @Override
    public boolean run(CommandSender sender, Player sender_p, Command cmd, String commandLabel, String[] args, boolean senderIsConsole)
    {
        final StringBuilder output = new StringBuilder();

        final String[] words = BACON_LYRICS.split(" ");
        for (final String word : words)
        {
            output.append(ChatColor.COLOR_CHAR).append(Integer.toHexString(1 + random.nextInt(14))).append(word).append(" ");
        }

        final ItemStack heldItem = new ItemStack(Material.PORK);
        final ItemMeta heldItemMeta = heldItem.getItemMeta();
        heldItemMeta.setDisplayName((new StringBuilder()).append(ChatColor.WHITE).append("Diabetes ").append(ChatColor.DARK_GRAY).append("Source").toString());
        heldItemMeta.setLore(BACON_LORE);
        heldItemMeta.addEnchant(Enchantment.DURABILITY, 127, true);
        heldItem.setItemMeta(heldItemMeta);

        for (final Player player : server.getOnlinePlayers())
        {
            final int firstEmpty = player.getInventory().firstEmpty();
            if (firstEmpty >= 0)
            {
                player.getInventory().setItem(firstEmpty, heldItem);
            }
            player.awardAchievement(Achievement.FLY_PIG);
        }
        FUtil.bcastMsg(output.toString());
    return true;
    }
}