package com.github.samthepsychoticleprechaun.KeyStoneChat.API.Channels;

import java.util.List;

import com.github.samthepsychoticleprechaun.KeyStoneChat.Storage.ChannelValues;

public class SetMembership {
	
	static ChannelValues channel = new ChannelValues();
	
	/**
	 * Sets a player's membership status to member no matter their previous rank
	 * 
	 * @param channel
	 * @param name
	 */
	public static void forceMember(String channelname, String name) {
		
		int ind = channel.getChannelName().indexOf(channel);
		List<String> listMem = channel.getChannelMembers().get(ind);
		List<String> listMod = channel.getChannelModerators().get(ind);
		List<String> listOwn = channel.getChannelOwners().get(ind);
		
		checkLists(ind);
		
		if(!channel.getChannelMembers().get(ind).contains(name)) {
			
			listMem.add(name);			
			channel.setChannelMembers(listMem, ind);
			
		}
			
		while(channel.getChannelModerators().get(ind).contains(name)) {
				
			listMod.remove(name);
				
		}
		
		channel.setChannelModerators(listMod, ind);
			
		while(channel.getChannelOwners().get(ind).contains(name)) {
				
			listOwn.remove(name);
				
		}
		
		channel.setChannelOwners(listOwn, ind);
		
	}
	
	/**
	 * Sets a player's membership status to moderator no matter their previous rank
	 * 
	 * @param channel
	 * @param name
	 */
	public static void forceModerator(String channelname, String name) {
		
		int ind = channel.getChannelName().indexOf(channelname);
		List<String> listMem = channel.getChannelMembers().get(ind);
		List<String> listMod = channel.getChannelModerators().get(ind);
		List<String> listOwn = channel.getChannelOwners().get(ind);
		
		checkLists(ind);
		
		if(!channel.getChannelMembers().get(ind).contains(name)) {

			listMem.add(name);
			channel.setChannelMembers(listMem, ind);
			
		}
			
		if(!channel.getChannelModerators().get(ind).contains(name)) {
			
			listMod.add(name);
			channel.setChannelModerators(listMod, ind);
				
		}
			
		while(channel.getChannelOwners().get(ind).contains(name)) {
				
			listOwn.remove(name);
				
		}
		
		channel.setChannelOwners(listOwn, ind);
		
	}
	
	/**
	 * Sets a player's membership status to owner no matter their previous rank
	 * 
	 * @param channel
	 * @param name
	 */
	public static void forceOwner(String channelname, String name) {
		
		int ind = channel.getChannelName().indexOf(channelname);
		List<String> listMem = channel.getChannelMembers().get(ind);
		List<String> listMod = channel.getChannelModerators().get(ind);
		List<String> listOwn = channel.getChannelOwners().get(ind);
		
		checkLists(ind);
		
		if(!channel.getChannelMembers().get(ind).contains(name)) {

			listMem.add(name);
			channel.setChannelMembers(listMem, ind);
			
		}
			
		if(!channel.getChannelModerators().get(ind).contains(name)) {
			
			listMod.add(name);
			channel.setChannelModerators(listMod, ind);
				
		}
			
		if(!channel.getChannelOwners().get(ind).contains(name)) {
			
			listMod.add(name);
			channel.setChannelOwners(listOwn, ind);
				
		}
		
	}
	
	/**
	 * Sets a player's membership status to member if they were previously a lower rank (not a member of the channel)
	 * 
	 * @param channel
	 * @param name
	 */
	public static void setMember(String channelname, String name) {
		
		int ind = channel.getChannelName().indexOf(channelname);
		List<String> listMem = channel.getChannelMembers().get(ind);
		
		checkLists(ind);
		
		if(!channel.getChannelOwners().get(ind).contains(name) && !channel.getChannelModerators().get(ind).contains(name) && !channel.getChannelMembers().get(ind).contains(name)) {
			
			listMem.add(name);
			channel.setChannelMembers(listMem, ind);
			
		}
		
	}
	
	/**
	 * Sets a player's membership status to moderator if they were previously a lower rank (either member rank within the channel or not a member of the channel)
	 * 
	 * @param channel
	 * @param name
	 */
	public static void setModerator(String channelname, String name) {
		
		int ind = channel.getChannelName().indexOf(channelname);
		List<String> listMem = channel.getChannelMembers().get(ind);
		List<String> listMod = channel.getChannelModerators().get(ind);
		
		checkLists(ind);
		
		if(!channel.getChannelOwners().get(ind).contains(name) && !channel.getChannelModerators().get(ind).contains(name)) {
			
			listMod.add(name);
			channel.setChannelModerators(listMod, ind);
			
			if(!channel.getChannelMembers().get(ind).contains(name)) {
				
				listMem.add(name);
				channel.setChannelMembers(listMem, ind);
				
			}
			
		}
		
	}
	
	/**
	 * Sets a player's membership status to owner if they were previously a lower rank (member or moderator rank within the channel or not a member of the channel)
	 * 
	 * @param channel
	 * @param name
	 */
	public static void setOwner(String channelname, String name) {
		
		int ind = channel.getChannelName().indexOf(channelname);
		List<String> listMem = channel.getChannelMembers().get(ind);
		List<String> listMod = channel.getChannelModerators().get(ind);
		List<String> listOwn = channel.getChannelOwners().get(ind);
		
		checkLists(ind);		
		
		if(!channel.getChannelOwners().get(ind).contains(name)) {
			
			listOwn.add(name);
			channel.setChannelOwners(listMod, ind);
			
			if(!channel.getChannelModerators().get(ind).contains(name)) {
				
				listMod.add(name);
				channel.setChannelModerators(listMod, ind);
			
				if(!channel.getChannelMembers().get(ind).contains(name)) {
				
					listMem.add(name);
					channel.setChannelMembers(listMem, ind);
				
				}
				
			}
			
		}
		
	}
	
	private static void checkLists(int index) {
		
		if(channel.getChannelMembers().get(index).contains("empty")) {
			
			List<String> list = channel.getChannelMembers().get(index);
			list.remove("empty");
			channel.setChannelMembers(list, index);			
			
		}
		
	}
	
}
