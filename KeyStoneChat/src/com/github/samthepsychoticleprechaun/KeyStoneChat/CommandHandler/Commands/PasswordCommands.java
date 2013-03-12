package com.github.samthepsychoticleprechaun.KeyStoneChat.CommandHandler.Commands;

import org.bukkit.command.CommandSender;

import com.github.samthepsychoticleprechaun.KeyStoneChat.API.Channels.Password;

public class PasswordCommands {
	
	Password pass = new Password();
	
	/**
	 * Sets the password of the given channel and tells the sender on success.
	 * 
	 * @param sender - Command Sender
	 * @param channelName - Name of Channel
	 * @param password - New Password
	 * @return Boolean of true on success.
	 */
	public boolean passwordCmd(CommandSender sender, String channelName, String password) {
		
		pass.setPassword(channelName, password, sender);
		return true;
		
	}
	
	/**
	 * Changes the original password of the sender's chosen channel to the new
	 * password chosen by the sender.
	 * 
	 * @param sender - Command Sender
	 * @return Boolean of true on success.
	 */
	public boolean confirmCmd(CommandSender sender) {
		
		pass.onConfirm(sender);
		return true;
		
	}
	
	/**
	 * Removes all confirmation requests for the sender.
	 * 
	 * @param sender - Command Sender
	 * @return Boolean of true on success.
	 */
	public boolean denyCmd(CommandSender sender) {
		
		pass.onDeny(sender);
		return true;
		
	}

}
