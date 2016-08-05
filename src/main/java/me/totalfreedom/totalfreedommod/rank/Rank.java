package me.totalfreedom.totalfreedommod.rank;

import lombok.Getter;
import org.bukkit.ChatColor;

public enum Rank implements Displayable
{

    IMPOSTOR("an", "Impostor", Type.PLAYER, "Imp", ChatColor.YELLOW),
    NON_OP("a", "Non-Op", Type.PLAYER, "", ChatColor.GREEN),
    OP("an", "Op", Type.PLAYER, "OP", ChatColor.RED),
    SUPER_ADMIN("a", "Super Admin", Type.ADMIN, "SA", ChatColor.AQUA),
    TELNET_ADMIN("a", "Telnet Admin", Type.ADMIN, "STA", ChatColor.DARK_GREEN),
    TELNET_CLAN_ADMIN("a", "Telnet Clan Admin", Type.ADMIN, "TCA", ChatColor.GREEN),
    SENIOR_ADMIN("a", "Senior Admin", Type.ADMIN, "SrA", ChatColor.GOLD),
    TELNET_CONSOLE("the", "Console", Type.ADMIN_CONSOLE, "Console", ChatColor.DARK_PURPLE),
    SENIOR_CONSOLE("the", "Console", Type.ADMIN_CONSOLE, "Console", ChatColor.DARK_PURPLE),
    EXECUTIVE("a", "Executive", Type.ADMIN, "Executive", ChatColor.GOLD),
    SYSADMIN("a", "System-Admin", Type.ADMIN, "System-Admin", ChatColor.GREEN),
    OWNER("the", "Owner", Type.ADMIN, "Owner", ChatColor.BLUE),
    EXECUTIVE_CONSOLE("the", "Console", Type.ADMIN_CONSOLE, "Console", ChatColor.DARK_PURPLE),
    SYSADMIN_CONSOLE("the", "Console", Type.ADMIN_CONSOLE, "Console", ChatColor.DARK_PURPLE),
    CHIP("is", "Chip", Type.ADMIN_CONSOLE, "Chip", ChatColor.GREEN),
    PUG("a", "Pug", Type.ADMIN_CONSOLE, "Pug", ChatColor.GOLD),
    PUG_CONSOLE("the", "Console", Type.ADMIN_CONSOLE, "Console", ChatColor.DARK_PURPLE),
    CHIP_CONSOLE("the", "Console", Type.ADMIN_CONSOLE, "Console", ChatColor.DARK_PURPLE),
    MASTER_BUILDER("a", "Master Builder", Type.ADMIN, "Builder", ChatColor.DARK_AQUA),
    SECURITY("a", "Security Officer", Type.ADMIN_CONSOLE, "Security", ChatColor.BLUE),
    OWNER_CONSOLE("the", "Console", Type.ADMIN_CONSOLE, "Console", ChatColor.DARK_PURPLE);
    @Getter
    private final Type type;
    @Getter
    private final String name;
    private final String determiner;
    @Getter
    private final String tag;
    @Getter
    private final String coloredTag;
    @Getter
    private final ChatColor color;

    private Rank(String determiner, String name, Type type, String abbr, ChatColor color)
    {
        this.type = type;
        this.name = name;
        this.determiner = determiner;
        this.tag = abbr.isEmpty() ? "" : "[" + abbr + "]";
        this.coloredTag = abbr.isEmpty() ? "" : ChatColor.DARK_GRAY + "[" + color + abbr + ChatColor.DARK_GRAY + "]" + color;
        this.color = color;
    }

    @Override
    public String getColoredName()
    {
        return color + name;
    }

    @Override
    public String getColoredLoginMessage()
    {
        return determiner + " " + color + ChatColor.ITALIC + name;
    }

    public boolean isConsole()
    {
        return getType() == Type.ADMIN_CONSOLE;
    }

    public int getLevel()
    {
        return ordinal();
    }

    public boolean isAtLeast(Rank rank)
    {
        if (getLevel() < rank.getLevel())
        {
            return false;
        }

        if (!hasConsoleVariant() || !rank.hasConsoleVariant())
        {
            return true;
        }

        return getConsoleVariant().getLevel() >= rank.getConsoleVariant().getLevel();
    }

    public boolean isAdmin()
    {
        return getType() == Type.ADMIN || getType() == Type.ADMIN_CONSOLE;
    }

    public boolean hasConsoleVariant()
    {
        return getConsoleVariant() != null;
    }

    public Rank getConsoleVariant()
    {
        switch (this)
        {
            case TELNET_ADMIN:
            case TELNET_CONSOLE:
                return TELNET_CONSOLE;
            case SENIOR_ADMIN:
            case SENIOR_CONSOLE:
                return SENIOR_CONSOLE;
            case EXECUTIVE:
            case EXECUTIVE_CONSOLE:
                return EXECUTIVE_CONSOLE;
            case SYSADMIN:
            case SYSADMIN_CONSOLE:
                return SYSADMIN_CONSOLE;
            case OWNER:
            case OWNER_CONSOLE:
                return OWNER_CONSOLE;
            case CHIP:
                return CHIP_CONSOLE;
            case PUG:
                return PUG_CONSOLE;
            default:
                return null;
        }
    }

    public Rank getPlayerVariant()
    {
        switch (this)
        {
            case TELNET_ADMIN: 
            case TELNET_CONSOLE: 
            case TELNET_CLAN_ADMIN: {
                return TELNET_CONSOLE;
            }
            case SENIOR_ADMIN:
            case SENIOR_CONSOLE:
                return SENIOR_ADMIN;
            case EXECUTIVE:
            case EXECUTIVE_CONSOLE:
                return EXECUTIVE;
            case SYSADMIN:
            case SYSADMIN_CONSOLE:
                return SYSADMIN;
            case OWNER:
            case OWNER_CONSOLE:
                return OWNER;
            case CHIP:
            return CHIP;
            case PUG:
            return PUG;
            case SECURITY:
                return SECURITY;
            default:
                return null;
        }
    }

    public static Rank findRank(String string)
    {
        try
        {
            return Rank.valueOf(string.toUpperCase());
        }
        catch (Exception ignored)
        {
        }

        return Rank.NON_OP;
    }

    public boolean contains(String name)
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
    public static enum Type
    {

        PLAYER,
        FUCKBOY,
        ADMIN,
        ADMIN_CONSOLE;

        public boolean isAdmin()
        {
            return this != PLAYER;
        }
    }

}
