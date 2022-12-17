package math;

import static java.lang.Math.*;
import static org.junit.jupiter.api.Assertions.*;

import math.nod.Nod;
import math.sqrt.Sqrt;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

@TestMethodOrder(MethodOrderer.MethodName.class)
public class MathTest {

    private static Stream<Arguments> gcdArguments() {
        return Stream.of(
                Arguments.of(3, 21, 3),
                Arguments.of(21, 3, 3),
                Arguments.of(5, 17, 1),
                Arguments.of(0, 0, 0),
                Arguments.of(1, 1, 1),
                Arguments.of(1, 0, 1),
                Arguments.of(-5, 25, 5),
                Arguments.of(77, -7, 7),
                Arguments.of(-133, -56, 7)
        );
    }

    @DisplayName("Проверка вычисления НОД рекурсивным методом")
    @ParameterizedTest(name = "{index}) => a={0}, b={1}, res={2}")
    @MethodSource("gcdArguments")
    public void recursiveGCDTest(int a, int b, int res) {
        assertEquals(res, Nod.recursiveGCD(a, b));
    }

    @DisplayName("Проверка вычисления НОД методом Евклида")
    @ParameterizedTest(name = "{index}) => a={0}, b={1}, res={2}")
    @MethodSource("gcdArguments")
    public void euclidGCDTest(int a, int b, int res) {
        assertEquals(res, Nod.euclidGCD(a, b));
    }

    @DisplayName("Проверка вычисления квадратного корня методом бинарного поиска")
    @ParameterizedTest
    @CsvSource(value = {
            "0,0", "1,1", "64,8", "500,22", "152399025,12345"
    })
    public void sqrtBinaryTest(long num, long res) {
        assertEquals(res, Sqrt.calculateSqrtBinarySearch(num));
    }

    @DisplayName("Проверка вычисления квадратного корня методом бинарного поиска с округлением")
    @Test
    public void sqrtBinaryTestApproximately() {
        assertEquals(floor(sqrt(555) * 10) / 10, Sqrt.calculateSqrtBinarySearch(555), 1e1);
    }

    @DisplayName("Проверка вычисления квадратного корня методом перебора")
    @ParameterizedTest
    @CsvSource(value = {
            "0,0", "1,1", "64,8", "500,22", "152399025,12345"
    })
    public void sqrtDecrementTest(long num, long res) {
        assertEquals(res, Sqrt.calculateSqrtDecrement(num));
    }

}
