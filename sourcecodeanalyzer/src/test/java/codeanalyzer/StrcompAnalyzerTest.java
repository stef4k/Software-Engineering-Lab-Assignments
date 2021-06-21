package codeanalyzer;

import java.io.IOException;
import org.junit.Test;

import static org.junit.Assert.*;

public class StrcompAnalyzerTest {

	private final static String TEST_CLASS_WEB = "https://drive.google.com/uc?export=download&id=1z51FZXqPyun4oeB7ERFlOgfcoDfLLLhg";
	private final static String TEST_CLASS_LOCAL = "src/test/resources/TestClass.java";
	private StrcompAnalyzer sca = new StrcompAnalyzer("local");
	private StrcompAnalyzer wca = new StrcompAnalyzer("web");

	@Test
	public void testCalculateStrCompLOCLocal() throws IOException {
		assertEquals(7, sca.calculateLOC(TEST_CLASS_LOCAL));
	}

	@Test
	public void testCalculateStrCompNOMLocal() throws IOException {
		assertEquals(3, sca.calculateNOM(TEST_CLASS_LOCAL));
	}

	@Test
	public void testCalculateStrCompNOCLocal() throws IOException {
		assertEquals(3, sca.calculateNOC(TEST_CLASS_LOCAL));
	}

	@Test
	public void testCalculateStrCompLOCWeb() throws IOException {
		assertEquals(7, wca.calculateLOC(TEST_CLASS_WEB));
	}

	@Test
	public void testCalculateStrCompNOMWeb() throws IOException {
		assertEquals(3, wca.calculateNOM(TEST_CLASS_WEB));
	}

	@Test
	public void testCalculateStrCompNOCWeb() throws IOException {
		assertEquals(3, wca.calculateNOC(TEST_CLASS_WEB));
	}
	
	@Test
	public void testStrcompNullFileReader() {
		StrcompAnalyzer test_object = new StrcompAnalyzer("inexistant file reader");
		assertEquals(null, test_object.getFileReader());
	}
	

}