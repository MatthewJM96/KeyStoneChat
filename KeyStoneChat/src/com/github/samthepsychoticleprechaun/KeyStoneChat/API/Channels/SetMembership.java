package com.github.samthepsychoticleprechaun.KeyStoneChat.API.Channels;

import com.github.samthepsychoticleprechaun.KeyStoneChat.Storage.ChannelValues;

public class SetMembership {
	
	/**
	 * Sets a player's membership status to member no matter their previous rank
	 * 
	 * @param channel
	 * @param name
	 */
	public void forceMember(String channel, String name) {
		
		int ind = ChannelValues.channelName.indexOf(channel);
		
		if(!ChannelValues.channelMembers.get(ind).contains(name)) {
			
			ChannelValues.channelMembers.get(ind).add(name);
			
		}
			
		while(ChannelValues.channelModerators.get(ind).contains(name)) {
				
			ChannelValues.channelModerators.get(ind).remove(name);
				
		}
			
		while(ChannelValues.channelOwners.get(ind).contains(name)) {
				
			ChannelValues.channelOwners.get(ind).remove(name);
				
		}
		
	}
	
	/**
	 * Sets a player's membership status to moderator no matter their previous rank
	 * 
	 * @param channel
	 * @param name
	 */
	public void forceModerator(String channel, String name) {
		
		int ind = ChannelValues.channelName.indexOf(channel);
		
		if(!ChannelValues.channelMembers.get(ind).contains(name)) {
			
			ChannelValues.channelMembers.get(ind).add(name);
			
		}
			
		if(!ChannelValues.channelModerators.get(ind).contains(name)) {
				
			ChannelValues.channelModerators.get(ind).add(name);
				
		}
			
		while(ChannelValues.channelOwners.get(ind).contains(name)) {
				
			ChannelValues.channelOwners.get(ind).remove(name);
				
		}
		
	}
	
	/**
	 * Sets a player's membership status to owner no matter their previous rank
	 * 
	 * @param channel
	 * @param name
	 */
	public void forceOwner(String channel, String name) {
		
		int ind = ChannelValues.channelName.indexOf(channel);
		
		if(!ChannelValues.channelMembers.get(ind).contains(name)) {
			
			ChannelValues.channelMembers.get(ind).add(name);
			
		}
			
		if(!ChannelValues.channelModerators.get(ind).contains(name)) {
				
			ChannelValues.channelModerators.get(ind).add(name);
				
		}
			
		if(!ChannelValues.channelOwners.get(ind).contains(name)) {
				
			ChannelValues.channelOwners.get(ind).add(name);
				
		}
		
	}
	
	/**
	 * Sets a player's membership status to member if they were previously a lower rank (not a member of the channel)
	 * 
	 * @param channel
	 * @param name
	 */
	public void setMember(String channel, String name) {
		
		int ind = ChannelValues.channelName.indexOf(channel);
		
		if(!ChannelValues.channelOwners.get(ind).contains(name) && !ChannelValues.channelModerators.get(ind).contains(name) && !ChannelValues.channelMembers.get(ind).contains(name)) {
			
			ChannelValues.channelMembers.get(ind).add(name);
			
		}
		
	}
	
	/**
	 * Sets a player's membership status to moderator if they were previously a lower rank (either member rank within the channel or not a member of the channel)
	 * 
	 * @param channel
	 * @param name
	 */
	public void setModerator(String channel, String name) {
		
		int ind = ChannelValues.channelName.indexOf(channel);
		
		if(!ChannelValues.channelOwners.get(ind).contains(name) && !ChannelValues.channelModerators.get(ind).contains(name)) {
			
			ChannelValues.channelModerators.get(ind).add(name);
			
			if(!ChannelValues.channelMembers.get(ind).contains(name)) {
				
				ChannelValues.channelMembers.get(ind).add(name);
				
			}
			
		}
		
	}
	
	/**
	 * Sets a player's membership status to owner if they were previously a lower rank (member or moderator rank within the channel or not a member of the channel)
	 * 
	 * @param channel
	 * @param name
	 */
	public void setOwner(String channel, String name) {
		
		int ind = ChannelValues.channelName.indexOf(channel);
		
		if(!ChannelValues.channelOwners.get(ind).contains(name)) {
			
			ChannelValues.channelOwners.get(ind).add(name);
			
			if(!ChannelValues.channelModerators.get(ind).contains(name)) {
				
				ChannelValues.channelModerators.get(ind).add(name);
				
			}
			
			if(!ChannelValues.channelMembers.get(ind).contains(name)) {
				
				ChannelValues.channelMembers.get(ind).add(name);
				
			}
			
		}
		
	}
	
}
