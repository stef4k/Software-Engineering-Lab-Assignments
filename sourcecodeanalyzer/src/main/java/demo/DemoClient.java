package demo;

import java.io.IOException;

import codeanalyzer.*;

public class DemoClient {

	/**
	 * Main method, reads from command line arguments. If no command arguments is
	 * given then it checks the TestClass with regex analyzer type.
	 * 
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		String filepath = "src/main/resources/TestClass.java";
		String sourceCodeAnalyzerType = "regex";
		String sourceFileLocation = "local";
		String outputFilePath = "output_metrics";
		String outputFileType = "csv";

		if (args.length == 5) {
			filepath = args[0];
			sourceCodeAnalyzerType = args[1];
			sourceFileLocation = args[2];
			outputFilePath = args[3];
			outputFileType = args[4];
		} else if (args.length != 0) {
			System.out.println("Incorrect number of arguments.");
			System.exit(1);
		}

		Facade fac = new Facade();
		fac.execute_metrics(filepath, sourceCodeAnalyzerType, sourceFileLocation, outputFilePath, outputFileType);
	}
}