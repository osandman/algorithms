package searching;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;
import static searching.BinSearch.*;


class BinSearchTest {
    static int[] numbers = {-2, 0, 1, 4, 7, 12, 58, 123, 35456};
    static int[] zeroArr = {};
    static int[] oneElementArr = {-2};
    static int[] twoElementsArr = {-2, 2};

    private static int[] targetNums() {
        return numbers;
    }

    private static int[][] targetArrays() {
        int[][] res = {numbers, oneElementArr, twoElementsArr};
        return res;
    }

    @DisplayName("Проверка обоих методов бинарного поиска разными массивами")
    @ParameterizedTest
    @MethodSource({"targetArrays"})
    public void binSearchTest(int[] arrays) {
        assertEquals(0, binRecursiveSearch(arrays, -2));
        assertEquals(0, binCycleSearch(arrays, -2));
        assertEquals(-1, binRecursiveSearch(arrays, 3));
        assertEquals(-1, binCycleSearch(arrays, 3));
    }

    @DisplayName("Проверка обоих методов бинарного поиска пустым массивом")
    @Test
    public void binSearchZeroArrayTest() {
        assertEquals(-1, binCycleSearch(zeroArr, 0), "циклический метод");
        assertEquals(-1, binRecursiveSearch(zeroArr, 0), "рекурсивный метод");
    }

    @DisplayName("Проверка двух методов бинарного поиска")
    @ParameterizedTest
    @MethodSource({"targetNums"})
    public void binRecursiveSearchTest(int target) {
        assertEquals(Arrays.binarySearch(numbers, target), binRecursiveSearch(numbers, target));
        assertEquals(Arrays.binarySearch(numbers, target), binCycleSearch(numbers, target));
    }

    @DisplayName("Проверка двух методов бинарного поиска, отсутствуют элементы")
    @ParameterizedTest
    @ValueSource(ints = {5, 120, 146236})
    public void binSearchNotContainedTest(int target) {
        assertEquals(-1, binRecursiveSearch(numbers, target));
        assertEquals(-1, binCycleSearch(numbers, target));
    }
}