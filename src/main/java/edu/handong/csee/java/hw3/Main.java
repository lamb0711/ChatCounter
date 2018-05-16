package edu.handong.csee.java.hw3;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	public static ArrayList<String> chatLine = new ArrayList<String>();;
	public static String file;
	
	public static void main(String[] args) {
		FileLoader fi = new FileLoader();
		Scanner keyboard = new Scanner(System.in);
		
		System.out.println("Input File name to read");
		file = keyboard.next();
		fi.readFile(file,chatLine);
		

	}

}
