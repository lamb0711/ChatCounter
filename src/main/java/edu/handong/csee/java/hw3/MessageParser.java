package edu.handong.csee.java.hw3;

import java.util.ArrayList;

public class MessageParser {
	
	private String line;
	ArrayList<String> saveOnlyMessage(ArrayList<String> fileLine, ArrayList<String> messageLine) {
		
		for(int i=0; i<fileLine.size(); i++) {
			String line = fileLine.get(i);
			if(line.matches("\\[.*")) {
				messageLine.add(line);
			}
		}
		
		for(int i=0; i<messageLine.size(); i++) {
			System.out.println(messageLine.get(i));
		}
		
		return messageLine;
		
	}
	ArrayList<String> saveOnlyMessageMac(ArrayList<String> fileLineMac, ArrayList<String> messageLineMac) {
		line = "";
		for(int i=1; i<fileLineMac.size()-1; i++) {
			line = line.concat(fileLineMac.get(i));
			if(fileLineMac.get(i+1).matches("2018-.*")) line = line.concat("]]");
		}
		
		//System.out.println(line);
		
		String[] tempStr = line.split("]]"); 
		for (int i = 0; i < tempStr.length; i++) { 
		      messageLineMac.add(tempStr[i]); 
		}
		if(fileLineMac.get(fileLineMac.size()-1).matches("2018-.*"))
		messageLineMac.add(fileLineMac.get(fileLineMac.size()-1));
		
		System.out.println("");
		for(int i=0; i<messageLineMac.size(); i++) {
			System.out.println(messageLineMac.get(i));
		}
		return messageLineMac;
	}

}
