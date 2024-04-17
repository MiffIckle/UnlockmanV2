package com.Unlockman;



import java.awt.Color;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lombok.Getter;
import net.runelite.api.Client;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.util.Text;

public class UnlockRegions
{
    private final Client client;
    private final UnlockConfig config;
    private final ConfigManager configManager;

    @Getter
    private static Map<String, UnlockRegionTypes> unlockregions = new HashMap<>();

    public static boolean renderLockedRegions;
    public static Color grayColor;
    public static int grayAmount;
    public static boolean hardBorder;
    private static boolean unlockReamls;
    private static boolean unlockUnderground;

    UnlockRegions(Client client, UnlockConfig config, ConfigManager configManager)
    {
        this.client = client;
        this.config = config;
        this.configManager = configManager;
        readConfig();
    }

    private List<String> StringToList(String s)
    {
        List<String> regs;
        if (s.isEmpty())
            regs = new ArrayList<>();
        else
            regs = new ArrayList<>(Text.fromCSV(s));
        return regs;
    }

    public void readConfig()
    {
        renderLockedRegions = config.renderLockedRegions();
        grayColor = config.shaderGrayColor();
        grayAmount = config.shaderGrayAmount().getAlpha();
        hardBorder = config.hardBorder();

        unlockregions.clear();

        if (config.renderMisthalin())
        {
            String misthalin = "12595, 12339, 12594";
            List<String> unlockedRegions = StringToList(misthalin);
            setRegions(unlockedRegions, UnlockRegionTypes.UNLOCKED);
        }

        if (config.renderDesert())
        {
            String desert = "13107, 13363, 13106";
            List<String> unlockedRegions = StringToList(desert);
            setRegions(unlockedRegions, UnlockRegionTypes.UNLOCKED);
        }

        if (config.renderDesert())
        {
            String desert = "13107, 13363, 13106";
            List<String> unlockedRegions = StringToList(desert);
            setRegions(unlockedRegions, UnlockRegionTypes.UNLOCKED);
        }

        if (config.renderTiranwnn())
        {
            String tiranwnn = "8755, 8756, 9011";
            if (config.renderDesert())
            {
                List<String> unlockedRegions = StringToList(tiranwnn);
                setRegions(unlockedRegions, UnlockRegionTypes.UNLOCKED);
            }
            else
            {
                //config.renderTiranwnn() = false;
            }
        }

    }

    private void setRegions(List<String> regs, UnlockRegionTypes type)
    {
        for (String id : regs)
        {
            unlockregions.put(id, type);
        }
    }

    private void setConfig()
    {
        List<String> unlockedRegions = new ArrayList<>();
        List<String> blacklistedRegions = new ArrayList<>();

        unlockregions.entrySet().forEach(e ->
        {
            if (e.getValue() == UnlockRegionTypes.UNLOCKED) unlockedRegions.add(e.getKey());
            if (e.getValue() == UnlockRegionTypes.BLACKLISTED) blacklistedRegions.add(e.getKey());
        });

        String csv = Text.toCSV(unlockedRegions);
        configManager.setConfiguration(UnlockPlugin.CONFIG_KEY, "unlockedRegions", csv);

        csv = Text.toCSV(blacklistedRegions);
        configManager.setConfiguration(UnlockPlugin.CONFIG_KEY, "blacklistedRegions", csv);
    }


    public static UnlockRegionTypes getType(int regionId)
    {
        String id = Integer.toString(regionId);
        int y = getY(regionId);
        if (unlockReamls && y >= 4160 && y < 5952) return UnlockRegionTypes.UNLOCKED;
        if (unlockUnderground && y >= 8960) return UnlockRegionTypes.UNLOCKED;
        if (unlockregions == null) return null;
        return unlockregions.get(id);
    }

    public static boolean hasRegion(int regionId)
    {
        UnlockRegionTypes type = getType(regionId);
        if (type == null) return false;
        return type == UnlockRegionTypes.UNLOCKED;
    }

    public static boolean isBlacklisted(int regionId)
    {
        UnlockRegionTypes type = getType(regionId);
        if (type == null) return false;
        return type == UnlockRegionTypes.BLACKLISTED;
    }

    public static int getX(int id)
    {
        return ((id >> 8) << 6);
    }

    public static int getY(int id)
    {
        return ((id & 255) << 6);
    }
}


