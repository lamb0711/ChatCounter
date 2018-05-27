package edu.handong.csee.java.hw3;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

/**
 * FileLoader class is open file and save string by line.
 * It divided by window and mac.
 * @author yangsujin
 *
 */
public class FileLoader {
	static ArrayList<String> fileLineWin = new ArrayList<String>();
	static ArrayList<String> fileLineMac = new ArrayList<String>();

	/**
	 * getFileLineWin method can use fileLineWin ArrayList in other class
	 * @return
	 */

	public ArrayList<String> getFileLineWin() {
		return fileLineWin;
	}

	/**
	 * getFileLineMac method can use fileLineMac ArrayList in other class
	 * @return
	 */

	public ArrayList<String> getFileLineMac() {
		return fileLineMac;
	}


	void readFile(String fileName, int a){
		Scanner inputStream = null;


		try {
			inputStream = new Scanner(new File(fileName));

		}  catch (FileNotFoundException e) { 
			System.out.println ("Error opening the file " + fileName);
			System.exit (0);
		}


		if(a == 1) {
			while (inputStream.hasNextLine ()) {
				String line = inputStream.nextLine ();
				fileLineMac.add(line);
			}

		} else {
			while (inputStream.hasNextLine ()) {
				String line = inputStream.nextLine ();
				fileLineWin.add(line);
			}

		}

		inputStream.close();
	}

}
