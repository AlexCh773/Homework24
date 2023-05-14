package pro.sky.homework24;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorServiceTest {
    private final CalculatorService out = new CalculatorService();
    private int num1, num2;
    private int num3, num4;
    private int num5, num6;

    @BeforeEach
    public void setup() {
        num1 = 0;
        num2 = 3;
        num3 = 1;
        num4 = -2;
        num5 = 0;
        num6 = -0;
    }

    @Test
    void plus() {
        assertEquals(3, out.plus(num1, num2));
        assertEquals(-1, out.plus(num3, num4));
    }

    @Test
    void minus() {
        assertEquals(-3, out.minus(num1, num2));
        assertEquals(3, out.minus(num3, num4));
    }

    @Test
    void multiply() {
        assertEquals(0, out.multiply(num1, num2));
        assertEquals(-2, out.multiply(num3, num4));
    }

    @Test
    void divide() {
        assertEquals(0, out.divide(num1, num2));
        assertEquals(-0.5, out.divide(num3, num4));
        assertThrows(CalculatorBadParams.class, () -> out.divide(num5, num6));
    }

    public static Stream<Arguments> provideParamsForPlusTest() {
        return Stream.of(
                Arguments.of(1, -3, -2),
                Arguments.of(0, 0, 0),
                Arguments.of(-1, -4, -5));
    }

    @ParameterizedTest
    @MethodSource("provideParamsForPlusTest")
    public void checkPlusOperation(int num1, int num2, int result) {
        assertEquals(result, out.plus(num1, num2));
    }

    public static Stream<Arguments> provideParamsForMinusTest() {
        return Stream.of(
                Arguments.of(1, -3, 4),
                Arguments.of(0, 0, 0),
                Arguments.of(-1, -4, 3));
    }

    @ParameterizedTest
    @MethodSource("provideParamsForMinusTest")
    public void checkMinusOperation(int num1, int num2, int result) {
        assertEquals(result, out.minus(num1, num2));
    }

    public static Stream<Arguments> provideParamsForMultiplyTest() {
        return Stream.of(Arguments.of(1, -3, -3),
                Arguments.of(0, 0, 0),
                Arguments.of(-1, -4, 4));
    }

    @ParameterizedTest
    @MethodSource("provideParamsForMultiplyTest")
    public void checkMultiplyOperation(int num1, int num2, int result) {
        assertEquals(result, out.multiply(num1, num2));
    }

    public static Stream<Arguments> provideParamsForDivideTest() {
        return Stream.of(Arguments.of(1, -1, -1),
                Arguments.of(10, 2, 5),
                Arguments.of(-4, -1, 4));
    }

    @ParameterizedTest
    @MethodSource("provideParamsForDivideTest")
    public void checkDivideOperation(int num1, int num2, int result) {
        assertEquals(result, out.divide(num1, num2));
    }
}