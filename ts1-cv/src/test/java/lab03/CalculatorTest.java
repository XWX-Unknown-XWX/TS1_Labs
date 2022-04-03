package lab03;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

public class CalculatorTest {
    Calculator calculator = new Calculator();

    @Test
    @Order(1)
    @DisplayName("Testing if Null implementation")
    public void test_ifClassIsZero() {
        Assertions.assertNotNull(calculator, "Checking if class is null");
    }

    @Test
    @Order(2)
    @DisplayName("Testing adding numbers")
    public void addTest_Nine_AddTwoNum() {
        assertEquals(9, calculator.add(4, 5), "Checking adding between two num");
    }

    @Test
    @Order(3)
    @DisplayName("Testing subtracting numbers")
    public void subtractTest_MinusTwoNum() {
        assertEquals(2, calculator.subtract(6, 4), "Checking subtraction between two num");
    }

    @Test
    @Order(4)
    @DisplayName("Testing multiplying numbers")
    public void multiplyTest_MultiplyTwoNum() {
        assertEquals(25, calculator.multiply(5, 5), "Checking multiply between two num");
    }

    @Test
    @Order(5)
    @DisplayName("Testing dividing numbers")
    public void divideTest_DivideTwoNum() {
        assertEquals(2, calculator.divide(8, 4), "Checking dividing between two num");
        assertEquals(0, calculator.divide(0, 4), "Checking dividing by zero num");
    }

    @Test
    @Order(6)
    @DisplayName("Testing with zero")
    public void zeroChecking_ZeroNum_Multiply() {
        assertEquals(0, calculator.multiply(0, 100), "Testing for checking zero num");
    }

    @Test
    @Order(7)
    @DisplayName("Testing with neg number")
    public void testingAll_negativeNumbers() {
        assertEquals(-1, calculator.add(-20, 19));
        assertEquals(-1, calculator.multiply(-1, 1));
        assertEquals(-1, calculator.divide(-3, 3));
        assertEquals(-3, calculator.subtract(5, 8));
    }

    @Test
    @Order(8)
    @DisplayName("Testing adding disable exception")
    @Disabled("Adding exception should be fixed and been enabled")
    public void testingForExceptionAdd() {
        assertEquals(10, calculator.add(10, 20));
    }

    @Test
    @DisplayName("Testing dividing by zero exception")
    public void testingDivideByZeroNum() {
        assertThrows(ArithmeticException.class, () -> calculator.divide(1, 0), "Dividing by zero exception");
    }
}
