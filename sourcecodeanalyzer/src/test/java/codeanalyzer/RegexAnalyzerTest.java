package codeanalyzer;

import java.io.IOException;
import org.junit.Test;

import static org.junit.Assert.*;

public class RegexAnalyzerTest {
	private final static String TEST_CLASS_LOCAL = "src/test/resources/TestClass.java";
	private final static String TEST_CLASS_WEB = "https://drive.google.com/uc?export=download&id=1z51FZXqPyun4oeB7ERFlOgfcoDfLLLhg";
	private RegexAnalyzer sca = new RegexAnalyzer("local");
	private RegexAnalyzer wca = new RegexAnalyzer("web");

	@Test
	public void testCalculateRegexLOCLocal() throws IOException {
		assertEquals(21, sca.calculateLOC(TEST_CLASS_LOCAL));
	}

	@Test
	public void testCalculateRegexNOMLocal() throws IOException {
		assertEquals(3, sca.calculateNOM(TEST_CLASS_LOCAL));
	}

	@Test
	public void testCalculateRegexNOCLocal() throws IOException {
		assertEquals(3, sca.calculateNOC(TEST_CLASS_LOCAL));
	}

	@Test
	public void testCalculateRegexLOCWeb() throws IOException {
		assertEquals(21, wca.calculateLOC(TEST_CLASS_WEB));
	}

	@Test
	public void testCalculateRegexNOMWeb() throws IOException {
		assertEquals(3, wca.calculateNOM(TEST_CLASS_WEB));
	}

	@Test
	public void testCalculateRegexNOCWeb() throws IOException {
		assertEquals(3, wca.calculateNOC(TEST_CLASS_WEB));
	}
	
	@Test
	public void testRegexNullFileReader() {
		StrcompAnalyzer test_object = new StrcompAnalyzer("inexistant file reader");
		assertEquals(null, test_object.getFileReader());
	}
	

}