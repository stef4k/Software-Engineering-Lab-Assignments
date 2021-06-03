package codeanalyzer;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class FactoryAnalyzer {
	public Map<String, Integer> codeAnalyze(String filepath, String sourceCodeAnalyzerType, String sourceFileLocation)
			throws IOException {
		SourceCodeAnalyzer analyzer;
		if (sourceCodeAnalyzerType.equals("regex")) {
			analyzer = new RegexAnalyzer(sourceFileLocation);
		} else if (sourceCodeAnalyzerType.equals("strcomp")) {
			analyzer = new StrcompAnalyzer(sourceFileLocation);
		} else {
			throw new IllegalArgumentException("Unknown analyzer type " + sourceCodeAnalyzerType);
		}

		int loc = analyzer.calculateLOC(filepath);
		int nom = analyzer.calculateNOM(filepath);
		int noc = analyzer.calculateNOC(filepath);

		Map<String, Integer> metrics = new HashMap<>();
		metrics.put("loc", loc);
		metrics.put("nom", nom);
		metrics.put("noc", noc);
		return metrics;
	}
}
