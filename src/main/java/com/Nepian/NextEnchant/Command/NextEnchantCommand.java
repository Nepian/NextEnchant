package com.Nepian.NextEnchant.Command;

import java.util.Map.Entry;

import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import com.Nepian.NextEnchant.EventManager;
import com.Nepian.NextEnchant.Event.EnchantLevelUpEvent;
import com.Nepian.NextEnchant.Util.EnchantmentUtil;

public class NextEnchantCommand implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		
		if (!(sender instanceof Player)) {
			return true;
		}
				
		if (args.length != 1) {
			return false;
		}
		
		Player player = (Player) sender;
		
		if (player.getItemInHand().getType() == Material.AIR) {
			return true;
		}
		
		final byte ENCHANT_NAME_NUM = 0;
		
		ItemStack item = player.getItemInHand();
		Enchantment enchantment = EnchantmentUtil.getEnchantment(args[ENCHANT_NAME_NUM]);
		
		if (enchantment == null) {
			this.showHasEnhantment(player, item);
			return true;
		}
		
		EnchantLevelUpEvent event = 
				new EnchantLevelUpEvent(player, item, enchantment);
		
		EventManager.callEvent(event);
		
		return true;
	}
	
	public void showHasEnhantment(Player player, ItemStack item) {
		StringBuilder msg = new StringBuilder(item.getType().toString() + "\n");
		
		for (Entry<Enchantment, Integer> ench : item.getEnchantments().entrySet()) {
			msg.append("EnchantName: ").append(ench.getKey().getName()).append(", ");
			msg.append("Level: ").append(ench.getValue()).append("\n");
		}
		
		player.sendMessage(msg.toString());
	}
}
