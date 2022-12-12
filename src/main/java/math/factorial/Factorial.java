package math.factorial;

import java.math.BigInteger;
import java.util.Scanner;

public class Factorial {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        BigInteger res = fact(input.nextInt());
        System.out.println(res.toString());

    }

    private static BigInteger fact(int n) {
        BigInteger res;
        if (n == 0 || n == 1) {
            return BigInteger.ONE;
        } else {
            res = BigInteger.valueOf(n).multiply(fact(n - 1));
        }
        return res;
    }
}
