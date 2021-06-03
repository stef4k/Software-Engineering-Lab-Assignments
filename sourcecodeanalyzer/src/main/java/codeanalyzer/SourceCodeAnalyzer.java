package codeanalyzer;

import java.io.IOException;

public abstract class SourceCodeAnalyzer {
	private SourceFileReader fileReader;

	public SourceCodeAnalyzer(){
	}
	
	public SourceCodeAnalyzer(String type) {
		if (type == "web") {
			fileReader = new WebFileReader();
		} else if (type == "local") {
			fileReader = new LocalFileReader();
		} else {
			fileReader = null;
		}
	}
	

	public SourceFileReader getFileReader() {
		return fileReader;
	}

	public abstract int calculateLOC(String filepath) throws IOException;

	public abstract int calculateNOM(String filepath) throws IOException;

	public abstract int calculateNOC(String filepath) throws IOException;

}