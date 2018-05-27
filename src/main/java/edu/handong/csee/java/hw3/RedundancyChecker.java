package edu.handong.csee.java.hw3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.TreeSet;


/**
 * RedundancyChecker class is check redundancy message and remove it.
 * @author yangsujin
 *
 */

public class RedundancyChecker {
	MessageDivider di = new MessageDivider();
	static ArrayList<String> oneUser = new ArrayList<String>();


	/**
	 * getOneUser method can use oneUser ArrayList in other class
	 * @return
	 */
	public static ArrayList<String> getOneUser() {
		return oneUser;
	}

	/**
	 * getOneMessage method can use oneMessage ArrayList in other class
	 * @return
	 */
	public static ArrayList<String> getOneMessage() {
		return oneMessage;
	}

	static ArrayList<String> oneMessage = new ArrayList<String>();

	void saveOnlyOneUser() {
		ArrayList<String> allUser = new ArrayList<String>();

		for(int i=0; i<di.getUser().size();i++) {
			allUser.add(di.getUser().get(i));
		}
		for(int i=0; i<di.getUserMac().size();i++) {
			allUser.addAll(di.getUserMac());
		}

		TreeSet<String> user = new TreeSet<String>(allUser);
		oneUser.addAll(user);

	}

	void removeRedundancy() {
		String line = "";

		ArrayList<String> allMessage = new ArrayList<String>();

		for(int i=0; i<di.getChatMessageMac().size();i++) {
			allMessage.add(di.getChatMessageMac().get(i));
		}
		for(int i=0; i<di.getChatMessageWin().size();i++) {
			allMessage.add(di.getChatMessageWin().get(i));
		}

		TreeSet<String> message = new TreeSet<String>(allMessage);
		ArrayList<String> oneMessage1 = new ArrayList<String>(message);

		for(int i=0; i < oneMessage1.size()-1;i++) {

			if(oneMessage1.get(i).length() > 50 && oneMessage1.get(i+1).length() > 100 ) 
				line = oneMessage1.get(i).substring(0, 30);

			if(line.length()==30 && oneMessage1.get(i+1).contains(line)) {
				continue;
			}

			oneMessage.add(oneMessage1.get(i));
		}
		oneMessage.add(oneMessage1.get(oneMessage1.size()-1));


	}


}
