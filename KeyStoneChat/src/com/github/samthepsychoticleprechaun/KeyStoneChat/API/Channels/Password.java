package com.github.samthepsychoticleprechaun.KeyStoneChat.API.Channels;

import java.util.ArrayList;
import java.util.List;

import com.github.samthepsychoticleprechaun.KeyStoneChat.Storage.ChannelValues;
import com.github.samthepsychoticleprechaun.KeyStoneCore.API.General.TimeParser;

public class Password {
	
	ChannelValues channel = new ChannelValues();
	
	public static List<String> playerNameList;
	public static List<String> passwordList;
	public static List<String> dateList;
	public static List<String> channelNameList;
	
	public void setPassword(String channelName, String password, String playerName) {
		
		int ind = channel.getChannelName().indexOf(channelName);
		
		if(!channel.getHasPass().get(ind)) {
			
			channel.setPassword(password, ind);
			channel.setHasPass(true, ind);
			
		} else {
			
			playerNameList.add(playerName);
			passwordList.add(password);
			dateList.add(TimeParser.getSystDate());
			channelNameList.add(channelName);
			
		}
	
	}
	
	//Called by command "/ks confirm"
	public void onConfirm(String playerName) {
		
		int ind = playerNameList.indexOf(playerName);
		
		String password = passwordList.get(ind);
		List<String> partialList;
		List<Integer> inds = new ArrayList<Integer>();
		 
		channel.setPassword(password, ind);
		channel.setHasPass(true, ind);
		
		partialList = playerNameList.subList(0, ind);
		for(int x = 0; x < partialList.size(); x++) {
			partialList.remove(x);
			inds.add(x);
		}
		playerNameList.subList(0, ind).clear();
		playerNameList.addAll(0, partialList);
		for(int x = 0; x < inds.size(); x++) {
			passwordList.remove(x);
			dateList.remove(x);
			channelNameList.remove(x);
		}
		
	}

}
