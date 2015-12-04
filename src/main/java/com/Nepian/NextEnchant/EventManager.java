package com.Nepian.NextEnchant;

import org.bukkit.Bukkit;
import org.bukkit.event.Event;
import org.bukkit.event.Listener;

import com.Nepian.NextEnchant.Listener.EnchantLevelUp.EluEnchLevelUp;
import com.Nepian.NextEnchant.Listener.EnchantLevelUp.EluEnchantChecker;
import com.Nepian.NextEnchant.Listener.EnchantLevelUp.EluXPChecker;
import com.Nepian.NextEnchant.Listener.PlayerInteract.PiEnchantLevelUp;

public class EventManager {
	private static final Main plugin;

	static {
		plugin = Main.getPlugin();
	}

	public static void load() {
		registerEnchantLevelUpEvent();
		registerPlayerInteractEvent();
	}

	public static void callEvent(Event event) {
		Bukkit.getPluginManager().callEvent(event);
	}

	private static void registerEvent(Listener listener) {
		plugin.getServer().getPluginManager().registerEvents(listener, plugin);
	}
	
	private static void registerEnchantLevelUpEvent() {
		registerEvent(new EluEnchantChecker());
		registerEvent(new EluXPChecker());
		registerEvent(new EluEnchLevelUp());
	}
	
	private static void registerPlayerInteractEvent() {
		registerEvent(new PiEnchantLevelUp());
	}
}
