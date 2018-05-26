package edu.handong.csee.java.hw3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.TreeSet;

public class RedundancyChecker {
	MessageDivider di = new MessageDivider();
	
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
		
		/*for(int i=0; i < oneMessage1.size()-1;i++) {
			
			if(oneMessage1.get(i).length()>50)
			line = oneMessage1.get(i).substring(1, 40);
			
			if(oneMessage1.get(i+1).equals(line)) {
				continue;
			}
			oneMessage.add(oneMessage1.get(i));
		}*/
		
		for(int i=0;i<oneMessage.size();i++) {
			System.out.println(i+" "+oneMessage.get(i));
		}
		
	}
	

}
