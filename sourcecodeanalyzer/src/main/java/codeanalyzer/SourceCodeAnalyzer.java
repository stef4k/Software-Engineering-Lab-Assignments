package codeanalyzer;

import java.io.IOException;

public interface SourceCodeAnalyzer {
	public int calculateLOC(String filepath, String analyzerType) throws IOException;
	public int calculateNOM(String filepath, String analyzerType) throws IOException;
	public int calculateNOC(String filepath, String analyzerType) throws IOException;
	
}