package com.github.samthepsychoticleprechaun.KeyStoneChat.API.Channels;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.command.CommandSender;
import com.github.samthepsychoticleprechaun.KeyStoneChat.KeyStoneChat;
import com.github.samthepsychoticleprechaun.KeyStoneChat.API.Chat.SendMessage;
import com.github.samthepsychoticleprechaun.KeyStoneChat.Storage.ChannelValues;
import com.github.samthepsychoticleprechaun.KeyStoneCore.API.General.TimeParser;
import com.github.samthepsychoticleprechaun.KeyStoneCore.Storage.StringValues;

public class Password {
	
	public Password() {
		return;
	}
	
	ChannelValues channel = new ChannelValues();
	KeyStoneChat plugin = KeyStoneChat.plugin;
	StringValues load = new StringValues();
	SendMessage msg = new SendMessage();
	TimeParser time = new TimeParser();
	
	public static List<CommandSender> senderList;
	public static List<String> passwordList;
	public static List<String> dateList;
	public static List<String> channelNameList;
	
	/**
	 * Changes the given channel's password to the given password if the channel does not have one
	 * else a confirmation message is sent to the player to confirm the change.
	 * 
	 * @param channelName
	 * @param password
	 * @param playerName
	 */
	public void setPassword(String channelName, String password, CommandSender sender) {
		
		int ind = channel.getChannelName().indexOf(channelName);
		
		if(!channel.getHasPass().get(ind)) {
			
			String success = load.getCreatedpassword();
			
			channel.setPassword(password, ind);
			channel.setHasPass(true, ind);
			msg.sendMessage(success, sender);
			
		} else {
						
			String confirm = load.getConfirmpassword();
			
			senderList.add(sender);
			passwordList.add(password);
			dateList.add(time.getSystDate());
			channelNameList.add(channelName);
			msg.sendMessage(confirm, sender);
			
		}
	
	}
	
	/**
	 * Updates a channel's password upon confirmation from the player requesting the change
	 * 
	 * @param playerName
	 */
	public void onConfirm(CommandSender sender) {
		
		int ind = senderList.indexOf(sender);
		
		String success = load.getUpdatedpassword();
		
		String password = passwordList.get(ind);
		List<CommandSender> partialList;
		List<Integer> inds = new ArrayList<Integer>();
		 
		channel.setPassword(password, ind);
		channel.setHasPass(true, ind);
		
		partialList = senderList.subList(0, ind);
		for(int x = 0; x < partialList.size(); x++) {
			if(partialList.get(x) == sender) {
				partialList.remove(x);
				inds.add(x);
			}
		}
		senderList.subList(0, ind).clear();
		senderList.addAll(0, partialList);
		for(int x = 0; x < inds.size(); x++) {
			passwordList.remove(inds.get(x));
			dateList.remove(inds.get(x));
			channelNameList.remove(inds.get(x));
		}
		msg.sendMessage(success, sender);
		
	}
	
	public void onDeny(CommandSender sender) {
		
		int ind = senderList.indexOf(sender);
		
		String denied = load.getDeniedpassword();
		
		List<CommandSender> partialList;
		List<Integer> inds = new ArrayList<Integer>();
		
		partialList = senderList.subList(0, ind);
		for(int x = 0; x < partialList.size(); x++) {
			if(partialList.get(x) == sender) {
				partialList.remove(x);
				inds.add(x);
			}
		}
		senderList.subList(0, ind).clear();
		senderList.addAll(0, partialList);
		for(int x = 0; x < inds.size(); x++) {
			passwordList.remove(inds.get(x));
			dateList.remove(inds.get(x));
			channelNameList.remove(inds.get(x));
		}
		msg.sendMessage(denied, sender);
		
		
	}

}
