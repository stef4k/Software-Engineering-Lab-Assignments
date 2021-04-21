package math;

/**
* MyMath provides simple arithmetic factorial operations
* that serve as hands-on practice on Unit Testing.
*
* @author  stef4k
* @version 1.0
* @since   2021-04-22 
*/
public class MyMath {

	/**
	 * Performs the basic arithmetic operation of division.
	 * 
	 * @param numerator   the numerator of the operation
	 * @param denominator the denominator of the operation
	 * @return the result of the division between numerator and denominator
	 * @exception ArithmeticException when denominator is zero
	 */
	public int factorial(int n) {
		if (n < 0 || n > 12)
			throw new IllegalArgumentException("Cannot find factorial for particular number");
		int fact = 1;
		for (int i = 1; i <= n; i++) {
			fact = fact * i;
		}
		return fact;
	}

}
