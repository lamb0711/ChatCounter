package edu.handong.csee.java.hw3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class PMCounter {
	static HashMap<String,ArrayList<Message>> message = new HashMap<String,ArrayList<Message>>();
	RedundancyChecker re = new RedundancyChecker();
	
	int total = 0;
	
	void countMessageNumber() {
		for(int j=0; j<re.getOneUser().size(); j++) {
			
			String name = re.getOneUser().get(j);
			message.put(name, new ArrayList<Message>());
			Message number = new Message();
			
			for(int i=0;i<re.getOneMessage().size();i++) {
				String line = re.getOneMessage().get(i);
				
				if(name.contains(")")) {
					String shortName = name.substring(0, 2);
					if(line.matches(shortName+".+")) {
						number.setNumber(number.getNumber()+1);
					}
				}
				else if(line.matches(name+".+")) {
					number.setNumber(number.getNumber()+1);
				}
			}
			System.out.println(name+" "+number.getNumber());
		}
		//printMap(message);
		
	}

	private void printMap(HashMap<String, ArrayList<Message>> message2) {
		
		for(int i=0; i<re.getOneUser().size(); i++) {
			Set<String> keyName = message2.keySet();
			ArrayList<Message> person = message2.get(keyName);
			System.out.println(keyName+" "+person.get(i).getNumber());
			
		}
		
	}

}
