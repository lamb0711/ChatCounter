package edu.handong.csee.java.hw3;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class CSVFileReader implements Runnable {//파일 하나만 읽는것. 그러니까 파일 경로를 받아야 한다.run에서는 파라미터 못넣어.. 그러니까어캐 파일이름 받을꺼임
	//일단 instance변수가 필요하다.
File fileName;
int a;
static ArrayList<String> fileLineWin = new ArrayList<String>();
static ArrayList<String> fileLineMac = new ArrayList<String>();
//file 의 값을 초기화 컨스트럭
public CSVFileReader(File file, int a) {
	this.fileName = fileName;
	this.a = a;
}
	@Override
	public void run() {
		readFile();

	}
	
	private void readFile() {
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


