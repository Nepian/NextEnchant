package com.Nepian.NextEnchant.Configuration;

import java.io.File;
import java.io.IOException;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

public enum Config {
	XP_RATE(10);

	private Object value;

	/* Constructor ----------------------------------------------------------*/

	Config(Object value) {
		this.value = value;
	}

	/* Methods --------------------------------------------------------------*/

	public int getInt() {
		return (int) this.get();
	}

	public static void load(File file) {
		read(file);
		save(file);
	}

	public static void save(File file) {
		write(file);
	}

	/* Private Methods ------------------------------------------------------*/

	private Object get() {
		return this.value;
	}

	private String toPath() {
		return this.toString().toLowerCase().replace("__", ".");
	}

	private static void read(File file) {
		FileConfiguration conf = YamlConfiguration.loadConfiguration(file);

		for (Config key : values()) {
			String path = key.toPath();

			if (conf.contains(path)) {
				key.value = conf.get(path);
			}
		}
	}

	private static void write(File file) {
		FileConfiguration conf = YamlConfiguration.loadConfiguration(file);

		for (Config key : values()) {
			conf.set(key.toPath(), key.value);
		}

		try {
			conf.save(file);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
