package edu.handong.csee.java.hw3;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class MessageDivider {
	ArrayList<String> user = new ArrayList<String>();
	ArrayList<String> time = new ArrayList<String>();
	ArrayList<String> chatMessage = new ArrayList<String>();
	
	FileLoader fi = new FileLoader();
	Message me = new Message();
	
	void divideMessageWin() {

		Pattern pattern = Pattern.compile("\\[(.+)\\]\\s\\[(.+)\\]\\s(.+)");

		for(int i=0; i<fi.getFileLineWin().size(); i++) {
			String line = fi.getFileLineWin().get(i);
			Matcher matcher = pattern.matcher(line);
			
			while(matcher.find()) {
				user.add(matcher.group(1));
				time.add(matcher.group(2));
				chatMessage.add(matcher.group(3));
			}
		}

		//changeTimeWin();
		/*for(int i=0; i<user.size(); i++) {
			System.out.println(user.get(i)+" "+time.get(i)+" "+chatMessage.get(i));
		}*/

	}
	
	private void changeTimeWin() {
		
		for(int i=0; i<time.size(); i++) {
			System.out.println(time.get(i));
		}

		
		for(int i=0; i<user.size(); i++) {
			String line = time.get(i);
	//		if(line.matches())
			
		}
	}


	public String group(int i) {
		// TODO Auto-generated method stub
		return null;
	}

	private void divideMessageMac() {

	}


}
