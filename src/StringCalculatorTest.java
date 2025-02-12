
import org.junit.jupiter.api.Assertions;

import static org.junit.Assert.assertEquals;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
public class StringCalculatorTest {

    private final StringCalculator calculator = new StringCalculator();

    @Test
    public void testEmptyString() {
        assertEquals(0, calculator.Add(""));
    }

    @Test
    public void testSingleNumber() {
        assertEquals(1, calculator.Add("1"));
    }

    @Test
    public void testTwoNumbers() {
        assertEquals(3, calculator.Add("1,2"));
    }

    @Test
    public void testMultipleNumbers() {
        assertEquals(6, calculator.Add("1,2,3"));
    }

    @Test
    public void testNewLineDelimiter() {
        assertEquals(6, calculator.Add("1\n2,3"));
    }

    @Test
    public void testCustomDelimiter() {
        assertEquals(3, calculator.Add("//;\n1;2"));
    }


    @Test
    public void testIgnoreNumbersGreaterThan1000() {
        assertEquals(2, calculator.Add("2,1001"));
    }

    @Test
    public void testNegativeNumberThrowsException() {
        IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> calculator.Add("1,-2"));
    }

    @Test
    public void testMultipleNegativeNumbers() {
        IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> calculator.Add("1,-2,-3"));
    }
}
