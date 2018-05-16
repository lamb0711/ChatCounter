package edu.handong.csee.java.hw3;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	public static ArrayList<String> chatLine = new ArrayList<String>();
	
	public static void main(String[] args) {
		FileLoader fi = new FileLoader();
		
		fi.readFile(chatLine);
		

	}

}
