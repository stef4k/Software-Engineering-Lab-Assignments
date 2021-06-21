package codeanalyzer;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * This class is used in order to create a simple interface to a complex system
 * and to separate the client from different sub-systems. The client class
 * becomes more independent and only depends on this class
 * 
 * @author stef4k
 *
 */
public class Facade {

	/**
	 * Method to calculate all the metrics (LOC,NOM, NOC) calculated with a unique
	 * analyzer and export it to a specific file
	 * 
	 * @param filepath
	 * @param sourceCodeAnalyzerType
	 * @param sourceFileLocation
	 * @param outputFilePath
	 * @param outputFileType
	 * @throws IOException
	 */
	public void execute_metrics(String filepath, String sourceCodeAnalyzerType, String sourceFileLocation,
			String outputFilePath, String outputFileType) throws IOException {

		FactoryAnalyzer analyze = new FactoryAnalyzer();
		Map<String, Integer> metrics = new HashMap<>();
		metrics = analyze.codeAnalyze(filepath, sourceCodeAnalyzerType, sourceFileLocation);

		if (outputFileType.equals("csv")) {
			CsvExporter exporter = new CsvExporter();
			exporter.writeFile(metrics, outputFilePath);
		} else if (outputFileType.equals("json")) {
			// JsonExporter exporter = new JsonExporter();
			// exporter.writeFile(metrics, outputFilePath);
			throw new IllegalArgumentException("Json not implemented yet");
		} else {
			throw new IllegalArgumentException("Unknown output file type " + outputFileType);
		}
	}
}
