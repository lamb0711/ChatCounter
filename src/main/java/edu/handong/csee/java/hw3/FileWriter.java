package edu.handong.csee.java.hw3;

import java.io.FileNotFoundException;
import java.io.PrintWriter;

/**
 * FileWriter class is save result data in csv file.
 * @author yangsujin
 *
 */

public class FileWriter {
	PMCounter pc = new PMCounter();
	RedundancyChecker re = new RedundancyChecker();

	/**
	 * saveInCsvFile method is save result data in csv file in descending order
	 */

	public void saveInCsvFile(String output) {
		String fileName = output;
		PrintWriter outputStream = null;

		try {
			outputStream = new PrintWriter(fileName);
		}catch(FileNotFoundException e) {
			System.out.println("Error opening the file "+fileName);
			System.exit(0);
		}

		outputStream.println("kakao_id,count");

		for(int i = 1; i<re.getOneUser().size()+3; i++) {

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
