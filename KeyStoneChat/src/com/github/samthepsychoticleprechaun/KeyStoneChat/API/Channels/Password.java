package com.github.samthepsychoticleprechaun.KeyStoneChat.API.Channels;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.entity.Player;

import com.github.samthepsychoticleprechaun.KeyStoneChat.KeyStoneChat;
import com.github.samthepsychoticleprechaun.KeyStoneChat.API.Chat.SendMessage;
import com.github.samthepsychoticleprechaun.KeyStoneChat.Storage.ChannelValues;
import com.github.samthepsychoticleprechaun.KeyStoneCore.API.General.TimeParser;
import com.github.samthepsychoticleprechaun.KeyStoneCore.Storage.StringValues;

public class Password {
	
	ChannelValues channel = new ChannelValues();
	KeyStoneChat plugin = KeyStoneChat.plugin;
	
	public static List<String> playerNameList;
	public static List<String> passwordList;
	public static List<String> dateList;
	public static List<String> channelNameList;
	
	/**
	 * Changes the given channel's password to the given password if the channel does not have one
	 * else a confirmation message is sent to the player to confirm the change
	 * 
	 * @param channelName
	 * @param password
	 * @param playerName
	 */
	public void setPassword(String channelName, String password, String playerName) {
		
		int ind = channel.getChannelName().indexOf(channelName);
		
		if(!channel.getHasPass().get(ind)) {
			
			Player p = plugin.getServer().getPlayer(playerName);
			String success = StringValues.createdpassword;
			
			channel.setPassword(password, ind);
			channel.setHasPass(true, ind);
			SendMessage.sendMessage(success, p);
			
		} else {
			
			Player p = plugin.getServer().getPlayer(playerName);			
			String confirm = StringValues.confirmpassword;
			
			playerNameList.add(playerName);
			passwordList.add(password);
			dateList.add(TimeParser.getSystDate());
			channelNameList.add(channelName);
			SendMessage.sendMessage(confirm, p);
			
		}
	
	}
	
	/**
	 * Updates a channel's password upon confirmation from the player requesting the change
	 * 
	 * @param playerName
	 */
	public void onConfirm(String playerName) {
		
		int ind = playerNameList.indexOf(playerName);
		
		Player p = plugin.getServer().getPlayer(playerName);
		String success = StringValues.updatedpassword;
		
		String password = passwordList.get(ind);
		List<String> partialList;
		List<Integer> inds = new ArrayList<Integer>();
		 
		channel.setPassword(password, ind);
		channel.setHasPass(true, ind);
		
		partialList = playerNameList.subList(0, ind);
		for(int x = 0; x < partialList.size(); x++) {
			partialList.remove(x);
			inds.add(x);
		}
		playerNameList.subList(0, ind).clear();
		playerNameList.addAll(0, partialList);
		for(int x = 0; x < inds.size(); x++) {
			passwordList.remove(x);
			dateList.remove(x);
			channelNameList.remove(x);
		}
		SendMessage.sendMessage(success, p);
		
	}

}
