package edu.handong.csee.java.hw3;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class WinFileReader implements Runnable{
	
	String file;
	static ArrayList<String> fileLineWin = new ArrayList<String>();
	
	public static ArrayList<String> getFileLineWin() {
		return fileLineWin;
	}

	@Override
	public void run() {
        Scanner inputStream = null;
		
		try {
			inputStream = new Scanner(new File(file));

		}  catch (FileNotFoundException e) { 
			System.out.println ("Error opening the file " + file);
			System.exit (0);
		}
		
		while (inputStream.hasNextLine ()) {
			String line = inputStream.nextLine ();
			fileLineWin.add(line);
		}
		
		inputStream.close();
		
	}
	
	public WinFileReader() {
	}
	
    public WinFileReader(String file) {
		this.file = file;
	}

}
