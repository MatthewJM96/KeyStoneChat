package com.github.samthepsychoticleprechaun.KeyStoneChat.YAML;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.logging.Logger;

import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.FileConfiguration;

import com.github.samthepsychoticleprechaun.KeyStoneChat.KeyStoneChat;

public class LoadChatYaml {
	
	private static KeyStoneChat plugin = KeyStoneChat.plugin;
	private static Logger log = KeyStoneChat.log;
	
	public LoadChatYaml() {
		return;
	}
	
	/**
	 *  Loads all files from <plugin>.jar file to plugins/<plugin> folder.
	 * 
	 * @return Boolean of true if successful, else returns false.
	 */
	public boolean loadYamls() {
		
		if(!loadConf())
			return false;
		if(!loadChannel())
			return false;
		
		return true;
		
	}
	
	/**
	 * Overwrites settings in "config.yml" file in plugins/<plugin> folder with default values.
	 * 
	 * @return boolean
	 */
	public boolean overwriteConf() {
		
		File configFile = KeyStoneChat.configFile;
		FileConfiguration config = KeyStoneChat.config;
		
		configFile.getParentFile().mkdirs();
		copy(plugin.getResource("config.yml"), configFile);
		KeyStoneChat.configFile = configFile;
		
		try {
			config.load(configFile);
		} catch (FileNotFoundException e) {
			log.info("Config file was not found!");
			e.printStackTrace();
		} catch (IOException e) {
			log.info("Error loading config file!");
			e.printStackTrace();
		} catch (InvalidConfigurationException e) {
			log.info("Error loading config file!");
			e.printStackTrace();
		}

		KeyStoneChat.config = config;
		
		return true;
		
	}
	
	/**
	 * Overwrites settings in "channels.yml" file in plugins/<plugin> folder with default values.
	 * 
	 * @return boolean
	 */
	public boolean overwriteChannel() {
		
		File channelFile = KeyStoneChat.channelFile;
		FileConfiguration channel = KeyStoneChat.channel;
		
		channelFile.getParentFile().mkdirs();
		copy(plugin.getResource("channels.yml"), channelFile);
		KeyStoneChat.channelFile = channelFile;
		
		try {
			channel.load(channelFile);
		} catch (FileNotFoundException e) {
			log.info("Channel file was not found!");
			e.printStackTrace();
			return false;
		} catch (IOException e) {
			log.info("Error loading channel file!");
			e.printStackTrace();
			return false;
		} catch (InvalidConfigurationException e) {
			log.info("Error loading channel file!");
			e.printStackTrace();
			return false;
		}

		KeyStoneChat.channel = channel;
		
		return true;
		
	}
	
	/**
	 * Loads settings in "config.yml" file in plugins/<plugin> folder.
	 * 
	 * @return boolean
	 */
	public boolean loadConf() {
		
		File configFile = KeyStoneChat.configFile;
		FileConfiguration config = KeyStoneChat.config;
		
		try {
			config.load(configFile);
		} catch (FileNotFoundException e) {
			log.info("Config file was not found!");
			e.printStackTrace();
			return false;
		} catch (IOException e) {
			log.info("Error loading config file!");
			e.printStackTrace();
			return false;
		} catch (InvalidConfigurationException e) {
			log.info("Error loading config file!");
			e.printStackTrace();
			return false;
		}

		KeyStoneChat.config = config;
		
		return true;
		
	}
	
	/**
	 * Loads settings in "channels.yml" file in plugins/<plugin> folder.
	 * 
	 * @return boolean
	 */
	public boolean loadChannel() {
		
		File channelFile = KeyStoneChat.channelFile;
		FileConfiguration channel = KeyStoneChat.channel;
		
		try {
			channel.load(channelFile);
		} catch (FileNotFoundException e) {
			log.info("Channel file was not found!");
			e.printStackTrace();
			return false;
		} catch (IOException e) {
			log.info("Error loading channel file!");
			e.printStackTrace();
			return false;
		} catch (InvalidConfigurationException e) {
			log.info("Error loading channel file!");
			e.printStackTrace();
			return false;
		}

		KeyStoneChat.channel = channel;
		
		return true;
		
	}
	
	
	/**
	 * Copies file from .jar file to plugins.<plugin name> directory
	 * 
	 * @param in
	 * @param file
	 */
	private void copy(InputStream in, File file) {
		
        try {
        	
            OutputStream out = new FileOutputStream(file);
            byte[] buf = new byte[1024];
            int len;
            
            while((len=in.read(buf))>0){
            	
                out.write(buf,0,len);
                
            }
            
            out.close();
            in.close();
            
        } catch (Exception e) {
        	
            e.printStackTrace();
            
        }
        
    }

}
