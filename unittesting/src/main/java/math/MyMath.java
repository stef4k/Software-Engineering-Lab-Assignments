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
	 * Performs the basic operation of factorial.
	 * 
	 * @param n   the number whose factorial will be calculated
	 * @return the factorial of @param n
	 * @exception IllegalArgumentException when @param n is less than 0 or more than 12
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
