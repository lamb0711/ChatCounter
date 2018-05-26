package edu.handong.csee.java.hw3;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Main {
	private static ArrayList<String> csv = new ArrayList<String>();
	private static ArrayList<String> txt = new ArrayList<String>();
	
	public static void main(String[]args) {
		File file  = new File("/Users/yangsujin/Documents/git/ChatCounter/Chat-자바");
		File arr[] = file.listFiles();
		
		ArrayList<String> name = new ArrayList<String>();

		 for(int i=0 ; i<arr.length ; i++ ){
		     
		     name.add(arr[i].getName());
		 
		}
		 
		 for(int i = 0; i < name.size(); i++){
			 String txtname = name.get(i);
			 if(txtname.matches(".*csv")) {
				 csv.add("/Users/yangsujin/Documents/git/ChatCounter/Chat-자바/"+txtname);
			 }else txt.add("/Users/yangsujin/Documents/git/ChatCounter/Chat-자바/"+txtname);
		 }
		 
		/* for(int i=0; i<csv.size(); i++) {
			 System.out.println(csv.get(i));
			 }
		 
		 for(int i=0; i<txt.size(); i++) {
			 System.out.println(txt.get(i));
			 }
		 */
		 
		 
		 FileLoader fi = new FileLoader();
		 MessageDivider di = new MessageDivider();
		 
		 for(int i=0; i<1; i++) {
			 fi.readFile(csv.get(i), 1);
			 }
		 
		 for(int i=0; i<txt.size(); i++) {
			 fi.readFile(txt.get(i), 0);
			 di.divideMessageWin();
			 }
		 
	}
	
	/*public static void main(String[] args) {
	 * 
		FileLoader fi = new FileLoader();
		MessageParser me = new MessageParser();
		Message ms = new Message();
		//RedundancyChecker re = new RedundancyChecker();
		String directory="";
		FileLoader fileLoader = new FileLoader(directory);//path copy and save in directory
		HashMap<String,ArrayList<Message>> user = fileLoader.loadMacFiles();
		for(String key : users.keySet()) {
			for(Message messages:users.get(key)) {
				System.out.println(message.getName()+" "+message.getMessage());
			}
		}
		
		fileLoader.loadMacFile();
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

	}*/

}
