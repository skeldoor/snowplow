package com.skeldoor;

import javax.inject.Inject;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.Client;
import net.runelite.api.events.GameTick;
import net.runelite.api.widgets.Widget;
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
	// fixedClassicOverlayId, resizableClassicOverlayId, resizableModernOverlayId
	private final int[] snowOverlayIds = {35913754, 10551297, 10747905};

	@Subscribe
	protected void onGameTick(GameTick ignored)
	{
		setOverlayHidden(true);
	}

	@Override
	protected void shutDown() throws Exception
	{
		setOverlayHidden(false);
	}

	private void setOverlayHidden(boolean hidden){
		for (int snowOverlayId : snowOverlayIds){
			Widget snowOverlay = client.getWidget(snowOverlayId);
			if (snowOverlay != null) snowOverlay.setHidden(hidden);
		}
	}
}
