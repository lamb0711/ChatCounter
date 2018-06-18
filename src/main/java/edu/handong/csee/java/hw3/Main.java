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
	String numberOfTheards;
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
//데이타 리더 클래스를 선언해서 파일을 읽는다. 데이타 리더 클래스로 감
		//dataread.readdata(input data)
		//	ㄷ내가 쓰레드로 하려던것 개인의 파일 읽기
		//데이타 리터 전체를 런터블로 만들면 안됨 디렉토리는 한번만 읽으면 되니까! 나는 파일을 쓰레드로 만들고 싶으니까!
		//즉 나는 readfile만변경하면 된다.
		//여기서 파일만 읽는 역할을 하는 csv파일 리더랑 txt파일리더랑 전용 러너블을 만든다. - 루프를 없앰
		
		
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

			}


			for(int i = 0; i < name.size(); i++){
				String txtname = name.get(i);
				if(txtname.matches(".*csv")) {
					csv.add(path+"/"+txtname);
				}else txt.add(path+"/"+txtname);
			} 


			 FileLoader fi = new FileLoader(numberOfTheards);
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



		try {
			CommandLine cmd = parser.parse(options, args);

			path = cmd.getOptionValue("i");
			output = cmd.getOptionValue("o");
			numberOfTheards = cmd.getOptionValue("c");
			verbose = cmd.hasOption("v");
			help = cmd.hasOption("h");

		}catch (Exception e) {
			printHelp(options);
			return false;
		}
		return true;
	}

	private void printHelp(Options options) {
		// automatically generate the help statement
		HelpFormatter formatter = new HelpFormatter();
		String header = "Kakao Chat counter";
		String footer ="\nPlease report issues at https://github.com/lamb0711/ChatCounter/issues";
		formatter.printHelp("Kakao Chat counter", header, options, footer, true);
	}

	private Options createOptions() {
		Options options = new Options();

		options.addOption(Option.builder("i").longOpt("path")
				.desc("Set a path of a directory or a file to input")
				.hasArg()
				.argName("Path name to display")
				.required()
				.build());
		options.addOption(Option.builder("o").longOpt("output")
				.desc("Set a path of a directory or a file to output")
				.hasArg()
				.argName("Path name to display")
				.required()
				.build());
		options.addOption(Option.builder("c").longOpt("number of threads")
				.desc("Set a number of threads")
				.hasArg()
				.argName("number to display")
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
