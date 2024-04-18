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
			name = "Mining (Level 45)",
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
			name = "Smithing (Level 40)",
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
			name = "Smithing (Level 50)",
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
			keyName = "renderMorytania",
			name = "Morytania",
			description = "Check if you have unlocked Morytania",
			position = 19,
			section = regionMorytania
	)
	default boolean renderMorytania()
	{
		return false;
	}

	@ConfigItem(
			keyName = "renderFremennik",
			name = "Fremennik",
			description = "Check if you have unlocked Fremennik",
			position = 20,
			section = regionFremennik
	)
	default boolean renderFremennik()
	{
		return false;
	}



	@ConfigItem(
			keyName = "renderKourend",
			name = "Kourend & Kebos",
			description = "Check if you have unlocked Kourend & Kebos",
			position = 22,
			section = regionKourend
	)
	default boolean renderKourend()
	{
		return false;
	}

	@ConfigItem(
			keyName = "renderVarlamore",
			name = "Varlamore",
			description = "Check if you have unlocked Varlamore",
			position = 23,
			section = regionVarlamore
	)
	default boolean renderVarlamore()
	{
		return false;
	}

	@ConfigItem(
			keyName = "renderWilderness",
			name = "Wilderness",
			description = "Check if you have unlocked Wilderness",
			position = 22,
			section = regionWilderness
	)
	default boolean renderWilderness()
	{
		return false;
	}









}