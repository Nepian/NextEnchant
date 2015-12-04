package com.Nepian.NextEnchant.Event;

import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.bukkit.inventory.ItemStack;

public class EnchantLevelUpEvent extends Event {
	private static final HandlerList handlers = new HandlerList();
	
	private Player player;
	private ItemStack itemStack;
	private Enchantment ench;
	private Outcome outcome;
	
	public EnchantLevelUpEvent(Player player, ItemStack itemStack, Enchantment ench) {
		this.player = player;
		this.itemStack = itemStack;
		this.ench = ench;
		this.outcome = Outcome.SUCCESS;
	}
	
	public boolean isCancelled() {
		return outcome != Outcome.SUCCESS;
	}
	
	public void setOutcome(Outcome outcome) {
		this.outcome = outcome;
	}
	
	public Player getPlayer() {
		return this.player;
	}
	
	public ItemStack getItemStack() {
		return this.itemStack;
	}
	
	public Enchantment getEnchantment() {
		return this.ench;
	}

	@Override
	public HandlerList getHandlers() {
		return handlers;
	}

	public static HandlerList getHandlerList() {
		return handlers;
	}
	
	public enum Outcome {
		NO_EXP,
		SUCCESS
	}
}
