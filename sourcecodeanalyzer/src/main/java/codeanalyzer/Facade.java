package codeanalyzer;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Facade {

	public void execute_metrics(String filepath, String sourceCodeAnalyzerType, String sourceFileLocation,
			String outputFilePath, String outputFileType) throws IOException {
		
		FactoryAnalyzer analyze = new FactoryAnalyzer();
		Map<String, Integer> metrics = new HashMap<>();
		metrics = analyze.codeAnalyze(filepath,sourceCodeAnalyzerType, sourceFileLocation);

		if (outputFileType == "csv") {
			CsvExporter exporter = new CsvExporter();
			exporter.writeFile(metrics, outputFilePath);
		} else if (outputFileType == "json") {
			JsonExporter exporter = new JsonExporter();
			exporter.writeFile(metrics, outputFilePath);
		}else {
			throw new IllegalArgumentException("Unknown output file type " + outputFileType);
		}
	}
}
