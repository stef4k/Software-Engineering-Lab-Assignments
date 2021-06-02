package codeanalyzer;

import java.io.IOException;

public class NullAnalyzer extends SourceCodeAnalyzer{
	public NullAnalyzer(String type) {
		super(type);
	}
	
	public int calculateLOC(String filepath, String analyzerType) throws IOException{
		return -1;
	}
	
	public int calculateNOM(String filepath, String analyzerType) throws IOException{
		return -1;
	}
	
	public int calculateNOC(String filepath, String analyzerType) throws IOException{
		return -1;
	}

}
