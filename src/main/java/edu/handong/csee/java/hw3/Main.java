package edu.handong.csee.java.hw3;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.Option;
import org.apache.commons.cli.Options;



public class Main {
	static String path;
	boolean verbose;
	boolean help;
	
	
	private static ArrayList<String> csv = new ArrayList<String>();
	private static ArrayList<String> txt = new ArrayList<String>();
	
	public static void main(String[]args) {
		Main my = new Main();
		//my.run(args);
		

		File file  = new File(args[0]);
		 File arr[] = file.listFiles();
		
		ArrayList<String> name = new ArrayList<String>();

		 for(int i=0 ; i<arr.length ; i++ ){
		     
		     name.add(arr[i].getName());
		 
		}
		 
		 for(int i = 0; i < name.size(); i++){
			 String txtname = name.get(i);
			 if(txtname.matches(".*csv")) {
				 csv.add(args[0]+"/"+txtname);
			 }else txt.add(args[0]+"/"+txtname);
		 }
		 
		 
		 for(int i=0; i<csv.size(); i++) {
			 System.out.println(csv.get(i));
			 }
		 
		 for(int i=0; i<txt.size(); i++) {
			 System.out.println(txt.get(i));
			 }
		 
		 
		 
		 FileLoader fi = new FileLoader();
		 MessageDivider di = new MessageDivider();

		 
		 for(int i=0; i<csv.size(); i++) {
			 fi.readFile(csv.get(i), 1);
			 di.divideMessageMac();
			 }
		 
		 
		 for(int i=0; i<0; i++) {
			 fi.readFile(txt.get(i), 0);
			 di.divideMessageWin();
			 }
		 
		 HashMapMaker ha = new HashMapMaker();
		// ha.saveOnlyOneUser();
		// ha.removeRedundancy();
		 
	}
	
	private void run(String[] args) {
		Options options = createOptions();

		if(parseOptions(options, args)) {
			if (help){
				printHelp(options);
				return;
			}
			System.out.println("You provided \"" + path + "\" as the value of the option p");


			if(verbose) {

				System.out.println("Your program is terminated. (This message is shown because you turned on -v option!");
			}
		}

	}
	
	private boolean parseOptions(Options options, String[] args) {
		CommandLineParser parser = new DefaultParser();
		
		try {
			CommandLine cmd = parser.parse(options, args);
			
			path = cmd.getOptionValue("p");
			verbose = cmd.hasOption("v");
			help = cmd.hasOption("h");
			
		}catch (Exception e) {
			printHelp(options);
			return false;
		}
		return false;
	}
	
	private void printHelp(Options options) {
		// automatically generate the help statement
		HelpFormatter formatter = new HelpFormatter();
		String header = "CLI test program";
		String footer ="\nPlease report issues at https://github.com/lifove/CLIExample/issues";
		formatter.printHelp("CLIExample", header, options, footer, true);
	}
	
	private Options createOptions() {
		Options options = new Options();
		
		options.addOption(Option.builder("p").longOpt("path")
				.desc("Set a path of a directory or a file to display")
				.hasArg()
				.argName("Path name to display")
				.required()
				.build());
		options.addOption(Option.builder("v").longOpt("verbose")
				.desc("Display detailed messages!")
				//.hasArg()     // this option is intended not to have an option value but just an option
				.argName("verbose option")
				//.required() // this is an optional option. So disabled required().
				.build());
		
		// add options by using OptionBuilder
		options.addOption(Option.builder("h").longOpt("help")
		        .desc("Help")
		        .build());
		
		
	return options;	
	}
	
	

}
