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

		
		FileLoader fi = new FileLoader();

		fi.readFile();
		
		/*MacFileReader fi1 = new MacFileReader();
		System.out.println("s"+fi1.getFileLineMac().size());
		for(int i=0;i<fi1.getFileLineMac().size();i++) {
			System.out.println(fi1.getFileLineMac().get(i));
		}*/
	}


	void readFile(){
		
		int numOfCoresInMyCPU = Runtime.getRuntime().availableProcessors();
		System.out.println("The number of cores of my system: " + numOfCoresInMyCPU);

		ExecutorService executor = Executors.newFixedThreadPool(numOfCoresInMyCPU);
		
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

		executor.shutdown();

		while (!executor.isTerminated()) {
		}
	}


}
