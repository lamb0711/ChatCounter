package edu.handong.csee.java.hw3;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class FileLoader {
	private String fileName;
	
	void readFile(String file, ArrayList<String> chatLine){
		Scanner inputStream = null;
		fileName = file;
		
		try {
			inputStream = new Scanner(new File(fileName));
			saveFileByLine(inputStream,chatLine);
		}  catch (FileNotFoundException e) {
			System.out.println ("Error opening the file " + fileName);
			System.exit (0);
	    }
		inputStream.close ();
    }
	
	void saveFileByLine(Scanner inputStream, ArrayList<String> chatLine) {
		
		while (inputStream.hasNextLine ()) {
			String line = inputStream.nextLine ();
			chatLine.add(line);
		}
		
		for(int i=0; i<chatLine.size(); i++) {
			i += 1;
			System.out.println(chatLine.get(i));
		}
		
	}

}
