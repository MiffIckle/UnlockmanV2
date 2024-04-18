package com.Unlockman;


import com.google.inject.Provides;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.concurrent.ScheduledExecutorService;
import javax.inject.Inject;
import lombok.AccessLevel;
import lombok.Setter;
import net.runelite.api.ChatMessageType;
import net.runelite.api.Client;
import net.runelite.api.MessageNode;
import net.runelite.api.Point;
import net.runelite.api.RenderOverview;
import net.runelite.api.events.ChatMessage;
import net.runelite.api.events.FocusChanged;
import net.runelite.api.events.MenuOptionClicked;
import net.runelite.api.widgets.Widget;
import net.runelite.api.widgets.WidgetInfo;
import net.runelite.client.chat.ChatColorType;
import net.runelite.client.chat.ChatCommandManager;
import net.runelite.client.chat.ChatMessageBuilder;
import net.runelite.client.chat.ChatMessageManager;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.events.ChatInput;
import net.runelite.client.events.ConfigChanged;
import net.runelite.client.input.KeyManager;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.ui.ClientToolbar;
import net.runelite.client.ui.NavigationButton;
import net.runelite.client.ui.overlay.OverlayManager;
import net.runelite.client.util.ImageUtil;
import net.runelite.client.util.LinkBrowser;
import net.runelite.client.util.Text;
import static net.runelite.client.util.Text.sanitize;
//import net.runelite.http.api.chat.ChatClient;

@PluginDescriptor(
		name = UnlockPlugin.PLUGIN_NAME,
		description = "Settings for the ChunkLite client.",
		tags = {"region", "locker", "chunk", "map", "square"}
)
public class UnlockPlugin extends Plugin
{
	static final String PLUGIN_NAME = "Unlockman";
	static final String CONFIG_KEY = "LockedRegions";
	private static final String CHUNK_COMMAND = "!unlock";
	//private final ChatClient chatClient = new ChatClient();

	@Inject
	private Client client;

	@Inject
	private ClientToolbar clientToolbar;

	@Inject
	private OverlayManager overlayManager;

	@Inject
	private UnlockConfig config;

	@Inject
	private UnlockRegionOverlay regionLockerOverlay;

	@Inject
	private UnlockRegionBorderOverlay regionBorderOverlay;

	//@Inject
	//private RegionLockerInput inputListener;

	@Inject
	private KeyManager keyManager;

	@Inject
	private ConfigManager configManager;

	@Inject
	private ChatMessageManager chatMessageManager;

	@Inject
	private ChatCommandManager chatCommandManager;

	@Inject
	private ScheduledExecutorService executor;

	@Setter(AccessLevel.PACKAGE)
	private boolean unlockKeyPressed = false;

	@Setter(AccessLevel.PACKAGE)
	private boolean blockKeyPressed = false;

	private UnlockRegions unlockRegions;
	private NavigationButton titleBarButton;

	@Provides
	UnlockConfig provideConfig(ConfigManager configManager)
	{
		return configManager.getConfig(UnlockConfig.class);
	}

	@Override
	protected void startUp() throws Exception
	{
		unlockRegions = new UnlockRegions(client, config, configManager);
		overlayManager.add(regionLockerOverlay);
		overlayManager.add(regionBorderOverlay);
	}

	@Override
	protected void shutDown() throws Exception
	{
		//chatCommandManager.unregisterCommand(CHUNK_COMMAND);
		overlayManager.remove(regionLockerOverlay);
		overlayManager.remove(regionBorderOverlay);
		//keyManager.unregisterKeyListener(inputListener);
		UnlockRegions.renderLockedRegions = false;
		//setButton(false);
	}

	@Subscribe
	public void onConfigChanged(ConfigChanged event)
	{
		if (!event.getGroup().equals(UnlockPlugin.CONFIG_KEY))
		{
			return;
		}
		unlockRegions.readConfig();
	}
}