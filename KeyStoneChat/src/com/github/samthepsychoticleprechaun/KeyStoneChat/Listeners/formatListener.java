package com.github.samthepsychoticleprechaun.KeyStoneChat.Listeners;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

import com.github.samthepsychoticleprechaun.KeyStoneChat.API.Chat.Chat;

public class formatListener implements Listener {
	
	@EventHandler (priority = EventPriority.HIGHEST)
	public void onChatListener(AsyncPlayerChatEvent e) {
		
		List<Player> playerList = new ArrayList<Player>(e.getRecipients());
		
		if(!e.isCancelled()) {
			
			String msg = e.getMessage();
			String newMsg = Chat.replaceFormatting(msg);
		
			e.setCancelled(true);
			
			for(int x = 0; x < playerList.size(); x++ ) {
			
				Player p = playerList.get(x);
				p.sendMessage(newMsg);
			
			}
		
		}
		
	}

}
