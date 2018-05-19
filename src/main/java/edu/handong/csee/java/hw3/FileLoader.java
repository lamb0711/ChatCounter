package edu.handong.csee.java.hw3;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class FileLoader {
	private String fileName;
	
	ArrayList<String> readFile(ArrayList<String> fileLine){
        Scanner keyboard = new Scanner(System.in);
        Scanner inputStream = null;
		
		System.out.println("Input File name to read");
		//fileName = keyboard.next();
		fileName = "parsing.txt";
		
		try {
			inputStream = new Scanner(new File(fileName));
			
		}  catch (FileNotFoundException e) {
			System.out.println ("Error opening the file " + fileName);
			System.exit (0);
	    }
		
		fileLine = saveFileByLine(inputStream,fileLine);
		inputStream.close();
		
		return fileLine;
		
    }
	
	ArrayList<String> saveFileByLine(Scanner inputStream, ArrayList<String> fileLine) {
		
		while (inputStream.hasNextLine ()) {
			String line = inputStream.nextLine ();
			fileLine.add(line);
		}
		
		for(int i=0; i<fileLine.size(); i++) {
			System.out.println(fileLine.get(i));
		}
		
		return fileLine;
		
	}

}
