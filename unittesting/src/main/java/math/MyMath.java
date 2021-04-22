package math;

/**
 * MyMath provides simple arithmetic factorial operations that serve as hands-on
 * practice on Unit Testing.
 *
 * @author stef4k
 * @version 1.0
 * @since 2021-04-22
 */
public class MyMath {

	/**
	 * Performs the basic operation of factorial.
	 * 
	 * @param n the number whose factorial will be calculated
	 * @return the factorial of @param n
	 * @exception IllegalArgumentException when @param n is less than 0 or more than
	 *                                     12
	 */
	public int factorial(int n) {
		// Different Exception messages for negative and high positive numbers
		if (n < 0) {
			throw new IllegalArgumentException("Cannot find factorial for negative number");
		} else if (n > 12) {
			throw new IllegalArgumentException("Cannot find factorial for high positive number");
		}
		// Calculating the factorial
		int fact = 1;
		for (int i = 1; i <= n; i++) {
			fact = fact * i;
		}
		return fact;
	}

}
