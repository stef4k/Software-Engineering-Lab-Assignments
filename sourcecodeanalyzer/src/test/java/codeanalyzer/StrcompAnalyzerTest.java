package codeanalyzer;

import java.io.IOException;
import org.junit.Test;

import static org.junit.Assert.*;

public class StrcompAnalyzerTest {

	private final static String TEST_CLASS = "src/test/resources/TestClass.java";
	private StrcompAnalyzer sca = new StrcompAnalyzer("local");
	
	

	@Test
	public void testCalculateStrCompLOC() throws IOException {
		assertEquals(7, sca.calculateLOC(TEST_CLASS));
	}
	
	@Test
	public void testCalculateStrCompNOM() throws IOException {
		assertEquals(3, sca.calculateNOM(TEST_CLASS));
	}
	
	@Test
	public void testCalculateStrCompNOC() throws IOException {
		assertEquals(3, sca.calculateNOC(TEST_CLASS));
	}
	
}