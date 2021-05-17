package math;

import io.FileIO;
import java.util.Arrays;

/**
 * Class that contains combinations of array operations to be used for unit
 * testing and mocking
 * 
 * @author stef4k
 * @version 1.0
 * @since 2021-04-30
 */
public class ArrayOperations {

	/**
	 * Function that reads a file, creates an array of the integers of that file and
	 * then iterates through it and returns a new array that contains only its prime
	 * numbers.
	 * 
	 * 
	 * @param fileIo,  object to pass file integers to array
	 * @param filepath string, the path of the file to read
	 * @param myMath,  object to find primes
	 * @return int[] that contains prime numbers
	 */
	public int[] findPrimesInFile(FileIO fileIo, String filepath, MyMath myMath) {
		// create array of integers from filepath
		int[] numbers_array;
		numbers_array = fileIo.readFile(filepath);
		int[] prime_array = new int[numbers_array.length];
		int prime_nextIndex = 0;
		// iterate through the array of numbers, find the primes and appends them to the
		// array of primes
		for (int i = 0; i < numbers_array.length; i++)
			if (myMath.isPrime(numbers_array[i])) {
				prime_array[prime_nextIndex] = numbers_array[i];
				prime_nextIndex++;
			}
		// return only the elements that where set in the previous loop
		return Arrays.copyOfRange(prime_array, 0, prime_nextIndex);
	}
}
