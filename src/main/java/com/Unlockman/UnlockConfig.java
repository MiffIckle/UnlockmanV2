package com.Unlockman;

import java.awt.Color;

import net.runelite.client.config.*;

@ConfigGroup(UnlockPlugin.CONFIG_KEY)
public interface UnlockConfig extends Config
{
	@ConfigSection(
			position = 0,
			name = "Regions",
			description = "Configurable region lock"
	)
	String regionSection = "regionSection";

	@ConfigSection(
			position = 1,
			name = "Map Overlay",
			description = "Configurable region lock"
	)
	String mapSection = "mapSection";

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
			description = "Draws the chunk borders in the environment",
			position = 15,
			section = regionSection
	)
	default boolean renderMisthalin()
	{
		return false;
	}

	@ConfigItem(
			keyName = "renderDesert",
			name = "Desert",
			description = "Draws the chunk borders in the environment",
			position = 16,
			section = regionSection
	)
	default boolean renderDesert()
	{
		return false;
	}

	@ConfigItem(
			keyName = "renderTiranwnn",
			name = "Tiranwnn",
			description = "Draws the chunk borders in the environment",
			position = 17,
			section = regionSection
	)
	default boolean renderTiranwnn()
	{
		return false;
	}
}