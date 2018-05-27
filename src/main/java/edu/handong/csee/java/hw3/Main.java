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

/**
 * Main class. It include main method and apache2 CLI code
 * @author yangsujin
 *
 */

public class Main {
	String path;
	String output;
	boolean verbose;
	boolean help;


	private static ArrayList<String> csv = new ArrayList<String>();
	private static ArrayList<String> txt = new ArrayList<String>();


	/**
	 * main method is implement first;
	 */

	public static void main(String[]args) {
		Main my = new Main();
		my.run(args);
	}

	private void run(String[] args) {
		Options options = createOptions();

		if(parseOptions(options, args)) {
			if (help){
				printHelp(options);
				return;
			}

			File file  = new File(path);
			File arr[] = file.listFiles();

			ArrayList<String> name = new ArrayList<String>();

			for(int i=0 ; i<arr.length ; i++ ){

				name.add(arr[i].getName());
				System.out.println(arr[i]);

			}


			for(int i = 0; i < name.size(); i++){
				String txtname = name.get(i);
				if(txtname.matches(".*csv")) {
					csv.add(path+"/"+txtname);
				}else txt.add(path+"/"+txtname);
			}

			for(int i=0; i<csv.size(); i++) {
				System.out.println(csv.get(i));
			}

			for(int i=0; i<txt.size(); i++) {
				System.out.println(txt.get(i));
			}


			FileLoader fi = new FileLoader();
			MessageDivider di = new MessageDivider();
			MacMessageParser ma = new MacMessageParser();

			for(int i=0; i<csv.size(); i++) {
				fi.readFile(csv.get(i), 1);
				ma.saveOnlyMessageMac();
				di.divideMessageMac();
			}


			for(int i=0; i<txt.size(); i++) {
				fi.readFile(txt.get(i), 0);
				di.divideMessageWin();
			}

			RedundancyChecker ha = new RedundancyChecker();
			ha.saveOnlyOneUser();
			ha.removeRedundancy();

			PMCounter pm = new PMCounter();
			pm.countMessageNumber();

			FileWriter wr = new FileWriter();
			wr.saveInCsvFile(output);


			if(verbose) {

				System.out.println("Your program is terminated. (This message is shown because you turned on -v option!");
			}
		}

	}

	private boolean parseOptions(Options options, String[] args) {
		CommandLineParser parser = new DefaultParser();
		for(int i=0; i<args.length; i++)
			System.out.println(args[i]);


		try {
			CommandLine cmd = parser.parse(options, args);

			path = cmd.getOptionValue("i");
			output = cmd.getOptionValue("o");
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
