package com.github.samthepsychoticleprechaun.KeyStoneChat.CommandHandler;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.github.samthepsychoticleprechaun.KeyStoneChat.API.Channels.CreateChannel;
import com.github.samthepsychoticleprechaun.KeyStoneChat.API.Chat.SendMessage;
import com.github.samthepsychoticleprechaun.KeyStoneChat.CommandHandler.Commands.MessageCommand;
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
		MessageCommand msgcom = new MessageCommand();
		
		Player p = (Player) sender;
		String noPermMsg = load.getWarnofnopermission();
		String missingArgsMsg = load.getMissingargcmd();
		String extraArgsMsg = load.getExtraargcmd();
		
		if(p.hasPermission(perm.getBasiccmdusage()) || !(sender instanceof Player) || p.isOp()) {
			
			if (args[0].equalsIgnoreCase("cc") || args[0].equalsIgnoreCase("createchannel")) {
				
				if(p.hasPermission(perm.getChannelBasicCreate()) || p.isOp()) {
				
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
				
				if (p.hasPermission(perm.getChannelBasicRename()) || p.hasPermission(perm.getChannelAdminRename()) || p.isOp()) {
					
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
				
			} else if (args[0].equalsIgnoreCase("privatemessage") || args[0].equalsIgnoreCase("pm")) {
				
				if (args.length <= 2) {
					
					
					
				} else {
					
					String message = "";
					List<String> words = Arrays.asList(args);
					Iterator<String> i = words.iterator();
					
					while (i.hasNext()) {
						
						String word = i.next();
						message = message + word;	
						i.remove();
						
					}
					
					msgcom.messageCmd(p, args[1], message);
					
				} 
				
			} else if (args[0].equalsIgnoreCase("reply") || args[0].equalsIgnoreCase("r")) {
				
				String message = "";
				List<String> words = Arrays.asList(args);
				Iterator<String> i = words.iterator();
				
				while (i.hasNext()) {
					
					String word = i.next();
					message = message + word;
					i.remove();
					
				}
				
				msgcom.replyCmd(p, message);
				
			}
			
		}
		
		return false;
		
	}
	
}
