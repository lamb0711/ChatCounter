package edu.handong.csee.java.hw3;

import java.util.ArrayList;

public class MessageParser {
	FileLoader fi = new FileLoader();
	private String line;
	
	ArrayList<String> fileLineMac = new ArrayList<String>();
	static ArrayList<String> messageLineMac = new ArrayList<String>();
	
	public static ArrayList<String> getMessageLineMac() {
		return messageLineMac;
	}

	public static void setMessageLineMac(ArrayList<String> messageLineMac) {
		MessageParser.messageLineMac = messageLineMac;
	}

	void saveOnlyMessageMac() {
		
		fileLineMac = fi.getFileLineMac();
		
		line = "";
		for(int i=1; i<fileLineMac.size()-1; i++) {
			line = line.concat(fileLineMac.get(i));
			if(fileLineMac.get(i+1).matches("2018-.*")) line = line.concat("]]]");
		}
		
		String[] tempStr = line.split("]]]"); 
		for (int i = 0; i < tempStr.length; i++) { 
		      messageLineMac.add(tempStr[i]); 
		}
		if(fileLineMac.get(fileLineMac.size()-1).matches("2018-.*"))
		messageLineMac.add(fileLineMac.get(fileLineMac.size()-1));
		
		System.out.println("");
		for(int i=0; i<messageLineMac.size(); i++) {
			System.out.println(messageLineMac.get(i));
		}
	}

}
