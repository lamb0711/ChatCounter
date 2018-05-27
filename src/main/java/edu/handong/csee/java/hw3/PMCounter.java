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

		}
		sortHashMap(countInfo);

	}

	private void sortHashMap(HashMap<String, CountInfo> countInfo2) {
		int i=0;
		int [] sortNumbers = new int[re.getOneUser().size()];

		for(String keyName : countInfo2.keySet()) {
			CountInfo person = countInfo2.get(keyName);
			sortNumbers[i] = person.getNumber();
			i++;
		}

		Arrays.parallelSort(sortNumbers);

		i =0;
		for(String keyName : countInfo2.keySet()) {
			CountInfo person = countInfo2.get(keyName);
			for(int j=0; j<re.getOneUser().size(); j++) {
				if(sortNumbers[j]==person.getNumber())
					person.setRank(29-j);
			}
		}

	}


}
