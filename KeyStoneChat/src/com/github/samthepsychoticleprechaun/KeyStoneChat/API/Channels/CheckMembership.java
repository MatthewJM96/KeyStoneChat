package com.github.samthepsychoticleprechaun.KeyStoneChat.API.Channels;

import com.github.samthepsychoticleprechaun.KeyStoneChat.Storage.ChannelValues;

public class CheckMembership {
	
	static ChannelValues channel = new ChannelValues();	
	
	/**
	 * Checks if a player is a member of the given channel
	 * 
	 * @param channel
	 * @param name
	 * @return
	 */
	public boolean checkMember(String channelname, String name) {
		
		int ind = channel.getChannelName().indexOf(channelname);
		
		if(channel.getChannelMembers().get(ind).contains(name)) {
			
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
	public boolean checkModerator(String channelname, String name) {

		int ind = channel.getChannelName().indexOf(channelname);
		
		if(channel.getChannelModerators().get(ind).contains(name)) {
			
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
	public boolean checkOwner(String channelname, String name) {

		int ind = channel.getChannelName().indexOf(channelname);
		
		if(channel.getChannelOwners().get(ind).contains(name)) {
			
			return true;
			
		}
		
		return false;
		
	}	

}
