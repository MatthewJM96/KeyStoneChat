package com.github.samthepsychoticleprechaun.KeyStoneChat.API.Channels;

import com.github.samthepsychoticleprechaun.KeyStoneChat.API.Chat.SendMessage;
import com.github.samthepsychoticleprechaun.KeyStoneChat.Storage.ChannelValues;

public class RenameChannel {
	
	public RenameChannel() {
		return;
	}
	
	ChannelValues channel = new ChannelValues();
	SendMessage msg = new SendMessage();
	
	/**
	 * Renames the given channel's name to the provided new name.
	 * 
	 * @param channelName - The channel's current name.
	 * @param newChannelName - The channel's new name.
	 */
	public void renameChannel(String channelName, String newChannelName) {
		
		int ind = channel.getChannelName().indexOf(channelName);
		
		channel.setChannelName(newChannelName, ind);
		
	}

}
