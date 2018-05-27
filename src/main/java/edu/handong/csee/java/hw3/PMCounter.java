package edu.handong.csee.java.hw3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;


public class PMCounter {
	static HashMap<String, CountInfo> countInfo = new HashMap<String,CountInfo>();
	public static HashMap<String, CountInfo> getCountInfo() {
		return countInfo;
	}

	RedundancyChecker re = new RedundancyChecker();
	
	int total = 0;
	int a=0;
	void countMessageNumber() {
		
		for(int j=0; j<re.getOneUser().size(); j++) {
			
			String name = re.getOneUser().get(j);
			
			CountInfo number = new CountInfo();
			countInfo.put(name, number);
			

			
			for(int i=0;i<re.getOneMessage().size();i++) {
				String line = re.getOneMessage().get(i);
				
				if(name.contains(")")) {
					if(line.contains(name))
						number.setNumber(number.getNumber()+1);
				}
				else if(line.matches(name+".+")) {
					number.setNumber(number.getNumber()+1);					
				}
			}
		    //System.out.println(name+" "+number.getNumber());
		}
		sortHashMap(countInfo);
		//printMap(countInfo);
		
	}

	private void sortHashMap(HashMap<String, CountInfo> countInfo2) {
		int i=0;
		int [] sortNumbers = new int[30];
		
		for(String keyName : countInfo2.keySet()) {
			CountInfo person = countInfo2.get(keyName);
			sortNumbers[i] = person.getNumber();
			i++;
			//System.out.println(keyName+" "+person.getNumber()+" "+person.getRank());
		}
		
		Arrays.parallelSort(sortNumbers);
		


		i = 0;
		for(String keyName : countInfo2.keySet()) {
			CountInfo person = countInfo2.get(keyName);
			for(int j=0; j<sortNumbers.length; j++) {
				if(sortNumbers[j]==person.getNumber())
					person.setRank(30-j);
			}
			System.out.println(keyName+" "+person.getRank()+" "+person.getNumber());
		}
		
	}

	private void printMap(HashMap<String, CountInfo> countInfo) {
		for(String keyName : countInfo.keySet()) {
			//Set<String> keyName = message2.keySet();
			CountInfo person = countInfo.get(keyName);
			System.out.println(keyName+" "+person.getNumber()+" "+person.getRank());
		}
		
	}

}
