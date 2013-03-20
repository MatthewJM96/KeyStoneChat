package com.github.samthepsychoticleprechaun.KeyStoneChat;

import java.io.File;
import java.util.logging.Logger;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import com.github.samthepsychoticleprechaun.KeyStoneChat.Listeners.formatListener;
import com.github.samthepsychoticleprechaun.KeyStoneChat.Listeners.recipientsListeners;
import com.github.samthepsychoticleprechaun.KeyStoneChat.YAML.LoadChatYaml;
import com.github.samthepsychoticleprechaun.KeyStoneChat.YAML.SaveYaml;
import com.github.samthepsychoticleprechaun.KeyStoneCore.Storage.ConfigValues;

public class KeyStoneChat extends JavaPlugin {
	
	public static KeyStoneChat plugin;
	public static Logger log;
	
	public static File configFile;
	public static File channelFile;
	public static FileConfiguration config;
	public static FileConfiguration channel;
	
	@Override
	public void onEnable() {
		
		//Sets the plugin value for other classes
		plugin = this;
		
		//Gets the plugin's logger
		log = plugin.getLogger();
		
		LoadChatYaml load = new LoadChatYaml();
		
		//Creates and Loads necessary files
	    if(!ConfigValues.usemysql) {
	    channelFile = new File(getDataFolder(), "channels.yml");
		channel = new YamlConfiguration();
		load.loadYamls();
		}
	    
	    //Register all chat listeners
	    getServer().getPluginManager().registerEvents(new formatListener(), this);
	    getServer().getPluginManager().registerEvents(new recipientsListeners(), this);
		
	}
	
	@Override
	public void onDisable() {
		
		//Saves all changes to files while server was live
		SaveYaml.saveYamls();
		
	}
	
}
