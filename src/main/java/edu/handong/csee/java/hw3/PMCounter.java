package edu.handong.csee.java.hw3;

import java.util.ArrayList;
import java.util.HashMap;

public class PMCounter {
	static HashMap<String,ArrayList<Message>> message = new HashMap<String,ArrayList<Message>>();
	RedundancyChecker re = new RedundancyChecker();
	
	void countMessageNumber() {
		for(int i=0;i<re.getOneUser().size();i++) {
			System.out.println(i+" "+re.getOneUser().get(i));
		}
	}

}
