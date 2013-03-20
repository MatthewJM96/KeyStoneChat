package com.github.samthepsychoticleprechaun.KeyStoneChat.Listeners;

import java.util.Iterator;
import java.util.Set;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

import com.github.samthepsychoticleprechaun.KeyStoneChat.API.Chat.SendMessage;
import com.github.samthepsychoticleprechaun.KeyStoneCore.BuddySystem.BuddySystem;

public class recipientsListeners implements Listener {

	BuddySystem buddy = new BuddySystem();
	SendMessage msg = new SendMessage();
	
	@EventHandler (priority = EventPriority.LOWEST) 
	public void buddyRecipientListener(AsyncPlayerChatEvent e) {
		
		e.setCancelled(true);
		
		Set<Player> recipients = e.getRecipients();
		String message = e.getMessage();
		String tempMsg;
		
		Iterator<Player> i = recipients.iterator();
		
		while (i.hasNext()) {
			
			Player p = i.next();
			
			if (buddy.getIgnoreList().get(p.getName()).contains(e.getPlayer().getName())) {
				
				recipients.remove(p);
				
			} else if (buddy.getFriendList().get(p.getName()).contains(e.getPlayer().getName())) {
				
				recipients.remove(p);
				tempMsg = "&2" + message;
				msg.sendMessage(tempMsg, p);
				
			} else if (buddy.getEnemyList().get(p.getName()).contains(e.getPlayer().getName())) {
				
				recipients.remove(p);
				tempMsg = "&4" + message;
				msg.sendMessage(tempMsg, p);
				
			}
			
			i.remove();
			
		}
		
		Player[] newrecipients = (Player[]) recipients.toArray();
		msg.sendMessage(message, newrecipients);
		
	}
	
}
