package com.github.samthepsychoticleprechaun.KeyStoneChat.YAML;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.Logger;

import org.bukkit.configuration.file.FileConfiguration;

import com.github.samthepsychoticleprechaun.KeyStoneChat.KeyStoneChat;
import com.github.samthepsychoticleprechaun.KeyStoneChat.Storage.ChannelValues;

public class SaveYaml {
	
	private static Logger log = KeyStoneChat.log;
	
	/**
	 * Saves all files in plugins/<plugin> folder
	 * 
	 * @return boolean
	 */
	public static boolean saveYamls() {
		
		saveConfig();
		saveChannel();
		
		return true;
		
	}
	
	/**
	 * Saves config FileConfiguration of KeyStoneChat to "config.yml" in plugins/<plugin> folder
	 * 
	 * @return boolean
	 */
	public static boolean saveConfig() {
		
		File configFile = KeyStoneChat.configFile;
		FileConfiguration config = KeyStoneChat.config;
		
		try {
			config.save(configFile);			
		} catch (FileNotFoundException e) {
			log.info("Config file was not found!");
			e.printStackTrace();
			return false;
		} catch (IOException e) {
			log.info("Error while saving config file!");
			e.printStackTrace();
			return false;
		}
		
		return true;
		
	}
	
	/**
	 * Saves channel FileConfiguration of KeyStoneChat to "channels.yml" in plugins/<plugin> folder
	 * 
	 * @return boolean
	 */
	public static boolean saveChannel() {
		
		File channelFile = KeyStoneChat.channelFile;
		FileConfiguration channel = KeyStoneChat.channel;
		
		for(int x = 0; x <= (ChannelValues.channelName.size() -1); x++) {
			
			SetYamlValues.setChannelValues("id" + (x + 1) + ".channelName", ChannelValues.channelName.get(x));
			SetYamlValues.setChannelValues("id" + (x + 1) + ".password", ChannelValues.password.get(x));
			SetYamlValues.setChannelValues("id" + (x + 1) + ".hasPass", ChannelValues.hasPass.get(x));
			SetYamlValues.setChannelValues("id" + (x + 1) + ".description", ChannelValues.description.get(x));
			SetYamlValues.setChannelValues("id" + (x + 1) + ".hasDesc", ChannelValues.hasDesc.get(x));
			SetYamlValues.setChannelValues("id" + (x + 1) + ".channelOwners", ChannelValues.channelOwners.get(x));
			SetYamlValues.setChannelValues("id" + (x + 1) + ".channelModerators", ChannelValues.channelModerators.get(x));
			SetYamlValues.setChannelValues("id" + (x + 1) + ".channelMembers", ChannelValues.channelMembers.get(x));
			
		}
		
		try {
			channel.save(channelFile);			
		} catch (FileNotFoundException e) {
			log.info("channel file was not found!");
			e.printStackTrace();
			return false;
		} catch (IOException e) {
			log.info("Error while saving channel file!");
			e.printStackTrace();
			return false;
		}
		
		return true;
		
	}
	
}
