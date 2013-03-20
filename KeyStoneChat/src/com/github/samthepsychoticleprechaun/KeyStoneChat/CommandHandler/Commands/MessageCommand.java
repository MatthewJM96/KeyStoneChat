package com.github.samthepsychoticleprechaun.KeyStoneChat.CommandHandler.Commands;

import java.util.List;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;

import org.bukkit.entity.Player;

import com.github.samthepsychoticleprechaun.KeyStoneChat.KeyStoneChat;
import com.github.samthepsychoticleprechaun.KeyStoneChat.API.Chat.SendMessage;
import com.github.samthepsychoticleprechaun.KeyStoneCore.Storage.StringValues;

public class MessageCommand {
	
	KeyStoneChat plugin = KeyStoneChat.plugin;
	SendMessage msg = new SendMessage();
	StringValues load = new StringValues();

	public MessageCommand() {
		return;
	}
	
	HashMap<String, String> messageHistory = new HashMap<String, String>();
	
	public void messageCmd (Player sender, String recipient, String message) {
		
		List<Player> players = Arrays.asList(plugin.getServer().getOnlinePlayers());
		List<String> names = null;
		
		String notOnline = load.getNotonline();
		
		Iterator<Player> i = players.iterator();
		
		while (i.hasNext()) {
			
			names.add(i.next().getName());
			
		}
		
		if (names.contains(recipient)) {
		
		String toSender = "&8You: &f" + message;
		String toRecipient = "&8" + recipient + ": &f" + message;
		
		messageHistory.put(recipient, sender.getName());
		messageHistory.put(sender.getName(), recipient);
		
		msg.sendMessage(toSender, sender);
		msg.sendMessage(toRecipient, plugin.getServer().getPlayer(recipient));
		
		} else {
			
			String toSender = recipient + notOnline;
			
			msg.sendMessage(toSender, sender);
			
		}
		
	}
	
	public void replyCmd (Player sender, String message) {
				
		List<Player> players = Arrays.asList(plugin.getServer().getOnlinePlayers());
		List<String> names = null;
		
		String notOnline = load.getNotonline();
		
		Iterator<Player> i = players.iterator();
		
		while (i.hasNext()) {
			
			names.add(i.next().getName());
			
		}
		
		if (names.contains(messageHistory.get(sender.getName()))) {
		
		Player recipient = plugin.getServer().getPlayer(messageHistory.get(sender.getName()));

		String toSender = "&8You: &f" + message;
		String toRecipient = "&8" + recipient.getName() + ": &f" + message;
		
		msg.sendMessage(toSender, sender);
		msg.sendMessage(toRecipient, recipient);
		
		} else{
		
			String toSender = messageHistory.get(sender.getName()) + notOnline;
			
			msg.sendMessage(toSender, sender);
			
		}
		
	}
	
}
