package edu.handong.csee.java.hw3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.TreeSet;

public class HashMapMaker {
	MessageDivider di = new MessageDivider();
	static HashMap<String,ArrayList<String>> message = new HashMap<String,ArrayList<String>>();
	
	void saveOnlyOneUser() {
		ArrayList<String> allUser = new ArrayList<String>();
		
		for(int i=0; i<di.getUser().size();i++) {
			allUser.add(di.getUser().get(i));
		}
		for(int i=0; i<di.getUserMac().size();i++) {
			allUser.addAll(di.getUserMac());
		}
		
		TreeSet<String> user = new TreeSet<String>(allUser);
		ArrayList<String> oneUser = new ArrayList<String>(user);
		
		for(int i=0;i<oneUser.size();i++) {
			System.out.println(i+" "+oneUser.get(i));
		}
	}
	
	void removeRedundancy() {
		ArrayList<String> allMessage = new ArrayList<String>();
		
		for(int i=0; i<di.getChatMessageMac().size();i++) {
			allMessage.add(di.getChatMessageMac().get(i));
		}
		for(int i=0; i<di.getChatMessageWin().size();i++) {
			allMessage.add(di.getChatMessageWin().get(i));
		}
		TreeSet<String> message = new TreeSet<String>(allMessage);
		ArrayList<String> oneMessage = new ArrayList<String>(message);
		
		for(int i=0;i<oneMessage.size();i++) {
			System.out.println(i+" "+oneMessage.get(i));
		}
		
	}

 
}
