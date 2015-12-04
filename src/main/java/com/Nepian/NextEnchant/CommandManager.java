package com.Nepian.NextEnchant;

import com.Nepian.NextEnchant.Command.NextEnchantCommand;

public class CommandManager {
	private static Main plugin;
	
	static {
		plugin = Main.getPlugin();
	}
	
	public static void load() {
		plugin.getCommand("nextenchant").setExecutor(new NextEnchantCommand());
	}
}
