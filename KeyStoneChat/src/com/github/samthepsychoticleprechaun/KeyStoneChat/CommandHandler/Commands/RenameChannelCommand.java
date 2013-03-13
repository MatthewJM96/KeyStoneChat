package com.github.samthepsychoticleprechaun.KeyStoneChat.CommandHandler.Commands;

import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.github.samthepsychoticleprechaun.KeyStoneChat.API.Channels.RenameChannel;
import com.github.samthepsychoticleprechaun.KeyStoneChat.API.Chat.SendMessage;
import com.github.samthepsychoticleprechaun.KeyStoneCore.Storage.StringValues;

public class RenameChannelCommand {

	RenameChannel rename = new RenameChannel();
	StringValues load = new StringValues();
	SendMessage msg = new SendMessage();
	
	public RenameChannelCommand() {
		return;
	}
	
	String renameChannelMsg = load.renamechannel;
	
	public void renameChannelCmd(String channelName, String newName, Player player) {
		
		rename.renameChannel(channelName, newName);
		
		msg.sendMessage(renameChannelMsg + channelName, player);
		
	}
	
	public void renameChannelCmd(String channelName, String newName, CommandSender sender) {
		
		rename.renameChannel(channelName, newName);
		
		msg.sendMessage(renameChannelMsg + channelName, sender);
		
	}
	
}
