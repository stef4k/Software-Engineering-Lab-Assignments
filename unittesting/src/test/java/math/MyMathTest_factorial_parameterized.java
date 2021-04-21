package math;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class MyMathTest_factorial_parameterized {
	@Parameter(value = 0)
	public int number;
	@Parameter(value = 1)
	public int result;

	MyMath mymath = new MyMath();

	@Parameters
	public static Collection<Object> data() {
		Object[] data = new Object[][] { { 0, 1 }, { 1, 1 }, { 2, 2 }, { 12, 479001600 } };
		return Arrays.asList(data);
	}

	@Test
	public void test_factorial() {
		Assert.assertEquals(result, mymath.factorial(number));
	}
}
