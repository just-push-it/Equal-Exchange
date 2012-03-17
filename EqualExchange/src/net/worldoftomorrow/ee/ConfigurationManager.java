package net.worldoftomorrow.ee;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.EnumMap;
import java.util.Map;

import org.bukkit.Bukkit;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.YamlConfiguration;

public class ConfigurationManager {
	    private ConfigurationManager() {
	    }
	    public enum ConfigFile {
	        CONFIG("config.yml"),
	        ITEMS("items.yml");

	        private String file;
	        ConfigFile(String  file) {
	            this.file = file;
	        }

	        public String getFile() {
	            return this.file;
	        }
	    }

	    private static Map<ConfigFile, YamlConfiguration> config = new EnumMap<ConfigFile, YamlConfiguration>(ConfigFile.class);
	    private static Map<ConfigFile, File> configFile = new EnumMap<ConfigFile, File>(ConfigFile.class);
	    private static Map<ConfigFile, Boolean> loaded = new EnumMap<ConfigFile, Boolean>(ConfigFile.class);

	    public static YamlConfiguration getConfig(ConfigFile configfile) {
	        if (loaded.get(configfile) == null || !loaded.get(configfile)) {
	            loadConfig(configfile);
	        }
	        return config.get(configfile);
	    }

	    public static File getConfigFile(ConfigFile configfile) {
	        return configFile.get(configfile);
	    }

	    public static boolean getLoaded(ConfigFile configfile) {
	        return loaded.get(configfile);
	    }

	    public static void loadConfigs() {
	        for (ConfigFile configfile : ConfigFile.values()) {
	            loadConfig(configfile);
	        }
	    }
	    
	    public static void loadConfig(ConfigFile configfile) {
	        configFile.put(configfile, new File (Bukkit.getServer().getPluginManager().getPlugin("EqualExchange").getDataFolder(), configfile.getFile()));
	        if (configFile.get(configfile).exists()) {
	            config.put(configfile, new YamlConfiguration());
	            try {
	                config.get(configfile).load(configFile.get(configfile));
	            } catch (FileNotFoundException  ex) {
	                loaded.put(configfile, false);
	                return;
	            } catch (IOException  ex) {
	                loaded.put(configfile, false);
	                return;
	            } catch (InvalidConfigurationException ex) {
	                loaded.put(configfile, false);
	                return;
	            }
	            loaded.put(configfile, true);
	        } else {
	            try {
	                Bukkit.getServer().getPluginManager().getPlugin("EqualExchange").getDataFolder().mkdir();
	                InputStream  jarURL = ConfigurationManager.class.getResourceAsStream("/" + configfile.getFile());
	                copyFile(jarURL, configFile.get(configfile));
	                config.put(configfile, new YamlConfiguration());
	                config.get(configfile).load(configFile.get(configfile));
	                loaded.put(configfile, true);
	            } catch (Exception  e) {
	            }
	        }
	    }

	    private static void copyFile(InputStream  in, File  out) throws Exception  {
	        InputStream  fis = in;
	        FileOutputStream  fos = new FileOutputStream (out);
	        try {
	            byte[] buf = new byte[1024];
	            int i = 0;
	            while ((i = fis.read(buf)) != -1) {
	                fos.write(buf, 0, i);
	            }
	        } catch (Exception  e) {
	            throw e;
	        } finally {
	            if (fis != null) {
	                fis.close();
	            }
	            if (fos != null) {
	                fos.close();
	            }
	        }
	    }
	}
