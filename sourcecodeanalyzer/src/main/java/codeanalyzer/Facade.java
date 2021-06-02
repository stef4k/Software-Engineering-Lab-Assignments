package codeanalyzer;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Facade {

	public void execute_metrics(String filepath, String sourceCodeAnalyzerType, String sourceFileLocation,
			String outputFilePath, String outputFileType) throws IOException {
		
		SourceCodeAnalyzer analyzer;
		if (sourceCodeAnalyzerType == "regex") {
			analyzer = new RegexAnalyzer(sourceFileLocation);
		} else if (sourceCodeAnalyzerType == "strcomp") {
			analyzer = new StrcompAnalyzer(sourceFileLocation);
		}else {
			analyzer = new NullAnalyzer(sourceFileLocation);
		}
		
		int loc = analyzer.calculateLOC(filepath, sourceCodeAnalyzerType);
		int nom = analyzer.calculateNOM(filepath, sourceCodeAnalyzerType);
		int noc = analyzer.calculateNOC(filepath, sourceCodeAnalyzerType);

		Map<String, Integer> metrics = new HashMap<>();
		metrics.put("loc", loc);
		metrics.put("nom", nom);
		metrics.put("noc", noc);

		if (outputFileType == "csv") {
			CsvExporter exporter = new CsvExporter();
			exporter.writeFile(metrics, outputFilePath);
		} else if (outputFileType == "json") {
			JsonExporter exporter = new JsonExporter();
			exporter.writeFile(metrics, outputFilePath);
		}
	}
}
