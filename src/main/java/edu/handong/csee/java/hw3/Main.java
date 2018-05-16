package edu.handong.csee.java.hw3;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	public static ArrayList<String> fileLine = new ArrayList<String>();
	public static ArrayList<String> messageLine = new ArrayList<String>();
	
	public static void main(String[] args) {
		FileLoader fi = new FileLoader();
		MessageParser me = new MessageParser();
		
		fi.readFile(fileLine);
		me.saveOnlyMessage(fileLine, messageLine);

	}

}
