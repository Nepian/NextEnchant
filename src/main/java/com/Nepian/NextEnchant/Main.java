package com.Nepian.NextEnchant;

import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {
	private static Main plugin;
	
	public Main() {
		plugin = this;
	}
	
	@Override
	public void onEnable() {
		EventManager.load();
		CommandManager.load();
	}
	
	public static Main getPlugin() {
		return plugin;
	}
}