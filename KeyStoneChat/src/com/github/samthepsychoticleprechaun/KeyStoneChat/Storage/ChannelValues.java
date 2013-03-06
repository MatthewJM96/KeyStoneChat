package com.github.samthepsychoticleprechaun.KeyStoneChat.Storage;

import java.util.List;

public class ChannelValues {
	
	private int channelcount;
	private List<String> channelName;
	private List<String> password;
	private List<Boolean> hasPass;
	private List<String> description;
	private List<Boolean> hasDesc;
	private List<List<String>> channelOwners;
	private List<List<String>> channelModerators;
	private List<List<String>> channelMembers;
	
	public ChannelValues() {
		return;
	}
	
	//Set each value in ChannelValues
	
	public void setChannelCount(int count) {
		this.channelcount = count;
	}
	
	public void setChannelName(String name, int index) {
		this.channelName.set(index, name);
	}
	
	public void setPassword(String password, int index) {
		this.password.set(index, password);
	}
	
	public void setHasPass(boolean state, int index) {
		this.hasPass.set(index, state);
	}
	
	public void setDescription(String desc, int index) {
		this.description.set(index, desc);
	}
	
	public void setHasDesc(boolean state, int index) {
		this.hasDesc.set(index, state);
	}
	
	public void setChannelOwners(List<String> owners, int index) {
		this.channelOwners.set(index, owners);
	}
	
	public void setChannelModerators(List<String> moderators, int index) {
		this.channelModerators.set(index, moderators);
	}
	
	public void setChannelMembers(List<String> members, int index) {
		this.channelMembers.set(index, members);
	}
	
	
	//Get each value in ChannelValues	
	
	public int getChannelCount() {
		return this.channelcount;
	}
	
	public List<String> getChannelName() {
		return this.channelName;
	}
	
	public List<String> getPassword() {
		return this.password;
	}
	
	public List<Boolean> getHasPass() {
		return this.hasPass;
	}
	
	public List<String> getDescription() {
		return this.description;
	}
	
	public List<Boolean> getHasDesc() {
		return this.hasDesc;
	}
	
	public List<List<String>> getChannelOwners() {
		return this.channelOwners;
	}
	
	public List<List<String>> getChannelModerators() {
		return this.channelModerators;
	}
	
	public List<List<String>> getChannelMembers() {
		return this.channelMembers;
	}
	
	
	//Add value to each value in ChannelValues
	
	public void addChannelName(String name) {
		this.channelName.add(name);
	}
	
	public void addPassword(String password) {
		this.password.add(password);
	}
	
	public void addHasPass(boolean state) {
		this.hasPass.add(state);
	}
	
	public void addDescription(String desc) {
		this.description.add(desc);
	}
	
	public void addHasDesc(boolean state) {
		this.hasDesc.add(state);
	}
	
	public void addChannelOwners(List<String> owners) {
		this.channelOwners.add(owners);
	}
	
	public void addChannelModerators(List<String> moderators) {
		this.channelModerators.add(moderators);
	}
	
	public void addChannelMembers(List<String> members) {
		this.channelMembers.add(members);
	}

}
