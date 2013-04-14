package stringcalc;

import static org.junit.Assert.*;
import static org.junit.matchers.JUnitMatchers.*;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class StringCalculatorTest {

    private static final String EMPTY = "";

    private StringCalculator calc;

    @Before
    public void setUp() throws Exception {
        calc = new StringCalculator();
    }

    @Test
    public void addReturnsZeroForEmptyString() throws Exception {
        assertEquals(0, calc.add(EMPTY));
    }

    @Test
    public void addCanSumOneNumber() throws Exception {
        assertEquals(10, calc.add("10"));
    }

    @Test
    public void addCanSumTwoNumbers() throws Exception {
        assertEquals(20, calc.add("10, 10"));
    }

    @Test
    public void addCanSumManyNumbers() throws Exception {
        assertEquals(30, calc.add("10, 10, 10"));
        assertEquals(50, calc.add("10, 10, 5, 0, 25"));
    }

    @Test
    public void sumsNumbersDelimitedByNewlines() throws Exception {
        assertEquals(30, calc.add("10\n10,10"));
    }

    @Test
    public void sumsNumbersSeparatedByCustomDelimiter() throws Exception {
        assertEquals(3, calc.add("//;\n1;2"));
    }

    @Rule
    public ExpectedException exception = ExpectedException.none();

    @Test
    public void throwsAnExceptionWhenAttemptingToAddNegativeNumbers()
            throws Exception {
        String negative = "-10";
        
        exception.expect(Exception.class);
        exception.expectMessage(containsString("negatives not allowed"));
        exception.expectMessage(containsString(negative));
        
        calc.add(negative);
    }

}