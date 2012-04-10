/**
 * @author nala3
 */
package net.worldoftomorrow.ee;

import java.sql.SQLException;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

public class CEqualExchangeAPI implements EqualExchangeAPI{
	
	/**
	 * Set a players account to a certain balance
	 * @see net.worldoftomorrow.ee.EqualExchangeAPI#setBalance(org.bukkit.entity.Player, long)
	 */
	public void setBalance(Player player, long amnt){
		try {
			DatabaseManager.setBalance(player, amnt);
		} catch (SQLException e) {
			player.sendMessage(ChatColor.RED + "[EE] Could not complete \"setBalance\". Please report this.");
		}
	}
	
	/**
	 * Add a certain amount to a players account
	 * @see net.worldoftomorrow.ee.EqualExchangeAPI#addBalance(org.bukkit.entity.Player, long)
	 */
	public void addBalance(Player player, long amnt){
		long current;
		long nb;
		//Try to get balance
		try {
			current = DatabaseManager.getBalance(player);
			nb = current + amnt;
			//Try to set balance
			try{
				DatabaseManager.setBalance(player, nb);
			} catch (SQLException e) {
				player.sendMessage(ChatColor.RED + "[EE] Could not complete \"setBalance\". Please report this.");
			}
		} catch (SQLException e) {
			player.sendMessage(ChatColor.RED + "[EE] Could not complete \"getBalance\". Please report this.");
		}
	}
	
	/**
	 * Remove a certain amount from a players account
	 * @see net.worldoftomorrow.ee.EqualExchangeAPI#removeBalance(org.bukkit.entity.Player, long)
	 */
	public void removeBalance(Player player, long amnt){
		try {
			DatabaseManager.subtractFromBalance(player, amnt);
		} catch (SQLException e) {
			player.sendMessage(ChatColor.RED + "[EE] Could not complete \"removeBalance\". Please report this.");
		}
	}
	
	/**
	 * Reset a players balance
	 * @see net.worldoftomorrow.ee.EqualExchangeAPI#resetBalance(org.bukkit.entity.Player)
	 */
	public void resetBalance(Player player){
		try {
			DatabaseManager.setBalance(player, 0);
		} catch (SQLException e) {
			player.sendMessage(ChatColor.RED + "[EE] Could not complete \"resetBalance\". Please report this.");
		}
	}
	
	/**
	 * Reset a players balance to the default amount
	 * @see net.worldoftomorrow.ee.EqualExchangeAPI#resetBalanceToDefault(org.bukkit.entity.Player)
	 */
	public void resetBalanceToDefault(Player player){
		long b = ConfigHelper.defaultAmount();
		try{
			DatabaseManager.setBalance(player, b);
		} catch (SQLException e){
			player.sendMessage(ChatColor.RED + "[EE] Could not complete \"resetBalanceToDefault\". Please report this.");
		}
	}
}
