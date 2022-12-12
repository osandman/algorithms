package math.nod;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

/**
 * нахождение НОД методом Евклида с использованием рекурсии
 * (eng. "greatest common divisor")
 */

public class Run {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num1, num2;
        num1 = Integer.parseInt(br.readLine());
        num2 = Integer.parseInt(br.readLine());
        if (num1 == 0 || num2 == 0) {
            System.out.println("Wrong number");
            return;
        }
        int a = Math.abs(num1);
        int b = Math.abs(num2);
        System.out.printf("a = %d, b = %d\n", num1, num2);
        System.out.printf("Recursive method: greatest common divisor = %d\n", recursiveNOD(a, b));
        System.out.printf("While method: greatest common divisor = %d\n", NOD(a, b));
        System.out.println("Checking: " + BigInteger.valueOf(num1).gcd(BigInteger.valueOf(num2)));
    }

    public static int recursiveNOD(int a, int b) {
        //меняем местами аргументы если a < b
        if (a < b) {
            return recursiveNOD(b, a);
        }
        if (b != 0) {
            return recursiveNOD(b, a % b);
        }
        return a;
    }

    public static int NOD(int a, int b) {
        int modulo; //остаток от деления
        //меняем местами аргументы если a < b, modulo используем как временную переменную, чтобы не создавать новую
        if (a < b) {
            modulo = a;
            a = b;
            b = modulo;
        }
        while ((modulo = a % b) > 0) {
            a = b;
            b = modulo;
        }
        return b;
    }
}


