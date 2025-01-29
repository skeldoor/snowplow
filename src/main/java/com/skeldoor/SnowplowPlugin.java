package com.skeldoor;

import com.google.inject.Provides;
import javax.inject.Inject;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.ChatMessageType;
import net.runelite.api.Client;
import net.runelite.api.GameState;
import net.runelite.api.events.GameStateChanged;
import net.runelite.api.events.GameTick;
import net.runelite.api.widgets.Widget;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;

@Slf4j
@PluginDescriptor(
	name = "Snowplow"
)
public class SnowplowPlugin extends Plugin
{
	@Inject
	private Client client;

	@Inject
	private SnowplowConfig config;

	@Subscribe
	protected void onGameTick(GameTick ignored)
	{
		Widget snowOverlay = client.getWidget(config.snowOverlayId());
		if (snowOverlay != null) client.getWidget(config.snowOverlayId()).setHidden(true);
	}

	@Override
	protected void shutDown() throws Exception
	{
		Widget snowOverlay = client.getWidget(config.snowOverlayId());
		if (snowOverlay != null) client.getWidget(config.snowOverlayId()).setHidden(false);
	}

	@Provides
	SnowplowConfig provideConfig(ConfigManager configManager)
	{
		return configManager.getConfig(SnowplowConfig.class);
	}
}
