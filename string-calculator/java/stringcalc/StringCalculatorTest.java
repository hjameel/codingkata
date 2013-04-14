package stringcalc;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class StringCalculatorTest {
	
	private static final String EMPTY = "";

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
		assertEquals(10, calc.add("10"));
	}
	
	@Test
	public void addCanSumTwoNumbers() {
		assertEquals(20, calc.add("10, 10"));
	}
	
	@Test
	public void addCanSumManyNumbers() {
		assertEquals(30, calc.add("10, 10, 10"));
		assertEquals(50, calc.add("10, 10, 5, 0, 25"));
	}
	
	@Test
	public void sumsNumbersDelimitedByNewlines() {
		assertEquals(30, calc.add("10\n10,10"));
	}
	
	@Test
	public void sumsNumbersSeparatedByCustomDelimiter() {
		assertEquals(3, calc.add("//;\n1;2"));
	}

}