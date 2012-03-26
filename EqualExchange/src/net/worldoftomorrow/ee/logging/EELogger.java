package net.worldoftomorrow.ee.logging;

import java.io.File;
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
			Logger log = Logger.getLogger("Minecraft.EqualExchange");
			if(type.equalsIgnoreCase("text")){
				File eelog = new File("EELog.log");
				if(!eelog.exists()){
					eelog.createNewFile();
				//	ostream = new FileOutputStream("EELog.log");
				}
				logFile = new FileHandler("EELog.log", true); //Append: true - So the file does not get reset every time.
				logFormat = new SimpleFormatter();
				logFile.setFormatter(logFormat);
				log.addHandler(logFile);
			}
			else if(type.equalsIgnoreCase("html")){
				File eelog = new File("EELog.html");
				if(!eelog.exists()){
					eelog.createNewFile();
				//	ostream = new FileOutputStream("EELog.html");
				}
				htmlFile = new FileHandler("EELog.html", true);
				htmlFormat = new LogFormatter();
				htmlFile.setFormatter(htmlFormat);
				log.addHandler(htmlFile);
			} else {/* Do nothing because they screwed up the config! */}
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
