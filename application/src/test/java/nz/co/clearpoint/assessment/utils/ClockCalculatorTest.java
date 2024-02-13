package nz.co.clearpoint.assessment.utils;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class ClockCalculatorTest {
    private ClockCalculator calculator;

    @Before
    public void setup() {
        this.calculator = new ClockCalculator();
    }

    @Test(expected = IllegalArgumentException.class)
    public void testClockeWithNullInput() {
        this.calculator.clocke(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testClockeWithInvalidInput() {
        this.calculator.clocke("123");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testClockeWithNonNumber() {
        this.calculator.clocke("abcd");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testClockeWithInvalidHours() {
        this.calculator.clocke("2430");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testClockeWithInvalidMinutes() {
        this.calculator.clocke("1681");
    }

    @Test
    public void testClockeWithMultipleCases() {
        String actual = this.calculator.clocke("1230");
        assertEquals("165", actual);

        actual = this.calculator.clocke("0245");
        assertEquals("187.5", actual);

        actual = this.calculator.clocke("1445");
        assertEquals("187.5", actual);

        actual = this.calculator.clocke("1754");
        assertEquals("147", actual);

        actual = this.calculator.clocke("1710");
        assertEquals("265", actual);

        actual = this.calculator.clocke("1200");
        assertEquals("0", actual);

        actual = this.calculator.clocke("0051");
        assertEquals("280.5", actual);

        actual = this.calculator.clocke("0000");
        assertEquals("0", actual);

        actual = this.calculator.clocke("0001");
        assertEquals("5.5", actual);

        actual = this.calculator.clocke("0100");
        assertEquals("330", actual);

        actual = this.calculator.clocke("0101");
        assertEquals("335.5", actual);

        actual = this.calculator.clocke("2359");
        assertEquals("354.5", actual);
    }
}
