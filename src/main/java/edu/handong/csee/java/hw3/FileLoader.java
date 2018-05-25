package edu.handong.csee.java.hw3;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class FileLoader {
	private String fileName;
    private File directory;

	/*public FileLoader() {
		directory = new File(path);
	}*/
	
	char divideWindowMac(){
		Scanner keyboard = new Scanner(System.in);
		Scanner inputStream = null;

		System.out.println("Input File name to read");
		//fileName = keyboard.next();
		//fileName = "parsing.txt";
		fileName = "L2.csv";

		try {
			inputStream = new Scanner(new File(fileName));

		}  catch (FileNotFoundException e) {
			System.out.println ("Error opening the file " + fileName);
			System.exit (0);
		}

		String line = inputStream.nextLine();
		if(!line.matches(".*JC.*")) {
			inputStream.close();
			return 'M';
		}else {
			inputStream.close();
			return 'W';
		}
	}
	
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

	ArrayList<String> readFile(ArrayList<String> fileLine){
		Scanner keyboard = new Scanner(System.in);
		Scanner inputStream = null;

		//fileName = keyboard.next();
		//fileName = "parsing.txt";
		fileName = "L2.csv";

		try {
			inputStream = new Scanner(new File(fileName));

		}  catch (FileNotFoundException e) { 
			System.out.println ("Error opening the file " + fileName);
			System.exit (0);
		}

		fileLine = saveFileByLine(inputStream,fileLine);
		inputStream.close();

		return fileLine;

	}

	ArrayList<String> saveFileByLine(Scanner inputStream, ArrayList<String> fileLine) {

		while (inputStream.hasNextLine ()) {
			String line = inputStream.nextLine ();
			fileLine.add(line);
		}

		/*for(int i=0; i<fileLine.size(); i++) {
			System.out.println(fileLine.get(i));
		}*/
		inputStream.close();

		return fileLine;

	}

}
