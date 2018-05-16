package edu.handong.csee.java.hw3;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FileLoader {
	private String fileName;
	
	void readFile(String file){
		Scanner inputStream = null;
		fileName = file;
		
		try {
			inputStream = new Scanner(new File(fileName));
			saveFileByLine(inputStream);
		}  catch (FileNotFoundException e) {
			System.out.println ("Error opening the file " + fileName);
			System.exit (0);
	    }
		inputStream.close ();
    }
	
	void saveFileByLine(Scanner inputStream) {
		
		while (inputStream.hasNextLine ()) {
			chatLine = inputStream.nextLine ();
		}
		
	}
	
}
