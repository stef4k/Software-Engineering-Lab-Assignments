package codeanalyzer;

import static org.junit.Assert.*;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.junit.Test;
import static org.hamcrest.CoreMatchers.is;

public class FactoryAnalyzerTest {
	private final static String TEST_CLASS_LOCAL = "src/main/resources/TestClass.java";

	@Test(expected = IllegalArgumentException.class)
	public void testFactoryAnalyzerException() throws IOException {
		FactoryAnalyzer test_object = new FactoryAnalyzer();
		test_object.codeAnalyze("string", "wrong analyzer type", "location");
	}

	@Test
	public void testFactoryAnalyzerRegex() throws IOException {
		FactoryAnalyzer test_object = new FactoryAnalyzer();
		Map<String, Integer> test_metrics = test_object.codeAnalyze(TEST_CLASS_LOCAL, "regex", "local");

		Map<String, Integer> metrics = new HashMap<>();
		metrics.put("loc", 21);
		metrics.put("nom", 3);
		metrics.put("noc", 3);
		assertThat(test_metrics, is(metrics));
	}

	@Test
	public void testFactoryAnalyzerStrcomp() throws IOException {
		FactoryAnalyzer test_object = new FactoryAnalyzer();
		Map<String, Integer> test_metrics = test_object.codeAnalyze(TEST_CLASS_LOCAL, "strcomp", "local");

		Map<String, Integer> metrics = new HashMap<>();
		metrics.put("loc", 7);
		metrics.put("nom", 3);
		metrics.put("noc", 3);
		assertThat(test_metrics, is(metrics));
	}
}
