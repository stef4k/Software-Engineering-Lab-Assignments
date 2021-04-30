package math;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class MyMathTest {
	MyMath mymath = new MyMath();
	
	@Test
	public void test_factorial_normal() {
		Assert.assertEquals(5*4*3*2 , mymath.factorial(5), 0 );
	}
	
	@Rule
	public ExpectedException thrown = ExpectedException.none();
	
	@Test
	public void test_factorial_negative_number_exception() {
		thrown.expect(IllegalArgumentException.class);
		thrown.expectMessage("Cannot find factorial for negative number");
		mymath.factorial(-1);
	}
	
	@Test
	public void test_multiply_high_positive_number_exception() {
		thrown.expect(IllegalArgumentException.class);
		thrown.expectMessage("Cannot find factorial for high positive number");
		mymath.factorial(13);
	}
	
	@Test
	public void test_prime_2_true() {
		Assert.assertTrue(mymath.isPrime(2));
	}
	
	@Test
	public void test_prime_997_true() {
		Assert.assertTrue(mymath.isPrime(997));
	}
	
	@Test
	public void test_prime_6_false() {
		Assert.assertFalse(mymath.isPrime(6));
	}
	
	@Test
	public void test_prime_999_false() {
		Assert.assertFalse(mymath.isPrime(999));
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void test_prime_positive_illegal_arg_exception() {
		mymath.isPrime(1);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void test_prime_negative_illegal_arg_exception() {
		mymath.isPrime(-100);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void test_prime_zero_illegal_arg_exception() {
		mymath.isPrime(0);
	}
	
}
