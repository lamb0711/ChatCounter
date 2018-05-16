package edu.handong.csee.java.hw3;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class FileLoader {
	private String fileName;
	
	void readFile(ArrayList<String> chatLine){
        Scanner keyboard = new Scanner(System.in);
        Scanner inputStream = null;
		
		System.out.println("Input File name to read");
		fileName = keyboard.next();
		//fileName = "parsing.txt";
		
		try {
			inputStream = new Scanner(new File(fileName));
		}  catch (FileNotFoundException e) {
			System.out.println ("Error opening the file " + fileName);
			System.exit (0);
	    }
		
		saveFileByLine(inputStream,chatLine);
		
		//inputStream.close ();
    }
	
	void saveFileByLine(Scanner inputStream, ArrayList<String> chatLine) {
		
		while (inputStream.hasNextLine ()) {
			String line = inputStream.nextLine ();
			chatLine.add(line);
		}
		
		for(int i=0; i<chatLine.size(); i++) {
			System.out.println(chatLine.get(i));
		}
		
	}

}
