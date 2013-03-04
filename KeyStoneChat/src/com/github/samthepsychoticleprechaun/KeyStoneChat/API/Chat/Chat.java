package com.github.samthepsychoticleprechaun.KeyStoneChat.API.Chat;

public class Chat {
	
	public static String replaceFormatting(String message) {
		
		message = message.replaceAll("&m", "§k");
		message = message.replaceAll("&B", "§l");
		message = message.replaceAll("&s", "§m");
		message = message.replaceAll("&u", "§n");
		message = message.replaceAll("&i", "§o");
		message = message.replaceAll("&r", "§r");
		message = message.replaceAll("&", "§");
		
		return message;
		
	}

}
