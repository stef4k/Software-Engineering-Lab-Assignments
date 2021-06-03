package codeanalyzer;

import java.io.IOException;
import org.junit.Test;

import static org.junit.Assert.*;

public class RegexAnalyzerTest {
	private final static String TEST_CLASS = "src/test/resources/TestClass.java";
	private RegexAnalyzer sca = new RegexAnalyzer("local");
	
	
	@Test
	public void testCalculateRegexLOC() throws IOException {
		assertEquals(21, sca.calculateLOC(TEST_CLASS));
	}
	
	@Test
	public void testCalculateRegexNOM() throws IOException {
		assertEquals(3, sca.calculateNOM(TEST_CLASS));
	}
	
	@Test
	public void testCalculateRegexNOC() throws IOException {
		assertEquals(3, sca.calculateNOC(TEST_CLASS));
	}

	
}