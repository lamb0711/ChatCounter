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

	public FileLoader () {

	}

	public FileLoader (String number) {
		this.numOfCoresInMyCPU = Integer.parseInt(number);
	}


	/**
	 * getFileLineWin method can use fileLineWin ArrayList in other class
	 * @return
	 */

	/**
	 * getFileLineMac method can use fileLineMac ArrayList in other class
	 * @return
	 */


	public void fileMain() {
		fileName.addAll(Main.getName());
		
		for(String file : fileName) {
			System.out.println(file);
		}
		FileLoader fi = new FileLoader();
		
		fi.readFile();
	}


	void readFile(){
		System.out.println("a");
		int numOfCoresInMyCPU = Runtime.getRuntime().availableProcessors();
		System.out.println("The number of cores of my system: " + numOfCoresInMyCPU);

		ExecutorService executor = Executors.newFixedThreadPool(numOfCoresInMyCPU);
		System.out.println("b");
		for(String file : fileName) {


			if(file.contains(".csv")) {
				System.out.println("c");
				MacFileReader fi = new MacFileReader(file);
				Runnable worker = fi;
				executor.execute(worker);

			} else {
				System.out.println("w");
				MacFileReader fa = new MacFileReader(file);
				Runnable worker = fa;
				executor.execute(worker);
			}
		}
		
		MacFileReader fi = new MacFileReader();
		for(int i=0;i<fi.getFileLineMac().size();i++) {
	 		System.out.println(fi.getFileLineMac().get(i));
	 	}

		executor.shutdown();
	}


}
