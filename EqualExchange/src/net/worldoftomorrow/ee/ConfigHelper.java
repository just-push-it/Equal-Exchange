package net.worldoftomorrow.ee;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;

import org.bukkit.Bukkit;

import net.worldoftomorrow.ee.ConfigurationManager.ConfigFile;

public class ConfigHelper {
	
	public static String version(){
		return Bukkit.getServer().getPluginManager().getPlugin("EqualExchange").getDescription().getVersion();
	}
	
	public static boolean isEnabled(){
		if(ConfigurationManager.getConfig(ConfigFile.CONFIG).getBoolean("Enabled") == true){ return true; }
		else { return false; }
	}
	
	public static String dbHost(){
		return ConfigurationManager.getConfig(ConfigFile.CONFIG).getString("DatabaseConfig.host");
	}
	
	public static String dbPort(){
		return ConfigurationManager.getConfig(ConfigFile.CONFIG).getString("DatabaseConfig.port");
	}
	
	public static String dbName(){
		return ConfigurationManager.getConfig(ConfigFile.CONFIG).getString("DatabaseConfig.database");
	}
	
	public static String dbUser(){
		return ConfigurationManager.getConfig(ConfigFile.CONFIG).getString("DatabaseConfig.user");
	}
	
	public static String dbPass(){
		return ConfigurationManager.getConfig(ConfigFile.CONFIG).getString("DatabaseConfig.password");
	}
	
	public static String defaultAmount(){
		return ConfigurationManager.getConfig(ConfigFile.CONFIG).getString("DefaultAmount");
	}
}
