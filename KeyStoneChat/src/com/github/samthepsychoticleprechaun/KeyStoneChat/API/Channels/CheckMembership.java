package com.github.samthepsychoticleprechaun.KeyStoneChat.API.Channels;

import com.github.samthepsychoticleprechaun.KeyStoneChat.Storage.ChannelValues;

public class CheckMembership {
	
	/**
	 * Checks if a player is a member of the given channel
	 * 
	 * @param channel
	 * @param name
	 * @return
	 */
	public boolean checkMember(String channel, String name) {
		
		int ind = ChannelValues.channelName.indexOf(channel);
		
		if(ChannelValues.channelMembers.get(ind).contains(name)) {
			
			return true;
			
		}
		
		return false;
		
	}
	
	/**
	 * Checks if a player is a moderator of the given channel
	 * 
	 * @param channel
	 * @param name
	 * @return
	 */
	public boolean checkModerator(String channel, String name) {
		
		int ind = ChannelValues.channelName.indexOf(channel);
		
		if(ChannelValues.channelModerators.get(ind).contains(name)) {
			
			return true;
			
		}
		
		return false;
		
	}
	
	/**
	 * Checks if a player is an owner of the given channel
	 * 
	 * @param channel
	 * @param name
	 * @return
	 */
	public boolean checkOwner(String channel, String name) {
		
		int ind = ChannelValues.channelName.indexOf(channel);
		
		if(ChannelValues.channelOwners.get(ind).contains(name)) {
			
			return true;
			
		}
		
		return false;
		
	}	

}
