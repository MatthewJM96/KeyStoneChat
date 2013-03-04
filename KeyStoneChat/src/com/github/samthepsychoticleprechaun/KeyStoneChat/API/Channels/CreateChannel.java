package com.github.samthepsychoticleprechaun.KeyStoneChat.API.Channels;

import java.util.Arrays;
import java.util.List;

import com.github.samthepsychoticleprechaun.KeyStoneChat.Storage.ChannelValues;

public class CreateChannel {
	
	public void createChannel(String name, String creator) {
		
		String[] arrayOwners = new String[] {creator};
		List<String> listOwners = Arrays.asList(arrayOwners);
		String[] arrayModerators = new String[] {creator};
		List<String> listModerators = Arrays.asList(arrayModerators);
		String[] arrayMembers = new String[] {creator};
		List<String> listMembers = Arrays.asList(arrayMembers);
		
		ChannelValues.channelcount += 1;
		ChannelValues.channelName.add(name);
		ChannelValues.password.add("empty");
		ChannelValues.hasPass.add(false);
		ChannelValues.description.add("empty");
		ChannelValues.hasDesc.add(false);	
		ChannelValues.channelOwners.add(listOwners);
		ChannelValues.channelModerators.add(listModerators);
		ChannelValues.channelMembers.add(listMembers);
		
	}

}
