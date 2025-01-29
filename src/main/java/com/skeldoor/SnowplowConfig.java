package com.skeldoor;

import net.runelite.client.config.Config;
import net.runelite.client.config.ConfigGroup;
import net.runelite.client.config.ConfigItem;

@ConfigGroup("snowplow")
public interface SnowplowConfig extends Config
{
	@ConfigItem(
		keyName = "snowOverlayId",
		name = "Snow Overlay Id",
		description = "The default overlay id for the snow layer"
	)
	default int snowOverlayId()
	{
		return 10551297;
	}
}
