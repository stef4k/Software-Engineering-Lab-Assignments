package math;


import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.Assert;
import org.junit.Rule;

public class ArithmeticOperationsTest {
	ArithmeticOperations ar_oper = new ArithmeticOperations();
	
	
	@Test
	public void test_divide_normal() {
		Assert.assertEquals(2.5 , ar_oper.divide(5, 2), 0 );
	}
	
	@Test
	public void test_divide_border() {
		Assert.assertEquals(50 , ar_oper.divide(5, 0.1), 0 );
	}
	
	@Test
	public void test_divide_zero_numerator() {
		Assert.assertEquals(0 , ar_oper.divide(0, 2), 0 );
	}
	
	@Test
	public void test_divide_max_numerator() {
		Assert.assertEquals(Double.MAX_VALUE/5 , ar_oper.divide(Double.MAX_VALUE, 5), 0.5 );
	}
	
	@Test
	public void test_divide_max_denominator() {
		Assert.assertEquals(0 , ar_oper.divide(2, Double.MAX_VALUE), 0.00001 );
	}
	
	@Test(expected = ArithmeticException.class)
	public void test_divide_arithmetic_exception() {
		ar_oper.divide(1, 0);
	}

	@Test
	public void test_multiply_normal() {
		Assert.assertEquals(30 , ar_oper.multiply(10, 3), 0);
	}
	
	@Test
	public void test_multiply_both_zero() {
		Assert.assertEquals(0 , ar_oper.multiply(0, 0), 0);
	}
	
	@Test
	public void test_multiply_first_zero() {
		Assert.assertEquals(0 , ar_oper.multiply(0, 10), 0);
	}
	
	@Test
	public void test_multiply_second_zero() {
		Assert.assertEquals(0 , ar_oper.multiply(58, 0), 0);
	}
	
	@Rule
	public ExpectedException thrown = ExpectedException.none();
	
	@Test
	public void test_multiply_negative_rule_exception() {
		thrown.expect(IllegalArgumentException.class);
		thrown.expectMessage("x & y should be >= 0");
		ar_oper.multiply(5, -1);
	}
	
	@Test
	public void test_multiply_both_negative_rule_exception() {
		thrown.expect(IllegalArgumentException.class);
		thrown.expectMessage("x & y should be >= 0");
		ar_oper.multiply(-500, -1);
	}
	
	@Test
	public void test_multiply_nofit_rule_exception() {
		thrown.expect(IllegalArgumentException.class);
		thrown.expectMessage("The product does not fit in an Integer variable");
		ar_oper.multiply(999999999, 999999999);
	}
	
}
