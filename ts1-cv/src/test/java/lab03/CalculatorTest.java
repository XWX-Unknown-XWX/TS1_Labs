package lab03;

import org.junit.jupiter.api.*;

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
        Assertions.assertEquals(9, calculator.add(4, 5), "Checking adding between two num");
    }

    @Test
    @Order(3)
    @DisplayName("Testing subtracting numbers")
    public void subtractTest_MinusTwoNum() {
        Assertions.assertEquals(2, calculator.subtract(6, 4), "Checking subtraction between two num");
    }

    @Test
    @Order(4)
    @DisplayName("Testing multiplying numbers")
    public void multiplyTest_MultiplyTwoNum() {
        Assertions.assertEquals(25, calculator.multiply(5, 5), "Checking multiply between two num");
    }

    @Test
    @Order(5)
    @DisplayName("Testing dividing numbers")
    public void divideTest_DivideTwoNum() {
        Assertions.assertEquals(2, calculator.divide(8, 4), "Checking dividing between two num");
    }

    @Test
    @Order(6)
    @DisplayName("Testing with zero")
    public void zeroChecking_ZeroNum_Multiply() {
        Assertions.assertEquals(0, calculator.multiply(0, 100), "Testing for checking zero num");
    }

    @Test
    @Order(7)
    @DisplayName("Testing with neg number")
    public void testingAll_negativeNumbers() {
        Assertions.assertEquals(-1, calculator.add(-20, 19));
        Assertions.assertEquals(-1, calculator.multiply(-1, 1));
        Assertions.assertEquals(-1, calculator.divide(-3, 3));
        Assertions.assertEquals(-3, calculator.subtract(5, 8));
    }

    @Test
    @Order(8)
    @DisplayName("Testing adding disable exception")
    @Disabled("Adding should be fixed and been enabled")
    public void testingForException() {
        Assertions.assertEquals(10, calculator.add(10, 20));
    }
}
