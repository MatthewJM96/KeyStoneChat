package com.github.samthepsychoticleprechaun.KeyStoneChat.API.Channels;

import java.util.Arrays;
import java.util.List;

import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.github.samthepsychoticleprechaun.KeyStoneChat.KeyStoneChat;
import com.github.samthepsychoticleprechaun.KeyStoneChat.API.Chat.SendMessage;
import com.github.samthepsychoticleprechaun.KeyStoneChat.Storage.ChannelValues;
import com.github.samthepsychoticleprechaun.KeyStoneCore.Storage.StringValues;

public class CreateChannel {
	
	public static void createChannel(String name, String creator) {
		
		KeyStoneChat plugin = KeyStoneChat.plugin;	
		SendMessage msg = new SendMessage();
		StringValues load = new StringValues();
		ChannelValues channel = new ChannelValues();	
		
		String success = load.getCreatedchannel();
		String failNameConflict = load.getFailedchannelcreate();
		
		Player p = plugin.getServer().getPlayer(creator);
		
		if(!channel.getChannelName().contains(name)) {
		
		channel.setChannelCount(channel.getChannelCount() + 1);
		channel.addChannelName(name);
		channel.addPassword("empty");
		channel.addHasPass(false);
		channel.addDescription("empty");
		channel.addHasDesc(false);
		SetMembership.forceOwner(name, creator);
		
		msg.sendMessage(success + name, p);
		
		} else {
			
			msg.sendMessage(failNameConflict, p);
			
		}
		
	}
	
	public static void createChannel(String name, CommandSender sender) {

		SendMessage msg = new SendMessage();
		StringValues load = new StringValues();
		ChannelValues channel = new ChannelValues();	
		
		String success = load.getCreatedchannel();
		String failNameConflict = load.getFailedchannelcreate();
		
		if(!channel.getChannelName().contains(name)) {
		
		String[] arrayOwners = new String[] {"empty"};
		List<String> listOwners = Arrays.asList(arrayOwners);
		String[] arrayModerators = new String[] {"empty"};
		List<String> listModerators = Arrays.asList(arrayModerators);
		String[] arrayMembers = new String[] {"empty"};
		List<String> listMembers = Arrays.asList(arrayMembers);
		
		channel.setChannelCount(channel.getChannelCount() + 1);
		channel.addChannelName(name);
		channel.addPassword("empty");
		channel.addHasPass(false);
		channel.addDescription("empty");
		channel.addHasDesc(false);
		channel.addChannelOwners(listOwners);
		channel.addChannelModerators(listModerators);
		channel.addChannelMembers(listMembers);
		
		msg.sendMessage(success + name, sender);
		
		} else {
		
			msg.sendMessage(failNameConflict, sender);
		
		}
		
	}

}
