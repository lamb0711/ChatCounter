package edu.handong.csee.java.hw3;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/**
 * MessageDivider class is divide window and mac message to user, time and message;
 * And refresh data, merge one message
 * @author yangsujin
 *
 */

public class MessageDivider {
	static ArrayList<String> user = new ArrayList<String>();
	ArrayList<String> time = new ArrayList<String>();
	ArrayList<String> timeRe = new ArrayList<String>();
	ArrayList<String> chatMessage = new ArrayList<String>();
	ArrayList<String> chatMessages = new ArrayList<String>();
	static ArrayList<String> chatMessageWin = new ArrayList<String>();

	static ArrayList<String> userMac = new ArrayList<String>();
	ArrayList<String> timeMac = new ArrayList<String>();
	static ArrayList<String> chatMessageMac1 = new ArrayList<String>();
	static ArrayList<String> chatMessageMac = new ArrayList<String>();

	/**
	 * getChatMessageWin method can use chatMessageWin ArrayList in other class
	 * @return
	 */

	public static ArrayList<String> getChatMessageWin() {
		return chatMessageWin;
	}
	/**
	 * getChatMessageMac method can use chatMessageMac ArrayList in other class
	 * @return
	 */

	public static ArrayList<String> getChatMessageMac() {
		return chatMessageMac;
	}

	/**
	 * getUser method can use user ArrayList in other class
	 * @return
	 */

	public static ArrayList<String> getUser() {
		return user;
	}

	/**
	 *  getUserMac method can use userMac ArrayList in other class
	 * @return
	 */


	public static ArrayList<String> getUserMac() {
		return userMac;
	}


	WinFileReader fi = new WinFileReader();
	MacMessageParser ma = new MacMessageParser();


	void divideMessageWin() {

		Pattern pattern = Pattern.compile("\\[(.+)\\]\\s\\[(.+)\\]\\s(.+)");

		for(int i=0; i<fi.getFileLineWin().size(); i++) {

			String line = fi.getFileLineWin().get(i);
			/*if(line.contains("사진")) {
				System.out.println(line);
				line.replace("사진","Photo");
				System.out.println(line);
			}*/
			Matcher matcher = pattern.matcher(line);

			while(matcher.find()) {

				user.add(matcher.group(1));
				time.add(matcher.group(2));
				chatMessage.add(matcher.group(3));

			}
		}

		changeTimeWin();

	}

	private void changeTimeWin() {

		String time1 = null;
		String time2 = null;
		int timeInt;

		for(int i=0; i<time.size(); i++) {

			String line = time.get(i);

			if(line.matches("오전\\s(.*)")||line.matches(".+\\sAM")) {

				Pattern pattern = Pattern.compile("([0-9]+):([0-9]+)");
				Matcher matcher = pattern.matcher(line);

				while(matcher.find()) {

					time1 = matcher.group(1);
					time2 = matcher.group(2);

				}

				if(time1.matches("12")){

					time1 ="00";
					timeRe.add(i,time1+":"+time2);

				}
				else if( time1.length()==1) {
					timeRe.add(i,"0"+time1+":"+time2);
				}else timeRe.add(i,time1+":"+time2);
			}


			else if(line.matches("오후\\s(.*)")||line.matches(".+\\sPM")) {

				Pattern pattern = Pattern.compile("([0-9]+):([0-9]+)");
				Matcher matcher = pattern.matcher(line);

				while(matcher.find()) {

					time1 = matcher.group(1);
					time2 = matcher.group(2);

				}
				timeInt = Integer.parseInt(time1);
				if(timeInt!=12) {
					timeInt = timeInt+12;
					time1 = String.valueOf(timeInt);
				}
				timeRe.add(i,time1+":"+time2);
			}
		}



		for(int i=0; i<user.size(); i++) {
			chatMessageWin.add(i,user.get(i)+" "+timeRe.get(i)+" "+chatMessage.get(i));
		}

	}


	void divideMessageMac() {

		Pattern pattern = Pattern.compile(".+\\s([0-9]+:[0-9]+):[0-9]+,\"(.+)\",\"(.+)\"");


		for(int i=0; i<ma.getMessageLineMac().size(); i++) {

			String line = ma.getMessageLineMac().get(i);
			Matcher matcher = pattern.matcher(line);

			while(matcher.find()) {

				userMac.add(matcher.group(2));
				timeMac.add(matcher.group(1));
				chatMessageMac.add(matcher.group(2)+" "+matcher.group(1)+" "+matcher.group(3));

			}
		}

	}


}
