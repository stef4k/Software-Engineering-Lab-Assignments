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
}
