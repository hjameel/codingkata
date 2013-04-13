package stringcalc;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class StringCalculatorTest {
	
	private static final String EMPTY = "";
	private static final String TEN = "10";

	private StringCalculator calc;

	@Before
	public void setUp() throws Exception {
		calc = new StringCalculator();
	}

	@Test
	public void addReturnsZeroForEmptyString() {
		assertEquals(0, calc.add(EMPTY)); 
	}
	
	@Test
	public void addCanSumOneNumber() {
		assertEquals(10, calc.add(TEN));
	}
	
	@Test
	public void addCanSumTwoNumbers() {
		assertEquals(20, calc.add("10, 10"));
	}

}