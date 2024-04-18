package com.Unlockman;



import java.awt.Color;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import jdk.dynalink.Operation;
import lombok.Getter;
import net.runelite.api.Quest;
import net.runelite.api.Client;
import net.runelite.api.QuestState;
import net.runelite.api.ScriptID;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.util.Text;
import net.runelite.api.Skill;
import static net.runelite.api.Skill.COOKING;


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
            String misthalin = "12080, 12079, 12342, 12341, 12340, 12339, 12338, 12337, 12336," +
                    "12335, 12598, 12597, 12596, 12595, 12594, 12593, 12592," +
                    "12854, 12853, 12852, 12851, 12850, 12849, 13110, 13109, 13108, 13366, 13365," +
                    "13364, 13622, 14142, 14398, 14395, 14394, 14393, 14654, 14653, 14652, 14651, 14650," +
                    "14649, 14910, 14909, 14908, 14907, 14906, 14905, 15166, 15165, 15164, 15163, 15162, 15418," +
                    "8237, 8236, 8494, 8493, 8492, 8491, 8750, 8749, 8748, 8747, 9006, 9005, 9004, 9003, 9262," +
                    "9261, 9260";
            List<String> unlockedRegions = StringToList(misthalin);
            setRegions(unlockedRegions, UnlockRegionTypes.UNLOCKED);
        }

        if ((config.DesertFishing() || config.DesertFishingDoom()) && (config.DesertRunecraft() || config.DesertRunecraftDoom()) && (config.DesertCooking() || config.DesertCookingDoom()))
        {
            String desert = "12591, 12590, 12589, 12588, 12587, 12848, 12847, 12846, 12845, 12844," +
                    "12843, 13107, 13106, 13105, 13104, 13103, 13102, 13101, 13100, 13099, 13098," +
                    "13363, 13362, 13361, 13360, 13359, 13358, 13357, 13356, 13355, 13354, 13353," +
                    "13617, 13616, 13615, 13614, 13613, 13612, 13611, 13610, 13609," +
                    "13872, 13871, 13870, 13869, 12078";
            List<String> unlockedRegions = StringToList(desert);
            setRegions(unlockedRegions, UnlockRegionTypes.UNLOCKED);
        }

        if (config.KandarinAccess() && (config.KandarinAgility() || config.KandarinAgilityDoom()) && (config.KandarinCrafting() || config.KandarinCraftingDoom()))
        {

            String kandarin = "9017, 9016, 9015, 9014, 9273, 9272, 9271, 9270, 9269, 9528, 9527," +
                    "9526, 9525, 9524, 9264, 9263, 9520, 9519, 9783, 9782, 9781, 9780, 9779, 9778," +
                    "9777, 9776, 9775, 9774, 9773, 9772, 10039, 10038, 10037, 10036, 10035, 10034, 10033," +
                    "10032, 10031, 10030, 10029, 10028, 10295, 10294, 10293, 10292, 10291, 10290, 10289, 10288," +
                    "10287, 10286, 10285, 10284, 10551, 10550, 10549, 10548, 10547, 10546, 10545, 10544, 10543, 10542" +
                    "10807, 10806, 10805, 10804, 10803, 11062, 11061, 11059, 11317, 11318, 10795, 10794, 11051, 11050, 11562";
            List<String> unlockedRegions = StringToList(kandarin);
            setRegions(unlockedRegions, UnlockRegionTypes.UNLOCKED);

            if (config.TiranwnnThieving() && config.TiranwnnUndergroundPass() && config.TiranwnnCombat())
            {
                String tiranwnn = "8501, 8500, 8499, 8498, 8497, 8496, 8495,8757, 8756, 8755," +
                        "8754, 8753, 8752, 8751, 9013, 9012, 9011, 9010, 9009, 9008, 9007," +
                        "9268, 9267, 9266, 9265, 9523, 9522, 9521";
                List<String> unlockedRegionstwo = StringToList(tiranwnn);
                setRegions(unlockedRegionstwo, UnlockRegionTypes.UNLOCKED);
            }
        }

        if (config.AsgarniaMining() && config.AsgarniaSmithing() && config.AsgarniaCombat())
        {
            String asgarnia = "11063, 11319, 11060, 11316, 11575, 11574, 11573, 11572, 11571, 11570, 11830, 11829," +
                    "11828, 11827, 11826, 11825, 11824, 12086, 12085, 12084, 12083, 12082, 12081, 10537, 10536";
            List<String> unlockedRegions = StringToList(asgarnia);
            setRegions(unlockedRegions, UnlockRegionTypes.UNLOCKED);
        }

        if (config.KaramjaAccess())
        {
            String karamja = "10802, 10801, 11058, 11057, 11056, 11055, 11054, 11053, 11315, 11314, 11313," +
                    "11312, 11311, 11310, 11309, 11569, 11568, 11567, 11566, 11565, 11823, 11822, 11821";
            List<String> unlockedRegions = StringToList(karamja);
            setRegions(unlockedRegions, UnlockRegionTypes.UNLOCKED);
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


