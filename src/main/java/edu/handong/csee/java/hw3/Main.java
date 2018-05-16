package edu.handong.csee.java.hw3;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	public static ArrayList<String> fileLine = new ArrayList<String>();
	public static ArrayList<String> messageLine = new ArrayList<String>();
	public static ArrayList<String> message = new ArrayList<String>();
	
	public static void main(String[] args) {
		FileLoader fi = new FileLoader();
		MessageParser me = new MessageParser();
		RedundancyChecker re = new RedundancyChecker();
		
		fileLine = fi.readFile(fileLine);
		
		messageLine = me.saveOnlyMessage(fileLine, messageLine);
		message = re.removeRedundancy(messageLine, message);

	}

}
