package edu.handong.csee.java.hw3;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * FileLoader class is open file and save string by line.
 * It divided by window and mac.
 * @author yangsujin
 *
 */
public class FileLoader implements Runnable{
	static ArrayList<String> fileLineWin = new ArrayList<String>();
	static ArrayList<String> fileLineMac = new ArrayList<String>();
	static int numOfCoresInMyCPU=0;
	
	public FileLoader () {
		
	}
	
	
	public FileLoader (String number) {
		this.numOfCoresInMyCPU = Integer.parseInt(number);
	}

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
		numOfCoresInMyCPU = Runtime.getRuntime().availableProcessors();
		System.out.println("The number of cores of my system: " + numOfCoresInMyCPU);
		
		ExecutorService executor = Executors.newFixedThreadPool(numOfCoresInMyCPU);
		
		try {
			inputStream = new Scanner(new File(fileName));

		}  catch (FileNotFoundException e) { 
			System.out.println ("Error opening the file " + fileName);
			System.exit (0);
		}

		//Thread csvFileReader = new Thread(new CsvFileReader(file));
		//csvFileReader.start(); = csv파일이 동시에 다 돌아
		//Thread FileLoader = new Thread(new File)

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

	@Override
	public void run() {
		// TODO Auto-generated method stub
		readFile(null, 0);
		
	}

}
