package edu.handong.csee.java.hw3;

import java.util.ArrayList;

public class RedundancyChecker {
	
	ArrayList<String> removeRedundancy(ArrayList<String> messageLine,ArrayList<String> message){
		
		for(int i=0; i<messageLine.size()-1; i++) {
			String line1 = messageLine.get(i);
			String line2 = messageLine.get(i+1);
			
			if(line1.equals(line2)) {
				message.add(line1);
				continue;
			}
			message.add(line1);
			
		}
		
		return message;
	}

}
