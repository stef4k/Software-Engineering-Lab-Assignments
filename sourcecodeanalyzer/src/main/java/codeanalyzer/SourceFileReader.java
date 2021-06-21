package codeanalyzer;

import java.io.IOException;
import java.util.List;

public interface SourceFileReader {
	public String readFileIntoString(String filepath) throws IOException;

	public List<String> readFileIntoList(String filepath) throws IOException;

}
