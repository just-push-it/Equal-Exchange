package net.worldoftomorrow.ee;

import java.sql.SQLException;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

public class EqualExchangeAPI {
	public void setBalance(Player player, long amnt){
		try {
			DatabaseManager.setBalance(player, amnt);
		} catch (SQLException e) {
			player.sendMessage(ChatColor.RED + "[EE] Could not complete \"setBalance\". Please report this.");
			//TODO: MENU - Add suggested fixes to a menu.
		}
	}
	
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
				//TODO: MENU - Add suggested fixes to a menu.
				//Maybe just make a easy fix suggestions menu.
			}
		} catch (SQLException e) {
			player.sendMessage(ChatColor.RED + "[EE] Could not complete \"getBalance\". Please report this.");
			//TODO: MENU - Add suggested fixes to a menu.
		}
	}
	
	public void removeBalance(Player player, long amnt){
		try {
			DatabaseManager.subtractFromBalance(player, amnt);
		} catch (SQLException e) {
			player.sendMessage(ChatColor.RED + "[EE] Could not complete \"removeBalance\". Please report this.");
		}
	}
	
	public void resetBalance(Player player){
		try {
			DatabaseManager.setBalance(player, 0);
		} catch (SQLException e) {
			player.sendMessage(ChatColor.RED + "[EE] Could not complete \"resetBalance\". Please report this.");
		}
	}
}
