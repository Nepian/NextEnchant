package com.Nepian.NextEnchant.Listener.EnchantLevelUp;

import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;

import com.Nepian.NextEnchant.Configuration.Config;
import com.Nepian.NextEnchant.Event.EnchantLevelUpEvent;

public class EluEnchLevelUp implements Listener {
	@EventHandler
	public static void levelUp(EnchantLevelUpEvent event) {
		
		if (event.isCancelled()) {
			return;
		}
		
		Player player = event.getPlayer();
		ItemStack itemStack = event.getItemStack();
		Enchantment ench = event.getEnchantment();
		
		int level = itemStack.getEnchantmentLevel(ench);		
		
		player.giveExpLevels(level * Config.XP_RATE.getInt() * -1);
		itemStack.addUnsafeEnchantment(ench, level + 1);
	}
}
