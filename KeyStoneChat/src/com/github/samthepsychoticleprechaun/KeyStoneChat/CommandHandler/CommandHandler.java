package com.github.samthepsychoticleprechaun.KeyStoneChat.CommandHandler;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.github.samthepsychoticleprechaun.KeyStoneChat.API.Channels.CreateChannel;
import com.github.samthepsychoticleprechaun.KeyStoneChat.API.Chat.SendMessage;
import com.github.samthepsychoticleprechaun.KeyStoneCore.Permissions.PermissionList;
import com.github.samthepsychoticleprechaun.KeyStoneCore.Storage.StringValues;

public class CommandHandler implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
		
		Player p = (Player) sender;
		String noPermMsg = StringValues.warnofnopermission;
		String missingArgsMsg = StringValues.missingargcmd;
		String extraArgsMsg = StringValues.extraargcmd;
		
		if(p.hasPermission(PermissionList.basiccmdusage) || !(sender instanceof Player) || p.isOp()) {
			
			if (args[0].equalsIgnoreCase("cc")) {
				
				if(p.hasPermission(PermissionList.channelBasicCreate) || p.isOp()) {
				
					if (args.length == 1) {
					
						SendMessage.sendMessage(missingArgsMsg + "&c /ks cc <Channel Name>", p);
					
					} else if (args.length == 2) {
				
						String name = p.getName();
						CreateChannel.createChannel(args[1], name);
				
					} else {
						
						SendMessage.sendMessage(extraArgsMsg + "&c /ks cc <Channel Name>", p);
						
					}
				
				} else if (!(sender instanceof Player)) {
					
					if (args.length == 1) {
						
						SendMessage.sendMessage(missingArgsMsg + "&c", sender);
						
					} else if (args.length == 2) {
						
						CreateChannel.createChannel(args[1], sender);
						
					} else {
						
						SendMessage.sendMessage(extraArgsMsg + "&c /ks cc <Channel Name>", sender);
						
					}
					
				} else {
					
					SendMessage.sendMessage(noPermMsg, p);
					
				}
				
			}
			
		}
		
		return false;
		
	}
	
}
