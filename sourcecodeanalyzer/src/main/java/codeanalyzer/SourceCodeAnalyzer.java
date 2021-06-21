package codeanalyzer;

import java.io.IOException;

/**
 * Abstract classs to analyze the contents of a Java source code file
 * 
 * @author stef4k
 *
 */
public abstract class SourceCodeAnalyzer {
	private SourceFileReader fileReader;

	public SourceCodeAnalyzer(String type) {
		if (type.equals("web")) {
			fileReader = new WebFileReader();
		} else if (type.equals("local")) {
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