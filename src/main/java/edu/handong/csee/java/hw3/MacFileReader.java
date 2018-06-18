package edu.handong.csee.java.hw3;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class MacFileReader implements Runnable{
	
	String file;
	static public ArrayList<String> fileLineMac = new ArrayList<String>();
	
	public static ArrayList<String> getFileLineMac() {
		return fileLineMac;
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
			fileLineMac.add(line);
			//System.out.println(line);
		}
		
		inputStream.close();
	}
	
	public MacFileReader() {
	}
	
    public MacFileReader(String file) {
		this.file = file;
	}
    


}
