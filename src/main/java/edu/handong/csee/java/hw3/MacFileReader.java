package edu.handong.csee.java.hw3;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
/**
 * MacFileReader is class to save file line to fileLineMac.
 * @author yangsujin
 *
 */
public class MacFileReader implements Runnable{

	String file;
	static ArrayList<String> fileLineMac = new ArrayList<String>();

	/**
	 * getFileLineMac method can use fileLineMac ArrayList in other class
	 * @return
	 */


	public static ArrayList<String> getFileLineMac() {
		return fileLineMac;
	}

	/**
	 * run is first method to implement in main method
	 */
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
			synchronized(fileLineMac) {
				fileLineMac.add(line);
			}
		}

		inputStream.close();

	}
	/**
	 * MacFileReader()is constructor
	 */
	public MacFileReader() {
	}
	/**
	 * MacFileReader(String)is constructor
	 */
	public MacFileReader(String file) {
		this.file = file;
	}



}
