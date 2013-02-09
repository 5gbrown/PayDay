package de.brightstorm.config;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import org.apache.commons.io.FileUtils;
import org.bukkit.craftbukkit.libs.com.google.gson.Gson;
import org.bukkit.plugin.Plugin;

public class ConfigReader {
	public ConfigReader(Plugin plugin) throws IOException {
		File configFile= new File(plugin.getDataFolder() + System.getProperty("file.separator") + "users.yml");
		if(!configFile.exists()) {
			plugin.getLogger().info("config.json not found. Creating a new one...");
			FileUtils.copyURLToFile(getClass().getResource("config.json"), configFile);
		}
		confFile = new FileReader(configFile);
		config = new Gson();
	}
	
	public Config parse() {
		return config.fromJson(confFile, Config.class);
	}
	
	private Gson config;
	private Reader confFile;
}