package codeanalyzer;


import java.io.File;
import java.io.IOException;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class FacadeTest {
	private final static String TEST_CLASS_LOCAL = "src/test/resources/TestClass.java";
	private final static String sourceCodeAnalyzerType = "regex";
	private final static String sourceFileLocation = "local";
	private final static String outputFilePath = "output_metrics_test";

	@Rule
	public ExpectedException thrown = ExpectedException.none();
	
	@Test
	public void testFacadeIllegalArgumentException() throws IOException {
		thrown.expect(IllegalArgumentException.class);
		thrown.expectMessage("Unknown output file type " + "unknown_type");
		Facade test_object = new Facade();
		test_object.execute_metrics(TEST_CLASS_LOCAL, sourceCodeAnalyzerType, sourceFileLocation, outputFilePath,
				"unknown_type");
	}
	
	
	@Test
	public void testFacadeIllegalArgumentExceptionJson() throws IOException {
		thrown.expect(IllegalArgumentException.class);
		thrown.expectMessage("Json not implemented yet");
		Facade test_object = new Facade();
		test_object.execute_metrics(TEST_CLASS_LOCAL, sourceCodeAnalyzerType, sourceFileLocation, outputFilePath,
				"json");
	}
	
	@Test
	public void testFacadeCsv() throws IOException {
		Facade test_object = new Facade();
		test_object.execute_metrics(TEST_CLASS_LOCAL, sourceCodeAnalyzerType, sourceFileLocation, outputFilePath,
				"csv");
		File outputFile = new File(outputFilePath + ".csv");
		Assert.assertTrue(outputFile.exists());
		// delete the generated file
		outputFile.delete();
	}
	
	

}
