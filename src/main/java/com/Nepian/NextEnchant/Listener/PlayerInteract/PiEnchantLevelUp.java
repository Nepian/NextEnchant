package com.Nepian.NextEnchant.Listener.PlayerInteract;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

import com.Nepian.NextEnchant.EventManager;
import com.Nepian.NextEnchant.Event.EnchantLevelUpEvent;

public class PiEnchantLevelUp implements Listener {
	@EventHandler(priority = EventPriority.LOWEST)
	public static void onPlayerInteract(PlayerInteractEvent event) {
		
		if (event.getAction() != Action.RIGHT_CLICK_AIR) {
			return;
		}
		
		Player player = event.getPlayer();
		ItemStack item = player.getItemInHand();
		
		if (item.getType() == Material.AIR) {
			return;
		}
		
		if (!item.containsEnchantment(Enchantment.DIG_SPEED)) {
			return;
		}
		
		for (Enchantment ench : item.getEnchantments().keySet()) {
			player.sendMessage("GetName: " + ench.getName());
			player.sendMessage("toString: " + ench.toString());
		}
		
		EnchantLevelUpEvent eve =
				new EnchantLevelUpEvent(player, item, Enchantment.DIG_SPEED);
		
		EventManager.callEvent(eve);
	}
}
