package com.Nepian.NextEnchant;

import org.bukkit.Bukkit;
import org.bukkit.event.Event;
import org.bukkit.event.Listener;

import com.Nepian.NextEnchant.Listener.EnchantLevelUp;

public class EventManager {
	private static final Main plugin;

	static {
		plugin = Main.getPlugin();
	}

	public static void load() {
		registerEvent(new EnchantLevelUp());
	}

	public static void callEvent(Event event) {
		Bukkit.getPluginManager().callEvent(event);
	}

	private static void registerEvent(Listener listener) {
		plugin.getServer().getPluginManager().registerEvents(listener, plugin);
	}
}
