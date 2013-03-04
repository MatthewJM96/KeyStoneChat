package com.github.samthepsychoticleprechaun.KeyStoneChat.YAML;

import java.util.logging.Logger;

import org.bukkit.configuration.file.FileConfiguration;

import com.github.samthepsychoticleprechaun.KeyStoneChat.KeyStoneChat;
import com.github.samthepsychoticleprechaun.KeyStoneChat.Storage.ChannelValues;

public class GetYamlValues {
	
	public static boolean getChannelValues() {
		
		FileConfiguration channel = KeyStoneChat.channel;
		Logger log = KeyStoneChat.log;
		
		try {
			
			ChannelValues.channelcount = channel.getInt("channelcount");
			
			for(int x = 1; x <= ChannelValues.channelcount; x++) {
				
				ChannelValues.channelName.add(channel.getString("id" + x +".channelName"));
				ChannelValues.password.add(channel.getString("id" + x +".password"));
				ChannelValues.hasPass.add(channel.getBoolean("id" + x + ".hasPass"));
				ChannelValues.description.add(channel.getString("id" + x +".description"));
				ChannelValues.hasDesc.add(channel.getBoolean("id" + x + ".hasDesc"));
				ChannelValues.channelOwners.add(channel.getStringList("id" + x +".channelOwners"));
				ChannelValues.channelModerators.add(channel.getStringList("id" + x +".channelModerators"));
				ChannelValues.channelMembers.add(channel.getStringList("id" + x +".channelMembers"));
				
			}
			
		} catch (Exception e) {
			log.info("Error getting channel values!");
			e.printStackTrace();
			return false;			
		}
		
		return true;
		
	}

}
