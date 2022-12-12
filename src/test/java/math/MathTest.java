package math;

import static org.junit.jupiter.api.Assertions.assertEquals;

import math.nod.Nod;
import math.sqrt.Sqrt;
import org.junit.jupiter.api.Test;

public class MathTest {
    @Test
    public void recursiveNODTest() {
        assertEquals(3, Nod.recursiveGCD(3, 21));
        assertEquals(3, Nod.recursiveGCD(21, 3));
        assertEquals(1, Nod.recursiveGCD(1, 17));
        assertEquals(1, Nod.recursiveGCD(17, 1));
        assertEquals(0, Nod.recursiveGCD(0, 0));
        assertEquals(1, Nod.recursiveGCD(1, 1));
        assertEquals(1, Nod.recursiveGCD(0, 1));
        assertEquals(5, Nod.recursiveGCD(-5, 25));
        assertEquals(5, Nod.recursiveGCD(-5, -25));
        assertEquals(5, Nod.recursiveGCD(5, -25));
    }

    @Test
    public void NODTest() {
        assertEquals(3, Nod.euclidGCD(3, 21));
        assertEquals(3, Nod.euclidGCD(21, 3));
        assertEquals(1, Nod.euclidGCD(1, 17));
        assertEquals(1, Nod.euclidGCD(17, 1));
        assertEquals(0, Nod.euclidGCD(0, 0));
        assertEquals(1, Nod.euclidGCD(1, 1));
        assertEquals(1, Nod.euclidGCD(0, 1));
        assertEquals(5, Nod.euclidGCD(-5, 25));
        assertEquals(5, Nod.euclidGCD(-5, -25));
        assertEquals(5, Nod.euclidGCD(5, -25));
    }

    @Test
    public void sqrtBinaryTest() {
        assertEquals(0, Sqrt.calculateSqrtBinarySearch(0));
        assertEquals(1, Sqrt.calculateSqrtBinarySearch(1));
        assertEquals(8, Sqrt.calculateSqrtBinarySearch(64));
        assertEquals(22, Sqrt.calculateSqrtBinarySearch(500));
        assertEquals(12345, Sqrt.calculateSqrtBinarySearch(152399025));
    }

    @Test
    public void sqrtDecrementTest() {
        assertEquals(0, Sqrt.calculateSqrtDecrement(0));
        assertEquals(1, Sqrt.calculateSqrtDecrement(1));
        assertEquals(8, Sqrt.calculateSqrtDecrement(64));
        assertEquals(22, Sqrt.calculateSqrtDecrement(500));
        assertEquals(12345, Sqrt.calculateSqrtDecrement(152399025));
    }

}
