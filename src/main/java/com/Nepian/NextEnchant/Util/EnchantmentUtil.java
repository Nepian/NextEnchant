package com.Nepian.NextEnchant.Util;

import org.bukkit.enchantments.Enchantment;

public class EnchantmentUtil {

	/**
	 * エンチャントを名前から取得する
	 * @param name
	 * @return enchantment
	 */
	public static Enchantment getEnchantment(String name) {
		for (Enchantment ench : Enchantment.values()) {
			if (ench.getName().equalsIgnoreCase(name)) {
				return ench;
			}
		}
		return null;
	}
}
