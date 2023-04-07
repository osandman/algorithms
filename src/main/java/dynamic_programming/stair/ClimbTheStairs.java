package dynamic_programming.stair;

/**
 * Ребенок бежит по лестнице состоящей из N ступенек, за 1 шаг он может пройти одну, две или три ступеньки.
 * <p>
 * Реализуй метод numberOfPossibleAscents(int n), который вернет количество способов которыми ребенок
 * может пробежать всю лестницу состоящую из n ступенек.
 * <p>
 * P.S. Если лестница состоит из 0 ступенек - метод должен возвращать 1. Для n < 0 верни 0.
 */
public class ClimbTheStairs {
    private static final int n = 70;

    public static void main(String[] args) {
        System.out.println("The number of possible ascents for " + n + " steps is: " + numberOfPossibleAscents(n));
    }

    public static long numberOfPossibleAscents(int n) {
        long s0 = 0;
        long s1 = 0;
        long s2 = 1;
        long sn = 0;
        if (n < 0) return sn;
        if (n == 0) return s2;
        for (int i = 0; i < n; i++) {
            sn = s0 + s1 + s2;
            s0 = s1;
            s1 = s2;
            s2 = sn;
        }
        return sn;
    }
}
