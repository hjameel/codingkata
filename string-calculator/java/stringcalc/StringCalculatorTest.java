package stringcalc;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class StringCalculatorTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void addReturnsZeroForEmptyString() {
		StringCalculator calc = new StringCalculator();
		assertEquals(0, calc.add("")); 
	}

}
