package math;
import help.*;

import java.lang.reflect.Method;

public class Run {
    public static void main(String[] args) {
//        long input = 1_000_000_000L;
        long input = 3_424_568_479L;
        System.out.println("Ответ правильный = " + Math.sqrt(input));
        Time.start();
        System.out.println(Sqrt.calculateSqrtDecrement(input));
        Time.finish("Use method: calculateSqrtDecrement");
        Time.start();
        System.out.println(Sqrt.calculateSqrtBinarySearch(input));
        Time.finish("Use method: calculateSqrtBinarySearch");

    }

}
