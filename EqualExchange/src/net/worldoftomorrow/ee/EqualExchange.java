package net.worldoftomorrow.ee;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import net.worldoftomorrow.ee.ConfigurationManager.ConfigFile;
import net.worldoftomorrow.ee.logging.EELogger;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class EqualExchange extends JavaPlugin {

	private static final Logger log = Logger.getLogger("Minecraft");
	private static final Logger eelog = Logger.getLogger("EqualExchange");
	private CommandManager cm = new CommandManager(this);

	@Override
	public void onEnable() {
		ConfigurationManager.loadConfigs();
		if(ConfigurationManager.getConfig(ConfigFile.CONFIG).getBoolean("EnableLogging") == true){
		EELogger.loadLogger();
		}
		/*
		 *  Check to see if the plugin is enabled in the configuration, if it is
		 *  not, disable the plugin
		 */
		if (ConfigHelper.isEnabled()) {
			// Then try to connect to the database, if it can't then disable the plugin
			try {
				DatabaseManager.CanDatabaseConnect();
			} catch (SQLException e) {
				eelog.log(Level.SEVERE, "Could not connect to the database.");
				log.log(Level.SEVERE, "Can not connect to the Database! Disabling..");
				this.getPluginLoader().disablePlugin(this);
			}
			// Then try to create the tables, this function checks if they
			// already exists, so don't worry.
			if (this.isEnabled()) {
				try {
					DatabaseManager.CreateTables();
					log.log(Level.INFO, "Table ee_users exists / was created.");
				} catch (SQLException e) {
					eelog.log(Level.SEVERE, "Could not create the tables. Printing stacktrace.", e);
					log.log(Level.SEVERE, "Can not create database tables! Disabling..");
					this.getPluginLoader().disablePlugin(this);
				}
			}
				if (this.isEnabled()) {
					log.log(Level.INFO, "EqualExchange has been loaded..");
				}
		} else {
			log.log(Level.INFO,
					"Plugin is disabled in configuration. Disabling..");
			this.getPluginLoader().disablePlugin(this);
		}
	}

	@Override
	public void onDisable() {
		
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
		if (commandLabel.equalsIgnoreCase("ee")) {
			try {
				cm.CommandParser((Player) sender, commandLabel, args);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return false;
	}
}
