package com.github.samthepsychoticleprechaun.KeyStoneChat.YAML;

import java.util.logging.Logger;

import org.bukkit.configuration.file.FileConfiguration;

import com.github.samthepsychoticleprechaun.KeyStoneChat.KeyStoneChat;
import com.github.samthepsychoticleprechaun.KeyStoneChat.Storage.ChannelValues;

public class GetYamlValues {
	
	public static boolean getChannelValues() {
		
		FileConfiguration channel = KeyStoneChat.channel;
		Logger log = KeyStoneChat.log;
		ChannelValues channelVal = new ChannelValues();
		
		try {
			
			channelVal.setChannelCount(channel.getInt("channelcount"));
			
			int count = channelVal.getChannelCount();
			
			for(int x = 1; x <= count; x++) {
				
				channelVal.addChannelName(channel.getString("id" + x +".channelName"));
				channelVal.addPassword(channel.getString("id" + x +".password"));
				channelVal.addHasPass(channel.getBoolean("id" + x + ".hasPass"));
				channelVal.addDescription(channel.getString("id" + x +".description"));
				channelVal.addHasDesc(channel.getBoolean("id" + x + ".hasDesc"));
				channelVal.addChannelOwners(channel.getStringList("id" + x +".channelOwners"));
				channelVal.addChannelModerators(channel.getStringList("id" + x +".channelModerators"));
				channelVal.addChannelMembers(channel.getStringList("id" + x +".channelMembers"));
				
			}
			
		} catch (Exception e) {
			log.info("Error getting channel values!");
			e.printStackTrace();
			return false;			
		}
		
		return true;
		
	}

}
