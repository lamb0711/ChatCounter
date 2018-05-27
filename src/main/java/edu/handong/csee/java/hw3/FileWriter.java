package edu.handong.csee.java.hw3;

import java.io.FileNotFoundException;
import java.io.PrintWriter;



public class FileWriter {
	PMCounter pc = new PMCounter();
	
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
		for(String keyName : pc.getCountInfo().keySet()) {
			CountInfo person = pc.getCountInfo().get(keyName);
			for(int i = 1; i < 30; i++) {
				
			}
			outputStream.println(keyName+",  "+pc.getCountInfo())
			//System.out.println(keyName+" "+person.getNumber()+" "+person.getRank());
		}
		
	}

}
