package math;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import org.junit.Assert;
import org.junit.Test;

import io.FileIO;

public class ArrayOperationsTest {

	ArrayOperations array_op = new ArrayOperations();
	FileIO fileio = new FileIO();
	MyMath mymath = new MyMath();
	public static String resourcesPath = "src/test/resources/";
	

	@Test
	public void test_findPrimesInFile_Mocking() {
		String mixedInputFilepath = resourcesPath.concat("mixed_input.txt");

		// Mock the ArrayOperations dependency
		FileIO fio_mock = mock(FileIO.class);
		when(fio_mock.readFile(mixedInputFilepath))
				.thenReturn(new int[] { 4, 5, 19, 34, 11, 58, 59, 73, 320, 997, 97 });

		MyMath mm_mock = mock(MyMath.class);
		when(mm_mock.isPrime(4)).thenReturn(false);
		when(mm_mock.isPrime(5)).thenReturn(true);
		when(mm_mock.isPrime(19)).thenReturn(true);
		when(mm_mock.isPrime(34)).thenReturn(false);
		when(mm_mock.isPrime(11)).thenReturn(true);
		when(mm_mock.isPrime(58)).thenReturn(false);
		when(mm_mock.isPrime(59)).thenReturn(true);
		when(mm_mock.isPrime(73)).thenReturn(true);
		when(mm_mock.isPrime(320)).thenReturn(false);
		when(mm_mock.isPrime(997)).thenReturn(true);
		when(mm_mock.isPrime(97)).thenReturn(true);

		int[] expectedprimes = new int[] { 5, 19, 11, 59, 73, 997, 97 };
		Assert.assertArrayEquals(expectedprimes, array_op.findPrimesInFile(fileio, mixedInputFilepath, mymath));
	}

}
