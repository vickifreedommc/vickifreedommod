
package me.totalfreedom.totalfreedommod.command;

import java.util.Arrays;
import java.util.List;
import me.totalfreedom.totalfreedommod.rank.Rank;
import me.totalfreedom.totalfreedommod.util.FUtil;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

@CommandPermissions(level = Rank.OP, source = SourceType.ONLY_IN_GAME)
@CommandParameters(
        description = "Add Lore to the current item in your hand.",
        usage = "/<command> <lore1> <lore2> <lore3> <lore4>",
        aliases = "lr")
public class Command_lore extends FreedomCommand
{
    @Override
    public boolean run(CommandSender sender, Player sender_p, Command cmd, String commandLabel, String[] args, boolean senderIsConsole)
    {
        if (args.length < 1)
        {
            return false;
        }
        ItemStack i = sender_p.getItemInHand();
        if (i != null)
        {
            ItemMeta im = i.getItemMeta();
            List<String> lore;
            if (args.length == 1)
            {
                lore = Arrays.asList(FUtil.colorize(args[0]).replaceAll("_", " "));
            }
            else if (args.length == 2)
            {
                lore = Arrays.asList(FUtil.colorize(args[0]).replaceAll("_", " "), FUtil.colorize(args[1]).replaceAll("_", " "));
            }
            else if (args.length == 3)
            {
                lore = Arrays.asList(FUtil.colorize(args[0]).replaceAll("_", " "), FUtil.colorize(args[1]).replaceAll("_", " "), FUtil.colorize(args[2]).replaceAll("_", " "));
            }
            else
            {
                lore = Arrays.asList(FUtil.colorize(args[0].replaceAll("_", " ")), FUtil.colorize(args[1].replaceAll("_", " ")), FUtil.colorize(args[2].replaceAll("_", " ")), FUtil.colorize(args[3]).replaceAll("_", " "));
            }
            im.setLore(lore);
            i.setItemMeta(im);
        }
        return true;
    }
}