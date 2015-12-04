package com.Nepian.NextEnchant.Listener.EnchantLevelUp;

import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;

import com.Nepian.NextEnchant.Event.EnchantLevelUpEvent;
import com.Nepian.NextEnchant.Event.EnchantLevelUpEvent.Outcome;

public class EluEnchantChecker implements Listener {

	@EventHandler(priority = EventPriority.LOWEST)
	public static void onEnchantLevelUp(EnchantLevelUpEvent event) {
		
		if (event.isCancelled()) {
			return;
		}
		
		ItemStack item = event.getItemStack();
		
		if (!item.containsEnchantment(event.getEnchantment())) {
			event.setOutcome(Outcome.NO_ENCHANTMENT);
		}
	}
}
