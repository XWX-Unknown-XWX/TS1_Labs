package lab01;

import lab01.Math;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MathTest {
    @Test
    public void factorialTest1() {
        assertEquals(Math.factorialRecursive(3), 6);
        assertEquals(Math.factorialIterative(3), 6);
    }
}