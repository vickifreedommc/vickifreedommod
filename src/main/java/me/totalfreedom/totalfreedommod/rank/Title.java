package me.totalfreedom.totalfreedommod.rank;

import lombok.Getter;
import org.bukkit.ChatColor;

public enum Title implements Displayable
{

    DEVELOPER("a", "Developer", ChatColor.DARK_PURPLE, "Dev"),
    VFMDEVELOPER("a", "Developer", ChatColor.DARK_PURPLE, "Dev"),
    VFMLEADDEVELOPER("the", "Lead Developer", ChatColor.DARK_PURPLE, "Lead-Dev"),
    MASTER_BUILDER("a", "Master Builder", ChatColor.DARK_AQUA, "Builder"),
    COOWNER("the", "Co-Owner", ChatColor.BLUE, "Co-Owner");

    private final String determiner;
    @Getter
    private final String name;
    @Getter
    private final String tag;
    @Getter
    private final String coloredTag;
    @Getter
    private final ChatColor color;

    private Title(String determiner, String name, ChatColor color, String tag)
    {
        this.determiner = determiner;
        this.name = name;
        this.tag = "[" + tag + "]";
        this.coloredTag = ChatColor.DARK_GRAY + "[" + color + tag + ChatColor.DARK_GRAY + "]" + color;
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

}
