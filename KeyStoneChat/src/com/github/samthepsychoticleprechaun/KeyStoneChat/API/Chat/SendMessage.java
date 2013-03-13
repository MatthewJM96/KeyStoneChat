package com.github.samthepsychoticleprechaun.KeyStoneChat.API.Chat;

import java.util.Arrays;
import java.util.List;

import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class SendMessage {
	
	public SendMessage() {
		return;
	}
	
	public void sendMessage(String message, Player[] targets) {
		
		String msg = Chat.replaceFormatting(message);
		List<Player> list = Arrays.asList(targets);
		
		for(int x = 0; x < list.size(); x++) {
			
			list.get(x).sendMessage(msg);
			
		}
		
	}
	
	public void sendMessage(String message, Player target) {
		
		String msg = Chat.replaceFormatting(message);
		
		target.sendMessage(msg);
		
	}

	public void sendMessage(String message, CommandSender target) {

		String msg = Chat.replaceFormatting(message);
		
		target.sendMessage(msg);
		
	}

}
