package math.sqrt;

public class Sqrt {
    static long count;

    public static long calculateSqrtDecrement(long input) {
        long res = (input + 1) / 2;
        count = 0;
        while (true) {
            if (res * res > input) {
                res--;
                count++;
            } else {
                break;
            }
        }
        System.out.println("Количество операций = " + count);
        return res;
    }

    public static long calculateSqrtBinarySearch(long input) {
        count = 0;
        long left = 1;
        long right = (input + 1) / 2;
        long mid = (left + right) / 2;
        while (left <= right) {
            if (mid * mid > input) {
                right = mid - 1;
                count++;
            } else {
                left = mid + 1;
                count++;
            }
            mid = (left + right) / 2;
        }
        System.out.println("Количество операций = " + count);
        return mid;
    }

}
