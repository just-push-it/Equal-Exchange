package net.worldoftomorrow.ee;

import org.bukkit.Bukkit;

import net.worldoftomorrow.ee.ConfigurationManager.ConfigFile;

public class ConfigHelper {
	
	/**
	 * @return plugin version
	 */
	public static String version(){
		return Bukkit.getServer().getPluginManager().getPlugin("EqualExchange").getDescription().getVersion();
	}
	
	/**
	 * @return if plugin is enabled
	 */
	public static boolean isEnabled(){
		return ConfigurationManager.getConfig(ConfigFile.CONFIG).getBoolean("Enabled");
	}
	
	/**
	 * @return database host
	 */
	public static String dbHost(){
		return ConfigurationManager.getConfig(ConfigFile.CONFIG).getString("DatabaseConfig.host");
	}
	
	/**
	 * @return database port
	 */
	public static int dbPort(){
		return ConfigurationManager.getConfig(ConfigFile.CONFIG).getInt("DatabaseConfig.port");
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
	
	public static long defaultAmount(){
		return ConfigurationManager.getConfig(ConfigFile.CONFIG).getLong("DefaultAmount");
	}
}
