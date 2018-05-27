package edu.handong.csee.java.hw3;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;


public class FileLoader {
	static ArrayList<String> fileLineWin = new ArrayList<String>();
	static ArrayList<String> fileLineMac = new ArrayList<String>();

	public ArrayList<String> getFileLineWin() {
		return fileLineWin;
	}

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
