package edu.handong.csee.java.hw3;

import java.util.ArrayList;

public class RedundancyChecker {
	
	ArrayList<String> removeRedundancy(ArrayList<String> MessageLine){
		
		for(int i=0; i<MessageLine.size()-1; i++) {
			String line1 = MessageLine.get(i);
			String line2 = MessageLine.get(i+1);
			
			if(line1.equals(line2)) {
				
			}
		}
		
		return MessageLine;
	}

}
