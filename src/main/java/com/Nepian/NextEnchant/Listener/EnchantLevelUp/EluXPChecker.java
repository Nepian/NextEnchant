package com.Nepian.NextEnchant.Listener.EnchantLevelUp;

import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;

import com.Nepian.NextEnchant.Configuration.Config;
import com.Nepian.NextEnchant.Event.EnchantLevelUpEvent;
import com.Nepian.NextEnchant.Event.EnchantLevelUpEvent.Outcome;

public class EluXPChecker implements Listener {
	@EventHandler(priority = EventPriority.LOW)
	public static void xpCheck(EnchantLevelUpEvent event) {
		
		if (event.isCancelled()) {
			return;
		}
		
		Player player = event.getPlayer();
		ItemStack item = event.getItemStack();
		Enchantment ench = event.getEnchantment();
		
		int xp = player.getLevel();
		int level = item.getEnchantmentLevel(ench);
		
		if (xp < level * Config.XP_RATE.getInt()) {
			event.setOutcome(Outcome.NO_EXP);
		}
	}
}
