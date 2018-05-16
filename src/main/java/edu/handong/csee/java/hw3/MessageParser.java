package edu.handong.csee.java.hw3;

import java.util.ArrayList;

public class MessageParser {
	
	ArrayList<String> saveOnlyMessage(ArrayList<String> fileLine, ArrayList<String> messageLine) {
		
		for(int i=0; i<fileLine.size(); i++) {
			String line = fileLine.get(i);
			if(line.matches("[")) {
				messageLine.add(line);
			}
		}
		
		return messageLine;
		
	}

}
