import calculator.Scientific_Calculator;
import static org.junit.Assert.*;
import org.junit.Test;

public class Calculator_Test {
    private static final double DELTA = 1e-10;
    Scientific_Calculator calculator = new Scientific_Calculator();

    @Test
    public void factorialCorrect(){
        assertEquals("factorial of a number for Correct Output", 120, calculator.factorial(5), DELTA);
        assertEquals("factorial of a number for Correct Output", 24, calculator.factorial(4), DELTA);
        assertEquals("factorial of a number for Correct Output", 6, calculator.factorial(3), DELTA);
    }

    @Test
    public void factorialWrong(){
        assertNotEquals("factorial of a number for Wrong Output", 119, calculator.factorial(5), DELTA);
        assertNotEquals("factorial of a number for Wrong Output", 25, calculator.factorial(4), DELTA);
        assertNotEquals("factorial of a number for Wrong Output", 9, calculator.factorial(3), DELTA);
    }

    @Test
    public void powerCorrect(){
        assertEquals("power for Correct Output", 5, calculator.power(5, 1), DELTA);
        assertEquals("power for Correct Output", 16, calculator.power(4, 2), DELTA);
        assertEquals("power for Correct Output", 27, calculator.power(3, 3), DELTA);
    }

    @Test
    public void powerWrong(){
        assertNotEquals("power for Wrong Output", 6, calculator.power(5, 1), DELTA);
        assertNotEquals("power for Wrong Output", 90, calculator.power(4, 2), DELTA);
        assertNotEquals("power for Wrong Output", -9, calculator.power(3, 3), DELTA);
    }

    @Test
    public void logCorrect(){
        assertEquals("natural log for Correct Output", 1.6094379124341003, calculator.naturalLog(5), DELTA);
        assertEquals("natural log for Correct Output", 1.3862943611198906, calculator.naturalLog(4), DELTA);
        assertEquals("natural log for Correct Output", 1.0986122886681098, calculator.naturalLog(3), DELTA);
    }

    @Test
    public void logWrong(){
        assertNotEquals("natural log for Wrong Output", 0, calculator.naturalLog(5), DELTA);
        assertNotEquals("natural log for Wrong Output", 7, calculator.naturalLog(4), DELTA);
        assertNotEquals("natural log for Wrong Output", 4, calculator.naturalLog(3), DELTA);
    }

    @Test
    public void squareRootCorrect(){
        assertEquals("square root for Correct Output", 5, calculator.squareRoot(25), DELTA);
        assertEquals("square root for Correct Output", 4, calculator.squareRoot(16), DELTA);
        assertEquals("square root for Correct Output", 3, calculator.squareRoot(9), DELTA);
    }

    @Test
    public void squareRootWrong(){
        assertNotEquals("square root for Wrong Output", 3, calculator.squareRoot(25), DELTA);
        assertNotEquals("square root for Wrong Output", 2, calculator.squareRoot(16), DELTA);
        assertNotEquals("square root for Wrong Output", 5, calculator.squareRoot(9), DELTA);
    }


}
