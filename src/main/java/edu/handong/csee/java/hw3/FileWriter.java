package edu.handong.csee.java.hw3;

import java.io.FileNotFoundException;
import java.io.PrintWriter;



public class FileWriter {
	PMCounter pc = new PMCounter();
	RedundancyChecker re = new RedundancyChecker();
	
	public void saveInCsvFile() {
		String fileName = "out.csv";
		PrintWriter outputStream = null;
		
		try {
			outputStream = new PrintWriter(fileName);
		}catch(FileNotFoundException e) {
			System.out.println("Error opening the file "+fileName);
			System.exit(0);
		}

		outputStream.println("kakao_id,count");
		
		for(int i = 1; i<31; i++) {
			
			for(String keyName : pc.getCountInfo().keySet()) {
				
				CountInfo person = pc.getCountInfo().get(keyName);
				
				if(i==person.getRank()) {
					outputStream.println(keyName+","+person.getNumber());
					continue;
				}
			}
			
			
		}
		
		outputStream.close();

	}

}
