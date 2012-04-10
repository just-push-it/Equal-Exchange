/**
 * @author nala3
 */
package net.worldoftomorrow.ee;

import org.bukkit.entity.Player;

public interface EqualExchangeAPI {
	/**
	 * Set a players balance
	 * @param player
	 * @param amnt
	 */
	public void setBalance(Player player, long amnt);
	/**
	 * Add to a players balance
	 * @param player
	 * @param amnt
	 */
	public void addBalance(Player player, long amnt);
	/**
	 * Remove from a players balance
	 * @param player
	 * @param amnt
	 */
	public void removeBalance(Player player, long amnt);
	/**
	 * Reset a players balance
	 * @param player
	 */
	public void resetBalance(Player player);
	 /**
	  * Reset a players balance to the default
	  * @param player
	  */
	public void resetBalanceToDefault(Player player);
}
