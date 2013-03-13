package com.github.samthepsychoticleprechaun.KeyStoneChat.CommandHandler;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.github.samthepsychoticleprechaun.KeyStoneChat.API.Channels.CreateChannel;
import com.github.samthepsychoticleprechaun.KeyStoneChat.API.Chat.SendMessage;
import com.github.samthepsychoticleprechaun.KeyStoneChat.CommandHandler.Commands.RenameChannelCommand;
import com.github.samthepsychoticleprechaun.KeyStoneCore.Permissions.PermissionList;
import com.github.samthepsychoticleprechaun.KeyStoneCore.Storage.StringValues;

public class CommandHandler implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
		
		SendMessage msg = new SendMessage();
		PermissionList perm = new PermissionList();
		RenameChannelCommand rename = new RenameChannelCommand();
		StringValues load = new StringValues();
		
		Player p = (Player) sender;
		String noPermMsg = load.warnofnopermission;
		String missingArgsMsg = load.missingargcmd;
		String extraArgsMsg = load.extraargcmd;
		
		if(p.hasPermission(perm.basiccmdusage) || !(sender instanceof Player) || p.isOp()) {
			
			if (args[0].equalsIgnoreCase("cc") || args[0].equalsIgnoreCase("createchannel")) {
				
				if(p.hasPermission(perm.channelBasicCreate) || p.isOp()) {
				
					if (args.length == 1) {
					
						msg.sendMessage(missingArgsMsg + "&c /ks cc <Channel Name>", p);
					
					} else if (args.length == 2) {
				
						String name = p.getName();
						CreateChannel.createChannel(args[1], name);
				
					} else {
						
						msg.sendMessage(extraArgsMsg + "&c /ks cc <Channel Name>", p);
						
					}
				
				} else if (!(sender instanceof Player)) {
					
					if (args.length == 1) {
						
						msg.sendMessage(missingArgsMsg + "&c /ks cc <Channel Name>", sender);
						
					} else if (args.length == 2) {
						
						CreateChannel.createChannel(args[1], sender);
						
					} else {
						
						msg.sendMessage(extraArgsMsg + "&c /ks cc <Channel Name>", sender);
						
					}
					
				} else {
					
					msg.sendMessage(noPermMsg, p);
					
				}
				
			} else if (args[0].equalsIgnoreCase("rc") || args[0].equalsIgnoreCase("renamechannel")) {
				
				if (p.hasPermission(perm.channelBasicRename) || p.hasPermission(perm.channelAdminRename) || p.isOp()) {
					
					if (args.length <= 2) {
						
						msg.sendMessage(missingArgsMsg + "&c /ks rc <Channel Name> <New Channel Name>", p);
						
					} else if (args.length == 3) {
						
						rename.renameChannelCmd(args[1], args[2], p);
						
					} else {
						
						msg.sendMessage(extraArgsMsg + "&c /ks rc <Channel Name> <New Channel Name>", p);
						
					}
					
				} else if (!(sender instanceof Player)) {
					
					if (args.length <= 2) {
						
						msg.sendMessage(missingArgsMsg + "&c /ks rc <Channel Name> <New Channel Name>", sender);
						
					} else if (args.length == 3) {
						
						rename.renameChannelCmd(args[1], args[2], sender);
						
					} else {
						
						msg.sendMessage(extraArgsMsg + "&c /ks rc <Channel Name> <New Channel Name>", sender);
						
					}
					
				}
				
			}
			
		}
		
		return false;
		
	}
	
}
