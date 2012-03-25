package net.worldoftomorrow.ee.logging;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Formatter;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

import net.worldoftomorrow.ee.ConfigurationManager;
import net.worldoftomorrow.ee.ConfigurationManager.ConfigFile;

public class EELogger {
	static private FileHandler logFile;
	static private SimpleFormatter logFormat;
	static private FileHandler htmlFile;
	static private Formatter htmlFormat;
	private static String type = ConfigurationManager.getConfig(ConfigFile.CONFIG).getString("LogType");
	
	static public void loadLogger(){
		@SuppressWarnings("unused")
		FileOutputStream ostream = null;
		try {
			Logger log = Logger.getLogger("EqualExchange");
			if(type.equalsIgnoreCase("text")){
				//TODO: Figure out why the file gets reset every damned time.
				ostream = new FileOutputStream("EELog.log");
				logFile = new FileHandler("EELog.log");
				logFormat = new SimpleFormatter();
				logFile.setFormatter(logFormat);
				log.addHandler(logFile);
			}
			else if(type.equalsIgnoreCase("html")){
				ostream = new FileOutputStream("EELog.html");
				htmlFile = new FileHandler("EELog.html");
				htmlFormat = new LogFormatter();
				htmlFile.setFormatter(htmlFormat);
				log.addHandler(htmlFile);
			} else {
				ostream = new FileOutputStream("EELog.log");
				logFile = new FileHandler ("equalExchange.log");
			    logFormat = new SimpleFormatter();
			    logFile.setFormatter(logFormat);
				log.addHandler(logFile);
			}
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
