package me.totalfreedom.totalfreedommod.command;

import java.util.Arrays;
import java.util.List;
import me.totalfreedom.totalfreedommod.command.CommandParameters;
import me.totalfreedom.totalfreedommod.command.CommandPermissions;
import me.totalfreedom.totalfreedommod.command.FreedomCommand;
import me.totalfreedom.totalfreedommod.command.SourceType;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.PlayerInventory;
import me.totalfreedom.totalfreedommod.rank.Rank;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

@CommandPermissions(level = Rank.OP, source = SourceType.ONLY_IN_GAME)
@CommandParameters(description = "Get a chara kit. Undertale fan, <3", usage = "/<command>")
public class Command_chara extends FreedomCommand
{
     private static final List<String> KNIFE_LORE = Arrays.asList(ChatColor.RED + "About time", ChatColor.DARK_RED + "Here we are!");
     private static final List<String> LOCKET_LORE = Arrays.asList(ChatColor.RED + "You can feel it beating", ChatColor.DARK_RED + "Right where it belongs");
     @Override
    public boolean run(CommandSender sender, Player sender_p, Command cmd, String commandLabel, String[] args, boolean senderIsConsole)
    {
        PlayerInventory inv = sender_p.getInventory();
         
        final ItemStack heldItem = new ItemStack(Material.IRON_SWORD);
        final ItemMeta heldItemMeta = heldItem.getItemMeta();
        heldItemMeta.setLore(KNIFE_LORE);
        heldItemMeta.setDisplayName((new StringBuilder()).append(ChatColor.DARK_RED).append("Real ").append(ChatColor.RED).append("Knife").toString());
        heldItemMeta.addEnchant(Enchantment.DAMAGE_ALL, 20, true);
        heldItemMeta.addEnchant(Enchantment.DURABILITY, 20, true);
        heldItemMeta.addEnchant(Enchantment.MENDING, 20, true);
        heldItem.setItemMeta(heldItemMeta);

        final ItemStack compassItem = new ItemStack(Material.DIAMOND_CHESTPLATE);
        final ItemMeta compassMeta = heldItem.getItemMeta();
        compassMeta.setDisplayName((new StringBuilder()).append(ChatColor.DARK_RED).append("The ").append(ChatColor.RED).append("Locket").toString());
        compassMeta.setLore(LOCKET_LORE);
        compassMeta.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 50, true);
        compassMeta.addEnchant(Enchantment.DURABILITY, 50, true);
        compassItem.setItemMeta(compassMeta);
    
    
              inv.addItem(heldItem);
              inv.addItem(compassItem);
              
             sender_p.sendMessage(ChatColor.RED + "Chara's item have been placed into your inventory");
        return true;
            }
 }