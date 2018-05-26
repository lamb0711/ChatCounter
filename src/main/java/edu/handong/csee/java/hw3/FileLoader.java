package edu.handong.csee.java.hw3;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;


public class FileLoader {
    static ArrayList<String> fileLineWin = new ArrayList<String>();
	static ArrayList<String> fileLineMac = new ArrayList<String>();

	public ArrayList<String> getFileLineWin() {
		return fileLineWin;
	}

	public ArrayList<String> getFileLineMac() {
		return fileLineMac;
	}



	//private String fileName;
	//private File directory;

	
	/*HashMap<String,ArrayList<Message>> messages = new HsahMap<String,ArrayList<Message>>();//one person a lot of message
	public HashMap<String,ArrayList<Message>> loadMacFiles() {
		for(File file : directory.listFiles()) {//directory file return
			if(file.getName().contains(".csv")) {
				Reader in;
				try {
					in = new FileReader(file);
					Iterable<Cs> 
					for(CSVRecord record : records) {
						String time = record.get(0).substring(11,16);
						String user 
					}

					if(!messages.contaninKey(user)) {
						messages.put(user,new ArrayList<Messages>());
					}
					Message message = new Message(user,time,message));
					messages.get(user).add(message);


				}catch() {

				}

			}
		}
		return messages;
	}*/



	void readFile(String fileName, int a){
		//Scanner keyboard = new Scanner(System.in);
		Scanner inputStream = null;


		try {
			inputStream = new Scanner(new File(fileName));

		}  catch (FileNotFoundException e) { 
			System.out.println ("Error opening the file " + fileName);
			System.exit (0);
		}


		if(a == 1) {
			while (inputStream.hasNextLine ()) {
				String line = inputStream.nextLine ();
				fileLineMac.add(line);
			}

			/*for(int i=0; i<fileLineMac.size(); i++) {
				System.out.println(fileLineMac.get(i));
			}*/
		} else {
			while (inputStream.hasNextLine ()) {
				String line = inputStream.nextLine ();
				fileLineWin.add(line);
			}

			/*for(int i=0; i<fileLineWin.size(); i++) {
				System.out.println(fileLineWin.get(i));
			}*/
		}

		inputStream.close();
	}

}
