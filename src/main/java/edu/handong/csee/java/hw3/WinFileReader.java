package edu.handong.csee.java.hw3;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
/**
 * WinFileReader is class to save file line to fileLineWin.
 * @author yangsujin
 *
 */
public class WinFileReader implements Runnable{

	String file;
	static ArrayList<String> fileLineWin = new ArrayList<String>();

	/**
	 * getFileLineWin method can use fileLineWin ArrayList in other class
	 * @return
	 */

	public static ArrayList<String> getFileLineWin() {
		return fileLineWin;
	}
	/**
	 * run is first method to implement in main method
	 */
	public synchronized void run() {
		Scanner inputStream = null;

		try {
			inputStream = new Scanner(new File(file));

		}  catch (FileNotFoundException e) { 
			System.out.println ("Error opening the file " + file);
			System.exit (0);
		}

		while (inputStream.hasNextLine ()) {
			String line = inputStream.nextLine ();
			synchronized(fileLineWin) {
				fileLineWin.add(line);
			}
		}

		inputStream.close();

	}
	/**
	 * WinFileReader()is constructor
	 */
	public WinFileReader() {
	}
	/**
	 * WinFileReader(String)is constructor
	 */
	public WinFileReader(String file) {
		this.file = file;
	}

}
