package stringcalc;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class StringCalculatorTest {

	private StringCalculator calc;

	@Before
	public void setUp() throws Exception {
		calc = new StringCalculator();
	}

	@Test
	public void addReturnsZeroForEmptyString() {
		assertEquals(0, calc.add("")); 
	}
	
	@Test
	public void addCanSumOneNumber() {
		assertEquals(10, calc.add("10"));
	}

}