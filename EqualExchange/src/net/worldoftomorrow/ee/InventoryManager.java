package net.worldoftomorrow.ee;

import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;

public class InventoryManager {
	public static boolean isFull(PlayerInventory inv){
		if(inv.firstEmpty() < 80){
			return false;
		} else { return true; }
	}
	
	public static void giveItems(PlayerInventory inv, int itemID, short dataValue, int amount){
		ItemStack stack = new ItemStack(itemID, amount);
		stack.setDurability(dataValue);
		inv.addItem(stack);
	}
	
}
