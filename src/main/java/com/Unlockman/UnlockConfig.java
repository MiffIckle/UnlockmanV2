package com.Unlockman;

import java.awt.Color;

import net.runelite.client.config.*;
import net.runelite.api.Quest;

import javax.swing.*;

@ConfigGroup(UnlockPlugin.CONFIG_KEY)
public interface UnlockConfig extends Config
{

    //All configurations are split into sections according to regions.
	//Unfortunately these are hard-coded as there is currently no point to make them more configurable.

	@ConfigSection(
			position = 0,
			name = "Misthalin",
			description = "Region Requirements Misthalin"
	)
	String regionMisthalin = "regionMisthalin";

	@ConfigSection(
			position = 1,
			name = "Asgarnia",
			description = "Region Requirements Asgarnia",
			closedByDefault = true
	)
	String regionAsgarnia = "regionAsgarnia";

	@ConfigSection(
			position = 2,
			name = "Desert",
			description = "Region Requirements Desert",
			closedByDefault = true
	)
	String regionDesert = "regionDesert";

	@ConfigSection(
			position = 3,
			name = "Morytania",
			description = "Region Requirements Morytania",
			closedByDefault = true
	)
	String regionMorytania = "regionMorytania";

	@ConfigSection(
			position = 4,
			name = "Kandarin",
			description = "Region Requirements Kandarin",
			closedByDefault = true
	)
	String regionKandarin = "regionKandarin";

	@ConfigSection(
			position = 5,
			name = "Fremennik",
			description = "Region Requirements Fremennik",
			closedByDefault = true
	)
	String regionFremennik = "regionFremennik";

	@ConfigSection(
			position = 6,
			name = "Tiranwnn",
			description = "Region Requirements Tiranwnn",
			closedByDefault = true
	)
	String regionTiranwnn = "regionTiranwnn";

	@ConfigSection(
			position = 7,
			name = "Kourend & Kebos",
			description = "Region Requirements Kourend & Kebos",
			closedByDefault = true
	)
	String regionKourend = "regionKourend";

	@ConfigSection(
			position = 8,
			name = "Varlamore",
			description = "Region Requirements Varlamore",
			closedByDefault = true
	)
	String regionVarlamore= "regionVarlamore";

	@ConfigSection(
			position = 9,
			name = "Karamja",
			description = "Region Requirements Karamja",
			closedByDefault = true
	)
	String regionKaramja = "regionKaramja";

	@ConfigSection(
			position = 10,
			name = "Wilderness",
			description = "Region Requirements Wilderness",
			closedByDefault = true
	)
	String regionWilderness = "regionWilderness";

	@ConfigSection(
			position = 11,
			name = "Utility Unlocks - in Descriptions",
			description = "Requirements for Utility",
			closedByDefault = true
	)
	String utilityUnlocks = "utilityUnlocks";

	@ConfigSection(
			position = 12,
			name = "Gear Slots - in Descriptions",
			description = "Requirements for Gear Slots",
			closedByDefault = true
	)
	String gearSlots = "gearSlots";

	@ConfigSection(
			position = 13,
			name = "Map Overlay",
			description = "Configurable region lock",
			closedByDefault = true
	)
	String mapSection = "mapSection";


//MapSection Config Items
	@ConfigItem(
			keyName = "renderLockedRegions",
			name = "Enable gray chunks",
			description = "Adds graphical change to all chunk that are locked",
			position = 0,
			section = mapSection
	)
	default boolean renderLockedRegions()
	{
		return true;
	}

	@ConfigItem(
			keyName = "renderRegionBorders",
			name = "Render chunk borders",
			description = "Draws the chunk borders in the environment",
			position = 1,
			section = mapSection
	)
	default boolean renderRegionBorders()
	{
		return false;
	}


	@ConfigItem(
			keyName = "drawMapOverlay",
			name = "Draw chunks on map",
			description = "Draw a color overlay for each locked/unlocked chunk",
			position = 2,
			section = mapSection

	)
	default boolean drawMapOverlay()
	{
		return true;
	}


	@ConfigItem(
			keyName = "hardBorder",
			name = "Hard chunk border cutoff",
			description = "Switches which chunks the map will draw the color overlay for (true = locked, false = unlocked)",
			position = 3,
			section = mapSection
	)
	default boolean hardBorder()
	{
		return true;
	}

	@Alpha
	@ConfigItem(
			keyName = "shaderGrayColor",
			name = "Chunk shader color",
			description = "The color of the locked chunks in the shader",
			position = 4,
			section = mapSection
	)
	default Color shaderGrayColor()
	{
		return new Color(0, 31, 77, 204);
	}

	@Alpha
	@ConfigItem(
			keyName = "shaderGrayAmount",
			name = "Chunk gray opacity",
			description = "The amount of gray scale that is applied to a locked chunk in the shader (alpha only)",
			position = 5,
			section = mapSection
	)
	default Color shaderGrayAmount()
	{
		return new Color(0, 0, 0, 204);
	}

	@Alpha
	@ConfigItem(
			keyName = "mapOverlayColor",
			name = "Map overlay color",
			description = "The color the map overlay will draw the chunks in",
			position = 6,
			section = mapSection
	)
	default Color mapOverlayColor()
	{
		return new Color(200, 16, 0, 100);
	}


	@Alpha
	@ConfigItem(
			keyName = "blacklistedOverlayColor",
			name = "Blacklisted overlay color",
			description = "The color the map overlay will draw the blacklisted chunks in",
			position = 7,
			section = mapSection
	)
	default Color blacklistedOverlayColor()
	{
		return new Color(0, 0, 0, 200);
	}

	@Alpha
	@ConfigItem(
			keyName = "regionBorderColor",
			name = "Chunk border color",
			description = "The color of the chunk borders",
			position = 8,
			section = mapSection
	)
	default Color regionBorderColor()
	{
		return new Color(0, 200, 83, 200);
	}

	@ConfigItem(
			keyName = "invertMapOverlay",
			name = "Invert map overlay",
			description = "Switches which chunks the map will draw the color overlay for (true = locked, false = unlocked)",
			position = 9,
			section = mapSection
	)
	default boolean invertMapOverlay()
	{
		return true;
	}

	@ConfigItem(
			keyName = "regionBorderWidth",
			name = "Chunk border width",
			description = "How wide the region border will be",
			position = 10,
			section = mapSection
	)
	default int regionBorderWidth()
	{
		return 1;
	}

	@ConfigItem(
			keyName = "drawMapGrid",
			name = "Draw map grid",
			description = "Draw the grid of chunks on the map",
			position = 11,
			section = mapSection
	)
	default boolean drawMapGrid()
	{
		return true;
	}

	@ConfigItem(
			keyName = "drawRegionId",
			name = "Draw region IDs",
			description = "Draw the chunk ID for each chunk on the map",
			position = 12,
			section = mapSection
	)
	default boolean drawRegionId()
	{
		return true;
	}


	@ConfigItem(
			keyName = "renderMisthalin",
			name = "Misthalin",
			description = "Check if you have unlocked Misthalin",
			position = 15,
			section = regionMisthalin
	)
	default boolean renderMisthalin()
	{
		return true;
	}


	@ConfigItem(
			keyName = "AsgarniaMining",
			name = "Mining (Level 40)",
			description = "Check if you have the Mining requirement for Asgarnia",
			position = 16,
			section = regionAsgarnia
	)
	default boolean AsgarniaMining()
	{
		return false;
	}

	@ConfigItem(
			keyName = "AsgarniaSmithing",
			name = "Smithing (Level 35)",
			description = "Check if you have the Smithing requirement for Asgarnia",
			position = 17,
			section = regionAsgarnia
	)
	default boolean AsgarniaSmithing()
	{
		return false;
	}

	@ConfigItem(
			keyName = "AsgarniaCombat",
			name = "Combat (Level 45)",
			description = "Check if you have the Combat requirement for Asgarnia",
			position = 19,
			section = regionAsgarnia
	)
	default boolean AsgarniaCombat()
	{
		return false;
	}

	@ConfigItem(
			keyName = "DesertFishing",
			name = "Fishing (Level 40)",
			description = "Check if you have the Fishing requirement for Desert",
			position = 20,
			section = regionDesert
	)
	default boolean DesertFishing()
	{
		return false;
	}

	@ConfigItem(
			keyName = "DesertCooking",
			name = "Cooking (Level 45)",
			description = "Check if you have the Cooking requirement for Desert",
			position = 21,
			section = regionDesert
	)
	default boolean DesertCooking()
	{
		return false;
	}

	@ConfigItem(
			keyName = "DesertRunecraft",
			name = "Runecraft (Level 15)",
			description = "Check if you have the Runecraft requirement for Desert",
			position = 22,
			section = regionDesert
	)
	default boolean DesertRunecraft()
	{
		return false;
	}

	@ConfigItem(
			keyName = "DesertFishingDoom",
			name = "Doom Fishing (Level 80)",
			description = "Check if you have the Fishing (x2) requirement for Desert (in case Desert belongs to the last two Tier 1 Regions)",
			position = 23,
			section = regionDesert
	)
	default boolean DesertFishingDoom()
	{
		return false;
	}

	@ConfigItem(
			keyName = "DesertCookingDoom",
			name = "Doom Cooking (Level 90)",
			description = "Check if you have the Cooking (x2) requirement for Desert (in case Desert belongs to the last two Tier 1 Regions)",
			position = 24,
			section = regionDesert
	)
	default boolean DesertCookingDoom()
	{
		return false;
	}

	@ConfigItem(
			keyName = "DesertRunecraftDoom",
			name = "Doom Runecraft (Level 30)",
			description = "Check if you have the Runecraft (x2) requirement for Desert (in case Desert belongs to the last two Tier 1 Regions)",
			position = 25,
			section = regionDesert
	)
	default boolean DesertRunecraftDoom()
	{
		return false;
	}

	@ConfigItem(
			keyName = "KandarinAccess",
			name = "Access to Kandarin",
			description = "Check if you have means to enter Kandarin without crossing locked regions",
			position = 26,
			section = regionKandarin
	)
	default boolean KandarinAccess()
	{
		return false;
	}

	@ConfigItem(
			keyName = "KandarinAgility",
			name = "Agility (Level 45)",
			description = "Check if you have the Agility requirement for Kandarin",
			position = 27,
			section = regionKandarin
	)
	default boolean KandarinAgility()
	{
		return false;
	}

	@ConfigItem(
			keyName = "KandarinCrafting",
			name = "Crafting (Level 30)",
			description = "Check if you have the Crafting requirement for Kandarin",
			position = 28,
			section = regionKandarin
	)
	default boolean KandarinCrafting()
	{
		return false;
	}

	@ConfigItem(
			keyName = "KandarinAgilityDoom",
			name = "Doom Agility (Level 90)",
			description = "Check if you have the Crafting (x2) requirement for Kandarin (in case Kandarin belongs to the last two Tier 1 Regions)",
			position = 29,
			section = regionKandarin
	)
	default boolean KandarinAgilityDoom()
	{
		return false;
	}

	@ConfigItem(
			keyName = "KandarinCraftingDoom",
			name = "Doom Crafting (Level 60)",
			description = "Check if you have the Crafting (x2) requirement for Kandarin (in case Kandarin belongs to the last two Tier 1 Regions)",
			position = 30,
			section = regionKandarin
	)
	default boolean KandarinCraftingDoom()
	{
		return false;
	}

	@ConfigItem(
			keyName = "KaramjaAccess",
			name = "Charter Ship",
			description = "Check if you have access to Karamja through Charter",
			position = 31,
			section = regionKaramja
	)
	default boolean KaramjaAccess()
	{
		return false;
	}

	@ConfigItem(
			keyName = "TiranwnnThieving",
			name = "Thieving (Level 70)",
			description = "Check if you have the Thieving requirement for Tiranwnn",
			position = 32,
			section = regionTiranwnn
	)
	default boolean TiranwnnThieving()
	{
		return false;
	}

	@ConfigItem(
			keyName = "TiranwnnCombat",
			name = "Thieving (Level 90)",
			description = "Check if you have the Combat requirement for Tiranwnn",
			position = 33,
			section = regionTiranwnn
	)
	default boolean TiranwnnCombat()
	{
		return false;
	}

	@ConfigItem(

			keyName = "UndergroundPass",
			name = "Underground Pass",
			description = "Check if you have completed Underground Pass",
			position = 34,
			section = regionTiranwnn
	)
	default boolean TiranwnnUndergroundPass()
	{
		return false;
	}

	@ConfigItem(
			keyName = "FremennikMagic",
			name = "Magic (Level 70)",
			description = "Check if you have the Magic requirement for Fremennik",
			position = 35,
			section = regionFremennik
	)
	default boolean FremennikMagic()
	{
		return false;
	}

	@ConfigItem(
			keyName = "FremennikCombat",
			name = "Combat (Level 80)",
			description = "Check if you have the Combat requirement for Fremennik",
			position = 36,
			section = regionFremennik
	)
	default boolean FremennikCombat()
	{
		return false;
	}

	@ConfigItem(
			keyName = "FremennikFishing",
			name = "Fishing (Level 76)",
			description = "Check if you have the Fishing requirement for Fremennik",
			position = 37,
			section = regionFremennik
	)
	default boolean FremennikFishing()
	{
		return false;
	}

	@ConfigItem(
			keyName = "VarlamoreQuest",
			name = "Children of the Sun",
			description = "Check if you have the quest requirement for Varlamore",
			position = 38,
			section = regionVarlamore
	)
	default boolean VarlamoreQuest()
	{
		return false;
	}

	@ConfigItem(
			keyName = "VarlamoreHunter",
			name = "Hunter (Level 45)",
			description = "Check if you have the Hunter requirement for Varlamore",
			position = 39,
			section = regionVarlamore
	)
	default boolean VarlamoreHunter()
	{
		return false;
	}

	@ConfigItem(
			keyName = "VarlamoreThieving",
			name = "Thieving (Level 45)",
			description = "Check if you have the Thieving requirement for Varlamore",
			position = 40,
			section = regionVarlamore
	)
	default boolean VarlamoreThieving()
	{
		return false;
	}

	@ConfigItem(
			keyName = "VarlamoreHunterdoom",
			name = "Doom Hunter (Level 90)",
			description = "Check if you have the Hunter (x2) requirement for Varlamore (in case Varlamore belongs to the last two Tier 1 Regions",
			position = 41,
			section = regionVarlamore
	)
	default boolean VarlamoreHunterDoom()
	{
		return false;
	}

	@ConfigItem(
			keyName = "VarlamoreThievingdoom",
			name = "Doom Thieving (Level 90)",
			description = "Check if you have the Thieving (x2) requirement for Varlamore (in case Varlamore belongs to the last two Tier 1 Regions",
			position = 42,
			section = regionVarlamore
	)
	default boolean VarlamoreThievingDoom()
	{
		return false;
	}

	@ConfigItem(
			keyName = "KourendQuest",
			name = "X Marks the Spot",
			description = "Check if you have the Quest requirement for Kourend & Kebos",
			position = 43,
			section = regionKourend
	)
	default boolean KourendQuest()
	{
		return false;
	}

	@ConfigItem(
			keyName = "KourendFiremaking",
			name = "Firemaking (Level 70)",
			description = "Check if you have the Firemaking requirement for Kourend & Kebos",
			position = 44,
			section = regionKourend
	)
	default boolean KourendFiremaking()
	{
		return false;
	}

	@ConfigItem(
			keyName = "KourendWoodcutting",
			name = "Woodcutting (Level 65)",
			description = "Check if you have the Woodcutting requirement for Kourend & Kebos",
			position = 45,
			section = regionKourend
	)
	default boolean KourendWoodcutting()
	{
		return false;
	}

	@ConfigItem(
			keyName = "KourendFletching",
			name = "Fletching (Level 45",
			description = "Check if you have the Fletching requirement for Kourend & Kebos",
			position = 46,
			section = regionKourend
	)
	default boolean KourendFletching()
	{
		return false;
	}

	@ConfigItem(
			keyName = "KourendConstruction",
			name = "Construction (Level 40)",
			description = "Check if you have the Construction requirement for Kourend & Kebos",
			position = 47,
			section = regionKourend
	)
	default boolean KourendConstruction()
	{
		return false;
	}

	@ConfigItem(
			keyName = "AsgarniaMiningDoom",
			name = "Doom Mining (Level 80)",
			description = "Check if you have the Mining (x2) requirement for Asgarnia (in case Asgarnia belongs to the last two Tier 1 Regions",
			position = 48,
			section = regionAsgarnia
	)
	default boolean AsgarniaMiningDoom()
	{
		return false;
	}

	@ConfigItem(
			keyName = "AsgarniaSmithingdoom",
			name = "Doom Smithing (Level 70)",
			description = "Check if you have the Smithing (x2) requirement for Asgarnia (in case Asgarnia belongs to the last two Tier 1 Regions",
			position = 49,
			section = regionAsgarnia
	)
	default boolean AsgarniaSmithingDoom()
	{
		return false;
	}

	@ConfigItem(
			keyName = "AsgarniaCombatdoom",
			name = "Doom Combat (Level 90)",
			description = "Check if you have the Combat (x2) requirement for Asgarnia (in case Asgarnia belongs to the last two Tier 1 Regions",
			position = 50,
			section = regionAsgarnia
	)
	default boolean AsgarniaCombatDoom()
	{
		return false;
	}



	@ConfigItem(
			keyName = "MorytaniaQuest",
			name = "Priest in Peril",
			description = "Check if you have the Quest requirement for Morytania",
			position = 51,
			section = regionMorytania
	)
	default boolean MorytaniaQuest()
	{
		return false;
	}

	@ConfigItem(
			keyName = "MorytaniaPrayer",
			name = "Prayer (Level 35)",
			description = "Check if you have the Prayer requirement for Morytania",
			position = 52,
			section = regionMorytania
	)
	default boolean MorytaniaPrayer()
	{
		return false;
	}

	@ConfigItem(
			keyName = "MorytaniaAgility",
			name = "Agility (Level 40)",
			description = "Check if you have the Agility requirement for Morytania",
			position = 53,
			section = regionMorytania
	)
	default boolean MorytaniaAgility()
	{
		return false;
	}

	@ConfigItem(
			keyName = "MorytaniaPrayerdoom",
			name = "Doom Prayer (Level 70)",
			description = "Check if you have the Prayer (x2) requirement for Morytania (in case Morytania belongs to the last two Tier 1 Regions",
			position = 54,
			section = regionMorytania
	)
	default boolean MorytaniaPrayerDoom()
	{
		return false;
	}

	@ConfigItem(
			keyName = "MorytaniaAgilitydoom",
			name = "Doom Agility (Level 80)",
			description = "Check if you have the Agility (x2) requirement for Morytania (in case Morytania belongs to the last two Tier 1 Regions",
			position = 55,
			section = regionMorytania
	)
	default boolean MorytaniaAgilityDoom()
	{
		return false;
	}

	@ConfigItem(
			keyName = "WildernessAsgarnia",
			name = "Falador Hard Diary",
			description = "Check if you have done this diary for unlocking Wilderness",
			position = 56,
			section = regionWilderness
	)
	default boolean WildernessAsgarnia()
	{
		return false;
	}

	@ConfigItem(
			keyName = "WildernessDesert",
			name = "Desert Hard Diary",
			description = "Check if you have done this diary for unlocking Wilderness",
			position = 57,
			section = regionWilderness
	)
	default boolean WildernessDesert()
	{
		return false;
	}

	@ConfigItem(
			keyName = "WildernessKandarin",
			name = "Kandarin & Ardougne Hard Diary",
			description = "Check if you have done this diary for unlocking Wilderness",
			position = 57,
			section = regionWilderness
	)
	default boolean WildernessKandarin()
	{
		return false;
	}

	@ConfigItem(
			keyName = "WildernessMistalin",
			name = "Varrock & Lumbridge Hard Diary",
			description = "Check if you have done this diary for unlocking Wilderness",
			position = 58,
			section = regionWilderness
	)
	default boolean WildernessMisthalin()
	{
		return false;
	}

	@ConfigItem(
			keyName = "WildernessFremennik",
			name = "Fremennik Hard Diary",
			description = "Check if you have done this diary for unlocking Wilderness",
			position = 59,
			section = regionWilderness
	)
	default boolean WildernessFremennik()
	{
		return false;
	}

	@ConfigItem(
			keyName = "WildernessTiranwnn",
			name = "Western Provinces Hard Diary",
			description = "Check if you have done this diary for unlocking Wilderness",
			position = 60,
			section = regionWilderness
	)
	default boolean WildernessTiranwnn()
	{
		return false;
	}

	@ConfigItem(
			keyName = "WildernessMorytania",
			name = "Morytania Hard Diary",
			description = "Check if you have done this diary for unlocking Wilderness",
			position = 61,
			section = regionWilderness
	)
	default boolean WildernessMorytania()
	{
		return false;
	}

	@ConfigItem(
			keyName = "WildernessKourend",
			name = "Kourend & Kebos Hard Diary",
			description = "Check if you have done this diary for unlocking Wilderness",
			position = 62,
			section = regionWilderness
	)
	default boolean WildernessKourend()
	{
		return false;
	}

	@ConfigItem(
			keyName = "UtilitySpellBook",
			name = "Spellbook Unlock",
			description = "Completion of 'Temple of the Eye'",
			position = 63,
			section = utilityUnlocks
	)
	default boolean UtilitySpellBook()
	{
		return false;
	}

	@ConfigItem(
			keyName = "UtilityPrayerBook",
			name = "Prayerbook Unlock",
			description = "Completion of 'Holy Grail', 'Restless Ghost' & 'His Faithful Servants'",
			position = 64,
			section = utilityUnlocks
	)
	default boolean UtilityPrayerBook()
	{
		return false;
	}

	@ConfigItem(
			keyName = "UtilityPersonalBank",
			name = "Personal Bank Unlock",
			description = "Obtain a POH, and carry an inventory of 250K G.E price after POH (only tradables)",
			position = 65,
			section = utilityUnlocks
	)
	default boolean UtilityPersonalBank()
	{
		return false;
	}

	@ConfigItem(
			keyName = "UtilityGroupBank",
			name = "Group Bank Unlock",
			description = "Everyone has Personal Bank unlocked, Shield of Arrav Completed, Total of 150+",
			position = 66,
			section = utilityUnlocks
	)
	default boolean UtilityGroupBank()
	{
		return false;
	}

	@ConfigItem(
			keyName = "UtilityTOA",
			name = "Tombs of Amascut Unlock",
			description = "Obtain one of these: 5x Tome of Water, 3x Pharaoh Sceptre or 1x Tempoross Pet",
			position = 67,
			section = utilityUnlocks
	)
	default boolean UtilityTOA()
	{
		return false;
	}

	@ConfigItem(
			keyName = "UtilityTOB",
			name = "Theatre of Blood Unlock",
			description = "Obtain one of these: 1x Soulreaper Axe, 1x Voidwaker, 1x Slayer Boss pet",
			position = 68,
			section = utilityUnlocks
	)
	default boolean UtilityTOB()
	{
		return false;
	}

	@ConfigItem(
			keyName = "UtilityCOX",
			name = "Chambers of Xeric Unlock",
			description = "Obtain one of these: 5x Tome of Fire, 3x Dragon Warhammer or 1x Wintertodt pet",
			position = 69,
			section = utilityUnlocks
	)
	default boolean UtilityCOX()
	{
		return false;
	}

	@ConfigItem(
			keyName = "GearMainHand",
			name = "Main Hand Slot",
			description = "Obtain one of these: 5x Tome of Fire, 3x Dragon Warhammer or 1x Wintertodt pet",
			position = 70,
			section = gearSlots
	)
	default boolean GearMainHand()
	{
		return false;
	}

	@ConfigItem(
			keyName = "GearAmmo",
			name = "Ammo Slot",
			description = "Obtain one of these: 5x Tome of Fire, 3x Dragon Warhammer or 1x Wintertodt pet",
			position = 71,
			section = gearSlots
	)
	default boolean GearAmmo()
	{
		return false;
	}

	@ConfigItem(
			keyName = "GearHelm",
			name = "Helm Slot",
			description = "Obtain one of these: 5x Tome of Fire, 3x Dragon Warhammer or 1x Wintertodt pet",
			position = 72,
			section = gearSlots
	)
	default boolean GearHelm()
	{
		return false;
	}

	@ConfigItem(
			keyName = "GearAmulet",
			name = "Amulet Slot",
			description = "Obtain one of these: 5x Tome of Fire, 3x Dragon Warhammer or 1x Wintertodt pet",
			position = 73,
			section = gearSlots
	)
	default boolean GearAmulet()
	{
		return false;
	}

	@ConfigItem(
			keyName = "GearCape",
			name = "Cape Slot",
			description = "Obtain one of these: 5x Tome of Fire, 3x Dragon Warhammer or 1x Wintertodt pet",
			position = 74,
			section = gearSlots
	)
	default boolean GearCape()
	{
		return false;
	}

	@ConfigItem(
			keyName = "GearBody",
			name = "Body Slot",
			description = "Obtain one of these: 5x Tome of Fire, 3x Dragon Warhammer or 1x Wintertodt pet",
			position = 75,
			section = gearSlots
	)
	default boolean GearBody()
	{
		return false;
	}

	@ConfigItem(
			keyName = "GearOffHand",
			name = "Off-Hand Slot",
			description = "Obtain one of these: 5x Tome of Fire, 3x Dragon Warhammer or 1x Wintertodt pet",
			position = 76,
			section = gearSlots
	)
	default boolean GearOffHand()
	{
		return false;
	}

	@ConfigItem(
			keyName = "GearLegs",
			name = "Legs Slot",
			description = "Obtain one of these: 5x Tome of Fire, 3x Dragon Warhammer or 1x Wintertodt pet",
			position = 77,
			section = gearSlots
	)
	default boolean GearLegs()
	{
		return false;
	}

	@ConfigItem(
			keyName = "GearBoots",
			name = "Boots Slot",
			description = "Obtain one of these: 5x Tome of Fire, 3x Dragon Warhammer or 1x Wintertodt pet",
			position = 78,
			section = gearSlots
	)
	default boolean GearBoots()
	{
		return false;
	}

	@ConfigItem(
			keyName = "GearGloves",
			name = "Gloves Slot",
			description = "Obtain one of these: 5x Tome of Fire, 3x Dragon Warhammer or 1x Wintertodt pet",
			position = 79,
			section = gearSlots
	)
	default boolean GearGloves()
	{
		return false;
	}

	@ConfigItem(
			keyName = "GearRing",
			name = "Ring Slot",
			description = "Obtain one of these: 5x Tome of Fire, 3x Dragon Warhammer or 1x Wintertodt pet",
			position = 80,
			section = gearSlots
	)
	default boolean GearRing()
	{
		return false;
	}



















}