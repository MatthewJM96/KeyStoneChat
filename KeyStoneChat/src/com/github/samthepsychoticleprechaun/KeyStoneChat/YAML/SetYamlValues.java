package com.github.samthepsychoticleprechaun.KeyStoneChat.YAML;

import java.util.List;

import org.bukkit.configuration.file.FileConfiguration;

import com.github.samthepsychoticleprechaun.KeyStoneChat.KeyStoneChat;

public class SetYamlValues {
	
	public static void setConfigValues(String path, String value) {
		
		FileConfiguration config = KeyStoneChat.config;
		config.set(path, value);
		
	}
	
	public static void setChannelValues(String path, String value) {
		
		FileConfiguration config = KeyStoneChat.channel;
		config.set(path, value);
		
	}
	
	public static void setChannelValues(String path, boolean value) {
		
		FileConfiguration config = KeyStoneChat.channel;
		config.set(path, value);
		
	}
	
	public static void setChannelValues(String path, List<String> value) {
		
		FileConfiguration config = KeyStoneChat.channel;
		config.set(path, value);
		
	}

}
