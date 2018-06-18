package edu.handong.csee.java.hw3;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collection;
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
public class FileLoader {
	Main ma = new Main();

	static int numOfCoresInMyCPU=0;
	static ArrayList<String> fileName = new ArrayList<String>();

	/**
	 * FileLoader()is constructor.
	 */

	public FileLoader () {

	}
	/**
	 * FileLoader(String)is constructor.
	 * @param number
	 */
	public FileLoader (String number) {
		this.numOfCoresInMyCPU = Integer.parseInt(number);
	}
	/**
	 * fileMain is first method to call
	 */

	public void fileMain() {
		fileName.addAll(Main.getName());


		FileLoader fi = new FileLoader();

		fi.readFile();

	}


	private synchronized void readFile(){

		int numOfCoresInMyCPU = Runtime.getRuntime().availableProcessors();
		System.out.println("The number of cores of my system: " + numOfCoresInMyCPU);

		ExecutorService executor = Executors.newFixedThreadPool(numOfCoresInMyCPU);


		synchronized(fileName) {
			for(String file : fileName) {

				if(file.contains(".csv")) {
					MacFileReader fi = new MacFileReader(file);
					Runnable worker = fi;
					executor.execute(worker);

				} else {
					WinFileReader fa = new WinFileReader(file);
					Runnable worker = fa;
					executor.execute(worker);
				}
			}
		}

		executor.shutdown();

		while (!executor.isTerminated()) {
		}
	}


}
