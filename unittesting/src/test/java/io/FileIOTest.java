package io;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class FileIOTest {

	FileIO fileio = new FileIO();
	public static String resourcesPath = "src/test/resources/";

	@Test
	public void test_readfile_valid_input() {
		int[] expectedIntegers = new int[] {1 , 200, -9999, 50, 0, -10};
		String validInputFilepath = resourcesPath.concat("integeres_valid.txt");
		
		Assert.assertArrayEquals(expectedIntegers, fileio.readFile(validInputFilepath));	
	}
	
	@Rule
	public ExpectedException thrown = ExpectedException.none();
	
	@Test
	public void test_readfile_nofile() {
		thrown.expect(IllegalArgumentException.class);
		thrown.expectMessage("Input file does not exist");
		
		String invalidInputFilepath = resourcesPath.concat("nofile_with_this_name.txt");
		fileio.readFile(invalidInputFilepath);
	}
	
	@Test
	public void test_readfile_empty_file() {
		thrown.expect(IllegalArgumentException.class);
		thrown.expectMessage("Given file is empty");
		
		String invalidInputFilepath = resourcesPath.concat("empty_file.txt");
		fileio.readFile(invalidInputFilepath);
	}
	
	@Test
	public void testReadFileContainsInvalidEntries() {
		int[] expectedIntegers = new int[] {-900, 78, 0, 5000};
		String mixedInputFilepath = resourcesPath.concat("invalid_entries.txt");
		
		Assert.assertArrayEquals(expectedIntegers, fileio.readFile(mixedInputFilepath));	
		
	}
	
	

}
