package com.github.samthepsychoticleprechaun.KeyStoneChat.CommandHandler.Commands;

import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.github.samthepsychoticleprechaun.KeyStoneChat.API.Channels.CheckMembership;
import com.github.samthepsychoticleprechaun.KeyStoneChat.API.Channels.RenameChannel;
import com.github.samthepsychoticleprechaun.KeyStoneChat.API.Chat.SendMessage;
import com.github.samthepsychoticleprechaun.KeyStoneCore.Permissions.PermissionList;
import com.github.samthepsychoticleprechaun.KeyStoneCore.Storage.StringValues;

public class RenameChannelCommand {

	RenameChannel rename = new RenameChannel();
	StringValues load = new StringValues();
	SendMessage msg = new SendMessage();
	CheckMembership check = new CheckMembership();
	PermissionList perm = new PermissionList();
	
	public RenameChannelCommand() {
		return;
	}
	
	String renameChannelMsg = load.getRenamechannel();
	String noPermMsg = load.getWarnofnopermission();
	String noOwnModMsg = load.getRenamedisallowed();
	
	public void renameChannelCmd(String channelName, String newName, Player player) {
		
		if (check.checkModerator(channelName, player.getName()) || check.checkOwner(channelName, player.getName()) || player.hasPermission(perm.getChannelAdminRename())) {
		
		rename.renameChannel(channelName, newName);
		
		msg.sendMessage(renameChannelMsg + channelName, player);
		
		} else {
			
			msg.sendMessage(noPermMsg + "\n" + noOwnModMsg, player);
			
		}
		
	}
	
	public void renameChannelCmd(String channelName, String newName, CommandSender sender) {
		
		rename.renameChannel(channelName, newName);
		
		msg.sendMessage(renameChannelMsg + channelName, sender);
		
	}
	
}
