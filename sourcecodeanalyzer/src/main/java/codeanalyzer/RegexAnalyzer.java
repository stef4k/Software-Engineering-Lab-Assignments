package codeanalyzer;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Analyzes the contents of a Java source code file and calculates the following
 * metrics: loc = lines of code, nom = number of methods, and noc=number of
 * classes with regex way (with the use of regular expressions).
 * 
 * @author stef4k
 *
 */
public class RegexAnalyzer extends SourceCodeAnalyzer {

	public RegexAnalyzer(String type) {
		super(type);
	}

	@Override
	public int calculateLOC(String filepath) throws IOException {
		String sourceCode = getFileReader().readFileIntoString(filepath);
		Pattern pattern = Pattern.compile("((//.*)|(/\\*.*)|(\\*+.*))");
		Matcher nonCodeLinesMatcher = pattern.matcher(sourceCode);

		int nonCodeLinesCounter = 0;
		while (nonCodeLinesMatcher.find()) {
			nonCodeLinesCounter++;
		}

		int sourceFileLength = sourceCode.split("\n").length;
		int loc = sourceFileLength - nonCodeLinesCounter;

		return loc;
	}

	@Override
	public int calculateNOM(String filepath) throws IOException {
		String sourceCode = getFileReader().readFileIntoString(filepath);
		Pattern pattern = Pattern.compile(
				".*(public |protected |private |static )?[\\w\\<\\>\\[\\]]+\\s+(\\w+) *\\([^\\)]*\\) *(\\{?|[^;]).*");
		Matcher methodSignatures = pattern.matcher(sourceCode);

		int methodCounter = 0;
		while (methodSignatures.find()) {
			methodCounter++;
		}
		return methodCounter;
	}

	@Override
	public int calculateNOC(String filepath) throws IOException {
		String sourceCode = getFileReader().readFileIntoString(filepath);
		Pattern pattern = Pattern.compile(".*\\s*class\\s+.*");
		Matcher classSignatures = pattern.matcher(sourceCode);

		int classCounter = 0;
		while (classSignatures.find()) {
			classCounter++;
		}
		return classCounter;
	}

}
