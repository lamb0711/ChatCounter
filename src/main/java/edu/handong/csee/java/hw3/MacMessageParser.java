package edu.handong.csee.java.hw3;

import java.util.ArrayList;
/**
 * MacMessageParser calss is save Mac Message remove enter.
 * @author yangsujin
 *
 */
public class MacMessageParser {
	static ArrayList<String> messageLineMac = new ArrayList<String>();

	/**
	 * getMessageLineMac method can use messageLineMac ArrayList in other class
	 * @return
	 */

	public static ArrayList<String> getMessageLineMac() {
		return messageLineMac;
	}

	MacFileReader fi = new MacFileReader();

	void saveOnlyMessageMac() {




		String line = "";
		for(int i=0; i<fi.getFileLineMac().size()-1; i++) {
			line = line.concat(fi.getFileLineMac().get(i));
			if(fi.getFileLineMac().get(i+1).matches("2018-.*")) line = line.concat("]]]");
		}


		String[] tempStr = line.split("]]]"); 
		for (int i = 0; i < tempStr.length; i++) { 
			messageLineMac.add(tempStr[i]); 
		}

		messageLineMac.add(fi.getFileLineMac().get(fi.getFileLineMac().size()-1));


	}

}
