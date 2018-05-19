package edu.handong.csee.java.hw3;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	private static char distinguish;
	public static ArrayList<String> fileLine = new ArrayList<String>();
	public static ArrayList<String> fileLineMac = new ArrayList<String>();
	public static ArrayList<String> messageLine = new ArrayList<String>();
	public static ArrayList<String> messageLineMac = new ArrayList<String>();
	
	public static void main(String[] args) {
		FileLoader fi = new FileLoader();
		MessageParser me = new MessageParser();
		Message ms = new Message();
		//RedundancyChecker re = new RedundancyChecker();
		
		distinguish = fi.divideWindowMac();
		
		if(distinguish == 'M') {
			fileLineMac = fi.readFile(fileLineMac);
			messageLineMac = me.saveOnlyMessageMac(fileLineMac, messageLineMac);
			
			System.out.println("M");
			//message = re.removeRedundancy(messageLineMac, message);
		}else {
			fileLineMac = fi.readFile(fileLine);
			messageLine = me.saveOnlyMessage(fileLine, messageLine);
			System.out.println("w");
			//message = re.removeRedundancy(messageLine, message);
		}

	}

}
