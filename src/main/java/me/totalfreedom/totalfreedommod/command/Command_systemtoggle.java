package me.totalfreedom.totalfreedommod.command;

import me.totalfreedom.totalfreedommod.GameRuleHandler.GameRule;
import me.totalfreedom.totalfreedommod.config.ConfigEntry;
import me.totalfreedom.totalfreedommod.rank.Rank;
import me.totalfreedom.totalfreedommod.util.FUtil;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

@CommandPermissions(level = Rank.SYSADMIN, source = SourceType.BOTH)
@CommandParameters(description = "Toggles TotalFreedomMod settings", usage = "/<command> [option] [value] [value]", aliases = "stog")
public class Command_systemtoggle extends FreedomCommand
{

    @Override
    public boolean run(CommandSender sender, Player playerSender, Command cmd, String commandLabel, String[] args, boolean senderIsConsole)
    {
    
        if (args.length == 0)
        {
            msg("Available toggles: ");
            msg("- structureplace");
            msg("- signplace");
            msg("- skullplace");
            msg("- nonuke [range] [count]");
            msg("- explosives [radius]");
            return false;
        }

                    
        if (args[0].equals("structureplace"))
        {
            toggle("Structure placement is", ConfigEntry.ALLOW_STRUCTURE_PLACE);
            return true;
        }
        
        if (args[0].equals("signplace"))
        {
            toggle("Sign placement is", ConfigEntry.ALLOW_SIGN_PLACE);
            return true;
        }
        
        if (args[0].equals("skullplace"))
        {
            toggle("Skull placement is", ConfigEntry.ALLOW_SKULL_PLACE);
            return true;
        }
        
        if (args[0].equals("nonuke"))
        {
            if (args.length >= 2)
            {
                try
                {
                    ConfigEntry.NUKE_MONITOR_RANGE.setDouble(Math.max(1.0, Math.min(500.0, Double.parseDouble(args[1]))));
                }
                catch (NumberFormatException nfex)
                {
                }
            }

            if (args.length >= 3)
            {
                try
                {
                    ConfigEntry.NUKE_MONITOR_COUNT_BREAK.setInteger(Math.max(1, Math.min(500, Integer.parseInt(args[2]))));
                }
                catch (NumberFormatException nfex)
                {
                }
            }

            toggle("Nuke monitor is", ConfigEntry.NUKE_MONITOR_ENABLED);

            if (ConfigEntry.NUKE_MONITOR_ENABLED.getBoolean())
            {
                msg("Anti-freecam range is set to " + ConfigEntry.NUKE_MONITOR_RANGE.getDouble() + " blocks.");
                msg("Block throttle rate is set to " + ConfigEntry.NUKE_MONITOR_COUNT_BREAK.getInteger() + " blocks destroyed per 5 seconds.");
            }

            return true;
        }
        if (args[0].equals("explosives"))
        {
            if (args.length == 2)
            {
                try
                {
                    ConfigEntry.EXPLOSIVE_RADIUS.setDouble(Math.max(1.0, Math.min(30.0, Double.parseDouble(args[1]))));
                }
                catch (NumberFormatException ex)
                {
                    msg(ex.getMessage());
                    return true;
                }
            }

            toggle("Explosions are", ConfigEntry.ALLOW_EXPLOSIONS);

            if (ConfigEntry.ALLOW_EXPLOSIONS.getBoolean())
            {
                msg("Radius set to " + ConfigEntry.EXPLOSIVE_RADIUS.getDouble());
            }
            return true;
        }

        return false;
    }
        
        
        
        
        private void toggle(String name, ConfigEntry entry)
    {
        msg(name + " now " + (entry.setBoolean(!entry.getBoolean()) ? "enabled." : "disabled."));
    }
}
