package net.worldoftomorrow.ee;

import java.sql.SQLException;

import org.bukkit.entity.Player;

import net.worldoftomorrow.ee.ConfigurationManager.ConfigFile;

public class MathHelper {
	
	public static int getItemValue(String item){
		return ConfigurationManager.getConfig(ConfigFile.ITEMS).getInt(item);
	}
	
	public static int getItemValue(int item){
		String name = SpawnableItem.toName(item);
		return ConfigurationManager.getConfig(ConfigFile.ITEMS).getInt(name);
	}
	
	public static long getEMCSum(String item, int amount){
		int EMCValue = getItemValue(item);
		return EMCValue * amount;
	}
	
	public static long getEMCSum(int item, int amount){
		int EMCValue = getItemValue(item);
		return EMCValue * amount;
	}
	
	public static long getNewEMCAmount(Player player, long l) throws SQLException{
		long current = DatabaseManager.getBalance(player);
		return current + l;
	}
	
	public static boolean canGet(String item, int amount, Player player) throws SQLException{
		long current = DatabaseManager.getBalance(player);
		long cost = getEMCSum(item, amount);
		if(current - cost > 0){ return true; }
		else{ return false; }
	}
	
	public static boolean canGet(int item, int amount, Player player) throws SQLException{
		long current = DatabaseManager.getBalance(player);
		long cost = getEMCSum(item, amount);
		if(current - cost > 0){ return true; }
		else{ return false; }
	}
	
	public static short getData(String item){
		int i = 0;
		String data[] = null;
		if(item.contains(":")){
			data = item.split(":", 2);
		}
		try { i = Integer.parseInt(data[2]); }
		catch(NumberFormatException e){
			i = DataItem.lookup(data[2]).getID();
			//TODO: Add the code to change name into data value. i.e. slab:wood
			//Hopefully this is done. Need to test though.
		}
		return (short) i;
	}
}
