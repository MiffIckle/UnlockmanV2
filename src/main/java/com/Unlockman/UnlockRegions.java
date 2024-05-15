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

            if ((config.DesertFishing() || config.DesertFishingDoom()) && (config.DesertRunecraft() || config.DesertRunecraftDoom()) && (config.DesertCooking() || config.DesertCookingDoom()))
            {
                if (config.FremennikMagic() && config.FremennikFishing() && config.FremennikCombat())
                {
                    String fremennik = "8253, 8509, 8252, 8508, 8763, 9276, 9275, 9532, 9531, 9023, 9790, 10045, 10044, 10043, 10042," +
                            "10041, 10040, 10301, 10300, 10299, 10298, 10297, 10296, 10559, 10558, 10557, 10556, 10555, 10554, 10553," +
                            "10552, 10812, 10811, 10810, 10809, 10808, 11069, 11068, 11067, 11066, 11065, 11064, 11326, 11325, 11324," +
                            "11581, 11580";
                    List<String> unlockedRegionsthree = StringToList(fremennik);
                    setRegions(unlockedRegionsthree, UnlockRegionTypes.UNLOCKED);
                }
            }


        }

        if ((config.AsgarniaMining() || config.AsgarniaMiningDoom()) && (config.AsgarniaSmithing() || config.AsgarniaSmithingDoom()) && (config.AsgarniaCombat() || config.AsgarniaCombatDoom()))
        {
            String asgarnia = "11063, 11319, 11060, 11316, 11575, 11574, 11573, 11572, 11571, 11570, 11830, 11829," +
                    "11828, 11827, 11826, 11825, 11824, 12086, 12085, 12084, 12083, 12082, 12081, 10537, 10536, 11320, 11321, 11322," +
                    "11323, 11579, 11578, 11577, 11576";
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

        if (config.KaramjaAccess())
        {
            String karamja = "10802, 10801, 11058, 11057, 11056, 11055, 11054, 11053, 11315, 11314, 11313," +
                    "11312, 11311, 11310, 11309, 11569, 11568, 11567, 11566, 11565, 11823, 11822, 11821";
            List<String> unlockedRegions = StringToList(karamja);
            setRegions(unlockedRegions, UnlockRegionTypes.UNLOCKED);
        }

        if(config.VarlamoreQuest() && (config.VarlamoreHunter() || config.VarlamoreHunterDoom()) && (config.VarlamoreThieving() || config.VarlamoreThievingDoom()))
        {
            String varlamore = "4916, 4915, 4914, 4913, 4912, 4911, 4910, 4909, 4908, 5164, 5165, 5166, 5167, 5168, 5169, 5170, 5171, 5172," +
                    "5428, 5427, 5426, 5425, 5424, 5423, 5422, 5421, 5420, 5676, 5677, 5678, 5679, 5680, 5681, 5682, 5683, 5684, 5940, 5939," +
                    "5938, 5937, 5938, 5937, 5936, 5935, 5934, 5933, 6189, 6190, 6191, 6192, 6193, 6194, 6195, 6451, 6450, 6449, 6448, 6447," +
                    "6446, 6445, 6701, 6702, 6703, 6704, 6705, 6706, 6707, 6961, 6960, 6959, 6958, 6957 7215, 7216, 7217, 7472";
            List<String> unlockedRegions = StringToList(varlamore);
            setRegions(unlockedRegions, UnlockRegionTypes.UNLOCKED);

            if ((config.AsgarniaMining() || config.AsgarniaMiningDoom()) && (config.AsgarniaSmithing() || config.AsgarniaSmithingDoom()) && (config.AsgarniaCombat() || config.AsgarniaCombatDoom()))
            {
                if(config.KourendQuest() && config.KourendConstruction() && config.KourendFiremaking() && config.KourendFletching() && config.KourendWoodcutting())
                {
                    String kourend = "4405, 4404, 4403, 4659, 4660, 4661, 4662, 4663, 4664, 4665, 4666, 4667 4923, 4922, 4921, 4920, 4919," +
                            "4918, 4917, 5173, 5174, 5175, 5176, 5177, 5178, 5179, 5180, 5435, 5434, 5433, 5432, 5431, 5430, 5429, 5685, 5686, 5687, 5688," +
                            "5689, 5690, 5691, 5692, 5693, 5950, 5949, 5948, 5947, 5946, 5945, 5944, 5943, 5942, 5941, 6197, 6198, 6199, 6200, 6201, 6202," +
                            "6203, 6204, 6205, 6206, 6463, 6462, 6461, 6460, 6459, 6458, 6457, 6456, 6455, 6454, 6453, 6709, 6710, 6711, 6712, 6713, " +
                            "6714, 6715, 6716, 6717, 6718, 6719, 6974, 6973, 6972, 6971, 6970, 6969, 6968 6967, 6966, 6965, 7221, 7220, 7222, 7223, " +
                            "7224, 7225, 7226, 7227, 7228, 7229, 7485, 7484, 7479, 7478";
                    List<String> unlockedRegionstwo = StringToList(kourend);
                    setRegions(unlockedRegionstwo, UnlockRegionTypes.UNLOCKED);

                }
            }
        }

        if(config.MorytaniaQuest() && (config.MorytaniaAgility() || config.MorytaniaAgilityDoom()) && (config.MorytaniaPrayer() || config.MorytaniaPrayerDoom()))
        {
            String morytania = "14393, 13624, 13623, 13622, 13621, 13620, 13619, 13618, 13879, 13878, 13877, 13876, 13875, 13874, 13873," +
                    "14135, 14134, 14133, 14132, 14131, 14130, 14129, 14391, 14390, 14389, 14388, 14387, 14386, 14385, 14647, 14646, 14645," +
                    "14644, 14643, 14642, 14641, 15159, 14901, 14900, 14899, 14898, 14897, 14639, 14638, 14637, 14894, 14895, 15151, 15150, 15149, 15148, 15407," +
                    "15406, 15405";
            List<String> unlockedRegions = StringToList(morytania);
            setRegions(unlockedRegions, UnlockRegionTypes.UNLOCKED);
        }

        if(config.WildernessMorytania() && config.WildernessTiranwnn() && config.WildernessAsgarnia() && config.WildernessDesert() && config.WildernessFremennik() && config.WildernessKandarin() && config.WildernessKourend() && config.WildernessMisthalin())
        {
            String wilderness = "11831, 11832, 11833, 11834, 11835, 11836, 11837, 12087, 12088, 12089, 12090, 12091, 12092, 12093, 12343, 12344," +
                    "12345, 12346, 12347, 12348, 12349, 12599, 12600, 12601, 12602, 12603, 12604, 12605, 12855, 12856, 12857, 12858, 12859, 12860," +
                    "12861, 13111, 13112, 13113, 13114, 13115, 13116, 13117, 13367, 13368, 13369, 13370, 13371, 13372, 13373, 13374, 13375, 13376," +
                    "13632, 13631, 13630, 13886, 13887, 13888";
            List<String> unlockedRegions = StringToList(wilderness);
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


