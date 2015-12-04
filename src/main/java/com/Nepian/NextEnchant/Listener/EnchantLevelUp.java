package com.Nepian.NextEnchant.Listener;

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
import com.Nepian.NextEnchant.Event.EnchantLevelUpEvent.Outcome;

public class EnchantLevelUp implements Listener {
	private final static int XP_RATE = 10;
	
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
		
		if (xp < level * XP_RATE) {
			event.setOutcome(Outcome.NO_EXP);
		}
	}

	@EventHandler
	public static void levelUp(EnchantLevelUpEvent event) {
		
		if (event.isCancelled()) {
			return;
		}
		
		Player player = event.getPlayer();
		ItemStack itemStack = event.getItemStack();
		Enchantment ench = event.getEnchantment();
		
		int level = itemStack.getEnchantmentLevel(ench);		
		
		player.giveExpLevels(level * XP_RATE * -1);
		itemStack.addUnsafeEnchantment(ench, level + 1);
	}
	
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
		
		EnchantLevelUpEvent eve =
				new EnchantLevelUpEvent(player, item, Enchantment.DIG_SPEED);
		
		EventManager.callEvent(eve);
	}
}
