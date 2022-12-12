package math.sqrt;
import help.*;

public class Run {
    public static void main(String[] args) {
//        long input = 1_000_000_000L;
        long input = 16;
        System.out.println("Ответ правильный = " + Math.sqrt(input));
        Time.start();
        System.out.println(Sqrt.calculateSqrtBinarySearch(input));
        long binTime = Time.finish("calculateSqrtBinarySearch");
        Time.start();
        //System.out.println(Sqrt.calculateSqrtDecrement(input));
        //Time.finish("calculateSqrtDecrement", binTime);
    }
}
